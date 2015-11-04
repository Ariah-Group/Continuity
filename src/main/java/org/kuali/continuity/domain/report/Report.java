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
package org.kuali.continuity.domain.report;

import java.util.List;
import java.util.Map;

public class Report {
	Map parameterList;
	boolean jrxmlOrJasper=true;
	String reportFile;
	List parameters2add;
	
	public List getParameters2add() {
		return parameters2add;
	}

	public void setParameters2add(List parameters2add) {
		this.parameters2add = parameters2add;
	}

	public Map getParameterList() {
		return parameterList;
	}

	public void setParameterList(Map parameterList) {
		this.parameterList = parameterList;
	}

	public boolean isJrxmlOrJasper() {
		return jrxmlOrJasper;
	}

	public void setJrxmlOrJasper(boolean jrxmlOrJasper) {
		this.jrxmlOrJasper = jrxmlOrJasper;
	}

	public String getReportFile() {
		return reportFile;
	}

	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getInstituionName() {
		return instituionName;
	}

	public void setInstituionName(String instituionName) {
		this.instituionName = instituionName;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public List<Report> getConcatenated() {
		return concatenated;
	}

	public void setConcatenated(List<Report> concatenated) {
		this.concatenated = concatenated;
	}

	String planName;
	String instituionName;
	Integer planId;
	List <Report> concatenated=null;
	
    public Integer run(Integer page) {
    	
    	if (null!= concatenated) {
    		for (Report r: concatenated) {
    			page=r.run(page);
    		}
    	}
    	return page;
    }
}
