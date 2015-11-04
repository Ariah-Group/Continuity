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
package org.kuali.continuity.admin.main.server;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class DeptPlanServiceImpl implements DeptPlanService {
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}
	public static final String HTMLSPACE = "&nbsp;";

	// Both should include 'deleted' plans - check what that means.
	
	String sqldept0 =	"select isnull(acronym.acronym+' - ','')+plan_name displayplan, pid, status, "
		+" status+isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
		+" from plans left join acronym on plans.acronymid = acronym.acronymid "
		+" where disabled = 'N' and plans.institutionid = ? 	"
		+" order by plannamekey";
	
	// The following JOIN-UNION query is (simplified) from ColdFusion ActivityLog.cfc.GetPlanSet lines 51-61 
	String sqldept =
		"SELECT   s.Comment + '(Deleted)' AS displayplan, s.ObjectID AS pid, 'D' AS status"
			+" , s.Comment as plannamekey"
			+" FROM SystemLog s"
			+" WHERE s.InstitutionID =  ? AND s.ObjectType = 'pl' AND s.EventType= 'dl'"
		    +" AND s.comment is not null AND s.comment != ''"		// to fix plan name display.  need to clean db too; 
		    														// delete system log comment must not be null
		+" UNION"
		+" SELECT isnull(acronym.acronym+' - ','')+plan_name displayplan, pid, status"
			+" ,isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
			+" FROM plans left join acronym on plans.acronymid = acronym.acronymid "
			+" WHERE disabled = 'N' and plans.institutionid = ?	"
			+" ORDER BY plannamekey";

	@Override
	public List<Object[]> getSimpleContinuityPlanList(int systemDomainId) {
		JdbcTemplate jtemplate = new JdbcTemplate(dataSource);
		StringRowMapper stringRowMapper = new StringRowMapper();
	        
		String sql2run = sqldept;
        String [] args = {""+systemDomainId, ""+systemDomainId,};
		return parseList(jtemplate.query(sql2run, args, stringRowMapper));
	}
	public List<Object[]> parseList(List<Object[]> ilist) {
		List<Object[]> ret = new ArrayList();
		for (Object[] o: ilist) {
			Object[] o2 = {o[1], o[0], o[2]};
			
			ret.add(o2);
		}
		
		return ret;
		
	}
	public class StringRowMapper implements RowMapper {

		// @Override
		public Object mapRow(ResultSet rs, int line) throws SQLException {
			StringResultSetExtractor extractor = new StringResultSetExtractor();
			return extractor.extractData(rs);
		}

	}
	public class StringResultSetExtractor implements ResultSetExtractor {

		// Override

		public Object extractData(ResultSet rs) throws SQLException {
			ResultSetMetaData rsmd = rs.getMetaData();

			int numCols = rsmd.getColumnCount();

			String[] stringarray = new String[numCols];
			try {

				for (int i = 1; i <= numCols; i++) {
					String type = rsmd.getColumnTypeName(i);


						stringarray[i - 1] = noNulls(rs.getString(i));
			
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

}
