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

import java.util.ArrayList;
import java.util.List;

public enum SecurityTypeEnum implements RefEnum {

	// xxxx
	// ROLE VALUE List 4 of 4 .  First two are in ImageViewer.java
	SYSTEM_ADMIN("0", "System Admin"), 
	LOCAL_ADMIN("1", "Local Admin"), 
	UNIVERSAL_VIEWER("2", "Universal Viewer"),
	INSTITUTION_ADMIN("3", "Institution Admin"),
	MODERATOR("4", "Moderator"),
	LOCAL_USER("9", "Local User");
	
	private String id;
	private String description;
	private static List<SecurityTypeEnum> orderedSecurityTypes;
	static {
		orderedSecurityTypes = new ArrayList<SecurityTypeEnum>();
		orderedSecurityTypes.add(SYSTEM_ADMIN);
		orderedSecurityTypes.add(INSTITUTION_ADMIN);
		orderedSecurityTypes.add(LOCAL_ADMIN);
		orderedSecurityTypes.add(MODERATOR);
		orderedSecurityTypes.add(UNIVERSAL_VIEWER);
		orderedSecurityTypes.add(LOCAL_USER);		
	}

	SecurityTypeEnum(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public SecurityType getRefDomainObject() {
		SecurityType securityType = new SecurityType();
		securityType.setId(this.id);
		securityType.setDescription(this.description);
		return securityType;
	}
	
	public static List<SecurityType> getSecurityTypeFilteredList(final SecurityType securityType) {
		List<SecurityType> returnList = new ArrayList<SecurityType>();
		int start = orderedSecurityTypes.indexOf(getEnum(securityType));
		if (start >= 0) {
			for (int i = start; i < orderedSecurityTypes.size(); i++) {
				returnList.add(orderedSecurityTypes.get(i).getRefDomainObject());
			}
		}
		return returnList;
	}
	
	public static SecurityTypeEnum getEnum(final SecurityType securityType) {
		if (SYSTEM_ADMIN.getRefDomainObject().equals(securityType))
			return SYSTEM_ADMIN;
		if (INSTITUTION_ADMIN.getRefDomainObject().equals(securityType))
			return INSTITUTION_ADMIN;
		if (LOCAL_ADMIN.getRefDomainObject().equals(securityType))
			return LOCAL_ADMIN;
		if (MODERATOR.getRefDomainObject().equals(securityType))
			return MODERATOR;
		if (UNIVERSAL_VIEWER.getRefDomainObject().equals(securityType))
			return UNIVERSAL_VIEWER;
		if (LOCAL_USER.getRefDomainObject().equals(securityType))
			return LOCAL_USER;
		return null;
	}
	
	public static boolean isAdmin(final SecurityType securityType) {
		return
			SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(securityType) ||
			SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject().equals(securityType) ||
			SecurityTypeEnum.LOCAL_ADMIN.getRefDomainObject().equals(securityType);		
	}
}
