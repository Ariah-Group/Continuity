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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class Setting extends ListControl implements EntryPoint {

	final HTML switchAccessOnoffHTML = new HTML(
			"<h3> Switch Access On/Off:</h3>");
	final Label locationLabel = new Label("Location");	
	
	final Label locationTextLabel = new Label();
	
	final TextBox locationTextBox = new TextBox();
	
	Hidden csrfToken = new Hidden();
	
	// final Label sublocationLabel = new Label("Sublocation");
	// final TextBox sublocationTextBox = new TextBox();
	final Label accessLabel = new Label("Access");
	final ListBox accessListBox = new ListBox();
	final HTML screenOptionsHTML = new HTML(
			"<H3 style='margin-bottom:8px;'> Select Optional Screens:  </H3>");
	final CheckBox showTeamsCheckBox = new CheckBox();
	final CheckBox showSkillsCheckBox = new CheckBox();
	final CheckBox showStaffingBox = new CheckBox();
	final CheckBox showExamplesOfCheckBox = new CheckBox();
	final CheckBox replaceStep4 = new CheckBox();
	final Button backButton = new Button();
	final Button saveSettingsButton = new Button();
	public SimpleServiceAsync itemService = null;
	int domaincount = 0;
	ArrayList domainList = new ArrayList();
	HashMap domainMap = new HashMap();
	HashMap<String, String> systemAccessIndex = new HashMap();

	VerticalPanel tableRoot;
	// Radio buttons

	final RadioButton radioFull = new RadioButton("new-group");
	final RadioButton radioPartial = new RadioButton("new-group");
	final TextBox domainTextBox = new TextBox();
	final TextBox systemNameTextBox = new TextBox();
	final VerticalPanel modPanel = new VerticalPanel();
	
	final CheckBox testModeCheckBox = new CheckBox();
	final VerticalPanel testModePanel = new VerticalPanel();
	
	final TextBox emailTextBox = new TextBox();
	final HorizontalPanel emailPanel = new HorizontalPanel();
	final HTML invalidEmailHTML = new HTML("<span class=\"MessageDIVClass\">Return email address is invalid!</span>");

	final CheckBox showCriticalLevelCheckBox = new CheckBox();
	final VerticalPanel otherPanel = new VerticalPanel();

	public void onModuleLoad() {

		RootPanel rootPanel = RootPanel.get("gwtRoot");
		rootPanel.setWidth("760px");

		VerticalPanel vp = new VerticalPanel();
		vp.add(new HTML("<h1>Setup System Parameters</h1>"));
		switchAccessOnoffHTML.setWidth("282px");
		vp.add(switchAccessOnoffHTML);

		HorizontalPanel switchAccessPanel = new HorizontalPanel();
		switchAccessPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		switchAccessPanel.setWidth("700px");
		switchAccessPanel.add(locationLabel);

		locationTextLabel.setWidth("151px");		
		locationTextLabel.setText("");
		locationTextLabel.addStyleName("settings-read-only");
		
		locationTextBox.setText("");
		locationTextBox.setReadOnly(true);
		locationTextBox.setStyleName("SettingsLocationTextBox");
		locationTextBox.setWidth("300px");
//		locationTextBox.addStyleName("SettingsLocationTextBox");
//		locationTextBox.setStylePrimaryName("SettingsLocationTextBox");
		
//		switchAccessPanel.add(locationTextLabel);
		switchAccessPanel.add(locationTextBox);
		switchAccessPanel.add(accessLabel);
		switchAccessPanel.add(accessListBox);
		switchAccessPanel.setCellVerticalAlignment(locationLabel, HasVerticalAlignment.ALIGN_MIDDLE);
		switchAccessPanel.setCellVerticalAlignment(accessLabel, HasVerticalAlignment.ALIGN_MIDDLE);
		switchAccessPanel.setCellVerticalAlignment(locationTextBox, HasVerticalAlignment.ALIGN_MIDDLE);
		switchAccessPanel.setCellVerticalAlignment(accessListBox, HasVerticalAlignment.ALIGN_MIDDLE);

		vp.add(switchAccessPanel);

		final Label usingThisControlLabel = new HTML(
				"<p class='StandardWidth'>Using this control, an Institution Administrator or Local Administrator can specify who may access this planning tool, at any location under his/her control. One use of this is to \"turn off\" access to end-users (\"Local Users\") while customization is being done to the application</p>");
		vp.add(usingThisControlLabel);
		
		// --- test mode
		vp.add(testModePanel);
		testModePanel.add(new HTML("<hr style='margin-top:10px;'/>"));
		testModePanel.add(new HTML("<h3>Testing mode:</h3>"));
		testModePanel.add(testModeCheckBox);
		testModeCheckBox.setHTML("<span class=\"gwt-HTML-location\">&nbsp;&nbsp;Check here to place the system in Testing Mode.  Testing Mode temporarily disables the automated email messages that are generated when you add a person's name onto the Add/Remove User screen, or when you approve/deny a password request on the Moderator's Approval screen.   Do this when testing, troubleshooting, setting up plans, etc. to avoid sending unwanted emails.   Uncheck to turn back on.</span>");
		FlexTable testModeTable = new FlexTable();
		testModeTable.setWidth("700px");
		testModeTable.getFlexCellFormatter().setColSpan(0, 0, 2);
		testModeTable.setHTML(0, 0, "<span class=\"gwt-HTML-location\">&nbsp;</span>");
		testModeTable.getFlexCellFormatter().setColSpan(1, 0, 2);
		testModeTable.setHTML(1, 0, "<span class=\"gwt-HTML-location\">Please note:</span>");
		testModeTable.setHTML(2, 0, "<span class=\"gwt-HTML-location\">(1)&nbsp;</span>");
		testModeTable.setHTML(2, 1, "<span class=\"gwt-HTML-location\">Testing Mode disables only the emails that would be generated by YOU.  Testing Mode has no impact on other users:  they will continue to experience normal system behavior.</span>");
		testModeTable.setHTML(3, 0, "<span class=\"gwt-HTML-location\">(2)&nbsp;</span>");
		testModeTable.setHTML(3, 1, "<span class=\"gwt-HTML-location\">Testing Mode disables only those emails generated by the Add/Remove User screen and by the Moderator's Approval screen.  Emails generated by the login screens (to create a new account, or replace a forgotten password) will continue to be generated as normal.</span>");
		testModeTable.setHTML(4, 0, "<span class=\"gwt-HTML-location\">(3)&nbsp;</span>");
		testModeTable.setHTML(4, 1, "<span class=\"gwt-HTML-location\">Emails are never generated by the Manage User Accounts screen, so that screen is not of concern.</span>");
		testModePanel.add(testModeTable);

		// -- email
		VerticalPanel emailVPanel = new VerticalPanel();
		vp.add(emailVPanel);
		emailVPanel.add(new HTML("<hr style='margin-top:10px;'/>"));
		emailVPanel.add(new HTML("<h3>Return Address for System-Generated Emails:</h3>"));
		emailVPanel.add(new HTML("<p class=\"StandardWidth\">Under certain circumstances, this tool will generate &amp; send emails to users (details are given in the Administrator's Manual).</p>"
						+ "<p class=\"StandardWidth\">Please choose here the <span style='font-weight:bold;'>return address</span> that will be displayed on these emails.</p>"
						+ "<ul class=\"bulletlist\">"
						+ "<li>You might  use the email address of one of  your Local Administrators</li>"
						+ "<li>You might use  the address of  a departmental email account, if you have one; or</li>"
						+ "<li>You might create a special email account for this purpose.</li>"
						+ "</ul><p>"
						+ "<p class=\"StandardWidth\">Keep in mind that  recipients are often reluctant  to open emails that have odd-looking  return addresses.</p>"
						+ "<p class=\"StandardWidth\">You may change this return address at any time in future by simply entering a new address here.</p>"));
		emailVPanel.add(emailPanel);
		emailPanel.setWidth("700px");
		HTML emailLabel = new HTML("<span style='font-weight:bold;'>Return address for system-generated emails:</span>");
		emailTextBox.setStyleName("SettingDomainTextBox");
		emailTextBox.setWidth("300px");
		emailPanel.add(emailLabel);
		emailPanel.add(emailTextBox);

		// -- screen options
		vp.add(new HTML("<hr style='margin-top:10px;'/>"));
		vp.add(screenOptionsHTML);
		vp.add(showTeamsCheckBox);
		showTeamsCheckBox.setText("Show Teams");
		showTeamsCheckBox.addStyleName("optional-screen-list");
		vp.add(showSkillsCheckBox);
		showSkillsCheckBox.setText("Show Skills");
		showSkillsCheckBox.addStyleName("optional-screen-list");
		vp.add(showStaffingBox);
		showStaffingBox.setText("Show Staffing Requirements");
		showStaffingBox.addStyleName("optional-screen-list");
		vp.add(showExamplesOfCheckBox);
		showExamplesOfCheckBox.setWidth("240px");
		showExamplesOfCheckBox.setText("Show Examples of Critical Functions");
		showExamplesOfCheckBox.addStyleName("optional-screen-list");
		vp.add(replaceStep4);
		replaceStep4.setSize("455px", "22px");
		replaceStep4
				.setText("Replace Step 4: Instruction with Step 4: Faculty Preparedness");
		replaceStep4.addStyleName("optional-screen-list");

		final HTML theseSettingsControlLabel = new HTML(
				"<p class=\"StandardWidth\">These settings control the display or non-display of certain screens. When checked, the screen in question will appear for ALL users at a location. When un-checked, the screen will be hidden from ALL users at that location.</p>"
						+ "<p class=\"StandardWidth\">These settings apply to one location (campus) only. In a multi-campus institution, the settings would have to be done separately for each campus - they cannot be done for the whole institution.</p>"
						+ "<p class=\"StandardWidth\">These settings do not affect the data in the database. Hence when you switch a screen off, any data displayed on that screen remains in the database and will re-appear if you switch the screen on again at some future time.</p>");
		vp.add(theseSettingsControlLabel);
		theseSettingsControlLabel.setSize("709px", "107px");

		// --- select other optional features
		vp.add(otherPanel);
		otherPanel.add(new HTML("<hr style='margin-top:10px;'/>"));
		otherPanel.add(new HTML("<h3>Select Other Optional Features:</h3>"));
		otherPanel.add(showCriticalLevelCheckBox);
		showCriticalLevelCheckBox.setHTML("&nbsp;&nbsp;<span style='font-weight:bold;'>Detail Screens:</span>  In Step 2 Critical Functions, display the detail screens for ALL functions, " 
			+ "regardless of criticality level.  If unchecked, the detail screens will be displayed for functions whose criticality level is one of " 
			+ "the top three levels, but will NOT be displayed for functions assigned  the fourth (lowest) level of criticality.");

		// --- select the rule for issuing passwords
		vp.add(modPanel);
		modPanel.setVisible(false);
		modPanel.add(new HTML("<hr style='margin-top:10px;'/>"));

		modPanel.add(new HTML("<h3>Select the Rule for Issuing Passwords:</h3>"));
		modPanel
				.add(new HTML(
						"<p class='StandardWidth'>This selection applies only when the location (campus) is configured for Direct Login (i.e., when Ariah Continuity issues passwords to users via email). </p>"));

		modPanel.add(radioFull);
		radioFull
				.setText("Full Moderation (every password request is submitted to the Moderator for approval before a password is issued)");
		radioFull.addStyleName("password-rules-list");
		radioFull.setChecked(true);
		modPanel.add(radioPartial);
		radioPartial
				.setText("Partial Moderation (issue passwords to users from the following email domains, submit other requests to Moderator):");
		radioPartial.addStyleName("password-rules-list");

		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		vp.add(csrfToken);
		
		rootPanel.add(vp);

		// rootPanel.setStyleName("delText");

		// Buttons
		backButton.setStyleName("BackButtonClass");
		saveSettingsButton.setStyleName("SaveButtonClass");
		// SimplePanel rootPanel = new SimplePanel();

		itemService = (SimpleServiceAsync) GWT.create(SimpleService.class);

		backButton.setStyleName("BackButtonClass");

		backButton.setText("Back");
		backButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				redirect("/continuity/admin/adminHome");
			}
		});

		saveSettingsButton.setStyleName("SaveButtonClass");
		saveSettingsButton.setText("Save Settings");

		saveSettingsButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				invalidEmailHTML.setVisible(false);
				String retEmailAddr = emailTextBox.getText();
				if (retEmailAddr != null &&
					retEmailAddr.trim().length() != 0 &&
				   !retEmailAddr.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
					invalidEmailHTML.setVisible(true);
					return;
				}

				domainList = new ArrayList();
				for (Iterator i = tableRoot.iterator(); i.hasNext();) {

					HorizontalPanel hp = (HorizontalPanel) i.next();
					Label dl = (Label) hp.getWidget(0);
					// Window.alert("Adding "+(String) dl.getText() );
					domainList.add((String) dl.getText());

				}
				boolean ok = true;
				
				
