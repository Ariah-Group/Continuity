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

import org.kuali.continuity.dao.SystemSetupDAO;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.SystemSetupSamplePlanDocument;
import org.kuali.continuity.plan.dao.BinaryDocumentDAO;
import org.kuali.continuity.plan.domain.SystemDomainSamplePlanDocument;

public class SystemDomainSamplePlanDocumentDAOImpl extends BaseDAOImpl 
	implements BinaryDocumentDAO {
	
	private SystemSetupDAO systemSetupDAO;

	@Override
	public BinaryDocument getById(int ownerId) {
		BinaryDocument binaryDocument = (BinaryDocument) this.getEntityManager()
			.find(SystemDomainSamplePlanDocument.class, ownerId);
		if (binaryDocument == null) {
			binaryDocument = new SystemDomainSamplePlanDocument();
			binaryDocument.setId(ownerId);
		}
		((SystemDomainSamplePlanDocument)binaryDocument).setDefaultDocument(
			this.systemSetupDAO.getDefaultSamplePlanDocument());
		return binaryDocument;
	}

	@Override
	public void update(BinaryDocument binaryDocument) {
		BinaryDocument mergeDocument = null;
		if (binaryDocument instanceof SystemSetupSamplePlanDocument)
			mergeDocument = this.systemSetupDAO.getDefaultSamplePlanDocument();
		else
			mergeDocument = this.getEntityManager().find(
				SystemDomainSamplePlanDocument.class, binaryDocument.getId());
		mergeDocument.setBlobDocument(binaryDocument.getBlobDocument());
		this.getEntityManager().merge(mergeDocument);
	}

	public SystemSetupDAO getSystemSetupDAO() {
		return this.systemSetupDAO;
	}

	public void setSystemSetupDAO(SystemSetupDAO systemSetupDAO) {
		this.systemSetupDAO = systemSetupDAO;
	}

}
