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
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.HTML;

import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * FlexibleForm defines a mechanism for setting up forms consisting of labels and fields.
 * There are two implementations.  FlexFormPanel and FlexFormTable.  Both provide an anciliary method for setting up a vertically arranged field.
 * @author richardkatz
 *
 */
public abstract class FlexibleForm extends VerticalPanel {
    public List<Widget> controls = new ArrayList();
	public abstract void addFormItem(String label, Widget widget) ;
	public abstract void addRequiredFormItem(String label, Widget widget) ;
	public abstract void addLabeledItem(Label label, Widget widget);
	public abstract void addIdentifiedItem(Widget label, Widget widget);
	public abstract void addUnlabeledItem(Widget widget);
	public  abstract void addRow() ;
	public abstract void setRowWidth(String rowWidth);
	public abstract void addFormItemVertical(String label, Widget widget);
	public abstract void addIdentifiedItemVertical(Widget label, Widget widget);
	
	public abstract void addVerticalItem(String slabel, Widget widget, String wwidth);
	public void clear() { 
		for (Widget c:controls) {
			// Covarient  does not function.
			if (c instanceof TextBox) {
				 clear((TextBox) c);
			} else if (c instanceof ListBox) {
				clear((ListBox) c);
			} else {
				if (c instanceof RichTextArea) {
					clear((RichTextArea) c);
				}
			}
		}
	}
    public void registerWidget(Widget w) {
    	controls.add(w);
    }
	public void clear(TextBox t) {
		t.setText("");
		
	}
	public void clear(ListBox l) {
		l.setSelectedIndex(0);
	}
	public void clear(RichTextArea c) {
	     
		 c.setHTML("");
		 c.setText("");
	}
	
}
