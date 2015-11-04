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
package org.kuali.continuity.report.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.action.dto.UITextDTO;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;
import org.kuali.continuity.service.ReportService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class PrintActionServlet extends HttpServlet {
	private static final Logger logger = Logger
			.getLogger(PrintActionServlet.class);

	WebApplicationContext context = null;
	
	ReportService reportService = null;
    String [] sec = {"cf", "it", "fr", "kr", "ai" };
    String actualPath="";
	public void init() {
		logger.info("Context Startup Begin");
		context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		// setItemService((ItemService) context.getBean("itemService"));
		logger.info("Context Startup Complete");
		ReportService impl = null;
		reportService = (ReportService) context.getBean("reportService");
		ServletContext scontext= this.getServletContext();
		actualPath=scontext.getRealPath("");
        System.out.println("Actual Path: "+actualPath);
	}

	/**
	 * We get a get Request on opening the PDF display page.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream servletOutputStream = response.getOutputStream();
		Connection conn = null;
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		JasperDesign jasperDesign;

		try {
			// get a database connection
			System.out.println("Start printActionServlet");
			
            Enumeration<String> pnames= request.getParameterNames();
           // PrintWriter out = response.getWriter();
           
//    	    while (pnames.hasMoreElements()) {
//    			String p = pnames.nextElement().toString();
//    			out.print("<TD>"+p);
//    			out.print("</TD>");
//				out.print("<TD>"+request.getParameter(p));
//				out.print("</TD>");
//    		}
			int entireNum =  Integer.parseInt(request.getParameter("entire"));
			int sectionNum = Integer.parseInt( request.getParameter("section"));
			System.out.print("got "+entireNum+" "+sectionNum);
			String section="all";
			if (entireNum==1) {
				section=sec[sectionNum];
			}
			String classPath = System.getProperty("java.class.path",".");
			System.out.println("Classpath is: "+classPath);
			ServletContext context = this.getServletContext();
			HttpSession session = request.getSession();
			
			SessionPlanDTO planDto = new SessionPlanDTO();
			String planKey = SessionKey.plan.toString();
			try {
				Object oplanDto= session.getAttribute(SessionKey.plan.toString());
			    planDto = (SessionPlanDTO) oplanDto;
			 
			} catch (Exception e) {
				System.out.println("Exception in Print Action get planDto for "+planKey+": "+e);
			}
			int pid =planDto.getId();
			System.out.println("GOT PLAN ID: "+pid);
			String filePath=context.getRealPath("");
			System.out.println("Real Path: "+filePath);
			File dot = new File("");
			System.out.println("Path: "+dot.getAbsolutePath());
			System.out.println(" section: "+section);
			String acronymPlusName = planDto.acronymPlusName; 
			System.out.println(" acronymPlusName: " + acronymPlusName);
			// create a map of parameters to pass to the report.
			Map parameters = new HashMap();
			boolean testMode=false;
			if (testMode) {
				System.out.println("Test mode");
				parameters.put("Report_Title", "Salesman Details");

				// load JasperDesign from XML and compile it into JasperReport
				jasperDesign = JRXmlLoader.load("C:/jasperReports/demo.jrxml");
				jasperReport = JasperCompileManager.compileReport(jasperDesign);
    			// fill JasperPrint using fillReport() method
				jasperPrint = JasperFillManager.fillReport(jasperReport,
						parameters, conn);

				JasperExportManager.exportReportToPdfFile(jasperPrint,
						"C:/jasperReports/demo.pdf");
			}

			if (reportService != null) {
				response
						.setContentType("application/pdf; name=\"contiunity.pdf\"");
				response.setHeader("Content-Disposition",
						"inline;filename=\"contiunity.pdf\"");
				//UITextDTO uiTextDto = (UITextDTO)session.getAttribute(SessionKey.uiText.toString());
				
				SystemDomainDTO systemDomainDto = (SystemDomainDTO)session.getAttribute(SessionKey.systemDomain.toString());
				String institutionId = Integer.toString(systemDomainDto.id);
				
				//String uiText = uiTextDto.textMap.get("uiText");
				reportService.runPrint(pid, acronymPlusName, institutionId, section, filePath, servletOutputStream);
                System.out.println("Servlet: doGet Report Finished.");
			} else {
				System.out.println("No Report Service");
			}

			servletOutputStream.flush();
			servletOutputStream.close();

		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());

		} catch (Exception e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());

		}
	}

}
