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
package org.kuali.continuity.admin.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageTypeEnum;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="SystemDomainUIImage")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@SuppressWarnings("serial")
public class SystemDomainUIImage extends BaseAdminDomainObject implements UIImage {
	
	private Blob image;
	private UIImageTypeEnum imageType;
	
	public SystemDomainUIImage() {
		
	}
	
	@Id
	@Column(name="UIImageID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return super.getSystemDomainId();
	}
	
	public String getName() {
		return super.getName();
	}
	
	@Lob
	@Column(name="UIImage")
	public Blob getImage() {
		return this.image;
	}
	
	public void setImage(Blob image) {
		this.image = image;
	}

	@Column(name="UIImageType")
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.domain.UIImageTypeEnum"
			)}
	)	
	public UIImageTypeEnum getImageType() {
		return this.imageType;
	}

	@Override
	public void setImageType(UIImageTypeEnum imageType) {
		this.imageType = imageType;
	}
	
}
