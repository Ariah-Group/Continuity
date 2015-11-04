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
package org.kuali.continuity.plan.domain.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.kuali.continuity.plan.domain.Consequence;

@Embeddable
@SuppressWarnings("serial")
public class Consequences implements Serializable {

	private boolean isDisruptTeaching;
	private String disruptTeachingExplain;
	private boolean isDisruptResearch;
	private String disruptResearchExplain;
	private boolean isDisruptPatientCare;
	private String disruptPatientCareExplain;
	private boolean isDepartureFaculty;
	private String departureFacultyExplain;
	private boolean isDepartureStaff;
	private String departureStaffExplain;
	private boolean isDepartureStudents;
	private String departureStudentsExplain;
	private boolean isWellbeingFacultyStaff;
	private String wellbeingFacultyStaffExplain;
	private boolean isWellbeingStudents;
	private String wellbeingStudentsExplain;
	private boolean isPaymentDeadlinesUnmet;
	private String paymentDeadlinesUnmetExplain;
	private boolean isLossRevenue;
	private String lossRevenueExplain;
	private boolean isLegalObligationsUnmet;
	private String legalObligationsUnmetExplain;
	private boolean isLegalHarmUniversity;
	private String legalHarmUniversityExplain;
	private boolean isImpactOtherUnits;
	private String impactOtherUnitsExplain;
	private boolean isImpactBusinessPartners;
	private String impactBusinessPartnersExplain;
	private boolean isOther;
	private String otherExplain;
	
	public Consequences() {
		this.init();
	}

	@Column(name="con_disruption_teaching")
	public boolean isDisruptTeaching() {
		return this.isDisruptTeaching;
	}

	public void setDisruptTeaching(boolean isDisruptTeaching) {
		this.isDisruptTeaching = isDisruptTeaching;
	}

	@Column(name="con_disruption_teaching_explain")
	public String getDisruptTeachingExplain() {
		return this.disruptTeachingExplain;
	}

	public void setDisruptTeachingExplain(String disruptTeachingExplain) {
		this.disruptTeachingExplain = disruptTeachingExplain;
	}

	@Column(name="con_disruption_research")
	public boolean isDisruptResearch() {
		return this.isDisruptResearch;
	}

	public void setDisruptResearch(boolean isDisruptResearch) {
		this.isDisruptResearch = isDisruptResearch;
	}

	@Column(name="con_disruption_research_explain")
	public String getDisruptResearchExplain() {
		return this.disruptResearchExplain;
	}

	public void setDisruptResearchExplain(String disruptResearchExplain) {
		this.disruptResearchExplain = disruptResearchExplain;
	}

	@Column(name="con_disruption_patientcare")
	public boolean isDisruptPatientCare() {
		return this.isDisruptPatientCare;
	}

	public void setDisruptPatientCare(boolean isDisruptPatientCare) {
		this.isDisruptPatientCare = isDisruptPatientCare;
	}

	@Column(name="con_disruption_patientcare_explain")
	public String getDisruptPatientCareExplain() {
		return this.disruptPatientCareExplain;
	}

	public void setDisruptPatientCareExplain(String disruptPatientCareExplain) {
		this.disruptPatientCareExplain = disruptPatientCareExplain;
	}

	@Column(name="con_loss_faculty")
	public boolean isDepartureFaculty() {
		return this.isDepartureFaculty;
	}

	public void setDepartureFaculty(boolean isDepartureFaculty) {
		this.isDepartureFaculty = isDepartureFaculty;
	}

	@Column(name="con_loss_faculty_explain")
	public String getDepartureFacultyExplain() {
		return this.departureFacultyExplain;
	}

	public void setDepartureFacultyExplain(String departureFacultyExplain) {
		this.departureFacultyExplain = departureFacultyExplain;
	}

	@Column(name="con_loss_staff")
	public boolean isDepartureStaff() {
		return this.isDepartureStaff;
	}

	public void setDepartureStaff(boolean isDepartureStaff) {
		this.isDepartureStaff = isDepartureStaff;
	}

	@Column(name="con_loss_staff_explain")
	public String getDepartureStaffExplain() {
		return this.departureStaffExplain;
	}

	public void setDepartureStaffExplain(String departureStaffExplain) {
		this.departureStaffExplain = departureStaffExplain;
	}

	@Column(name="con_loss_students")
	public boolean isDepartureStudents() {
		return this.isDepartureStudents;
	}

