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
package org.kuali.continuity.admin.project.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SourcesTableEvents;
import com.google.gwt.user.client.ui.TableListener;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.HttpProxy;
import com.gwtext.client.data.JsonReader;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.widgets.grid.event.GridHeaderListener;
import com.gwtext.client.widgets.grid.event.GridRowListener;
import com.gwtextux.client.data.PagingMemoryProxy;

/**
 * Entry point classes define <code>onModuleLoad()</code>. This is the Kuali
 * Continuity Admin Role Management Application in GWT.
 */

public class ImageViewer  extends ListControl implements EntryPoint,
		TableListener {

	// Model control variables.
	boolean localpaging = true;
	boolean showpagingbar = false;
	boolean showingscrollbar = true;
	// Application control variables.
	int roleGridCols = 6;
    String buttonPressed="";
	KcpServiceAsync kcpService;
	HttpProxy dataProxy = new HttpProxy("./accounts");
	String currentSort= "name";	
	String [] sorts = { "userID", "name", "emailregular","workPhone","securityType", "accessStatus"};
	Object[][] userData = new Object[][] {};
	PagingMemoryProxy memproxy = new PagingMemoryProxy(userData);

	final RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("name"), new StringFieldDef("emailregular"),
			new StringFieldDef("workPhone"),
			new StringFieldDef("securityType"),
			new StringFieldDef("accessStatus"), new StringFieldDef("userID") });
	ArrayList persons = null;

	JsonReader reader = new JsonReader(recordDef);
	// MEM ArrayReader reader2 = new ArrayReader(recordDef);

	private Button clickMeButton;
	final FormPanel formPanel = new FormPanel();

	protected final String CSRF_TOKEN = "adminCsrfToken";

	// Buttons

	final Button backButton = new Button();
	final Button insertAccountButton = new Button();
	final Button updateAccountButton = new Button();
	final Button deleteAccountButton = new Button();

	// Headings
	final Label headingLabel = new Label("Role Management");
	final Label trustAccessLabel = new Label(
			"This location is configured for Shibboleth Trust authentication. Only Role and Access fields can be updated. ");
	// Grid


	final GridPanel roleGrid = new GridPanel();

	int roleGridTopItem = 0;

	// Form
	final ListBox universityListBox = new ListBox();

	// Search and Trust Section.
