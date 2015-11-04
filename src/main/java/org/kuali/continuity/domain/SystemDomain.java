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
package org.kuali.continuity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SystemDomain")
@SuppressWarnings("serial")
@Deprecated
public class SystemDomain implements Serializable {
	
	private Integer institutionId;
	private String institution;
	private Integer type;
	private String authLocation;
	private Integer authType;
	
	public SystemDomain() {
	}
	
	@Id
	@Column(name="institutionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getInstitutionId() {
		return institutionId;
	}
	
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}
	
	public String getInstitution() {
		return institution;
	}
	
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	@Column(name="institutionType")
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getAuthLocation() {
		return authLocation;
	}
	
	public void setAuthLocation(String authLocation) {
		this.authLocation = authLocation;
	}
	
	public Integer getAuthType() {
		return authType;
	}
	
	public void setAuthType(Integer authType) {
		this.authType = authType;
	}
}