	public void setDepartureStudents(boolean isDepartureStudents) {
		this.isDepartureStudents = isDepartureStudents;
	}

	@Column(name="con_loss_students_explain")
	public String getDepartureStudentsExplain() {
		return this.departureStudentsExplain;
	}

	public void setDepartureStudentsExplain(String departureStudentsExplain) {
		this.departureStudentsExplain = departureStudentsExplain;
	}

	@Column(name="con_well_being_staff")
	public boolean isWellbeingFacultyStaff() {
		return this.isWellbeingFacultyStaff;
	}

	public void setWellbeingFacultyStaff(boolean isWellbeingFacultyStaff) {
		this.isWellbeingFacultyStaff = isWellbeingFacultyStaff;
	}

	@Column(name="con_well_being_staff_explain")
	public String getWellbeingFacultyStaffExplain() {
		return this.wellbeingFacultyStaffExplain;
	}

	public void setWellbeingFacultyStaffExplain(String wellbeingFacultyStaffExplain) {
		this.wellbeingFacultyStaffExplain = wellbeingFacultyStaffExplain;
	}

	@Column(name="con_well_being_students")
	public boolean isWellbeingStudents() {
		return this.isWellbeingStudents;
	}

	public void setWellbeingStudents(boolean isWellbeingStudents) {
		this.isWellbeingStudents = isWellbeingStudents;
	}

	@Column(name="con_well_being_students_explain")
	public String getWellbeingStudentsExplain() {
		return this.wellbeingStudentsExplain;
	}

	public void setWellbeingStudentsExplain(String wellbeingStudentsExplain) {
		this.wellbeingStudentsExplain = wellbeingStudentsExplain;
	}

	@Column(name="con_payment_deadline")
	public boolean isPaymentDeadlinesUnmet() {
		return this.isPaymentDeadlinesUnmet;
	}

	public void setPaymentDeadlinesUnmet(boolean isPaymentDeadlinesUnmet) {
		this.isPaymentDeadlinesUnmet = isPaymentDeadlinesUnmet;
	}

	@Column(name="con_payment_deadline_explain")
	public String getPaymentDeadlinesUnmetExplain() {
		return this.paymentDeadlinesUnmetExplain;
	}

	public void setPaymentDeadlinesUnmetExplain(String paymentDeadlinesUnmetExplain) {
		this.paymentDeadlinesUnmetExplain = paymentDeadlinesUnmetExplain;
	}

	@Column(name="con_loss_revenue")
	public boolean isLossRevenue() {
		return this.isLossRevenue;
	}

	public void setLossRevenue(boolean isLossRevenue) {
		this.isLossRevenue = isLossRevenue;
	}

	@Column(name="con_loss_revenue_explain")
	public String getLossRevenueExplain() {
		return this.lossRevenueExplain;
	}

	public void setLossRevenueExplain(String lossRevenueExplain) {
		this.lossRevenueExplain = lossRevenueExplain;
	}

	@Column(name="con_legal_obligations")
	public boolean isLegalObligationsUnmet() {
		return this.isLegalObligationsUnmet;
	}

	public void setLegalObligationsUnmet(boolean isLegalObligationsUnmet) {
		this.isLegalObligationsUnmet = isLegalObligationsUnmet;
	}

	@Column(name="con_legal_obligations_explain")
	public String getLegalObligationsUnmetExplain() {
		return this.legalObligationsUnmetExplain;
	}

	public void setLegalObligationsUnmetExplain(String legalObligationsUnmetExplain) {
		this.legalObligationsUnmetExplain = legalObligationsUnmetExplain;
	}

	@Column(name="con_legal_harm")
	public boolean isLegalHarmUniversity() {
		return this.isLegalHarmUniversity;
	}

	public void setLegalHarmUniversity(boolean isLegalHarmUniversity) {
		this.isLegalHarmUniversity = isLegalHarmUniversity;
	}

	@Column(name="con_legal_harm_explain")
	public String getLegalHarmUniversityExplain() {
		return this.legalHarmUniversityExplain;
	}

	public void setLegalHarmUniversityExplain(String legalHarmUniversityExplain) {
		this.legalHarmUniversityExplain = legalHarmUniversityExplain;
	}

	@Column(name="con_impact_other_campus")
	public boolean isImpactOtherUnits() {
		return this.isImpactOtherUnits;
	}

	public void setImpactOtherUnits(boolean isImpactOtherUnits) {
		this.isImpactOtherUnits = isImpactOtherUnits;
	}

