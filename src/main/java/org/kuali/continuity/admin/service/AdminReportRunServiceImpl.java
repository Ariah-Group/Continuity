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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.kuali.continuity.admin.service.util.PlanString;
import org.kuali.continuity.report.HeaderParameterData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class AdminReportRunServiceImpl implements AdminReportRunService {
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}


	// OLD public List runReport(String reportId, SelectionSet selectionSet) {
	// AdminReport ar = (AdminReport)
	// AdminReportService.getInstance().getReports().get(reportId);
	//		
	// return runReport(ar, selectionSet);
	// }
	public List runReport(AdminReport ar, SelectionSet selectionSet) {
		System.out.println("Running AdminReport" + ar.getName());
		String optional = "";
		ArrayList<String> argList = new ArrayList();
		argList.add(selectionSet.selectedInstitution);

		// String [] args = (String[]) argList.toArray();
		String sql = ar.getSql();
		
		// Selected Plan
		if ("status".equals(ar.getId())) {
			int idx = sql.indexOf("group by");
			if (idx >= 0) {
				String groupBySQL = sql.substring(idx);
				String startSQL = sql.substring(0, idx);
				sql = startSQL + " " + PlanString.parse(selectionSet.selectedPlan, ar) + " " + groupBySQL;
			} else {
				sql+=PlanString.parse(selectionSet.selectedPlan, ar);
			}
		} else {
			sql+=PlanString.parse(selectionSet.selectedPlan, ar);
		}
//		if (null != selectionSet.selectedPlan
//				&& selectionSet.selectedPlan.trim().length() > 0) {
//			String planarg = selectionSet.selectedPlan.trim() + "%";
//			// Replace left most character.
//
//			if (planarg.charAt(0) == '*') {
//				planarg = "%" + planarg.substring(1);
//
//				if (planarg.equals("%%")) {
//					planarg = "";
//					;
//				}
//			}
//			if (planarg.length() > 0) {
//				planarg = ar.filterSearchString(planarg);
//				sql += ar.optionString(planarg);
//				System.out.println("planarg: " + planarg);
//				// argList.add(planarg);
//			}
//		}
		
		// Special: 	Add 2nd prepared parameter.
		if (null!=selectionSet.specialSelection ) {
			if (!selectionSet.specialSelection.equals("all")) {
				argList.add(selectionSet.specialSelection);
				sql+=ar.getSpecialSelectionClause();  
			}
		}
		System.out.println("Processing the exclude: "+ar.excludeitem+selectionSet.excludeEmpty);
		if ((!selectionSet.excludeEmpty) && (null != ar.excludeitem)
				&& (ar.excludeitem.length() > 0)) {
            System.out.println("Excluding "+ar.getExcludeitem());
			sql += " AND " + ar.getExcludeitem() + " IS NOT NULL ";
		}
		System.out.println("Calling getSelectedSort Selected sort is: "
				+ selectionSet.selectedSort);
		sql += ar.orderString(selectionSet.selectedSort);
		System.out.println("AdminReport - SQL: " + sql);


		String args[] = new String[argList.size()];
		argList.toArray(args);
		List ret = runSql(sql, args, "");
		System.out.println("List len:" + ret.size());
		return ret;
	}
    public String runBand(AdminReport ar, BandProcess bp, SelectionSet selectionSet) {
    	String ret = bp.runProcess(dataSource, ar, selectionSet);
    	return ret;
    }
	public List runSql(String sql, String[] args, String optional) {
		JdbcTemplate jtemplate = new JdbcTemplate(dataSource);
		StringRowMapper stringRowMapper = new StringRowMapper();
		String sql2run = sql + optional;

		return jtemplate.query(sql2run, args, stringRowMapper);

	}

	public int runIntSql(String sql, Object arg, String optional) {
		int ret=0;
		HeaderParameterData hpd = new HeaderParameterData();
		try {
			Connection conn = dataSource.getConnection();
			
			ret = hpd.getCountData(conn,sql+optional, arg);
		} catch (Exception e) {
			System.out.println("Exception "+e+" on SQL query: "+sql+optional);
			e.printStackTrace();
		}
		
		return ret;
	}
	@Override
	public List getNvpList(AdminReport ar, String sql, String[]  args) {
		JdbcTemplate jtemplate = new JdbcTemplate(dataSource);
		NvpRowMapper stringRowMapper = new NvpRowMapper();
		

		return jtemplate.query(sql, args, stringRowMapper);

	}
	String DATE_FORMAT = "MM/dd/yyyy";
	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	public static final String HTMLSPACE = "&nbsp;";

	public class StringResultSetExtractor implements ResultSetExtractor {

		// Override

		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();

			int numCols = rsmd.getColumnCount();

			String[] stringarray = new String[numCols];
			try {

				for (int i = 1; i <= numCols; i++) {
					String type = rsmd.getColumnTypeName(i);

					if (type.equals("datetime")) {
						String datedata = HTMLSPACE;
						java.sql.Date datein = rs.getDate(i);

						if (null != datein) {
							datedata = sdf.format(datein);
							if (datedata.equals("01/01/1901")
									|| datedata.equals("01/01/1900")) {
								datedata = HTMLSPACE;
							}
						}
						stringarray[i - 1] = datedata;

					} else {
						stringarray[i - 1] = noNulls(rs.getString(i));
					}
				}
			} catch (Exception e) {
				System.out
						.println("StringResultSetExtractor Formatting exception: "
								+ e);
				e.printStackTrace();
			}
			return (Object) stringarray;
		}

		public String noNulls(String stringin) {
			String ret = HTMLSPACE;
			if (null != stringin && !stringin.equals("null")) {
				ret = stringin;
			}
			return ret;
		}

	}

	public class StringRowMapper implements RowMapper {

		// @Override
		public Object mapRow(ResultSet rs, int line) throws SQLException {
			StringResultSetExtractor extractor = new StringResultSetExtractor();
			return extractor.extractData(rs);
		}

	}



	public class NvpResultSetExtractor implements ResultSetExtractor {
		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();
			int numCols = rsmd.getColumnCount();
			Nvp nvp = new Nvp();
			nvp.setDescription(rs.getString("description"));
			nvp.setId(rs.getString("id"));
			return (Object) nvp;
		}


	}
	public class NvpRowMapper implements RowMapper {

		// @Override
		public Object mapRow(ResultSet rs, int line) throws SQLException {
			NvpResultSetExtractor extractor = new NvpResultSetExtractor();
			return extractor.extractData(rs);
		}

	}
}
