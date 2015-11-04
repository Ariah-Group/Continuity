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

import org.kuali.continuity.admin.dao.SystemDomainUIImageDAO;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageEnum;

public class SystemDomainUIImageServiceImpl implements SystemDomainUIImageService {
	
	private SystemDomainUIImageDAO systemDomainUIImageDAO;

	@Override
	public Map<UIImageEnum, UIImage> getByOwnerId(int id) {
		return this.systemDomainUIImageDAO.getByOwnerId(id);
	}

	@Override
	public UIImage getImageByOwnerIdAndImageEnum(int id, UIImageEnum uiImageEnum) {
		return this.systemDomainUIImageDAO.getImageByOwnerIdAndImageEnum(id, uiImageEnum);
	}

	public SystemDomainUIImageDAO getSystemDomainUIImageDAO() {
		return this.systemDomainUIImageDAO;
	}

	public void setSystemDomainUIImageDAO(SystemDomainUIImageDAO systemDomainUIImageDAO) {
		this.systemDomainUIImageDAO = systemDomainUIImageDAO;
	}

}
