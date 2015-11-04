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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.main.client.Item;

/**
 * This service implements ordered changes for a set. There is also an
 * implementation for a list.
 * 
 * @author richkatz
 * 
 */
public class OrderingServiceSetImpl extends OrderingServiceListImpl implements OrderingService {
//	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
//		this.itemDaoFactory = itemDaoFactory;
//	}

	private static final Logger logger = Logger.getLogger(OrderingServiceSetImpl.class);

	ItemDaoFactory itemDaoFactory;

	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	};
	public boolean insert(String itemRoot, int location, Item item) {
		/**
		 * 1. Check for duplicates (if required, generally it is) 2. For all
		 * items greater than or equal to current order, set order to current
		 * order + n
		 */
		BaseAdminOrderedDAO orderingDao = itemDaoFactory.getDao(itemRoot);
		
		String name = item.getName();
		BaseAdminOrderedDomainObject nameditem= orderingDao.getBySystemDomainIdAndName(location,name);
		if(nameditem!=null) {
			return false;
		} else {
			List<BaseAdminOrderedDomainObject> aboveList = (List<BaseAdminOrderedDomainObject>) orderingDao.getSubListBySystemDomainId(location, item.getOrderNo(), 999);
			for (BaseAdminOrderedDomainObject i: aboveList) {
				int pushOrder=i.getOrderNo();
				if(pushOrder>=item.getOrderNo()) {
					i.setOrderNo(pushOrder+1);
					orderingDao.update(i);
				}
			}
			BaseAdminOrderedDomainObject newItem = itemDaoFactory.getItem(itemRoot);
			try {
				BeanUtils.copyProperties(newItem, item);
				orderingDao.create(newItem);
				return true;
			} catch (Exception e) {
				logger.warn("Unable to copy and create item"+itemRoot, e);
			}
			return false;
			
		}
		

	}



}
