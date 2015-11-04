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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectParameterData {
	
	List getHeaderParameters(Connection conn, String databaseQuery, Object id) throws SQLException {
		List dataList = new ArrayList();
		PreparedStatement pstmt = conn.prepareStatement(databaseQuery);
		System.out.println(databaseQuery);
		if (id instanceof Integer ) {
			pstmt.setInt(1, (Integer) id);
		} else if (id instanceof String ) {
			pstmt.setString(1, (String) id);
		}
		System.out.println("Parameter is set running statement");
		ResultSet rs =pstmt.executeQuery();
		
		if(rs.next()) {
			int nnames= rs.getMetaData().getColumnCount();
			for (int i=1;i<=nnames;i++) {
				String thisName=rs.getMetaData().getColumnName(i);
				
				dataList.add(new SelectBean(thisName, rs.getString(i)));
			}
		}
		
		
		return dataList;
	}
		

}
