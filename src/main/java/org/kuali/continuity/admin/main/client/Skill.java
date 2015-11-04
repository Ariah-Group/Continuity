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
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Skill extends SimpleGridViewer {



	final TextArea description = new TextArea();

	final ListBox access = new ListBox();

	int[] gcsize = { 40, 95, 160, 50, 0, 0 };
	public ColumnConfig skillCol = new ColumnConfig("Skill", "name",
			gcsize[1], true);	

	public ColumnConfig descriptionCol = new ColumnConfig("Description", "description",
					gcsize[2], true);
    public ColumnModel columnModel= null;
	
	public void onModuleLoad()  {
		// Grid
		String proxyUrl="./items.lst";
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new StringFieldDef("id"), new StringFieldDef("name"),
				new IntegerFieldDef("order"), new StringFieldDef("description") });

		itemService= (ItemServiceAsync) GWT.create(ItemService.class);
		Element screenelement= DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element pluralelement=DOM.getElementById("plural");
		Element dataelement = DOM.getElementById("dataelement");
		itemRootName=dataelement.getTitle();
		this.formController=sfc;
		itemRootName="skill";
		columnModel = new ColumnModel(new ColumnConfig[] { orderColumn, skillCol, descriptionCol });

		onModuleLoad("Skills", proxyUrl, columnModel, recordDef);

		// Buttons
		String name="Skill";
		setButtonNames("Skill");

		// Heading
		String plural=pluralelement.getTitle();
		setHeadingName(plural+" Setup");

		// Form
        flexForm.setRowWidth("642px");
		flexForm.addFormItem(name,textBox);
	    flexForm.addFormItem("Order", orderBox);
	    description.setSize("642px", "64px");
	    textBox.setWidth("500px");
	    textBox.setMaxLength(50);
		formPanel.add(new Label("Description"));

		formPanel.add( description);
		flexForm.registerWidget(description);  // All this does is enable the UI to clear the field when it is supposed to.
		
		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		flexForm.registerWidget(csrfToken);
	}
	SkillFormController sfc = new SkillFormController();
    class SkillFormController extends SimpleFormController {
        public void showController() {

        }

    	public boolean formLoad(Object result) {
			SkillItem item = (SkillItem) result;
			textBox.setText(item.getName());
			description.setText(item.getDescription());
			orderBox.setText(item.getOrder());
			return true;
		}
		public NamedItem validateSave(NamedItem namedItem) {
			SkillItem item = new SkillItem();
			item.setName(textBox.getText());
			item.setDescription(description.getText());
			String orderStr = orderBox.getText();
			if (orderStr.trim().isEmpty()) orderStr = "999";  // max 3 digit int
			item.setOrder(orderStr);
			item.setCsrfToken(csrfToken.getValue());
			return (NamedItem) item;
		}



    };
}
