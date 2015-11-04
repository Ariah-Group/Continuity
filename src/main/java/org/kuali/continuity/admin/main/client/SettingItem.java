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

public class SettingItem extends NamedItem {
	
	String sublocation;  // To be removed.
	String [] domainList;
	String loggedUserAccessLevel;
	String fullModeration;
	String systemName;
	boolean isShibMode;
	boolean isInTestMode;
	String email;
 
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isShibMode() {
		return this.isShibMode;
	}
	public void setShibMode(boolean isShibMode) {
		this.isShibMode = isShibMode;
	}
	public boolean isInTestMode() {
		return this.isInTestMode;
	}
	public void setInTestMode(boolean isInTestMode) {
		this.isInTestMode = isInTestMode;
	}
	public String getSystemName() {
		return this.systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getFullModeration() {
		return fullModeration;
	}
	public void setFullModeration(String fullModeration) {
		this.fullModeration = fullModeration;
	}
	public String[] getDomainList() {
		return domainList;
	}
	public void setDomainList(String[] domainList) {
		this.domainList = domainList;
	}
	Integer access;
    Boolean options[] = new Boolean[] { false,false,false,false, false, false };
    public  enum optionType {Teams, Skills, Staffing, Functions, Replace, CriticalityLevel};
    
	public String getSublocation() {
		return sublocation;
	}
	public void setSublocation(String sublocation) {
		this.sublocation = sublocation;
	}
	public Integer getAccess() {
		return access;
	}
	public void setAccess(Integer access) {
		this.access = access;
	}

	public Boolean[] getOptions() {
		return options;
	}
	public void setOptions(Boolean[] options) {
		this.options = options;
	}
	public String getLocation() {
		return name;
	}
    public void setLocation(String location)	 {
    	this.name=location;
    }
    
	public String getLoggedUserAccessLevel() {
		return loggedUserAccessLevel;
	}
	public void setLoggedUserAccessLevel(String loggedUserAccessLevel) {
		this.loggedUserAccessLevel = loggedUserAccessLevel;
	}
    
}
