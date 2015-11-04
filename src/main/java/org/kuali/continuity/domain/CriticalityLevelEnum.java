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

import org.kuali.continuity.domain.ext.StringValuedEnum;


public enum CriticalityLevelEnum implements StringValuedEnum {

		LEVEL1("1"), LEVEL2("2"), LEVEL3("3"), LEVEL4("4"),
		LEVELN(""),  LEVEL0("0");	// exceptions 
	
	private String levelNo;
	
	CriticalityLevelEnum(String levelNo) {
		this.levelNo = levelNo;
	}
	
	public String getLevelNo() {
		return this.levelNo;
	}
	
	@Override
	public String getValue() {
		return this.levelNo;
	}
	
	public static CriticalityLevelEnum getEnum(final String levelNo) {
		for (CriticalityLevelEnum en : CriticalityLevelEnum.values()) {
			if (en.getValue().equals(levelNo)) return en;
		}
		return null;
	}

}