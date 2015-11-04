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
package org.kuali.continuity.admin.service;

import java.util.List;

public class AdminReportDisplayService {
	public String useFormat;
	
	public void setUseFormat(String useFormat) {
		this.useFormat = useFormat;
	}
	public  String printReport(AdminReport ar, List list) {
		String ret="";

		return displayGrid(ar,list);
	}
    public String getSortOptionsList(AdminReport ar) {
    	String ret="";
    	for (String s: ar.getSortOptions() ) {
    		ret+="<OPTION value= \""+s+"\">"+s+"<OPTION>\n";
    				
    	}
    	return ret;
    }
    
    public String displayGrid(AdminReport ar, List list) {
    	// String ret="";
    	// Assign first row based on headings.
    	StringBuffer retb=new StringBuffer();
    	System.out.println("s1");
        String s1=initGrid(ar);
        System.out.println("r1");
        String r1=buildFirstRow(ar);
        System.out.println("rs");
        StringBuffer rs=buildRows(ar,list);
        System.out.println("se");
        String se=endGrid();
        // ret=s1+r1+rs+se;
        retb.append(s1);
        retb.append(r1);
        retb.append(rs);
        retb.append(se);
    	return retb.toString();
    }
    public String initGrid(AdminReport ar) {
    	String ret="<TABLE  border=\"1\" cellspacing=\"0\">";
    	return ret;
    }
    public String endGrid() {
    	String ret="</TABLE>";
    	return ret;
    }

    public String buildFirstRow(AdminReport ar) {
    	String ret="<TR>";
    	for (String head: ar.headings) {
    		ret+="<TH>"+head+"</TH>";
    		
    	}
    	ret+="</TR>";
    	return ret;
    }
    public StringBuffer buildRows(AdminReport ar, List<String[]> list) {

    	return ar.buildRows(list, ar.headings);
    }
    

}
