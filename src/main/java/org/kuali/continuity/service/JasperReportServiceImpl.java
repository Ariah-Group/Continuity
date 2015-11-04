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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;
import org.kuali.continuity.domain.report.Report;
import org.kuali.continuity.report.ReportParameterData;

import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfCopyFields;
import com.lowagie.text.pdf.PdfReader;


public class JasperReportServiceImpl implements JasperReportService {
	private static final Logger logger = Logger
	.getLogger(JasperReportServiceImpl.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	DataSource dataSource;
	Connection mainconn = null;
    boolean serverMode=false;
	String title;
	String globalReport = ""; // C:/ws/wsjasper/JasperWeb/src/ActionITem.jrxml";
	String globalFilePath = "";
	static boolean fontsLoaded = false;

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		if (mainconn == null) {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			if (serverMode ) {
			conn = DriverManager
					.getConnection(
							// "jdbc:oracle:thin:@192.168.10.85:1521:oracledb",
							// "xyz","abc"
							"jdbc:jtds:sqlserver://sql-dnon02.ist.berkeley.edu:1433;DatabaseName=UCReady",
							"restart_app", "RB7erk.ley");
		   } else {
			      logger.info("Reports connecting to Kuali Ready");
			      conn = dataSource.getConnection();
		   }
		
			mainconn = conn;
			
		} else {
			logger.info("Using existing connection");
			conn = mainconn;
		}
		
		return conn;
	}

	public void dropConnection(Connection conn, boolean temporaryConn) {
		if (conn != null) {
			try {
				conn.close();
				mainconn = null;
			} catch (Exception e) {
				logger.warn("Unable to close connection: ",e);
			}
		} else {
			if (mainconn != null)
				try {
					mainconn.close();
				} catch (SQLException e) {
					logger.warn("Unable to close main connection: ", e);
					
				}
			mainconn = null;
		}
	}

	public void loadFonts(String gfp) {
		if (!fontsLoaded) {
			
			globalFilePath=gfp;
			
			loadFont(gfp+"arial.ttf","Arial");
	
		}
		logger.info("Fonts are registered.");
		// System.out.println("Fonts loaded.");
		fontsLoaded = true;

	}
    
	public boolean loadFont(String fontLocation, String fontName) {
		boolean ret=false;
		try {
			FontFactory.register(fontLocation, fontName);
			ret=true;
		} catch (Exception de) {
			logger.warn(" loadFont exception: ", de);
		}
		return ret;
	}

	public String getTitle() {
		return title;
	}

	public String getReport() {
		return globalReport;
	}

	public Map getStartParameters(int pid, String startSql) {
		ReportParameterData rpd = new ReportParameterData();
		Map ret = null;
		Connection conn = null;

		try {
			conn = getConnection();
			ret = rpd.getParameters(getConnection(), startSql, new Integer(pid));
			String secname="FACULTY PREPAREDNESS";
			int flag = Integer.parseInt(ret.get("ReplaceStep4Flag").toString());
			if (flag==1) {
				 secname="INSTRUCTION";
			}
			ret.put("OPTION_SECTION", secname);
		} catch (Exception e) {
			logger.warn("Start Parameter Exception: ", e);
			e.printStackTrace();
		} finally {
			if (conn != null && serverMode) {
				try {
					dropConnection(conn, false);
				} catch (Exception e) {
					logger.warn("Start Parameter Unable to close Exception: "
									+ e);
					e.printStackTrace();
				}
			}
		}

		return ret;
	}
	
	public boolean hasRows(int pid, String startSql) {
		ReportParameterData rpd = new ReportParameterData();
		Connection conn = null;

		try {
			conn = getConnection();
			return rpd.hasRows(getConnection(), startSql, new Integer(pid));
		} catch (Exception e) {
			logger.warn("Start Parameter Exception: ", e);
			e.printStackTrace();
		} finally {
			if (conn != null && serverMode) {
				try {
					dropConnection(conn, false);
				} catch (Exception e) {
					logger.warn("Start Parameter Unable to close Exception: " + e);
					e.printStackTrace();
				}
			}
		}

		return false;
	}
	
