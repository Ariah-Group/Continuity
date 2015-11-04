// 
// Copyright 2011 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.opensource.org/licenses/ecl2.php
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.admin.main.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Dependency extends SimpleGridViewer {

	// Setup specific for Dependencies
	final TextBox textBox = new TextBox();
	final ListBox type = new ListBox();
	int[] gcsize = { 100, 40, 300 };
	public ColumnConfig typeCol = new ColumnConfig("Type", "description", gcsize[0],
			true);
	public ColumnConfig orderColumn = new ColumnConfig("Order", "order",
			gcsize[1], true);
	public ColumnConfig dependencyCol = new ColumnConfig("Dependency", "name",
			gcsize[2], true);

	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { typeCol,
			orderColumn, dependencyCol });



	public void onModuleLoad() {
		// Top level info

		itemService= (ItemServiceAsync) GWT.create(ItemService.class);
		
		Element screenelement = DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element pluralelement = DOM.getElementById("plural");
		String plural = pluralelement.getTitle();

		String pageInfo = screenelement.getTitle();
		String pageTitle = screenelement.getTitle();
		String proxyUrl = "./items";
		String formItemName = pageTitle;
		itemRootName = pageInfo;
		// Grid
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("name"),
				new IntegerFieldDef("order"), new StringFieldDef("description") });
        
		super.onModuleLoad(plural, proxyUrl, columnModel, recordDef);
		this.formController=dependencyFormController;

		// Buttons

		this.setButtonNames(pageTitle);

		// Heading
		this.setHeadingName(plural + " Setup");

		// Form Data
		textBox.setMaxLength(50);
		textBox.setWidth("335px");
		flexForm.addFormItem(formItemName, textBox);
		type.setVisibleItemCount(1);

		type.addItem("--Select--","2");
		type.addItem("Upstream","1");
		type.addItem("Downstream","0");
		flexForm.addFormItem("Type", type);
		flexForm.addFormItem("Order", orderBox);

      	// set token
      	String token = Cookies.getCookie(CSRF_TOKEN);
      	csrfToken.setValue(token);
      	flexForm.registerWidget(csrfToken);

      	gridPanel.setCls(".myclass");
		itemRootName=itemRootName.toLowerCase();
	}

	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			// Get Item from result and load form.

			// Window.alert("We got an item here."+item.getName());
			dependencyFormController.formLoad(result);
			// textBox.setText(item.getName());
			// orderBox.setText(item.getOrder());
			// //Load item fields.
		}

		public void onFailure(Throwable e) {
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}
		}

	};

	SimpleFormController dependencyFormController = new SimpleFormController() {
		public boolean formLoad(Object result) {
			DependencyItem item = (DependencyItem) result;
			textBox.setText(item.getName());
			orderBox.setText(item.getOrder());
			String typestr = item.getDescription();
			int typeIndex=1;
			if (typestr.equals("Downstream")) {
				typeIndex=2;
			}
			type.setSelectedIndex(typeIndex);
			
			return true;
		}

		public NamedItem validateSave(NamedItem namedItem) {
            DependencyItem di = (DependencyItem) namedItem;
            di.setName(textBox.getText());
            int tind=type.getSelectedIndex();
            int itype = Integer.parseInt(type.getValue(tind));
            di.setType(itype);
            di.setCsrfToken(csrfToken.getValue());
            return (NamedItem) di;
		}
		
		Item saveFields() {

			Item item = this.validate();
			if (item != null) {
				item.setId(currentId);

			}
			return item;
		}
		
		public Item validate() {
			DependencyItem item = new DependencyItem();
			boolean ret = true;
			int order = 0;
			String excp = "";
			try {
				// This check can be removed.  All these are orderedTypes
				if (checkForGetMethod(item, "getOrder")) {
					String orderStr = orderBox.getText();
					if (orderStr.trim().isEmpty()) orderStr = "999";  // max 3 digit int
					item.setOrder(orderStr);
					order = Integer.parseInt(item.getOrder().trim());
//					if (order == 0) {
//						ret = false;
//						setError("Order must be a numeric value. " + excp);
//					}
				}
				
				// dependency type
				String typeString = type.getValue(type.getSelectedIndex());
				if (typeString.isEmpty() || typeString.equals("2")) {
					ret = false;
					setError("Type selection required");
				} else {
					item = (DependencyItem) validateSave((NamedItem) item);
					item.setId(currentId);
				}
			   
			//	item.setName(textBox.getText());
			} catch (NumberFormatException e) {
				ret = false;
				setError("Order must be a numeric value. " + excp);
			} catch (Exception e) {
				excp = e.toString();

			}
			ret = ret && validation();
			showErr(!ret);
			if (!ret) {
				item = null;
			}
			return item;

		}

		public boolean delete(String itemRootName, AsyncCallback updateItemCallback) {
			Item item = saveFields();
			itemService.deleteItem(itemRootName, item, updateItemCallback);
			return true;
		}

		public boolean insert(String itemRootName, AsyncCallback updateItemCallback) {
			Item item = saveFields();
			if (item != null) {
				itemService.insertItem(itemRootName, item, updateItemCallback);
			}
			return true;
		}

		public boolean update(String itemRootName, AsyncCallback updateItemCallback) {
		
			Item item = saveFields();

			if (item != null) {
				itemService.updateItem(itemRootName, item, updateItemCallback);
			}
			return true;
		}


		public void getItem(String itemRootName, String id) {
			itemService.getItem(itemRootName, id, selectItemCallback);
		}

		public boolean gridDisplayEdit() {

			return true;

		}

	};

}
