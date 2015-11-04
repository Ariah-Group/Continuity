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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * AdminReport defines a Report. It has an Id that it can be looked up by (used
 * to load a hashmap) It has a name and a description, knows how to run itself
 * (SQL and optional SQL) and how to display itself (Headings)
 * 
 * @author richkatz
 */
public class AdminReport {
	public static String SORTDIV = ",";
	public static String SORTDIV2 = "`";
	public static String SPLITDIV = "/";
	public static String SPLITDIV2 = ":";
	String id;
	String name;
	String numberedName;
	String description;
	String excludeitem = ""; // Test in Action is for length.
	String excludePhrase = "";
	String[] sorts = null;
	
	// Special Selection data
	String specialSelectionSql=null;
	
	public String specialName=null;

	String specialSelectionClause=null;

	public String getSpecialSelectionSql() {
		return specialSelectionSql;
	}

	public void setSpecialSelectionSql(String specialSelectionSql) {
		this.specialSelectionSql = specialSelectionSql;
	}

	public String getSpecialSelectionClause() {
		return specialSelectionClause;
	}

	public void setSpecialSelectionClause(String specialSelectionClause) {
		this.specialSelectionClause = specialSelectionClause;
	}

	public String getNumberedName() {
		return numberedName;
	}

	public void setNumberedName(String numberedName) {
		this.numberedName = numberedName;
	}

	public String extraParam() {
		return "";
	}

	HashMap sortMap = new HashMap();
	HashMap sortValues = new HashMap();
	public ArrayList<Nvp> sortList = new ArrayList<Nvp>();
	
	String sql = null;
	String[] headings = null;
	TopBand topBandProcess = null;





	public TopBand getTopBandProcess() {
		return topBandProcess;
	}

	public void setTopBandProcess(TopBand topBandProcess) {
		this.topBandProcess = topBandProcess;
	}

	public String[] getHeadings() {
		return headings;
	}

	public void setHeadings(String[] headings) {
		this.headings = headings;
	}

	void loadSortMap(String[] sorts) {

		this.sorts = sorts;

		for (String s : this.sorts) {
			String splitby = SPLITDIV2;
			if (s.indexOf(splitby) <0) {
				splitby = SPLITDIV;
			}
			String nvparr[] = s.split(splitby);
			String value = "";
			if (nvparr.length <= 1) {
				value = nvparr[0];
			} else {
				value = nvparr[1];
			}
			// if (null!=nvp[0] && nvp[0].length()>0) {
			System.out.println("loadSortMap loading: key: " + nvparr[0]
					+ "  value: " + value);
			sortMap.put(nvparr[0], value);

			sortValues.put(value, nvparr[0]);
			Nvp nvp = new Nvp(nvparr[0], value);
			this.sortList.add(nvp);

		}

	}
    public ArrayList<Nvp> getSpecialList(String nvpSql) {
    	ArrayList<Nvp> specialList=null;
    	
    	return specialList;
    	
    }
	public String[] splitup(String stringin) {

		String[] ret = {""};
		if (stringin.indexOf(SORTDIV2) > -1) {
			// System.out.print("Using Div2");
			ret = stringin.split(SORTDIV2);
		} else {
			// System.out.print("Using Div1");
			ret=stringin.split(SORTDIV);
		}
		 System.out.print("Split into: ");
       for (String s: ret) {
    	   //System.out.print("["+s+"] ");
       }
       //System.out.println("");
		return ret;
	}

