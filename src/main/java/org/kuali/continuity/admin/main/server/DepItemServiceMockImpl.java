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

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.DependencyListValue;
import org.kuali.continuity.admin.main.client.DependencyService;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

public class DepItemServiceMockImpl  implements DependencyService, ListService {
	 private static final Logger logger = Logger.getLogger(DepItemServiceMockImpl.class);
		private ItemDaoFactory itemDaoFactory;
		private OrderingService orderingService;
		public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
			this.itemDaoFactory = itemDaoFactory;
		}
		
		public void setOrderingService(OrderingService orderingService) {
			this.orderingService = orderingService;
		}
	 List <DependencyItem> mocklist = new ArrayList() {
		 {
			DependencyItem r1 = createMockItem(0,"an item named a",1,1);
			DependencyItem r2 = createMockItem(1,"an item named b",2,2);
			add(r1);
			add(r2);
		 }
	 };
	 int mocklistnextid=2;
	 DepItemServiceMockImpl() {

	 }
	 protected DependencyItem createMockItem(int id, String name, int order, int type) {
		 DependencyItem ret = new DependencyItem();
			ret.setId(id);
			ret.setName(name);
			ret.setOrder(""+order);
		    ret.setType(type);
			return ret;

	 }
		public List getSortedList(String rootName, String sortBy, int limit, String dir,
				String institutionId) {
		
			return getList(rootName, Integer.parseInt(institutionId));
		}
	public DependencyItem getItem(String itemSet, int id) {
	    System.out.println("Get "+id);
	    DependencyItem r1 = (DependencyItem) mocklist.get(id);
	    System.out.println("Returning "+r1.getName());
		return r1;
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
	public List getList(String itemSet, int institutionId) {

		printList();
		ArrayList displist= new ArrayList();
		for (DependencyItem it : mocklist) {
            DependencyListValue dlv = new DependencyListValue();
            try {
            	PropertyUtils.copyProperties(dlv, it);
            } catch (Exception e) {
            	logger.warn("Exception while copying",e);
            }
            dlv.setType((String) typeMap.get(it.getType()));
            displist.add(dlv);
		}
		return displist;
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
	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {

		return getList(rootName, institutionId.intValue());
	}
	public List getSortedValuesbyIntegerFilter(Integer institutionId, String osort, int limit, String dir) {
           return getList("",institutionId.intValue());
	}

	public List getSortedList(String itemSet, int start, String sortBy,
			int limit, String dir, String institutionId) {
		// TODO Auto-generated method stub
		return getList(itemSet, institutionId);
	}
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public DependencyItem getItem(String itemSet, String id) {
		// TODO Auto-generated method stub
		return getItem(itemSet, Integer.parseInt(id));
	}

	public List getList(String itemSet, String institutionId) {
		// TODO Auto-generated method stub
		return getList(itemSet, Integer.parseInt(institutionId));
	}




	public void deleteItem(String itemSet, Item oitem) {
		DependencyItem item = (DependencyItem) oitem;
		System.out.println("delete called.");

	}

	public void insertItem(String itemSet, Item oitem) {
		DependencyItem item = (DependencyItem) oitem;
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
		DependencyItem item = (DependencyItem) oitem;
		DependencyItem thisitem= (DependencyItem) mocklist.get(item.getId());
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
