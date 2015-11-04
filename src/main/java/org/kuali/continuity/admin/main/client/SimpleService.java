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
package org.kuali.continuity.admin.main.client;



import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * Simple Service sends and receives NamedItems from the client
 * and sends and receives NamedAdminItems from the database.
 * @author richkatz
 *
 */
@RemoteServiceRelativePath("SimpleService.rpc")
public interface SimpleService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */

	public  NamedItem getItem(String rootName, Integer id);
	public String insertItem(String rootName, NamedItem item);
	public String updateItem(String rootName,  NamedItem  item);
	public String deleteItem(String rootName, NamedItem  item);
	public String [][] getStringArray(String rootName, Integer institutionId);
	public String [][] getStringPlanArray(String rootName, Integer institutionId);

//	public void saveStringArray(String rootName, Integer institutionId, String[][] stringArray);
	
	public static class Util {
		private static SimpleServiceAsync instance;
		public static SimpleServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(ItemService.class);
			}
			return instance;
		}
	}
}
