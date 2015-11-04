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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;

public class ListControl {
	protected int currow = 0;
	protected int ncols = 5;
	
	protected final String logoutPath = "/kcpt/login/logout";
	
    public void highlight(Grid g, int row) {
		if (row != currow && row>0) {
			
			g.getRowFormatter().addStyleName(row, ".gwt-table-SelectedRow");
			if (currow!=0) {
				g.getRowFormatter().removeStyleName(row, ".gwt-table-SelectedRow");
			}
			currow=row;
		}
		
	}
	public native void redirect(String url) /*-{


	$wnd.open(url,"mainwindow");

 }-*/;

    // Error display management
	final Image redball = new Image("redlight2.gif");
	final HTML errortext = new HTML(
			"<span class=\"MessageDIVClass\">Action not complete:</span>");
	final ListBox errlist = new ListBox();
	// Error display management.
	void showErr(boolean show) {
		redball.setVisible(show);
		errortext.setVisible(show);
		errlist.setVisible(show);
		if (!show) 
		errlist.clear();

	}

	void setError(String message) {
		errlist.addItem(message);
		redball.setVisible(true);
		errortext.setVisible(true);
		errlist.setVisible(true);
	}
	
	public void onModuleSetup() {
		
		showErr(false);
		errortext.setStylePrimaryName("MessageDIVClass");
		errortext.setStyleName("MessageDIVClass");
		redball.setVisible(false);
		
	}
	
	public void rootPanelLoadErrorSetup(RootPanel rootPanel, int left, int top) {
		redball.setVisible(false);
		redball.setSize("20", "20");
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(redball);
		hp.add(errortext);
		hp.add(errlist);
		rootPanel.add(hp);
		errlist.setWidth("370px");
		
	}
	
	protected String getLogoutUrlWithParm(String errorCode){
		return Window.Location.getProtocol() + "//" + Window.Location.getHost() + logoutPath + "?error=" + errorCode;
	}

}

