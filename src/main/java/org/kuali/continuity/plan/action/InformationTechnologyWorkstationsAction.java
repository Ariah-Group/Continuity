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

import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.plan.action.dto.WorkstationProcedureDTO;
import org.kuali.continuity.plan.domain.WorkstationProcedure;
import org.kuali.continuity.plan.service.InformationTechnologyService;

@SuppressWarnings("serial")
public class InformationTechnologyWorkstationsAction extends
		InformationTechnologyAction {

	// service
	private InformationTechnologyService informationTechnologyService;
	
	// bean
	private WorkstationProcedureDTO workstation = new WorkstationProcedureDTO();
	

	public InformationTechnologyWorkstationsAction(InformationTechnologyService informationTechnologyService) {
		super();
		this.informationTechnologyService = informationTechnologyService;
	}

	public WorkstationProcedureDTO getWorkstation() {
		return this.workstation;
	}
	
	public void setWorkstation(WorkstationProcedureDTO workstation) {
		this.workstation = workstation;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setReadRowAction(new WorkstationReadRowAction());
		this.setUpdateAction(new WorkstationUpdateAction());
	}

	// ----- actions ----- //
	
	public class WorkstationReadRowAction implements ReadRowAction {
		public String execute() throws Exception {
			InformationTechnologyService service = InformationTechnologyWorkstationsAction.this.informationTechnologyService;
			int id = InformationTechnologyWorkstationsAction.this.getOwnerId();
			WorkstationProcedure wp = service.getWorkstationProcedure(id);
			InformationTechnologyWorkstationsAction.this.workstation = new WorkstationProcedureDTO(wp);
			return SUCCESS;
		}
	}
	
	public class WorkstationUpdateAction implements UpdateAction {
		public String execute() throws Exception {
			InformationTechnologyService service = InformationTechnologyWorkstationsAction.this.informationTechnologyService;
			int id = InformationTechnologyWorkstationsAction.this.getOwnerId();
			service.updateWorkstationProcedure(id, InformationTechnologyWorkstationsAction.this.workstation.getWorkstationProcedure());
			return SUCCESS;
		}
	}
}
