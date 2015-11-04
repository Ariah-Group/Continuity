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
package org.kuali.continuity.admin.dao;

import java.io.InputStream;
import java.util.Map;

import org.hibernate.Hibernate;
import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.SystemDomainUIImage;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;

public class SystemDomainUIImageDAOTest extends BasePlanTest {
	
	private SystemDomainUIImageDAO dao;
	
	public void setDao(SystemDomainUIImageDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCreate() throws Exception {
		SystemDomainUIImage image = new SystemDomainUIImage();
		image.setImageType(UIImageTypeEnum.GIF);
		image.setSystemDomainId(68);

		image.setName(UIImageEnum.BEGIN_TEXT.name());
		InputStream is = SystemDomainUIImageDAOTest.class.getResourceAsStream("/images/CMA-Begin-Text.gif");
		image.setImage(Hibernate.createBlob(is));
		this.dao.create(image);
		
		this.setComplete();
	}
/*	
	public void testGetImageByOwnerIdAndImageEnum() {
		UIImage image = this.dao.getImageByOwnerIdAndImageEnum(PlanTestData.wellknown_institution, UIImageEnum.BANNER);
		assertNotNull(image);
	}
	
	public void testGetByOwnerId() {
		Map<UIImageEnum, UIImage> images = this.dao.getByOwnerId(PlanTestData.wellknown_institution);
		assertNotNull(images);
		assertFalse(images.isEmpty());
	}
*/
}
