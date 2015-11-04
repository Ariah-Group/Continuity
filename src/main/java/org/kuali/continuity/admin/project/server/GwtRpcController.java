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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.kuali.continuity.service.RoleService;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GwtRpcController extends RemoteServiceServlet implements
        Controller, ServletContextAware {
	private static final Logger logger = Logger.getLogger(GwtRpcController.class);

    private ServletContext servletContext;

    private RemoteService remoteService;

    private Class remoteServiceClass;
      

	public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		logger.info("GwtRpeController.handleRequest: Saving Local Data");
		System.out.println("GwtRpeController.handleRequest: Saving Local Data");
		new Localizer().localize(request);  // Place required variables on ThreadLocal.
        super.doPost(request, response);
        return null;
    }

    @Override
    public String processCall(String payload) throws SerializationException {
        try {
        	System.out.println("GwtRpcController: received "+ payload);
        	   
            RPCRequest rpcRequest = RPC.decodeRequest(payload,
                    this.remoteServiceClass);
            logger.info("GwtRpeController.processCall: "+remoteServiceClass.getName());
            // delegate work to the spring injected service
            return RPC.invokeAndEncodeResponse(this.remoteService, rpcRequest
                    .getMethod(), rpcRequest.getParameters());
        } catch (IncompatibleRemoteServiceException ex) {
            getServletContext()
                    .log(
                            "An IncompatibleRemoteServiceException was thrown while processing this call.",
                            ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }

    @Override
    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void setRemoteService(RemoteService remoteService) {
        this.remoteService = remoteService;
        this.remoteServiceClass = this.remoteService.getClass();
    }

}