	@Column(name="con_impact_other_campus_explain")
	public String getImpactOtherUnitsExplain() {
		return this.impactOtherUnitsExplain;
	}

	public void setImpactOtherUnitsExplain(String impactOtherUnitsExplain) {
		this.impactOtherUnitsExplain = impactOtherUnitsExplain;
	}

	@Column(name="con_impact_business")
	public boolean isImpactBusinessPartners() {
		return this.isImpactBusinessPartners;
	}

	public void setImpactBusinessPartners(boolean isImpactBusinessPartners) {
		this.isImpactBusinessPartners = isImpactBusinessPartners;
	}

	@Column(name="con_impact_business_explain")
	public String getImpactBusinessPartnersExplain() {
		return this.impactBusinessPartnersExplain;
	}

	public void setImpactBusinessPartnersExplain(
			String impactBusinessPartnersExplain) {
		this.impactBusinessPartnersExplain = impactBusinessPartnersExplain;
	}

	@Column(name="con_other")
	public boolean isOther() {
		return this.isOther;
	}

	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}

	@Column(name="con_other_explain")
	public String getOtherExplain() {
		return this.otherExplain;
	}

	public void setOtherExplain(String otherExplain) {
		this.otherExplain = otherExplain;
	}

	@Transient
	public Map<Consequence.Type, Consequence> getConsequences() {
		Map<Consequence.Type, Consequence> consequences = 
			new HashMap<Consequence.Type, Consequence>();
			
		consequences.put(
				Consequence.Type.DISRUPT_TEACHING, 
				new Consequence(this.isDisruptTeaching(), this.getDisruptTeachingExplain()));
		consequences.put(
				Consequence.Type.DISRUPT_RESEARCH, 
				new Consequence(this.isDisruptResearch(), this.getDisruptResearchExplain()));
		consequences.put(
				Consequence.Type.DISRUPT_PATIENT_CARE, 
				new Consequence(this.isDisruptPatientCare(), this.getDisruptPatientCareExplain()));
		consequences.put(
				Consequence.Type.DEPARTURE_FACULTY, 
				new Consequence(this.isDepartureFaculty(), this.getDepartureFacultyExplain()));
		consequences.put(
				Consequence.Type.DEPARTURE_STAFF, 
				new Consequence(this.isDepartureStaff(), this.getDepartureStaffExplain()));
		consequences.put(
				Consequence.Type.DEPARTURE_STUDENTS, 
				new Consequence(this.isDepartureStudents(), this.getDepartureStudentsExplain()));
		consequences.put(
				Consequence.Type.WELLBEING_FACULTY_STAFF, 
				new Consequence(this.isWellbeingFacultyStaff(), this.getWellbeingFacultyStaffExplain()));
		consequences.put(
				Consequence.Type.WELLBEING_STUDENTS, 
				new Consequence(this.isWellbeingStudents(), this.getWellbeingStudentsExplain()));
		consequences.put(
				Consequence.Type.PAYMENT_DEADLINES_UNMET, 
				new Consequence(this.isPaymentDeadlinesUnmet(), this.getPaymentDeadlinesUnmetExplain()));
		consequences.put(
				Consequence.Type.LOSS_REVENUE, 
				new Consequence(this.isLossRevenue(), this.getLossRevenueExplain()));
		consequences.put(
				Consequence.Type.LEGAL_OBLIGATIONS_UNMET, 
				new Consequence(this.isLegalObligationsUnmet(), this.getLegalObligationsUnmetExplain()));
		consequences.put(
				Consequence.Type.LEGAL_HARM_UNIVERSITY, 
				new Consequence(this.isLegalHarmUniversity(), this.getLegalHarmUniversityExplain()));
		consequences.put(
				Consequence.Type.IMPACT_OTHER_UNITS, 
				new Consequence(this.isImpactOtherUnits(), this.getImpactOtherUnitsExplain()));
		consequences.put(
				Consequence.Type.IMPACT_BUSINESS_PARTNERS, 
				new Consequence(this.isImpactBusinessPartners(), this.getImpactBusinessPartnersExplain()));
		consequences.put(
				Consequence.Type.OTHER, 
				new Consequence(this.isOther(), this.getOtherExplain()));
		
		return consequences;
		
	}
	
	public void setConsequences(Map<Consequence.Type, Consequence> consequences) {
		this.init();
		if (consequences == null) return;
		Set<Consequence.Type> types = consequences.keySet();
		for (Consequence.Type type : types) {
			Consequence consequence = consequences.get(type);
			if (consequence == null) continue;
			boolean isMayOccur = consequence.isMayOccur();
			String explanation = consequence.getExplanation();
			if (type == Consequence.Type.DISRUPT_TEACHING) {
				this.setDisruptTeaching(isMayOccur);
				this.setDisruptTeachingExplain(explanation);
			}
			if (type == Consequence.Type.DISRUPT_RESEARCH) {
				this.setDisruptResearch(isMayOccur);
				this.setDisruptResearchExplain(explanation);
			}
			if (type == Consequence.Type.DISRUPT_PATIENT_CARE) {
				this.setDisruptPatientCare(isMayOccur);
				this.setDisruptPatientCareExplain(explanation);
			}
			if (type == Consequence.Type.DEPARTURE_FACULTY) {
				this.setDepartureFaculty(isMayOccur);
				this.setDepartureFacultyExplain(explanation);
			}
			if (type == Consequence.Type.DEPARTURE_STAFF) {
				this.setDepartureStaff(isMayOccur);
				this.setDepartureStaffExplain(explanation);
			}
			if (type == Consequence.Type.DEPARTURE_STUDENTS) {
				this.setDepartureStudents(isMayOccur);
				this.setDepartureStudentsExplain(explanation);
			}
			if (type == Consequence.Type.WELLBEING_FACULTY_STAFF) {
				this.setWellbeingFacultyStaff(isMayOccur);
				this.setWellbeingFacultyStaffExplain(explanation);
			}
			if (type == Consequence.Type.WELLBEING_STUDENTS) {
				this.setWellbeingStudents(isMayOccur);
				this.setWellbeingStudentsExplain(explanation);
			}
			if (type == Consequence.Type.PAYMENT_DEADLINES_UNMET) {
				this.setPaymentDeadlinesUnmet(isMayOccur);
				this.setPaymentDeadlinesUnmetExplain(explanation);
			}
			if (type == Consequence.Type.LOSS_REVENUE) {
				this.setLossRevenue(isMayOccur);
				this.setLossRevenueExplain(explanation);
			}
			if (type == Consequence.Type.LEGAL_OBLIGATIONS_UNMET) {
				this.setLegalObligationsUnmet(isMayOccur);
				this.setLegalObligationsUnmetExplain(explanation);			
			}
			if (type == Consequence.Type.LEGAL_HARM_UNIVERSITY) {
				this.setLegalHarmUniversity(isMayOccur);
				this.setLegalHarmUniversityExplain(explanation);			
			}
			if (type == Consequence.Type.IMPACT_OTHER_UNITS) {
				this.setImpactOtherUnits(isMayOccur);
				this.setImpactOtherUnitsExplain(explanation);			
			}
			if (type == Consequence.Type.IMPACT_BUSINESS_PARTNERS) {
				this.setImpactBusinessPartners(isMayOccur);
				this.setImpactBusinessPartnersExplain(explanation);
			}
			if (type == Consequence.Type.OTHER) {
				this.setOther(isMayOccur);
				this.setOtherExplain(explanation);
			}
		}
	}
	
	private void init() {
		this.setDisruptTeaching(false);
		this.setDisruptTeachingExplain("");
		this.setDisruptResearch(false);
		this.setDisruptResearchExplain("");
		this.setDisruptPatientCare(false);
		this.setDisruptPatientCareExplain("");
		this.setDepartureFaculty(false);
		this.setDepartureFacultyExplain("");
		this.setDepartureStaff(false);
		this.setDepartureStaffExplain("");
		this.setDepartureStudents(false);
		this.setDepartureStudentsExplain("");
		this.setWellbeingFacultyStaff(false);
		this.setWellbeingFacultyStaffExplain("");
		this.setWellbeingStudents(false);
		this.setWellbeingStudentsExplain("");
		this.setPaymentDeadlinesUnmet(false);
		this.setPaymentDeadlinesUnmetExplain("");
		this.setLossRevenue(false);
		this.setLossRevenueExplain("");
		this.setLegalObligationsUnmet(false);
		this.setLegalObligationsUnmetExplain("");
		this.setLegalHarmUniversity(false);
		this.setLegalHarmUniversityExplain("");
		this.setImpactOtherUnits(false);
		this.setImpactOtherUnitsExplain("");
		this.setImpactBusinessPartners(false);
		this.setImpactBusinessPartnersExplain("");
		this.setOther(false);
		this.setOtherExplain("");
	}
}
