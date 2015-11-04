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

import org.kuali.continuity.action.BaseAction;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.plan.action.dto.PlanDTO;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

public class GetBasePlansAction extends BaseAction {
	
	// service
	private ContinuityPlanService continuityPlanService;
	
	// converter
	private DomainObject2DTOConverter do2dtoConverter;
	
	// beans
	private List<PlanDTO> cPlans = new ArrayList<PlanDTO>();
	private List<PlanDTO> nPlans = new ArrayList<PlanDTO>();
	
	public GetBasePlansAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		int systemDomainId = this.getSessionSystemDomain().id;
		List<BaseContinuityPlan> cSvcPlans = 
			this.continuityPlanService.getBaseContinuityPlanList(
				systemDomainId, PlanStatusEnum.COMPLETE.getRefDomainObject(),
				BaseContinuityPlan.SortBy.acronymPlusName, true);
		List<BaseContinuityPlan> nSvcPlans = 
			this.continuityPlanService.getBaseContinuityPlanList(
				systemDomainId, PlanStatusEnum.IN_PROGRESS.getRefDomainObject(),
				BaseContinuityPlan.SortBy.acronymPlusName, true);
		this.cPlans = (List<PlanDTO>)
			this.do2dtoConverter.getDomainObjectDTOList(cSvcPlans);
		this.nPlans = (List<PlanDTO>)
			this.do2dtoConverter.getDomainObjectDTOList(nSvcPlans);
		return SUCCESS;
	}

	public List<PlanDTO> getCPlans() {
		return this.cPlans;
	}

	public void setCPlans(List<PlanDTO> plans) {
		cPlans = plans;
	}

	public List<PlanDTO> getNPlans() {
		return this.nPlans;
	}

	public void setNPlans(List<PlanDTO> plans) {
		nPlans = plans;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public void prepare() throws Exception {

	}

}
