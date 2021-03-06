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

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.RichTextArea;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.HtmlEditor; 
import com.gwtext.client.widgets.layout.AnchorLayoutData;

public class Knowledge extends SimpleGridViewer {
	//RichTextArea item = new RichTextArea();
	//

	int textht=75;
	public void onModuleLoad()  {
		// Grid
		
		itemService= (ItemServiceAsync) GWT.create(ItemService.class);
		Element dataelement = DOM.getElementById("dataelement");
		itemRootName=dataelement.getTitle();

		// Buttons;
		onModuleLoad("Things to Know");
		setButtonNames("Item");
		
		// Heading
		String plural="Things to Know as You Plan";
		setHeadingName(plural+" Setup");

		// Form
        // Rich Text Area. 
        FormPanel extFormPanel = new FormPanel();  
        extFormPanel.setFrame(false);  
        extFormPanel.setWidth(642);  
        extFormPanel.setLabelAlign(Position.TOP);  
        extFormPanel.add(gridPanel);
		 HtmlEditor htmlEditor = new HtmlEditor("Item", "knowledge");  
	    	htmlEditor.setHeight(textht);
			htmlEditor.setPixelSize(622, textht);
	        htmlEditor.setEnableFont(true);
	        htmlEditor.setEnableFontSize(true);
	    extFormPanel.add(htmlEditor, new AnchorLayoutData("98%"));    
	    flexForm.addFormItem("Order", orderBox);
	   
	    formPanel.add(extFormPanel);
		
		gridPanel.setCls(".myclass");
		
	}

}
