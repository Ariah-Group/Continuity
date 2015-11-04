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


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopyFields;

public interface JasperReportService {
	public void setTitle(String title);
	// public void setReport(String report);
	public String getTitle();
    public void loadFonts(String globalFilePath);
    public boolean loadFont(String fontLocation, String fontID);
    public Map getStartParameters(int pid, String startSql);
    public boolean hasRows(int pid, String startSql);
    public String getInstructionManageTool(String institutionId, String startSql);
    public Map<String, String> getInfo(String institutionId, String startSql);
	public String getReport();
	
// 	public void run(Report report);
	public OutputStream startStream(String output)  throws Exception;
	
	public void closeStream(OutputStream stream)  throws Exception;
	public Integer run(String report,  OutputStream steam, Integer pageStart, Map parameters ) throws Exception;
	public Integer runAdd( String reportToRun, PdfCopyFields outputStream, Integer pageStart, Map parameters) throws Exception;
			
	public Integer run(String report, String outputfile, Integer pageStart, Map parameters) throws Exception;
    // Integer run(OutputStream outputStream, Integer pageStart, Map parameters) throws ClassNotFoundException, SQLException, JRException;
	// public void run(OutputStream outputStream) throws ClassNotFoundException, SQLException, JRException;
    
     void mergePdf(String outfile,List<String> pdfs) throws DocumentException, IOException;
    
}
