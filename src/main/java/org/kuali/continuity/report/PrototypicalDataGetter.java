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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrototypicalDataGetter {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager
				.getConnection(
						// "jdbc:oracle:thin:@192.168.10.85:1521:oracledb",
						// "xyz","abc"
						"jdbc:jtds:sqlserver://sql-dnon02.ist.berkeley.edu:1433;DatabaseName=UCReady",
						"restart_app", "RB7erk.ley");

		return conn;
	}

	public List getList() {
    	ArrayList list = new ArrayList();
		try {
			System.out.print("Getting list of action items");
			Connection conn = getConnection();
			PreparedStatement stmt = conn
					.prepareStatement("select * from action_items where pid=? ");
			stmt.setInt(1, 436);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			while (rs.next()) {

				String[] row = new String[numberOfColumns];
				for (int i = 1; i <= numberOfColumns; i++) {
					String tempString = new String((String) rsmd
							.getColumnLabel(i));
					row[i] = tempString;
				}
				list.add(row);
			}
		} catch (Exception e) {
			System.out.println("PrototypicalDataGetter exception:" + e);

		}
		return list;
	}
}
