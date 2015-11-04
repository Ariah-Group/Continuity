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


public class LocationItem0 extends NamedItem {
	private String typestr;
	private String authLocation;
	// private byte[] logo;
	private String phone;
	public String getTypestr() {
		return typestr;
	}
	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}
	public String getAuthLocation() {
		return authLocation;
	}
	public void setAuthLocation(String authLocation) {
		this.authLocation = authLocation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
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
	private String fax;
	private String email;
	private String access;	// TODO: map this, error in execution

	private boolean isLBNL;
	private boolean isDirAccessible;		// DirectoryAccess
	private boolean isShibMode;	
}
