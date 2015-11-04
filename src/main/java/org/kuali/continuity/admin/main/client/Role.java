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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Role extends SimpleGridViewerS {
	int[] gcsize = { 100, 100, 80, 20, 50, 0 };
	public ColumnConfig nameCol = new ColumnConfig("Name", "name",
			gcsize[0], true);
	public ColumnConfig emailCol = new ColumnConfig("Email", "email",
			gcsize[1], true);
	
	public ColumnConfig phoneCol = new ColumnConfig("Phone", "phone",
			gcsize[2], true);
	
	public ColumnConfig roleCol = new ColumnConfig("Role", "role",
			gcsize[3], true);
	public ColumnConfig accessCol = new ColumnConfig("Access", "access",
			gcsize[4], true);
	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { nameCol, emailCol, 
			phoneCol, roleCol, accessCol });
	RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("id"), new StringFieldDef("name"),
			new StringFieldDef("email"), new StringFieldDef("phone"), new StringFieldDef("role"), new StringFieldDef("access"), new StringFieldDef("order")  });
	public void onModuleLoad()  {
		this.formController=sf;
		String formItemName= this.setElementNames( columnModel, recordDef);

		// Form 

		Element pluralelement=DOM.getElementById("plural");
		String plural=pluralelement.getTitle();
        
        
		setHeadingName(plural+" Setup");
		textBox.setMaxLength(50);
		textBox.setWidth("500px");
	//	VerticalPanel formPanel= new VerticalPanel();
		this.setFormPanel(formPanel);
	//	AbsolutePanel abs = new AbsolutePanel();
	//	formPanel.add(abs);
	//	abs.setSize("642px", "200px");
		
//		flexForm.addUnlabeledItem(new ListBox());
//		flexForm.addRow();
//		
//	    flexForm.addFormItem(formItemName, textBox);
//	    flexForm.addFormItem("Order", orderBox);
//		final ListBox universityListBox = new ListBox();
//		flexForm.addUnlabeledItem( universityListBox);

		// Search and Trust Section.
		final Label firstSearchLabel = new Label("First Name");
		final TextBox firstSearchTextBox = new TextBox();
		// flexForm.addLabeledItem(firstSearchLabel, firstSearchTextBox);

		final ListBox universityListBox = new ListBox();
		flexForm.addUnlabeledItem( universityListBox);

		// Search and Trust Section.
		// final Label firstSearchLabel = new Label("First Name");
		// final TextBox firstSearchTextBox = new TextBox();
		flexForm.addLabeledItem(firstSearchLabel, firstSearchTextBox);
		
		final Label lastSearchLabel = new Label("Last Name");
		final Image searchButton = new Image("Search2.gif");
		final TextBox lastSearchTextBox = new TextBox();
		flexForm.addLabeledItem(lastSearchLabel, lastSearchTextBox);
		flexForm.addRow();

		// Not visible: User Key Info.
		final TextBox idTextBox = new TextBox();

		// Main Form
		final Image formImage = new Image("spacer.gif");
		flexForm.addRow();
		final Label firstNameLabel = new Label("First Name");
		final TextBox firstNameTextBox = new TextBox();
		flexForm.addLabeledItem(firstNameLabel,firstNameTextBox);

		final Label lastNameLabel = new Label("Last Name");
		final TextBox lastNameTextBox = new TextBox();
		flexForm.addLabeledItem(lastNameLabel,lastNameTextBox);

		final ListBox roleListBox = new ListBox();
		flexForm.addFormItem("Role", roleListBox);
		flexForm.addRow();
		
		final Label titleLabel = new Label("Title");
		final TextBox titleTextBox = new TextBox();
        flexForm.addFormItem("Title", titleTextBox);
        
		final Label departmentLabel = new Label("Department");
		final TextBox departmentTextBox = new TextBox();
		flexForm.addFormItem("Department", departmentTextBox);

		final Label emailLabel = new Label("EMail");
		final TextBox emailTextBox = new TextBox();
		

		final Label phoneLabel = new Label("Phone");
		final TextBox phoneTextBox = new TextBox();

		final Label loginLabel = new Label("Login Name");
		final TextBox loginTextBox = new TextBox();

		final Label passwordLabel = new Label("Password");
		final PasswordTextBox passwordTextBox = new PasswordTextBox();

		final Label accessLabel = new Label("Access");
		final ListBox accessListBox = new ListBox();
		flexForm.addRow();
		final Label directoryidLabel = new Label("DirectoryID");
		final TextBox directoryidTextBox = new TextBox();
		flexForm.addLabeledItem(directoryidLabel, directoryidTextBox);

	}
    SimpleFormController sf = new SimpleFormController() {
    	@Override
    	public boolean formLoad(Object result) {
    		boolean ret=true;
    		Window.alert("We made it");
    		
    		return ret;
    	}
		@Override
    	public NamedItem validateSave(NamedItem  item) {
    		NamedItem it = (NamedItem) item;
    		it.setName(textBox.getName());
    	
    		return (NamedItem )it;
    	}
    };
}
