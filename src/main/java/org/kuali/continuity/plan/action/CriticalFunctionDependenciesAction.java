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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.domain.DependencyTypeEnum;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionNavigation;
import org.kuali.continuity.plan.action.dto.DependencyDTO;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.CriticalFunctionService;

import edu.emory.mathcs.backport.java.util.Collections;

@SuppressWarnings("serial")
public class CriticalFunctionDependenciesAction extends BasePlanActionSupport implements SessionPlanRequired {
	
	private CriticalFunctionService criticalFunctionService;
	private GenericAdminService adminService;
	
	private CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	private List<CriticalFunctionDTO> criticalFunctions = new ArrayList<CriticalFunctionDTO>();
	private List<DependencyDTO> upDependencies = new ArrayList<DependencyDTO>();
	private List<DependencyDTO> dnDependencies = new ArrayList<DependencyDTO>();
	private List<DependencyDTO> upCFDependencies = new ArrayList<DependencyDTO>();
	private List<DependencyDTO> dnCFDependencies = new ArrayList<DependencyDTO>();
	private int upDependencyId;
	private int dnDependencyId;
	private int deleteDependencyId;
	private String upDependencyName;
	private String dnDependencyName;
	private int copyCriticalFunctionId;
	private int addType;
	private String cfNav = CriticalFunctionNavigation.DEPENDENCIES.name();
	private DomainObject2DTOConverter do2dtoConverter;

	public CriticalFunctionDependenciesAction(CriticalFunctionService criticalFunctionService, GenericAdminService adminService) {
		this.criticalFunctionService = criticalFunctionService;
		this.adminService = adminService;
	}
	
