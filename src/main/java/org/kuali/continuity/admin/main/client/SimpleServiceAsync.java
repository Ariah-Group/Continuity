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



import com.google.gwt.user.client.rpc.AsyncCallback;
/**
 * Simple Service sends and receives NamedItems from the client
 * and sends and receives NamedAdminItems from the database.
 * @author richkatz
 *
 */
public interface SimpleServiceAsync {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */

	public  void getItem(String rootName, Integer id, AsyncCallback<NamedItem> callback);
	public void insertItem(String rootName, NamedItem item, AsyncCallback<Void> callback);
	public void updateItem(String rootName,  NamedItem  item, AsyncCallback<Void> callback);
	public void deleteItem(String rootName, NamedItem  item, AsyncCallback<Void> callback);
	public void getStringArray(String rootName, Integer institutionId, AsyncCallback<String [][]> callback);
	public void getStringPlanArray(String rootName, Integer institutionId, AsyncCallback<String [][]> callback);
}
