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
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.service.BaseService;

public class BaseReadRowAction implements ReadRowAction, ServiceAction {
	
	private BaseService service;
	private DomainObjectDTO dto;
	private DomainObject2DTOConverter do2dtoConverter;
	private int rowId;
	
	public BaseReadRowAction() {

	}
	
	public BaseService getService() {
		return this.service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}
	
	public DomainObjectDTO getDto() {
		return this.dto;
	}

	public void setDto(DomainObjectDTO dto) {
		this.dto = dto;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String execute() throws Exception {
		this.setDto(this.getById(this.getRowId()));
		return SUCCESS;
	}

	protected DomainObjectDTO getById(int rowId) throws Exception {
		BaseDomainObject dObj = service.getById(rowId);
		return this.do2dtoConverter.getDomainObjectDTO(dObj);
	}

}
