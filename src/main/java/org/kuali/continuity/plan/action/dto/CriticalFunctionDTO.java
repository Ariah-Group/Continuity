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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.domain.Consequence;
import org.kuali.continuity.plan.domain.CriticalFunction;

@SuppressWarnings("serial")
public class CriticalFunctionDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {
	
	public int priority;
	public SystemDomainCriticalityLevelDTO criticalityLevel = new SystemDomainCriticalityLevelDTO();
	public PlanDTO plan = new PlanDTO();
	
	// description
	public String description;
	public String performingUnits;
	public String responsiblePersons;
	
	// peaks
	public boolean[] peaks = new boolean[12];
	public String peaksExplantion;
	
	// consequences
	public Map<String, ConsequenceDTO> consequences = new HashMap<String, ConsequenceDTO>();
	
	// coping methods
	public CopingMethodDTO copingMethod = new CopingMethodDTO();
	
	public CriticalFunctionDTO() {
		super();
	}

	public CriticalFunctionDTO(int id) {
		super(id);
	}
	
	public CriticalFunctionDTO(int id, String name) {
		super(id, name);
	}

	public CriticalFunctionDTO(BaseDomainObject obj) {
		super(obj);
	}

	public CriticalFunctionDTO(CriticalFunction obj) {
		this.copyFromDomainObject(obj);
	}
	
	public CriticalFunction getDomainObject() {
		CriticalFunction criticalFunction = new CriticalFunction(this.id);
		criticalFunction.setName(this.name);
		criticalFunction.setPriority(this.priority);
		if (this.criticalityLevel != null)
			criticalFunction.setCriticalityLevelEnum(CriticalityLevelEnum.getEnum(this.criticalityLevel.levelNo.id));
		
		// descriptions
		criticalFunction.setDescription(this.description);
		criticalFunction.setPerformingUnits(this.performingUnits);
		criticalFunction.setResponsiblePersons(this.responsiblePersons);
		
		// peak periods
		if (this.peaks != null) {
			Set<Integer> peakMonths = new HashSet<Integer>();
			for (int i = 0; i < 12; i++) if (peaks[i]) peakMonths.add(i);
			criticalFunction.setPeakMonths(peakMonths);
		}
		criticalFunction.setPeaksExplanation(this.peaksExplantion);
		
		// consequences
		if (this.consequences != null && !this.consequences.isEmpty()) {
			Consequence.Type[] cTypes = Consequence.Type.values();
			Map<Consequence.Type, Consequence> objConsequences = new HashMap<Consequence.Type, Consequence>();
			for (Consequence.Type cType : cTypes) {
				ConsequenceDTO consequenceDTO = this.consequences.get(cType.name());
				if (consequenceDTO == null) consequenceDTO = new ConsequenceDTO();
				objConsequences.put(cType, consequenceDTO.getConsequence());
			}
			criticalFunction.setConsequences(objConsequences);
		}
		
		// coping methods
		if (this.copingMethod != null) {
			criticalFunction.setCopingMethod(this.copingMethod.getCopingMethod());
		}
		
		// return
		return criticalFunction;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof CriticalFunction)) return;
		CriticalFunction obj = (CriticalFunction) copyObj;
		
		// set other fields
		this.priority = obj.getPriority();
		this.criticalityLevel = new SystemDomainCriticalityLevelDTO(obj.getCriticalityLevelEnum());
		
		// descriptions
		this.description = obj.getDescription();
		this.performingUnits = obj.getPerformingUnits();
		this.responsiblePersons = obj.getResponsiblePersons();
		
		// peak periods
		Set<Integer> objPeakMonths = obj.getPeakMonths();
		for (Integer mon : objPeakMonths) {
			this.peaks[mon] = true;
		}
		this.peaksExplantion = obj.getPeaksExplanation();
		
		// consequences
		Consequence.Type[] cTypes = Consequence.Type.values();
		Map<Consequence.Type, Consequence> objConsequences = obj.getConsequences();
		for (Consequence.Type cType : cTypes) {
			ConsequenceDTO consequenceDTO = new ConsequenceDTO();
			Consequence objConsequence = objConsequences.get(cType);
			if (objConsequence != null) {
				consequenceDTO.isMayOccur = objConsequence.isMayOccur();
				consequenceDTO.explanation = objConsequence.getExplanation();
			}
			this.consequences.put(cType.name(), consequenceDTO);
		}
		
		// coping methods
		this.copingMethod = new CopingMethodDTO(obj.getCopingMethod());
	}
}
