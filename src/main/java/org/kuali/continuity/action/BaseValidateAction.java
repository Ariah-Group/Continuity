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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.DomainObjectDTO;

public abstract class BaseValidateAction implements ValidateAction {

	private Map<String, List<String>> fieldErrors = new HashMap<String, List<String>>();
	private List<String> actionErrors = new ArrayList<String>(); 
	private DomainObjectDTO dto;
	
	// true - success
	// false - with error
	// null - ignore and do not save
	public abstract Boolean validate(DomainObjectDTO dto) throws Exception;
	
	public Boolean validate() throws Exception {
		return this.validate(this.getDto());
	}

	
	public Map<String, List<String>> getFieldErrors() {
		return this.fieldErrors;
	}
	
	public List<String> getActionErrors() {
		return this.actionErrors;
	}
	
	public DomainObjectDTO getDto() {
		return this.dto;
	}

	public void setDto(DomainObjectDTO dto) {
		this.dto = dto;
	}

	public void addFieldError(String field, String error) {
		List<String> errors = this.fieldErrors.get(field);
		if (errors == null) errors = new ArrayList<String>();
		errors.add(error);
		this.fieldErrors.put(field, errors);
	}
	
	public void addActionError(String error) {
		this.actionErrors.add(error);
	}
	
	public void clearErrors() {
		this.fieldErrors.clear();
		this.actionErrors.clear();
	}

}
