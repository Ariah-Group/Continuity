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

public class SimpleServiceTest2 extends AdminDAOTest {

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

	public void testSetAcronym(int x) {
		System.out.println("**Acronym:");
		AcronymItem ac = new AcronymItem();
		ac.setName("UC");
		ac.setFullName("University of California");
        simpleService.insertItem("acronym",ac);
		System.out.println(" Done with insert");
		AcronymItem ac2 = new AcronymItem();
		ac2.setId(2);
		ac2.setSystemDomainId(1);
		ac2.setName("SOM");
		ac2.setFullName("School of Mars");
		simpleService.updateItem("acronym", ac2);
		
		
	}
	
	public void testSetting(int x) {
		System.out.println("**Setting:");
		SettingItem si = (SettingItem) simpleService.getItem("setting", 7);
		System.out.println(si.getLocation());
		System.out.println(si.getSublocation());
		System.out.println(si.getAccess());
		for (int i = 0; i < 4; i++) {
			System.out.print(si.getOptions()[i]);
		}
		System.out.println("");
	}
	public void testBuilding(int x) {
		System.out.println("**Building:");
		BuildingItem bi = (BuildingItem) simpleService.getItem("building", 2);
		
		System.out.println(bi.getName()+" "+bi.getCommonName()+ bi.getCaan()+ bi.getAddress());
		bi.setCommonName("New Building");
		simpleService.updateItem("building", bi);
		
	}
    public void testParse(int x) {
    	String unparsed="567,432,15";
    	String [] a = unparsed.split(",");
    	System.out.println(a[2]);
    }
    public void testExample(int x) {
    	System.out.println("**Critical Function");
    	NamedItem fi = (NamedItem) simpleService.getItem("function",7);
    	System.out.println(fi.getName());
    	
    }

	

	public void testLocation() {
		System.out.println("Location List");
		List<LocationItem> llist = ((ListService) simpleService).getSortedList(
				"location", 0, "name", -1, "ASC", 1);
		for (LocationItem loc : llist) {
			System.out.println(loc.getParentSystemDomainName() + ":"
					+ loc.getName() + ":" + loc.getTypestr() + ":"
					+ loc.getAccess()+":"+ loc.getAccessstr());
		}
		int key = ((LocationItem) llist.get(0)).getId();
		LocationItem lf=(LocationItem) simpleService.getItem("location", key);
		System.out.println("Got Id: "+lf.getId());
		LocationItem li = new LocationItem();
		li.setAccess(lf.getAccess());
		li.setId(lf.getId());
		li.setParentSystemDomainName(lf.getParentSystemDomainName());
		li.setName(lf.getName());
		li.setTypestr(li.getTypestr());
		simpleService.updateItem("location", (NamedItem) li);
		
		LocationItem li2 = new LocationItem();
		li2.setId(91);
		li2.setName("CyberCampus");
		li2.setTypestr("Member");
		li2.setAuthId(1);
		li2.setAccess("2");
		simpleService.updateItem("location", (NamedItem) li2);
		
	}
	public void testFunction() {
		String [][] planList = simpleService.getStringArray("plan", 1);
		String fnlist="120,220,320";
		NamedItem function = simpleService.getItem("function", 7);
		function.setName(function.getName()+",30");
		//function.setName(fnlist);
		simpleService.updateItem("function", (NamedItem) function);
		NamedItem function2 = simpleService.getItem("function", 7);
		System.out.println(function2.getName());
		
		
		
	}

}