//				if (domainList.size() > 0 && radioFull.isChecked()) {
//
//					radioPartial.setChecked(false);
//					radioFull.setChecked(true);
//					ok = true;
//				}
				if (domainList.size() == 0 && radioPartial.isChecked()) {
					ok = false;
					boolean uncheck = Window
							.confirm("You have selected partial moderation with no email domains. Do you wish to use full moderation instead?");

					if (!uncheck) {
						Window
								.alert("Please enter email domains for partial moderation, or select full moderation.");
					} else {
						radioPartial.setChecked(false);
						radioFull.setChecked(true);
						ok = true;
					}
				}
				if (ok)
					ok = Window.confirm("Update  System Parameters: "
							+ "are you sure?");
				if (ok) {
					SettingItem item = new SettingItem();
					item.setAccess(new Integer(accessListBox
							.getValue(accessListBox.getSelectedIndex())));
					Boolean[] opts = { false, false, false, false, false, false };
					opts[SettingItem.optionType.Teams.ordinal()] = showTeamsCheckBox
							.isChecked();
					opts[SettingItem.optionType.Skills.ordinal()] = showSkillsCheckBox
							.isChecked();
					opts[SettingItem.optionType.Staffing.ordinal()] = showStaffingBox
							.isChecked();
					opts[SettingItem.optionType.Functions.ordinal()] = showExamplesOfCheckBox
							.isChecked();
					opts[SettingItem.optionType.Replace.ordinal()] = !replaceStep4
							.isChecked();
					opts[SettingItem.optionType.CriticalityLevel.ordinal()] = showCriticalLevelCheckBox
							.isChecked();

					item.setOptions(opts);
					// ArrayList<String> domainList = new ArrayList();
					
					// admin email disabled
					item.setInTestMode(testModeCheckBox.isChecked());
					
					if (radioFull.isChecked()){
						item.setFullModeration("1");
					} else if(radioPartial.isChecked()){
						item.setFullModeration("2");
					}
					
					item.setSystemName(systemNameTextBox.getText());
					item.setEmail(emailTextBox.getText());
					item.setCsrfToken(csrfToken.getValue());
					
					String str[] = new String[domainList.size()];
					domainList.toArray(str);
					item.setDomainList(str);
					String[] str2 = item.getDomainList();
					// String slist="";
					// for (String s: str) {
					// slist+=s+" ";
					// }
					// Window.alert("Saving: "+slist);
					itemService.updateItem("setting", item, updateItemCallback);

				}

			}
		});

		final HorizontalPanel buttonPanel = new HorizontalPanel();

		buttonPanel.add(backButton);
		buttonPanel.add(saveSettingsButton);

		final HorizontalPanel domainPanel = new HorizontalPanel();
		modPanel.add(domainPanel);

