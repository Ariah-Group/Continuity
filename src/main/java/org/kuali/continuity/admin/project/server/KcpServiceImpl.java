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
package org.kuali.continuity.admin.project.server;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.main.server.ServiceImpl;
import org.kuali.continuity.admin.project.client.KcpService;
import org.kuali.continuity.admin.project.client.UserInfo;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.admin.service.UserLoginService;
import org.kuali.continuity.domain.AccessStatus;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.service.EmailMessageEnum;
import org.kuali.continuity.service.RoleService;

public class KcpServiceImpl extends ServiceImpl implements KcpService {

	// Spring injected.
	RoleService roleService = null;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	// public void init() {
	// logger.info("Context Startup Begin");
	// if (impl == null) {
	// // WebApplicationContext context = WebApplicationContextUtils
	// // .getRequiredWebApplicationContext(this.getServletContext());
	// // setRoleService((RoleService) context.getBean("roleService"));
	// //
	// }
	// logger.info("Context Startup Complete");
	//
	// }
	UserLoginService userLoginService;
	SystemDomainService systemDomainService;

	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}

	private static final Logger logger = Logger.getLogger(KcpServiceImpl.class);

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	/**
	 * Provide Institution List Box
	 */
	public String[][] getInstitutions() {
		String[][] a = null;
		try {
		List ret = null;
		logger.info("Servlet getInstitutions call");
		int thisLoc = (Integer) this
				.getContextAttribute(SessionKey.systemDomain.toString());
		Map m = getUserInfo();
		SessionUserDTO sud = (SessionUserDTO) m.get(SessionKey.user.toString());
		String thisRole = sud.getDomainObject().getSecurityType().getId();
		ret = roleService.getInstitutionValueList();

		logger.info("ret size:" + ret.size());
		logger.info("Servlet getInstitutions return");
		
		if (ret.size() > 0) {
			a = new String[ret.size()][3];
		}

		for (int i = 0; i < ret.size(); i++) {
			a[i] = (String[]) ret.get(i);
			if (Integer.parseInt(a[i][1]) == thisLoc) {
				a[i][2] = thisRole;

			}
		}
		// Test code.
		String[][] aa = { { "abc", "def" }, { "123", "456" }, { "AB", "DEF" } };
		} catch (Exception e) {
			System.out.println("getInstitutions: Exception "+e);
			logger.warn("getInstitutions: Exception",e);
		}
		return a;

	}

	public String[][] getUserArray(int institutionId) {
		System.out.println("Getting user array for " + institutionId);
		logger.info("Getting array users for " + institutionId);
		int nusers = 0;
		String[][] ulist;
		if (1 == 2) { // test mode.
			String[] data1 = { "Jefferson, Tom", "tjeff@berkeley.edu",
					"2-1212", "Administrator", "ON" };
			String[] data2 = { "Washington, George", "gw@berkeley.edu",
					"3-3131", "User", "ON" };
			String[] data3 = { "Franklin, Ben", "wiseman@berkeley.edu",
					"3-3131", "User", "ON" };
			String[][] ulist0 = { data1, data2, data3 };
			return ulist0;
		} else {
			List userlist = getUsers(institutionId);
			nusers = userlist.size();
			ulist = new String[userlist.size()][6];
			for (int i = 0; i < userlist.size(); i++) {
				User u = (User) userlist.get(i);
				ulist[i][0] = u.getLastName() + ", " + u.getFirstName();
				ulist[i][1] = u.getEmailRegular();
				ulist[i][2] = u.getWorkPhone();

				ulist[i][3] = "Administrator";

				if (u.getAccessStatus().equals("0")) {
					ulist[i][4] = "OFF";
				} else {
					ulist[i][4] = "ON";
				}
				ulist[i][5] = u.getUserId().toString();

			}

		}
		System.out.println("Retrieved " + nusers);
		File f = new File(".");
		System.out.println("Directory:");
		String[] flist = f.list();
		for (String s : flist) {
			System.out.print(s + " ");
		}
		System.out.println();
		logger.info("Retrieved " + nusers);
		return ulist;
	}

	public UserInfo getUser(String userID) {
		User u = roleService.getUser(new Integer(userID).intValue());
		UserInfo ui = new UserInfo();

		// Determining if the User if Logged in or Trying to get his own record
		Map m = getUserInfo();
		SessionUserDTO sud = (SessionUserDTO) m.get(SessionKey.user.name());
		try {
			if (sud != null) {
				logger.debug("Loggedin User ID is "
						+ sud.getDomainObject().getUserId());
				logger.debug("Fetting User ID is " + userID);

				if (sud.getDomainObject().getUserId().toString()
						.equalsIgnoreCase(userID)) {
					logger.debug("User is Self");
					ui.isUserSelf(true);
				}else
				{
					ui.isUserSelf(false);
				}
			} else {
				logger.error("Session User DTO Is null");
			}
		} catch (Exception ex) {
			logger.error("Error while fetching loggedin user", ex);
		}

		try {
			BeanUtils.copyProperties(ui, u);
			ui.setEmailregular(u.getEmailRegular());
			ui.setAccessStatus(u.getAccessStatus().getId());
			ui.setSecurityType(u.getSecurityType().getId());

			System.out.println("Field Match reading AccessStatus: "
					+ u.getAccessStatus().getId());
			System.out.println("Field Match setting AccessStatus: "
					+ ui.getAccessStatus());
		} catch (Exception e) {
			logger.warn("Unable to copy user", e);
		}
		return ui;
	}

	public List getUsers(int institutionId0) {

		Integer institutionId = (Integer) this
				.getContextAttribute("systemDomainId");
		int accessLevel = (Integer) this.getContextAttribute("accessLevel");
		logger.info("Get users for: " + institutionId);
		return roleService.getAllUsersbyInst(institutionId);

	}

	/**
	 * Test to ensure servlet container is operational.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		// List<SystemDomain> universities = impl.getInstitutions();
		List<String[]> universities = roleService.getInstitutionValueList();
		// User u = impl.getUser(PlanTestData.known_complete_user);
		UserInfo ui = new UserInfo();
		// Interpret Servlet-Service Request
		logger.info("Servlet get Startup");
		try {
			PrintWriter out = response.getWriter();
			// out.print("<html><body><p>I'm alright. " + getButtonAnswer());
			out.print("Servlet has been reached - OK<br>");
			for (String[] sd : universities) {
				out.println("<p>" + sd[0] + "," + sd[1] + "</p>");
				// out.println("<p>"+sd.getInstitution()+"</p>");
			}
			// BeanUtils.copyProperties(u, ui);
			// out.print(u.getAuthId());
			// out.print(ui.getAuthId());
			//			
			// System.out.println(u.getDirectoryId()+" "+u.getAuthId());
			// System.out.println(ui.getDirectoryId()+" "+ui.getAuthId());

			out.print("</p></body></html>");

		} catch (Exception e) {
			logger.warn("Exception during test: ", e);
			System.out.println("Exception during test: " + e);
			e.printStackTrace();
		}
		logger.info("Servlet get Complete");
	}

	public String getButtonAnswer() {
		return "hey baby"; // Janice Joplin button.
	}

	org.kuali.continuity.admin.domain.User loadUser(UserInfo ui,
			int institutionId, boolean preread) {
		org.kuali.continuity.admin.domain.User tu = null;

		if (preread) {
			System.out.println("Retrieve user: " + ui.getUserId());
			tu = roleService.getUser(ui.getUserId());
		} else {
			tu = new org.kuali.continuity.admin.domain.User();
		}
		System.out.println("Institution ID: " + institutionId);
		tu.setFirstName(ui.getFirstName());
		tu.setLastName(ui.getLastName());
		tu.setWorkAddress(ui.getWorkAddress());
		tu.setEmailRegular(ui.getEmailregular());

		tu.setDepartmentName(ui.getDepartmentName());
		tu.setTitle(ui.getTitle());
		tu.setWorkPhone(ui.getWorkPhone());
		tu.setAuthId(ui.getAuthId());
		System.out.println("Field Match Saving: " + tu.getAuthId());
		// Specials for objectified (non string/int) objects in the Domain model
		SecurityType securityType = new SecurityType();
		securityType.setId(ui.getSecurityType());
		tu.setSecurityType(securityType);
		System.out.println("securityType: " + securityType.getId());
		tu.setSystemDomainId(institutionId);
		AccessStatus accessStatus = new AccessStatus();

		accessStatus.setId(ui.getAccessStatus());
		System.out.println("access Status: " + accessStatus.getId());
		tu.setAccessStatus(accessStatus);

		tu.setDateCreated(new GregorianCalendar().getTime());

		return tu;
	}
	
	public String createUser(UserInfo ui){
		// check token
		if (!this.isCsrfTokenValid(ui.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		User u = new User();
		try {
			// BeanUtils.copyProperties(u, ui);
			int thelocation = (Integer) this
					.getContextAttribute("systemDomainId");

			System.out.println("KCP create: copy Properties");

			// Note that institution added is not the administrators
			// institution, but what is specified.
			org.kuali.continuity.admin.domain.User tu = loadUser(ui, ui
					.getInstitutionId(), false);
			
			
			User testUser = null;
			testUser = userLoginService.getBySystemDomainIdAndAuthId(tu.getSystemDomainId(), tu.getAuthId());
			if (testUser != null) {				
				return "Specified login name already exists";
			}
			
			System.out.println("KCP inserting");
			roleService.addUser(tu);
			// KCP 157 Password is required on Create
			logger.info("adding password.");
			String password = ui.getPassword(); 
			
			//Check if this is full moderation or partial.
			SystemDomain systemDomain = this.systemDomainService.getById(tu.getSystemDomainId());
			userLoginService.changePassword(tu.getId(), password, true);	
			
			List<org.kuali.continuity.admin.domain.User> users = (List) new ArrayList();

			users.add(tu);
			System.out.println("KCP call Service");
			// KCP 157 Password is required on Create - no longer call to approve.
			// userLoginService.approveUserLogins(users, true);
			System.out.println("Create done.");
			
			
		} catch (Exception e) {
			System.out.println("Unable to create user " + e);
			logger.warn("Unable to create user", e);
		}
		
		return "";
	}
	
	public String deleteUser(UserInfo ui) {
		// check token
		if (!this.isCsrfTokenValid(ui.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		Integer userId = ui.getUserId();
		try {
			roleService.deleteUser(userId);
			System.out.println("Delete done.");
		} catch (Exception e) {
			System.out.println("Unable to delete user " + e);
			logger.warn("Unable to delete user", e);
		}
		
		return "";
	}

	public String updateUser(UserInfo ui) {
		// check token
		if (!this.isCsrfTokenValid(ui.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		int thelocation = (Integer) this.getContextAttribute("systemDomainId");
		User u = loadUser(ui, ui.getInstitutionId(), true);
		try {
			
			SystemDomain systemDomain = this.systemDomainService.getById(u.getSystemDomainId());
			if (systemDomain.isShibMode()) {
				roleService.updateUser(u);
				return "";
			}

			User testUser = null;
			testUser = userLoginService.getBySystemDomainIdAndAuthId(u.getSystemDomainId(), u.getAuthId());
			if (testUser != null && !testUser.getId().equals(u.getId())) {				
				return "Specified login name already exists";
			}
			
			roleService.updateUser(u);
			// KCP 157 Password is not required on update, but must be 8 charaters or more
			if (null!= ui.getPassword() && ui.getPassword().length()>7) {
				logger.info("Updating password.");
				userLoginService.changePassword(u.getId(), ui.getPassword());
				
			}
			System.out.println("Update done.");
		} catch (Exception e) {
			System.out.println("Unable to save user " + e);
			logger.warn("Unable to save user", e);
		}
		
		return "";

	}

	// This shouldn't have to be here anymore, but since it is..
	public List getUsers(String institution) {
		return getUsers((int) Integer.parseInt(institution));

	}
}
