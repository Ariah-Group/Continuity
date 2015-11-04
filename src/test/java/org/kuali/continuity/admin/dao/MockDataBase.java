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
package org.kuali.continuity.admin.dao;

import java.util.ArrayList;

import org.kuali.continuity.admin.main.client.Item;

public class MockDataBase {
	private static MockDataBase mockDataBase = new MockDataBase();
	public Item rowa = new Item(0,"An item called A",1);

	public Item rowb = new Item(1,"An item called B",2);
	
	public ArrayList<Item> getTableData() {
		return tableData;
	}

	public void setTableData(ArrayList tableData) {
		this.tableData = tableData;
	} 
	public Item searchMockTable(String name) {
		Item ret=null;
		for (Item i: tableData) {
			if(i.getName().equals(name)) {
				ret=i;
				break;
			}
		}
		return ret;
	}

	ArrayList<Item> tableData = new ArrayList() {
		{
			add(rowa);
			add(rowb);
		}
	};
	private MockDataBase() {
		
	}
    public static MockDataBase getInstance() {
    	return mockDataBase;
    }
}
