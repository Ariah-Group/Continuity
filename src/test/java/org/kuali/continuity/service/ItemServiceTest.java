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

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.kuali.continuity.admin.dao.AdminDAOTest;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.dao.MapGetter;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.admin.main.client.SimpleService;

public class ItemServiceTest extends AdminDAOTest {

	ItemService itemService;
	SimpleService simpleService;

	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	ItemDaoFactory itemDaoFactory;

	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;

	}

	public void testInjection() {
		System.out.println("Start");
		System.out.println(itemService.getClass().getName());
		// System.out.println(listService.getClass().getName());
	}

	public void testItemLevel() {
		Item i = itemService.getItem("application", "1");

		System.out.println("GET: " + i.getId() + " " + i.getName() + " "
				+ i.getOrder());

		System.out.println("Change Order.");
		i.setOrderNo(2);
		itemService.updateItem("application", i);
		System.out.println("Change Name.");
		i.setName("joe");
		itemService.updateItem("application", i);

		System.out.println("Delete.");
		itemService.deleteItem("application", i);
		Item i2 = new Item();
		i2.setName("new one");
		i2.setOrderNo(2);
		i2.setSystemDomainId(1);
		itemService.insertItem("application", i2);

	}

	public void testListLevel() {
		ListService listService = (ListService) itemService;
		List list = listService.getSortedList("dependency", 0, "name", 999,
				"ASC", 1);

		List list2 = listService.getSortedList("application", 0, "name", 999,
				"ASC", 1);
		if (null == list || list2 == null) {
			fail("One List is null");
		}

	}

	public void testAllItems() {
		MapGetter mg = new MapGetter();
		HashMap itemMap = mg.getDomainMap(itemDaoFactory);
		Set itemSet = itemMap.keySet();
		String action = "get rootName";
		ListService itemListService = (ListService) itemService;
		for (Object key : itemSet) {
			try {
				String rootName = (String) key;
				System.out.println("Start root: " + key);
				action = "get instance";
				Object domainInstance = ((Class) itemMap.get(rootName))
						.newInstance();
				System.out.println("Start domain: "
						+ domainInstance.getClass().getName());
				action = "get list Service";
				if (domainInstance instanceof BaseAdminOrderedDomainObject) {
					action = "get item";
					Item item = itemService.getItem(rootName, "1");

					action = "get list";
					List l = itemListService.getSortedList(rootName, 0, "name",
							-1, "ASC", 1);

				} else {
					if (!rootName.equals("function")) {
						action = "get named list";
						List l = ((ListService) simpleService).getSortedList(
								rootName, 0, "name", -1, "ASC", 1);
					}
				}
			} catch (Exception e) {
				System.out
						.println("Unable to " + action + ": " + key + " " + e);
				this.fail();

			}

		}

	}

}
