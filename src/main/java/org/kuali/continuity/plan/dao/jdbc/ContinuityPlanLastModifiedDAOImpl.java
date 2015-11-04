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
package org.kuali.continuity.plan.dao.jdbc;

import java.util.Date;

import javax.sql.DataSource;

import org.kuali.continuity.plan.dao.ContinuityPlanLastModifiedDAO;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContinuityPlanLastModifiedDAOImpl implements ContinuityPlanLastModifiedDAO {

	private DataSource dataSource;

	@Override
	public void updateLastModifiedDate(int planId, Date lastModifiedDate) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String updateStatement = 
			" UPDATE plans SET last_modified = ? WHERE pid = ?";
		jdbcTemplate.update(updateStatement, new Object[] {lastModifiedDate, planId});
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
