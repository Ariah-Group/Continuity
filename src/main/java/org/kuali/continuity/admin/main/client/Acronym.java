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

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;



public class Acronym extends SimpleGridViewerS {

	
	final TextBox acronym = new TextBox();
	final TextBox fullName = new TextBox();

	final ListBox access = new ListBox();

	int[] gcsize = { 50, 160, 50, 50, 0, 0 };
	public ColumnConfig acronymCol = new ColumnConfig("Acronym", "name",
			gcsize[0], true);
	
	public ColumnConfig fullNameCol = new ColumnConfig("Full Name", "fullName",
					gcsize[1], true);

	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { acronymCol, fullNameCol });
	RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("id"),
			new StringFieldDef("name"), new StringFieldDef("fullName"), new StringFieldDef("order") });
	
	public void onModuleLoad()  {
		// Grid
		String proxyUrl="./items.lst";
   
        this.formController=sf;  
		String formItemName= this.setElementNames( columnModel, recordDef);

		// Form
	    textBox.setMaxLength(25);
	    textBox.setWidth("100px");
		flexForm.addFormItem(formItemName,textBox);
		fullName.setMaxLength(60);
		fullName.setWidth("400px");
		HTML fullLabel= new HTML("Full&nbsp;Name");
	    flexForm.addIdentifiedItem(fullLabel, fullName);
	    itemRootName="acronym";
		
	 // set token
	    String token = Cookies.getCookie(CSRF_TOKEN);
	    csrfToken.setValue(token);
	    flexForm.registerWidget(csrfToken);
	}

	SimpleFormController sf = new SimpleFormController() {
    	@Override
    	public boolean formLoad(Object result) {
    		boolean ret=true;
    		AcronymItem item= (AcronymItem) result;
    		currentId=item.getId();
    		textBox.setText(item.getName());
    		fullName.setText(item.getFullName());
    		return ret;
    	}
		@Override
    	public NamedItem validateSave(NamedItem  item) {
			AcronymItem it = new AcronymItem();
    		it.setName(textBox.getText());
    	    it.setFullName(fullName.getText());
    	    it.setCsrfToken(csrfToken.getValue());
    		return (NamedItem )it;
    	}
    	
    };
}
