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
package org.kuali.continuity.plan.action;

import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.action.util.SessionHelper;
import org.kuali.continuity.action.util.SessionHelperImpl;
import org.kuali.continuity.plan.action.dto.PageAccessControlDTO;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;
import org.kuali.continuity.service.ReportService;

/**
 * Not currently in use.  Will be
 * deleted due to YAGNI.
 * @author richkatz
 *
 */
public class PrintAction extends BasePlanActionSupport implements
		ServletResponseAware, ParameterAware, SessionAware, SessionHelper {
	private Map parameters;
	private SessionHelperImpl sessionHelper;
	private HttpServletResponse response;
	private static final Logger log = Logger.getLogger(PrintAction.class);

	public PrintAction(ReportService reportService) {
		this.reportService = reportService;

	}

	public void setSession(Map<String, Object> session) {
		this.sessionHelper = new SessionHelperImpl(session);
	}

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	ReportService reportService;

	// public void prepare() throws Exception {
	// super.prepare();
	// this.removeFromSession(SessionKey.plan);
	// }

	// SessionHelper 7 methods.
	public SessionPlanDTO getSessionPlan() {
		return (SessionPlanDTO) this.sessionHelper.getSessionValue(SessionKey.plan);
	}

	public SessionSystemDomainDTO getSessionSystemDomain() {
		return (SessionSystemDomainDTO) this.sessionHelper.getSessionValue(SessionKey.systemDomain);
	}

	public SessionUserDTO getSessionUser() {
		return (SessionUserDTO) this.sessionHelper.getSessionValue(SessionKey.user);
	}

	public PageAccessControlDTO getSessionPageAccessControl() {
		return (PageAccessControlDTO) this.sessionHelper.getSessionValue(SessionKey.planAccessControl);
	}

	public Object getSessionValue(SessionKey key) {
		return this.sessionHelper.getSessionValue(key);
	}

	public void putInSession(SessionKey key, SessionValue value) {
		this.sessionHelper.putInSession(key, value);

	}

	public void removeFromSession(SessionKey key) {
		this.sessionHelper.removeFromSession(key);
	}

	public void prepare() throws Exception {
		super.prepare();
	}
    /**
     * This is no longer used and will be deleted.
     */
	public String execute() throws Exception {
		System.out.println("Start printAction");

		String entire = getParameterValue("entire");
		String section = getParameterValue("section");
		log.info("Start printAction for PDF: " + section);
		System.out.println("Parameters: " + entire + " " + section);
		section = "ai"; // For testing
		String uiText = (String)sessionHelper.getSessionValue(SessionKey.uiText);
		String acronymPlusName = (String)sessionHelper.getSessionValue(SessionKey.acronymPlusName);
		if (reportService != null) {
			OutputStream pdfOut = reportService.runPrint(5, acronymPlusName, uiText, section, "");
			response.setContentType("application/pdf; name=\"contiunity.pdf\"");
			response.setHeader("Content-Disposition",
					"inline;filename=\"contiunity.pdf\"");

			OutputStream out = response.getOutputStream();
			reportService.runPrint(5, acronymPlusName, uiText, section, "", out);

			out.flush();
			out.close();
		} else {
			System.out.println("Struts Test mode");
		}
		return SUCCESS;
	}

	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;

	}

	public Map getParameters() {
		return parameters;
	}

	public String getParameterValue(String param) {
		Map p = getParameters();
		if (p == null) {
			return null;
		} else {
			Object varr = getParameters().get(param);
			if (varr == null)
				return null;
			return ((String[]) varr)[0];
		}
	}

}
