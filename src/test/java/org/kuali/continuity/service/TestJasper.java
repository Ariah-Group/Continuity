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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.DomainObjectTest;

import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.PdfCopyFields;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TestJasper extends DomainObjectTest {
	JasperReportService jasperReportService;

	public void setJasperReportService(JasperReportService jasperReportService) {
		this.jasperReportService = jasperReportService;
	}

	ReportService reportService;
	
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	public void testClass(int x) {
		//jasperReportService = new JasperReportServiceImpl();
		jasperReportService.setTitle("this title");
		String title = jasperReportService.getTitle();
		System.out.println(title);

	}
   
	public void testLoad(int x) {
		jasperReportService = new JasperReportServiceImpl();
		// jrs.loadFonts(int x);
		Set registered = FontFactory.getRegisteredFonts();
		for (Iterator i = registered.iterator(); i.hasNext();) {
			System.out.println((String) i.next());
		}
	}
    public void testStart() {
    	
    	System.out.println("Startup Query:");
    	Map m =jasperReportService.getStartParameters(pid, ReportServiceJasperImpl.startSql);
    	System.out.println("Returned "+m.size());
    	System.out.println(m.get("PID"));
    	for (Object om: m.keySet()) {
    		  String val =  m.get(om).toString();
    		  System.out.println(om.toString()+"="+val);
    	}
    	System.out.println("End Startup Query:");
    }
	public void testFile(int x) {
		try {
			File thisDir = new File(filePath);
			
			System.out.println("Path is: "+thisDir.getAbsolutePath());
			File[] files = thisDir.listFiles();
			for (File f : files) {
				System.out.println(f.getName());
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e + " during testFile");
			fail("failed to load frin target directory - probably won't run.");
		}
	}
	String filePath0="target/continuity/WEB-INF/classes/reports/";
	String filePath="src/main/jasperreports/";
	int pid =1854;
	String srcFolder=filePath;
	String outFolder = "/var/tmp/kcpa/pdfout/";

	public void testRun(int x) {
		jasperReportService = new JasperReportServiceImpl();
		//jrs.setReport("srcFolder+ai.jrxml");
		int pg = 0;
		Map emptyMap = new HashMap();
		try {
			FileOutputStream fos = new FileOutputStream(
					new File("test/out.pdf"));
			pg++;
			jasperReportService.run("srcFolder+ai.jrxml", fos, pg, emptyMap);
			fos.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e + " during testRun");
		}
		System.out.println("Done");
	}

	public void testRunSet0(int x) {
		jasperReportService = new JasperReportServiceImpl();
		// String indir="C:/ws/wsjasper/JasperAssist1/";
		String indir = "C:/dnld/apps/cal/kcpa/proj/kr0125/continuity/target/classes/reports/";
		String[] reports = { "Front1", "Front2", "ai" };
		String thisrpt = "starting";
		Map testMap =jasperReportService.getStartParameters(pid, ReportServiceJasperImpl.startSql);
	
		try {
			FileOutputStream fos = new FileOutputStream(new File(
					"C:/tmp/outall.pdf"));

			for (String report : reports) {
				thisrpt = report+".jrxml";
				// jrs.setReport(indir + report);
				System.out.println("Processing: " + thisrpt);
				jasperReportService.run(indir + thisrpt, fos, 1, testMap );

			}
			fos.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e + " processing " + thisrpt);
		}
	}


	
	
	String[] all = new String[] { "front", "cf", "it", "fr", "kr","ai", "ap"};
	HashMap listMap = new HashMap() {
		{
			put("front", new String[] { "Front1", "Front2",
			"Front3" });
			put("it", new String[] { "IT1", "IT2", "IT3", "IT4", });
			put("kr", "kr1,kr2,kr3,kr4,kr5,kr6,kr7,kr8,kr9,".split(","));
			put("ai",new String[] { "ai" });
			put("cf",new String[] { "cf" });
			put("ap",new String[] { "ap1" });
			put("fr",new String[] { "fp" });
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
    public void testAll(int x) {
    	 List x1 = this.reportList("all");
    	 String sep="";
    	 for (int i=0;i<x1.size();i++) {
    		 System.out.print(sep+(String) x1.get(i));	
    		 sep=", ";
      
    		 
    	 }
    	 System.out.println();
    }
    /** This test is switched off.  It runs without using an OutputStream. 
     * 
     * @param x
     */
	public void testRunSet(int x) {
		jasperReportService = new JasperReportServiceImpl();
		// String indir="C:/ws/wsjasper/JasperAssist1/";
		String indir = "C:/dnld/apps/cal/kcpa/proj/kr0125/continuity/target/classes/reports/";
		
		// String indir = srcFolder;
		String fontDir="C:/windows/fonts/";
		jasperReportService.loadFont(fontDir+"arial.ttf","Helvetica");
		jasperReportService.loadFont(fontDir+"ariali.ttf","Helvetica-Oblique");
		jasperReportService.loadFont(fontDir+"arialbd.ttf","Helvetica-Bold");
		jasperReportService.loadFont(fontDir+"arialbi.ttf","Helvetica-Bold-Oblique");
		// String[] reports = { "Front1", "Front3", "ai", "IT1", "IT2", "IT3",
		// "IT4", };
		// String[] reports = { "fp", "kr1", "kr2", "kr3", "kr4", "kr5", "kr6",
		//		"kr7", "kr8", "kr9" };
		List<String> reports = reportList("all");
				
		String thisrpt = "starting";
		ArrayList<String> pdfs = new ArrayList<String>();
		Map emptyMap = new HashMap();
		GregorianCalendar now = new GregorianCalendar();
		System.out.println("Start time: "+now.getTime());

		try {
			int pg = 1;
			for (String report : reports) {
				thisrpt = report;
				System.out.println("Processing: " + thisrpt);
				String pdfout = outFolder + report + ".pdf";
				pg = pg
						+ jasperReportService.run(indir + report + ".jrxml", pdfout, pg,
								emptyMap);
				pdfs.add(pdfout);

			}
		} catch (Exception e) {
			System.out
					.println("Run Exception: " + e + " processing " + thisrpt);
		}

		try {
			jasperReportService.mergePdf(outFolder + "finalout.pdf", pdfs);
		} catch (Exception e) {
			System.out.println("Exception: " + e + " merging ");
			e.printStackTrace();
			fail("Unable to merge");
		}
		GregorianCalendar then = new GregorianCalendar();
		Long diff = then.getTimeInMillis()-now.getTimeInMillis();
		Double difd = diff/1000.0;
		System.out.println("End time: "+then.getTime()+" difference: "+difd);
	
	}
	String[] littleITTest = { "Front1", "Front2", "ai", "IT1", "IT2", "IT3", "IT4", };
	String[] oneTest ={"Front2"};
	
	/** 
	 * This is the main test.  It uses the OutputStream environment just as deployment does.  It uses the run method 
	 * which continually adds reports to the output stream.
	 */
	public void testRunStream() {
		//jasperReportService = new JasperReportServiceImpl();
		// String indir="C:/ws/wsjasper/JasperAssist1/";
		String indir = srcFolder;
		String fontDir="C:/windows/fonts/";
		jasperReportService.loadFonts(fontDir);
	
		// String[] reports = { "fp", "kr1", "kr2", "kr3", "kr4", "kr5", "kr6",
		//		"kr7", "kr8", "kr9" };
		// List<String> reports = reportList("all");
		List<String> reports = (List<String>) Arrays.asList(oneTest);
				
		String thisrpt = "starting";
		
		Map startMap =jasperReportService.getStartParameters(pid, ReportServiceJasperImpl.startSql);
		String finalpdfout = outFolder + "streamout" + ".pdf";
		System.out.println(startMap.get("OPTION_SECTION"));
		
		try {
			int pg = 1;
			OutputStream outStream= jasperReportService.startStream(finalpdfout);
			for (String report : reports) {
				thisrpt = report;
				System.out.println("Processing: " + thisrpt);
				
				pg = pg
						+ jasperReportService.run(indir + report + ".jrxml", outStream, pg,
								startMap);
			}
			jasperReportService.closeStream(outStream);
		} catch (Exception e) {
			System.out
					.println("Run Exception: " + e + " processing " + thisrpt);
		}

	

	}
	/** Tests actual runAdd
	 * 
	 */
	public void testRunPrint(int x) {
		//jasperReportService = new JasperReportServiceImpl();
		// String indir="C:/ws/wsjasper/JasperAssist1/";
		String indir = srcFolder;
		String fontDir="C:/windows/fonts/";
		jasperReportService.loadFont(fontDir+"arial.ttf","Helvetica");
		jasperReportService.loadFont(fontDir+"ariali.ttf","Helvetica-Oblique");
		jasperReportService.loadFont(fontDir+"arialbd.ttf","Helvetica-Bold");
		jasperReportService.loadFont(fontDir+"arialbi.ttf","Helvetica-Bold-Oblique");
		// String[] reports = { "Front1", "Front3", "ai", "IT1", "IT2", "IT3",
		// "IT4", };
		// String[] reports = { "fp", "kr1", "kr2", "kr3", "kr4", "kr5", "kr6",
		//		"kr7", "kr8", "kr9" };
		//List<String> reports = reportList("it");
		List<String> reports = (List<String>) Arrays.asList(littleITTest);
				
		String thisrpt = "starting";
		ArrayList<String> pdfs = new ArrayList<String>();
		Map startMap =jasperReportService.getStartParameters(pid, ReportServiceJasperImpl.startSql);
		String finalpdfout = outFolder + "streamout" + ".pdf";
		GregorianCalendar now = new GregorianCalendar();
		System.out.println("Start time: "+now.getTime());
//		try {
//			int pg = 1;
//			OutputStream outStream= jasperReportService.startStream(finalpdfout);
//			PdfCopyFields copy = new PdfCopyFields(outStream);
//			
//			for (String report : reports) {
//				thisrpt = report;
//				System.out.println("Processing: " + thisrpt);
//				String pdfout = outFolder + report + ".pdf";
//				int pgadd=jasperReportService.runAdd(indir + report + ".jrxml", copy, pg,
//						startMap);
//				pg = pg +pgadd;
//						+ jasperReportService.runAdd(indir + report + ".jrxml", copy, pg,
//								startMap);
//				
//				pdfs.add(pdfout);
//
//			}
//			copy.close();
//			jasperReportService.closeStream(outStream);
//		} catch (Exception e) {
//			System.out
//					.println("Run Exception: " + e + " processing " + thisrpt);
//			fail("Failed to run report test");
//		}
		GregorianCalendar then = new GregorianCalendar();
		Long diff = then.getTimeInMillis()-now.getTimeInMillis();
		Double difd = diff/1000.0;
		System.out.println("End time: "+then.getTime()+" difference: "+difd);
		
	

	}

}
