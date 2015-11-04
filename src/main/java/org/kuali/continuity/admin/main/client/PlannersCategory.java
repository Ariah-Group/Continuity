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
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.GridRowListener;

public class PlannersCategory extends SimpleGridViewer {
	
	public void onModuleLoad()  {
		super.onModuleLoad("Planner's Log Categories");
		String name="Category";
		setButtonNames(name);
		String plural="Categories for Planner's Log";
		setHeadingName(plural+" Setup");
		textBox.setMaxLength(50);
		textBox.setWidth("480px");
	    flexForm.addFormItem("Category", textBox);
	    flexForm.addFormItem("Order", orderBox);

		gridPanel.setCls(".myclass");
		
	}

}
