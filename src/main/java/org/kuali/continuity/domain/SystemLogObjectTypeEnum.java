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

import org.kuali.continuity.plan.domain.BaseContinuityPlan;

public enum SystemLogObjectTypeEnum implements RefEnum {
	
	ac("ac", "Action Item", null),
	cr("cr", "Critical Function", null),
	pl("pl", "Plan", BaseContinuityPlan.class),
	sh("sh", "Shib", null),
	us("us", "User Account", null),
	xx("xx", "System", null);
	
	private String id;
	private String description;
	private Class<? extends BaseDomainObject> logClass;
	
	SystemLogObjectTypeEnum(final String id, final String description, final Class<? extends BaseDomainObject> logClass) {
		this.id = id;
		this.description = description;
		this.logClass = logClass;
	}
	
	public SystemLogObjectType getRefDomainObject() {
		SystemLogObjectType systemLogObjectType = new SystemLogObjectType();
		systemLogObjectType.setId(this.id);
		systemLogObjectType.setDescription(this.description);
		return systemLogObjectType;
	}
	
	public final static SystemLogObjectTypeEnum getObjectTypeFromClass(
			final Class<? extends BaseDomainObject> logClass) {
		if (logClass == null) return null;
		SystemLogObjectTypeEnum[] objTypes = values();
		for (SystemLogObjectTypeEnum objType : objTypes) {
			if (objType.logClass == null) continue;
			if (logClass.isInstance(objType.logClass)) 
				return objType;
		}
		return null;
	}
}
