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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.kuali.continuity.domain.RecordType;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.UserDefinable;

@Entity
@Table(name="CentralApplication")
@NamedQueries({
	@NamedQuery(name="CentralApplication.list",
		query="SELECT dObj FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId ORDER BY dObj.orderNo"),
	@NamedQuery(name="CentralApplication.size",
		query="SELECT COUNT(dObj) FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="CentralApplication.admin.list",
		query="SELECT dObj FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId " +
				 "AND dObj.recordType = org.kuali.continuity.domain.RecordType.S ORDER BY dObj.orderNo"),
	@NamedQuery(name="CentralApplication.admin.size",
		query="SELECT COUNT(dObj) FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId " +
				 "AND dObj.recordType = org.kuali.continuity.domain.RecordType.S")
})
@SuppressWarnings("serial")
public class CentralApplication extends BaseAdminOrderedDomainObject implements UserDefinable {
	
	private RecordType recordType = RecordType.S;
	
	public enum SortBy implements SortByType {
		id, orderNo, name;
		public String getSortByValue() {return this.name();}
	};

	public CentralApplication() {
		super();
	}
	
	public CentralApplication(Integer id) {
		super(id);
	}
	
	public CentralApplication(Integer id, String name, int orderNo) {
		this.setId(id);
		this.setName(name);
		this.setOrderNo(orderNo);
	}

	@Id
	@Column(name="CentralApplicationID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
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

	@Transient
	public boolean isUserDefined() {
		return (this.getRecordType() == RecordType.U);
	}

	public void setUserDefined(boolean isUserDefined) {
		this.setRecordType(isUserDefined ? RecordType.U : RecordType.S);
	}

	@Enumerated(EnumType.STRING)
	private RecordType getRecordType() {
		return this.recordType;
	}

	private void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}

}
