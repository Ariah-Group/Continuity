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
import com.google.gwt.user.client.ui.Label;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;


public class Building extends SimpleGridViewerS {
	
	// final TextBox buildingName = new TextBox();
	int[] gcsize = { 100, 90, 100, 60,  0 };
	public ColumnConfig commonnameCol = new ColumnConfig("Common Name", "commonName",
			gcsize[0], true);
	public ColumnConfig caannoCol = new ColumnConfig("Identifier", "caan",
			gcsize[1], true);	
	public ColumnConfig caannameCol = new ColumnConfig("Official Name", "name",
					gcsize[2], true);
	public ColumnConfig ownershipCol = new ColumnConfig("Ownership", "owner",
			gcsize[3], true);
	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { commonnameCol, caannoCol, caannameCol, ownershipCol });

	RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("id"), new StringFieldDef("name"),
			new StringFieldDef("caan"), new StringFieldDef("commonName"), new StringFieldDef("owner"), new StringFieldDef("address"), new StringFieldDef("order")  });
    public FormController getFormController() {
    	return sf;
    }
	public void onModuleLoad()  {
		
		this.formController=sf;	
		String formItemName= this.setElementNames(columnModel, recordDef );
		this.formController=sf;
		
		// Form
		textBox.setWidth("344px");
		textBox.setMaxLength(50);
		flexForm.addFormItem("Common&nbsp;Name",textBox);
		ownership.setVisibleItemCount(1);
		ownership.addItem("Owned","1");
		ownership.addItem("Not Owned","0");
		ownership.addItem("Special Status","2");
	    flexForm.addFormItem("Ownership", ownership);
	    
	    flexForm.addRow();
	    caanname.setWidth("344px");
	    caanname.setMaxLength(50);
	    HTML offName=new HTML("Official&nbsp;Name");
	    flexForm.addIdentifiedItem(offName, caanname);
	    caanno.setWidth("134px");
	    caanno.setMaxLength(5);
	    flexForm.addFormItem("Identifier", caanno);
	    
	    formPanel.add(new Label("Address"));
	    address.setWidth(screenWidth);
	    address.setHeight("40px");
	    formPanel.add(address);

	    flexForm.addRow();
	    itemRootName="building";
	    //formGrid.addFormItem("Order", orderBox);
	    this.formController=sf;
	   
	 // set token
	    String token = Cookies.getCookie(CSRF_TOKEN);
	    csrfToken.setValue(token);
	    flexForm.registerWidget(csrfToken);
		
	}
    SimpleFormController sf = new SimpleFormController() {
    	public boolean formLoad(Object result) {
    		
    		BuildingItem bi= (BuildingItem) result;
    		boolean ret=true;
    		currentId=bi.getId();
    		textBox.setText(bi.getCommonName());
    		caanno.setText(bi.getCaan());
    		caanname.setText(bi.getName());
    		ownership.setItemSelected(bi.getOwnerIndex(), true);
    		address.setText(bi.getAddress());		
    		
    		return ret;
    	}
    	public NamedItem validateSave(NamedItem  item) {
    	
    		BuildingItem bi = new BuildingItem();
    		bi.setName(caanname.getText()); 
    		
    		bi.setCommonName(textBox.getText());  // caan to common common to caen
    		bi.setCaan(caanno.getText());
    		bi.setAddress(address.getText());
    		bi.setOwner(""+ownership.getValue(ownership.getSelectedIndex()));
    		bi.setOwnerIndex(Integer.parseInt(ownership.getValue(ownership.getSelectedIndex())));
    		bi.setCsrfToken(csrfToken.getValue());
    		
    		return  bi;
    	}
    };
    
    protected void clearThisForm() {
    	address.setText("");
	}
}