	public String getInstructionManageTool(String institutionId, String startSql) {
		ReportParameterData rpd = new ReportParameterData();
		// List<String> retList = null;
		Map resultMap = null;
		Connection conn = null;
		try {
			conn = getConnection();
			resultMap = rpd.getParameters(conn, startSql, institutionId);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultMap.isEmpty()){
			return "bSPACE";
		} else{
			return (String)resultMap.get("uitext");
		}
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getInfo(String institutionId, String startSql) {
		ReportParameterData rpd = new ReportParameterData();
		// List<String> retList = null;
		Map<String, String> resultMap = null;
		Connection conn = null;
		try {
			conn = getConnection();
			//String institutionId = (String) super.getParameterValue("InstitutionID");
			// retList = rpd.getValueList(conn, buildingSql, id, ",");
			resultMap = rpd.getParameters(conn, startSql, institutionId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultMap.get("TeamsScreenFlag") != null && ((String)resultMap.get("TeamsScreenFlag")).equals("1")){
			resultMap.put("TeamsScreenFlag", "1");
		} else{
			resultMap.put("TeamsScreenFlag", "0");
		}
		
		if(resultMap.get("SkillsScreenFlag") != null && ((String)resultMap.get("SkillsScreenFlag")).equals("1")){
			resultMap.put("SkillsScreenFlag", "1");
		} else{
			resultMap.put("SkillsScreenFlag", "0");
		}
		
		if(resultMap.get("StaffingScreenFlag") != null && ((String)resultMap.get("StaffingScreenFlag")).equals("1")){
			resultMap.put("StaffingScreenFlag", "1");
		} else{
			resultMap.put("StaffingScreenFlag", "0");
		}
		
		return resultMap;
	}
	
	JRLoader jrLoader = new JRLoader();

	void run0(OutputStream outputStream) throws ClassNotFoundException,
			SQLException, JRException {
		Connection conn = getConnection();
		// loadFonts();
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		JasperDesign jasperDesign;
		// create a map of parameters to pass to the report.
		Map parameters = new HashMap();
		parameters.put("Report_Title", title);
		// System.out.println("Setting page number: " + 1);
		parameters.put("PAGE_NUMBER", 1);
		// load JasperDesign from XML and compile it into JasperReport
		jasperDesign = JRXmlLoader.load(globalReport);
		jasperReport = JasperCompileManager.compileReport(jasperDesign);

		// fill JasperPrint using fillReport() method

		// response.setContentType("application/pdf");

		// JRVariable[] jvs =jasperReport.getVariables();
		// System.out.println("Variables");
		// for (JRVariable jv: jvs) {
		// System.out.println(jv.getName()+" "+jv.getExpression().getText());
		// }
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
				conn);
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		dropConnection(conn, false);

	}

	// No page number given. But set JASPER_PRINT_LIST
	Integer run(OutputStream outputStream, String reportToRun,
			Integer pageStart, Map parameters) throws ClassNotFoundException,
			SQLException, JRException {
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		JasperDesign jasperDesign;
		Connection conn = getConnection();
		// loadFonts();
		// create a map of parameters to pass to the report.
		if (null == pageStart) {
			pageStart = 1;
		}
		// System.out.println("JRS: Setting page number: " + pageStart);
		parameters.put("PAGE_NUMBER", pageStart);
		parameters.put("Report_Title", title);
		// JRExporterParameter.JASPER_PRINT_LIST=printList;
		// JRExporterParameter jasperList = new JRExporterParameter();

		// load JasperDesign from XML and compile it into JasperReport
		jasperDesign = JRXmlLoader.load(reportToRun);
		jasperReport = JasperCompileManager.compileReport(jasperDesign);

		// fill JasperPrint using fillReport() method
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
				conn);
		int npages = jasperPrint.getPages().size();
		// System.out.println("I got " + npages + " pages.");
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
		dropConnection(conn, false);
		return npages;

	}

