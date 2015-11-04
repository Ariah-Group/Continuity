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


public class BuildingItem extends NamedItem {
	private String caan;
	private String commonName;
	private String address;
	private String owner="";
    private Integer ownerIndex;
	public Integer getOwnerIndex() {
		return ownerIndex;
	}
	public void setOwnerIndex(Integer ownerIndex) {
		this.ownerIndex = ownerIndex;
	}
	public String getCaan() {
		return caan;
	}
	public void setCaan(String caan) {
		this.caan = caan;
	}
	
	public String getCommonName() {
		return commonName;
	}
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
