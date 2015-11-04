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


import org.kuali.continuity.admin.main.client.controls.RichTextToolbar;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.RowParams;

public class Reference extends SimpleGridViewer implements EntryPoint {
	 // HtmlEditor htmlEditor1 = new HtmlEditor("Reference", "reference");
	 // RichTextArea htmlEditor1 = new RichTextArea();
		
    public class NewRichTextArea extends RichTextArea {
    	public void setHTML(String html) {
    		super.setHTML("<SPAN STYLE=\"" + STYLE_ATTRIBUTE + 
           STYLE_ATTRIBUTE_DISABLED_ADDITION + "\">" + html + "</SPAN>");
    	}
    		private static final String STYLE_ATTRIBUTE = "font-family:Tahoma,Arial,Helvetica,sans-serif; font-size:11px; margin-top:-10px; margin-bottom:-10px";
    	    private static final String STYLE_ATTRIBUTE_DISABLED_ADDITION = "; ";

    	

    }
    NewRichTextArea richBox = new NewRichTextArea();
    String plural="";
	public String setElementNames() {
		Element gwtRoot = DOM.getElementById("gwtRoot");
		itemService = (ItemServiceAsync) GWT.create(ItemService.class);
		Element screenelement = DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element dataelement = DOM.getElementById("dataelement");
		Element pluralelement = DOM.getElementById("plural");
		
		String pageInfo = screenelement.getTitle();
		String pageTitle = screenelement.getTitle();
		String proxyUrl = "./items.lst"; // ListService name.
		String formItemName = pageInfo;
		String columnTitle=formItemName;
		if (null!=DOM.getElementById("columnelement")) {
			Element columnelement = DOM.getElementById("columnelement");
			columnTitle=columnelement.getTitle();
		}
		//  Window.alert("Setting Name header to: "+columnTitle+"|"+nameColumn.getHeader());
		 simplecolumnModel = new ColumnModel(new ColumnConfig[] {
					orderColumn, nameColumn });
		//  Window.alert("Name header is: "+simplecolumnModel.getColumnHeader(1));
		 
		 simplecolumnModel.setColumnHeader(1, columnTitle);
		itemRootName = pageInfo;
		if (null != formelement) {
			formItemName = formelement.getTitle();
		}
		if (dataelement!=null) {
			itemRootName=dataelement.getTitle();
		}
		 plural = pluralelement.getTitle();

		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("name"),
				new IntegerFieldDef("order") });
		GridView gridView = new GridView() {
			public String getRowClass(Record record, int index,
					RowParams rowParams, Store store) {
				rowParams.setBody(Format.format("<p>{0}</p>", record
						.getAsString("excerpt")));
				return "x-grid3-row-expanded";
			}
		};
		gridPanel.setView(gridView);
		
		this.formController=refFormController;
		super.onModuleLoadRef(plural, simplecolumnModel);

		this.setButtonNames(pageTitle);
		this.setHeadingName(plural + " Setup");

		// nameColumn.setHeader(pageInfo);
		return formItemName;
	}


	public void onModuleLoad() {
		// Top level info
		
		
		itemService = (ItemServiceAsync) GWT.create(ItemService.class);
		
		// Grid
		this.gpheight="260px";
		String formItemName = this.setElementNames();

		// Admin item specific settings

		// Form
		Panel extPanel= new Panel();
		FormPanel extFormPanel = new FormPanel();
		extFormPanel.setFrame(false);
		extFormPanel.setWidth(642);
		extFormPanel.setLabelAlign(Position.TOP);
		extFormPanel.add(gridPanel);
        HTML orderLabel = null;
        orderLabel=new HTML("<B>Order</B>");
     	flexForm.addIdentifiedItem(orderLabel, orderBox);
	    // Create Rich Text Area
		richBox.ensureDebugId("cwRichText-area");
		richBox.setSize("642px", "14em");
		RichTextToolbar toolbar = new RichTextToolbar(richBox);
		toolbar.ensureDebugId("cwRichText-toolbar");
		toolbar.setWidth("642px");
		Grid grid = new Grid(2, 1);
		grid.setStyleName("cw-RichText");
		grid.setWidget(0, 0, toolbar);
		grid.setWidget(1, 0, richBox);
		flexForm.addRow();
		HTML itemName =new HTML("<B>"+formItemName+"</B>");
		
		flexForm.addIdentifiedItemVertical(itemName, grid);
		flexForm.registerWidget(richBox);
		
		itemRootName=itemRootName.toLowerCase();
		
		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		flexForm.registerWidget(csrfToken);

	}
	public class  RefFormController  extends SimpleFormController {

		public boolean formLoad(Object result) {
			Item item = (Item) result;
			richBox.setHTML(item.getName());
		
			//richBox.setHTML(htmlLeader+item.getName()+htmlTrailer);

			orderBox.setText(item.getOrder());
			return true;
		}

	
		public NamedItem validateSave(NamedItem itemin) {
			
			Item item = new Item();
			item.setName(richBox.getHTML());
			String orderStr = orderBox.getText();
			if (orderStr.trim().isEmpty()) orderStr = "999";  // max 3 digit int
			item.setOrder(orderStr);
			item.setCsrfToken(csrfToken.getValue());
			return (NamedItem) item;
		}

	}
	public RefFormController refFormController = new RefFormController();

}
