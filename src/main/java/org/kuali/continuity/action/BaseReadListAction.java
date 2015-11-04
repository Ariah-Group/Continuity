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

import java.util.List;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.service.BaseService;

public class BaseReadListAction implements ReadListAction, ServiceAction {
	
	private BaseService service;
	private List<? extends DomainObjectDTO> dtos;
	private DomainObject2DTOConverter do2dtoConverter;
	private int ownerId;
	
	public BaseReadListAction() {

	}

	public BaseService getService() {
		return this.service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}

	public List<? extends DomainObjectDTO> getDtos() {
		return this.dtos;
	}

	public void setDtos(List<? extends DomainObjectDTO> dtos) {
		this.dtos = dtos;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	public String execute() throws Exception {
		this.setDtos(this.getListByOwnerId(this.getOwnerId()));
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	protected List<? extends DomainObjectDTO> getListByOwnerId(int ownerId) throws Exception {
		List<BaseDomainObject> dObjs = (List<BaseDomainObject>) this.service.getListByOwnerId(ownerId);
		return (List<? extends DomainObjectDTO>) this.do2dtoConverter.getDomainObjectDTOList(dObjs);
	}

}
