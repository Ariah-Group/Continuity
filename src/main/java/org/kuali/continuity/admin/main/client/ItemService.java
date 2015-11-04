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

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ItemService.rpc")
public interface ItemService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */

	public Item getItem(String rootName, String id);
	public String insertItem(String rootName, Item item);
	public String updateItem(String rootName,  Item  item);
	public String deleteItem(String rootName, Item  item);
	
	public static class Util {
		private static ItemServiceAsync instance;
		public static ItemServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(ItemService.class);
			}
			return instance;
		}
	}
}
