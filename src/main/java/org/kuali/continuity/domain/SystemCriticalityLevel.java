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

@SuppressWarnings("serial")
public abstract class SystemCriticalityLevel extends BaseDomainObject implements
		CriticalityLevel {

	private CriticalityLevelEnum levelEnum;
	private String description;
	private String longDescription;
	
	@Override
	public CriticalityLevelEnum getCriticalityLevelEnum() {
		return this.levelEnum;
	}

	@Override
	public void setCriticalityLevelEnum(CriticalityLevelEnum levelEnum) {
		this.levelEnum = levelEnum;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getLongDescription() {
		return this.longDescription;
	}

	@Override
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
