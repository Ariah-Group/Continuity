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
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class TestJasperBasics extends TestCase {
	JasperReportService jrs;

	public void testClass(int x) {
		jrs = new JasperReportServiceImpl();
		jrs.setTitle("this title");
		String title = jrs.getTitle();
		System.out.println(title);
		String classPath = System.getProperty("java.class.path",".");
		System.out.println("Classpath is: "+classPath);
		File dot = new File("");
		System.out.println("Path: "+dot.getAbsolutePath());
	}

	public void testFonts() {
		jrs = new JasperReportServiceImpl();
		jrs.loadFonts("C:/dnld/apps/cal/kcpa/proj/kcpa1005/continuity/src/main/resources/");
		
	}
	public void testLoad() {
		jrs = new JasperReportServiceImpl();
		String fontDir="C:\\windows\\fonts\\";
		jrs.loadFonts("C:\\windows\\fonts\\");
		jrs.loadFont(fontDir+"Vera.ttf","Vera.ttf");
		jrs.loadFont(fontDir+"CALIBRI.ttf","CALIBRI.ttf");
		System.out.println("Done");
	}
	public void testRun() {
		jrs = new JasperReportServiceImpl();
		//jrs.loadFonts("C:\\windows\\fonts\\");
		String thisReport=
		// "C:/ws/wsjasper/JasperWeb/src/FontSample2.jrxml";
			"src/main/resources/reports/Front2.jrxml";
		try {
			Map emptyMap = new HashMap();
			emptyMap.put("PID", new Integer (530));
			FileOutputStream fos = new FileOutputStream(
					new File("c:/tmp/Front2.pdf"));
			jrs.run(thisReport,fos,55, emptyMap);
			fos.close();
			
            
		} catch (Exception e) {
			System.out.println("Exception: " + e + " during testRun");
		}
		System.out.println("Done");
	}	
	
}