//		vp.add(domainPanel);
		final Label allowThisDomainLabel = new Label(
				"Allow this domain (e.g. tufts.edu, tuftsfund.org):");
		domainPanel.add(allowThisDomainLabel);
		allowThisDomainLabel.setWidth("284px");
		allowThisDomainLabel.addStyleName("SettingAllowThisDomainLabel");

		domainPanel.add(domainTextBox);
		domainTextBox.setSize("255px", "20px");
		domainTextBox.setStyleName("SettingDomainTextBox");

		final Button addButton = new Button();

		domainPanel.add(addButton);
		addButton.setSize("103px", "22px");
		addButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				// Label listItem = new Label();
				// listItem.setText(domainTextBox.getText());
				// domainList.add(listItem);

				addDomain();

			}
		});
		addButton.setStyleName("ButtonClass");
		addButton.setText("Add to List");

		// Setup test code: delete
		final Label domain1 = new Label("l1");
		// rootPanel.add(domain1, 345, 460);
		domain1.setSize("255px", "15px");

		final Label del1 = new Label("delete");
		// rootPanel.add(del1, 620, 460);
		//del1.setStylePrimaryName("gwt-Labeld");
		del1.setStyleName("SettingDomainDeleteLink");
		del1.setSize("47px", "15px");

		formLoad();
		tableRoot = new VerticalPanel();
		tableRoot.addStyleName("domain_list");
		//tableRoot.addStyleName("partial-moderation-margin");
		
		HTML allowedDomainLab = new HTML("<p><strong>Allowed Domains:</strong></p>");
		allowedDomainLab.addStyleName("SettingAllowDomainLabel");
		modPanel.add(allowedDomainLab);

		modPanel.add(tableRoot);
		tableRoot.setWidth("300px");

		vp.add(new HTML("<hr style='margin-top:10px;'/>"));
		vp.add(new HTML("<h3>Create a Name for this Planning Tool:</h3>"));
		vp.add(new HTML("<p class='StandardWidth'>Please enter here a name for your local version of the Ariah Continuity tool.  This name will appear in the system-generated emails that notify users about new accounts, passwords, etc.   Some possible examples:  Indiana Ready, UBC Ready, Penn State Continuity Planner.  For consistency, please use the same name as will appear in your custom graphics at the top of every page.</p>"));
		systemNameTextBox.setSize("644px", "20px");
		
		systemNameTextBox.setMaxLength(1000);
		systemNameTextBox.setStyleName("SettingDomainTextBox");
		vp.add(systemNameTextBox);

		vp.add(new HTML("<hr style='margin-top:10px;'/>"));
		
		invalidEmailHTML.setVisible(false);
		vp.add(invalidEmailHTML);
		vp.add(buttonPanel);

	};

	int domainPanelXBase = 80;
	int domainPanelYBase = 500;
	int domainPanelYadd = 25;

	boolean validDomain(String domainString) {
		boolean ret = true;
		if (domainString.length() == 0) {
			ret = false;
		} else if (domainString.indexOf(".") <= 0) {
			ret = false;
		} else {
			String pstring = "[a-zA-Z_0-9|\\.]*";
			ret = domainString.matches(pstring);
		}
		return ret;
	}

	public void addDomain() {

		// Window.alert(""+domIdx);

		String newString = domainTextBox.getText();
		if (validDomain(newString)) {
			addDomain(newString);
		} else {
			Window.alert("The Domain is not valid, should be similar to tufts.edu, gmail.com");
		}

	}

	public void addDomain(String newString) {
		boolean oktogo = true;
		if (null != domainMap.get(newString)) {
			oktogo = false;
			Window.alert("Item " + newString + "  already entered.");
		}
		if (oktogo) {

			//radioPartial.setChecked(true);
			int domIdx = domainList.size();
			Label domainItem = new Label(newString);
			domainItem.setStylePrimaryName("SettingDomainItemLabel");
			HorizontalPanel newItem = new HorizontalPanel();
			// newItem.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
			domainItem.setWidth("50px");
			newItem.add(domainItem);

			newItem.setHeight("" + domainPanelYadd + "px");

			IndexedLabel delbutton = new IndexedLabel();
			delbutton.setText("delete");
			delbutton.setStylePrimaryName("delete_domain_button");
			delbutton.index = domIdx;
			delbutton.thatItem = newItem;
			delbutton.addClickListener(new ClickListener() {
				public void onClick(final Widget sender) {

					int xloc = ((IndexedLabel) sender).index;
					// Window.alert("Delete pressed at: "+xloc);
					String dk = ((IndexedLabel) sender).itemName;
					domainMap.remove(dk);
					tableRoot.remove(((IndexedLabel) sender).thatItem);
					domainList.remove(xloc);

					reCountList();
				}
			});
			delbutton.setSize("47px", "15px");

			newItem.add(delbutton);
			domainMap.put(newString, "x");
			domainList.add(newItem);
			tableRoot.add(newItem);
			domainTextBox.setText("");
			if (!radioPartial.isChecked()){
				radioFull.setChecked(false);
				radioPartial.setChecked(true);
			}
		}

	}

	class IndexedLabel extends Label {
		public int index = 0;
		public String itemName = null;
		public HorizontalPanel thatItem = null;

	}

	public void reCountList() {
		for (int i = 0; i < domainList.size(); i++) {
			HorizontalPanel h = (HorizontalPanel) domainList.get(i);
			Widget w = null;
			for (Iterator j = h.iterator(); j.hasNext();) {
				w = (Widget) j.next();
			}
			IndexedLabel il = (IndexedLabel) w;
			if (w != null) {
				il.index = i;
			}
		}

	}

	public void displayItem(int i) {
		int domIdx = i;

		HorizontalPanel newItem = new HorizontalPanel();
		Label domainItem = new Label(domainList.get(i).toString());
		domainItem.addStyleName("SettingDomainItemLabel");
		domainItem.setWidth("50px");
		newItem.add(domainItem);
		newItem.setHeight("" + domainPanelYadd + "px");

		IndexedLabel delbutton = new IndexedLabel();
		delbutton.setText("delete");
		delbutton.index = domIdx;
		delbutton.thatItem = newItem;
		delbutton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				int xloc = ((IndexedLabel) sender).index;
				// Window.alert("Delete pressed at: "+xloc);
				tableRoot.remove(((IndexedLabel) sender).thatItem);
				domainList.remove(xloc);
				reCountList();
			}
		});
		delbutton.setStylePrimaryName("gwt-Labeld");
		delbutton.setSize("47px", "15px");

		newItem.add(delbutton);
		domainList.add(newItem);
		tableRoot.add(newItem);

	}

	public void formLoad() {
		itemService.getItem("setting", 0, selectItemCallback);

	}

	public AsyncCallback updateItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			flashDone();
			redirect("/continuity/admin/setting");
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
	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			SettingItem si = (SettingItem) result;

			if (!si.isShibMode()) {
				modPanel.setVisible(true);
			}

