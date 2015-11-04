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

public enum DependencyTypeEnum implements RefEnum {
	
	UPSTREAM("1", "Upstream"), DOWNSTREAM("0", "Downstream");
	private String id;
	private String description;
	
	DependencyTypeEnum(final String id, final String description) {
		this.id = id;
		this.description = description;
	}

	public DependencyType getRefDomainObject() {
		DependencyType rObj = new DependencyType();
		rObj.setId(this.id);
		rObj.setDescription(this.description);
		return rObj;
	}

}
