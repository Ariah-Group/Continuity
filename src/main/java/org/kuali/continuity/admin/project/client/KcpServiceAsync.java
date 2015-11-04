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
package org.kuali.continuity.admin.project.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface KcpServiceAsync {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public void getUsers(int institutionId, AsyncCallback<List> callback);
	public void getUserArray(int institutionId, AsyncCallback<String[][]> callback);
	public void getUsers(String institution, AsyncCallback<List> callback);
	public void getInstitutions(AsyncCallback<String [][]> callback);
	public void getButtonAnswer(AsyncCallback<String> callback);
	public void getUser(String userID, AsyncCallback<UserInfo> callback);
	public void updateUser(UserInfo ui, AsyncCallback<Void> callback);
	public void createUser(UserInfo ui, AsyncCallback<Void> callback);
	public void deleteUser(UserInfo ui, AsyncCallback<Void> callback);
}
