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
package org.kuali.continuity.plan.dao.jpa;

import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.plan.dao.InformationTechnologyDAO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.InformationTechnology;
import org.kuali.continuity.plan.domain.RestartProcedure;
import org.kuali.continuity.plan.domain.WorkstationProcedure;

public class InformationTechnologyDAOImpl extends BaseDAOImpl implements 
	InformationTechnologyDAO {

	// information technology
	public InformationTechnology get(int planId) {
		ContinuityPlan plan = this.getPlan(planId);
		return plan.getInformationTechnology();
	}
	
	// workstation procedure
	public void updateWorkstationProcedure(int planId, WorkstationProcedure workstationProcedure) {
		ContinuityPlan plan = this.getPlan(planId);
		InformationTechnology it = plan.getInformationTechnology();
		it.setWorkstationProcedure(workstationProcedure);
		this.updatePlan(plan);
	}
	
	public WorkstationProcedure getWorkstationProcedure(int planId) {
		return this.get(planId).getWorkstationProcedure();
	}
	
	// restart procedure
	public void updateRestartProcedure(int planId, RestartProcedure restartProcedure) {
		ContinuityPlan plan = this.getPlan(planId);
		InformationTechnology it = plan.getInformationTechnology();
		it.setRestartProcedure(restartProcedure);
		this.updatePlan(plan);
	}
	
	public RestartProcedure getRestartProcedure(int planId) {
		return this.get(planId).getRestartProcedure();
	}
	
	private ContinuityPlan getPlan(int planId) {
		return
			(ContinuityPlan) this.getEntityManager().find(ContinuityPlan.class, planId);
	}
	
	private void updatePlan(ContinuityPlan plan) {
		this.getEntityManager().merge(plan);
	}
	
}
