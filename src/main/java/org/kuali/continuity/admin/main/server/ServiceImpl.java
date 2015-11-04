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

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.project.server.Localizer;
import org.kuali.continuity.security.SecurityUtil;
import org.springframework.web.context.ServletContextAware;

public class ServiceImpl implements ServletContextAware {
	private final Logger logger = Logger.getLogger(ServiceImpl.class);
	public final static String INVALID_CSRF_TOKEN_MESSAGE = "Invalid CSRF security token! Please contact system administrator.";

	protected ServletContext servletContext;

	public void setServletContext(ServletContext servletContextin) {
		this.servletContext = servletContextin;

	}

	protected Object getContextAttribute(String attribute) {
		logger.info("Start getAttribute");
		Object ret = new Integer("1");
		Map m = getUserInfo();
		Integer instkey= (Integer) m.get(SessionKey.systemDomain.toString());
		ret = instkey;
		logger.info("getContextAttribute: get from LOCALIZER: Institution Key: "+ret);

		if (null != servletContext && 1==2) {
			if (servletContext.getAttribute(SessionKey.user.toString()) != null) {
				try {

					logger.info("Get Context value");
	
					System.out.println("I GOT INSTITUTION: "+ret);
					// This should not happen anymore... The code can be pulled.
					if (null == ret) {
						SessionUserDTO sessionUserDTO = (SessionUserDTO) servletContext
								.getAttribute(SessionKey.user.toString());
						if (attribute.equals("systemDomainId")) {
							ret = sessionUserDTO.systemDomain.getId();

						} else if (attribute.equals("accessLevel")) {
							ret = Integer
									.parseInt(sessionUserDTO.accessStatus.id);
						} else if (attribute.equals("securitytype")) {
							ret = sessionUserDTO.getDomainObject().getSecurityType().getId();
						} else if (attribute.equals("shibMode")) {
							ret = new Boolean(sessionUserDTO.isShibMode);
						}
					}

				} catch (Exception e) {
					logger.warn("Context does not contain " + attribute);
					ret = new Integer("1"); // This enables testing without
					// Servlet
					// container
				}
			} else {
				// No SessionUserDTO is stored. Could create one here (if and
				// only if user can log into Admin console
			}
		}
		logger.info("getContextAttribute: Returning value: " + ret);
		return ret;
	}

	protected Map getUserInfo() {
		Localizer loc = new Localizer();

		Map userInfo = loc.getLocalMap();

		return (Map) userInfo;
	}

	protected boolean isCsrfTokenValid(String token) {
		String clientToken = SecurityUtil.decode(token);
		String sessionToken = (String) this.getUserInfo().get(SessionKey.adminCsrfToken.name());
		boolean isValid =  
			(clientToken != null && clientToken.trim().length() != 0 &&
			 sessionToken != null && sessionToken.trim().length() != 0 &&
			 clientToken.trim().equals(sessionToken.trim()));
		if (!isValid) logger.warn(
			"Security tokens do not match.  " +
			"Possible CSRF Attack!  " +
			"Session Token is '" + sessionToken + "' and Client Token is '" + clientToken + "'");
		return isValid;
	}

}
