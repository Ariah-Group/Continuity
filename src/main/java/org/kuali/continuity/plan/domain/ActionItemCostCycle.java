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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;
import org.kuali.continuity.domain.BaseRefDomainObject;

@Entity
@Table(name="lookup_items")
@Where(clause="lookup_id=15")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="lookup_item_id")),
	@AttributeOverride(name="description", column=@Column(name="lookup_item_desc"))	
})
@NamedQuery(name="ActionItemCostCycle.list",
		query="SELECT dObj FROM ActionItemCostCycle dObj ORDER BY dObj.orderNo")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="query.all.org.kuali.continuity.domain.BaseRefDomainObject")
@SuppressWarnings("serial")
public class ActionItemCostCycle extends BaseRefDomainObject {

	private int orderNo;

	public ActionItemCostCycle() {
		super();
	}

	public ActionItemCostCycle(String id) {
		super(id);
	}

	@Column(name="lookup_item_no")
	public int getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

}
