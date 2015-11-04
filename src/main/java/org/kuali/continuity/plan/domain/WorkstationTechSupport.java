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

import java.io.Serializable;

@SuppressWarnings("serial")
public class WorkstationTechSupport implements Serializable {

	private boolean isSupported;
	private String comment;
	
	public WorkstationTechSupport(boolean isSupported, String comment) {
		this.setSupported(isSupported);
		this.setComment(comment);
	}
	
	public boolean isSupported() {
		return this.isSupported;
	}
	
	public void setSupported(boolean isSupported) {
		this.isSupported = isSupported;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	public enum Type {
		DEPT, OTHER_DEPT, VENDOR, OTHER;
	}
	
}
