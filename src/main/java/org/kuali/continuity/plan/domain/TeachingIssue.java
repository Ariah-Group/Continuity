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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.kuali.continuity.domain.BaseDomainObject;

@Entity
@Table(name="instruction_teaching_issues")
@NamedQuery(name="TeachingIssue.list", 
	query="select dObj from TeachingIssue dObj where instruction.id = :ownerId")
@SuppressWarnings("serial")
public class TeachingIssue extends BaseDomainObject {
	
	private Instruction instruction;
	private String impact;
	private String alternatives;
	
	public TeachingIssue() {
		
	}

	@Id
	@Column(name="iti_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	public String getName() {
		return super.getName();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pis_id", nullable=false, updatable=false)
	public Instruction getInstruction() {
		return this.instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	public String getImpact() {
		return this.impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getAlternatives() {
		return this.alternatives;
	}

	public void setAlternatives(String alternatives) {
		this.alternatives = alternatives;
	}

}
