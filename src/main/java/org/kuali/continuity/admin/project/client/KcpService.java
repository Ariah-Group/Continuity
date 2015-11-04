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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("KcpService.rpc")
public interface KcpService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public List getUsers(int institutionId);
	public String[][] getUserArray(int institutionId);
	public List getUsers(String institution);
	public String [][] getInstitutions();
	public String getButtonAnswer();
	public UserInfo getUser(String userID);
	public String updateUser(UserInfo ui);
	public String createUser(UserInfo ui);
	public String deleteUser(UserInfo ui);
	
	public static class Util {
		private static KcpServiceAsync instance;
		public static KcpServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(KcpService.class);
			}
			return instance;
		}
	}
}
