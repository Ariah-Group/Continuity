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
package org.kuali.continuity.admin.dao.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.kuali.continuity.admin.dao.AdminTestModeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class AdminTestModeDAOImpl implements AdminTestModeDAO {

	private DataSource dataSource;
	private final static String SELECT_QUERY = "SELECT count(*) FROM AdminTestMode WHERE UserID = ?";
	private final static String DELETE_QUERY = "DELETE FROM AdminTestMode WHERE UserID = ?";

	@Override
	public void setInTestMode(boolean isInTestMode, Integer userId) {
		if (userId == null || userId == 0) return;
		if (isInTestMode) {
			// test if already disabled
			if (this.isInTestMode(userId)) return;
			
			// build column-value map
			Map<String, Object> colValueMap = new HashMap<String, Object>();
			colValueMap.put("UserID", userId);
	
			// insert new row
			SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(this.dataSource);
			simpleInsert.setSchemaName("dbo");
			simpleInsert.setTableName("AdminTestMode");
			simpleInsert.setColumnNames(new ArrayList<String>(colValueMap.keySet()));
			simpleInsert.execute(colValueMap);
		} else {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
			jdbcTemplate.update(DELETE_QUERY, new Object[] {userId});
		}
	}
	
	@Override
	public boolean isInTestMode(Integer userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		int count = jdbcTemplate.queryForInt(SELECT_QUERY, new Object[] {userId});
		return (count > 0);
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
