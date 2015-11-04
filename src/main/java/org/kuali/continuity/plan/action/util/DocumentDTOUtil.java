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
package org.kuali.continuity.plan.action.util;

import java.util.Comparator;

import org.kuali.continuity.plan.action.dto.DocumentDTO;

public class DocumentDTOUtil implements Comparator<DocumentDTO> {

	public int compare(DocumentDTO dto1, DocumentDTO dto2)
		throws IllegalArgumentException {
		if (dto1.plan.id != dto2.plan.id) {
			int retVal = dto1.plan.name.compareTo(dto2.plan.name);
			if (retVal != 0) return retVal;
		}
		return dto1.name.compareTo(dto2.name);
	}
	
}
