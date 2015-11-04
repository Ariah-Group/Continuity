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
package org.kuali.continuity.domain.valueobject;

import java.io.Serializable;

import org.kuali.continuity.domain.User;
import org.kuali.continuity.util.DisplayUtil;

@SuppressWarnings("serial")

public class UserListValue  implements Serializable {
	
	public UserListValue() {
		
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public void setInstitutionID(Integer institutionID) {
		this.institutionID = institutionID;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public void setEmailregular(String emailregular) {
		this.emailregular = emailregular;
	}
	public void setAccessStatus(String accessStatus) {
		this.accessStatus = accessStatus;
	}
	Integer userID;

	Integer institutionID;
	String securityType;
	String name;
	String workPhone;
	String emailregular;
	String accessStatus;
	public Integer getUserID() {
		return userID;
	}
	public Integer getInstitutionID() {
		return institutionID;
	}
	public String getSecurityType() {
		return securityType;
	}
	public String getName() {
		return name;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public String getEmailregular() {
		return emailregular;
	}
	public String getAccessStatus() {
		return accessStatus;
	}
	
    public void setUserListValue(User u) {
		 this.setUserID(u.getUserId());
		 this.setName(u.getLastName()+" "+u.getFirstName());
		 this.setInstitutionID(u.getInstitutionId());
		 this.setEmailregular(u.getEmailregular());
		 this.setWorkPhone(u.getWorkPhone());
		 this.setSecurityType(DisplayUtil.displayRole(u.getSecurityType()));
		 this.setAccessStatus(DisplayUtil.displayAccess(u.getAccessStatus()));
    	
    }
   
	

}
