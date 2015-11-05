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

import org.kuali.continuity.admin.dao.CustomImageUploadDAO;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.domain.UIImageTypeEnum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class CustomImageUploadDAOImpl implements CustomImageUploadDAO {

	private DataSource dataSource;
	private final static String DELETE_SD_QUERY = "DELETE FROM SystemDomainUIImage WHERE InstitutionID = ? AND Name = ?";

	@Override
	public void uploadImage(int systemDomainId, UIImageEnum uiImageKey, UIImageTypeEnum uiImageType, byte[] image) {
		
		// delete first
		this.deleteImage(systemDomainId, uiImageKey);
		
		// build column-value map
		Map<String, Object> colValueMap = new HashMap<String, Object>();
		colValueMap.put("InstitutionID", systemDomainId);
		colValueMap.put("Name", uiImageKey.name());
		colValueMap.put("UIImageType", uiImageType.name());
		colValueMap.put("UIImage", image);

		// then insert new row
		SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(this.dataSource);
		simpleInsert.setSchemaName("dbo");
		simpleInsert.setTableName("SystemDomainUIImage");
		simpleInsert.setColumnNames(new ArrayList<String>(colValueMap.keySet()));
		simpleInsert.execute(colValueMap);
	}
	
	@Override
	public void deleteImage(int systemDomainId, UIImageEnum uiImageKey) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		jdbcTemplate.update(
			DELETE_SD_QUERY,
		    new Object[] {systemDomainId, uiImageKey.name()});
		
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
