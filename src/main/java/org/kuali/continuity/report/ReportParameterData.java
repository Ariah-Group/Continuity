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
package org.kuali.continuity.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportParameterData {

	public Map getHeaderParameters(Connection conn, String cataloguedQuery,
			Map queryMap, Object id) throws SQLException {

		String databaseQuery = (String) queryMap.get(cataloguedQuery);
		Map dataMap = this.getParameters(conn, databaseQuery, id);

		return dataMap;

	}

	public Map getParameters(Connection conn, String databaseQuery, Object id)
			throws SQLException {
		Map dataMap = new HashMap();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(databaseQuery);

			System.out.println(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			System.out.println("Parameter is set running statement");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dataMap = rsRow2Map(rs);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != rs)
			rs.close();
		if (null != pstmt)
			pstmt.close();

		return dataMap;
	}

	public List getValueListMap(Connection conn, String databaseQuery, Object id)
			throws SQLException {
		Map dataMap = new HashMap();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		try {
			pstmt = conn.prepareStatement(databaseQuery);

			System.out.println(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			System.out.println("Parameter is set running statement");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dataMap = rsRow2Map(rs);
				resultList.add(dataMap);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != rs)
			rs.close();
		if (null != pstmt)
			pstmt.close();
		
		System.out.println("		Result list size is: " + resultList.size());
		return resultList;
	}

	public Map getParameters(Connection conn, String databaseQuery,
			List<?> parmList) throws SQLException {
		Map dataMap = new HashMap();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(databaseQuery);

			System.out.println(databaseQuery);
			int i = 1;
			for (Object parm : parmList) {
				if (parm instanceof Integer) {
					pstmt.setInt(i++, (Integer) parm);
				} else if (parm instanceof String) {
					pstmt.setString(i++, (String) parm);
				}
			}

			System.out.println("Parameter is set running statement");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dataMap = rsRow2Map(rs);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (null != rs)
			rs.close();
		if (null != pstmt)
			pstmt.close();

		return dataMap;
	}

	Map rsRow2Map(ResultSet rs) throws SQLException {
		Map dataMap = new HashMap();
		int nnames = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= nnames; i++) {
			String thisName = rs.getMetaData().getColumnName(i);
			if (thisName.toUpperCase().equals("PID")) {
				dataMap.put(thisName, rs.getInt(i));

			} else {
				dataMap.put(thisName, rs.getString(i));
			}

		}
		return dataMap;
	}

	public Map getNameValuePairSeries(Connection conn, String databaseQuery,
			Object id, String sep) throws SQLException {
		Map dataMap = new HashMap();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			pstmt = conn.prepareStatement(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (null == dataMap.get(rs.getObject(1))) {
					dataMap.put(rs.getObject(1), rs.getObject(2).toString()
							.trim());
				} else {
					String nv = (String) dataMap.get(rs.getObject(1)) + sep
							+ rs.getObject(2).toString().trim();
					dataMap.put(rs.getObject(1), nv);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		pstmt.close();
		return dataMap;
	}

	public List getValueList(Connection conn, String databaseQuery, Object id,
			String sep) throws SQLException {
		List dataList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			System.out.println("ReportParameterData List: Preparing "
					+ databaseQuery + " for " + id);
			pstmt = conn.prepareStatement(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dataList.add(rs.getObject(1));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		rs.close();
		pstmt.close();
		return dataList;
	}

	public List getMapList(Connection conn, String databaseQuery, Object id)
			throws SQLException {
		Map dataMap = new HashMap();
		List dataList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (null == dataMap.get(rs.getObject(1))) {
					dataMap.put(rs.getObject(1), rs.getObject(2).toString()
							.trim());
				} else {
					String nv = (String) dataMap.get(rs.getObject(1)) + "\n"
							+ rs.getObject(2).toString().trim();
					dataMap.put(rs.getObject(1), nv);

				}

			}
		} catch (Exception e) {

		}
		if (null != rs)
			rs.close();
		if (null != pstmt)
			pstmt.close();
		return dataList;
	}

	public boolean hasRows(Connection conn, String databaseQuery, Object id)
			throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(databaseQuery);
			if (id instanceof Integer) {
				pstmt.setInt(1, (Integer) id);
			} else if (id instanceof String) {
				pstmt.setString(1, (String) id);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;

			}
		} catch (Exception e) {

		}
		return false;
	}

}
