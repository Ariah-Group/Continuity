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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Function extends ListControl implements EntryPoint {
	
	
	final HTML switchAccessOnoffHTML = new HTML("<h3> Set Access On/Off for All Users:</h3>");
	final Label locationLabel = new Label("Location");
	final TextBox locationTextBox = new TextBox();
	final Label sublocationLabel = new Label("Sublocation");
	final TextBox sublocationTextBox = new TextBox();
	final Label accessLabel = new Label("Access");
	final ListBox accessListBox = new ListBox();
	final HTML screenOptionsHTML = new HTML("<H3>Screen Options:  </H3>");
	final CheckBox showTeamsCheckBox = new CheckBox();
	final CheckBox showSkillsCheckBox = new CheckBox();
	final CheckBox showStaffingBox = new CheckBox();
	final CheckBox showExamplesOfCheckBox = new CheckBox();
	final Button backButton = new Button();
	final Button saveSettingsButton = new Button();
	public SimpleServiceAsync itemService = null;
	
	public void onModuleLoad()  {
		RootPanel rootPanel = RootPanel.get("gwtRoot");
		
		// SimplePanel  rootPanel = new SimplePanel();
		rootPanel.setWidth("642");
		// rootPanel_1.add(rootPanel);
		itemService= (SimpleServiceAsync) GWT.create(SimpleService.class);
		
		rootPanel.add(switchAccessOnoffHTML, 20, 67);
		switchAccessOnoffHTML.setWidth("236px");
		rootPanel.add(locationLabel, 20, 125);

		rootPanel.add(locationTextBox, 86, 124);
		locationTextBox.setWidth("151px");
		locationTextBox.setEnabled(false);
		locationTextBox.setText("");

		rootPanel.add(sublocationLabel, 245, 125);

		rootPanel.add(sublocationTextBox, 322, 124);
		sublocationTextBox.setWidth("179px");

		rootPanel.add(accessLabel, 505, 125);

		rootPanel.add(accessListBox, 557, 123);
		accessListBox.addItem("System Admin Only");
		accessListBox.addItem("Admins Only");
		accessListBox.addItem("All Users");
		accessListBox.setSelectedIndex(2);
		accessListBox.setVisibleItemCount(1);

		rootPanel.add(screenOptionsHTML, 20, 175);
		rootPanel.add(showTeamsCheckBox, 20, 225);
		showTeamsCheckBox.setText("Show Teams");
		rootPanel.add(showSkillsCheckBox, 120, 225);
		showSkillsCheckBox.setText("Show Skills");
		rootPanel.add(showStaffingBox, 210, 225);
		showStaffingBox.setText("Show Staffing Requirements");
		rootPanel.add(showExamplesOfCheckBox, 415, 225);
		showExamplesOfCheckBox.setWidth("228px");
		showExamplesOfCheckBox.setText("Show Examples of Critical Functions");

		rootPanel.add(backButton, 20, 260);
		backButton.setText("Back");

		rootPanel.add(saveSettingsButton, 441, 260);
		saveSettingsButton.setText("Save Settings");
	    //formGrid.addFormItem("Order", orderBox);
		formLoad();

		
	}	public AsyncCallback selectItemCallback = new AsyncCallback() {
		public void onSuccess(Object result) {
			 SettingItem si = (SettingItem) result;
			 locationTextBox.setText(si.getLocation());
			 sublocationTextBox.setText(si.getSublocation());
			 accessListBox.setItemSelected(si.getAccess(), true);
			 Boolean [] opts = si.getOptions();
			 showTeamsCheckBox.setChecked(opts[SettingItem.optionType.Teams.ordinal()]);
			 showSkillsCheckBox.setChecked(opts[SettingItem.optionType.Skills.ordinal()]);
			 showStaffingBox.setChecked(opts[SettingItem.optionType.Staffing.ordinal()]);
			 showExamplesOfCheckBox.setChecked(opts[SettingItem.optionType.Functions.ordinal()]);
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
    public void formLoad() {
    	 itemService.getItem("setting", 0, selectItemCallback);
    	
    }
    
}
