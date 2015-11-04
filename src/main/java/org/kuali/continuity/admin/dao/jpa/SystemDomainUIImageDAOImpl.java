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
package org.kuali.continuity.admin.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.kuali.continuity.admin.dao.SystemDomainUIImageDAO;
import org.kuali.continuity.admin.domain.SystemDomainUIImage;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.dao.jpa.UIImageUtil;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageEnum;

public class SystemDomainUIImageDAOImpl extends BaseDAOImpl implements SystemDomainUIImageDAO {
	
	private static String GET_UI_IMAGE =
		"SELECT dObj from SystemDomainUIImage dObj WHERE dObj.systemDomainId = :systemDomainId AND name = :name";
	private static String GET_ALL_UI_IMAGE =
		"SELECT dObj from SystemDomainUIImage dObj WHERE dObj.systemDomainId = :systemDomainId";
	
	@Override
	public void create(SystemDomainUIImage uiImage) {
		SystemDomainUIImage uiImageTest = this.getByOwnerIdAndImageEnum(
			uiImage.getSystemDomainId(), UIImageEnum.valueOf(uiImage.getName()));
		if (uiImageTest != null) this.delete(uiImageTest);
		uiImage.setId(null);
		this.getEntityManager().persist(uiImage);
	}

	@Override
	public void delete(int id, UIImageEnum uiImageEnum) {
		SystemDomainUIImage uiImage = this.getByOwnerIdAndImageEnum(id, uiImageEnum);
		this.delete(uiImage);
	}
	
	protected void delete(SystemDomainUIImage uiImage) {
		if (uiImage != null) this.getEntityManager().remove(uiImage);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<UIImageEnum, UIImage> getByOwnerId(int id) {
		Query query = this.getEntityManager().createQuery(GET_ALL_UI_IMAGE);
		query.setParameter("systemDomainId", id);
		List<SystemDomainUIImage> uiImageList = (List<SystemDomainUIImage>)query.getResultList();
		Map<UIImageEnum, UIImage> systemDomainUIImages = UIImageUtil.getInstance().getUIImages(uiImageList);
		return systemDomainUIImages;
	}

	@Override
	public UIImage getImageByOwnerIdAndImageEnum(int id, UIImageEnum uiImageEnum) {
		SystemDomainUIImage obj = this.getByOwnerIdAndImageEnum(id, uiImageEnum);
		return obj;
	}

	@SuppressWarnings("unchecked")
	protected SystemDomainUIImage getByOwnerIdAndImageEnum(int id, UIImageEnum uiImageEnum) {
		Query query = this.getEntityManager().createQuery(GET_UI_IMAGE);
		query.setParameter("systemDomainId", id);
		query.setParameter("name", ((Enum)uiImageEnum).name());
		try {
			SystemDomainUIImage obj = (SystemDomainUIImage) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			return null;
		}
		
	}

}
