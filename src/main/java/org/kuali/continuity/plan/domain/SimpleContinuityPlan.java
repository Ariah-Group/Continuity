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

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.MapKeyManyToMany;
import org.hibernate.annotations.Where;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;

@Entity
@Table(name="plans")
@SuppressWarnings("serial")
public class SimpleContinuityPlan extends BaseContinuityPlan {
	
	private int contactsSize;

	public SimpleContinuityPlan() {
		super();
	}

	public SimpleContinuityPlan(Integer id) {
		super(id);
	}

	@Formula("(select count(*) from plan_contacts up where up.pid = pid)")
	public int getContactsSize() {
		return this.contactsSize;
	}

	public void setContactsSize(int contactsSize) {
		this.contactsSize = contactsSize;
	}

	@CollectionOfElements(targetElement=PlanAccessType.class, 
		fetch=FetchType.EAGER)
	@JoinTable(name="user_plan", 
		joinColumns={@JoinColumn(name="pid")},
		inverseJoinColumns={@JoinColumn(name="PlanAccess")})
	@MapKeyManyToMany(targetEntity=User.class,
		joinColumns={@JoinColumn(name="UserID")})
	@Where(clause="LookupName='UserPlanAccess'")
	@Override
	public Map<User, PlanAccessType> getUserAccessMap() {
		return super.getUserAccessMap();
	}

}
