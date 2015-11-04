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
package org.kuali.continuity.plan.domain.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.kuali.continuity.plan.domain.WorkstationTechSupport;

@Embeddable
@SuppressWarnings("serial")
public class WorkstationTechSupports implements Serializable {

	private boolean isDeptSupported;
	private String deptSupportComment;
	private boolean isOtherDeptSupported;
	private String otherDeptSupportComment;
	private boolean isVendorSupported;
	private String vendorSupportComment;
	private boolean isOtherSupported;
	private String otherSupportComment;
	
	public WorkstationTechSupports() {
		
	}

	@Column(name="it_ws_support_dept_flag", insertable=false)
	public boolean isDeptSupported() {
		return this.isDeptSupported;
	}

	public void setDeptSupported(boolean isDeptSupported) {
		this.isDeptSupported = isDeptSupported;
	}

	@Column(name="it_ws_support_dept_comment", insertable=false)
	public String getDeptSupportComment() {
		return this.deptSupportComment;
	}

	public void setDeptSupportComment(String deptSupportComment) {
		this.deptSupportComment = deptSupportComment;
	}

	@Column(name="it_ws_support_campus_flag", insertable=false)
	public boolean isOtherDeptSupported() {
		return this.isOtherDeptSupported;
	}

	public void setOtherDeptSupported(boolean isOtherDeptSupported) {
		this.isOtherDeptSupported = isOtherDeptSupported;
	}

	@Column(name="it_ws_support_campus_comment", insertable=false)
	public String getOtherDeptSupportComment() {
		return this.otherDeptSupportComment;
	}

	public void setOtherDeptSupportComment(String otherDeptSupportComment) {
		this.otherDeptSupportComment = otherDeptSupportComment;
	}

	@Column(name="it_ws_support_vendor_flag", insertable=false)
	public boolean isVendorSupported() {
		return this.isVendorSupported;
	}

	public void setVendorSupported(boolean isVendorSupported) {
		this.isVendorSupported = isVendorSupported;
	}

	@Column(name="it_ws_support_vendor_comment", insertable=false)
	public String getVendorSupportComment() {
		return this.vendorSupportComment;
	}

	public void setVendorSupportComment(String vendorSupportComment) {
		this.vendorSupportComment = vendorSupportComment;
	}

	@Column(name="it_ws_support_other_flag", insertable=false)
	public boolean isOtherSupported() {
		return this.isOtherSupported;
	}

	public void setOtherSupported(boolean isOtherSupported) {
		this.isOtherSupported = isOtherSupported;
	}

	@Column(name="it_ws_support_other_comment", insertable=false)
	public String getOtherSupportComment() {
		return this.otherSupportComment;
	}

	public void setOtherSupportComment(String otherSupportComment) {
		this.otherSupportComment = otherSupportComment;
	}
	
	@Transient
	public Map<WorkstationTechSupport.Type, WorkstationTechSupport> getTechSupports() {
		Map<WorkstationTechSupport.Type, WorkstationTechSupport> supports = 
			new HashMap<WorkstationTechSupport.Type, WorkstationTechSupport>();
		supports.put(WorkstationTechSupport.Type.DEPT,
			new WorkstationTechSupport(this.isDeptSupported, this.getDeptSupportComment()));
		supports.put(WorkstationTechSupport.Type.OTHER_DEPT,
			new WorkstationTechSupport(this.isOtherDeptSupported, this.getOtherDeptSupportComment()));
		supports.put(WorkstationTechSupport.Type.VENDOR,
			new WorkstationTechSupport(this.isVendorSupported, this.getVendorSupportComment()));
		supports.put(WorkstationTechSupport.Type.OTHER,
			new WorkstationTechSupport(this.isOtherSupported, this.getOtherSupportComment()));
		return supports;
	}
	
	@Transient
	public void setTechSupports(Map<WorkstationTechSupport.Type, WorkstationTechSupport> supports) {
		this.init();
		if (supports == null) return;
		Set<WorkstationTechSupport.Type> types = supports.keySet();
		for (WorkstationTechSupport.Type type : types) {
			WorkstationTechSupport support = supports.get(type);
			if (support == null) continue;
			boolean isSupported = support.isSupported();
			String comment = support.getComment();
			if (type == WorkstationTechSupport.Type.DEPT) {
				this.setDeptSupported(isSupported);
				this.setDeptSupportComment(comment);
			} else if (type == WorkstationTechSupport.Type.OTHER_DEPT) {
				this.setOtherDeptSupported(isSupported);
				this.setOtherDeptSupportComment(comment);
			} else if (type == WorkstationTechSupport.Type.VENDOR) {
				this.setVendorSupported(isSupported);
				this.setVendorSupportComment(comment);
			} else if (type == WorkstationTechSupport.Type.OTHER) {
				this.setOtherSupported(isSupported);
				this.setOtherSupportComment(comment);
			}
		}
	}
	
	private void init() {
		this.setDeptSupported(false);
		this.setDeptSupportComment("");
		this.setOtherDeptSupported(false);
		this.setOtherDeptSupportComment("");
		this.setVendorSupported(false);
		this.setVendorSupportComment("");
		this.setOtherSupported(false);
		this.setOtherSupportComment("");
	}
	
}
