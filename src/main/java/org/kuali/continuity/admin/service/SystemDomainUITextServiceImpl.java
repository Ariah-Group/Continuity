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
package org.kuali.continuity.admin.service;

import java.util.Map;

import org.kuali.continuity.admin.dao.SystemDomainUITextDAO;
import org.kuali.continuity.domain.UITextEnum;

public class SystemDomainUITextServiceImpl implements SystemDomainUITextService {
	
	private SystemDomainUITextDAO systemDomainUITextDAO;

	@Override
	public void create(int id, UITextEnum uiTextEnum, String text) {
		this.systemDomainUITextDAO.create(id, uiTextEnum, text);
	}

	@Override
	public Map<UITextEnum, String> getByOwnerId(int id) {
		return this.systemDomainUITextDAO.getByOwnerId(id);
	}

	@Override
	public String getTextByOwnerIdAndTextEnum(int id, UITextEnum uiTextEnum) {
		return this.systemDomainUITextDAO.getTextByOwnerIdAndTextEnum(id, uiTextEnum);
	}

	@Override
	public void update(int id, UITextEnum uiTextEnum, String text) {
		this.systemDomainUITextDAO.update(id, uiTextEnum, text);
	}

	@Override
	public void delete(int id, UITextEnum uiTextEnum) {
		this.systemDomainUITextDAO.delete(id, uiTextEnum);
	}

	public SystemDomainUITextDAO getSystemDomainUITextDAO() {
		return this.systemDomainUITextDAO;
	}

	public void setSystemDomainUITextDAO(SystemDomainUITextDAO systemDomainUITextDAO) {
		this.systemDomainUITextDAO = systemDomainUITextDAO;
	}

}
