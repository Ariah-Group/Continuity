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

import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;

public class PageAccessControlDTO implements SessionValue {

	public Boolean isInputReadOnly;
	public Boolean isSelectDisabled;
	public String addClass;
	public String noDisplayClass;
	public String displayClass;
	public String hideClass;
	public String showClass;
	
	public PageAccessControlDTO(PlanAccessType planAccessType) {
		if (planAccessType.equals(PlanAccessTypeEnum.FULL.getRefDomainObject())) {
			this.isInputReadOnly = false;
			this.isSelectDisabled = false;
			this.addClass = "";
			this.noDisplayClass = "";
			this.displayClass = "NoToDisplay";
			this.hideClass = "";
			this.showClass = "HideElement";
		} else if (planAccessType.equals(PlanAccessTypeEnum.VIEW_ONLY.getRefDomainObject())) {
			this.isInputReadOnly = true;
			this.isSelectDisabled = true;
			this.addClass = "ReadOnly";
			this.noDisplayClass = "NoToDisplay";
			this.displayClass = "";
			this.hideClass = "HideElement";
			this.showClass = "";			
		}
	}
}
