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

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
public abstract class MainViewer extends ListControl {

	// LISTENER CLASSES
	// Grid:
	String itemRootName = "";
	String htmlLeader = "<SPAN STYLE=\"font-family:arial;font-size:11px\">";
	String htmlTrailer = "</SPAN>";

	// Configuration
	public boolean showButtonRow = true;

	// HeaderListener

	public class MyHeaderListener implements GridHeaderListener {

		public void onHeaderClick(GridPanel grid, int colIndex, EventObject e) {
			String colname = grid.getColumnModel().getColumnHeader(colIndex);
			int institutionId = 0;
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
	final Hidden csrfToken = new Hidden();	

	// Heading
	// final HTML headingLabel = new HTML("<h1>main</h1>");
	final HTML headingLabel = new HTML("<p> </p>");
	// Main Screen Panels and Layout
	final String screenWidth = "642px";
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
	
	String delAskMsg = "Delete  entry: ";

	// Grid
	int gridColumns = 3;
	int institutionId = 0;
	GridPanel gridPanel = new GridPanel();
	HttpProxy dataProxy; // = new HttpProxy(proxyUrl0);
	Store store; // = new Store(dataProxy0, reader0);

	FormController formController;
	MainViewer mv = this;

	abstract FormController getFormController();

	public void setFlexForm(FlexibleForm flexForm) {
		this.flexForm = flexForm;
	}

	public void setFormPanel(VerticalPanel formPanel) {
		this.formPanel = formPanel;
	}

	// Callbacks.
	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {

			currentId = (((Item) result).getId());
			// formController.showController();
			formController.formLoad(result);
			// Get Item from result and load form.
			// Item item = (Item) result;
			//
			// textBox.setText(item.getName());
			// orderBox.setText(item.getOrder());
			// //Load item fields.
		}

		public void onFailure(Throwable e) {
			//Cookies for 
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}		
		}
	};

