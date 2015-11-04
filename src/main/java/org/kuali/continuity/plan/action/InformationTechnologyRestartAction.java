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
import org.kuali.continuity.plan.action.dto.RestartProcedureDTO;
import org.kuali.continuity.plan.domain.RestartProcedure;
import org.kuali.continuity.plan.service.InformationTechnologyService;

@SuppressWarnings("serial")
public class InformationTechnologyRestartAction extends InformationTechnologyAction {

	// service
	private InformationTechnologyService informationTechnologyService;
	
	// bean
	private RestartProcedureDTO restart = new RestartProcedureDTO();
	

	public InformationTechnologyRestartAction(InformationTechnologyService informationTechnologyService) {
		this.informationTechnologyService = informationTechnologyService;
	}

	public RestartProcedureDTO getRestart() {
		return this.restart;
	}
	
	public void setRestart(RestartProcedureDTO restart) {
		this.restart = restart;
	}
	
	@Override
	public void prepare() throws Exception {
		this.setReadRowAction(new ServerReadRowAction());
		this.setUpdateAction(new ServerUpdateAction());
	}

	public class ServerReadRowAction implements ReadRowAction {
		public String execute() throws Exception {
			InformationTechnologyService service = InformationTechnologyRestartAction.this.informationTechnologyService;
			int id = InformationTechnologyRestartAction.this.getOwnerId();
			RestartProcedure rp = service.getRestartProcedure(id);
			InformationTechnologyRestartAction.this.restart = new RestartProcedureDTO(rp);
			return SUCCESS;
		}
	}
	
	public class ServerUpdateAction implements UpdateAction {
		public String execute() throws Exception {
			InformationTechnologyService service = InformationTechnologyRestartAction.this.informationTechnologyService;
			int id = InformationTechnologyRestartAction.this.getOwnerId();
			service.updateRestartProcedure(id, InformationTechnologyRestartAction.this.restart.getRestartProcedure());
			return SUCCESS;
		}
	}
	
}
