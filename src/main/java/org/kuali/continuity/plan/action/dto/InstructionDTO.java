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
package org.kuali.continuity.plan.action.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.AllCoursesPractice;
import org.kuali.continuity.plan.domain.DepartmentalPractice;
import org.kuali.continuity.plan.domain.Instruction;

@SuppressWarnings("serial")
public class InstructionDTO extends DomainObjectDTO  implements DomainObjectValue, DTOValue {
	
	public PlanDTO plan = new PlanDTO();
	public DomainObjectDTO instructionalDepartment = new DomainObjectDTO();
	public Map<String, AllCoursesPracticeDTO> allCoursesPractices = new HashMap<String, AllCoursesPracticeDTO>();
	public Map<String, DepartmentalPracticeDTO> departmentalPractices = new HashMap<String, DepartmentalPracticeDTO>();
	
	public InstructionDTO() {
		super();
	}
	
	public InstructionDTO(BaseDomainObject obj) {
		super(obj);
	}
	
	public InstructionDTO(int id, String name) {
		super(id, name);
	}
	
	public InstructionDTO(int id) {
		super(id);
	}
	
	public InstructionDTO(Instruction dObj) {
		this.copyFromDomainObject(dObj);
	}

	@Override
	public Instruction getDomainObject() {
		Instruction obj = new Instruction();
		obj.setId(this.id);
		obj.setName(this.name);

		if (this.plan != null && this.plan.id != 0)
			obj.setPlan(plan.getDomainObject());
		if (this.instructionalDepartment != null && this.instructionalDepartment.id != 0)
			obj.setDepartment(new InstructionalDepartment(this.instructionalDepartment.id));
		
		// practices
		if (this.allCoursesPractices != null && !this.allCoursesPractices.isEmpty()) {
			AllCoursesPractice.Type[] pTypes = AllCoursesPractice.Type.values();
			Map<AllCoursesPractice.Type, AllCoursesPractice> pMap = new HashMap<AllCoursesPractice.Type, AllCoursesPractice>();
			for (AllCoursesPractice.Type pType : pTypes) {
				AllCoursesPracticeDTO dto = this.allCoursesPractices.get(pType.name());
				if (dto == null) continue;
				pMap.put(pType, dto.getPractice());
			}
			obj.setAllCoursesPractices(pMap);
			
		}
		if (this.departmentalPractices != null && !this.departmentalPractices.isEmpty()) {
			DepartmentalPractice.Type[] pTypes = DepartmentalPractice.Type.values();
			Map<DepartmentalPractice.Type, DepartmentalPractice> pMap = new HashMap<DepartmentalPractice.Type, DepartmentalPractice>();
			for (DepartmentalPractice.Type pType : pTypes) {
				DepartmentalPracticeDTO dto = this.departmentalPractices.get(pType.name());
				if (dto == null) continue;
				pMap.put(pType, dto.getPractice());
			}
			obj.setDepartmentalPractices(pMap);
		}
			
		// return
		return obj;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof Instruction)) return;
		Instruction obj = (Instruction) copyObj;
		
		// set other fields
		this.instructionalDepartment = new DomainObjectDTO(obj.getDepartment());
		Map<AllCoursesPractice.Type, AllCoursesPractice> apMap = obj.getAllCoursesPractices();
		if (apMap != null && !apMap.isEmpty()) {
			Set<AllCoursesPractice.Type> keys = apMap.keySet();
			for (AllCoursesPractice.Type key : keys) {
				this.allCoursesPractices.put(key.name(), new AllCoursesPracticeDTO(apMap.get(key)));
			}
		}
		Map<DepartmentalPractice.Type, DepartmentalPractice> dpMap = obj.getDepartmentalPractices();
		if (dpMap != null && !dpMap.isEmpty()) {
			Set<DepartmentalPractice.Type> keys = dpMap.keySet();
			for (DepartmentalPractice.Type key : keys) {
				this.departmentalPractices.put(key.name(), new DepartmentalPracticeDTO(dpMap.get(key)));
			}
		}
	}

}
