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
package org.kuali.continuity.admin.main.server;
import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.main.client.BuildingItem;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.admin.main.client.SettingItem;
import org.kuali.continuity.admin.main.client.SimpleService;
import org.kuali.continuity.service.ListService;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class SimpleServiceMockImpl implements  SimpleService, ListService  {
	private ItemDaoFactory itemDaoFactory;
	
	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}
	
	static List mocklist = new ArrayList() {
		 {
			 NamedItem r1 = createMockItem(0,"an item named a\nand so on",1);
			 NamedItem r2 = createMockItem(1,"an item named b",2);
			 NamedItem r3 = createMockItem(1,"an item named c",3);

			add(r1);
			add(r2);
			add(r3);
		 }
	 };
	 int mocklistnextid=3;
	 SimpleServiceMockImpl() {

	 }
	 protected static BuildingItem createMockItem(int id, String name, int order) {
			BuildingItem ret = new BuildingItem();
			ret.setId(id);
			ret.setName(name);
			ret.setAddress("123 First St");
			ret.setCaan("1243");
			ret.setCommonName(name);
			ret.setOwner("Owned");
			return ret;

	 }
	 
	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {
		System.out.println("SortedList");
		printList();
		return mocklist;
	}

	public List getSortedValuesbyIntegerFilter(Integer filter, String osort,
			int limit, String dir) {
		System.out.println("SortedValues");
		printList();
		return mocklist;
	}

	public String deleteItem(String rootName, NamedItem item) {
		// TODO Auto-generated method stub
		return "This is deleteItem mock test";
	}

	public NamedItem getItem(String rootName, Integer id) {
	    System.out.println("Get "+id);
	    NamedItem r1 = null;
	    if (rootName.equals("setting")) {
	    	SettingItem s1 = new SettingItem();
	    	s1.setLocation("UCSF");
	    	s1.setSublocation("Medical Center");
	    	s1.setAccess(0);
	    	Boolean [] opts= {true, false, true, true };
	    	s1.setOptions(opts);
	    	r1 = (NamedItem)s1;
	    	
	    } else {
	    	 r1 =  (NamedItem) mocklist.get(id);
	    }
	   
		return r1;
	}

	public List getList(String rootName, String institutionId) {
		// TODO Auto-generated method stub
		
		printList();
		return mocklist;
	}

	public List getList() {

		printList();
		return mocklist;
	}

	public String insertItem(String rootName, NamedItem item) {
		// TODO Auto-generated method stub
		return "";
	}

	public String updateItem(String rootName, NamedItem item) {
		// TODO Auto-generated method stub
		return "";
	}
    void printList() {
    	System.out.println("Print List");
	    for (int i=0;i<mocklist.size();i++) {
	    	System.out.println(((BuildingItem) mocklist.get(i)).getName());
	    }
    }
	public String [][] getStringArray(String rootName, Integer institutionId) {
		
		String [] x = {"a", "b", "c"};
		String [] y= {"a", "b", "c"};
		String [] [] ret =  {x, y};
		
		return ret;
		
	}
	public void saveStringArray(String rootName, Integer institutionId, String[][] stringArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] getStringPlanArray(String rootName, Integer institutionId) {
		//sourceList=continuityPlanService.getSimpleContinuityPlanList(planId);
		return null;
	}

}