//	final Label firstSearchLabel = new Label("First Name");
//	final TextBox firstSearchTextBox = new TextBox();
//	final Label lastSearchLabel = new Label("Last Name");
//	final Image searchButton = new Image("Search2.gif");
//	final TextBox lastSearchTextBox = new TextBox();

	//final HTML directoryidLabel = new HTML("<span class='required'>*</span> DirectoryID");
	//final TextBox directoryidTextBox = new TextBox();

	// Not visible: User Key Info.
	final TextBox idTextBox = new TextBox();

	// Main Form
	final Image formImage = new Image("spacer.gif");
	final HTML firstNameLabel = new HTML("<span class='required'>*</span>First&nbsp;Name");
	final TextBox firstNameTextBox = new TextBox();

	final HTML lastNameLabel =  new HTML("<span class='required'>*</span>Last&nbsp;Name");
	final TextBox lastNameTextBox = new TextBox();

	final HTML roleLabel = new HTML("<span class='required'>*</span>Role");
	final ListBox roleListBox = new ListBox();

	final Label titleLabel = new Label("Title");
	final TextBox titleTextBox = new TextBox();

	final Label departmentLabel = new Label("Department");
	final TextBox departmentTextBox = new TextBox();

	final Label emailLabel = new HTML("<span class='required'>*</span>EMail");
	final TextBox emailTextBox = new TextBox();

	final HTML phoneLabel = new HTML("&nbsp;Phone");
	final TextBox phoneTextBox = new TextBox();

	final HTML loginLabel = new HTML("<span class='required'>*</span>Login&nbsp;Name");
	
	final TextBox loginTextBox = new TextBox();
	
	final HTMLPanel passwordPanel = new HTMLPanel("<span class='required'>*</span>Password&nbsp;<span id='passwordTextBox'  ></span>");
	// final HTMLPanel passwordPanel = new HTMLPanel("<span id='loginTextBox'  ></span>&nbsp;  <span class='required'>*</span>Password&nbsp;<span id='passwordTextBox'  ></span>");


	final PasswordTextBox passwordTextBox = new PasswordTextBox();

	final HTML accessLabel = new HTML("&nbsp;Access");
	final ListBox accessListBox = new ListBox();

	final Hidden csrfToken = new Hidden();
	// Callback
	public AsyncCallback callback = new AsyncCallback() {
		public void onSuccess(Object result) {
			String gotit = (String) result;

			Window.alert("The button was pressed:" + gotit);

		}

		public void onFailure(Throwable e) {
			//Window.alert("An error occured:" + e);
			redirect(getLogoutUrlWithParm("3"));
		}
	};
	// Current User Information
	String curId = "";
	// xxxx
	int rolePullDownSelects[] = { -1, 0, 3, 1, 2, 4, 9 };
	int rolePullDownSelects0[] = { -1, 0, 3, 1, 2, 4, 9 };
	int rolePullDownSelects3[]= { -1,  3, 1, 2, 4, 9 };
	int rolePullDownSelects1[]= { -1,  1, 2, 4, 9 };
	
	
	
	public AsyncCallback usercallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			showErr(false);
			UserInfo u = (UserInfo) result;
			idTextBox.setText("" + u.getUserId());
			firstNameTextBox.setText(u.getFirstName());

			lastNameTextBox.setText(u.getLastName());
			emailTextBox.setText(u.getEmailregular());
			phoneTextBox.setText(u.getWorkPhone());
			titleTextBox.setText(u.getTitle());
			departmentTextBox.setText(u.getDepartmentName());
			int itemselected = (int) Integer.parseInt(u.getAccessStatus());  // Either 0 or 1.
			accessListBox.setSelectedIndex(itemselected);
			loginTextBox.setText(u.getAuthId());
			passwordTextBox.setText(u.getPassword());
			idTextBox.setText(u.getUserId().toString());

			//directoryidTextBox.setText(u.getDirectoryId());
			
			// accessListBox.setItemSelected(itemselected, false);
			// xxxx
			int roleselected = -1;
			
			
			int sectype = Integer.parseInt(u.getSecurityType());
			// Translate the security type.
			for (int i = 0; i < rolePullDownSelects.length; i++) {
				if (sectype == rolePullDownSelects[i]) {
					roleselected = i;
					break;
				}
			}

				
			roleListBox.setItemSelected(roleselected, true);
			
			if(u.isUserSelf()){
				roleListBox.setEnabled(false);
			}else{
				roleListBox.setEnabled(true);
			}

		}

		public void onFailure(Throwable e) {
			//Window.alert("An error occured reading user:" + trunc(e.toString(),200));
			//Window.alert("Host Base URL is: " + GWT.getHostPageBaseURL());
			//Window.alert("Host is: " + getHostName());
			//Window.alert(getLogoutUrlWithParm("3"));
			redirect(getLogoutUrlWithParm("3"));
		}
	};
	
	
	
	public native void redirect(String url)
	/*-{
	        $wnd.parent.location.replace(url);

	}-*/; 
	
	public void onCellClicked(SourcesTableEvents sender, int row, int cell) {
		// highlight(null, row);

	}

	// public void onTableLoad(List<User> ulist) {
	// int row = 0;
	//
	// for (User u : ulist) {
	//
	// }
	//
	// }
	
	public class MyHeaderListener implements GridHeaderListener {

		public void onHeaderClick(GridPanel grid, int colIndex, EventObject e) {
			currentSort=sorts[colIndex];
			int selectedItem = universityListBox.getSelectedIndex();
			final int institutionId = new Integer(universityListBox
					.getValue(selectedItem)).intValue();
			gridLoad(selectedItem, institutionId);

		}

		public void onHeaderContextMenu(GridPanel grid, int colIndex,
				EventObject e) {
			// TODO Auto-generated method stub

		}

		public void onHeaderDblClick(GridPanel grid, int colIndex, EventObject e) {
			this.onHeaderClick(grid, colIndex, e);

		}

	}


	MyHeaderListener headerlistener = new MyHeaderListener();

	public class MyRowListener implements GridRowListener {

		public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
			showErr(false);
			Record record = grid.getStore().getAt(rowIndex);
			String[] fields = record.getFields();
			String f = "";
			for (String fi : fields) {
				f += " " + fi;
			}

			String id = record.getAsString("userID");
			// Window.alert("Row: "+id);
			kcpService.getUser(id, usercallback);

		}

		public void onRowContextMenu(GridPanel grid, int rowIndex, EventObject e) {
			// TODO Auto-generated method stub

		}

		public void onRowDblClick(GridPanel grid, int rowIndex, EventObject e) {
//			Window.alert("Row click: " + rowIndex + " "
//					+ e.getClass().getName());
		}

	}

	public MyRowListener rowlistener = new MyRowListener();

	// public void onCellClicked(final SourcesTableEvents sender, final int
	// row, final int cell) {
	//				
	// highlight(roleGrid, row);
	//			 
	// }
	// });

	
	// Grid Column size.
	int[] gcsize = { 200, 200, 160, 80, 50, 0 };
	int curinst = 1;

	String[] heading = { "Name", "Email", "Phone", "Role", "Access", "" };

	public ColumnConfig nameColumn = new ColumnConfig("Name", "name",
			gcsize[0], true);

	public ColumnConfig emailColumn = new ColumnConfig("Email", "emailregular",
			gcsize[1], true);

	public ColumnConfig phoneColumn = new ColumnConfig("Phone", "workPhone",
			gcsize[2], true);
	public ColumnConfig roleColumn = new ColumnConfig("Role", "securityType",
			gcsize[3], true);
	public ColumnConfig accessColumn = new ColumnConfig("Access",
			"accessStatus", gcsize[5], true);

	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { nameColumn,
			emailColumn, phoneColumn, roleColumn, accessColumn });

	int pageSize = 999;
	final Store store = new Store(dataProxy, reader, true);


	public void onModuleLoad() {
		
		//
		// Grid
		//
		if (!showingscrollbar) {
			pageSize = 7;
		}

		kcpService = (KcpServiceAsync) GWT.create(KcpService.class);
		int startinstitutionId = curinst;
		kcpService.getUserArray(startinstitutionId, callbackUserload);

		// PagingMemoryProxy memproxy = new PagingMemoryProxy(userData);
	
		
		store.setDefaultSort("name", SortDir.ASC);

		reader.setRoot("persons");

		// reader.setTotalProperty("totalPersons");
		reader.setId("UserID");

		RootPanel rootPanel = RootPanel.get();
		rootPanel.setStylePrimaryName("user-accounts-page");
		VerticalPanel vp = new VerticalPanel();
		rootPanel.add(vp);
		vp.add(new HTML("<h1>Manage User Accounts</h1>"));
		vp.add(new HTML("<p class='StandardWidth'>Please use this page to manage user accounts and access roles.</p>"));
		vp.add(new HTML("<p class='StandardWidth'>To modify an existing item, first highlight that row on the grid then use the entry-forms at the bottom to modify.</p>"));
		HTMLPanel buttonPanel = new HTMLPanel("<div class='MyButtonsDivClass'><div class='floatLeft' id='leftButtons'></div><div class='floatRight' id='rightButtons'></div></div>");
		// rootPanel.add(formPanel, 20, 581);
		// formPanel.setSize("639px", "39px");
		// formPanel.setTitle(" ");

		roleGrid.setStore(store);

		// EXT roleGrid.addTableListener(new TableListener() {

		// EXT roleGrid.setCellPadding(0);
		// EXT initData(roleGrid);
		// EXT highlight(roleGrid, 1);
		// EXT ColumnFormatter cf = roleGrid.getColumnFormatter();
		// EXT roleGrid.addTableListener(this);
		// EXT roleGrid.setCellSpacing(0);
		// roleGrid.addGridHeaderListener(headerlistener);
		roleGrid.addGridRowListener(rowlistener);
		roleGrid.setTitle("Accounts");
		roleGrid.setCls(".myclass");

		roleGrid.setColumnModel(columnModel);

		roleGrid.setTrackMouseOver(true);

		roleGrid.setLoadMask(true);
		roleGrid.setSelectionModel(new RowSelectionModel());
		roleGrid.setStripeRows(true);
		roleGrid.setIconCls("grid-icon");
		roleGrid.setEnableColumnResize(true);
		GridView view = new GridView();
		view.setForceFit(true);
		roleGrid.setView(view);

		//
		if (showpagingbar) {
			PagingToolbar pagingToolbar = new PagingToolbar(store);
			pagingToolbar.setPageSize(pageSize);
			pagingToolbar.setDisplayMsg("");
			pagingToolbar.setDisplayInfo(false);

			roleGrid.setBottomToolbar(pagingToolbar);
		}
		if (!showingscrollbar) {
			pageSize = 7;
		}

		final UrlParam[] urlParams = {
				// new UrlParam("start", 0),
				new UrlParam("limit", pageSize),
				new UrlParam("institution", curinst), new UrlParam("sort", "name"),
				new UrlParam("dir", "ASC") };
		store.setBaseParams(urlParams);
		store.setRemoteSort(false);

		if (localpaging) {
			store.load(0, pageSize);
		} else {
			roleGrid.addListener(new PanelListenerAdapter() {
				public void onRender(Component component) {

					// store.load(urlParams,false);
					store.load(0, pageSize);
				}
			});
		}
		vp.add(roleGrid);
		roleGrid.setSize("660px", "226px");
		vp.add(universityListBox);
		universityListBox.addStyleName("insselector-row");
		vp.add(trustAccessLabel);
	
		headingLabel.setStylePrimaryName("h1");
		headingLabel.addStyleName("h1");
		headingLabel.setWidth("212px");

		buttonPanel.add(backButton, "leftButtons");
		backButton.setWidth("41px");
		backButton.setStyleName("ButtonClass");
		backButton.setText("Back");
		backButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
                showErr(false);
                redirect("/continuity/admin/adminHome");
			}
		});

		buttonPanel.add(insertAccountButton, "rightButtons");
		insertAccountButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				boolean ok = Window.confirm("Insert new user account: "
						+ firstNameTextBox.getText() + " "
						+ lastNameTextBox.getText() + ". are you sure?");
				if (ok) {
					buttonPressed="insert";
					UserInfo ui = new UserInfo();
					saveUserFields(ui,true);
					validateUser(ui,errlist);
					if (errlist!=null && errlist.getItemCount()>0) {
						showErr(true);
					} else {
						kcpService.createUser(ui, callbackCreateUser);
//						StringBuilder error = new StringBuilder();
//						kcpService.createUser(ui, error, callbackUpdate);
//						
//						if (error.length() > 0){
//							setError("Specified login name already exists");
//							showErr(true);
//						}
						
					}
				}

			}
		});
       
		insertAccountButton.setText("Insert Account");
		insertAccountButton.setStyleName("ButtonClass");

		buttonPanel.add(updateAccountButton,"rightButtons");
		updateAccountButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				boolean ok = Window.confirm("Update  user account "
						+ firstNameTextBox.getText() + " "
						+ lastNameTextBox.getText() + ": are you sure?");
				if (ok) {
					buttonPressed="update";
					UserInfo ui = new UserInfo();
					saveUserFields(ui);
                    validateUser(ui,errlist);
                    if (errlist!=null && errlist.getItemCount()>0) {
						showErr(true);
					} else {
						kcpService.updateUser(ui, callbackUpdateUser);
					}
				}

			}
		});
		updateAccountButton.setText("Update Account");
		updateAccountButton.setStyleName("ButtonClass");
		
		// public void onClick(final Widget sender) {
		//
		// kcpService.getButtonAnswer(callback);
		//
		// }
		buttonPanel.add(deleteAccountButton, "rightButtons");
		deleteAccountButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				boolean ok = Window.confirm("Delete user account "
						+ firstNameTextBox.getText() + " "
						+ lastNameTextBox.getText()+" "+idTextBox.getText() +": are you sure?");
				if (ok) {
					buttonPressed="delete";
					UserInfo ui = new UserInfo();

					saveUserFields(ui);
					kcpService.deleteUser(ui, callbackUpdateUser);
				}

			}
		});
		deleteAccountButton.setText("Delete Account");
		deleteAccountButton.setStyleName("ButtonClass");
		
		
		
		FlexTable formTable = new FlexTable();
		vp.add(formTable);
		vp.add(buttonPanel);
		formTable.setStylePrimaryName("user-accounts-form");
		formTable.setWidget(0,0,firstNameLabel);
		formTable.setWidget(0,1,firstNameTextBox);
		
		/* NOT SURE what the ID Box is for, so disabling it 
		idTextBox.setVisible(false);
		formTable.setWidget(0,2,idTextBox);
		idTextBox.setWidth("7px");
		*/
		
		firstNameTextBox.setWidth("120px");
		firstNameTextBox.setMaxLength(20);
		
		//formPanel1.add(starLabel1);
		formTable.setWidget(0,2,new HTML("<span class='required'>*</span>Last&nbsp;Name"));

		formTable.setWidget(0,3,lastNameTextBox);
		lastNameTextBox.setWidth("115px");
		lastNameTextBox.setMaxLength(30);

		formTable.setWidget(0,4,roleLabel);
		formTable.setWidget(0,5,roleListBox);
		// xxxx
		// ROLE VALUE List 2 of 4 .  Next go to DisplayUtil
		roleListBox.setStyleName("AccountRoleSelectClass");

		roleListBox.setWidth("120px");
		roleListBox.setVisibleItemCount(1);
		
		
		
		formTable.setWidget(1,0,titleLabel);
	

		formTable.setWidget(1,1,titleTextBox);
		titleTextBox.setWidth("552px");
		titleTextBox.setMaxLength(100);
		
		formTable.getFlexCellFormatter().setColSpan(1, 1, 5);

		formTable.setWidget(2,0,departmentLabel);
	

		formTable.setWidget(2,1,departmentTextBox);
		departmentTextBox.setWidth("552px");
		departmentTextBox.setMaxLength(100);
		formTable.getFlexCellFormatter().setColSpan(2, 1, 5);

		formTable.setWidget(3,0,emailLabel);
		
		HTMLPanel hpanel = new HTMLPanel("<div class='gwt-HTML'><span id='emailTextBox'></span> Phone <span id='phoneTextBox'></span> Access  <span id='accessListBox'></span></div>");
		hpanel.add(emailTextBox,"emailTextBox");
		emailTextBox.setWidth("252px");
		//emailTextBox.setMaxLength(50);
		
		//hpanel.add(phoneLabel,"items");
		hpanel.add(phoneTextBox,"phoneTextBox");
		//hpanel.add(accessLabel,"items");
		hpanel.add(accessListBox,"accessListBox");
		
		formTable.setWidget(3,1,hpanel);
		formTable.getFlexCellFormatter().setColSpan(3, 1, 5);
		//formTable.setWidget(3,3,phoneTextBox);
		phoneTextBox.setWidth("115px");
		phoneTextBox.setMaxLength(20);

		//formTable.setWidget(3,4,accessLabel);
		//formTable.setWidget(3,5,accessListBox);

		accessListBox.addItem("OFF", "0");
		accessListBox.addItem("ON", "1");
		
		accessListBox.setSize("63px", "22px");
		accessListBox.setVisibleItemCount(1);
		accessListBox.setSelectedIndex(1);
        // loginLabel.setWidth("72px");
		formTable.setWidget(4,0,loginLabel);
		

		// rootPanel.add(starLabel4, 420, 545);
		// rootPanel.add(passwordLabel, 430, 548);
		// passwordLabel.setWidth("71px");

		// rootPanel.add(directoryIdLabel,475,25);
		// directoryIdLabel.setWidth("71px");
		// rootPanel.add(directoryIdTextBox,475,107);
		// directoryIdTextBox.setWidth("552px");

		formTable.setWidget(4,1,loginTextBox);
		loginTextBox.setWidth("252px"); // Was 552
		loginTextBox.setMaxLength(256);
		formTable.getFlexCellFormatter().setColSpan(4, 1,3);
		formTable.getFlexCellFormatter().setColSpan(4, 2,3);
		
		
		
		// formTable.setWidget(4, 3, passwordLabel);
		// formTable.setWidget(4,4,passwordTextBox);
		passwordTextBox.setWidth("135px");
		passwordTextBox.setMaxLength(50);
	
		
		// HorizontalPanel hpanel2 = new HorizontalPanel();
		

        passwordPanel.setStylePrimaryName ("gwt-HTML");
		passwordPanel.add(passwordTextBox,"passwordTextBox");
		
		// hpanel2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		formTable.setWidget(4,2,passwordPanel);
		
		
		//formTable.setWidget(5,0,directoryidLabel);
		//formTable.setWidget(5,1,directoryidTextBox);

		//directoryidTextBox.setWidth("552px");
		//directoryidTextBox.setMaxLength(12);
		formTable.getFlexCellFormatter().setColSpan(5, 1, 5);
		
		universityListBox.setWidth("300px");
		universityListBox.addChangeListener(new ChangeListener() {
			public void onChange(final Widget sender) {
				showErr(false);
				int selectedItem = universityListBox.getSelectedIndex();
				
				final int institutionId = new Integer(universityListBox
						.getValue(selectedItem)).intValue();
				curinst=institutionId;
				currentSort=sorts[1];
				gridLoad(selectedItem, institutionId);

			}
		});

		universityListBox.setWidth("300px");

		universityListBox.setVisibleItemCount(1);

