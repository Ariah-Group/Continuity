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

import com.google.gwt.user.client.rpc.IsSerializable;

public class NamedItem implements IsSerializable{

	int id;
	String name;
	int systemDomainId;
	String csrfToken;
	
	public NamedItem() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getSystemDomainId() {
		return systemDomainId;
	}

	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}
	
	public String getCsrfToken() {
		return this.csrfToken;
	}

	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

}
