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
package org.kuali.continuity.admin.main.client;

public class LocationItem extends NamedItem {
	private String typestr;
	// private String authLocation;
	private String group;
    private int groupId;
	private boolean isLBNL;
	private boolean isDirAccessible; // DirectoryAccess
	private boolean isShibMode;
    private String authLocation;
    private String shibUniqueId;
    private String customUrl;
    
    // custom images
    private boolean customImage1;
    private boolean customImage2;
    private boolean customImage3;
    private boolean customImage4;
    
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	private String parentSystemDomainName;
	private String accessstr;
	public String getParentSystemDomainName() {
		return parentSystemDomainName;
	}

	public void setParentSystemDomainName(String parentSystemDomainName) {
		this.parentSystemDomainName = parentSystemDomainName;
	}

	private Integer authId;

	public Integer getAuthId() {
		return authId;
	}

	public void setAuthId(Integer authId) {
		this.authId = authId;
	}



	public String getAccessstr() {
		return accessstr;
	}

	public void setAccessstr(String accessstr) {
		this.accessstr = accessstr;
	}

	public String getSubLocation() {
		return name;
	}

	public void setSubLocation(String subLocation) {
		this.name = subLocation;
	}

	private String access; // TODO: map this, error in execution

	public String getTypestr() {
		return typestr;
	}

	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}

//	public String getAuthLocation() {
//		return authLocation;
//	}
//
//	public void setAuthLocation(String authLocation) {
//		this.authLocation = authLocation;
//	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public boolean isLBNL() {
		return isLBNL;
	}

	public void setLBNL(boolean isLBNL) {
		this.isLBNL = isLBNL;
	}

	public boolean isDirAccessible() {
		return isDirAccessible;
	}

	public void setDirAccessible(boolean isDirAccessible) {
		this.isDirAccessible = isDirAccessible;
	}

	public boolean isShibMode() {
		return isShibMode;
	}

	public void setShibMode(boolean isShibMode) {
		this.isShibMode = isShibMode;
	}

	public String getAuthLocation() {
		return authLocation;
	}

	public void setAuthLocation(String idp) {
		this.authLocation = idp;
	}

	public String getShibUniqueId() {
		return this.shibUniqueId;
	}

	public void setShibUniqueId(String shibUniqueId) {
		this.shibUniqueId = shibUniqueId;
	}

	public String getCustomUrl() {
		return this.customUrl;
	}

	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}

	public boolean isCustomImage1() {
		return this.customImage1;
	}

	public void setCustomImage1(boolean customImage1) {
		this.customImage1 = customImage1;
	}

	public boolean isCustomImage2() {
		return this.customImage2;
	}

	public void setCustomImage2(boolean customImage2) {
		this.customImage2 = customImage2;
	}

	public boolean isCustomImage3() {
		return this.customImage3;
	}

	public void setCustomImage3(boolean customImage3) {
		this.customImage3 = customImage3;
	}

	public boolean isCustomImage4() {
		return this.customImage4;
	}

	public void setCustomImage4(boolean customImage4) {
		this.customImage4 = customImage4;
	}

}
