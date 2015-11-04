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

import java.util.Map;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.InstructionUITextEnum;
import org.kuali.continuity.domain.UITextEnum;

public class SystemDomainUITextDAOTest extends BasePlanTest {
	
	private SystemDomainUITextDAO dao;
	
	public void setDao(SystemDomainUITextDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCreate() {
		String test = "TEST CREATE";
		this.dao.create(PlanTestData.wellknown_institution, InstructionUITextEnum.INSTR_COURSE_MGMT_TOOL, test);
		String text = this.dao.getTextByOwnerIdAndTextEnum(PlanTestData.wellknown_institution, InstructionUITextEnum.INSTR_COURSE_MGMT_TOOL);
		assertEquals(test, text);
	}
	
	public void testUpdate() {
		String test = "TEST UPDATE";
		this.dao.update(PlanTestData.wellknown_institution, InstructionUITextEnum.INSTR_COURSE_MGMT_TOOL, test);
		String text = this.dao.getTextByOwnerIdAndTextEnum(PlanTestData.wellknown_institution, InstructionUITextEnum.INSTR_COURSE_MGMT_TOOL);
		assertEquals(test, text);
	}
	
	public void testGetTextByOwnerIdAndTextEnum() {
		String text = this.dao.getTextByOwnerIdAndTextEnum(PlanTestData.wellknown_institution, InstructionUITextEnum.INSTR_COURSE_MGMT_TOOL);
		assertEquals("bSpace", text);
	}
	
	public void testGetByOwnerId() {
		Map<UITextEnum, String> texts = this.dao.getByOwnerId(PlanTestData.wellknown_institution);
		assertNotNull(texts);
		assertFalse(texts.isEmpty());
	}
}
