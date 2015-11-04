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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class MajorDivision extends SimpleGridViewerS {
	int[] gcsize = { 100, 40, 120, 80, 50, 0 };
RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("id"), new StringFieldDef("name"),
			 new IntegerFieldDef("order")  });
	
	public void onModuleLoad()  {
		// Get parameters from HTML
		Element screenelement= DOM.getElementById("itemdata");
		Element pluralelement=DOM.getElementById("plural");
		Element formelement = DOM.getElementById("formelement");
		Element columnelement = DOM.getElementById("columnelement");
		String formItemName=formelement.getTitle();
		String plural=pluralelement.getTitle();
		String pageInfo=screenelement.getTitle();
		String columnTitle=columnelement.getTitle();
		
		
		// Set Columns.
		 ColumnConfig divisionCol = new ColumnConfig(columnTitle, "name",
				gcsize[0], true);
		ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { divisionCol  });
		
		// Set backend.
		this.formController=sf;
		
		// Set up form.
		formItemName= this.setElementNames(columnModel, recordDef);
		
        // MajorDivision.java also handles Instructional Departments which is also 50.
		// MajorDivision requires a form label of "Major Division" which is wider than "Name."
		
		textBox.setMaxLength(50);  
		HTML formItemHTML = null;
		/* There is probably a way to measure the HTML once created and subtract from the form
		 * width.  However, according to experiments with FireBug, we would still
		 * need the non-breaking space in the label to represent it on one line.
		 */
		if (pageInfo.equals("Division")) {
			formItemHTML = new HTML("Major&nbsp;Division");  // Setup to prevent splitting
			textBox.setWidth("550px");
		} else {
			textBox.setWidth("600px");
			formItemHTML = new HTML(formItemName);

		}
		flexForm.addIdentifiedItem(formItemHTML,textBox);
		itemRootName=pageInfo.toLowerCase();  // Backend Item 
		this.formController=sf;
		
		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		flexForm.registerWidget(csrfToken);
	}
    SimpleFormController sf = new SimpleFormController() {
    	@Override
    	public boolean formLoad(Object result) {
    		boolean ret=true;
    		NamedItem item = (NamedItem) result;
    		
    		textBox.setText(item.getName());
    	 
    		return ret;
    	}

		@Override
    	public NamedItem validateSave(NamedItem  item) {
    		NamedItem it = new NamedItem();
    		
    		it.setName(textBox.getText());
    		it.setCsrfToken(csrfToken.getValue());
    		
    		return it;
    	}
    	
    };

}
