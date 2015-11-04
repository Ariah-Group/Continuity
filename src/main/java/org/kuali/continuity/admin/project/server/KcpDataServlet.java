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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.UserLoginService;
import org.kuali.continuity.domain.valueobject.UserListValue;
import org.kuali.continuity.service.RoleService;
import org.kuali.continuity.util.DisplayUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class KcpDataServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(KcpDataServlet.class);
	RoleService impl;

	protected void setRoleService(RoleService roleService) {
		this.impl = roleService;
	}

	public void init() {
		logger.info("Context Startup Begin");
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		setRoleService((RoleService) context.getBean("roleService"));
		logger.info("Context Startup Complete");

	}

	UserLoginService userLoginService;

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		printParameters(request);
		JSONObject jsonDataToReturn;
		JSONArray jsonPersons;
		jsonDataToReturn = new JSONObject();
		ArrayList persons = getUserValueList(1);
		jsonPersons = new JSONArray(persons, true);
		try {
			logger.info("kcpDataServlet.doGet: Saving Local Data");
			new Localizer().localize(request); // Place required variables on
												// ThreadLocal.

			jsonDataToReturn.put("persons", jsonPersons);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.getWriter().print(jsonDataToReturn.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse response) {
		printParameters(req);
		logger.info("Post Start");
		// int institutionId=new
		// Integer(req.getParameter("institution")).intValue();
		logger.info("KcpDataServlet: Saving Local Data");
		new Localizer().localize(req); // Place required variables on
										// ThreadLocal.

		int start = req.getParameter("start") == null ? 1 : Integer
				.parseInt(req.getParameter("start"));
		int limit = req.getParameter("limit") == null ? 10 : Integer
				.parseInt(req.getParameter("limit"));
		String sortBy = req.getParameter("sort") == null ? "id" : req
				.getParameter("sort");
		String dir = req.getParameter("dir") == null ? "asc" : req
				.getParameter("dir");

		boolean sorting = true;

		logger.info("start set to: " + start);
		JSONObject jsonDataToReturn;
		jsonDataToReturn = new JSONObject();
		JSONArray jsonPersons;
		logger.info("JSON Objects created.");
		try {

			logger.info("get List.");
			ArrayList<User> persons0 = null;
			if (sorting) {
				System.out.println("Sorting!");
				// Handle idiosyncratic sort difference between DAO and screen
				persons0 = filterSecuirty(req,getSortedUserValueList(start, sortBy, limit, dir));
			} else {

				if (limit < 99) {
					persons0 = filterSecuirty(req,getUserValueList(start, limit));
				} else {
					persons0 = getUserValueList(start);
				}
			}
			logger.info("returns " + persons0.size());
			ArrayList<UserListValue> persons = new ArrayList();
			for (User u : persons0) {
//				logger.info(u.getName() + u.getWorkPhone());
				UserListValue uv = getUserListValue(u);
				persons.add(uv);
				
			}
			
			
			jsonPersons = new JSONArray(persons, true);

			jsonDataToReturn.put("persons", jsonPersons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			logger.warn("Failed with exception", e);
		}
		try {
			response.getWriter().print(jsonDataToReturn.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn("Failed with exception", e);
		}
		logger.info("Post End");

	}
	UserListValue getUserListValue(User u) {
		UserListValue uv= new UserListValue();
		 uv.setUserID(u.getUserId());
		 uv.setName(u.getLastName()+" "+u.getFirstName().trim());
		 uv.setInstitutionID(u.getId());
		 uv.setEmailregular(u.getEmailRegular());
		 uv.setWorkPhone(u.getWorkPhone());
		 uv.setSecurityType(DisplayUtil.displayRole(u.getSecurityType().getId()));
		 uv.setAccessStatus(DisplayUtil.displayAccess(u.getAccessStatus().getDescription()));
		return uv;
	}

	private void printParameters(HttpServletRequest req) {
		Enumeration parameterNames = req.getParameterNames();
		System.out.println("\nRequest Parameters:");
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			System.out.println(" " + parameterName + "="
					+ req.getParameter(parameterName));
			logger.info(" " + parameterName + "="
					+ req.getParameter(parameterName));
		}
	}

	public ArrayList getUserValueList(int institutionId) {
		return (ArrayList) impl.getUserValuesbyInst(institutionId);
	}

	public ArrayList getUserValueList(int institutionId, int limit) {
		return (ArrayList) impl.getUserValuesbyInst(institutionId, limit);
	}

	public ArrayList getSortedUserValueList(int institutionId, String sort,
			int limit, String dir) {
		return (ArrayList) impl.getSortedUserValuesbyInst(institutionId, sort,
				limit, dir);
	}

	public ArrayList getUserArray(int institutionId) {
		ArrayList ulist = new ArrayList();
		if (1 == 1) { // test mode.
			String[] data1 = { "Jefferson Tom", "tjeff@berkeley.edu", "2-1212",
					"Administrator", "ON" };
			String[] data2 = { "Washington George", "gw@berkeley.edu",
					"3-3131", "User", "ON" };
			String[] data3 = { "Franklin Ben", "wiseman@berkeley.edu",
					"3-3131", "User", "ON" };
			String[][] ulist0x = { data1, data2, data3 };
			ulist.add(data1);
			ulist.add(data2);
			ulist.add(data3);

		} else {
			List userlist = getUsers(institutionId);
			// for (User o: (List <User>) userlist) {
			// org.kuali.continuity.domain.User ui = new
			// org.kuali.continuity.domain.User();
			// ui.setFirstName(o.getFirstName());
			// ui.setLastName(o.getLastName());
			// }
			ulist = (ArrayList) userlist;

		}

		return ulist;
	}

	public List getUsers(int institutionId) {
		return impl.getAllUsersbyInst(institutionId);

	}
	
	private ArrayList<User> filterSecuirty(HttpServletRequest req, ArrayList<User> users) {
		ArrayList<User> result = new ArrayList();
		
		
		SessionUserDTO sud = (SessionUserDTO) req.getSession().getAttribute(SessionKey.user.name());
		int loggedInSecurityType = Integer.parseInt(sud.getDomainObject()
				.getSecurityType().getId());

		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			String secType = user.getSecurityType().getId();
			
			switch (loggedInSecurityType) {
			case 1: // Local Admin
				if (!secType.equalsIgnoreCase("0")
						&& !secType.equalsIgnoreCase("3")) {
					result.add(user);
					System.out.println("Adding " + user.getName() + "Sec type " + secType);
	
				}else{
					System.out.println("Ignoring User " + user.getName());
				}
				break;
			case 3: // Institutional Admin
				if (!secType.equalsIgnoreCase("0")) {
					result.add(user);
				}else{
					System.out.println("Ignoring User " + user.getName());
				}
				break;
			default:
				result = users;
				break;
			}

		}
		System.out.println("Returning User List with Size: " + result.size());
		return result;
	}

}
