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
package org.kuali.continuity.dao;

import java.util.List;
import java.util.Set;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.domain.BaseRefDomainObject;

public class ReferenceDomainObjectDAOTest extends BasePlanTest {
	
	private ReferenceDomainObjectDAOFactory factory;
	
	public void setFactory(ReferenceDomainObjectDAOFactory factory) {
		this.factory = factory;
	}
	
	public void testInjection() throws Exception {
		System.out.println("DAO is " + this.factory.getClass().getName());
	}

	public void testGetReferenceDomainObjectList() throws Exception {
		Set<Class<? extends BaseRefDomainObject>> refClasses = ((ReferenceDomainObjectDAOFactoryImpl)this.factory).getDaoMap().keySet();
		for (Class<? extends BaseRefDomainObject> refClass : refClasses) {
			this.doTestReferenceDomainObject(this.factory.getReferenceDomainObjectDAO(refClass).getReferenceDomainObjects());
		}
	}
	
	private void doTestReferenceDomainObject(List<? extends BaseRefDomainObject> list) throws Exception {
		assertNotNull(list);
		assertFalse(list.isEmpty());
		if (list == null || list.isEmpty()) return;
		System.out.println(list.get(0).getClass().getName());
		for (Object obj : list) {
			System.out.println(
				((BaseRefDomainObject)obj).getId() + 
				": " + 
				((BaseRefDomainObject)obj).getDescription());
		}
		System.out.println();
	}
	
}
