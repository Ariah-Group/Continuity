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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.export.*;

public class JasperReportServlet extends HttpServlet {
	/**
	 * We  get a get Request on openning the PDF display page.
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.10.85:1521:oracledb", "xyz",
					"abc");

			// create a map of parameters to pass to the report.
			Map parameters = new HashMap();
			parameters.put("Report_Title", "Salesman Details");

			// load JasperDesign from XML and compile it into JasperReport
			jasperDesign = JRXmlLoader.load("C:/jasperReports/demo.jrxml");
			jasperReport = JasperCompileManager.compileReport(jasperDesign);

			// fill JasperPrint using fillReport() method
			jasperPrint = JasperFillManager.fillReport(jasperReport,
					parameters, conn);

			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:/jasperReports/demo.pdf");
			response.setContentType("application/pdf");
			// for creating report in excel format
			JRXlsExporter exporterXls = new JRXlsExporter();
			exporterXls.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
			exporterXls.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
					"C:/jasperReports/demo.xls");
			exporterXls.exportReport();
			JasperExportManager.exportReportToPdfStream(jasperPrint,
					servletOutputStream);

			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("No such class found!");
		} catch (JRException e) {
			// display stack trace in the browser
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		} finally {
			// close the connection.
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ignored) {
				}
			}
		}
	}
}
