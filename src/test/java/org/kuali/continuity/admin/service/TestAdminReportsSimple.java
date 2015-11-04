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

package org.kuali.continuity.admin.service;

import junit.framework.TestCase;

import org.kuali.continuity.admin.service.AdminReport;


public class TestAdminReportsSimple extends TestCase {
	public void testSortLoad() {
		 String p1="Label 1 part 1, Label 1 part 2:TSA.sort1, sort2`Label 2 part 1, label 2 part 2:sort2, sort1";
		 AdminReport a = new AdminReport("a","b","c");
		 a.loadSortMap(a.splitup(p1));
		 String p2="Upstream Dept, Subject Dept:TCF.name,dependency'Subject Dept, Upstream Dept:dependency,TCF.name'Criticality Level, Subject Dept:TCF.criticalitylevel,TCF.name";
		 a.loadSortMap(a.splitup(p2));
			

		 
	}

}
