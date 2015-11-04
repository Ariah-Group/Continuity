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

public enum SystemDomainAccessEnum implements RefEnum {

	SA_ONLY("0", "System Admin Only"), 
	SA_IA_ONLY("3", "System and Institution Admins Only"), 
	ALL_ADMINS("1", "Admins Only"),
	ALL_USERS("2","All Users");
	
	private String id;
	private String description;
	
	SystemDomainAccessEnum(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public SystemDomainAccess getRefDomainObject() {
		SystemDomainAccess status = new SystemDomainAccess();
		status.setId(this.id);
		status.setDescription(this.description);
		return status;
	}
	
}