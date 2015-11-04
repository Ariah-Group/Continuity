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

import java.util.Map;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.domain.UITextEnum;

public class SystemUITextDAOTest extends BasePlanTest {
	
	private SystemUITextDAO dao;
	
	public void setDAO(SystemUITextDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testGetSystemUITexts() throws Exception {
		Map<UITextEnum, String> uiTextMap = this.dao.getSystemUITexts();
		assertNotNull(uiTextMap);
		assertFalse(uiTextMap.isEmpty());
	}
}
