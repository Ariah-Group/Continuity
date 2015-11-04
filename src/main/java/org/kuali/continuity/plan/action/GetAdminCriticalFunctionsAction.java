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
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.CriticalFunctionService;

import com.opensymphony.xwork2.Action;

public class GetAdminCriticalFunctionsAction implements Action {

	private int planId;
	private Map<String, Object> jsonModel;
	private CriticalFunctionService criticalFunctionService;
	private final static String CRITICAL_FUNCTIONS = "criticalFunctions";
	private final static String SIZE = CRITICAL_FUNCTIONS+"-size";
	
	public GetAdminCriticalFunctionsAction(CriticalFunctionService criticalFunctionService) {
		this.criticalFunctionService = criticalFunctionService;
	}
	
	public Map<String, Object> getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Map<String, Object> jsonModel) {
		this.jsonModel = jsonModel;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String execute() {
		Map<String, Object> model = new HashMap<String, Object>();
		List<DomainObjectDTO> cfDTOs = new ArrayList<DomainObjectDTO>();
		List<CriticalFunction> cfs = this.criticalFunctionService.getCriticalFunctionList(this.getPlanId());
		if (cfs != null) {
			for (CriticalFunction cf : cfs) {
				cfDTOs.add(new DomainObjectDTO(cf));
			}
		}
		model.put(CRITICAL_FUNCTIONS, cfDTOs);
		model.put(SIZE, "" + (cfs == null ? 0 : cfs.size()));
		this.setJsonModel(model);
		return SUCCESS;
	}

}
