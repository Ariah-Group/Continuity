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

import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.dao.AdminDAOTest;
import org.kuali.continuity.admin.dao.CentralApplicationDAO;
import org.kuali.continuity.admin.dao.OrderingDef.SortBy;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;

public class OrderingServiceTest extends AdminDAOTest {
	
	private OrderingService orderingService;
	
    private CentralApplicationDAO centralApplicationDAO;
    
    private ItemService itemService;
    public static String barely_known_application="";
    public static int barely_known_id=0;
    public static int barely_known_order=0;
    
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	public void setOrderingService(OrderingService orderingService) {
		this.orderingService = orderingService;
	}
	
	private CentralApplication getLatest() throws Exception {
		List<CentralApplication> dObjs = this.centralApplicationDAO.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.id, false);
		return dObjs.get(0);
	}
	public void testDao() {
		CentralApplication dObj = centralApplicationDAO.getBySystemDomainIdAndOrderNo(PlanTestData.wellknown_institution, 1);
		assertNotNull(dObj);
		
		CentralApplication dObj2 = centralApplicationDAO.getBySystemDomainIdAndOrderNo(PlanTestData.wellknown_institution, 3);
		this.barely_known_application=dObj.getName();
		this.barely_known_id=dObj.getId();
		this.barely_known_order=dObj.getOrderNo();
	}
    public void testVerifyTest() {
    	   assert(barely_known_application.length()>0);
    	
    }
	public void setCentralApplicationDAO(CentralApplicationDAO centralApplicationDAO) {
		this.centralApplicationDAO = centralApplicationDAO;
	}

	protected Item setupTestApplication() {
		Item item= new Item();  // ItemService passes an Item down to the OrderingService.
        
        item.setId(barely_known_id);
        System.out.println("Id is: "+item.getId());
        System.out.println("System Domain: "+item.getSystemDomainId());
        item.setName(barely_known_application);
        item.setOrderNo(PlanTestData.known_application_order);
        item.setSystemDomainId(PlanTestData.wellknown_institution);

        return item;
	}
	protected Item setupTestApplication2() {
		Item item= new Item();  // ItemService passes an Item down to the OrderingService.
        
        item.setId(barely_known_id);
        System.out.println("Id is: "+item.getId());
        System.out.println("System Domain: "+item.getSystemDomainId());
        item.setName(barely_known_application);
        item.setOrderNo(barely_known_order);
        item.setSystemDomainId(PlanTestData.wellknown_institution);

        return item;
	}
	public void testUpdateOrder()  {
        System.out.println("Start Update Test");
        Item item = setupTestApplication();
        int thisid=item.getId();
        
        int location= item.getSystemDomainId();
        System.out.println("Location is: "+location);
        
        item.setOrder(3);
        String itemRoot="application";
        checkList(itemRoot, location);
        orderingService.update(itemRoot, location, item);
        Item updateditem= itemService.getItem("application", ""+thisid);
        System.out.println("New order: "+updateditem.getOrderNo());
        
        checkList(itemRoot, location);
        this.assertEquals(3,updateditem.getOrderNo());
        
        
	}
	public void testUpdateData()  {
        System.out.println("Start Update Test");
        Item item = setupTestApplication2();
        int thisid=item.getId();
        item.setName("New Name");
        int location= item.getSystemDomainId();
        System.out.println("Order is: "+item.getOrder());
        orderingService.update("application", location, item);
        // orderingService.update("application", location, item);
        CentralApplication  updateditem= centralApplicationDAO.getById(thisid);
        System.out.println("New order: "+updateditem.getOrderNo());
        System.out.println("New Name: "+updateditem.getName());
        this.assertEquals("New Name",updateditem.getName());
        
	}
	public void testChangeBoth()  {
        System.out.println("Start Update Test");
        Item item = setupTestApplication();
        int thisid=item.getId();
        item.setName("New Name");
        int location= item.getSystemDomainId();
        System.out.println("Order is: "+item.getOrder());
        orderingService.update("application", location, item);
        // orderingService.update("application", location, item);
        CentralApplication  updateditem= centralApplicationDAO.getById(thisid);
        System.out.println("New order: "+updateditem.getOrderNo());
        System.out.println("New Name: "+updateditem.getName());
        this.assertEquals("New Name",updateditem.getName());
        
	}
	public void testInsert() {
		String itemRoot="application";
		int location=1;
		checkList(itemRoot, location);
        Item item= new Item();
        item.setName("new application");
        item.setOrder(3);
        
        orderingService.insert(itemRoot, location, item);
        CentralApplication ca = centralApplicationDAO.getBySystemDomainIdAndName(PlanTestData.wellknown_institution, "new application");
       // Item i2 = itemService.getItem(itemRoot, ""+ca.getId());
        this.assertEquals(3, ca.getOrderNo());
        checkList(itemRoot, location);
       
        
	}
	public void checkList(String itemRoot, int location) {
		List<CentralApplication> list = centralApplicationDAO.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.orderNo, true);
		int prevOrd=0; 
		int nerrs=0;
		String erris="";
		int errat=0;
		for (CentralApplication i : list) {
	    	 System.out.println(""+i.getOrderNo()+" "+i.getName());
	    	 int thisOrd=i.getOrderNo();
	    	 if (thisOrd==prevOrd) {
	    		 System.out.println ("Error duplicate.");
	    		 System.out.println("*******************");
	    		 erris="duplicate";
	    		 errat=thisOrd;
	    		 nerrs++;
	    		 break;
	    	 }
	    	 if (thisOrd-1!=prevOrd) {
	    		 System.out.println ("Error gap.");
	    		 System.out.println("*******************");
	    		 erris="gap";
	    		 errat=thisOrd;
	    		 nerrs++;
	    		 break;
	    	 }
	    	 prevOrd=thisOrd;
	    	 
	     }
		if (nerrs>0) {
			System.out.println("FAILURE AT: "+errat+" is "+erris);
			this.fail();
			
		}
	}
	public void testDelete2(int x) throws Exception {

		// delete
		this.centralApplicationDAO.delete(26);
		System.out.println("Using: " + centralApplicationDAO.getClass().getName());
		
		CentralApplication nullObj = this.centralApplicationDAO.getById(26);
		assertNull(nullObj);
	}
	public void testDelete(int x) {
		Item item = new Item();
		item.setOrder(1);
		item.setId(26);
		int location=1;
		
		 orderingService.delete("application", location, item);
		
	}
}

