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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

import com.opensymphony.xwork2.Action;

public class GetAdminPlansAction implements Action {

	private int systemDomainId;
	private Map<String, Object> jsonModel;
	private ContinuityPlanService continuityPlanService;
	private final static String PLANS = "plans";
	private final static String SIZE = PLANS+"-size";
	
	public GetAdminPlansAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}
	
	public int getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	public Map<String, Object> getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Map<String, Object> jsonModel) {
		this.jsonModel = jsonModel;
	}

	public String execute() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<DomainObjectDTO> planDTOs = new ArrayList<DomainObjectDTO>();
		List<ContinuityPlan> plans = this.continuityPlanService.getContinuityPlanList(this.getSystemDomainId());
		if (plans != null) {
			for (ContinuityPlan continuityPlan : plans) {
				planDTOs.add(new DomainObjectDTO(continuityPlan));
			}
		}
		model.put(PLANS, planDTOs);
		model.put(SIZE, "" + (plans == null ? 0 : plans.size()));
		this.setJsonModel(model);
		return SUCCESS;
	}

}
