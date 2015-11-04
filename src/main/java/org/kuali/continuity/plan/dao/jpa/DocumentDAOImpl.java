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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;

import org.kuali.continuity.dao.jpa.BaseDomainObjectDAOImpl;
import org.kuali.continuity.plan.dao.DocumentDAO;
import org.kuali.continuity.plan.domain.Document;

public abstract class DocumentDAOImpl extends BaseDomainObjectDAOImpl implements DocumentDAO {

	public void create(Document obj) {
		super.create(obj);
	}

	public void update(Document obj) {
//		if (obj.getFileName() == null || obj.getFileName().trim().length() == 0) {
//			Document origDocument = this.getById(obj.getId());
//			if (origDocument != null) {
//				obj.setFileName(origDocument.getFileName());
//				obj.setDocument(origDocument.getDocument());
//			}
//		}
		super.update(obj);
	}

	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Document getById(int id) {
		return (Document) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends Document> getListByOwnerId(int ownerId) {
		return (List<? extends Document>) super.getListByOwnerId(ownerId);
	}
	
}
