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
package org.kuali.continuity;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.domain.OrderedType;
import org.kuali.continuity.domain.SortByType;

public class DomainObjectTest extends BasePlanTest {

	protected void doTestList(Collection<? extends BaseDomainObject> list) throws Exception {
		assertNotNull(list);
		assertFalse(list.isEmpty());
		if (list == null || list.isEmpty()) return;
		this.printDomainObjectList(list);		
	}
	
	@SuppressWarnings("unchecked")
	protected void doTestMap(Map map) throws Exception {
		assertNotNull(map);
		assertFalse(map.isEmpty());
		if (map == null || map.isEmpty()) return;
		this.printDomainObjectMap(map);
	}
	
	protected void doTestSortedList(List<? extends BaseDomainObject> list, SortByType sortBy, boolean isAscending)
		throws Exception {
		this.doTestList(list);
		if (list == null || list.isEmpty() || list.size() < 2) return;
		if (sortBy.getSortByValue().equals("id")) {
			if (isAscending)
				assertTrue(list.get(1).getId() > list.get(0).getId());
			else
				assertFalse(list.get(1).getId() > list.get(0).getId());
		} else if (sortBy.getSortByValue().equals("name")) {
			if (isAscending)
				assertTrue(list.get(1).getName().compareToIgnoreCase(list.get(0).getName()) >= 0);
			else
				assertFalse(list.get(1).getName().compareToIgnoreCase(list.get(0).getName()) > 0);
		}
	}
	
	protected void doTestLimitedList(List<? extends BaseDomainObject> list, int limit) 
		throws Exception {
		this.doTestList(list);
		if (list == null || list.isEmpty()) return;
		assertFalse(list.size() > limit);
	}
	
	protected void doTestSortedLimitedList(List<? extends BaseDomainObject> list, int limit, SortByType sortBy, boolean isAscending) 
		throws Exception {
		this.doTestSortedList(list, sortBy, isAscending);
		assertFalse(list.size() > limit);
	}
	
	@SuppressWarnings("unchecked")
	protected void printDomainObjectMap(Map map) {
		Set keys = map.keySet();
		for (Object key : keys) {
			System.out.print("Key: ");
			if (key instanceof BaseDomainObject)
				this.printDomainObject((BaseDomainObject) key);
			else if (key instanceof BaseRefDomainObject)
				this.printRefDomainObject((BaseRefDomainObject) key); 
			else
				System.out.print(key);
			System.out.print(" --- Value: ");
			Object value = map.get(key);
			if (value instanceof BaseDomainObject)
				this.printDomainObject((BaseDomainObject) value);
			else if (value instanceof BaseRefDomainObject)
				this.printRefDomainObject((BaseRefDomainObject) value); 
			else
				System.out.println(value);
		}
		System.out.println();
	}

	protected void printDomainObjectList(Collection<? extends BaseDomainObject> list) {
		for (BaseDomainObject dObj : list) {
			this.printDomainObject(dObj);
		}
		System.out.println();
	}
	
	protected void printDomainObject(BaseDomainObject dObj) {
		if (dObj == null) {System.out.println("[null]"); return;}
		System.out.print("[" + new StringTokenizer(dObj.getClass().getSimpleName(), "$$").nextToken() + "]  ");
		if (dObj instanceof OrderedType)
			System.out.print("#" + ((OrderedType) dObj).getOrderNo() + " - ");
		System.out.println(dObj.getId() + ": " + dObj.getName());
	}

	protected void printRefDomainObject(BaseRefDomainObject dObj) {
		if (dObj == null) {System.out.println("[null]"); return;}
		System.out.print("[" + new StringTokenizer(dObj.getClass().getSimpleName(), "$$").nextToken() + "]  ");
		System.out.println(dObj.getId() + ": " + dObj.getDescription());
	}

	protected String getRandomTestString() {
		return "Test" + Math.round(Math.random()*100000);
	}
	
}
