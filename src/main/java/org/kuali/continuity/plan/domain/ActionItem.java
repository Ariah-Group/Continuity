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

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForceDiscriminator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.BaseDomainObject;

@Entity
@Table(name="action_items")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@ForceDiscriminator
//@DiscriminatorColumn(name="a_type", discriminatorType=DiscriminatorType.STRING, length=1)
@DiscriminatorFormula("case when cid is not null and cid != 0 then 'C' else case when a_type = '' or a_type = 'N' then ' ' else a_type end end")
@DiscriminatorValue(" ")
@NamedQueries({
	@NamedQuery(name="ContinuityPlan.ActionItem.list",
		query="SELECT dObj FROM ActionItem dObj WHERE dObj.plan.id = :ownerId"),
	@NamedQuery(name="ContinuityPlan.ActionItemCost.list",
		query="SELECT dObj FROM ActionItemCost dObj"),
	@NamedQuery(name="ContinuityPlan.ActionItemCostCycle.list",
		query="SELECT dObj FROM ActionItemCostCycle dObj"),
	@NamedQuery(name="ContinuityPlan.ActionItemScope.list",
		query="SELECT dObj FROM ActionItemScope dObj"),
	@NamedQuery(name="ContinuityPlan.ActionItemStatus.list",
			query="SELECT dObj FROM ActionItemStatus dObj")
})
@SuppressWarnings("serial")
public class ActionItem extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private String comment;
	private ActionItemStatus status = new ActionItemStatus();
	private ActionItemCost cost = new ActionItemCost();
	private ActionItemCostCycle costCycle = new ActionItemCostCycle();
	private ActionItemScope scope = new ActionItemScope();
	private String type = " ";
	
	public ActionItem() {
	}
	
	@Id
	@Column(name="a_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@ManyToOne
	@JoinColumn(name="status")
	@Fetch(FetchMode.SELECT)
	public ActionItemStatus getStatus() {
		return this.status;
	}

	public void setStatus(ActionItemStatus status) {
		this.status = status;
	}

	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	@JoinColumn(name="cost")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public ActionItemCost getCost() {
		return this.cost;
	}

	public void setCost(ActionItemCost cost) {
		this.cost = cost;
	}

	@ManyToOne
	@JoinColumn(name="cost_is")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public ActionItemCostCycle getCostCycle() {
		return this.costCycle;
	}

	public void setCostCycle(ActionItemCostCycle costCycle) {
		this.costCycle = costCycle;
	}

	@ManyToOne
	@JoinColumn(name="scope")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public ActionItemScope getScope() {
		return this.scope;
	}

	public void setScope(ActionItemScope scope) {
		this.scope = scope;
	}

	@Column(name="a_type")
	protected String getType() {
		return this.type;
	}

	protected void setType(String type) {
		this.type = type;
	}

}
