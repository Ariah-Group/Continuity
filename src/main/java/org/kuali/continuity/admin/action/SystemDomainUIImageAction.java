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
package org.kuali.continuity.admin.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.kuali.continuity.action.BaseAction;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.admin.service.SystemDomainUIImageService;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;

public class SystemDomainUIImageAction extends BaseAction {

	private SystemDomainUIImageService systemDomainUIImageService;
	private InputStream inputStream;
	private String contentType;
	private UIImageEnum imgEnum;

	public SystemDomainUIImageAction(SystemDomainUIImageService systemDomainUIImageService) {
		this.systemDomainUIImageService = systemDomainUIImageService;
	}
	
	@Override
	public String execute() throws Exception {
		this.setInputStream(new ByteArrayInputStream("".getBytes()));
		this.setContentType("");
		SessionSystemDomainDTO dto = 
			(SessionSystemDomainDTO) this.getSessionValue(SessionKey.loginSystemDomain);
		if (dto != null && dto.id != 0) {
			UIImage image = this.systemDomainUIImageService.
				getImageByOwnerIdAndImageEnum(dto.id, this.getImgEnum());
			if (image != null) {
				this.setInputStream(image.getImage().getBinaryStream());
				this.setContentType(image.getImageType().getContentType());
			} else {
				// default
				String fileName = "";
				if (imgEnum == UIImageEnum.BANNER)
					fileName = "/images/banner.png";
				else if (imgEnum == UIImageEnum.BANNER_TEXT)
					fileName = "/images/banner-text.png";
				else if (imgEnum == UIImageEnum.BEGIN)
					fileName = "/images/begin.png";
				else if (imgEnum == UIImageEnum.BEGIN_TEXT)
					fileName = "/images/begin-text.png";
				this.setInputStream(SystemDomainUIImageAction.class.getResourceAsStream(fileName));
				this.setContentType(UIImageTypeEnum.PNG.getContentType());
			}
		}

		// return
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		// do nothing
	}

	public InputStream getInputStream() {
		return this.inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public UIImageEnum getImgEnum() {
		return this.imgEnum;
	}

	public void setImgEnum(UIImageEnum imgEnum) {
		this.imgEnum = imgEnum;
	}

}
