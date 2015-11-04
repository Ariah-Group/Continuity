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
package org.kuali.continuity.admin.service.util;

import java.util.List;

import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.AdminReport;

public class PlanString {
	
	public static String  parse(String selectedPlan, AdminReport ar) {
		String ret="";
		if (null != selectedPlan
				&& selectedPlan.trim().length() > 0) {
			
			String planarg = selectedPlan.trim() + "%";
			// Replace left most character.
            
			if (planarg.charAt(0) == '*') {
				planarg = "%" + planarg.substring(1);

				if (planarg.equals("%%")) {
					planarg = "";
					;
				}
			}
			if (planarg.length() > 0) {
				planarg = ar.filterSearchString(planarg);
				ret= ar.optionString(planarg);
				System.out.println("planarg: " + planarg);
				// argList.add(planarg);
			}
		}
		return ret;
	}
	
	public static String planList2String(List<Object[]> list){
		String ret = "";
		for(int i=0; i < list.size(); i++){			
			ret += list.get(i)[0] + ", ";
		}
		return ret.substring(0, ret.length() - 2);
	}
	
	public static String userList2String(List<User> list){
		String ret = "";
		
		for(User user : list){			
			ret += user.getAuthId() + ", ";
		}
		return ret.substring(0, ret.length() - 2);
	}

}
