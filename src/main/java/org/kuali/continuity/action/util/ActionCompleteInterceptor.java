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
package org.kuali.continuity.action.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionMessage;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ActionCompleteInterceptor implements Interceptor {
	
	private final static String SESSION_MESSAGE_DEFAULT_VALUE = "Action Completed.";

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		// get request
		HttpServletRequest request = ServletActionContext.getRequest();

	    // if not base plan action support, invoke action the return
	    if (!(actionInvocation.getAction() instanceof BaseActionSupport)) 
	    	return actionInvocation.invoke();

	    // process action
		String httpMethod = request.getMethod();
		if (httpMethod.equalsIgnoreCase("POST")) return processPost(actionInvocation);
		if (httpMethod.equalsIgnoreCase("GET"))  return processGet (actionInvocation);
		return actionInvocation.invoke();
	}
	
	private String processGet(ActionInvocation actionInvocation) throws Exception {
	    // for base support
    	BaseActionSupport baseAction = (BaseActionSupport) actionInvocation.getAction();
    	
    	// get tmp message and set action message
    	SessionMessage tmpMessage = (SessionMessage) actionInvocation.getInvocationContext().getSession().get(SessionKey.tmpActionMessage);
    	if (tmpMessage != null && tmpMessage.getMessage() != null && tmpMessage.getMessage().trim().length() != 0 && baseAction.getActionMessages().isEmpty())
    		baseAction.addActionMessage(tmpMessage.getMessage());
    	
    	// remove session
    	actionInvocation.getInvocationContext().getSession().remove(SessionKey.tmpActionMessage);
    	
    	// return
    	return actionInvocation.invoke();
	}
	
	private String processPost(ActionInvocation actionInvocation) throws Exception {
	    // for base support
    	BaseActionSupport baseAction = (BaseActionSupport) actionInvocation.getAction();
    	SaveTypeEnum saveTypeEnum = baseAction.getSaveTypeEnum();
	    	
    	// if continue, do not even invoke action
    	if (saveTypeEnum == SaveTypeEnum.CONTINUE) return saveTypeEnum.getActionReturnValue();
    	
    	// now, invoke the action
	    String retVal = actionInvocation.invoke();
	    if (retVal.equals(Action.SUCCESS)) {
	    	// store in session action completed message
	    	SessionMessage tmpMessage = (SessionMessage) actionInvocation.getInvocationContext().getSession().get(SessionKey.tmpActionMessage.name());
	    	if (tmpMessage == null || tmpMessage.getMessage() == null || tmpMessage.getMessage().trim().length() == 0)
	    		actionInvocation.getInvocationContext().getSession().put(SessionKey.tmpActionMessage.name(), new SessionMessage(SESSION_MESSAGE_DEFAULT_VALUE));
	    }
	    
	    // return
	    return retVal;
	}
	
}