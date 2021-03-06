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

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("C")
@NamedQuery(name="ContinuityPlan.CriticalFunctionActionItem.list",
	query="SELECT dObj FROM CriticalFunctionActionItem dObj WHERE dObj.criticalFunction.id = :ownerId")
@SuppressWarnings("serial")
public class CriticalFunctionActionItem extends ActionItem {
	
	private CriticalFunction criticalFunction;

	public CriticalFunctionActionItem() {

	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="cid", nullable=false)
	public CriticalFunction getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunction criticalFunction) {
		this.criticalFunction = criticalFunction;
		this.setPlan(criticalFunction.getPlan());
	}
	
}