	/**
	 * Constructor for AdminReport.
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param sorts
	 * @param sql
	 * @param headingStr
	 */
	public AdminReport(String id, String name, String description,
			String sorts, String sql, String headingStr, String excludePhrase,
			String exclude) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));
		this.sql = sql;
		this.headings = headingStr.split(",");
		this.excludePhrase = excludePhrase;
		this.excludeitem = exclude;
	}

	public AdminReport(String id, String name, String description,
			String sorts, String sql, String headingStr, String excludePhrase) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));
		this.sql = sql;
		this.headings = headingStr.split(",");
		this.excludePhrase = excludePhrase;

	}

	public String getExcludePhrase() {
		return excludePhrase;
	}

	public void setExcludePhrase(String excludePhrase) {
		this.excludePhrase = excludePhrase;
	}

	public HashMap getSortMap() {
		return sortMap;
	}

	public void setSortMap(HashMap sortMap) {
		this.sortMap = sortMap;
	}

	public HashMap getSortValues() {
		return sortValues;
	}

	public void setSortValues(HashMap sortValues) {
		this.sortValues = sortValues;
	}

	public AdminReport(String id, String name, String description,
			String sorts, String sql, String headingStr) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));
		this.sql = sql;
		this.headings = headingStr.split(",");
		excludeitem = "";

	}

	public String getExcludeitem() {
		return excludeitem;
	}

	public void setExcludeitem(String excludeitem) {
		this.excludeitem = excludeitem;
	}

	public AdminReport(String id, String name, String description,
			String sorts, String sql, String[] headings) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));
		this.sql = sql;
		this.headings = headings;
	}

	public AdminReport(String id, String name, String description,
			String[] sorts) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(sorts);
		this.excludeitem = "";
	}

	public AdminReport(String id, String name, String description, String sorts) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));

	}

	public AdminReport(String id, String name, String description,
			String sorts, String sql) {
		this.id = id;
		this.name = name;
		this.description = description;
		loadSortMap(splitup(sorts));
		this.sql = sql;

	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public AdminReport(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getSorts() {
		return sorts;
	}

	public void setSorts(String[] sorts) {
		this.sorts = sorts;
	}

	/**
	 * Editing ensures that only upper case characters are searched on trims the
	 * string to < 255 characters. For SQL Server There are at present two
	 * search workable search methods. 1. optionString2 searches both the
	 * acronym and plan name fields independently 2. optionString(insstr)
	 * searches the fields jointly.
	 * 
	 * Because of limitations of MS SQL server the method below optionStringNope
	 * will not work as a prepared statement.
	 * 
	 * We have to filter the string ANYWAY for upper case and to ensure that it
	 * is less than 255 characters.
	 * 
	 * Follow up: After explaining these to the business analyst,
	 * optionString(string) was selected over optionstring2()
	 * 
	 * @return filtered string
	 */
	public String filterSearchString(String insstr) {
		String ret = "'";
		char[] ucs = insstr.toUpperCase().toCharArray();

		int i = 0;

		for (char c : ucs) {
			if ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')
					|| allowableCharacters.indexOf(c) > -1) {
				ret += c;
			}
			if (++i >= 255) {
				break;
			}
		}
		ret += "'";
		return ret;
	}

	private final String allowableCharacters = " -/.,*%";

	/**
	 * This method (unused) would search the combined field. Unfortunately it
	 * doesn't work in MS SQL in a prepared statement.
	 * 
	 * @return
	 */
	public String optionStringNope() {
		String ret = " AND isnull(upper(acronym.acronym),'')+upper(plan_name) LIKE '?' ";

		return ret;
	}

	/**
	 * This method (unused) would search both the Department and Plan name for
	 * the same characters.
	 * 
	 * @return
	 */
	public String optionString2() {
		String ret = " AND (upper(acronym.acronym) LIKE ? OR upper(plan_name) LIKE ? )";
		return ret;
	}

	/**
	 * This is the currently used method. It searches the combined field using
	 * an input string and this works.
	 * 
	 * @param insstr
	 * @return
	 */
	public String optionString(String insstr) {
		String ret = "";
		if (null != insstr && insstr.length() < 256
				&& insstr.indexOf(';') == -1) {
			ret = " AND isnull(acronym.acronym,'')+upper(plan_name) LIKE "
					+ insstr;
		}
		return ret;
	}

	public String orderString(String order) {
		String ret = "";
		if (null != order && order.length() > 0)
			ret = " ORDER BY " + order;
		return ret;
	}

	public String[] getSortOptions() {
		String[] ret = new String[sorts.length];
		for (int i = 0; i < sorts.length; i++) {
			String[] nv = sorts[i].split("/");
			ret[i] = nv[0];
		}
		return ret;

	}

	public String getSelectedSort(String option) {
		String ret = "";
		try {
			ret = sortMap.get(option).toString();
		} catch (Exception e) {
			System.out.println("getSelectedSort Exception " + e);

		}
		return ret;
	}

	public boolean isASort(String testValue) {
		boolean ret = false;
		if (null != this.sortValues.get(testValue)) {
			ret = true;
		}
		return ret;
	}

	public StringBuffer buildRows(List<String[]> list, String[] thisheads) {
		// String ret = "";
		StringBuffer retb=new StringBuffer();
		
		System.out.println("Heading length: " + thisheads.length);
		System.out.println("Table length: " + list.size());
		int maxlen = thisheads.length; // Only print enough data for the number
										// of headings to be shown.
		int r = 0;
		int thold = 10;
		for (String[] cols : list) {
			// ret += "<TR>";
           retb.append( "<TR>");
			for (int i = 0; i < maxlen; i++) {
				String item = cols[i];
				// ret += "<TD>" + item + "</TD>";
				retb.append("<TD>" + item + "</TD>");
			}
			// ret += "</TR>";
			retb.append("</TR>");
			r++;
			if ((r % thold) == 0) {
				System.out.println(r);
				thold = thold * 2;
			}
		}
		return retb;
	}

	public String getSpecialName() {
		return specialName;
	}

	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

}
