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
package org.kuali.continuity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.google.gwt.i18n.client.DateTimeFormat;

public class DateFormatTest extends TestCase {

	public void testDateDisp() {
		GregorianCalendar now = new GregorianCalendar();
		Date today = (Date) now.getTime();
		System.out.println(today.toString());

			String DATE_FORMAT = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		System.out.println(sdf.format(today));

	}

	public void testDateInput() {
		String testString = "3/1/08";

		Date d = getJavaDateFromString(testString);
		System.out.println(d.toString());
		System.out.println(getJavaDateFromString("4/30/2010"));
		System.out.println(getJavaDateFromString("4/31/2010"));

	}

	Date getJavaDateFromString(String instr) {
		Date ret = null;
		String[] dsec = instr.split("/");
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(GregorianCalendar.MONTH, Integer.parseInt(dsec[0]) - 1);
		gc.set(GregorianCalendar.DATE, Integer.parseInt(dsec[1]));
		int yr = Integer.parseInt(dsec[2]);
		if (yr < 2000) {
			yr = yr + 2000;
		}
		gc.set(GregorianCalendar.YEAR, yr);
		ret = gc.getTime();
		return ret;
	}
    public void testGwtDateFormating() {
    	
    	//DateTimeFormat dtf = DateTimeFormat.getFormat("MM/dd/yyyy");
        Date d = new Date();
        d.setYear(2000-1900);
        
        d.setMonth(0);
        d.setDate(31);
        System.out.println(d);
        d.setYear(8);
        System.out.println(d);
        d.setYear(99);
        System.out.println(d);
        d.setYear(199);
        System.out.println(d);
        System.out.println("Start GWT test");
        System.out.println(getDateFromString("3/1/08"));
        System.out.println(getDateFromString("3/1/99"));
        System.out.println(getDateFromString("3/1/2000"));
        System.out.println(getDateFromString("3/1/00"));
        System.out.println(getDateFromString("3/13/10")); 
        System.out.println(getDateFromString("3/14/10"));  
        System.out.println(getDateFromString("3/15/10"));  
        System.out.println(getDateFromString("3/16/10"));  
    }
	public void checkData(String[] dsec) {
		String dispsep = "";
		for (int i = 0; i < dsec.length; i++) {
			System.out.print(dispsep + dsec[i]);
			dispsep = "/";

		}
	}
	
	Date getDateFromString(String instr) {
		Date ret = new Date();
		String[] dsec = instr.split("/");
		int yr = Integer.parseInt(dsec[2]);
		if (yr < 999) {
			yr = yr + 100;
		} else {
			yr = yr -1900;
		}
//		Calendar gc = Calendar.getInstance();
//		gc.set(Calendar.MONTH, Integer.parseInt(dsec[0]) - 1);
//		gc.set(Calendar.DATE, Integer.parseInt(dsec[1]));
//		gc.set(Calendar.YEAR, yr);
//		ret = gc.getTime();
        ret.setYear(yr);
        ret.setMonth(Integer.parseInt(dsec[0]) - 1);
        ret.setDate(Integer.parseInt(dsec[1]));
        ret.setHours(10);  // This is a Work around for Daylight Savings Time Bug in 1.5.3
        		                  // See: http://code.google.com/p/google-web-toolkit/issues/detail?id=3132
        
		return ret;
	}

}
