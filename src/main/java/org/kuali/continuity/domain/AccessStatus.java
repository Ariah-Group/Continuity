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
package org.kuali.continuity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

@Entity
@Table(name="DescriptionLookup")
@Where(clause="LookupName='AccessStatus'")
@NamedQuery(name="AccessStatus.list",
		query="SELECT dObj FROM AccessStatus dObj ORDER BY dObj.id")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="query.all.org.kuali.continuity.domain.BaseRefDomainObject")
@SuppressWarnings("serial")
public class AccessStatus extends BaseRefDomainObject {
	
	private String lookupName;
	
	public AccessStatus() {
		super();
	}
	
	public AccessStatus(String id) {
		super(id);
	}
	
	// to fix order by issue in user
	@Column(name="LookupName", insertable=false, updatable=false)
	public String getLookupName() {
		return this.lookupName;
	}
	
	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}

}
