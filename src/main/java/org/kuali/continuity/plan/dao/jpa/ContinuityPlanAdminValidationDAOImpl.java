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

import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.plan.dao.ContinuityPlanAdminValidationDAO;

@SuppressWarnings("unchecked")
public class ContinuityPlanAdminValidationDAOImpl<T extends BaseAdminDomainObject> extends BaseDAOImpl
	implements ContinuityPlanAdminValidationDAO {

	private Class<T> adminClass;
	
	public ContinuityPlanAdminValidationDAOImpl() {
		
	}

	public ContinuityPlanAdminValidationDAOImpl(Class<T> adminClass) {
		this.adminClass = adminClass;		
	}

	@Override
	public List<Object[]> getPlans(int id) {
		Query query = this.getEntityManager().createNativeQuery(this.buildQuery());
		query.setParameter("id", (Integer)id);
		return (List<Object[]>) query.getResultList();
 	}
	
	
	protected String buildQuery() {
		StringBuffer query = new StringBuffer("SELECT DISTINCT p.pid, p.plan_name FROM PLANS p");

		if (Utility.class.isAssignableFrom(this.adminClass))
			query.append(", key_utility a WHERE p.pid = a.pid AND a.utilityid = :id");
		else if (Shift.class.isAssignableFrom(this.adminClass))
			query.append(", key_staffing_req a WHERE p.pid = a.pid AND a.shiftid = :id");
		else if (StaffCategory.class.isAssignableFrom(this.adminClass))
			query.append(", key_staffing_req a WHERE p.pid = a.pid AND a.staffcategoryid = :id");
		else if (Skill.class.isAssignableFrom(this.adminClass))
			query.append(", key_skills a WHERE p.pid = a.pid AND a.skillid = :id");
		else if (CentralApplication.class.isAssignableFrom(this.adminClass))
			query.append(", it_central_applications a WHERE p.pid = a.pid AND a.centralapplicationid = :id");
		else if (Dependency.class.isAssignableFrom(this.adminClass))
			query.append(", critical_functions cf, cf_dependency a WHERE p.pid = cf.pid AND cf.cid = a.cid AND a.dependencyid = :id");
		else if (Acronym.class.isAssignableFrom(this.adminClass))
			query.append(" WHERE p.acronymid = :id");
		else if (MajorDivision.class.isAssignableFrom(this.adminClass))
			query.append(" WHERE p.majordivisionid = :id");
		else if (Building.class.isAssignableFrom(this.adminClass))
			query.append(", plan_buildings a WHERE p.pid = a.pid AND a.buildingid = :id");
		else if (DepartmentType.class.isAssignableFrom(this.adminClass))
			query.append(", plan_department_types a WHERE p.pid = a.pid AND a.departmenttypeid = :id");
		else if (InstructionalDepartment.class.isAssignableFrom(this.adminClass))
			query.append(", plans_instructions a WHERE p.pid = a.pid AND a.instructionaldepartmentid = :id");
		else if (SystemDomain.class.isAssignableFrom(this.adminClass))
			query.append(", systemdomain a WHERE p.institutionid = a.institutionid AND a.institutionid = :id");
		else
			query = null;
		
		if (query != null)
			query.append(" ORDER BY p.pid");
		else
			query = new StringBuffer();
		
		return query.toString();
	}

	public Class<T> getAdminClass() {
		return this.adminClass;
	}

	public void setAdminClass(Class<T> adminClass) {
		this.adminClass = adminClass;
	}

}