	public CriticalFunctionDTO getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunctionDTO criticalFunction) {
		this.criticalFunction = criticalFunction;
	}

	public List<CriticalFunctionDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunctionDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

	public List<DependencyDTO> getUpDependencies() {
		return this.upDependencies;
	}

	public void setUpDependencies(List<DependencyDTO> upDependencies) {
		this.upDependencies = upDependencies;
	}

	public List<DependencyDTO> getDnDependencies() {
		return this.dnDependencies;
	}

	public void setDnDependencies(List<DependencyDTO> dnDependencies) {
		this.dnDependencies = dnDependencies;
	}

	public List<DependencyDTO> getUpCFDependencies() {
		return this.upCFDependencies;
	}

	public void setUpCFDependencies(List<DependencyDTO> upCFDependencies) {
		this.upCFDependencies = upCFDependencies;
	}

	public List<DependencyDTO> getDnCFDependencies() {
		return this.dnCFDependencies;
	}

	public void setDnCFDependencies(List<DependencyDTO> dnCFDependencies) {
		this.dnCFDependencies = dnCFDependencies;
	}

	public int getUpDependencyId() {
		return this.upDependencyId;
	}

	public void setUpDependencyId(int upDependencyId) {
		this.upDependencyId = upDependencyId;
	}

	public int getDnDependencyId() {
		return this.dnDependencyId;
	}

	public void setDnDependencyId(int dnDependencyId) {
		this.dnDependencyId = dnDependencyId;
	}

	public int getDeleteDependencyId() {
		return this.deleteDependencyId;
	}

	public void setDeleteDependencyId(int deleteDependencyId) {
		this.deleteDependencyId = deleteDependencyId;
	}

	public String getUpDependencyName() {
		return this.upDependencyName;
	}

	public void setUpDependencyName(String upDependencyName) {
		this.upDependencyName = upDependencyName;
	}

	public String getDnDependencyName() {
		return this.dnDependencyName;
	}

	public void setDnDependencyName(String dnDependencyName) {
		this.dnDependencyName = dnDependencyName;
	}

	public int getCopyCriticalFunctionId() {
		return this.copyCriticalFunctionId;
	}

	public void setCopyCriticalFunctionId(int copyCriticalFunctionId) {
		this.copyCriticalFunctionId = copyCriticalFunctionId;
	}

	public int getAddType() {
		return this.addType;
	}

	public void setAddType(int addType) {
		this.addType = addType;
	}

	public String getCfNav() {
		return this.cfNav;
	}

	public void setCfNav(String cfNav) {
		this.cfNav = cfNav;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}
	
	@SuppressWarnings("unchecked")
	public void prepare() {
		// system domain dependencies
		this.upDependencies = new ArrayList<DependencyDTO>();
		this.dnDependencies = new ArrayList<DependencyDTO>();
		List<Dependency> svcDependencies = (List<Dependency>) this.adminService.getListBySystemDomainId(Dependency.class, this.getSessionSystemDomain().id);
		for (Dependency dependency : svcDependencies) {
			if (dependency.getDependencyType().equals(DependencyTypeEnum.UPSTREAM.getRefDomainObject()))
				this.upDependencies.add(new DependencyDTO(dependency));
			else
				this.dnDependencies.add(new DependencyDTO(dependency));
		}
	}
	
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// critical function
		if (this.criticalFunction.name == null || this.criticalFunction.name.trim().length() == 0) {
			CriticalFunction svcCriticalFunction = this.criticalFunctionService.getCriticalFunction(this.criticalFunction.id);
			this.criticalFunction = new CriticalFunctionDTO(svcCriticalFunction);
		}
		
		// critical functions
		this.criticalFunctions = 
			(List<CriticalFunctionDTO>) this.do2dtoConverter.getDomainObjectDTOList(
				this.criticalFunctionService.getNonDeferrableCriticalFunctionSubList(this.getSessionPlan().id, this.criticalFunction.id));
		
		// critical function dependencies
		this.upCFDependencies = new ArrayList<DependencyDTO>();
		this.dnCFDependencies = new ArrayList<DependencyDTO>();
		Set<Dependency> svcCFDependencies = this.criticalFunctionService.getDependencies(this.criticalFunction.id);
		for (Dependency dependency : svcCFDependencies) {
			if (dependency.getDependencyType().equals(DependencyTypeEnum.UPSTREAM.getRefDomainObject()))
				this.upCFDependencies.add(new DependencyDTO(dependency));
			else
				this.dnCFDependencies.add(new DependencyDTO(dependency));
		}
		Collections.sort(upCFDependencies);
		Collections.sort(dnCFDependencies);
		return SUCCESS;
	}
	
	public String add() throws Exception {
		// new dependency
		Dependency dependency = new Dependency();
		dependency.setSystemDomainId(this.getSessionSystemDomain().id);
		
		// upstream & admin defined
		if ((this.addType == 0 || this.addType == 1) && this.upDependencyId != 0) {
			dependency.setId(this.upDependencyId);
			dependency.setName(null);
			dependency.setUserDefined(false);
			dependency.setDependencyType(DependencyTypeEnum.UPSTREAM.getRefDomainObject());
			this.criticalFunctionService.createDependency(this.criticalFunction.id, dependency);
		}

		// upstream & user defined
		if ((this.addType == 0 || this.addType == 2) && (this.upDependencyName != null && this.upDependencyName.trim().length() != 0)) {
			dependency.setId(null);
			dependency.setName(this.upDependencyName);
			dependency.setUserDefined(true);
			dependency.setDependencyType(DependencyTypeEnum.UPSTREAM.getRefDomainObject());
			this.criticalFunctionService.createDependency(this.criticalFunction.id, dependency);
		}

			// downstream & admin defined
		if ((this.addType == 0 || this.addType == 3) && this.dnDependencyId != 0) {
			dependency.setId(this.dnDependencyId);
			dependency.setName(null);
			dependency.setDependencyType(DependencyTypeEnum.DOWNSTREAM.getRefDomainObject());
			dependency.setUserDefined(false);
			this.criticalFunctionService.createDependency(this.criticalFunction.id, dependency);
		}
		
		// upstream & user defined
		if ((this.addType == 0 || this.addType == 4) && (this.dnDependencyName != null && this.dnDependencyName.trim().length() != 0)) {
			dependency.setId(null);
			dependency.setName(this.dnDependencyName);
			dependency.setUserDefined(true);
			dependency.setDependencyType(DependencyTypeEnum.DOWNSTREAM.getRefDomainObject());
			this.criticalFunctionService.createDependency(this.criticalFunction.id, dependency);
			
		}
		
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String delete() throws Exception {
		if (this.deleteDependencyId != 0)
			this.criticalFunctionService.deleteDependency(this.criticalFunction.id, new Dependency(this.deleteDependencyId));
		return SUCCESS;
	}
	
	public String copy() throws Exception {
		if (this.copyCriticalFunctionId != 0) {
			Set<Dependency> svcDependency = this.criticalFunctionService.getDependencies(this.copyCriticalFunctionId);
			// workaround
			Set<Dependency> newSvcDependency = new HashSet<Dependency>();
			for (Dependency dependency : svcDependency) {
				newSvcDependency.add(new Dependency(dependency.getId()));
			}
			this.criticalFunctionService.updateDependencies(this.criticalFunction.id, newSvcDependency);
		}
		return SUCCESS;
	}

}
