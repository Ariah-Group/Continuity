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
package org.kuali.continuity.action.dto;

import java.io.Serializable;

import org.kuali.continuity.domain.BaseDomainObject;

@SuppressWarnings("serial")
public class DomainObjectDTO implements Serializable {
	
	public int id;
	public String name;
	
	public DomainObjectDTO() {
		
	}
	
	public DomainObjectDTO(int id) {
		this.id = id;
	}
	
	public DomainObjectDTO(int id, String name) {
		this(id);
		this.name = name;
	}
	
	public DomainObjectDTO(BaseDomainObject dObj) {
		if (dObj == null) return;
		this.id = dObj.getId();
		this.name = dObj.getName();
	}
	
	// needed for json
	public int getId() {
		return this.id;
	}

	// needed for json
	public String getName() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainObjectDTO other = (DomainObjectDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
