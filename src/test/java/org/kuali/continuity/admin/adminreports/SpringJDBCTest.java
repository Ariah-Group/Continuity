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
// 
// Copyright 2009 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.osedu.org/licenses/ECL-2.0
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.admin.adminreports;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.kuali.continuity.BasePlanTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/** This tests basic functionality using the DataSource and Spring JDBC for
 * admin reports.
 * 
 * @author richkatz
 *
 */
public class SpringJDBCTest extends BasePlanTest {

	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void testRun() {
		ArrayList commissions = new ArrayList();
		try {
			
			JdbcTemplate jt = new JdbcTemplate(dataSource);
			List plans = jt.queryForList("SELECT * from plans");
            System.out.println("Plan count: "+plans.size());
		    for (Object p: plans) {
		    	
		    }
		} catch (DataAccessException ex) // unchecked exception
		{
			System.err.println(ex.getMessage());
		}
	}
}
