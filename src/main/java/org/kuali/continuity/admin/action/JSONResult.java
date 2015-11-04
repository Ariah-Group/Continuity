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
package org.kuali.continuity.admin.action;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("serial")
public class JSONResult implements Result {

	@SuppressWarnings("unchecked")
	public void execute(ActionInvocation invocation) throws Exception {

		ServletActionContext.getResponse().setContentType("text/plain");
		PrintWriter responseStream = ServletActionContext.getResponse()
				.getWriter();

		/* Retrieve Objects to Serialize to JSON from ValueStack */
		ValueStack valueStack = invocation.getStack();
		Object jsonObject = valueStack.findValue("jsonModel");
		
		JSONObject jsonResult = new JSONObject();
		if (jsonObject instanceof Map) {
			Map<String, Object> jsonMap = (Map<String, Object>) jsonObject;
			for (String jsonKey : jsonMap.keySet()) {
				Object jsonMapValue = jsonMap.get(jsonKey);
				if (jsonMapValue instanceof Collection) {
					JSONArray jsonCollection = new JSONArray((Collection)jsonMapValue, true);
					jsonResult.put(jsonKey, jsonCollection);
				} else {
					jsonResult.put(jsonKey, jsonMapValue);
				}
			}
		} else {
			jsonResult.put(jsonObject.getClass().getName(), jsonObject);
		}

		
		// write to stream
		responseStream.print(jsonResult.toString());
	}

}
