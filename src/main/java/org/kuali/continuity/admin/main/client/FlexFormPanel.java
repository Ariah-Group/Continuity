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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * FlexFormPanel enables setting up of a form where the labels and widgets have varying widths.
 * @author richardkatz
 *
 */
public class FlexFormPanel extends FlexibleForm {
	
	VerticalPanel thisvp = new VerticalPanel();
	HorizontalPanel currentHp = null;
	String currentMargin=" ";
	FlexFormPanel() {
	    this.add(thisvp);
		currentHp= new HorizontalPanel();
		currentHp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		currentHp.setWidth("0");
		thisvp.add(currentHp);
		
	}
	public void setRowWidth(String rowWidth) {
		 currentHp.setWidth(rowWidth);
	}


	public void addRequiredFormItem(String label, Widget widget) {
		currentHp.add(new HTML("<span class='required'>*</span> " + label));
		currentHp.add(widget);
		controls.add(widget);
		
	}

	public void addFormItem(String label, Widget widget) {
		currentHp.add(new HTML(label));
		currentHp.add(widget);
		controls.add(widget);
		
	}

	public void addLabeledItem(Label label, Widget widget) {
		currentHp.add(label);
		currentHp.add(widget);
		controls.add(widget);	
	}
	public void addIdentifiedItem(Widget label, Widget widget) {
		currentHp.add(label);
		currentHp.add(widget);
		controls.add(widget);	
	}
	public void addUnlabeledItem(Widget widget) {
		currentHp.add(  widget);
		controls.add(widget);	
		
	}
	public void addFormItemVertical(String slabel, Widget widget) {
		currentHp.add(new HTML(slabel));
		this.addRow();
		currentHp.add(  widget);
		this.addRow();
		
	}
	public void addIdentifiedItemVertical(Widget slabel, Widget widget) {
		currentHp.add(slabel);
		this.addRow();
		currentHp.add(  widget);
		this.addRow();
		
	}

	public void addRow() {
		currentHp = new HorizontalPanel();
		currentHp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		thisvp.add(currentHp);
		
	}
	@Override
	public void addVerticalItem(String slabel, Widget widget, String wwidth) {

		VerticalPanel vp = new VerticalPanel();
		vp.add(new HTML(slabel));
		vp.add(widget);
		controls.add(widget);
		vp.setWidth(wwidth);
		currentHp.add(vp);
		
	}





}
