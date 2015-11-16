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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.GridHeaderListener;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public abstract class MainViewerAL extends ListControl  {

	// LISTENER CLASSES
	//    Grid:
	String itemRootName="";
	String htmlLeader="<SPAN STYLE=\"font-family:arial;font-size:11px\">";
    String htmlTrailer="</SPAN>";
	String DATE_FORMAT = "MM/dd/yyyy";

	final TextBox startDate = new TextBox();
	final TextBox endDate = new TextBox();
	final ListBox planListBox = new ListBox();
    // Configuration
    public boolean showButtonRow=true;
    
	// HeaderListener

	public class MyHeaderListener implements GridHeaderListener {

		public void onHeaderClick(GridPanel grid, int colIndex, EventObject e) {
            String colname=grid.getColumnModel().getColumnHeader(colIndex);
            int institutionId=0;
			gridLoad(colIndex, institutionId, colname, itemRootName);

		}
        
		public void onHeaderContextMenu(GridPanel grid, int colIndex,
				EventObject e) {
			// TODO Auto-generated method stub

		}

		public void onHeaderDblClick(GridPanel grid, int colIndex, EventObject e) {
			this.onHeaderClick(grid, colIndex, e);

		}

	}

	// Default objects.
	int currentId = 0;
	// Buttons.
	final Button insertButton = new Button("Insert");
	final Button updateButton = new Button("Update");
	final Button deleteButton = new Button("Delete");
	final Button backButton = new Button();

	// Simple Form for Simple Form Grid.
	final Label fieldLabel = new Label("Field Label");
	final TextBox textBox = new TextBox();
	final TextBox orderBox = new TextBox();
	final TextBox idBox = new TextBox();

    // Heading
	//final HTML headingLabel = new HTML("<h1>main</h1>");
	final HTML headingLabel = new HTML("<p> </p>");
	// Main Screen Panels and Layout
	final String screenWidth="642px";
	final DockPanel dockPanel = new DockPanel();
	final HorizontalPanel headingBar = new HorizontalPanel();
	final HorizontalPanel spacerBar = new HorizontalPanel();
	final DockPanel buttonBar = new DockPanel();
	final HorizontalPanel left = new HorizontalPanel();
	final HorizontalPanel right = new HorizontalPanel();
	VerticalPanel formPanel = new VerticalPanel();
    FlexibleForm flexForm = new FlexFormPanel();
    final HorizontalPanel errorPanel = new HorizontalPanel();
    final HorizontalPanel errorTextPanel = new HorizontalPanel();

	// Grid
    int gridColumns=3;
    int institutionId=0;
	GridPanel gridPanel = new GridPanel();
	HttpProxy dataProxy; // = new HttpProxy(proxyUrl0);
	Store store; // = new Store(dataProxy0, reader0);

	 FormController formController;
	 abstract FormController  getFormController();

	public void setFlexForm(FlexibleForm flexForm) {
		this.flexForm=flexForm;
	}
	public void setFormPanel(VerticalPanel formPanel) {
		  this.formPanel=formPanel;
	}
	
   // Data Validation and Formatting
    // Dates
//	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	Date getDateFromString(String instr) {
		Date ret = new Date();
		String[] dsec = instr.split("/");
		int yr = Integer.parseInt(dsec[2]);
		if (yr < 999) {
			yr = yr + 100;
		} else {
			yr = yr -1900;
		}
//		Calendar gc = Calendar.getInstance();
//		gc.set(Calendar.MONTH, Integer.parseInt(dsec[0]) - 1);
//		gc.set(Calendar.DATE, Integer.parseInt(dsec[1]));
//		gc.set(Calendar.YEAR, yr);
//		ret = gc.getTime();
        ret.setYear(yr);
        ret.setMonth(Integer.parseInt(dsec[0]) - 1);
        ret.setDate(Integer.parseInt(dsec[1]));
        ret.setHours(10);  // This is a Work around for Daylight Savings Time Bug in 1.5.3
        		                  // See: http://code.google.com/p/google-web-toolkit/issues/detail?id=3132
        
		return ret;
	}

	String formatDate(Date datein) {
		DateTimeFormat dtf = DateTimeFormat.getFormat("MM/dd/yyyy");
		return dtf.format(datein);
	}

	// Callbacks.
	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {

			currentId =(((Item) result).getId());
			//formController.showController();
			formController.formLoad(result);
			// Get Item from result and load form.
//			Item item = (Item) result;
//
//			textBox.setText(item.getName());
//			orderBox.setText(item.getOrder());
//			//Load item fields.
		}

		public void onFailure(Throwable e) {
			Window.alert("An error occured:" + e);
		}
	};

	public AsyncCallback updateItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			gridPanel.clear();
			gridLoad(1,1,"id",itemRootName, store);

		}

		public void onFailure(Throwable e) {
			Window.alert("An error occured:" + e);
		}
	};

	// public ItemServiceAsync  itemService=null;
	public int pageSize = 7;

	public native void redirect(String url) /*-{


	$wnd.open(url,"mainwindow");

 }-*/;
	public void setButtonNames(String noun) {

		backButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
                showErr(false);
                redirect("/continuity/admin/adminHome");
			}
		});
		backButton.setText("Back");
		backButton.setStyleName("ButtonClass");
		insertButton.setText("Insert "+noun);
		insertButton.setStyleName("ButtonClass");
		updateButton.setText("Update "+noun);
		updateButton.setStyleName("ButtonClass");
		deleteButton.setText("Delete "+noun);
		deleteButton.setStyleName("ButtonClass");
		//itemRootName=noun;

	}
	public void setHeadingName(String heading) {
		//headingLabel.setHTML("<H1>"+heading+"</H1>");
	}

	public void doModuleLoad() {
		super.onModuleSetup();

		//Element gwtRoot= DOM.getElementById("gwtRoot");
		//rootPanel = RootPanel.get("gwtRoot");
		RootPanel rootPanel = RootPanel.get("gwtRoot");

        // Window.alert("Start at: "+rootPanel.getTitle());
        // Defaults for SimpleGridView
		textBox.setWidth("341px");
        orderBox.setWidth("40px");

        // Button Bar
		buttonBar.add(left,DockPanel.WEST);
		left.setWidth("200px");
        right.setWidth("440px");
		left.add(backButton);
		buttonBar.add(right,DockPanel.EAST);
		HTML spacer= new HTML("&nbsp;");
        right.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		// right.add(insertButton);
		// right.add(updateButton);
        // right.add(deleteButton);

        // Add button listeners.

		insertButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);

    			boolean ok = Window.confirm("Insert new  entry: "
    					+ textBox.getText() + ": are you sure?");
				if (ok) {
				
					getFormController().insert(itemRootName,  updateItemCallback);
				}

			}
		});
    	updateButton.addClickListener(new ClickListener() {
    		public void onClick(final Widget sender) {
    			showErr(false);
    	
    			boolean ok = Window.confirm("Update entry: "
    					+ textBox.getText() + ": are you sure?");
    			if (ok) {
    				getFormController().update(itemRootName,  updateItemCallback);
    			}

    		}
    	});
    	deleteButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				boolean ok = Window.confirm("Delete  entry: "
    					+ textBox.getText() + ": are you sure?");
				if (ok) {

					Item item = new Item();
					formController.delete(itemRootName, item, updateItemCallback);
				}

			}
		});

        // Build up Main dock panel
        rootPanel.add(dockPanel);
		dockPanel.setWidth("642px");
		spacerBar.setSize(screenWidth,"10px");

		// Page heading
		// headingLabel.setHTML("<p>&nbsp;</p>");
		// headingBar.add(headingLabel);
        // headingBar.setSize(screenWidth,"30px");
     	dockPanel.add(headingBar, DockPanel.NORTH);
        headingBar.setHeight("2px");
        headingBar.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

        // Add panels below the gridpanel
        // if (showButtonRow) {
        	dockPanel.add(buttonBar, DockPanel.SOUTH);
        // }
        
        dockPanel.add(errorTextPanel, DockPanel.SOUTH);
		dockPanel.add(errorPanel, DockPanel.SOUTH);
		
		errorPanel.setSize(screenWidth,"24px");
		buttonBar.setSize(screenWidth, "58px");
		dockPanel.add(formPanel,DockPanel.SOUTH);
		dockPanel.add(spacerBar, DockPanel.SOUTH);
		formPanel.add(flexForm);
		loadErrorSetup(errorPanel, errorTextPanel);
		CSS.swapStyleSheet("theme", "js/ext/resources/css/xtheme-gray.css");


	}

	boolean validate(FlexibleForm flexForm) {
		boolean ret= true;

		return ret;
	}
    UrlParam[] urlParams = null;

	void gridLoad(int selectedItem, int institutionId, String sort, String dataset) {
		// Window.alert("called gridLoad");
		gridLoad( selectedItem,  institutionId,  sort,  dataset, store);
	}
	// Institution serves as a filter but is actually present in the servlet context.
	boolean firsttime=true;
	void gridLoad(int selectedItem, int institutionId, String sort, String dataset, Store store) {
	    // Window.alert("loading grid: "+dataset);
	    String [] props = store.getProperties();
	    String proplist = "";
	    for (String s: props) {
	    	proplist+=s+" , ";
	    	
	    }
	    if ( firsttime) {  // First time the plan list is loaded.
	    	firsttime=false;
	    } else {
	    
	    int planId = Integer.parseInt(planListBox.getValue(planListBox.getSelectedIndex()));
//	    Date d1= getDateFromString(startDate.getText());
//	    startDate.setText(formatDate(d1));
//	    Date d2 = getDateFromString(endDate.getText());
//	    endDate.setText(formatDate(d2));
		UrlParam[] urlParams = { new UrlParam("start",planId),
				new UrlParam("limit", pageSize),
				new UrlParam("institution", institutionId),
				new UrlParam("dataset", dataset),
				new UrlParam("sort", startDate.getText()), new UrlParam("dir", endDate.getText()) };
		store.setDefaultSort("order", SortDir.ASC);

		store.setBaseParams(urlParams);

		store.load(urlParams);
		//formController.gridDisplayEdit();
	    }
	}
	public Map statusMap = new HashMap();
	
    public void loadListBox(ListBox lb, String[][] list, boolean emptyrow) {
		int nitems = list.length;
		// Window.alert("Loading Plan ListBox");
		if (list != null) {
			for (int i = 0; i < nitems; i++) {
				String[] nvp = (String[]) list[i];
				lb.addItem(nvp[1], nvp[0]);
				int iid = Integer.parseInt(nvp[0]);
				if (nvp.length==3)
				statusMap.put(nvp[0], nvp[2]);
			}
		}
	}

	MyHeaderListener headerlistener = new MyHeaderListener();

}
