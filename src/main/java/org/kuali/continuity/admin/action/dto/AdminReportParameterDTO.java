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
package org.kuali.continuity.admin.action.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.kuali.continuity.admin.service.Nvp;

public class AdminReportParameterDTO implements Serializable {
	
	public String reportId;
	public String reportName;
	public String numberedReportName;
	public String description;
	public List<String> sortNames = new ArrayList<String>();
	public List<Nvp> sortNvp = new ArrayList<Nvp>();
	public Map<String, String> sortMap = new HashMap<String, String>();
	public String exclude;
	public String excludeItem=""; 
	public String excludePhrase="";
	public String rplan;
	public String extracontrol;   // Used for Building List
	public String plannames;
	public boolean issort=true;
	public boolean ispull=false;
	public String sortby;
	public String table;
	public String location; 
	
	

}
