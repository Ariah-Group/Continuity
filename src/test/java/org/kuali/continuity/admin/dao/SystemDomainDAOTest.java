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
package org.kuali.continuity.admin.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainSettings;
import org.kuali.continuity.admin.domain.SystemDomain.SortBy;
import org.kuali.continuity.domain.SystemDomainAccess;

public class SystemDomainDAOTest extends AdminDAOTest {
	
	private SystemDomainDAO dao;
	
	public void setSystemDomainDAO(SystemDomainDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}
		
	public void testGetListSize() throws Exception {
		long size = this.dao.getListByGroupSize("UC");
		assertTrue(size > 0L);
	}
	
	public void testGetList() throws Exception {
		this.doTestList(this.dao.getListByGroup("UC"));
	}
	
	public void testGetSortedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedList(this.dao.getSortedListByGroup("UC", SortBy.name, true),  SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedList(this.dao.getSortedListByGroup("UC", SortBy.name, false), SortBy.name, false);
	}
	
	public void testGetLimitedList() throws Exception {
		System.out.println("first Three");
		this.doTestLimitedList(this.dao.getSubListByGroup("UC", 0, 3), 3);
	}

	public void testGetSortedLimitedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedLimitedList(this.dao.getSortedSubListByGroup("UC", 0, 3, SortBy.name, true),  3, SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedLimitedList(this.dao.getSortedSubListByGroup("UC", 0, 3, SortBy.name, false), 3, SortBy.name, false);
	}
	
	public void testGetByGroupAndName() throws Exception {
		assertNotNull(this.dao.getByGroupAndName("", "UC Berkeley"));
	}
	
	public void testGetListByShibIDP() throws Exception {
		List<SystemDomain> list = this.dao.getListByShibIDP("urn:mace:incommon:ucdavis.edu");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertTrue(list.size() > 1);
	}
	
	public void testGetListByShibIDPAuthTypeBerkeley() throws Exception {
		List<SystemDomain> list = this.dao.getShibListByIDPAuthType("https://shib-test.berkeley.edu/idp/shibboleth");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
	}
	
	public void testGetListByShibIDPAuthTypeUCI() throws Exception {
		List<SystemDomain> list = this.dao.getShibListByIDPAuthType("urn:mace:incommon:uci.edu");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 2);
	}
	
	public void testGetListByCustomUrlBerkeley() throws Exception {
		List<SystemDomain> list = this.dao.getListByCustomUrl("berkeley");
		assertNotNull(list);
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
	}
	
	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestUpdateDomains();
		this.doTestDelete();
	}
	
	private void doTestCreate() throws Exception {
		SystemDomain dObj = new SystemDomain();
		dObj.setName("TEST");
		dObj.setShibIDP("TEST");
		dObj.setEmail("TEST");
		dObj.setFax("TEST");
		dObj.setLBNL(true);
		dObj.setName("TEST");
		dObj.setPhone("TEST");
		dObj.setSettings(new SystemDomainSettings());
		dObj.setShibMode(false);
		dObj.setCustomUrl("TEST");
		dObj.setShibUniqueId("TEST");
		
		// set institution
		dObj.setSystemDomainGroup("UC");
		
		// set domains
		Set<String> domains = new HashSet<String>();
		domains.add("berkeley.edu");
		domains.add("webapps.berkeley.edu");
		dObj.setNetDomains(domains);
		
		// TODO: retrieve from database?
		SystemDomainAccess systemDomainAccess = new SystemDomainAccess();
		systemDomainAccess.setId("0");
		dObj.setSystemDomainAccess(systemDomainAccess);
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
		assertTrue(dObj.isPartialModeratedAccess());
		System.out.println("New System Domain: " + dObj.getId());
	}
	public  void testMinCreate() throws Exception {
		SystemDomain dObj = new SystemDomain();
		dObj.setName("TEST");
		dObj.setShibIDP("");
		dObj.setEmail("");
		dObj.setFax("");
		dObj.setPhone("");
		
		dObj.setLBNL(false);

		
		dObj.setSettings(new SystemDomainSettings());
		dObj.setShibMode(false);
		
		// set institution
		dObj.setSystemDomainGroup("UC");
		
		// set domains
		Set<String> domains = new HashSet<String>();
//		domains.add("berkeley.edu");
//		domains.add("webapps.berkeley.edu");
		dObj.setNetDomains(domains);
		
		// TODO: retrieve from database?
		SystemDomainAccess systemDomainAccess = new SystemDomainAccess();
		systemDomainAccess.setId("0");
		dObj.setSystemDomainAccess(systemDomainAccess);
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
		assertTrue(dObj.isPartialModeratedAccess());
		System.out.println("New System Domain: " + dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		SystemDomain dObj = this.getLatest();
		SystemDomain dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
		assertFalse(dSameObj.getNetDomains().isEmpty());
		assertEquals(2, dObj.getNetDomains().size());
	}
	
	private void doTestUpdateDomains() throws Exception {
		SystemDomain dObj = this.getLatest();

		// new domains
		Set<String> domains = new HashSet<String>();
//		domains.add("test.edu");
//		domains.add("webapps.test.edu");
//		domains.add("apps.test.edu");
		
		// update domains
		this.dao.update(dObj.getId(), domains);

		// test
		SystemDomain modObj = this.dao.getById(dObj.getId());
		assertTrue(modObj.getNetDomains().isEmpty());
	}
	
	private void doTestUpdate() throws Exception {
		SystemDomain dObj = this.getLatest();
		String modName = dObj.getName() + "-Modified";
		dObj.setName(modName);
		dObj.setSystemDomainGroup("UCModified");
		
		// update
		this.dao.update(dObj);
		
		// test
		SystemDomain modObj = this.dao.getById(dObj.getId());
		assertEquals(modName, modObj.getName());
	}
	
	private void doTestDelete() throws Exception {
		SystemDomain dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		SystemDomain nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private SystemDomain getLatest() throws Exception {
		List<SystemDomain> dObjs = this.dao.getAll(SortBy.id, false);
		return dObjs.get(0);
	}


	public void testDemo() {
		SystemDomain sd1 = this.dao.getById(1);
		assertNotNull(sd1);
		assertTrue(!sd1.isDemo());
		SystemDomain sd2 = this.dao.getById(186);
		assertNotNull(sd2);
		assertTrue(sd2.isDemo());
	}

}
