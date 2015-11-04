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
package org.kuali.continuity.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.dao.UserDAO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.domain.User.SortBy;
import org.kuali.continuity.admin.main.server.ServiceImpl;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.util.DataUtil;


public class RoleServiceImpl extends ServiceImpl implements RoleService {
	// Spring Configured:
	UserDAO userDAO;
	SystemDomainDAO systemDomainDAO;
	private static final Logger logger = Logger.getLogger(RoleServiceImpl.class);

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	
	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO=systemDomainDAO;
	}
	
	public List getAllUsersbyInst(Integer institutionId) {
		return userDAO.getListBySystemDomainId(institutionId);
	}

	/**
	 * Get list of locations for Location Pull-down in Manage User Roles
	 * If this user is an Institution Administrator, then they only see the Locations for their institution 
	 */
	public List getInstitutionValueList() {
		Map m = getUserInfo();
		SessionUserDTO sud = (SessionUserDTO) m.get(SessionKey.user.toString());
		// Get role
		User u = sud.getDomainObject();
		System.out.println("RoleServiceImpl getInstitutionValueList Got user "+u.getId());
		int thisRole=Integer.parseInt(u.getSecurityType().getId());
		SessionSystemDomainDTO ssd = (SessionSystemDomainDTO) m.get(SessionKey.systemDomain.toString()+"Full");
        
		String systemDomainGroup= ssd.systemDomainGroup;
		System.out.println("RoleServiceImpl getInstitutionValueList Getting Group "+systemDomainGroup);
		List<SystemDomain> list = null;
		
		SortByType sortBy = SystemDomain.SortBy.name;
		
		// SystemAdmin
		if (thisRole==0) {
			list = systemDomainDAO.getAll();
			System.out.println("got "+list.size()+"  locations.");
		} else if (thisRole==3) {
				list = systemDomainDAO.getSortedSubListByGroup(systemDomainGroup, 0, 999, sortBy, true);
				System.out.println("got "+list.size()+"  locations.");
		} else {
			// LocalAdmin - 1
			list = new ArrayList();
			SystemDomain sd = systemDomainDAO.getById(ssd.id);
			list.add(sd);
			
		}
		
		List ret= new ArrayList();
		for (SystemDomain sd: list) {
			String name=sd.getName();
			String value=sd.getId().toString();
			String istrust="N";
			if (sd.isShibMode()) {
				istrust="Y";
			}
			String [] row = {name,value,"",istrust};  // Now Contains Institution Name, id, empty, and istrust
			ret.add(row);
		
		}
		return ret;
	}
	public List getInstitutions() {
		
		return systemDomainDAO.getAll();
	}

	// Value List Handler functions (not implemented at this point).
	public List scrollBackward(Integer institutionId, int nusers,
			Integer endingBeforeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List scrollForward(Integer institutionId, int nusers,
			Integer startafterId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
	  	// User user = new User();
    	//loadUser(user, updates);
		userDAO.create(user);
		
	}

	public void deleteUser(User user) {
		userDAO.delete(user.getUserId());
		
	}

	public void deleteUser(int id) {
		userDAO.delete(id);
		
	}

	protected void loadUser(User user, User updates) {
		 logger.info("Retrieved user:"+user.getUserId());
		 logger.info("Got st"+updates.getSecurityType());
		 user.setId(updates.getId());
		 user.setFirstName(DataUtil.nonulls(updates.getFirstName()));
		 user.setLastName(DataUtil.nonulls(updates.getLastName()));
		 user.setAccessStatus(updates.getAccessStatus());
		 user.setSecurityType(updates.getSecurityType());
		 user.setTitle(DataUtil.nonulls(updates.getTitle()));
		 user.setDepartmentName(DataUtil.nonulls(updates.getDepartmentName()));
		 user.setEmailRegular(DataUtil.nonulls(updates.getEmailRegular()));
		 user.setWorkPhone(DataUtil.nonulls(updates.getWorkPhone()));
		
		 user.setAuthId(updates.getAuthId());
		
	}
	/** This method is designed specifically to 
	 * accept data from the KCP User Role Management form.
	 */
	public void updateUser(User user) {
		try { 
			 logger.info("RoleService Update called: "+user.getUserId());	
		//  User user=userDAO.getById(updates.getUserId());
       //   loadUser(user, updates);
         
		 logger.info("Calling save.");
		 userDAO.update(user);
		} catch (Exception e) {
			System.out.println("Exception "+e);
			logger.warn("Exception in roleService save: ",e);
		}
		
	}

	public User getUser(int id) {
		return userDAO.getById(id);
	}

	public List getUserValuesbyInst(Integer institutionId) {
		List list = userDAO.getListBySystemDomainId(institutionId);
		return list;
	}
	public List getUserValuesbyInst(Integer institutionId, int limit) {
		List list = userDAO.getListBySystemDomainId(institutionId);
		return list;
	}
	public List getSortedUserValuesbyInst(Integer institutionId,  String osort, int limit, String dir) {
		String sort=osort.toLowerCase();
		System.out.println("Requesting sort: "+sort + " and direction "+dir);
		
        logger.info("Requesting sort: "+sort + "and direction "+dir);
		SortBy sb= SortBy.name;
		
		if (sort.equals("userid")) {
			sb = SortBy.id;
		}
		if (sort.equals("name")) {
			sb = SortBy.lastAndFirstName;
		}
		if (sort.equals("workphone")) {
			sb = SortBy.workPhone;
		}
		if (sort.equals("emailregular")) {
			sb = SortBy.emailRegular;
		}
		if (sort.equals("securitytype")) {
			sb = SortBy.securityType;
		}
		if (sort.equals("accessstatus")) {
			sb = SortBy.accessStatus;
		}
		if (institutionId.intValue()==0) {
			institutionId=(Integer) this.getContextAttribute(SessionKey.systemDomain.toString());

		}
		// For this service, don't intercept the institution ID. 
		// It actually does come from the front end.
		// Integer institutionId = (Integer) this.getContextAttribute("systemDomainId");
	     logger.info("Setting sort: "+sb.toString());
	     System.out.println("Setting sort: "+sb.toString());
		List list = userDAO.getSortedListBySystemDomainId(institutionId, sb,  dir.equals("ASC"));
        System.out.println("CALLED userDAO: Returned: "+list.size()+" users.");
		return list;
	}

	public List getSortedValuesbyIntegerFilter(Integer filter, String osort,
			int limit, String dir) {
		
		return getSortedUserValuesbyInst(filter,   osort,  limit,  dir);
	}

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {
		// TODO Auto-generated method stub
		return null;
	}


}
