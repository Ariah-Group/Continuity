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

import org.kuali.continuity.domain.BaseDomainObject;

@SuppressWarnings("serial")
public abstract class BaseAdminDomainObject extends BaseDomainObject {
	
	private Integer systemDomainId;

	public BaseAdminDomainObject() {
		super();
	}
	
	public BaseAdminDomainObject(Integer id) {
		super(id);
	}
	
	public Integer getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(Integer systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
