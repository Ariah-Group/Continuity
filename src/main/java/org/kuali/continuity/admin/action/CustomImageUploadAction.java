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

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.admin.service.CustomImageUploadService;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;

@SuppressWarnings("serial")
public class CustomImageUploadAction extends BaseActionSupport {
	
	private CustomImageUploadService customImageUploadService;
	private final Logger logger = Logger.getLogger(CustomImageUploadAction.class);
	
	// file related fields
	private File uploadedImg1;
	private String uploadedImg1FileName;
	private String uploadedImg1ContentType;
	private File uploadedImg2;
	private String uploadedImg2FileName;
	private String uploadedImg2ContentType;
	private File uploadedImg3;
	private String uploadedImg3FileName;
	private String uploadedImg3ContentType;
	private File uploadedImg4;
	private String uploadedImg4FileName;
	private String uploadedImg4ContentType;

	private String systemDomainId;
	private boolean restore;
	private UIImageEnum uiImageEnum;
	
	public CustomImageUploadAction(CustomImageUploadService customImageUploadService) {
		this.customImageUploadService = customImageUploadService;
	}
	
	public String update() throws Exception {
		try {
			// get file
			File upImg = null;
			String upImgContentType = null;
			if (uiImageEnum.equals(UIImageEnum.BEGIN)) {
				upImg = this.uploadedImg1;
				upImgContentType = this.uploadedImg1ContentType;
			} else if (uiImageEnum.equals(UIImageEnum.BEGIN_TEXT)) {
				upImg = this.uploadedImg2;
				upImgContentType = this.uploadedImg2ContentType;
			} else if (uiImageEnum.equals(UIImageEnum.BANNER)) {
				upImg = this.uploadedImg3;
				upImgContentType = this.uploadedImg3ContentType;
			} else if (uiImageEnum.equals(UIImageEnum.BANNER_TEXT)) {
				upImg = this.uploadedImg4;
				upImgContentType = this.uploadedImg4ContentType;
			} else {
				throw new Exception("Invalid UI Image Key");
			}
			
			// system domain id
			int sdId = Integer.parseInt(this.systemDomainId);
			
			// restore default?
			if (this.isRestore()) {
				this.customImageUploadService.deleteImage(
					sdId, 
					this.uiImageEnum);
			} else {
				this.customImageUploadService.uploadImage(
					sdId, 
					this.uiImageEnum, 
					UIImageTypeEnum.getEnum(upImgContentType), 
					Hibernate.createBlob(new FileInputStream(upImg), (int) upImg.length()));
			}
			
		} catch (Exception e) {
			logger.error("Error uploading image", e);
			throw e;
		}
		// return
		return SUCCESS;
	}

	public File getUploadedImg1() {
		return this.uploadedImg1;
	}

	public void setUploadedImg1(File uploadedImg1) {
		this.uploadedImg1 = uploadedImg1;
	}

	public String getUploadedImg1FileName() {
		return this.uploadedImg1FileName;
	}

	public void setUploadedImg1FileName(String uploadedImg1FileName) {
		this.uploadedImg1FileName = uploadedImg1FileName;
	}

	public String getUploadedImg1ContentType() {
		return this.uploadedImg1ContentType;
	}

	public void setUploadedImg1ContentType(String uploadedImg1ContentType) {
		this.uploadedImg1ContentType = uploadedImg1ContentType;
	}

	public File getUploadedImg2() {
		return this.uploadedImg2;
	}

	public void setUploadedImg2(File uploadedImg2) {
		this.uploadedImg2 = uploadedImg2;
	}

	public String getUploadedImg2FileName() {
		return this.uploadedImg2FileName;
	}

	public void setUploadedImg2FileName(String uploadedImg2FileName) {
		this.uploadedImg2FileName = uploadedImg2FileName;
	}

	public String getUploadedImg2ContentType() {
		return this.uploadedImg2ContentType;
	}

	public void setUploadedImg2ContentType(String uploadedImg2ContentType) {
		this.uploadedImg2ContentType = uploadedImg2ContentType;
	}

	public File getUploadedImg3() {
		return this.uploadedImg3;
	}

	public void setUploadedImg3(File uploadedImg3) {
		this.uploadedImg3 = uploadedImg3;
	}

	public String getUploadedImg3FileName() {
		return this.uploadedImg3FileName;
	}

	public void setUploadedImg3FileName(String uploadedImg3FileName) {
		this.uploadedImg3FileName = uploadedImg3FileName;
	}

	public String getUploadedImg3ContentType() {
		return this.uploadedImg3ContentType;
	}

	public void setUploadedImg3ContentType(String uploadedImg3ContentType) {
		this.uploadedImg3ContentType = uploadedImg3ContentType;
	}

	public File getUploadedImg4() {
		return this.uploadedImg4;
	}

	public void setUploadedImg4(File uploadedImg4) {
		this.uploadedImg4 = uploadedImg4;
	}

	public String getUploadedImg4FileName() {
		return this.uploadedImg4FileName;
	}

	public void setUploadedImg4FileName(String uploadedImg4FileName) {
		this.uploadedImg4FileName = uploadedImg4FileName;
	}

	public String getUploadedImg4ContentType() {
		return this.uploadedImg4ContentType;
	}

	public void setUploadedImg4ContentType(String uploadedImg4ContentType) {
		this.uploadedImg4ContentType = uploadedImg4ContentType;
	}

	public UIImageEnum getUiImageEnum() {
		return this.uiImageEnum;
	}

	public void setUiImageEnum(UIImageEnum uiImageEnum) {
		this.uiImageEnum = uiImageEnum;
	}

	@Override
	public void prepare() throws Exception {
		// do nothing?
	}

	public CustomImageUploadService getCustomImageUploadService() {
		return this.customImageUploadService;
	}
	
	public void setCustomImageUploadService(CustomImageUploadService customImageUploadService) {
		this.customImageUploadService = customImageUploadService;
	}

	public boolean isRestore() {
		return this.restore;
	}

	public void setRestore(boolean restore) {
		this.restore = restore;
	}

	public String getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(String systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

}
