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
import java.util.HashMap;
import java.util.Map;

public class HeaderParameterData {
	
	Map getHeaderParameters(Connection conn, String cataloguedQuery, Map queryMap, Object id) throws SQLException {
		
		String databaseQuery= (String) queryMap.get(cataloguedQuery);
		Map dataMap = this.getHeaderParameters(conn, databaseQuery, id);
		
		return dataMap;
		
	}
	Map getHeaderParameters(Connection conn, String databaseQuery, Object id)  throws SQLException {
		Map dataMap = new HashMap();
		PreparedStatement pstmt = null;
		
		ResultSet rs=null;
		System.out.println(databaseQuery);
		try {
			pstmt = conn.prepareStatement(databaseQuery);
			if (id instanceof Integer ) {
			pstmt.setInt(1, (Integer) id);
		} else if (id instanceof String ) {
			pstmt.setString(1, (String) id);
		}
		System.out.println("Parameter is set running statement");
		 rs =pstmt.executeQuery();
		
		if(rs.next()) {
			int nnames= rs.getMetaData().getColumnCount();
			for (int i=1;i<=nnames;i++) {
				String thisName=rs.getMetaData().getColumnName(i);
				dataMap.put(thisName, rs.getString(i));
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
		
				if (null != rs)
					rs.close();
				if (null != pstmt)
					pstmt.close();

		}
		
		
		return dataMap;
	}
	public int getCountData(Connection conn, String databaseQuery, Object id) throws SQLException {
        int ret=0;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		pstmt=conn.prepareStatement(databaseQuery);
		System.out.println(databaseQuery);
		try {
		if (id instanceof Integer ) {
			pstmt.setInt(1, (Integer) id);
		} else if (id instanceof String ) {
			pstmt.setString(1, (String) id);
		}
		System.out.println("Parameter is set running statement");
		 rs =pstmt.executeQuery();
		
		if(rs.next()) {
			int nnames= rs.getMetaData().getColumnCount();
			ret = rs.getInt(1);
		}
		} catch (Exception e) {
			
		} finally {
			if (null != rs)
				rs.close();
			if (null != pstmt)
				pstmt.close();

		}
  		return ret;
	}
		

}
