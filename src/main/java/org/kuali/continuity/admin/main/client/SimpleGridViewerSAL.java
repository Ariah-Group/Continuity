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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
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
public class SimpleGridViewerSAL extends MainViewerAL{

	// Grid setup
	int[] gridColumnSize = { 40, 350, 160, 80, 50, 0 };
	int curinst = 1;

	// Special Controls
	final TextBox caanno = new TextBox();
	final TextBox caanname = new TextBox();
	final ListBox ownership = new ListBox();
	final TextArea address = new TextArea();

	
	// Service
	public SimpleServiceAsync itemService = null;

	// String[] heading = { "Name", "Order", "" };
	public ColumnConfig orderColumn = new ColumnConfig("Order", "order",
			gridColumnSize[0], true);
	public ColumnConfig nameColumn = new ColumnConfig("Name", "name",
			gridColumnSize[1], true);
	/**
	 * Default column model (used by a number of grid-based managers).
	 */
//	ColumnModel simplecolumnModel = new ColumnModel(new ColumnConfig[] {
//			orderColumn, nameColumn });


	public String setElementNames(ColumnModel columnModel, RecordDef recordDef) {
		Element gwtRoot= DOM.getElementById("gwtRoot");
		// remoteServiceClass
		itemService= (SimpleServiceAsync) GWT.create(SimpleService.class);
		Element screenelement= DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element pluralelement=DOM.getElementById("plural");
		Element dataelement = DOM.getElementById("dataelement");
		String pageInfo=screenelement.getTitle();
		String pageTitle=screenelement.getTitle();
		String proxyUrl="./items.lst";  //ListService name.
		String formItemName=pageInfo;
		itemRootName=pageInfo.toLowerCase();
		if (null!=formelement) {
			formItemName=formelement.getTitle();
		}
		if (null!=dataelement) {
			itemRootName=dataelement.getTitle().toLowerCase();

		}
		String plural=pluralelement.getTitle();
//		RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("id"),
//				new StringFieldDef("name"), new StringFieldDef("order") });

		onModuleLoad(plural, "./items.lst", columnModel, recordDef);

		this.setButtonNames(pageTitle);
		this.setHeadingName(plural+" Setup");

		 nameColumn.setHeader(pageInfo);
		 return formItemName;
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

	public void onModuleLoad(String gridname, String proxyUrl,
			ColumnModel columnModel, RecordDef recordDef) {
		// this.formController = formController;
		doModuleLoad( );

		// Initialize ItemService.

		JsonReader reader = new JsonReader(recordDef);
		reader.setRoot("items");
		reader.setId("id");

		dataProxy = new HttpProxy("./items.lst"); // Temp
		store = new Store(dataProxy, reader);
		store.setDefaultSort("order", SortDir.ASC);
	   //	gridPanel.addGridRowListener(rowlistener);
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
		gridPanel.setSize("642px", "200px");

		dockPanel.add(gridPanel, DockPanel.WEST);
		orderBox.setMaxLength(2);
		orderBox.setWidth("20px");
		gridPanel.addListener(new PanelListenerAdapter() {
			public void onRender(Component component) {

				store.load(0, pageSize);
			}
		});
		store.setBaseParams(urlParams);
     	gridLoad(1, 1, "id", itemRootName, store);


	}

	/**
	 * This is the selectCall back that is installed during onModuleLoad. It
	 * receives a record and displays it in the form section. We would very much
	 * like to use Template method with this, giving full control of the form to
	 * the main decorator class.
	 */
	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
 			currentId =(((NamedItem) result).getId());
			//formController.showController();
			formController.formLoad(result);
		}

		public void onFailure(Throwable e) {
			Window.alert("An error occured:" + e);
		}
	};
    public int selectedRow=0;
    
	public class MyRowListener implements GridRowListener {

		public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
			showErr(false);
			selectedRow=rowIndex;  // Save selected row.
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
	//		Window.alert("Row click: " + rowIndex + " "
	//				+ e.getClass().getName());
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
			itemService.deleteItem(itemRootName, item, updateItemCallback);
			return true;
		}

		public boolean insert(String itemRootName, NamedItem item,
				AsyncCallback callback) {
			Window.alert("Calling service to insert. Item name is: "+ item.getName());
			itemService.insertItem(itemRootName, item, updateItemCallback);

			return true;
		}

		public boolean update(String itemRootName, NamedItem item,
				AsyncCallback callback) {
            Window.alert("Calling service to update. Item name is: "+ item.getName());
			itemService.updateItem(itemRootName, item, updateItemCallback);
			return true;

		}

		public void getItem(String itemRootName, String id) {
           // Window.alert("I got to get");
			int iid = Integer.parseInt(id);
			itemService.getItem(itemRootName, iid, selectItemCallback);
		}

		public boolean gridDisplayEdit() {

			return true;
		}

		public boolean delete(String itemRootName, AsyncCallback updateItemCallback) {
			NamedItem item = saveFields();
			itemService.deleteItem(itemRootName, item, updateItemCallback);
			return true;
		}

		public boolean insert(String itemRootName, AsyncCallback updateItemCallback) {
			NamedItem item = saveFields();
			if (item != null) {
				itemService.insertItem(itemRootName, item, updateItemCallback);
			}
			return true;
		}

		public boolean update(String itemRootName, AsyncCallback updateItemCallback) {

			NamedItem item = saveFields();
			
			if (item != null) {
				itemService.updateItem(itemRootName, item, updateItemCallback);
			}
			return true;
		}

		NamedItem saveFields() {
			
			NamedItem item = this.validate();
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
		public NamedItem validate() {
			NamedItem item = new NamedItem();
			boolean ret = true;
			int order = 0;
			String excp = "";
			try {
				item.setName(textBox.getText());  // ALlow validateSave to override.
			    item =  validateSave( item);
			    
				
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
			
		/**
		 * Solution to polymorphism not working.	
		 */
		public  NamedItem validateSave(NamedItem item) {
			Window.alert("Went to wrong place.");
//			if (itemRootName.equals("building")) {
//		   		Window.alert("I got xhere2ca : "+item.getName());
//	    		BuildingItem bi = new BuildingItem();
//	    		bi.setId(item.getId());
//	    		item = bi;
//	    		
//	    		Window.alert("I got xhere2cb cast : "+item.getName());
//	    		bi.setName(textBox.getText());
//	    		Window.alert("I got here2cc getText : "+item.getName());
//	    		bi.setCommonName(caanname.getText());
//	    		bi.setCaan(caanno.getText());
//	    		bi.setAddress(address.getText());
//	    		bi.setOwner(""+ownership.getSelectedIndex());
//	    		Window.alert("I got here2cc : "+item.getName());
//	 
//			}
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
