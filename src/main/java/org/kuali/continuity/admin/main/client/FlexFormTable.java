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

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class FlexFormTable  extends FlexibleForm {
	 FlexTable thisft = new FlexTable();
	 
	 FlexFormTable() {
		 this.add(thisft);
	 }


	int curht=1;
	int curwid=1;
    public void addFormItem(String label, Widget widget) {
    	 thisft.setHTML(curht, curwid*2-1, label);
    	 thisft.setWidget(curht, curwid*2, widget);
    	 curwid=curwid+2;
    	 
    	
    }
	public  void addIdentifiedItem(Widget label, Widget widget) {
		
	}


	public void setRowWidth(String rowWidth) {
		
	}
 
	public void addRequiredFormItem(String label, Widget widget) {
        String newlabel="<span class=required>*&nbsp;</span>"+label;
	   	 thisft.setHTML(curht, curwid*2-1,newlabel);
    	 thisft.setWidget(curht, curwid*2, widget);
    	 curwid=curwid+2;
		
	}
	
	@Override
	public void addLabeledItem(Label label, Widget widget) {
		 thisft.setWidget(curht, curwid*2-1, label);
    	 thisft.setWidget(curht, curwid*2, widget);
    	 curwid=curwid+2;
		
	}

	@Override
	public void addUnlabeledItem(Widget widget) {
	  	 thisft.setWidget(curht, curwid+1, widget);
    	 curwid=curwid+1;
		
	}
    public void addFormItemVertical(String label, Widget widget) {
    	 if (curwid>1) this.addRow();
    	 thisft.setHTML(curht, 1, label);
    	 this.addRow();
    	 
    	 thisft.setWidget(curht, 1, widget);
    }
    public void addRow() {
    	curht=curht+1;
    	curwid=1;
    }
	@Override
	public void addVerticalItem(String slabel, Widget widget, String wwidth) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addIdentifiedItemVertical(Widget label, Widget widget) {
		// TODO Auto-generated method stub
		
	}



}
