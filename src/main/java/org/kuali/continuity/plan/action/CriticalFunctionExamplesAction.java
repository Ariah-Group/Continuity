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
package org.kuali.continuity.plan.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.kuali.continuity.admin.domain.CriticalFunctionExample;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CriticalFunctionCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.PlanDTO;
import org.kuali.continuity.plan.action.dto.SystemDomainCriticalityLevelDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.ContinuityPlanService;
import org.kuali.continuity.plan.service.CriticalFunctionService;

public class CriticalFunctionExamplesAction extends BasePlanAction {
	
	// services
	private ContinuityPlanService planService;
	private CriticalFunctionService criticalFunctionService;
	private GenericAdminService genericAdminService;
	private SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;
	private SortedMap<CriticalityLevelEnum, SystemDomainCriticalityLevelDTO> criticalityLevels = 
		new TreeMap<CriticalityLevelEnum, SystemDomainCriticalityLevelDTO>();
	
	// bean
	private List<CFExampleDTO> examples = new ArrayList<CFExampleDTO>();
	
	public CriticalFunctionExamplesAction(
			ContinuityPlanService planService,
			CriticalFunctionService criticalFunctionService, 
			GenericAdminService genericAdminService,
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		this.planService = planService;
		this.criticalFunctionService = criticalFunctionService;
		this.genericAdminService = genericAdminService;
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
	}
	
	public List<CFExampleDTO> getExamples() {
		return this.examples;
	}

	public void setExamples(List<CFExampleDTO> examples) {
		this.examples = examples;
	}
	
	public void prepare() throws Exception {
		super.prepare();
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> levelMap = this.systemDomainCriticalityLevelService.getListByOwnerId(
			SystemDomainCriticalFunctionCriticalityLevel.class, 
			this.getSessionSystemDomain().id);
		Set<CriticalityLevelEnum> levelKeys = levelMap.keySet();
		for (CriticalityLevelEnum levelKey : levelKeys) {
			this.criticalityLevels.put(levelKey, new SystemDomainCriticalityLevelDTO((CriticalFunctionCriticalityLevel)levelMap.get(levelKey)));
		}
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// init
		this.examples = new ArrayList<CFExampleDTO>();
		
		List<CriticalFunctionExample> egs = (List<CriticalFunctionExample>)
			this.genericAdminService.getListBySystemDomainId(CriticalFunctionExample.class, this.getSessionSystemDomain().id);
		
		if (egs == null) return SUCCESS;
			
		// iterate thru examples
		for (CriticalFunctionExample criticalFunctionExample : egs) {

			String planList = criticalFunctionExample.getPlans();
			if (planList == null || planList.trim().length() == 0) continue;

			// iterate thru plans
			StringTokenizer tzer = new StringTokenizer(planList, ",");
			while (tzer.hasMoreElements()) {
				int planId = Integer.parseInt(tzer.nextToken());

				// get plan
				ContinuityPlan plan = this.planService.getContinuityPlan(planId);
				if (plan == null) continue;
				String planName = plan.getAcronymPlusName();
				
				// get critical functions
				List<CriticalFunction> cfs = this.criticalFunctionService.getCriticalFunctionList(planId);
				if (cfs == null || cfs.isEmpty()) continue;

				List<CriticalFunctionDTO> cfDTOs = new ArrayList<CriticalFunctionDTO>();
				for (CriticalFunction criticalFunction : cfs) {
					int cfId = criticalFunction.getId();
					String cfName = criticalFunction.getName();
					SystemDomainCriticalityLevelDTO cfLevel = new SystemDomainCriticalityLevelDTO();
					if (criticalFunction.getCriticalityLevelEnum() != null)
						cfLevel = this.criticalityLevels.get(criticalFunction.getCriticalityLevelEnum());
					
					// init cf dto
					CriticalFunctionDTO cfDTO = new CriticalFunctionDTO();
					cfDTO.id = cfId;
					cfDTO.name = cfName;
					cfDTO.criticalityLevel = cfLevel;
					
					// add cf dto
					cfDTOs.add(cfDTO);
				}
				
				// init plan dto
				PlanDTO planDTO = new PlanDTO();
				planDTO.id = planId;
				planDTO.name = planName;
				
				// init cfExample dto
				CFExampleDTO egDTO = new CFExampleDTO();
				egDTO.plan = planDTO;
				egDTO.criticalFunctions = cfDTOs;
				
				// add to examples
				this.examples.add(egDTO);
			}
				
		}

		return SUCCESS;
	}
	
	public class CFExampleDTO {
		public PlanDTO plan;
		public List<CriticalFunctionDTO> criticalFunctions;
	}

}
