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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.kuali.continuity.admin.dao.SystemDomainUITextDAO;
import org.kuali.continuity.admin.domain.SystemDomainUIText;
import org.kuali.continuity.dao.SystemUITextDAO;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.dao.jpa.UITextUtil;
import org.kuali.continuity.domain.InstructionUITextEnum;
import org.kuali.continuity.domain.UITextEnum;

public class SystemDomainUITextDAOImpl extends BaseDAOImpl implements SystemDomainUITextDAO {
	
	private static String GET_UI_TEXT =
		"SELECT dObj from SystemDomainUIText dObj WHERE institutionid = :systemDomainId AND name = :name";
	private static String GET_ALL_UI_TEXT =
		"SELECT dObj from SystemDomainUIText dObj WHERE institutionid = :systemDomainId";
	
	private SystemUITextDAO systemUITextDAO;

	@Override
	@SuppressWarnings("unchecked")
	public void create(int id, UITextEnum uiTextEnum, String text) {
		SystemDomainUIText uiText = this.getByOwnerIdAndTextEnum(id, uiTextEnum);
		if (uiText == null) { 
			uiText = new SystemDomainUIText();
			uiText.setName(((Enum)uiTextEnum).name());
			uiText.setSystemDomainId(id);
			uiText.setText(text);
			this.getEntityManager().persist(uiText);
		} else {
			this.update(id, uiTextEnum, text);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<UITextEnum, String> getByOwnerId(int id) {
		Query query = this.getEntityManager().createQuery(GET_ALL_UI_TEXT);
		query.setParameter("systemDomainId", id);
		List<SystemDomainUIText> uiTextList = (List<SystemDomainUIText>)query.getResultList();
		Map<UITextEnum, String> systemDomainUITexts = UITextUtil.getInstance().getUITexts(InstructionUITextEnum.class, uiTextList);
		Map<UITextEnum, String> systemUITexts = this.systemUITextDAO.getSystemUITexts();
		Map<UITextEnum, String> conUITexts = new HashMap<UITextEnum, String>();
		conUITexts.putAll(systemUITexts);
		conUITexts.putAll(systemDomainUITexts);
		return conUITexts;
	}

	@Override
	public String getTextByOwnerIdAndTextEnum(int id, UITextEnum uiTextEnum) {
		SystemDomainUIText obj = this.getByOwnerIdAndTextEnum(id, uiTextEnum);
		if (obj == null) return this.systemUITextDAO.getSystemUITexts().get(uiTextEnum);
		return obj.getText();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void update(int id, UITextEnum uiTextEnum, String text) {
		SystemDomainUIText uiText = this.getByOwnerIdAndTextEnum(id, uiTextEnum);
		if (uiText != null) { 
			uiText.setName(((Enum)uiTextEnum).name());
			uiText.setSystemDomainId(id);
			uiText.setText(text);
			this.getEntityManager().merge(uiText);
		} else {
			this.create(id, uiTextEnum, text);
		}
	}
	
	@Override
	public void delete(int id, UITextEnum uiTextEnum) {
		SystemDomainUIText uiText = this.getByOwnerIdAndTextEnum(id, uiTextEnum);
		if (uiText != null) this.getEntityManager().remove(uiText);
	}
	
	@SuppressWarnings("unchecked")
	protected SystemDomainUIText getByOwnerIdAndTextEnum(int id, UITextEnum uiTextEnum) {
		Query query = this.getEntityManager().createQuery(GET_UI_TEXT);
		query.setParameter("systemDomainId", id);
		query.setParameter("name", ((Enum)uiTextEnum).name());
		try {
			SystemDomainUIText obj = (SystemDomainUIText) query.getSingleResult();
			return obj;
		} catch (NoResultException e) {
			return null;
		}
		
	}

	public SystemUITextDAO getSystemUITextDAO() {
		return this.systemUITextDAO;
	}

	public void setSystemUITextDAO(SystemUITextDAO systemUITextDAO) {
		this.systemUITextDAO = systemUITextDAO;
	}

}