//			locationTextLabel.setText(si.getLocation());
			locationTextBox.setText(si.getLocation());
			
			// sublocationTextBox.setText(si.getSublocation());

			// Populating the Access List Drop Down
			switch (Integer.parseInt(si.getLoggedUserAccessLevel())) {
			case 0: // System Admin
				accessListBox.addItem("System Admins Only", "0");
			case 3: // Institutional Admin
				accessListBox.addItem("System and Institutional Admins Only",
						"3");
			case 1:// Local Admin
				accessListBox.addItem("Admins Only", "1");
			default:
				accessListBox.addItem("All Users", "2");
			}

			// Populating the Access List Map
			switch (Integer.parseInt(si.getLoggedUserAccessLevel())) {
			case 0: // System Admin
				systemAccessIndex = new HashMap<String, String>();
				systemAccessIndex.put("0", "0"); // For System Admins
				systemAccessIndex.put("3", "1"); // For System and Insitutional
				// Admins
				systemAccessIndex.put("1", "2"); // For Admins
				systemAccessIndex.put("2", "3"); // For All Users

				break;
			case 3: // Institutional Admin
				systemAccessIndex = new HashMap<String, String>();
				systemAccessIndex.put("3", "0"); // For System and Insitutional
				// Admins
				systemAccessIndex.put("1", "1"); // For Admins
				systemAccessIndex.put("2", "2"); // For All Users
				break;
			case 1:// Local Admin
				systemAccessIndex = new HashMap<String, String>();
				systemAccessIndex.put("1", "0"); // For Admins
				systemAccessIndex.put("2", "1"); // For All Users
				break;
			default:
			}

			// Window.alert(si.getLoggedUserAccessLevel());
			accessListBox.setVisibleItemCount(1);
			accessListBox.setItemSelected(Integer
					.parseInt(((String) systemAccessIndex.get(si.getAccess()
							.toString()))), true);

			// accessListBox.get
			Boolean[] opts = si.getOptions();
			showTeamsCheckBox.setChecked(opts[SettingItem.optionType.Teams
					.ordinal()]);
			showSkillsCheckBox.setChecked(opts[SettingItem.optionType.Skills
					.ordinal()]);
			showStaffingBox.setChecked(opts[SettingItem.optionType.Staffing
					.ordinal()]);
			showExamplesOfCheckBox
					.setChecked(opts[SettingItem.optionType.Functions.ordinal()]);
			replaceStep4.setChecked(!opts[SettingItem.optionType.Replace
					.ordinal()]);
			showCriticalLevelCheckBox.setChecked(opts[SettingItem.optionType.CriticalityLevel
			         					.ordinal()]);
			
			// admin email disabled
			testModeCheckBox.setChecked(si.isInTestMode());
			
			
			// Add in email Domain list
			for (String s : si.getDomainList()) {
				addDomain(s);
			}
								
			if(si.getFullModeration().equals("2")){				
				radioFull.setChecked(false);
				radioPartial.setChecked(true);
			} else{			
				radioFull.setChecked(true);
				radioPartial.setChecked(false);
			}
			
			systemNameTextBox.setText(si.getSystemName());
			emailTextBox.setText(si.getEmail());
			
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

}
