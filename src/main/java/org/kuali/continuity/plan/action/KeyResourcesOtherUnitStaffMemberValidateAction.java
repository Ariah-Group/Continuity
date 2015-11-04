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
package org.kuali.continuity.plan.action;

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.OtherUnitStaffMemberDTO;

public class KeyResourcesOtherUnitStaffMemberValidateAction extends
		BaseValidateAction {

	@Override
	public Boolean validate(DomainObjectDTO dto) throws Exception {
		OtherUnitStaffMemberDTO ousmDTO = (OtherUnitStaffMemberDTO) dto;
		if ((ousmDTO.firstName == null || ousmDTO.firstName.trim().length() == 0) &&
			(ousmDTO.lastName == null || ousmDTO.lastName.trim().length() == 0) &&
			(ousmDTO.department == null || ousmDTO.department.trim().length() == 0) &&
			(ousmDTO.address == null || ousmDTO.address.trim().length() == 0) &&
			(ousmDTO.email == null || ousmDTO.email.trim().length() == 0) &&
			(ousmDTO.workPhone == null || ousmDTO.workPhone.trim().length() == 0) &&
			(ousmDTO.cellPhone == null || ousmDTO.cellPhone.trim().length() == 0) &&
			(ousmDTO.fax == null || ousmDTO.fax.trim().length() == 0) &&
			(ousmDTO.comment == null || ousmDTO.comment.trim().length() == 0)) return null;
		return true;
	}

}