//		rootPanel.add(firstSearchLabel, 280, 350);
//		rootPanel.add(firstSearchTextBox, 350, 345);
//		firstSearchTextBox.setWidth("90px");
//		rootPanel.add(lastSearchLabel, 450, 350);
//		lastSearchTextBox.setWidth("80px");
//		rootPanel.add(lastSearchTextBox, 520, 345);
//		rootPanel.add(searchButton, 605, 350);
//		searchButton.addClickListener(new ClickListener() {
//			public void onClick(final Widget sender) {
//				showErr(false);
//				Window.confirm("Search for: " + firstSearchTextBox.getText()
//						+ " " + lastSearchTextBox.getText() + "?");
//				setError("Search not allowed.");
//				setError("Wait until next version.");
//			}
//		});
		
		//rootPanel.add(trustAccessLabel, 25, 375);

		// rootPanel.add(passwordTextBox, 500, 545);

		// passwordTextBox.setWidth("96px");
		// passwordTextBox.setMaxLength(12);


		formImage.setSize("52px", "70px");

		//rootPanel.add(formImage, 20, 393);
		formImage.setStylePrimaryName("gwt-Image1");
		formImage.setSize("649px", "217px");
		formImage.setVisibleRect(20, 393, 649, 217);

		kcpService.getInstitutions(callbackUload);

		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		vp.add(csrfToken);

		CSS.swapStyleSheet("theme", "js/ext/resources/css/xtheme-gray.css");
		rootPanelLoadErrorSetup(rootPanel, 20, 602);
		onModuleSetup();
		
	}
    // END of onModuleLoad
	// ******************************************************
	
   void gridRefresh() {
		
		int selectedItem = universityListBox.getSelectedIndex();
		final int institutionId = new Integer(universityListBox
				.getValue(selectedItem)).intValue();
		gridLoad(selectedItem, institutionId);
	   
   }	

   	
	void gridLoad(int selectedItem, int institutionId) {
		gridLoad(selectedItem, institutionId, currentSort);
	}

	void gridLoad(int selectedItem, int institutionId, String sort) {


		final UrlParam[] urlParams = { new UrlParam("start", institutionId),
				new UrlParam("limit", pageSize),
				new UrlParam("institution", institutionId),
				new UrlParam("sort", sort), new UrlParam("dir", "ASC") };
		store.setDefaultSort("name", SortDir.ASC);
		// store.setBaseParams(urlParams);
		store.load(urlParams);
		// Window.alert("calling trustForm "+institutionId+" "+selectedItem);
		trustForm(isTrustList[selectedItem]);
		// End new code.
	}

	void trustForm(boolean isTrust) {

//		firstSearchLabel.setVisible(isTrust);
//		lastSearchLabel.setVisible(isTrust);
//		firstSearchTextBox.setVisible(isTrust);
//		lastSearchTextBox.setVisible(isTrust);
//		searchButton.setVisible(isTrust);
		trustAccessLabel.setVisible(isTrust);

		loginLabel.setVisible(!isTrust);
		loginTextBox.setVisible(!isTrust);
		passwordPanel.setVisible(!isTrust);
		passwordTextBox.setVisible(!isTrust);
		//directoryidLabel.setVisible(isTrust);
		//directoryidTextBox.setVisible(isTrust);
		enableForm(!isTrust); // Input fields are disabled for Trust Form.
		
		// modify role list
		int roleCount = roleListBox.getItemCount();
		int testIndex = roleCount - 2;
		String roleValue = roleListBox.getValue(testIndex);
		if (isTrust && roleValue.trim().equals("4")) {
			roleListBox.removeItem(testIndex);
			int[] rTestList = new int[roleCount-1];
			for (int i=0,j=0; i < this.rolePullDownSelects.length; i++) {
				if (this.rolePullDownSelects[i] != 4) {
					rTestList[j] = this.rolePullDownSelects[i];
					j++;
				}
			}
			this.rolePullDownSelects = rTestList;
		} else if (!isTrust && !roleValue.trim().equals("4")) {
			roleListBox.insertItem("Moderator", "4", testIndex+1);
			int[] rTestList = new int[roleCount+1];
			for (int i=0; i < (this.rolePullDownSelects.length - 1); i++) {
				rTestList[i] = this.rolePullDownSelects[i];
			}
			rTestList[roleCount-1] = 4;
			rTestList[roleCount] = this.rolePullDownSelects[roleCount-1];
			this.rolePullDownSelects = rTestList;
		}
	}

	void enableElement(TextBox t, boolean enabled) {
		t.setEnabled(enabled);
		t.setReadOnly(!enabled);
		String primarycolor = "gandalfwhite";
		if (!enabled) {
			primarycolor = "gandalfgrey";

		}
		t.setStylePrimaryName(primarycolor);
		t.setStyleName(primarycolor);

	}

	void enableForm(boolean enabled) {
		enableElement(firstNameTextBox, enabled);
		enableElement(lastNameTextBox, enabled);
		enableElement(titleTextBox, enabled);
		enableElement(departmentTextBox, enabled);
		enableElement(emailTextBox, enabled);
		enableElement(phoneTextBox, enabled);
		enableElement(loginTextBox, enabled);
		enableElement(passwordTextBox, enabled);
		//enableElement(directoryidTextBox, enabled);

	}
    boolean isEmpty(String s) {
    	boolean ret=false;
    	if (s==null) {
    		ret=true;
    	} else {
    		if (s.trim().length()==0) {
    			ret=true;
    		}
    	}
    	return ret;
    }
    void addif(ListBox list, boolean condition, String msg) {
    	if (condition) {
    		list.addItem(msg);
    	}
    }
    
    void checkfield(ListBox l, TextBox t, String fn) {
    	addif(l, isEmpty(t.getText()) && t.isEnabled(), fn+" can not be empty.");
    	
    }
	void validateUser(UserInfo ui, ListBox ret) {
	
        addif(ret, isEmpty(ui.getLastName()), "Last name can not be empty.");
        addif(ret, isEmpty(ui.getLastName()), "First name can not be empty.");
        addif(ret, isEmpty(ui.getAuthId()) && loginTextBox.isVisible(),"Login Name must be specified.");
        addif(ret, isEmpty(ui.getPassword()) && loginTextBox.isVisible() && buttonPressed.equals("insert"),"Password must be specified.");
        addif(ret, !isEmpty(ui.getPassword()) && loginTextBox.isVisible() && ui.getPassword().length()<8,"Password must be at least 8 characters.");
        addif(ret, isEmpty(ui.getEmailregular()) && loginTextBox.isVisible(),"EMail Address must be specified.");
        
        //addif(ret, isEmpty(ui.getDirectoryId()) && directoryidTextBox.isVisible(), "Directory ID must be specified.");
        addif(ret, isEmpty(ui.getSecurityType()) || ui.getSecurityType().equals("-1"), "Account role required.");
	}
    String noNulls(String strin) {
    	String ret="";
    	if (strin!=null) {
    		ret=strin;
    	}
    	return ret;
    }
    void saveUserFields(UserInfo ui) {
    	saveUserFields(ui,false);
    	
    }
    
	void saveUserFields(UserInfo ui, boolean adding) {
		int index=universityListBox.getSelectedIndex();
		ui.setInstitutionId(new Integer(universityListBox.getValue(index)));
	
		ui.setLastName(lastNameTextBox.getText());
		ui.setFirstName(firstNameTextBox.getText());
		if (!adding) {
			ui.setUserId(Integer.parseInt(idTextBox.getText())); 
		} else {
			// ui.setUserId(null); Shouldn't be necessary.
		}
		ui.setTitle(titleTextBox.getText());
		
		ui.setEmailregular(emailTextBox.getText());
	    ui.setDepartmentName(departmentTextBox.getText());
		//ui.setDirectoryId(noNulls(directoryidTextBox.getText()));
	
		ui.setWorkPhone(noNulls(phoneTextBox.getText()));
		ui.setAuthId(loginTextBox.getText());
		
	    ui.setPassword(passwordTextBox.getText());
		ui.setSecurityType(roleListBox.getValue(roleListBox
						.getSelectedIndex()));
		
    	int accessindex=this.accessListBox.getSelectedIndex();
		ui.setAccessStatus(accessListBox.getValue(accessindex));
		// if (buttonPressed.equals("insert")) {  -- Always.

		ui.setCsrfToken(csrfToken.getValue());
		// }
	}
    public void clearUserFields() {
    	idTextBox.setText("");
    	lastNameTextBox.setText("");
    	firstNameTextBox.setText("");
    	titleTextBox.setText("");
    	emailTextBox.setText("");
    	departmentTextBox.setText("");
    	//directoryidTextBox.setText("");
    	phoneTextBox.setText("");
    	loginTextBox.setText("");
    	roleListBox.setSelectedIndex(0);
    	accessListBox.setSelectedIndex(1);  // KCP-98 default is on.
    	passwordTextBox.setText("");
 	   
    }
    
    // Not in use?
	public void addToUserList(UserInfo ui) {

	}

	public AsyncCallback callbackUpdate = new AsyncCallback() {
		public void onSuccess(Object result) {
			
			roleGrid.clear();
			// loadGrid(roleGrid, (String[][]) result);
			
			userData = (Object[][]) result;
			clearUserFields();
			int selectedInstItem=universityListBox.getSelectedIndex();
			// Window.alert("Selected Institution: "+selectedInstItem+" "+universityListBox.getValue(selectedInstItem));
			gridRefresh();
			// Window.alert("I got here: ");
			// Window.alert("The button was pressed:" + gotit);

		}

		public void onFailure(Throwable e) {
			String emsg="Error occured while performing "+buttonPressed+":  "+trunc(e.toString(),120);
			setError(emsg);
		}
	};
	
	public AsyncCallback callbackUpdateUser = new AsyncCallback() {
		public void onSuccess(Object result) {			
                String delmsg= (String) result;
               
                // Following Plans have links to the record selected for deletion: | 12;13;1024
                if (delmsg.length() > 0) {
                	setError(delmsg);
        			showErr(true);
                } 
            clearUserFields();
			roleGrid.clear();
			gridRefresh();
		}
		public void onFailure(Throwable e) {
			String emsg="Error occured while performing "+buttonPressed+":  "+trunc(e.toString(),120);
			setError(emsg);
		}
	};
	
	public AsyncCallback callbackCreateUser = new AsyncCallback() {
		public void onSuccess(Object result) {			
                String delmsg= (String) result;
               
                // Following Plans have links to the record selected for deletion: | 12;13;1024
                if (delmsg.length() > 0) {
                	setError(delmsg);
        			showErr(true);
                } 
            clearUserFields();    
			roleGrid.clear();
			gridRefresh();
		}
		public void onFailure(Throwable e) {
			String emsg="Error occured while performing "+buttonPressed+":  "+trunc(e.toString(),120);
			setError(emsg);
		}
	};
	
    public String trunc(String in, int len) {
    	if (in.length()> len) {
    		return in.substring(0,len);
    	}
    	return in;
    }
	public AsyncCallback callbackUserload = new AsyncCallback() {
		public void onSuccess(Object result) {

			roleGrid.clear();
			// loadGrid(roleGrid, (String[][]) result);
			userData = (Object[][]) result;
             
			// Window.alert("I got here: ");
			// Window.alert("The button was pressed:" + gotit);
			

		}

		public void onFailure(Throwable e) {
			//Window.alert("An error occured:" +trunc(e.toString(),200));	
			redirect(getLogoutUrlWithParm("3"));
		}
	};




	public AsyncCallback callbackUload = new AsyncCallback() {
		public void onSuccess(Object result) {

			universityListBox.clear();
			loadListBox(universityListBox, (String[][]) result, true);

			// Window.alert("I got here: ");
			// Window.alert("The button was pressed:" + gotit);

		}

		public void onFailure(Throwable e) {
			//Window.alert("Error occured reading institution list:" + trunc(e.toString(),200));
			redirect(getLogoutUrlWithParm("3"));
		}
	};
	public boolean isTrustList[] = null;

	public void loadListBox(ListBox lb, String[][] list, boolean emptyrow) {
		int nitems = list.length;
		int selectedIdx = 0;
		// if (emptyrow) {
		// lb.addItem("", "0");
		// }
		isTrustList = new boolean[nitems];
		int adminUserRole=0;
		if (list != null) {
			for (int i = 0; i < nitems; i++) {
				String[] nvp = (String[]) list[i];
				lb.addItem(nvp[0], nvp[1]);
				// 8,14,16,20

				// Set initially selected Institution
				int iid = Integer.parseInt(nvp[1]);
				
//				if (iid == curinst) {
//					lb.setItemSelected(i, true);
//				}
				// Refactored to get initial item from SAML
				
				if (nvp[2].trim().length()>0) {
				
					lb.setItemSelected(i, true);  // Selects current institution
					selectedIdx = i;
					curinst=iid;
					adminUserRole=Integer.parseInt(nvp[2]);
					roleListBox.addItem("--Select Role--", "-1");
					
					if (adminUserRole==0) {
						rolePullDownSelects = rolePullDownSelects0; 
						roleListBox.addItem("System Admin", "0");
						roleListBox.addItem("Institution Admin", "3");
						roleListBox.addItem("Local Admin", "1");
					} else if (adminUserRole==3) {
						rolePullDownSelects = rolePullDownSelects3; 
						roleListBox.addItem("Institution Admin", "3");
						roleListBox.addItem("Local Admin", "1");
						
					}  else if (adminUserRole==1) {
						rolePullDownSelects = rolePullDownSelects1; 
						roleListBox.addItem("Local Admin", "1");
						
					}  
					roleListBox.addItem("Universal Viewer", "2");
					roleListBox.addItem("Moderator", "4");
					roleListBox.addItem("Local User", "9");

				}
               

//				if (iid == 23 || iid == 27 || iid == 28 || iid == 29) { // test
//					// code
//					// (replace
//					// with
//					// npv[3]
//					isTrustList[i] = false;
//				} else {
//					isTrustList[i] = true;
//				}
				isTrustList[i]=nvp[3].equals("Y");
			}
			
			if(isTrustList.length == 1){
				trustForm(isTrustList[0]);
			} else{
				trustForm(isTrustList[selectedIdx]);
			}

		}
		// lb.setItemSelected(curinst, true);
	}


	public class TextBoxItem extends TextBox {
		int row = 0;
		int cell = 0;

		public void setRow(int rowin) {
			row = rowin;
		}

		TableListener container = null;;

		public void setContainer(TableListener contin) {
			container = contin;
		}

		public int getRow() {
			return row;
		}

		TextBoxItem() {
			super();
			this.addClickListener(new ClickListener() {
				public void onClick(final Widget sender) {
					showErr(false);
					container.onCellClicked(null, row, cell);
				}
			});
		}

	}

}

