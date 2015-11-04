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
package org.kuali.continuity.plan.domain;

public class OfficeEquipmentMinimum {

	private Integer minRequirement;
	private String comment;
	
	public OfficeEquipmentMinimum() {
	}
	
	public OfficeEquipmentMinimum(Integer min, String comment) {
		this.setMinRequirement(min);
		this.setComment(comment);
	}

	public Integer getMinRequirement() {
		return this.minRequirement;
	}

	public void setMinRequirement(Integer minRequirement) {
		this.minRequirement = minRequirement;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public enum Type {
		WORKSTATION, LAPTOP, TELEPHONE, PRINTER, FAX, COPIER, SCANNER, SERVER;
	}
	
}
