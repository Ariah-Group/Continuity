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
package org.kuali.continuity.action;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.util.DTO2DomainObjectConverter;
import org.kuali.continuity.domain.BaseDomainObject;

public abstract class BaseSaveAction implements SaveAction {
	
	private ValidateAction validateAction;
	private DomainObjectDTO dto;
	private DTO2DomainObjectConverter dto2doConverter;
	
	public DomainObjectDTO getDto() {
		return this.dto;
	}
	
	public void setDto(DomainObjectDTO dto) {
		this.dto = dto;
	}
	
	public String execute() throws Exception {
		return this.save(this.dto);
	}

	public ValidateAction getValidateAction() {
		return this.validateAction;
	}

	public void setValidateAction(ValidateAction validateAction) {
		this.validateAction = validateAction;
	}

	public DTO2DomainObjectConverter getDto2doConverter() {
		return this.dto2doConverter;
	}

	public void setDto2doConverter(DTO2DomainObjectConverter dto2doConverter) {
		this.dto2doConverter = dto2doConverter;
	}

	public String save(DomainObjectDTO dto) throws Exception {
		if (this.validateAction != null) {
			if (this.validateAction instanceof BaseValidateAction)
				((BaseValidateAction)validateAction).setDto(dto);
			Boolean success = this.validateAction.validate();
			if (success == null) return SUCCESS;	// ignore if null
			if (success == false) return INPUT;		// error 
		}
		BaseDomainObject dObj = this.dto2doConverter.getDomainObject(dto);
		this.doSave(dObj);
		return SUCCESS;
	}
	
	protected abstract void doSave(BaseDomainObject dObj) throws Exception;

}
