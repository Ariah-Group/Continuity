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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
public class CampusBuilding extends SimpleGridViewer {
	
	final TextBox buildingName = new TextBox();
	final TextBox caanno = new TextBox();
	final TextBox caanname = new TextBox();
	final ListBox ownership = new ListBox();
	final TextArea address = new TextArea();
	int[] gcsize = { 120, 40, 120, 80, 50, 0 };
	public ColumnConfig commonnameCol = new ColumnConfig("Common Name", "name",
			gcsize[0], true);
	public ColumnConfig caannoCol = new ColumnConfig("CAAN No", "caano",
			gcsize[1], true);	
	public ColumnConfig caannameCol = new ColumnConfig("CAAN Name", "caanname",
					gcsize[1], true);
	public ColumnConfig ownershipCol = new ColumnConfig("Ownership", "ownership",
			gcsize[1], true);
	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { commonnameCol, caannoCol, caannameCol, ownershipCol });
	
	public void onModuleLoad()  {

		// onModuleLoad("Local Buildings List", columnModel);
		String name="Building";
		setButtonNames(name);
		String plural="Buidings";
		setHeadingName(plural+" Setup");

		// Form
		flexForm.addFormItem("Common Name",buildingName);
		ownership.setVisibleItemCount(1);
	    flexForm.addFormItem("Ownership", ownership);
	    flexForm.addRow();
	    flexForm.addFormItem("CAAN Name", caanname);
	    flexForm.addFormItem("CAAN No", caanno);
	    
	    formPanel.add(new Label("Address"));
	    formPanel.add(address);

	    flexForm.addRow();

	    //formGrid.addFormItem("Order", orderBox);
		
		gridPanel.setCls(".myclass");
		
	}

}



