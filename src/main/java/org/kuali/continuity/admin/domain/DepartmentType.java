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
package org.kuali.continuity.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.kuali.continuity.domain.OrderedType;
import org.kuali.continuity.domain.SortByType;

@Entity
@Table(name="DepartmentType")
@NamedQueries({
	@NamedQuery(name="DepartmentType.list",
		query="SELECT dObj FROM DepartmentType dObj WHERE dObj.systemDomainId = :systemDomainId ORDER BY dObj.orderNo"),
	@NamedQuery(name="DepartmentType.size",
		query="SELECT COUNT(dObj) FROM DepartmentType dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@SuppressWarnings("serial")
public class DepartmentType extends BaseAdminOrderedDomainObject implements OrderedType {
	
	public enum SortBy implements SortByType {
		id, orderNo, name;
		public String getSortByValue() {return this.name();}
	};
	
	public DepartmentType() {
		super();
	}
	
	public DepartmentType(Integer id) {
		super(id);
	}

	@Id
	@Column(name="DepartmentTypeID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="DepartmentType")
	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return super.getSystemDomainId();
	}
	
	public void setSystemDomainId(Integer systemDomainId) {
		super.setSystemDomainId(systemDomainId);
	}
	
	public int getOrderNo() {
		return super.getOrderNo();
	}

	public void setOrderNo(int orderNo) {
		super.setOrderNo(orderNo);
	}

}
