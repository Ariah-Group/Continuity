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

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import org.kuali.continuity.service.ListService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * GWT-Ext Spring Controller for Lists
 * @author richkatz
 *
 */
public class ItemListServlet extends HttpServlet  {
	
	private static final Logger logger = Logger.getLogger(ItemListServlet.class);
	
	
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
			put("shift","item");
			put("staffcategory","item");
			put("departmenttype","item");
			put("division","division");
			put("utility","item");
			put("plannerscategory","item");
			put("dependency","item");
			put("setting","setting");
			put("acronym","acronym");
			put("building","building");
			put("function","function");
			put("knowledge","item");
			put("faq","faq");
			put("reference","item");
			put("contact","item");
			put("review","item");
			put("location","location");
			put("role","role");
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
		String dataset = req.getParameter("dataset") == null ? "" : 
				req.getParameter("dataset");
		int institutionId = req.getParameter("institution") == null ? 1 : Integer
				.parseInt(req.getParameter("institution"));				
		String dir = req.getParameter("dir") == null ? "asc" : req
				.getParameter("dir");
		if (start == 0) {
			start = 1;
		}
		
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
			String implid=req.getPathTranslated();
			String implName =dataset.toLowerCase();
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
			// items= (ArrayList) impl.getSortedList( dataset,   start,  sortBy,  limit,  dir,  ""+institutionId);

			 items= (ArrayList) impl.getSortedList( dataset,   start,  sortBy,  limit,  dir,  institutionId);

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
		System.out.println("\nItemListServlet: Request Parameters:");
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			System.out.println(" " + parameterName + "="
					+ req.getParameter(parameterName));
			logger.info(" " + parameterName + "="
					+ req.getParameter(parameterName));
		}
	}

}
