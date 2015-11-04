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
package org.kuali.continuity.action.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SystemDomainDisplayConstantsDTO implements Serializable {
	
	public String deptHeader;
	public String keyResource;
	public String criticalUpper;
	public String criticalLower;
	public String resumeDays;
	public String facultyPrepare;  
	public String facultyPrepareShort;  
	public String facultyPreparePrint;  
	public String facultyPreparePrintUPPER;
	public String article;
	
	public SystemDomainDisplayConstantsDTO(boolean isLBNL) {
		if (isLBNL) {
			this.deptHeader 				= "Division/Department Identification";
			this.keyResource 				= "in your campus, medical center or LBNL";
			this.criticalUpper 				= "Essential";
			this.criticalLower 				= "essential";
			this.resumeDays 				= "45";  
			this.facultyPrepare 			= "Principal Investigator/Faculty";
			this.facultyPrepareShort 		= "PI";  
			this.facultyPreparePrint 		= "Principal Investigators/Faculty";  
			this.facultyPreparePrintUPPER 	= "PI";
			this.article 					= "an";
		} else {
			this.deptHeader 				= "Department Identification";
			this.keyResource 				= "in your campus or medical center";
			this.criticalUpper 				= "Critical";
			this.criticalLower 				= "critical";
			this.resumeDays 				= "30";
			this.facultyPrepare 			= "Faculty";  
			this.facultyPrepareShort 		= "Faculty";  
			this.facultyPreparePrint 		= "Faculty";  
			this.facultyPreparePrintUPPER 	= "FACULTY";
			this.article 					= "a";
		}
	}
		
}
