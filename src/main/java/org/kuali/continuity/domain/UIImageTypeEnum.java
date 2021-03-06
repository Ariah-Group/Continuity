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
package org.kuali.continuity.domain;

import org.kuali.continuity.domain.ext.StringValuedEnum;

public enum UIImageTypeEnum implements StringValuedEnum {
	
	GIF("image/gif"), 
	JPEG("image/jpeg"),
	JPG("image/jpeg"),
	TIFF("image/tiff"), 
	BMP("image/x-ms-bmp"), 
	PNG("image/x-png");
	
	private String contentType;
	
	UIImageTypeEnum(final String contentType) {
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return this.contentType;
	}

	@Override
	public String getValue() {
		return this.name();
	}
	
	public static UIImageTypeEnum getEnum(String contentType) {
		if (contentType == null) return null;
		UIImageTypeEnum[] ens = UIImageTypeEnum.values();
		for (UIImageTypeEnum en : ens) {
			if (en.getContentType().equals(contentType))
				return en;
			if (contentType.endsWith("jpeg"))
				return JPG;
			if (contentType.endsWith("png"))
				return PNG;
			if (contentType.endsWith("bmp"))
				return BMP;
		}
		return null;
	}
}