	/***
	 * runAdd: calling program opens the final output stream
	 * 
	 * @throws IOException
	 * @throws DocumentException
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Integer runAdd(String reportToRun, PdfCopyFields outputStream,
			Integer pageStart, Map parameters) throws Exception {
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		JasperDesign jasperDesign;
		Connection conn = getConnection();
		// loadFonts();
		// create a map of parameters to pass to the report.
		if (null == pageStart) {
			pageStart = 1;
		}
		// System.out.println("JRS:runAdd Setting page number: " + pageStart);
		parameters.put("PAGE_NUMBER", pageStart);
		parameters.put("Report_Title", title);
		// JRExporterParameter.JASPER_PRINT_LIST=printList;
		// JRExporterParameter jasperList = new JRExporterParameter();

		// load JasperDesign from XML and compile it into JasperReport
		// System.out.println("JRS:runAdd loadingReport: "+reportToRun);
		jasperDesign = JRXmlLoader.load(reportToRun);
		jasperReport = JasperCompileManager.compileReport(jasperDesign);
		// jasperReport = (JasperReport) JRLoader.loadObject(new
		// File(reportToRun+".jasper"));

		// fill JasperPrint using fillReport() method
		// System.out.println("JRS:runAdd running Fill Manager.fillReport: " +jasperReport.getName());
		jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
				conn);
		// System.out.println("JRS:runAdd finished. ");
			
		int npages = jasperPrint.getPages().size();
		// System.out.println(" 	npages is: " + npages);
		// jasperPrint can now be added to stream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

		mergeNextPdf(baos, outputStream, npages);
		// System.out.println("I got " + npages + " pages.");
		dropConnection(conn, false);
		return npages;

	}

	// Override
	public void setReport(String report) {
		this.globalReport = report;

	}

	// Override
	public void setTitle(String title) {
		this.title = title;

	}

	// Override
	public Integer run(String report, String outputfile, Integer pageStart,
			Map params) throws Exception {

		FileOutputStream fos = new FileOutputStream(new File(outputfile));
		Integer npages = this.run(fos, report, pageStart, params);
		fos.close();
		return npages;

	}

	// Override
	public void mergePdf(String outfile, List<String> pdfs)
			throws DocumentException, IOException {
//		File test = new File("/");
//		String[] flist = test.list();
//		for (String f : flist) {
			// System.out.println(f);
//		}
		FileOutputStream baos = new FileOutputStream(new File(outfile));
		PdfCopyFields copy = new PdfCopyFields(baos);

//		int i = 0;
		for (String pdf : pdfs) {
			copy.addDocument(new PdfReader(pdf));
		}
		copy.close();
	}

	void mergeNextPdf(ByteArrayOutputStream baos, PdfCopyFields pdfCopyOut,
			int npages) throws DocumentException, IOException {

		// FileOutputStream baos = new FileOutputStream(new File(outfile));
		// PdfCopyFields copy = new PdfCopyFields(baos);

//		int i = 0;
		// Jasper produces blank reports if there is no detail section.
//		if (npages > 0) {
//			pdfCopyOut.addDocument(new PdfReader(new ByteArrayInputStream(baos
//					.toByteArray())));
//		}
//		
		pdfCopyOut.addDocument(new PdfReader(new ByteArrayInputStream(baos
				.toByteArray())));

	}

	public void run(Report report) {
		// TODO Auto-generated method stub

	}

	public Integer run(String report, OutputStream outStream,
			Integer pageStart, Map parameters) throws Exception {
		Integer npages = this.run(outStream, report, pageStart, parameters);

		return npages;

	}

	public OutputStream startStream(String outputfile) throws Exception {
		OutputStream outputStream = null;
		if (outputfile.length() > 0) {
			outputStream = (OutputStream) new FileOutputStream(new File(
					outputfile));
		} else {
			outputStream = (OutputStream) new ByteArrayOutputStream();

		}

		return outputStream;
	}

	public void closeStream(OutputStream stream) throws Exception {
		stream.close();

	}

}
