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

import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.admin.domain.User;

public class ContactDTO extends UserDTO {
	
	public boolean isPrimary;

	public ContactDTO() {
		super();
	}
	
	public ContactDTO(int id) {
		super(id);
	}
	
	public ContactDTO(User user) {
		super(user);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((emailRegular == null) ? 0 : emailRegular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDTO other = (ContactDTO) obj;
		if (emailRegular == null) {
			if (other.emailRegular != null)
				return false;
		} else if (!emailRegular.equals(other.emailRegular))
			return false;
		return true;
	}

}
