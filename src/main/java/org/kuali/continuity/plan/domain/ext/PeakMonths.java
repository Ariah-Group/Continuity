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
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
@SuppressWarnings("serial")
public class PeakMonths implements Serializable {

	// peak periods
	private String peakJan;
	private String peakFeb;
	private String peakMar;
	private String peakApr;
	private String peakMay;
	private String peakJun;
	private String peakJul;
	private String peakAug;
	private String peakSep;
	private String peakOct;
	private String peakNov;
	private String peakDec;
	private String peaksExplanation;
	
	public PeakMonths() {
		this.init();
	}

	@Column(name="peak_jan")
	public String getPeakJan() {
		return this.peakJan;
	}

	public void setPeakJan(String peakJan) {
		this.peakJan = peakJan;
	}

	@Column(name="peak_feb")
	public String getPeakFeb() {
		return this.peakFeb;
	}

	public void setPeakFeb(String peakFeb) {
		this.peakFeb = peakFeb;
	}

	@Column(name="peak_mar")
	public String getPeakMar() {
		return this.peakMar;
	}

	public void setPeakMar(String peakMar) {
		this.peakMar = peakMar;
	}

	@Column(name="peak_apr")
	public String getPeakApr() {
		return this.peakApr;
	}

	public void setPeakApr(String peakApr) {
		this.peakApr = peakApr;
	}

	@Column(name="peak_may")
	public String getPeakMay() {
		return this.peakMay;
	}

	public void setPeakMay(String peakMay) {
		this.peakMay = peakMay;
	}

	@Column(name="peak_jun")
	public String getPeakJun() {
		return this.peakJun;
	}

	public void setPeakJun(String peakJun) {
		this.peakJun = peakJun;
	}

	@Column(name="peak_jul")
	public String getPeakJul() {
		return this.peakJul;
	}

	public void setPeakJul(String peakJul) {
		this.peakJul = peakJul;
	}

	@Column(name="peak_aug")
	public String getPeakAug() {
		return this.peakAug;
	}

	public void setPeakAug(String peakAug) {
		this.peakAug = peakAug;
	}

	@Column(name="peak_sep")
	public String getPeakSep() {
		return this.peakSep;
	}

	public void setPeakSep(String peakSep) {
		this.peakSep = peakSep;
	}

	@Column(name="peak_oct")
	public String getPeakOct() {
		return this.peakOct;
	}

	public void setPeakOct(String peakOct) {
		this.peakOct = peakOct;
	}

	@Column(name="peak_nov")
	public String getPeakNov() {
		return this.peakNov;
	}

	public void setPeakNov(String peakNov) {
		this.peakNov = peakNov;
	}

	@Column(name="peak_dec")
	public String getPeakDec() {
		return this.peakDec;
	}

	public void setPeakDec(String peakDec) {
		this.peakDec = peakDec;
	}

	@Column(name="explanation")
	public String getPeaksExplanation() {
		return this.peaksExplanation;
	}

	public void setPeaksExplanation(String peaksExplanation) {
		this.peaksExplanation = peaksExplanation;
	}

	@Transient
	public Set<Integer> getPeakMonths() {
		Set<Integer> set = new HashSet<Integer>();
		if (this.isPeak(this.getPeakJan())) set.add(Calendar.JANUARY);
		if (this.isPeak(this.getPeakFeb())) set.add(Calendar.FEBRUARY);
		if (this.isPeak(this.getPeakMar())) set.add(Calendar.MARCH);
		if (this.isPeak(this.getPeakApr())) set.add(Calendar.APRIL);
		if (this.isPeak(this.getPeakMay())) set.add(Calendar.MAY);
		if (this.isPeak(this.getPeakJun())) set.add(Calendar.JUNE);
		if (this.isPeak(this.getPeakJul())) set.add(Calendar.JULY);
		if (this.isPeak(this.getPeakAug())) set.add(Calendar.AUGUST);
		if (this.isPeak(this.getPeakSep())) set.add(Calendar.SEPTEMBER);
		if (this.isPeak(this.getPeakOct())) set.add(Calendar.OCTOBER);
		if (this.isPeak(this.getPeakNov())) set.add(Calendar.NOVEMBER);
		if (this.isPeak(this.getPeakDec())) set.add(Calendar.DECEMBER);
		return set;
	}

	public void setPeakMonths(Set<Integer> peakMonths) {
		this.init();
		if (peakMonths == null) return;
		for (Integer m : peakMonths) {
			switch(m) {
	 	 		case Calendar.JANUARY:	 this.setPeakJan("Y"); break;
	 			case Calendar.FEBRUARY:	 this.setPeakFeb("Y"); break;
				case Calendar.MARCH:	 this.setPeakMar("Y"); break;
				case Calendar.APRIL:	 this.setPeakApr("Y"); break;
				case Calendar.MAY:		 this.setPeakMay("Y"); break;
				case Calendar.JUNE:		 this.setPeakJun("Y"); break;
				case Calendar.JULY:		 this.setPeakJul("Y"); break;
				case Calendar.AUGUST:	 this.setPeakAug("Y"); break;
				case Calendar.SEPTEMBER: this.setPeakSep("Y"); break;
				case Calendar.OCTOBER:	 this.setPeakOct("Y"); break;
				case Calendar.NOVEMBER:	 this.setPeakNov("Y"); break;
				case Calendar.DECEMBER:	 this.setPeakDec("Y"); break;
			}
		}
	}
	
	private boolean isPeak(String peak) {
		return (peak != null ? peak.equalsIgnoreCase("Y") : false);
	}
	
	private void init() {
		this.setPeakJan("N");
		this.setPeakFeb("N");
		this.setPeakMar("N");
		this.setPeakApr("N");
		this.setPeakMay("N");
		this.setPeakJun("N");
		this.setPeakJul("N");
		this.setPeakAug("N");
		this.setPeakSep("N");
		this.setPeakOct("N");
		this.setPeakNov("N");
		this.setPeakDec("N");
		this.setPeaksExplanation("");
	}
}
