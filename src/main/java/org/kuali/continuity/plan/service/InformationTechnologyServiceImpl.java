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
package org.kuali.continuity.plan.service;

import org.kuali.continuity.plan.dao.InformationTechnologyDAO;
import org.kuali.continuity.plan.domain.CriticalCentralApplication;
import org.kuali.continuity.plan.domain.DepartmentOwnedApplication;
import org.kuali.continuity.plan.domain.InformationTechnology;
import org.kuali.continuity.plan.domain.RestartProcedure;
import org.kuali.continuity.plan.domain.Server;
import org.kuali.continuity.plan.domain.WorkstationProcedure;

public class InformationTechnologyServiceImpl implements
		InformationTechnologyService {
	
	private InformationTechnologyDAO informationTechnologyDAO;
	private CriticalCentralApplicationService criticalCentralApplicationService;
	private DepartmentOwnedApplicationService departmentOwnedApplicationService;
	private ServerService serverService;

	public ServerService getServerService() {
		return this.serverService;
	}

	public void setServerService(ServerService serverService) {
		this.serverService = serverService;
	}

	public InformationTechnology getInformationTechnology(int planId) {
		return this.informationTechnologyDAO.get(planId);
	}

	public RestartProcedure getRestartProcedure(int planId) {
		return this.informationTechnologyDAO.getRestartProcedure(planId);
	}

	public WorkstationProcedure getWorkstationProcedure(int planId) {
		return this.informationTechnologyDAO.getWorkstationProcedure(planId);
	}

	public void updateRestartProcedure(int planId,
			RestartProcedure restartProcedure) {
		this.informationTechnologyDAO.updateRestartProcedure(planId, restartProcedure);
	}

	public void updateWorkstationProcedure(int planId,
			WorkstationProcedure workstationProcedure) {
		this.informationTechnologyDAO.updateWorkstationProcedure(planId, workstationProcedure);
	}

	@Override
	// used in delete plan
	public void deleteInformationTechnology(int planId) {
		InformationTechnology it = this.getInformationTechnology(planId);
		
		// delete central apps
		for (CriticalCentralApplication app : it.getCriticalCentralApplications()) {
			this.criticalCentralApplicationService.delete(app.getId());
		}
		
		// delete department apps
		for (DepartmentOwnedApplication app : it.getDepartmentOwnedApplications()) {
			this.departmentOwnedApplicationService.delete(app.getId());
		}
		
		// delete servers
		for (Server server : it.getServers()) {
			this.serverService.delete(server.getId());
		}
	}

	public InformationTechnologyDAO getInformationTechnologyDAO() {
		return this.informationTechnologyDAO;
	}

	public void setInformationTechnologyDAO(
			InformationTechnologyDAO informationTechnologyDAO) {
		this.informationTechnologyDAO = informationTechnologyDAO;
	}

	public CriticalCentralApplicationService getCriticalCentralApplicationService() {
		return this.criticalCentralApplicationService;
	}

	public void setCriticalCentralApplicationService(
			CriticalCentralApplicationService criticalCentralApplicationService) {
		this.criticalCentralApplicationService = criticalCentralApplicationService;
	}

	public DepartmentOwnedApplicationService getDepartmentOwnedApplicationService() {
		return this.departmentOwnedApplicationService;
	}

	public void setDepartmentOwnedApplicationService(
			DepartmentOwnedApplicationService departmentOwnedApplicationService) {
		this.departmentOwnedApplicationService = departmentOwnedApplicationService;
	}

}
