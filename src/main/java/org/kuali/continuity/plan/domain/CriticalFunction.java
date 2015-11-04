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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.ext.StringValuedEnumType;
import org.kuali.continuity.plan.domain.ext.Consequences;
import org.kuali.continuity.plan.domain.ext.PeakMonths;

@Entity
@Table(name="critical_functions")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@NamedQuery(name="CriticalFunction.list", 
		query="SELECT dObj FROM CriticalFunction dObj WHERE dObj.plan.id = :ownerId")
@SuppressWarnings("serial")
public class CriticalFunction extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private int priority;
	private CriticalityLevelEnum criticalityLevelEnum;
	
	// description
	private String description;
	private String performingUnits;
	private String responsiblePersons;
	
	// documents
	private List<CriticalFunctionDocument> documents;
	
	// dependencies
	private Set<Dependency> dependencies;
	
	// how to cope
	private CopingMethod copingMethod = new CopingMethod();
	
	// action items
	private List<CriticalFunctionActionItem> actionItems;
	
	// used for mapping only
	private Consequences consequencesExt = new Consequences();
	private PeakMonths peakMonthsExt = new PeakMonths();
	
	public final static String CF_INSTRUCTION = "Instruction";
	
	public enum SortBy implements SortByType {
		id, name, priority;
		public String getSortByValue() {return this.name();}
	}
	
	public CriticalFunction() {
		super();
	}
	
	public CriticalFunction(Integer id) {
		super(id);
	}
	
	@Id
	@Column(name="cid")
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
	@JoinColumn(name="pid", nullable=false, updatable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name="CriticalityLevel", insertable=false)
	@Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.domain.CriticalityLevelEnum"
			)})
	@NotFound(action=NotFoundAction.IGNORE)
	public CriticalityLevelEnum getCriticalityLevelEnum() {
		return this.criticalityLevelEnum;
	}

	public void setCriticalityLevelEnum(CriticalityLevelEnum criticalityLevelEnum) {
		this.criticalityLevelEnum = criticalityLevelEnum;
	}

	@Column(name="description", insertable=false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="unit_performs", insertable=false)
	public String getPerformingUnits() {
		return this.performingUnits;
	}

	public void setPerformingUnits(String performingUnits) {
		this.performingUnits = performingUnits;
	}

	@Column(name="responsible_person", insertable=false)
	public String getResponsiblePersons() {
		return this.responsiblePersons;
	}

	public void setResponsiblePersons(String responsiblePersons) {
		this.responsiblePersons = responsiblePersons;
	}

	@Transient
	public Set<Integer> getPeakMonths() {
		if (this.getPeakMonthsExt() == null) return null;
		return this.getPeakMonthsExt().getPeakMonths();
	}

	public void setPeakMonths(Set<Integer> peakMonths) {
		if (this.getPeakMonthsExt() == null)
			this.setPeakMonthsExt(new PeakMonths());
		this.getPeakMonthsExt().setPeakMonths(peakMonths);
	}
	
	@Transient
	public String getPeaksExplanation() {
		if (this.getPeakMonthsExt() == null) return null;
		return this.getPeakMonthsExt().getPeaksExplanation();
	}
	
	public void setPeaksExplanation(String peaksExplanation) {
		if (this.getPeakMonthsExt() == null)
			this.setPeakMonthsExt(new PeakMonths());
		this.getPeakMonthsExt().setPeaksExplanation(peaksExplanation);
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="cid", insertable=false, updatable=false)
	public List<CriticalFunctionDocument> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<CriticalFunctionDocument> documents) {
		this.documents = documents;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="cf_dependency", 
		joinColumns=@JoinColumn(name="cid"),
		inverseJoinColumns=@JoinColumn(name="DependencyID"))
	public Set<Dependency> getDependencies() {
		return this.dependencies;
	}

	public void setDependencies(Set<Dependency> dependencies) {
		this.dependencies = dependencies;
	}
	
	public void addDependency(Dependency dependency) {
		Set<Dependency> dSet = this.getDependencies();
		if (dSet == null) {
			dSet = new HashSet<Dependency>();
			this.setDependencies(dSet);
		}
		dSet.add(dependency);
	}
	
	public void removeDependency(Dependency dependency) {
		Set<Dependency> dSet = this.getDependencies();
		dSet.remove(dependency);
	}

	@Transient
	public Map<Consequence.Type, Consequence> getConsequences() {
		if (this.getConsequencesExt() == null) return null;
		return this.getConsequencesExt().getConsequences();
	}

	public void setConsequences(Map<Consequence.Type, Consequence> consequences) {
		if (this.getConsequencesExt() == null)
			this.setConsequencesExt(new Consequences());
		this.getConsequencesExt().setConsequences(consequences);
	}

	@Embedded
	public CopingMethod getCopingMethod() {
		return this.copingMethod;
	}

	public void setCopingMethod(CopingMethod copingMethod) {
		this.copingMethod = copingMethod;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="cid", insertable=false, updatable=false) 
	@Where(clause="disabled != 'Y'")
	public List<CriticalFunctionActionItem> getActionItems() {
		return this.actionItems;
	}

	public void setActionItems(List<CriticalFunctionActionItem> actionItems) {
		this.actionItems = actionItems;
	}

	@Embedded
	private Consequences getConsequencesExt() {
		return this.consequencesExt;
	}

	private void setConsequencesExt(Consequences consequencesExt) {
		this.consequencesExt = consequencesExt;
	}

	@Embedded
	private PeakMonths getPeakMonthsExt() {
		return this.peakMonthsExt;
	}

	private void setPeakMonthsExt(PeakMonths peakMonthsExt) {
		this.peakMonthsExt = peakMonthsExt;
	}
	
	@PreUpdate
	protected void preUpdate() {
		if (this.criticalityLevelEnum == null)
			this.criticalityLevelEnum = CriticalityLevelEnum.LEVEL0;
	}
	
}
