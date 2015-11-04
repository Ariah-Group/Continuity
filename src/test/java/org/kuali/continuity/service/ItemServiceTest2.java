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
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.admin.main.client.SimpleService;
import org.kuali.continuity.domain.OrderedType;

public class ItemServiceTest2 extends AdminDAOTest {

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
	public void testSkills() {
		ListService itemListService = (ListService) itemService;
        List skillList = itemListService.getSortedList("skill", 1, "name", 999, "ASC", 1);
        for (Object s: skillList) {
        	System.out.println(s.getClass().getSimpleName());
        }
	}
	public void testDependency() {
		ListService itemListService = (ListService) itemService;
        List<DependencyItem> dList = itemListService.getSortedList("dependency", 1, "name", 999, "ASC", 1);
        for (DependencyItem s: dList) {
        	System.out.println(s.getName()+" "+s.getDescription()+s.getType()+" "+s.getOrderNo());
        }
        DependencyItem di = (DependencyItem) itemService.getItem("dependency", "85");
        System.out.println(di.getDescription()+" "+di.getName()+" "+di.getType());
	}



}
