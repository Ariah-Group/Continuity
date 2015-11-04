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
package org.kuali.continuity.service;

import java.io.OutputStream;

import org.kuali.continuity.admin.dao.AdminDAOTest;

public class ReportServiceTest extends AdminDAOTest {
	
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	private ReportService reportService;
	
    public void testServiceSetup() {
    	System.out.println("I got here");
    	System.out.println(reportService.getClass().getName());
    }
    
    public void testReportToPrint() {
    	String outFolder = "c:/var/tmp/kcpa/pdfout/";
    	String pdfFileOut = outFolder + "out" + ".pdf";
    	try {
    		OutputStream out=reportService.runPrint(5, "testAcronymPlusName", "bSPACE", "it", pdfFileOut);   		
    		out.close();
    	} catch (Exception e) {
    		System.out.println("Exception during testReport"+e);
    		e.printStackTrace();
    	}
    }
    public void testReportToByteArray(int x) {
        
        	try {
        		OutputStream out=reportService.runPrint(5, "testAcronymPlusName", "bSPACE", "it", "");
        		out.close();
        	} catch (Exception e) {
        		System.out.println("Exception during testReport"+e);
        		e.printStackTrace();
        	}
        }
    public void testRSTJ() {
    	ReportServiceJasperImpl rsji = new ReportServiceJasperImpl();
    	String [] sawyer = (String []) rsji.listMap.get("cf");
    	
    }
}
