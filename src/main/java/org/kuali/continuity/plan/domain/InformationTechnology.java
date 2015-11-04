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
package org.kuali.continuity.plan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;

@Embeddable
@SuppressWarnings("serial")
public class InformationTechnology implements Serializable {
	
	private List<CriticalCentralApplication> criticalCentralApplications;
	private List<DepartmentOwnedApplication> departmentOwnedApplications;
	private List<Server> servers;
	private WorkstationProcedure workstationProcedure;
	private RestartProcedure restartProcedure;
	private List<InformationTechnologyActionItem> actionItems;

	public InformationTechnology() {
	}
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<CriticalCentralApplication> getCriticalCentralApplications() {
		return this.criticalCentralApplications;
	}

	public void setCriticalCentralApplications(
			List<CriticalCentralApplication> criticalCentralApplications) {
		this.criticalCentralApplications = criticalCentralApplications;
	}
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<DepartmentOwnedApplication> getDepartmentOwnedApplications() {
		return this.departmentOwnedApplications;
	}

	public void setDepartmentOwnedApplications(
			List<DepartmentOwnedApplication> departmentOwnedApplications) {
		this.departmentOwnedApplications = departmentOwnedApplications;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<Server> getServers() {
		return this.servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	@Embedded
	public WorkstationProcedure getWorkstationProcedure() {
		return this.workstationProcedure;
	}

	public void setWorkstationProcedure(WorkstationProcedure workstationProcedure) {
		this.workstationProcedure = workstationProcedure;
	}

	@Embedded
	public RestartProcedure getRestartProcedure() {
		return this.restartProcedure;
	}

	public void setRestartProcedure(RestartProcedure restartProcedure) {
		this.restartProcedure = restartProcedure;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false) 
	@Where(clause="disabled != 'Y'")
	public List<InformationTechnologyActionItem> getActionItems() {
		return this.actionItems;
	}

	public void setActionItems(List<InformationTechnologyActionItem> actionItems) {
		this.actionItems = actionItems;
	}

}
