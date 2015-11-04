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
package org.kuali.continuity.plan.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Embeddable
@SuppressWarnings("serial")
public class CriticalFunctions implements Serializable {
	
	private List<CriticalFunction> criticalFunctions;

	public CriticalFunctions() {	
	}
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<CriticalFunction> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunction> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

}
