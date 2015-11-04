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

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Scanner;

import junit.framework.TestCase;

public class JdbcConnectTest  extends TestCase{
	static class Connector {
		String url;
		String userid;
		String pw;
		String classname;

		Connector(String url, String userid, String pw, String classname) {
			this.url = url;
			this.userid = userid;
			this.pw = pw;
			this.classname = classname;
		}
	}

	public static HashMap connectors = new HashMap() {
		{
			put(
					"1",
					new Connector(
							"jdbc:jtds:sqlserver://sql-dnon02.ist.berkeley.edu:1433;DatabaseName=UCReady",
							"restart_app", "RB7erk.ley",
							"net.sourceforge.jtds.jdbc.Driver"));
			put("2", new Connector("jdbc:derby://localhost:1527/continuity;create=true",
					"continuity", "kuali", "org.apache.derby.jdbc.ClientDriver"));
			put("3", new Connector(
					"jdbc:jtds:sqlserver://krdy-ddb01.ist.berkeley.edu:1433;DatabaseName=KualiReady",
					"restart_app", "RB7erk.ley",
					"net.sourceforge.jtds.jdbc.Driver"));
		}
	};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Select database: ");
		System.out.println("1): UCReadyDev");
		System.out.println("2): Derby");
		System.out.print("Enter selection (1, 2 or 3):");

		String dbstr = in.nextLine();

		JdbcConnectTest.Connector c = (Connector) connectors.get(dbstr);
		try {

			DB db = new DB(c.classname);
			// db
			// .dbConnect(
			// // "jdbc:jtds:sqlserver://localhost:1433/tempdb","sa",""
			// "jdbc:jtds:sqlserver://sql-dnon02.ist.berkeley.edu:1433;DatabaseName=UCReady",
			// "restart_app", "RB7erk.ley");
			db.dbConnect(c.url, c.userid, c.pw);
		} catch (Exception e) {
			System.out.println("Unable to obtain driver or connection: " + e);
			e.printStackTrace();
		}
	}
}

class DB {
	String classname = "net.sourceforge.jtds.jdbc.Driver";

	public DB() {
	}

	public DB(String classname) {
		this.classname = classname;
	}

	public void dbConnect(String db_connect_string, String db_userid,
			String db_password) {
		Connection conn = null;
		try {
			System.out.println("Driver classname: "+classname);
			Class.forName(classname);
			conn = DriverManager.getConnection(db_connect_string, db_userid,
					db_password);
			System.out.println("connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void testJdbc() {
		
		JdbcConnectTest.Connector c = (JdbcConnectTest.Connector) JdbcConnectTest.connectors.get("1");
		try {

			DB db = new DB(c.classname);
			// db
			// .dbConnect(
			// // "jdbc:jtds:sqlserver://localhost:1433/tempdb","sa",""
			// "jdbc:jtds:sqlserver://sql-dnon02.ist.berkeley.edu:1433;DatabaseName=UCReady",
			// "restart_app", "RB7erk.ley");
			db.dbConnect(c.url, c.userid, c.pw);
		} catch (Exception e) {
			System.out.println("Unable to obtain driver or connection: " + e);
			e.printStackTrace();
		}
		
	}
};
