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

public enum AccessStatusEnum implements RefEnum {
	ON("1"), OFF("0");
	private String id;
	
	
	AccessStatusEnum(final String id) {
		this.id = id;
	}

	public AccessStatus getRefDomainObject() {
		AccessStatus refObj = new AccessStatus();
		refObj.setId(this.id);
		refObj.setDescription(this.name());
		return refObj;
	}

}