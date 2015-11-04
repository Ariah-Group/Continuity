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

import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.report.ReportParameterData;

import junit.framework.TestCase;

public class TestHeaderParameter extends TestCase {

	String headerSql = "select plan_name, key_basic_emergency_contact_copy, key_basic_who_hold,key_facilities, "
			+ "key_basic_who_update, key_basic_who_check_msg, key_basic_who_record_greeting, "
			+ "key_basic_who_post_msg,	key_basic_shared_password, key_basic_comment, "
			+ "not_applicable, na_explain, key_transportation, key_other_resources "
			+ "from plans where pid = ?";
	String pairSql = "select c.cid, d.Dependency "
			+ " from Dependency d, cf_dependency c, critical_functions f "
			+ " where c.DependencyID = d.DependencyID " + " and c.cid = f.cid "
			+ " and f.pid = ? " + "  and d.DependencyType=1 "
			+ "  and d.recordtype = 'U'";
	String pairSql2 = "SELECT kt_id, first_name+' ' +last_name as name "
			+ " from key_team_members" 
			+ " where kt_id = ?";

	public void testHeader1(int x) {
		ReportParameterData rpd = new ReportParameterData();
		JasperReportServiceImpl jrsi = new JasperReportServiceImpl();
		Map m = null;
		Connection conn=null;
		try {
			 conn = jrsi.getConnection();

			m = rpd.getParameters(conn, headerSql, new Integer(436));
		} catch (Exception e) {
			System.out.println("Exception thrown " + e);
			e.printStackTrace();
			fail();
		} finally {
			jrsi.dropConnection(conn, true);

		}

		Set<String> ks = m.keySet();
		for (String s : ks) {
			System.out.println(s + ": " + m.get(s));
		}
		
	}

	public void testSeries() {
		ReportParameterData rpd = new ReportParameterData();
		JasperReportServiceImpl jrsi = new JasperReportServiceImpl();
		Map m = null;
		Connection conn=null;
		try {
			conn = jrsi.getConnection();
            String sep =", ";
			m = rpd.getNameValuePairSeries(conn, pairSql2, new Integer(22),  sep);

		} catch (Exception e) {
			System.out.println("Exception thrown " + e);
			e.printStackTrace();
			fail();
		} finally {
			jrsi.dropConnection(conn, true);
		}
		Set<Object> ks = m.keySet();
		for (Object s : ks) {
			System.out.println(s.toString() + ": " + m.get(s));
		}
		
	}

}
