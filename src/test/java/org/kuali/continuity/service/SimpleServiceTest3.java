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

import javax.servlet.ServletContext;

import org.kuali.continuity.admin.dao.AdminDAOTest;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.admin.main.client.SimpleService;
import org.kuali.continuity.plan.dao.ContinuityPlanDAO;

public class SimpleServiceTest3 extends AdminDAOTest {
	
	public enum NamedItemType {
//	    application,
	    acronym,
	    building,
//	    contact,
//	    function,
//	    knowledge,
	    dependency,
	    faq,
	    division,
	    location,
//	    plannerscategory,
//	    reference,
//	    review,
	    setting,
//		shift,
	    skill,
//	    staffcategory,
//	    type,
//	    user,
//	    utility}
	}

	private SimpleService simpleService;
	
	public void testInjection() {
		System.out.println("OK " + simpleService.getClass().getName());
	}

	public void setSimpleService(SimpleService simpleService) {
		this.simpleService = simpleService;
	}
	ContinuityPlanDAO continuityPlanDAO;
	
	public void setContinuityPlanDAO(ContinuityPlanDAO continuityPlanDAO) {
		this.continuityPlanDAO = continuityPlanDAO;
	}
	
	
	public ServletContext setServletContext() {

		ServletContext sc;
		
		return null;
	}
	@SuppressWarnings("unchecked")
//	public void testGetItems() {
//		ListService listService = (ListService) simpleService;
//		NamedItemType[] types = NamedItemType.values();
//		for (NamedItemType namedItemType : types) {
//			System.out.println(namedItemType.name() + " --------------- ");
//			
//			List<NamedItem> list = (List<NamedItem>) listService.getSortedList(namedItemType.name(), 0, "name", 0, "ASC", 1);
//			this.doTestNamedItemList(list);
//		}
//	}
	public void testDAO() { 
		List plans = continuityPlanDAO.getSimpleListByOwnerId(1);

		System.out.println(plans.size());
		if (plans.size()>0) {
			Object [] p = (Object[]) plans.get(0);
			for (Object p0:p) {
				System.out.print(p0.toString()+" ");
			}
			System.out.println();
			
			
		}
		    
	}
	protected void doTestNamedItemList(List<NamedItem> list) {
		assertFalse(list == null || list.isEmpty());
		for (NamedItem namedItem : list) {
			System.out.println(namedItem.getId() + ": " + namedItem.getName());
		}
		System.out.println();
	}

}