	public AsyncCallback updateItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			if (buttonPressed.equals("delete")) {
                String delmsg= (String) result;
                int split= delmsg.indexOf("|");
                String m1 = delmsg.substring(0,split);
                String m2= delmsg.substring(split+1, delmsg.length());
                // Following Plans have links to the record selected for deletion: | 12;13;1024
                if (delmsg.length() > 0) {
                    setErrorText(m1);
                	setErrorTextArea(m2);
                	showErrorWithTa(true);
                }
            } else if(buttonPressed.equals("update") || buttonPressed.equals("insert")){
            	String msg= (String) result;
            	if (msg.length() > 0){
            		setError(msg);
                	showErr(true);
            	}
            }
			gridPanel.clear();
			flexForm.clear();
			clearThisForm();
			currentActiveItem = -1;
			currentId = 0;
			gridLoad(1, 1, "id", itemRootName, store);

		}

		public void onFailure(Throwable e) {
			String emsg = "Error occured while performing " + buttonPressed
					+ ":  " + trunc(e.toString(), 120);
			if (mainerror.length() > 0) {
				setError(mainerror);
			}
			setError(emsg);
			showErr(true);
			// Window.alert("An error occured while performing "+buttonPressed+
			// "  "+trunc(e.toString(),120) );
		}
	};

	public String trunc(String in, int len) {
		if (in.length() > len) {
			return in.substring(0, len);
		}
		return in;
	}

	// public ItemServiceAsync itemService=null;
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
		insertButton.setText("Insert " + noun);
		insertButton.setStyleName("ButtonClass");
		updateButton.setText("Update " + noun);
		updateButton.setStyleName("ButtonClass");
		deleteButton.setText("Delete " + noun);
		deleteButton.setStyleName("ButtonClass");
		// itemRootName=noun;

	}

	public void setHeadingName(String heading) {
		// headingLabel.setHTML("<H1>"+heading+"</H1>");
	}

	public String buttonPressed = "";

	public void doModuleLoad() {
		super.onModuleSetup();

		// Element gwtRoot= DOM.getElementById("gwtRoot");
		// rootPanel = RootPanel.get("gwtRoot");
		RootPanel rootPanel = RootPanel.get("gwtRoot");

		// Window.alert("Start at: "+rootPanel.getTitle());
		// Defaults for SimpleGridView
		textBox.setWidth("341px");
		orderBox.setWidth("40px");

		// Button Bar
		buttonBar.add(left, DockPanel.WEST);
		left.setWidth("200px");
		right.setWidth("440px");
		left.add(backButton);
		buttonBar.add(right, DockPanel.EAST);
		HTML spacer = new HTML("&nbsp;");
		right.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		right.add(insertButton);
		right.add(updateButton);
		right.add(deleteButton);

		// Add button listeners.

		insertButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);

				boolean ok = Window.confirm("Insert new  entry: "
						+ textBox.getText() + ": are you sure?");
				currentActiveItem = gridPanel.getActiveItem();
				if (ok) {
					buttonPressed = "insert";

					getFormController()
							.insert(itemRootName, updateItemCallback);
				}

			}
		});
		updateButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				if (currentId <= 0) {
					setError("Record selection required");
					showErr(true);
				} else {
					currentActiveItem = gridPanel.getActiveItem();
					boolean ok = Window.confirm("Update entry: "
							+ textBox.getText() + ": are you sure?");
					if (ok) {
						buttonPressed = "update";
						getFormController().update(itemRootName,
								updateItemCallback);
					}
				}

			}
		});

		deleteButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				if (currentId <= 0) {
					setError("Record selection required");
					showErr(true);
				} else {
					currentActiveItem = gridPanel.getActiveItem();
					boolean ok = Window.confirm(delAskMsg + textBox.getText()
							+ ": are you sure?");
					if (ok) {
						buttonPressed = "delete";
						// Item item = new Item();
						formController.delete(itemRootName, updateItemCallback);
					}
				}
			}
		});

		// Build up Main dock panel
		rootPanel.add(dockPanel);
		dockPanel.setWidth("642px");
		spacerBar.setSize(screenWidth, "10px");

		// Page heading
		// headingLabel.setHTML("<p>&nbsp;</p>");
		// headingBar.add(headingLabel);
		// headingBar.setSize(screenWidth,"30px");
		dockPanel.add(headingBar, DockPanel.NORTH);
		headingBar.setHeight("2px");
		headingBar.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

		// Add panels below the gridpanel
		if (showButtonRow) {
			dockPanel.add(buttonBar, DockPanel.SOUTH);
		}
		
		dockPanel.add(errorTextPanel, DockPanel.SOUTH);		
		dockPanel.add(errorPanel, DockPanel.SOUTH);
		
		
		
		errorPanel.setSize(screenWidth, "12px");
		errorTextPanel.setSize(screenWidth, "12px");
		
		buttonBar.setSize(screenWidth, "58px");
		dockPanel.add(formPanel, DockPanel.SOUTH);
		dockPanel.add(spacerBar, DockPanel.SOUTH);
		formPanel.add(flexForm);
		loadErrorSetup(errorPanel, errorTextPanel);
		
		loadErrorSetup(errorPanel, errorTextPanel);
		
		CSS.swapStyleSheet("theme", "js/ext/resources/css/xtheme-gray.css");

	}

	boolean validate(FlexibleForm flexForm) {
		boolean ret = true;

		return ret;
	}

	UrlParam[] urlParams = null;

	void gridLoad(int selectedItem, int institutionId, String sort,
			String dataset) {
		gridLoad(selectedItem, institutionId, sort, dataset, store);
	}

	// Institution serves as a filter but is actually present in the servlet
	// context.
	void gridLoad(int selectedItem, int institutionId, String sort,
			String dataset, Store store) {

		UrlParam[] urlParams = { new UrlParam("start", institutionId),
				new UrlParam("limit", pageSize),
				new UrlParam("institution", institutionId),
				new UrlParam("dataset", dataset), new UrlParam("sort", sort),
				new UrlParam("dir", "ASC") };
		store.setDefaultSort("order", SortDir.ASC);

		store.setBaseParams(urlParams);

		store.load(urlParams);
		// formController.gridDisplayEdit();
		gridPanel.setActiveItem(currentActiveItem);
	}

	int currentActiveItem = -1;

	MyHeaderListener headerlistener = new MyHeaderListener();

	protected void clearThisForm() {};
}
