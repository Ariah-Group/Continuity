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
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.admin.service.util.PlanString;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.service.ContinuityPlanAdminValidationService;
import org.kuali.continuity.security.SecurityUtil;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

/**
 * This service is addressed both by GWT and by Ext.
 * 
 * @author richkatz
 * 
 */
public class ItemServiceImpl extends ServiceImpl implements ItemService,
		ListService {
	private final Logger logger = Logger.getLogger(ItemServiceImpl.class);

	private ItemDaoFactory itemDaoFactory;

	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}

	private OrderingService orderingService;

	private BaseAdminOrderedDAO getDao(String itemRootName) {
		return itemDaoFactory.getDao(itemRootName);
	}

	public void setOrderingService(OrderingService orderingService) {
		this.orderingService = orderingService;
	}

	private ContinuityPlanAdminValidationService continuityPlanAdminValidationService;

	public void setContinuityPlanAdminValidationService(
			ContinuityPlanAdminValidationService continuityPlanAdminValidationService) {
		this.continuityPlanAdminValidationService = continuityPlanAdminValidationService;
	}

	public Item getItem(String rootName, int id) {
		Item dest = null;
		String action = "getting data ";
		try {
			BaseAdminOrderedDAO dao = getDao(rootName);
			System.out.println("dao class" + dao.getClass().getName());
			BaseAdminOrderedDomainObject orig = dao.getById(id);
			dest = transform2UI(orig, rootName);
		} catch (Exception e) {
			logger.warn("Failed to retrieve  " + rootName + " while" + action
					+ ":" + rootName, e);
			System.out.println("Failed to retrieve  " + rootName + " while"
					+ action + ":" + rootName + " " + e);
		}
		return dest;
	}

	ArrayList<String> typeMap = new ArrayList() {
		{
			add(0, "Downstream");
			add(1, "Upstream");
			add(2, "None");
		}
	};

	public Item transform2UI(BaseAdminOrderedDomainObject orig, String rootName) {
		String action = "getting destination instance ";
		Item dest = null;
		try {
			dest = (Item) itemDaoFactory.getNamedItem(rootName);
			action = "transforming ";

			PropertyUtils.copyProperties(dest, orig);

			if (dest instanceof DependencyItem) {
				DependencyItem ditem = (DependencyItem) dest;

				Dependency dorig = (Dependency) orig;
				ditem
						.setDescription(dorig.getDependencyType()
								.getDescription());
				int typenum = Integer.parseInt(dorig.getDependencyType()
						.getDescription());
				System.out.println("Got description: "
						+ dorig.getDependencyType().getDescription());

				System.out.println("Got type: "
						+ dorig.getDependencyType().getId());
				int dvalue = 0;
				if (ditem.getDescription().equals("Upstream")) {
					dvalue = 1;
				}
				ditem.setType(dvalue);

			}
		} catch (Exception e) {
			logger.warn("Unable to return properties for " + rootName + ": "
					+ orig.getId(), e);

		}
		return dest;
	}

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId0) {
		System.out.println("Calling list");
		Integer institutionId = (Integer) this
				.getContextAttribute("systemDomainId");
		int accessLevel = (Integer) this.getContextAttribute("accessLevel");

		BaseAdminOrderedDAO itemDao = itemDaoFactory.getDao(rootName);
		SortByThis sortByThis = new SortByThis(sortBy);
		System.out.println("The DAO" + itemDao.getClass().getName());
		System.out.println("The Institution: " + institutionId);
		Boolean boolDir = new Boolean(dir.equals("ASC"));
		List<? extends BaseAdminOrderedDomainObject> listRet = itemDao
				.getSortedListBySystemDomainId(institutionId, sortByThis,
						boolDir);
		// List ret= itemDao.getList(institutionId.intValue(), 0, 999,
		// OrderingDef.SortBy.id, true);
		if (listRet == null) {
			System.out.println("getList: nothing returned");

		} else {
			System.out.println("getList: returned " + listRet.size());
		}
		List ret = new ArrayList();

		int i = 0;
		boolean toSort = sortBy != null && sortBy.trim().equals("orderNo");
		for (BaseAdminOrderedDomainObject orig : listRet) {
			i++;
			if (toSort) {
				// re-sort
				if (orig.getOrderNo() != i) {
					orig.setOrderNo(i);
					itemDao.update(orig);
				}
			}
			Item dest = transform2UI(orig, rootName); // Covariant
			ret.add(dest);
		}

		return ret;
	}

	public Item getItem(String rootName, String id) {

		return getItem(rootName, Integer.parseInt(id));
	}

	// ============================
	// Methods for individual items - controlled by OrderingService.

	public String deleteItem(String itemRoot, Item item) {

		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		// proceed
		String err = "";
		String action = "geting the Location";
		try {
			int thelocation = (Integer) this
					.getContextAttribute("systemDomainId");
			action = "validating plan usage";
			List<Object[]> planList = new ArrayList();
			if (!(itemRoot.equals("reference") || itemRoot.equals("faq"))) {
				try {
					continuityPlanAdminValidationService.getPlans(
							itemDaoFactory.getDomainItem(itemRoot).getClass(),
							item.getId());
				} catch (Exception e) {
					logger.info("Plan usage test appears to be not necesssary on item:"
							+ itemRoot, e);
					
				}
			}
			if (planList.size() > 0) {
				err = "Following Plans have links to the record selected for deletion:"
						+ "|" + PlanString.planList2String(planList);
			} else {
				action = "performing delete";
				orderingService.delete(itemRoot, thelocation, item);
			}

		} catch (Exception e) {
			System.out.println("ItemServiceImpl:deleteItem Exception while "
					+ action + ": " + e);
			err = "Delete encountered an error while " + action + ": " + e;
			logger.warn(
					"ItemServiceImpl:deleteItem Exception during " + action, e);
		}
		return err;
	}

	public String insertItem(String itemRoot, Item item) {
		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		// proceed
		Integer systemDomainId = (Integer) getContextAttribute("systemDomainId");
		orderingService.insert(itemRoot, systemDomainId, item);
		return "";
	}

	public String updateItem(String itemRoot, Item item) {
		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		// proceed
		int systemDomainId = (Integer) getContextAttribute("systemDomainId");
		item.setSystemDomainId(systemDomainId);
		orderingService.update(itemRoot, systemDomainId, item);
		return "";
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
