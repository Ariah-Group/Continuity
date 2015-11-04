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

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.admin.dao.AdminDAOTest;
import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.main.client.AcronymItem;
import org.kuali.continuity.admin.main.client.BuildingItem;
import org.kuali.continuity.admin.main.client.LocationItem;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.admin.main.client.SettingItem;
import org.kuali.continuity.admin.main.client.SimpleService;
import org.kuali.continuity.domain.SortByType;

public class SimpleServiceTest extends AdminDAOTest {

	private SimpleService simpleService;
	private SystemDomainDAO systemDomainDAO;
	

	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO = systemDomainDAO;
	}

	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}

	public void testInjection() {
		System.out.println("OK " + simpleService.getClass().getName());

	}

	public void testSimpleServiceGets() {
		System.out.println("Start");
		List<String> rootItems = new ArrayList() {
			{
				add("acronym");
				add("building");
				add("location");
			}
		};
		int[] ids = { 2, 2, 1 };
		int i = 0;
		for (String rootItem : rootItems) {
			System.out.println("****" + rootItem);
			int id = ids[i++];
			NamedItem acr = simpleService.getItem(rootItem, id);
			if (acr == null) {
				System.out.println("got null");
				// fail();
			}
			System.out.println(acr.getClass().getName());
			System.out.print(acr.getId() + " ");
			System.out.print(acr.getName() + " ");
		}
	}



	public void testSimpleList() {
		List<BuildingItem> slist = ((ListService) simpleService).getSortedList(
				"building", 0, "name", -1, "ASC", 1);
		for (BuildingItem b : slist) {
			System.out.println(b.getCommonName());
		}
	}

	
	public void testSimpleServiceUpdate() {
		String rootItem = "acronym";
		int id = 2;
		AcronymItem acr = (AcronymItem) simpleService.getItem(rootItem, id);
		String newname = "JoyJoy";
		acr.setFullName(newname);
		simpleService.updateItem(rootItem, acr);
		AcronymItem ai = (AcronymItem) simpleService.getItem(rootItem, id);
		assert (ai.getFullName().equals(newname));
	}

	public void testSimpleServiceUpdate2() {
		String rootItem = "building";
		int id = 2;
		BuildingItem b = (BuildingItem) simpleService.getItem(rootItem, id);
		String newname = "JoyJoy";
		b.setCommonName(newname);
		simpleService.updateItem(rootItem, b);
		BuildingItem b2 = (BuildingItem) simpleService.getItem(rootItem, id);
		assert (b2.getCommonName().equals(newname));
	}

	public void testSimpleServiceInsert() {
		System.out.println("****Test Acronym Insert");
		String rootItem = "acronym";

		int id = 1;
		AcronymItem acr = new AcronymItem();
		acr.setName("MA2");
		acr.setFullName("My Acronym2");
		acr.setSystemDomainId(1);

		simpleService.insertItem(rootItem, acr);
		int acrloc = acr.getId();
		AcronymItem ai = (AcronymItem) simpleService.getItem(rootItem, acrloc);
		assert (ai.getFullName().equals("My Acronym2"));

	}

	public void testSimpleServiceDelete() {
		String rootItem = "acronym";
		int id = 2;
		NamedItem acr = simpleService.getItem(rootItem, id);
		simpleService.deleteItem(rootItem, acr);
	}


	class SortByName implements SortByType {

		public String getSortByValue() {
		
			return "name";
		}
		
	}
	public void testSystemDomainList(String bypass) {
		System.out.println("System Domain List");
		int parentSystemDomainId=0;
		int start=0;
		int limit=999;
		String sortBy="name";
		boolean isAscending=true;
		//SortByType nameSort= new SortByType("name");
		SortByName sortByName = new SortByName();
		List<SystemDomain> slist= systemDomainDAO.getAll();
		// List<SystemDomain> slist= systemDomainDAO.getSortedSubListBySystemDomainId(parentSystemDomainId, start, limit, sortByName, isAscending);
	    for (SystemDomain s: slist) {
	    	System.out.println(s.getName()+" "/*+s.getParentSystemDomainName()*/+" "+s.getType()+s.getSystemDomainAccess().getDescription());
	    }
	}

}
