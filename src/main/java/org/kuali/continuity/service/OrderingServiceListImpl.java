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
package org.kuali.continuity.service;

import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.domain.DependencyType;

/**
 * This service implements ordered changes for a list. There is also an
 * implementation for a set.
 * 
 * @author richkatz
 * 
 */
public class OrderingServiceListImpl implements OrderingService {
	ItemDaoFactory itemDaoFactory;

	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}

	private static final Logger logger = Logger
			.getLogger(OrderingServiceListImpl.class);

	public boolean delete(String itemRoot, int thelocation, Item item) {
		/**
		 * 1. Retrieve record to be deleted and get order 2. Delete the item 3.
		 * For all items greater than or equal to current order set order to
		 * current order + n -1
		 */
		logger.info("Deleting: " + item.getId());
		System.out.println("Deleting: " + item.getId());
		BaseAdminOrderedDAO orderingDao = itemDaoFactory.getDao(itemRoot);
		System.out.println("Using: " + orderingDao.getClass().getName());
		int id = item.getId();

		// OrderedType o= (OrderedType) orderingDao.get(item.getId());

		int oldOrder = item.getOrderNo();
		orderingDao.delete(item.getId());
		List<BaseAdminOrderedDomainObject> aboveList = (List<BaseAdminOrderedDomainObject>) orderingDao
				.getSubListBySystemDomainIdAndStartOrderNo(thelocation, item
						.getOrderNo() + 1);
		for (BaseAdminOrderedDomainObject obj : aboveList) {
			obj.setOrderNo(obj.getOrderNo() - 1);
			orderingDao.update(obj);
		}

		return true;

	}

	/**
	 * Utility method to push remaining items up one order number to insert
	 * 
	 * @param item
	 * @param aboveList
	 * @param orderingDao
	 *            `
	 */
	protected void pushList(Item item,
			List<BaseAdminOrderedDomainObject> aboveList,
			BaseAdminOrderedDAO orderingDao) {
		for (BaseAdminOrderedDomainObject i : aboveList) {
			int pushorder = i.getOrderNo();
			if (pushorder >= item.getOrderNo()) {
				i.setOrderNo(pushorder + 1);
				orderingDao.update(i);
			}
		}
	}

	public void checkList(List<BaseAdminOrderedDomainObject> list, int testorder) {
		System.out.println("***SUBLIST*** Test for:" + testorder);
		for (BaseAdminOrderedDomainObject i : list) {
			System.out.println("" + i.getOrderNo() + " " + i.getName() + " "
					+ i.getId());
			if (i.getOrderNo() < testorder) {
				System.out.println("Error - order not correct");
			}
		}
		System.out.println("***SUBLIST End***");

	}

	public boolean insert(String itemRoot, int location, Item item) {

		/**
		 * 1. Check for duplicates (if required, generally it is) 2. For all
		 * items greater than or equal to current order, set order to current
		 * order + n
		 */
		String action = "get Dao";
		BaseAdminOrderedDAO orderingDao = itemDaoFactory.getDao(itemRoot);
		item.setSystemDomainId(location);
		action = "get above list";
		List<BaseAdminOrderedDomainObject> aboveList = (List<BaseAdminOrderedDomainObject>) orderingDao
				.getSubListBySystemDomainIdAndStartOrderNo(location, item
						.getOrderNo());

		// Create the new item.
		if (aboveList != null && !aboveList.isEmpty()) {
			checkList(aboveList, item.getOrderNo());
			action = "push list";
			pushList((Item) item, aboveList, orderingDao);
		} else {
			action = "adjust top";
			int top =0;
			try {
				BaseAdminOrderedDomainObject topobj = ((BaseAdminOrderedDomainObject) orderingDao
					.getHighestOrderedObjectBySystemDomainId(location));
				if (null!=topobj) {
					top=topobj.getOrderNo();
				}
			} catch (Exception e) {
				System.out.println("Exception while getting top record for domain: "+location);
			}
			item.setOrderNo(top + 1);
		}
		//
		action = "make empty domain item";
		
		BaseAdminOrderedDomainObject dest = itemDaoFactory.getItem(itemRoot);

		try {
			action = "copy to domain item";
			dest = this.transformFromUI2Domain(dest, item);
//			PropertyUtils.copyProperties(dest, item);
			// Wipe out ID because we're inserting.
			dest.setId(null);
			action = "create in database";
			logger.info("Insert Ordered: "+itemRoot+" "+item.getId()+": "+item.getName()+" Order: "+ item.getOrder());
			
			orderingDao.create(dest);

			return true;
		} catch (Exception e) {
			logger.warn("Unable to copy and create item during" + action + " "
					+ itemRoot, e);
			System.out.println("Unable to copy and create item during" + action
					+ " " + itemRoot + " " + e);

		}
		return false;

	}

	// givenSystemDomain comes from user.
	public boolean update(String itemRoot, int givenSystemDomain, Item item) {

		/**
		 * If item name (or anything but order) changes, store new item name If
		 * order changes If order is greater than or equal to highest order, 1.
		 * Make it highest order, but don't store it yet. 2. For all items
		 * greater than current order, set order to their order -1. 3. Store
		 * item. 4. If order is less than
		 */
		BaseAdminOrderedDAO orderingDao = itemDaoFactory.getDao(itemRoot);
		BaseAdminOrderedDomainObject saveObj = orderingDao
				.getById(item.getId());
		int thislocation = saveObj.getSystemDomainId();
		logger.info("**updating to SystemDomainID: " + thislocation);
		int thisId = item.getId();
		int neworder = item.getOrderNo();
		int oldorder = saveObj.getOrderNo();
		int hiorder = orderingDao.getHighestOrderedObjectBySystemDomainId(
				thislocation).getOrderNo();
		long recCount =orderingDao.getListBySystemDomainIdSize(thislocation);
		
		// Is the order changing?
		int location = givenSystemDomain;
		String action = "get list.";
		boolean updated = false;
		  System.out.println("Requested:" +neworder +" for "+recCount + " with current "+hiorder);
		// Special Case neworder is greater than highest order - make it equal
		if (neworder > hiorder) {
			neworder = hiorder;
		}
		
       if (neworder> (int) recCount) {
		    neworder= (int) recCount;
		}
     
		// Case data is different.
		                // if (oldorder == neworder) {
			try {
				saveObj = this.transformFromUI2Domain(saveObj, item);
//				PropertyUtils.copyProperties(saveObj, item);
				saveObj.setSystemDomainId(thislocation);
				logger.info("update Ordered: "+itemRoot+" "+saveObj.getId()+": "+saveObj.getName()+" Order: "+ saveObj.getOrderNo());
				
				orderingDao.update(saveObj);
				updated = true;
			} catch (Exception e) {
				logger.warn("Unable to copy properties of save item: "
						+ itemRoot + " " + item.getId());
			}

		             //}
		// Case Order Ids are not equal.
		if (oldorder != neworder) {
			// exchange(saveitem)
			List<? extends BaseAdminOrderedDomainObject> exchange = null;
			if (neworder > oldorder) {
				// Get sublist
				exchange = orderingDao
						.getSubListBySystemDomainIdAndStartOrderNo(location,
								oldorder);

				for (int i = 0; i < exchange.size(); i++) {
					BaseAdminOrderedDomainObject obj = exchange.get(i);
					if ((obj.getId() != thisId)
							&& (obj.getOrderNo() <= neworder)) {
						obj.setOrderNo(obj.getOrderNo() - 1);
						orderingDao.update(obj);
					}
				}

			} else {  // neworder < oldorder
				exchange = orderingDao
						.getSubListBySystemDomainIdAndStartOrderNo(location,
								neworder);
				for (int i = 0; i < exchange.size(); i++) {
					BaseAdminOrderedDomainObject obj = exchange.get(i);
					if ((obj.getId() != thisId)
							&& (obj.getOrderNo() <= oldorder)) {
						obj.setOrderNo(obj.getOrderNo() + 1);
						orderingDao.update(obj);
					}
				}

			}
			saveObj.setOrderNo(neworder);
			orderingDao.update(saveObj);
			updated = true;

		}
		return updated;

	}
	
	protected BaseAdminOrderedDomainObject transformFromUI2Domain(
			BaseAdminOrderedDomainObject dest, NamedItem item) throws Exception {
		PropertyUtils.copyProperties(dest, item);
		if (item instanceof DependencyItem) {
			DependencyItem dItem = (DependencyItem) item;
			Dependency dDest = (Dependency) dest;
			dDest.setDependencyType(new DependencyType("" + dItem.getType()));
		}
		return dest;
	}

}
