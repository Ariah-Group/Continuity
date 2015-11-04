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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.SamplePlanDocument;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;
import org.kuali.continuity.plan.domain.KeyDocument;

public class BinaryDocumentDTO {
	
	public enum Type {
		
		cp(KeyDocument.class), 
		cf(CriticalFunctionDocument.class),
		sp(SamplePlanDocument.class);
		
		private Class<? extends BinaryDocument> binaryDocumentClass;
		
		Type(final Class<? extends BinaryDocument> binaryDocumentClass) {
			this.binaryDocumentClass = binaryDocumentClass;
		}
		
		public Class<? extends BinaryDocument> getBinaryDocumentClass() {
			return this.binaryDocumentClass;
		}
	};
	
}
