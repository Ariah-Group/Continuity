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

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class SystemLogInfo implements UserAccessValue {
	
	private Integer userId;
	private Integer systemDomainId;
	private String hostIP;
	private String module;
	private SecurityType securityType;
	private Boolean isInTestMode = false;
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return this.systemDomainId;
	}
	
	public void setSystemDomainId(Integer systemDomainId) {
		this.systemDomainId = systemDomainId;
	}
	
	public String getHostIP() {
		return this.hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

	public String getModule() {
		return this.module;
	}
	
	public void setModule(String module) {
		this.module = module;
	}
	
	@Transient
	public SecurityType getSecurityType() {
		return this.securityType;
	}

	public void setSecurityType(SecurityType securityType) {
		this.securityType = securityType;
	}

	@Transient
	public Boolean isInTestMode() {
		return this.isInTestMode;
	}

	public void setInTestMode(Boolean isInTestMode) {
		this.isInTestMode = isInTestMode;
	}

	@Override
	@Transient
	public String getEmailRegular() {
		return null;
	}

}
