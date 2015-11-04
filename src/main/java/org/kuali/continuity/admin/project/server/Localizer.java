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

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;

public class Localizer {
	private static final Logger logger = Logger.getLogger(Localizer.class);
	
	@SuppressWarnings("unchecked")
	protected static ThreadLocal<Map> localMap = new ThreadLocal<Map>() {
		@Override
		protected Map initialValue() {
			return (Map) new HashMap();
		}
	};

	public  void localize(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		localMap.set(this.mapData(session));
       
	}
    
    @SuppressWarnings("unchecked")
	public Map getLocalMap() {
    	return localMap.get();
    }

    @SuppressWarnings("unchecked")
	public  Map mapData(HttpSession session) {
		HashMap ret = new HashMap();
		
		// Get institution
		String instKey = SessionKey.systemDomain.toString();
		
		
		Object oInstDto = session.getAttribute(instKey);
		SessionSystemDomainDTO sd = (SessionSystemDomainDTO) oInstDto;
		logger.info("transfer from session: Institution Key: "+sd.name+" "+sd.getId());

		ret.put(instKey, sd.getId());
		ret.put(instKey+"Full", sd);
		
		// Get User
		Object oUserDto = session.getAttribute(SessionKey.user.toString());
		SessionUserDTO ud = (SessionUserDTO) oUserDto;
		ret.put(SessionKey.user.toString(), ud);
		
		// Get Token
		ret.put(SessionKey.adminCsrfToken.name(), session.getAttribute(SessionKey.adminCsrfToken.name()));
		return ret;
	}

}
