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
package org.kuali.continuity.domain.report;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.kuali.continuity.report.ReportParameterData;

/**
 * This defines runnable parameters
 * @author richardkatz
 *
 */
public class Parameter {
    enum Method  { ITEM, MAP, VALUE };
	String parameterName;
    Object dataSource;
    Method method;
    ReportParameterData rpd = new ReportParameterData();
    public void loadInto(Map parameterMap, Connection conn, Object id) { 
    	if (method.equals(Method.MAP)) {
    		
    		Map item=null;
			try {
				item = rpd.getNameValuePairSeries(conn, (String) dataSource, id, "\n");
				parameterMap.put(parameterName, item);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    		
    	} else if (method.equals(Method.ITEM)) {
    		Map map;
			try {
				map = rpd.getParameters(conn,(String) dataSource, id);
				HashMap pmap = (HashMap) parameterMap;
	    		pmap.putAll(map);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
    		
    		
    	} else if (method.equals(Method.VALUE)) {
    		   parameterMap.put(parameterName, (String) dataSource);
    	}
    }
}
