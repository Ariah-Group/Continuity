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

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;

public class ListControl {
	
	protected final String logoutPath = "/continuity/login/logout";
	protected final String welcomePath = "/continuity/plan/welcome";
	protected final String KUALI_DIRECTLOGIN_COOKIE_KEY = "KUALI_DIRECTLOGIN_COOKIE_KEY";
	protected final String SHIBBOLETH_LOGIN_IDP_ID = "SHIBBOLETH_LOGIN_IDP_ID";
	protected final String SESSION_EXPIRED_ERROR = "3";
	protected final String CSRF_TOKEN = "adminCsrfToken";
	/**
	 * Redirect to a Web page.
	 * @param url
	 */
	public native void redirect(String url) /*-{
    
    
	$wnd.open(url,"mainwindow");
	
 }-*/;
	
	
	   // Error display management
	final Image redball = new Image("redlight2.gif");
	final Image greenball = new Image("greenlight2.gif");
	final String screenWidth="642px";
	
	final String spanCssStart = "<span class=\"MessageDIVClass\">";
	final String spanCssEnd = "</span>";
	final String errorTextHeader = "Action not complete! ";
	
	final HTML errortext = new HTML(
	"<span class=\"MessageDIVClass\">Action not complete!</span>");
	
	final ListBox errlist = new ListBox();
	final TextArea ta = new TextArea();
	
	String mainerror="";
	// Error display management.
	void showErr(boolean show) {		
		redball.setVisible(show);
		errortext.setVisible(show);	
		errlist.setVisible(show);
		ta.setVisible(false);
		
		if (!show) 
			errlist.clear();
		mainerror="";
	}
	
	void showErrorWithTa(boolean show){
		redball.setVisible(show);
		errortext.setVisible(show);		
		errlist.setVisible(false);
		ta.setVisible(show);
		
		if (!show) 
			errlist.clear();
		mainerror="";
	}
	
	void setErrorTextArea(String message){
		ta.setText(message);
	}
	
	void setError(String message) {
		errlist.addItem(message);
		errortext.setHTML(spanCssStart + errorTextHeader + spanCssEnd);
	}
	void setErrorText(String message){
		errortext.setHTML(spanCssStart + errorTextHeader + message + spanCssEnd);
	}
	
	public void onModuleSetup() {
		
		showErr(false);
		showErrorWithTa(false);
		errortext.setStylePrimaryName("MessageDIVClass");
		errortext.setStyleName("MessageDIVClass");
		
		ta.setStylePrimaryName("ErrorDetailClass");
		ta.setStyleName("ErrorDetailClass");
		
		redball.setVisible(false);
		
	}
	
	public void loadErrorSetup(HorizontalPanel rootPanel, HorizontalPanel rootTextPanel) {
		
		showErr(false);
		showErrorWithTa(false);
		redball.setSize("10", "10");
		rootPanel.add(redball);
		rootPanel.add(errortext);
		rootPanel.add(errlist);	
		errlist.setWidth("370px");
		rootTextPanel.add(ta);	
		ta.setWidth(screenWidth);
		
	}
    void flashDone2() {
    	showDone(true);
    	for (int i=0;i<100000;i++) {
    		int j=i;
    	}
    	showDone(false);
    }
    void flashDone() {
    	showDone(true);
    	Timer t = new Timer() {
    		  public void run() {
    			  showDone(false);
    		  }

    		};

    		// delay running for 2 seconds
    	t.schedule(2000); 
    }
	void showDone(boolean show) {
		
		greenball.setVisible(show);
		errortext.setVisible(show);	
		ta.setVisible(show);	
		
		errlist.setVisible(show);
		if (!show) 
			errlist.clear();

	}
	HorizontalPanel ball = new HorizontalPanel();
	
	public void loadErrorSetup(DockPanel dockPanel, int left, int top) {
		redball.setVisible(false);
		
		ta.setVisibleLines(5);
		ta.setVisible(false);
		
		HorizontalPanel errorRow = new HorizontalPanel();
		dockPanel.add(errorRow);
		redball.setSize("10", "10");
		greenball.setSize("10", "10");
		errorRow.add(ball);
		errorRow.add(errortext);
		errorRow.add(errlist);
		errorRow.add(ta);
		errlist.setWidth("370px");
	}
	
	protected String getLogoutUrlWithParm(String errorCode){
		return Window.Location.getProtocol() + "//" + Window.Location.getHost() + logoutPath + "?error=" + errorCode + "&defaultDirectLoginUrl=/continuity/login/ready&shibbolethLoginWayfUrl=/secure";
	}
	
	protected String getWelcomeUrl(){
		return Window.Location.getProtocol() + "//" + Window.Location.getHost() + welcomePath;
	}
}
