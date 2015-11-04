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
package org.kuali.continuity.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.kuali.continuity.dao.SystemUITextDAO;
import org.kuali.continuity.domain.InstructionUITextEnum;
import org.kuali.continuity.domain.SystemUIText;
import org.kuali.continuity.domain.UITextEnum;

public class SystemUITextDAOImpl extends BaseDAOImpl implements SystemUITextDAO {

	@Override
	@SuppressWarnings("unchecked")
	public Map<UITextEnum, String> getSystemUITexts() {
		String queryString = "SELECT dObj FROM SystemUIText dObj";
		Query query = this.getEntityManager().createQuery(queryString);
		// TODO: result needs to be cached
		List<SystemUIText> uiTextList = (List<SystemUIText>)query.getResultList();
		return UITextUtil.getInstance().getUITexts(InstructionUITextEnum.class, uiTextList);
	}
	
}
