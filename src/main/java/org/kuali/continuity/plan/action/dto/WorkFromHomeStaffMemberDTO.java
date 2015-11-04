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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.BroadbandConnection;
import org.kuali.continuity.domain.ComputerRunning;
import org.kuali.continuity.domain.ConnectFromHome;
import org.kuali.continuity.domain.StaffPosition;
import org.kuali.continuity.plan.domain.WorkFromHomeStaffMember;


@SuppressWarnings("serial")
public class WorkFromHomeStaffMemberDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public RefDTO staffPosition = new RefDTO();
	public RefDTO hasBroadbandConnection = new RefDTO();
	public RefDTO doesConnectFromHome = new RefDTO();
	public RefDTO mustOfficeComputerRunning = new RefDTO();
	public String comment;
	
	public WorkFromHomeStaffMemberDTO() {
		super();
	}

	public WorkFromHomeStaffMemberDTO(BaseDomainObject obj) {
		super(obj);
	}

	public WorkFromHomeStaffMemberDTO(int id, String name) {
		super(id, name);
	}

	public WorkFromHomeStaffMemberDTO(int id) {
		super(id);
	}
	
	public WorkFromHomeStaffMemberDTO(WorkFromHomeStaffMember dObj) {
		this.copyFromDomainObject(dObj);
	}

	public WorkFromHomeStaffMember getDomainObject() {
		WorkFromHomeStaffMember dObj = new WorkFromHomeStaffMember();
		dObj.setId(this.id);
		dObj.setName(this.name);
		if (this.plan != null) dObj.setPlan(plan.getDomainObject());
		if (this.staffPosition != null) dObj.setStaffPosition(new StaffPosition(this.staffPosition.id));
		if (this.hasBroadbandConnection != null) dObj.setHasBroadbandConnection(new BroadbandConnection(this.hasBroadbandConnection.id));
		if (this.doesConnectFromHome != null) dObj.setDoesConnectFromHome(new ConnectFromHome(this.doesConnectFromHome.id));
		if (this.mustOfficeComputerRunning != null) dObj.setMustOfficeComputerRunning(new ComputerRunning(this.mustOfficeComputerRunning.id));
		dObj.setComment(this.comment);
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof WorkFromHomeStaffMember)) return;
		WorkFromHomeStaffMember dObj = (WorkFromHomeStaffMember) copyObj;
		
		// set other fields
		if (dObj.getStaffPosition() != null) this.staffPosition = new RefDTO(dObj.getStaffPosition());
		if (dObj.getHasBroadbandConnection() != null) this.hasBroadbandConnection = new RefDTO(dObj.getHasBroadbandConnection());
		if (dObj.getDoesConnectFromHome() != null) this.doesConnectFromHome = new RefDTO(dObj.getDoesConnectFromHome());
		if (dObj.getMustOfficeComputerRunning() != null) this.mustOfficeComputerRunning = new RefDTO(dObj.getMustOfficeComputerRunning());
		this.comment = dObj.getComment();
	}

}
