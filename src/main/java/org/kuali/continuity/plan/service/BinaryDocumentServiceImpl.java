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
package org.kuali.continuity.plan.service;

import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.plan.dao.BinaryDocumentDAO;
import org.kuali.continuity.plan.dao.BinaryDocumentDAOFactory;

public class BinaryDocumentServiceImpl implements BinaryDocumentService {
	
	BinaryDocumentDAOFactory binaryDocumentFactory;
	private Class<? extends BinaryDocument> binaryDocumentClass;
	
	public BinaryDocumentServiceImpl(BinaryDocumentDAOFactory binaryDocumentFactory,
			Class<? extends BinaryDocument> binaryDocumentClass) {
		this.binaryDocumentFactory = binaryDocumentFactory;
		this.binaryDocumentClass = binaryDocumentClass;
	}

	public BinaryDocument getDocument(int id) {
		BinaryDocument document = this.getBinaryDocumentDAO().getById(id);
		document.getBlobDocument();	// for those lazy loading
		return document;
	}
	
	public void updateDocument(BinaryDocument document) {
		this.getBinaryDocumentDAO().update(document);
	}


	private BinaryDocumentDAO getBinaryDocumentDAO() {
		return 
			this.binaryDocumentFactory.getBinaryDocumentDAO(this.binaryDocumentClass);
	}

}
