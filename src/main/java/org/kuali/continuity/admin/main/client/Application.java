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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Application extends SimpleGridViewer implements EntryPoint {
	
	public void onModuleLoad()  {
		// Top level info
		String pageInfo;
		
	    
        String formItemName= this.setElementNames(ItemService.class);
        
      // Admin item specific settings
		this.formController=topFormController;
		textBox.setMaxLength(50);
		textBox.setWidth("500px");
		flexForm.addFormItem(formItemName, textBox);
	    flexForm.addFormItem("Order", orderBox);
        itemRootName=itemRootName.toLowerCase();

     // set token
        String token = Cookies.getCookie(CSRF_TOKEN);
        csrfToken.setValue(token);
        flexForm.registerWidget(csrfToken);

	}
	
	// Temporary Refactor
	public ColumnModel columnSet(String nameName) {
		 ColumnConfig orderColumn = new ColumnConfig("Order", "order",
				gridColumnSize[0], true);
		 ColumnConfig nameColumn = new ColumnConfig(nameName, "name",
				gridColumnSize[1], true);
		/**
		 * Default column model (used by a number of grid-based managers).
		 */
		ColumnModel simplecolumnModel = new ColumnModel(new ColumnConfig[] {
				orderColumn, nameColumn });
		return simplecolumnModel;
	}
	public class TopFormController extends SimpleFormController {
		public boolean formLoad(Object result) {
		    
			Item item = (Item) result;
			//Window.alert("I got there: "+item.getOrder());
			textBox.setText(item.getName());
			orderBox.setText(item.getOrder());
			return true;
		}
    	public NamedItem validateSave(NamedItem  item) {
    		Item bi = (Item) item;
    		item.setName(textBox.getText());
    		item.setCsrfToken(csrfToken.getValue());
    		return (NamedItem )bi;
    	}

	
	}
    public TopFormController topFormController = new TopFormController();
    
}
