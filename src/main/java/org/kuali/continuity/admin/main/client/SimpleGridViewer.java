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
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.JsonReader;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.GridRowListener;

/**
 * SimpleGridViewer is used by all Admin Managed Lists
 * 
 * @author richkatz
 * 
 */
public class SimpleGridViewer extends MainViewer {

	// Grid setup
	int[] gridColumnSize = { 40, 350, 160, 80, 50, 0 };
	int curinst = 1;

	// Service
	public ItemServiceAsync itemService = null;

	// String[] heading = { "Name", "Order", "" };
	public ColumnConfig orderColumn = new ColumnConfig("Order", "order",
			gridColumnSize[0], true);
	public ColumnConfig nameColumn = new ColumnConfig("Name", "name",
			gridColumnSize[1], true);
	/**
	 * Default column model (used by a number of grid-based managers).
	 */
	ColumnModel simplecolumnModel = new ColumnModel(new ColumnConfig[] {
			orderColumn, nameColumn });
    public void setItemService(ItemServiceAsync itemService) {
    	this.itemService=itemService;
    }
    
	public String setElementNames(Class remoteServiceClass) {
		Element gwtRoot= DOM.getElementById("gwtRoot");
		// remoteServiceClass
		itemService= (ItemServiceAsync) GWT.create(ItemService.class);
		Element screenelement= DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element pluralelement=DOM.getElementById("plural");
		Element dataelement = DOM.getElementById("dataelement");
		Element columnelement= null;

		String pageInfo=screenelement.getTitle();
		String pageTitle=screenelement.getTitle();
		String proxyUrl="./items.lst";  //ListService name.
		String columnTitle="Name";
		try {
			if (null !=DOM.getElementById("columnelement")) {
				columnelement=DOM.getElementById("columnelement");
				columnTitle=columnelement.getTitle();
			}
		} catch (Exception e) {
			// We don't care.
		}
		String formItemName=pageInfo; 
		itemRootName=pageInfo.toLowerCase();
		if (null!=formelement) {
			formItemName=formelement.getTitle();
		}
		if (null!=dataelement) {
			itemRootName=dataelement.getTitle().toLowerCase();

		}
		String plural=pluralelement.getTitle();
		RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("id"),
				new StringFieldDef("name"), new IntegerFieldDef("order") });
		
	

		this.setButtonNames(pageTitle);
		this.setHeadingName(plural+" Setup");
	
		//  Window.alert("Name header is: "+nameColumn.getHeader());
		 nameColumn.setHeader(columnTitle);
		//  Window.alert("Setting Name header to: "+columnTitle+"|"+nameColumn.getHeader());
		 simplecolumnModel = new ColumnModel(new ColumnConfig[] {
					orderColumn, nameColumn });
		//  Window.alert("Name header is: "+simplecolumnModel.getColumnHeader(1));
		 
		 simplecolumnModel.setColumnHeader(1, columnTitle);
		// Window.alert("Setting header to: "+columnTitle+"|"+simplecolumnModel.getColumnHeader(1));
		 
		 onModuleLoad(plural);
		 return formItemName;
	}
	public void onModuleLoad(String gridname) {
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("name"),
				new IntegerFieldDef("order") });
		
		this.onModuleLoad(gridname, "./items.lst", simplecolumnModel, recordDef);

	}
	public void onModuleLoadRef(String gridname, ColumnModel simplecolumnModel) {
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("name"),
				new IntegerFieldDef("order") });
		
		this.onModuleLoad(gridname, "./items.lst", simplecolumnModel, recordDef);

	}
    
    
	public void onModuleLoad(String gridname, String proxyUrl,
			ColumnModel columnModel, RecordDef recordDef) {
		onModuleLoad(gridname, proxyUrl, columnModel, recordDef,
				null);
	}

	/**
	 * This isn't really an onModuleLoad method but is designated as such
	 * because it will be called by the main Module's onModuleLoad. Note that it
	 * has several parameters.
	 * 
	 * @param gridname
	 *            The name to be applied to the grid
	 * @param proxyUrl
	 *            The location of the Service that supports this grid manager.
	 * @param columnModel
	 *            The column model that is used by this grid (if not the
	 *            default).
	 */
    String gpheight="200px";
	public void onModuleLoad(String gridname, String proxyUrl,
			ColumnModel columnModel, RecordDef recordDef,
			Object placeholder) {
		// this.formController = formController;
		doModuleLoad( );

		// Initialize ItemService.

		JsonReader reader = new JsonReader(recordDef);
		reader.setRoot("items");
		reader.setId("id");
		
		dataProxy = new HttpProxy("./items.lst"); // Temp
		store = new Store(dataProxy, reader);
		store.setDefaultSort("order", SortDir.ASC);
		gridPanel.addGridRowListener(rowlistener);
		gridPanel.setTitle(gridname);
		gridPanel.setColumnModel(columnModel);
		gridPanel.setTrackMouseOver(true);
		gridPanel.setLoadMask(true);
		gridPanel.setSelectionModel(new RowSelectionModel());
		gridPanel.setStripeRows(true);
		gridPanel.setIconCls("grid-icon");
		gridPanel.setEnableColumnResize(true);
		GridView view = new GridView();
		view.setForceFit(true);
		gridPanel.setView(view);
		gridPanel.setStore(store);
		gridPanel.setSize("642px", gpheight);

		dockPanel.add(gridPanel, DockPanel.WEST);
		orderBox.setMaxLength(3);
		orderBox.setWidth("25px");
		gridPanel.addListener(new PanelListenerAdapter() {
			public void onRender(Component component) {

				store.load(0, pageSize);
			}
		});
		store.setBaseParams(urlParams);
		
     	gridLoad(1, 1, "orderNo", itemRootName, store);
     	
     	
	}

	/**
	 * This is the selectCall back that is installed during onModuleLoad. It
	 * receives a record and displays it in the form section. We would very much
	 * like to use Template method with this, giving full control of the form to
	 * the main decorator class.
	 */
	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			currentId =(((Item) result).getId());
			//formController.showController();
			formController.formLoad(result);
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

	public class MyRowListener implements GridRowListener {

		public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
			showErr(false);
			
			Record record = grid.getStore().getAt(rowIndex);
			String[] fields = record.getFields();

			String id = record.getId();
			currentId = Integer.parseInt(id);
			formController.getItem(itemRootName, id);

		}

		public void onRowContextMenu(GridPanel grid, int rowIndex, EventObject e) {
			// TODO Auto-generated method stub

		}

		public void onRowDblClick(GridPanel grid, int rowIndex, EventObject e) {
//			Window.alert("Row click: " + rowIndex + " "
//					+ e.getClass().getName());
		}

	}
    public FormController getFormController() {
    	return this.formController;
    }
	public MyRowListener rowlistener = new MyRowListener();

	/**
	 * SimpleFormController defines the main Form Controller for an ordered item
	 * with methods to be overridden by the EntryPoint class (e.g. Application, Dependency)
	 * @author richkatz
	 *
	 */
	public abstract class SimpleFormController implements FormController {
		Widget wlist[] = { textBox, orderBox };
        public void showController() {
        	Window.alert("Simple");
        }

		public boolean formLoad(Object result) {
			
			Item item = (Item) result;
			//Window.alert("I got there: "+item.getOrder());
			textBox.setText(item.getName());
			orderBox.setText(item.getOrder());
			return true;
		}

		public boolean delete(String itemRootName, NamedItem item,
				AsyncCallback callback) {
			itemService.deleteItem(itemRootName, (Item)item, updateItemCallback);
			return true;
		}

		public boolean insert(String itemRootName, NamedItem item,
				AsyncCallback callback) {

			itemService.insertItem(itemRootName, (Item) item, updateItemCallback);

			return true;
		}

		public boolean update(String itemRootName, NamedItem item,
				AsyncCallback callback) {

			itemService.updateItem(itemRootName, (Item) item, updateItemCallback);
			return true;

		}

		public void getItem(String itemRootName, String id) {
            itemService.getItem(itemRootName, id, selectItemCallback);
		}

		public boolean gridDisplayEdit() {

			return true;
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

		Item saveFields() {

			Item item = this.validate();
			if (item != null) {
				item.setId(currentId);

			}
			return item;
		}
        /**
         * the validate method validates and actually saves data from the form
         * into the domain object DTO.  It returns an instance of the saved object 
         * which is used by Insert or Update.
         * @return
         */
		public Item validate() {
			Item item = new Item();
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
				
			    item = (Item) validateSave((NamedItem) item);
			    item.setId(currentId);
			   
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

		 /**
	        * If additional validation is to be performed.
	        * @return
	        */
			public boolean validation() {
				return true;
			}
		public  NamedItem validateSave(NamedItem item) {
		      Window.alert("wrong place");
		      return item;
		}
//		public NamedItem validateSave(NamedItem item) {
//			item.setName(textBox.getText());
//
//			return item;
//		}

	}

//	public SimpleFormController simpleFormController = new SimpleFormController();

	public boolean checkForGetMethod(Object item, String name) {
		boolean ret = false;

		try {
			if (item instanceof Item) {
				ret = true;
			}
		} catch (Exception e) {

		}
		return ret;
	}
}
