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

import org.kuali.continuity.admin.dao.CustomImageUploadDAO;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;

public class CustomImageUploadServiceImpl implements CustomImageUploadService {
	
	private CustomImageUploadDAO customImageUploadDAO;

	@Override
	public void uploadImage(int systemDomainId, UIImageEnum uiImageKey,
			UIImageTypeEnum uiImageType, byte[] image) {
		this.getCustomImageUploadDAO().uploadImage(systemDomainId, uiImageKey, uiImageType, image);
	}

	@Override
	public void deleteImage(int systemDomainId, UIImageEnum uiImageKey) {
		this.getCustomImageUploadDAO().deleteImage(systemDomainId, uiImageKey);
	}

	public CustomImageUploadDAO getCustomImageUploadDAO() {
		return this.customImageUploadDAO;
	}

	public void setCustomImageUploadDAO(CustomImageUploadDAO customImageUploadDAO) {
		this.customImageUploadDAO = customImageUploadDAO;
	}

}
