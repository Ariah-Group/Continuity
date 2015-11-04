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
import org.kuali.continuity.plan.action.dto.StakeholderDTO;

public class KeyResourcesStakeholderValidateAction extends BaseValidateAction {

	@Override
	public Boolean validate(DomainObjectDTO doDTO) throws Exception {
        StakeholderDTO dto = (StakeholderDTO) doDTO;
        if ((dto.firstName == null || dto.firstName.trim().length() == 0) &&
            (dto.lastName == null || dto.lastName.trim().length() == 0) &&
            (dto.department == null || dto.department.trim().length() == 0) &&
            (dto.address == null || dto.address.trim().length() == 0) &&
            (dto.email == null || dto.email.trim().length() == 0) &&
            (dto.workPhone == null || dto.workPhone.trim().length() == 0) &&
            (dto.cellPhone == null || dto.cellPhone.trim().length() == 0) &&
            (dto.fax == null || dto.fax.trim().length() == 0) &&
            (dto.suppliedProductsOrServices == null || dto.suppliedProductsOrServices.trim().length() == 0) &&
            (dto.alternateVendors == null || dto.alternateVendors.trim().length() == 0) &&
            (dto.comment == null || dto.comment.trim().length() == 0)) return null;
        if (dto.stakeholderType == null || 
        	dto.stakeholderType.id == null || 
        	dto.stakeholderType.id.trim().length() == 0 ||
        	dto.stakeholderType.id.equals("0")) {
        		this.addFieldError("dto.stakeholderType.id", "'This is' field is required.");
        		return false;        	
        }
		return true;
	}

}
