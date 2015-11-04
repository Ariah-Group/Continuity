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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.DependencyService;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

public class DependencyServiceImpl  implements DependencyService, ListService {
	 private static final Logger logger = Logger.getLogger(DepItemServiceMockImpl.class);
		private ItemDaoFactory itemDaoFactory;
		private OrderingService orderingService;
		public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
			this.itemDaoFactory = itemDaoFactory;
		}
		
		public void setOrderingService(OrderingService orderingService) {
			this.orderingService = orderingService;
		}
		private BaseAdminOrderedDAO getDao(String itemRootName) {
			return itemDaoFactory.getDao(itemRootName);
		}

		

	 int mocklistnextid=2;
	 public DependencyServiceImpl() {

	 }
	 protected DependencyItem createMockItem(int id, String name, int order, int type) {
		 DependencyItem ret = new DependencyItem();
			ret.setId(id);
			ret.setName(name);
			ret.setOrder(""+order);
		    ret.setType(type);
			return ret;

	 }
	 public List getSortedList(String rootName, int start, String sortBy,
				int limit, String dir, Integer institutionId) {
		 BaseAdminOrderedDAO itemDao = itemDaoFactory.getDao(rootName);
			SortByThis sortByThis = new SortByThis(sortBy);	
			Boolean boolDir = new Boolean(dir.equals("ASC"));
			List<? extends BaseAdminOrderedDomainObject> listRet = itemDao.getSortedListBySystemDomainId(institutionId, sortByThis,
					boolDir);
			// List ret= itemDao.getList(institutionId.intValue(), 0, 999,
			// OrderingDef.SortBy.id, true);
			if (listRet == null) {
				System.out.println("getList: nothing returned");

			} else {
				System.out.println("getList: returned " + listRet.size());
			}
			List ret = new ArrayList();
			try {
				for (BaseAdminOrderedDomainObject orig : listRet) {
					Item dest = transformLoad(orig); // Replace with covariant from Factory.
					ret.add(dest);
				}
			} catch (Exception e) {
	             System.out.println("Unable to copy: "+e);
	             logger.warn("Unable to copy list:",e);
			}
			return ret;
		}
	 
	protected DependencyItem transformLoad(BaseAdminOrderedDomainObject orig) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		DependencyItem dest = new DependencyItem();
		PropertyUtils.copyProperties(dest, orig);
		Dependency dorig= (Dependency) orig;
		int thistype = Integer.parseInt(dorig.getDependencyType().getId());
		dest.setDescription(typeMap.get(thistype));
		dest.setType(thistype);
		return dest;
		
	}
	public DependencyItem getItem(String rootName, int id) {
		DependencyItem dest=null;
		String action="getting data ";
		try {		
			BaseAdminOrderedDAO dao = getDao(rootName);
			System.out.println("dao class"+dao.getClass().getName());
			BaseAdminOrderedDomainObject orig= dao.getById(id);
		
			action="transforming ";
			dest= transformLoad(orig);


		} catch (Exception e) {
			logger.warn(
					"Failed to retrieve  "+rootName+" while"+action+":" + rootName, e);
			System.out.println("Failed to retrieve  "+rootName+" while"+action+":"
					+ rootName + " " + e);
		}
		return  dest;
	}

   ArrayList<String> typeMap = new ArrayList() {
	   {
		      add(0, "Downstream");
		      add(1, "Upstream");
		      add(2, "None");
	   }
   };





	public DependencyItem getItem(String rootName, String id) {
		// TODO Auto-generated method stub
		return getItem(rootName, Integer.parseInt(id));
	}

	public void deleteItem(String itemRoot, Item item) {
		orderingService.delete(itemRoot, 0, item);
	}

	public void insertItem(String itemRoot, Item item) {
		orderingService.insert(itemRoot, item.getOrderNo(), item);
		
	}

	public void updateItem(String itemRoot, Item item) {
		orderingService.update(itemRoot, item.getOrderNo(), item);
	}



	public List getSortedValuesbyIntegerFilter(Integer filter, String osort,
			int limit, String dir) {
		// TODO Auto-generated method stub
		return null;
	}


	class SortByThis implements SortByType {
		String thisSort;

		public SortByThis(String thisin) {
			thisSort = thisin;
		}

		public void setThis(String thisin) {
			thisSort = thisin;
		}

		public String getSortByValue() {
			return thisSort;
		}

	}


	

	




}
