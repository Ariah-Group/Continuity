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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.SimpleContinuityPlanDAO;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class SimpleContinuityPlanDAOImpl implements SimpleContinuityPlanDAO {
	
	private DataSource dataSource;
	private final static String PLAN_LIST_USER_QUERY = 
		"SELECT distinct p.pid, " +				// 1
			   "p.plan_name, " +		// 2
			   "p.status, " +			// 3
			   "p.institutionid, " +	// 4
			   "p.create_date, " +		// 5
			   "p.last_modified, " +	// 6
			   "p.acronymid, " +		// 7
			   "ac.acronym, " +			// 8
			   "up.userid, " +			// 9
			   "up.planaccess, " +		// 10
			   "(select count(*) " +
			      "FROM plan_contacts pc " +
			      "WHERE p.pid = pc.pid), " +	// 11
			   "case when " +
			       "p.acronymid = 0 or p.acronymid is null " +
			       "then p.plan_name " +
			       "else " +
			           "case when " +
			               "ac.acronym is null " +
			               "then p.plan_name " +
			               "else ac.acronym + ' - ' + p.plan_name " +
			           "end " +
			       "end acronymPlusName, " +	// 12
			   "st.lookupdescription status_desc, " +	// 13
			   "pa.lookupdescription access_desc, " +	// 14
			   "us.emailregular " +						// 15
		 "FROM plans p " +
		 "LEFT OUTER JOIN acronym ac ON p.acronymid = ac.acronymid " +
		 "LEFT OUTER JOIN user_plan up ON p.pid = up.pid AND up.userid = ? " +
		 "LEFT OUTER JOIN descriptionlookup st ON p.status = st.lookupvalue AND st.lookupname = 'PlanStatus' " +
		 "LEFT OUTER JOIN descriptionlookup pa ON up.planaccess = pa.lookupvalue AND pa.lookupname = 'UserPlanAccess' " +
		 "LEFT OUTER JOIN usersecurity us ON up.userid = us.userid " +
		"WHERE p.institutionid = ? ";

	@SuppressWarnings("unchecked")
	@Override
	public List<SimpleContinuityPlan> getSortedList(int systemDomainId,
			int userId, SortByType sortBy, boolean isAscending) {
		JdbcTemplate template = new JdbcTemplate(this.dataSource);
		return (List<SimpleContinuityPlan>) template.query(
				PLAN_LIST_USER_QUERY + this.getOrderByClause(sortBy, isAscending), 
			new Object[] {(Integer) userId, (Integer) systemDomainId}, 
			new SimpleContinuityPlanRowMapper());
	}
	
	private String getOrderByClause(SortByType sortBy, boolean isAscending) {
		if (sortBy == null) return "";
		String ascDesc = this.getAscDesc(isAscending);
		if (BaseContinuityPlan.SortBy.access.name().equals(sortBy.getSortByValue()))
			return "ORDER BY up.userid " + this.getAscDesc(!isAscending) + ", acronymPlusName " + ascDesc;
		if (BaseContinuityPlan.SortBy.acronymPlusName.name().equals(sortBy.getSortByValue()))
			return "ORDER BY acronymPlusName " + ascDesc;
		if (BaseContinuityPlan.SortBy.id.name().equals(sortBy.getSortByValue()))
			return "ORDER BY p.pid " + ascDesc;
		if (BaseContinuityPlan.SortBy.name.name().equals(sortBy.getSortByValue()))
			return "ORDER BY p.plan_name " + ascDesc;
		return "";
	}

	private String getAscDesc(boolean isAscending) {
		return isAscending ? "asc" : "desc";
	}

	public DataSource getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public class SimpleContinuityPlanResultSetExtractor implements ResultSetExtractor {

		@Override
		public Object extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			// acronym
			Acronym acronym = null;
			int acronymId = rs.getInt(7);
			String acronymName = rs.getString(8);
			if (acronymId != 0) 
				acronym = new Acronym(acronymId, acronymName);
			
			// status
			String statusId = rs.getString(3);
			PlanStatus planStatus = null;
			if (statusId != null && statusId.trim().length() != 0) {
				planStatus = new PlanStatus();
				planStatus.setId(statusId);
				planStatus.setDescription(rs.getString(13));
			}
			
			// system domain
			int systemDomainId = rs.getInt(4);
			SystemDomain systemDomain = systemDomainId == 0 ? null : new SystemDomain(systemDomainId);
			
			// plan access type
			String planAccessTypeId = rs.getString(10);
			PlanAccessType planAccessType = null;
			if (planAccessTypeId != null && planAccessTypeId.trim().length() != 0) {
				planAccessType = new PlanAccessType();
				planAccessType.setId(planAccessTypeId);
				planAccessType.setDescription(rs.getString(14));
			}
			
			// user
			int userId = rs.getInt(9);
			User user = null;
			if (userId != 0) {
				user = new User();
				user.setId(userId);
				user.setEmailRegular(rs.getString(15));
			}
			
			// user access map
			Map<User, PlanAccessType> userAccessMap = new HashMap<User, PlanAccessType>();
			if (user != null) userAccessMap.put(user, planAccessType);
			
			// plan
			SimpleContinuityPlan plan = new SimpleContinuityPlan();
			plan.setId(rs.getInt(1));
			plan.setName(rs.getString(2));
			plan.setCreatedDate(rs.getDate(5));
			plan.setLastModifiedDate(rs.getDate(6));
			plan.setAcronymPlusName(rs.getString(12));
			plan.setSystemDomain(systemDomain);
			plan.setAcronym(acronym);
			plan.setStatus(planStatus);
			plan.setUserAccessMap(userAccessMap);
			plan.setContactsSize(rs.getInt(11));
			return plan;
		}
		
	}
	
	public class SimpleContinuityPlanRowMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SimpleContinuityPlanResultSetExtractor extractor = new SimpleContinuityPlanResultSetExtractor();
			return extractor.extractData(rs);
		}
		
	}

}
