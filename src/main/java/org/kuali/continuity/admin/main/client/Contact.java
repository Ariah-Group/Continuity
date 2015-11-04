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

import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.form.HtmlEditor;
import com.gwtext.client.widgets.layout.AnchorLayoutData; 
import com.gwtext.client.widgets.form.FormPanel;  
import com.gwtext.client.widgets.Panel;  
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.core.client.EntryPoint;  
 
import com.gwtext.client.core.Position;  
import com.gwtext.client.widgets.Button;  
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.form.FormPanel;  
import com.gwtext.client.widgets.form.HtmlEditor;  
import com.gwtext.client.widgets.form.TextField;  
import com.gwtext.client.widgets.form.VType;  
import com.gwtext.client.widgets.layout.AnchorLayoutData;  
import com.gwtext.client.widgets.layout.ColumnLayout;  
import com.gwtext.client.widgets.layout.ColumnLayoutData;  
import com.gwtext.client.widgets.layout.FormLayout;  
  

public class Contact extends SimpleGridViewer {

	
	// RichTextArea contact = new RichTextArea();
	int textht=75;
	
	public void onModuleLoad()  {
		
		// Buttons
	
		setButtonNames("Contact");
		
		// Heading
		String plural="Contacts";
		setHeadingName(plural+" Setup");
		
		// Grid
		onModuleLoad("Contacts");
        Panel panel = new Panel();  
        panel.setBorder(false);  
        panel.setPaddings(15);  
        
        // Fields: Order
        HorizontalPanel formdata = new HorizontalPanel();
        formdata.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);  
        formdata.add(new Label("Order"));
        formdata.add(orderBox);
  
        formPanel.add(formdata);
        
        // Rich Text Area. 
        FormPanel extFormPanel = new FormPanel();  
        extFormPanel.setFrame(false);  
        extFormPanel.setWidth(642);  
        extFormPanel.setLabelAlign(Position.TOP);  
        extFormPanel.add(gridPanel);
 
        HtmlEditor htmlEditor = new HtmlEditor("Contact", "contact");  
    	htmlEditor.setHeight(textht);
		htmlEditor.setPixelSize(622, textht);
        htmlEditor.setEnableFont(true);
        htmlEditor.setEnableFontSize(true);
       
        extFormPanel.add(htmlEditor, new AnchorLayoutData("98%"));  
  
        //add a couple of buttons to the form  


        formPanel.add(extFormPanel);  
       
        //rootPanel.add(panel);  
    }  

}
