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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKeyManyToMany;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.EvacuationPlan;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="plans")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@NamedQuery(name="ContinuityPlan.list",
	query="SELECT dObj FROM ContinuityPlan dObj " +
		"JOIN FETCH dObj.systemDomain WHERE dObj.systemDomain.id = :ownerId")
@Where(clause="disabled != 'Y'")
@SuppressWarnings("serial")
public class ContinuityPlan extends BaseContinuityPlan {
	
	private User departmentHead;
	private Map<User, Boolean> contacts;
	
	// sections
	private DepartmentInfo departmentInfo;
	private CriticalFunctions criticalFunctions;
	private InformationTechnology informationTechnology;
	private FacultyPreparedness facultyPreparedness;
	private Instructions instructions;
	private KeyResources keyResources;
	
	// action items
	private List<ActionItem> actionItems;
	
	// reviews
	private List<CompletedPlanReview> completedReviews;
	private List<AnnualPlanReview> annualReviews;

	public ContinuityPlan() {
		super();
	}
	
	public ContinuityPlan(Integer id) {
		super(id);
	}

	@ManyToOne
	@JoinColumn(name="MajorDivisionId")
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public MajorDivision getMajorDivision() {
		return super.getMajorDivision();
	}

	@ManyToOne
	@JoinColumn(name="AcronymID")
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public Acronym getAcronym() {
		return super.getAcronym();
	}

	@OneToOne(targetEntity=User.class)
	@JoinTable(name="plan_unit_heads", 
		joinColumns=@JoinColumn(name="pid"),
		inverseJoinColumns=@JoinColumn(name="UserID"))
	@NotFound(action=NotFoundAction.IGNORE)
	public User getDepartmentHead() {
		return this.departmentHead;
	}

	public void setDepartmentHead(User departmentHead) {
		this.departmentHead = departmentHead;
	}


	@CollectionOfElements(targetElement=Boolean.class, 
		fetch=FetchType.LAZY)
	@Column(name="ContactType")
	@JoinTable(name="plan_contacts", 
		joinColumns={@JoinColumn(name="pid")})
	@MapKeyManyToMany(targetEntity=User.class,
		joinColumns={@JoinColumn(name="UserID")})
	@NotFound(action=NotFoundAction.IGNORE)
	public Map<User, Boolean> getContacts() {
		if (this.contacts == null)
			this.setContacts(new HashMap<User, Boolean>());
		return this.contacts;
	}

	public void setContacts(Map<User, Boolean> contacts) {
		this.contacts = contacts;
	}
	
	public void addContact(User user, boolean isPrimary) {
		this.getContacts().put(user, isPrimary);
	}
	
	public void removeContact(User user) {
		this.getContacts().remove(user);
	}

	@Embedded
	public DepartmentInfo getDepartmentInfo() {
		return this.departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfo departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	@Embedded
	public CriticalFunctions getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(CriticalFunctions criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

	@Embedded
	public InformationTechnology getInformationTechnology() {
		return this.informationTechnology;
	}

	public void setInformationTechnology(InformationTechnology informationTechnology) {
		this.informationTechnology = informationTechnology;
	}

	@Embedded
	public FacultyPreparedness getFacultyPreparedness() {
		return this.facultyPreparedness;
	}

	public void setFacultyPreparedness(FacultyPreparedness facultyPreparedness) {
		this.facultyPreparedness = facultyPreparedness;
	}

	@Embedded
	public Instructions getInstructions() {
		return this.instructions;
	}

	public void setInstructions(Instructions instructions) {
		this.instructions = instructions;
	}

	@Embedded
	public KeyResources getKeyResources() {
		return this.keyResources;
	}

	public void setKeyResources(KeyResources keyResources) {
		this.keyResources = keyResources;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<ActionItem> getActionItems() {
		return this.actionItems;
	}

	public void setActionItems(List<ActionItem> actionItems) {
		this.actionItems = actionItems;
	}

	@CollectionOfElements(targetElement=PlanAccessType.class, 
		fetch=FetchType.LAZY)
	@JoinTable(name="user_plan", 
		joinColumns={@JoinColumn(name="pid")},
		inverseJoinColumns={@JoinColumn(name="PlanAccess")})
	@MapKeyManyToMany(targetEntity=User.class,
		joinColumns={@JoinColumn(name="UserID")})
	@Where(clause="LookupName='UserPlanAccess'")
	@NotFound(action=NotFoundAction.IGNORE)
	@Override
	public Map<User, PlanAccessType> getUserAccessMap() {
		return super.getUserAccessMap();
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<CompletedPlanReview> getCompletedReviews() {
		return this.completedReviews;
	}

	public void setCompletedReviews(List<CompletedPlanReview> completedReviews) {
		this.completedReviews = completedReviews;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<AnnualPlanReview> getAnnualReviews() {
		return this.annualReviews;
	}

	public void setAnnualReviews(List<AnnualPlanReview> annualReviews) {
		this.annualReviews = annualReviews;
	}

	@PrePersist
	public void checkNullInserts() {
		if (this.getAcronym() == null)
			this.setAcronym(new Acronym(0));
	}

	@PreUpdate
	public void checkNullUpdates() {
		this.checkNullInserts();
		if (this.getDepartmentInfo() == null)
			this.setDepartmentInfo(new DepartmentInfo());
		if (this.getDepartmentInfo().getEvacuationPlan() == null)
			this.getDepartmentInfo().setEvacuationPlan(new EvacuationPlan(""));
	}

}
