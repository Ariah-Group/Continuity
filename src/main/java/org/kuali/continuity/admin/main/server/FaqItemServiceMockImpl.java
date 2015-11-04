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

import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.main.client.FaqItem;
import org.kuali.continuity.admin.main.client.FaqService;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

public class FaqItemServiceMockImpl  implements FaqService, ListService {
	 private static final Logger logger = Logger.getLogger(DepItemServiceMockImpl.class);
		private ItemDaoFactory itemDaoFactory;
		private OrderingService orderingService;
		public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
			this.itemDaoFactory = itemDaoFactory;
		}
		
		public void setOrderingService(OrderingService orderingService) {
			this.orderingService = orderingService;
		}
	 List <FaqItem> mocklist = new ArrayList() {
		 {
			 FaqItem r1 = createMockItem(0,"a question named a",1,"answer this");
			 FaqItem r2 = createMockItem(1,"a question named b",2,"answer that");
			add(r1);
			add(r2);
		 }
	 };
	 int mocklistnextid=2;
	 FaqItemServiceMockImpl() {

	 }
	 protected FaqItem createMockItem(int id, String name, int order, String ans) {
		 FaqItem ret = new FaqItem();
			ret.setId(id);
			ret.setName(name);
			ret.setOrder(""+order);
		    ret.setAnswer(ans);
			return ret;

	 }
		public List getSortedList(String rootName, String sortBy, int limit, String dir,
				String institutionId) {
		
			return mocklist;
		}
	public Item getItem(String itemSet, int id) {
	    System.out.println("Get "+id);
	    FaqItem r1 = (FaqItem) mocklist.get(id);
	    System.out.println("Returning "+r1.getName());
		return (Item) r1;
	}
   public void init() {
//		Item r1 = createMockItem(1,"an item named a",1);
//		Item r2 = createMockItem(2,"an item named b",2);
//		mocklist.add(r1);
//		mocklist.add(r2);
   }
   ArrayList typeMap = new ArrayList() {
	   {
		      add("None");
		      add("Upstream");
		      add("Downstream");
	   }
   };

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {

		return mocklist;
	}
	
	
	public List getSortedList(String itemSet, int start, String sortBy,
			int limit, String dir, String institutionId) {
		// TODO Auto-generated method stub
		return mocklist;
	}
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Item getItem(String itemSet, String id) {
		
		return getItem(itemSet, Integer.parseInt(id));
	}

	public void deleteItem(String itemSet, Item oitem) {
		FaqItem item = (FaqItem) oitem;
		System.out.println("delete called.");

	}

	public void insertItem(String itemSet, Item oitem) {
		FaqItem item = (FaqItem) oitem;
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
//		System.out.println("create called.");

	}

	public void updateItem(String itemSet, Item oitem) {
		FaqItem item = (FaqItem) oitem;
		FaqItem thisitem= (FaqItem) mocklist.get(item.getId());
	    System.out.println("Updating item "+itemSet+": "+item.getId());
	    thisitem.setName(item.getName());
	    System.out.println("Setting name to: "+thisitem.getName());
	    mocklist.set(item.getId(), thisitem);

	    System.out.println("Updated");
        printList();




	}
    void printList() {
    	System.out.println("Print List");
	    for (int i=0;i<mocklist.size();i++) {
	    	System.out.println(((Item) mocklist.get(i)).getName());
	    }
    }


}
