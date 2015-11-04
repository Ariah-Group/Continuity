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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.kuali.continuity.admin.project.server.Localizer;
import org.kuali.continuity.service.ListService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * GWT-Ext Spring Controller for Lists
 * @author richkatz
 *
 */
public class AjaxSpringListController extends HttpServlet  {
	
	private static final Logger logger = Logger.getLogger(AjaxSpringListController.class);
	
	
//	protected void setItemService(ItemService itemService) {
//		this.impl = itemService;
//	}
	WebApplicationContext context=null;
	public void init() {
		logger.info("Context Startup Begin");
		 context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		//setItemService((ItemService) context.getBean("itemService"));
		logger.info("Context Startup Complete");

	}
	/**
	 * ===========================
	 * Maps lists to their service.  
	 * The ones known as item all go to the itemService
	 * which actually processes ordered items.
	 * that follow the Id, Name, OrderNo convention.
	 * and use the itemDaoFactory.
	 *
	 * Other objects that do not follow this convention
	 * have their own individual services.
	 * 
	 * 
	 */
	HashMap serviceMap = new HashMap() {
		{
			put("application", "item");
			put("activitylog", "simple");
			put("plan", "simple");  // Used by for instance ActivityLog to get a list of plans
			put("deptplan", "simple");  // Used by for instance ActivityLog to get a list of plans
			put("shift","item");
			put("staffcategory","item");
			put("skill","item");
			put("type","item");  //DepartmentType
			put("division","simple");
			put("department","simple");
			put("utility","item");
			put("plannerscategory","item");
			put("reference","item");
			put("contact","item");
			put("review","item"); // Annual Review Item
			put("dependency","item");
			put("setting","simple");
			put("acronym","simple");
			put("building","simple");
			put("example","simple");
			put("function","simple");
			put("knowledge","item");
			put("faq","item");
			put("location","simple");
			
			put("role","simple");
		}
	};
	
	protected int getInstitution(HttpServletRequest req) {
		return 1;
		
	}
	/**
	 * The ListService interface of each service is called here.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse response) {
		printParameters(req);
		logger.info("Post Start");
		System.out.println("Post start");
		// int institutionId=new
		// Integer(req.getParameter("institution")).intValue();
		
		int start = req.getParameter("start") == null ? 1 : Integer
				.parseInt(req.getParameter("start"));
		int limit = req.getParameter("limit") == null ? 10 : Integer
				.parseInt(req.getParameter("limit"));
		String sortBy = req.getParameter("sort") == null ? "id" : req
				.getParameter("sort");
		String dataset = req.getParameter("dataset") == null ? "skill" : 
				req.getParameter("dataset").toLowerCase();
		int institutionId = req.getParameter("institution") == null ? 1 : Integer
				.parseInt(req.getParameter("institution"));				
		String dir = req.getParameter("dir") == null ? "asc" : req
				.getParameter("dir");
		if (start == 0) {
			start = 1;
		}
		// Deal with SAML and session data.
		ServletContext sc =req.getSession().getServletContext();
		sc.setAttribute("systemDomainId", new Integer("1"));
	
		// Deal with request.
		boolean sorting=true;
		ListService impl = null; 
		logger.info("start set to: "+start);
		JSONObject jsonDataToReturn;
		jsonDataToReturn = new JSONObject();
		JSONArray jsonItems;
		logger.info("JSON Objects created.");
		try {
			// Spring loading.
			// String implname=req.getPathInfo().substring(1);
			logger.info("AjaxSpring: Saving Local Data");
			new Localizer().localize(req);  // Place required variables on ThreadLocal.
			String implid=req.getPathTranslated();
			String implName =dataset.toLowerCase();
		    System.out.println("Will call service for: "+implName);
					
			String mappedService = (String) serviceMap.get(implName);
		    impl =(ListService) context.getBean(mappedService+"Service");
			//impl =(ListService) context.getBean("itemService");
		    System.out.println("Will call "+mappedService+"Service");
			logger.info("get List.");
			ArrayList  items = null;
			
		    institutionId=getInstitution(req);
			if (sorting) {
				System.out.println("Sorting!");
			}
			
			// Although we have routed the dataset request to a service, a given service may handle
			// multiple kinds of datasets and needs to know what root is requested.

			items= (ArrayList) impl.getSortedList( dataset,   start,  sortBy,  limit,  dir,  institutionId);

			// items= (ArrayList) impl.getSortedValuesbyIntegerFilter(institutionId, sortBy, limit, dir);
			if (null == items) {
				items= new ArrayList();
			}
			logger.info("returns "+items.size());

			jsonItems = new JSONArray(items, true);

			jsonDataToReturn.put("items", jsonItems);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			logger.warn("Failed with exception", e);
		}
		try {
			response.getWriter().print(jsonDataToReturn.toString());
			System.out.println("returned.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.warn("Failed with exception", e);
		}
		logger.info("Post End");

	}

	private void printParameters(HttpServletRequest req) {
		Enumeration parameterNames = req.getParameterNames();
		System.out.println("URL Pattern S: "+req.getServletPath());
		System.out.println("URL Pattern I: "+req.getPathInfo());
		System.out.println("\nAjaxSpring: Request Parameters:");
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			System.out.println(" " + parameterName + "="
					+ req.getParameter(parameterName));
			logger.info(" " + parameterName + "="
					+ req.getParameter(parameterName));
		}
	}

}
