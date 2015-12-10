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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.admin.service.SystemDomainUIImageService;
import org.kuali.continuity.domain.UIImageEnum;

import com.lowagie.text.pdf.PdfCopyFields;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ReportServiceJasperImpl implements ReportService {
	
	private static final Logger logger = Logger
	.getLogger(ReportServiceJasperImpl.class);
	String outFolder = "/var/tmp/kcpa/pdfout/";

	JasperReportService jasperReportService;
	SystemDomainService systemDomainService;
	SystemDomainUIImageService systemDomainUIImageService;			

	String headerSql = "select plan_name, key_basic_emergency_contact_copy, key_basic_who_hold,key_facilities, "
		+ "key_basic_who_update, key_basic_who_check_msg, key_basic_who_record_greeting, "
		+ "key_basic_who_post_msg,	key_basic_shared_password, key_basic_comment, "
		+ "not_applicable, na_explain, key_transportation, key_other_resources "
		+ "from plans where pid = ?";
	String startSql0 = "select p.PLAN_NAME, s.institution as INSTITUTION_NAME from plans p join systemdomain s on   p.InstitutionID =s.InstitutionID where p.pid = ? ";

	String startSql1 = "select p.PLAN_NAME, s.institution as INSTITUTION_NAME, CONVERT(VARCHAR(20), p.create_date, 100) as CREATE_DATE, CONVERT(VARCHAR(20), p.last_modified, 100) as LAST_MODIFIED from plans p join systemdomain s on   p.InstitutionID =s.InstitutionID where p.pid = ?";
	String startSql2 = "select p.PLAN_NAME, s.institution as INSTITUTION_NAME, CONVERT(VARCHAR(20), p.create_date, 100) as CREATE_DATE, CONVERT(VARCHAR(20), p.last_modified, 100) as LAST_MODIFIED, p.key_basic_emergency_contact_copy, p.key_basic_who_hold,key_facilities, "
	+ " key_basic_who_update, p.key_basic_who_check_msg, p.key_basic_who_record_greeting, "
	+ " key_basic_who_post_msg,	key_basic_shared_password, p.key_basic_comment, "
	+ " not_applicable, p.na_explain, p.key_transportation, p.key_other_resources from plans p join systemdomain s on   p.InstitutionID =s.InstitutionID where p.pid = ? ";
 
	public final static String startSql =
		"select p.InstitutionID, p.PLAN_NAME, p.PID, s.institution as INSTITUTION_NAME, CONVERT(VARCHAR, p.create_date, 107) as CREATE_DATE, CONVERT(VARCHAR, p.last_modified, 107) as LAST_MODIFIED, p.key_basic_emergency_contact_copy, p.key_basic_who_hold,key_facilities, "
		+ " key_basic_who_update, p.key_basic_who_check_msg, p.key_basic_who_record_greeting, "
		+ " key_basic_who_post_msg,	key_basic_shared_password, p.key_basic_comment, "
		+ " p.not_applicable, p.na_explain, p.key_transportation, p.key_other_resources, "
		+ " p.acad_staff,p.fulltime_staff,parttime_staff,p.student_staff,p.other_staff,res_fellows,p.volunteers,p.guests, "
		+ " p.HeadOfUnitName,p.HeadOfUnitTitle, p.cost_center, p.comment, s.ReplaceStep4Flag "
		+ " from plans p join systemdomain s on  p.InstitutionID =s.InstitutionID where p.pid = ? ";
	
	public final static String instructionSql = " select * from critical_functions where pid = ? and upper(name) = 'INSTRUCTION'";
	public final static String instructionManageSql = " SELECT name, uitext from SystemDomainUIText WHERE institutionid = ?";
	public final static String getInfoSql = " select TeamsScreenFlag, SkillsScreenFlag, StaffingScreenFlag from SystemDomain where InstitutionID = ?";
	public final static String informationSqlIt2 = "select * from it_applications where pid=?  AND disabled <> 'Y'";
	public final static String informationSqlIt3 = "select * from it_servers where pid=?  and disabled <> 'Y'";
	public final static String criticalFunctionSql = 
		"select * from critical_functions " +
			"where pid= ? and (CriticalityLevel <> '4' " +
			"or (CriticalityLevel = '4' and exists (" +
			"select plans.pid from plans, systemdomain " +
			"where plans.institutionid = systemdomain.institutionid " +
			"and systemdomain.CriticalLvlDtlsFlag = 1 " +
			"and plans.pid = critical_functions.pid)))";
	
	// ReportTask [] rts = new ReportTask[] {new ReportTask("kr1"), new ReportTask("kr9")};
   // Map reportMap=MappedList.mapArray(rts);
    // Spring injected
	public void setJasperReportService(JasperReportService jasperReportService) {
		this.jasperReportService = jasperReportService;
	}
	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}	
	public void setSystemDomainUIImageService(
			SystemDomainUIImageService systemDomainUIImageService) {
		this.systemDomainUIImageService = systemDomainUIImageService;
	}
    void loadFonts(String dir) {
    	jasperReportService.loadFonts(dir);
    }
    
    public OutputStream runPrint(int pid, String acronymPlusName,  String institutionId, String section, String pdfDestination) {
    	OutputStream outStream= null;
    	try {
    		outStream= jasperReportService.startStream(pdfDestination);
    		runPrint(pid, acronymPlusName, institutionId, section,"",outStream);
    	} catch (Exception e) {
    		System.out
			.println("runPrint1 Run Exception: " + e + " processing " + section);
    	}
    	return outStream;
    }
	public Map getStartParameters(int pid, String startSql) {
		Map m= jasperReportService.getStartParameters(pid, startSql);
//		String secname="FACULTY PREPAREDNESS";
//	
//		int flag = Integer.parseInt(m.get("ReplaceStep4Flag").toString());
//		if (flag==1) {
//			 secname="INSTRUCTIONAL DEPARTMENT";
//		}
//		m.put("OPTION_SECTION", secname);
		
		return m;
	}
	
	public boolean hasRows(int pid, String startSql) {
		return jasperReportService.hasRows(pid, startSql);	
	}
	
	public String getInstructionManageTool(String institutionId, String startSql){
		return jasperReportService.getInstructionManageTool(institutionId, startSql);
	}
	
	public Map<String, String> getInfo(String institutionId, String startSql){
		return jasperReportService.getInfo(institutionId, startSql);
	}

	String srcFolder ="/WEB-INF/classes/reports/";
    String fontFolder="/fonts/";
    String imageFolder="/images/";
    String report="/reports/";
	@SuppressWarnings("unchecked")
	public void runPrint(int pid, String acronymPlusName, String institutionId, String section, String filePath, OutputStream outStream) {
		// jasperReportService = new JasperReportServiceImpl();
		// String indir="C:/ws/wsjasper/JasperAssist1/";

		String indir = filePath+srcFolder;
		String fontDir=filePath+fontFolder;
		String imageDir = filePath+imageFolder + "begin-report.png";
		String reportDir=filePath+report;
	
		String thisrpt = "starting";
		ArrayList<String> pdfs = new ArrayList<String>();
		String fs=System.getProperty("file.separator");
		fontFolder=fs+"WEB-INF"+fs+"classes"+fs;

		GregorianCalendar now = new GregorianCalendar();
		System.out.println("Start time: "+now.getTime());

		Map startParameterMap =  getStartParameters(pid,  startSql); //rpd.getParameters(jasperReportService.getConnection(), startSql, new Integer(436));
		
		
		boolean hasInstructionRows = false;
		boolean hasInformationRowsIt2 = false;
		boolean hasInformationRowsIt3 = false;
		boolean hasCriticalFunction = false;
		hasInstructionRows = hasRows(pid, instructionSql);
		hasInformationRowsIt2 = hasRows(pid, informationSqlIt2);
		hasInformationRowsIt3 = hasRows(pid, informationSqlIt3);
		hasCriticalFunction = hasRows(pid, criticalFunctionSql);
		
		String instructionManageTool = getInstructionManageTool(institutionId, instructionManageSql);
		Map<String, String> infoMap = getInfo(institutionId, getInfoSql);
		String optionSection = "FACULTY PREPAREDNESS";
		
		System.out.println("	Is instruction size > 0?  " + hasInstructionRows);
		
		if (section.equals("fr") && ((String)startParameterMap.get("OPTION_SECTION")).equals("INSTRUCTION") && !hasInstructionRows){
			section = "in-no-data";
		} else if(section.equals("fr") && ((String)startParameterMap.get("OPTION_SECTION")).equals("INSTRUCTION")){
			section = "in";
		} else if (section.equals("all") && ((String)startParameterMap.get("OPTION_SECTION")).equals("INSTRUCTION") && hasInstructionRows){
			all[3] = "in";
		} else if (section.equals("all") && ((String)startParameterMap.get("OPTION_SECTION")).equals("INSTRUCTION") && !hasInstructionRows){
			all[3] = "in-no-data";
		} 
		
		if(!hasCriticalFunction){
			((String[])listMap.get("cf"))[0] = "cf1-no-data";
		} else{
			((String[])listMap.get("cf"))[0] = "cf1";
		}
		
		if (!hasInformationRowsIt2){
			((String[])listMap.get("it"))[1] = "IT2-no-data";
		} else{
			((String[])listMap.get("it"))[1] = "IT2";
		}
		
		if (!hasInformationRowsIt3){
			((String[])listMap.get("it"))[2] = "IT3-no-data";
		} else{
			((String[])listMap.get("it"))[2] = "IT3";
		}
		
		boolean isLbnl = this.systemDomainService.getById(Integer.parseInt(institutionId)).isLBNL();
		
		if(((String)startParameterMap.get("OPTION_SECTION")).equals("FACULTY PREPAREDNESS")){
			((String[])listMap.get("front"))[1] = "Front2-prepareness";
			if(isLbnl){
				optionSection = "PI PREPAREDNESS";
			} else{
				optionSection = "FACULTY PREPAREDNESS";
			}
		} else if (((String)startParameterMap.get("OPTION_SECTION")).equals("INSTRUCTION")){
			((String[])listMap.get("front"))[1] = "Front2";
			optionSection = "INSTRUCTION";
		}
		
		String systemName = this.systemDomainService.getSystemName(Integer.parseInt(institutionId));
		boolean customImage = false;
		
		if (this.systemDomainUIImageService.getImageByOwnerIdAndImageEnum(Integer.parseInt(institutionId), UIImageEnum.BANNER) != null){
			customImage = true;
		}		
		
		startParameterMap.put(ReportServiceEnum.IN_DIR.toString(), indir);
		startParameterMap.put(ReportServiceEnum.IMAGE_DIR.toString(), imageDir);
		startParameterMap.put(ReportServiceEnum.INSTITUTION_ID.toString(), instructionManageTool);
		startParameterMap.put(ReportServiceEnum.OPTION_SECTION.toString(), optionSection);
		startParameterMap.put(ReportServiceEnum.REPORT_DIR.toString(), reportDir);
		startParameterMap.put(ReportServiceEnum.TEAMS_SCREEN_FLAG.toString(), infoMap.get("TeamsScreenFlag"));
		startParameterMap.put(ReportServiceEnum.SKILLS_SCREEN_FLAG.toString(), infoMap.get("SkillsScreenFlag"));
		startParameterMap.put(ReportServiceEnum.STAFFING_SCREEN_FLAG.toString(), infoMap.get("StaffingScreenFlag"));
		startParameterMap.put(ReportServiceEnum.ACRONYM_PLUS_NAME.toString(), acronymPlusName);
		startParameterMap.put(ReportServiceEnum.SYSTEM_NAME.toString(), systemName);		
		startParameterMap.put(ReportServiceEnum.DOMAIN_ID.toString(), institutionId);
		startParameterMap.put(ReportServiceEnum.LNBL.toString(), new Boolean(isLbnl));
		startParameterMap.put(ReportServiceEnum.CUSTOM_IMAGE.toString(), new Boolean(customImage));
		
		List<String> reports = reportList(section);		
		try {
			int pg = 1;
            loadFonts(fontDir);
			PdfCopyFields copy = new PdfCopyFields(outStream);
						
			for (String report : reports) {
				thisrpt = report;
				System.out.println("runPrint: Processing: " + thisrpt);
				String pdfout = outFolder + report + ".pdf";
					
				pg = pg + jasperReportService.runAdd(indir + report + ".jrxml", copy, pg, startParameterMap);
				
				pdfs.add(pdfout);

			}
			copy.close();
			jasperReportService.closeStream(outStream);
		} catch (Exception e) {
			System.out
					.println("runPrint2: Run Exception: " + e + " processing " + thisrpt);
			e.printStackTrace();
		}
		GregorianCalendar then = new GregorianCalendar();
		Long diff = then.getTimeInMillis()-now.getTimeInMillis();
		Double difd = diff/1000.0;
		System.out.println("RSJI: End time: "+then.getTime()+" difference: "+difd);


	}
	
	String[] all = new String[] { "front", "cf", "it", "fr", "kr","ai", "ap"};
	@SuppressWarnings("unchecked")
	HashMap listMap = new HashMap() {
		{
			put("front", new String[] { "Front1", "Front2","Front3" });
			put("it", new String[] { "IT1", "IT2", "IT3", "IT4","IT5"});
			put("kr", "kr1,kr2,kr3,kr4,kr5,kr6,kr7,kr8,kr9,".split(","));  //kr5 needs to be fixed.
			put("ai",new String[] { "ai" });
			put("cf",new String[] { "cf1" });
			put("ap",new String[] { "ap1" });
			put("fr",new String[] { "fp" });
			put("in",new String[] { "in" });
			put("in-no-data",new String[] { "in-no-data" });
			put("IT2-no-data",new String[] { "IT2-no-data" });
			put("IT3-no-data",new String[] { "IT3-no-data" });
			put("cf1-no-data",new String[] { "cf1-no-data" });
//			put("in_subreport1",new String[] { "in_subreport1" });
		}
	};
	
	
	
	List reportList(String listName) {
		List ret= (List) new ArrayList();
		if (!(listName.equals("all"))) {
			String [] sarray =(String []) listMap.get(listName);
		    ret=  Arrays.asList(sarray);
		} else {

			for (String sp: all) {
				String[] sa = (String []) listMap.get(sp);
				for (String s:sa) {
					ret.add(s);
				}

			}
		}
        return   ret;
	}


}
