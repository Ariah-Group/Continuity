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
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TestServiceMockImpl  implements ItemService, ListService {
	private ItemDaoFactory itemDaoFactory;
	private OrderingService orderingService;
	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}
	
	public void setOrderingService(OrderingService orderingService) {
		this.orderingService = orderingService;
	}
	 List mocklist = new ArrayList() {
		 {
			Item r1 = createMockItem(0,"an item named a",1);
			Item r2 = createMockItem(1,"an item named b",2);
			add(r1);
			add(r2);
		 }
	 };
	 int mocklistnextid=2;
	 TestServiceMockImpl() {

	 }
	 protected Item createMockItem(int id, String name, int order) {
			Item ret = new Item();
			ret.setId(id);
			ret.setName(name);
			ret.setOrder(""+order);

			return ret;

	 }

	public Item getItem(String rootName, int id) {
	    System.out.println("Get "+id);
		Item r1 = (Item) mocklist.get(id);
		return r1;
	}
   public void init() {
//		Item r1 = createMockItem(1,"an item named a",1);
//		Item r2 = createMockItem(2,"an item named b",2);
//		mocklist.add(r1);
//		mocklist.add(r2);
   }
	public List getList(String rootName, int institutionId) {

		printList();
		return mocklist;
	}
	public List getSortedUserValuesbyInstReal(Integer institutionId,  String osort, int limit, String dir) {
		String sort=osort.toLowerCase();
		String seq=sort;
		if (sort.equals("name")) {
			seq="userId";
		}
		if (sort.equals("name")) {
			seq="lastName, firstName";
		}
		if (sort.equals("phone")) {
			seq="workPhone";
		}
		if (sort.equals("email")) {
			seq="emailregular";
		}
		if (sort.equals("role")) {
			seq="securityType";
		}
		if (sort.equals("access")) {
			seq="accessStatus";
		}
		List list= null;
		//list = someDao.valueListBy(institutionId, seq, limit, dir);
		return list;
	}

	public List getSortedValuesbyIntegerFilter(Integer institutionId, String osort, int limit, String dir) {
           return getList("",institutionId.intValue());
	}

	
	
	
	public List getSortedList(String rootName, String sortBy, int limit, String dir,
			String institutionId) {
	
		return getList(rootName, Integer.parseInt(institutionId));
	}
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Item getItem(String rootName, String id) {
		// TODO Auto-generated method stub
		return getItem(rootName, Integer.parseInt(id));
	}

	public List getList(String rootName, String institutionId) {
		// TODO Auto-generated method stub
		return getList(rootName, Integer.parseInt(institutionId));
	}




	public String deleteItem(String rootName, Item item) {
		System.out.println("delete called.");
		return "This is delteItem mock test";
	}

	public String insertItem(String rootName, Item item) {
        // Add new item into list.
		// Create a new id for the item.
		item.setId(mocklistnextid++);
		mocklist.add(item);
		int addedord=Integer.parseInt(item.getOrder());
        for (int i=0;i<mocklist.size()-2;i++) {
        	Item thisitem= (Item) mocklist.get(i);
        	int thisord=Integer.parseInt(thisitem.getOrder());
        	if(thisord>addedord) {
        		thisitem.setOrder(""+(thisord+1));
        	}
        } 
        System.out.println("create called.");
        System.out.println(orderingService.getClass().getCanonicalName());
        System.out.println(itemDaoFactory.getClass().getCanonicalName());
        return "";
	}

	public String updateItem(String rootName, Item item) {
	    Item thisitem= (Item) mocklist.get(item.getId());
	    System.out.println("Updating item "+rootName+": "+item.getId());
	    thisitem.setName(item.getName());
	    System.out.println("Setting name to: "+thisitem.getName());
	    mocklist.set(item.getId(), thisitem);

	    System.out.println("Updated");
        printList();
        return "";
	}
    void printList() {
    	System.out.println("Print List");
	    for (int i=0;i<mocklist.size();i++) {
	    	System.out.println(((Item) mocklist.get(i)).getName());
	    }
    }

	public List getSortedList(String itemSet, int start, String sortBy,
			int limit, String dir, String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {
		// TODO Auto-generated method stub
		return null;
	}


}
