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
package org.kuali.continuity.service;

import org.kuali.continuity.admin.main.client.Item;

public interface OrderingService {
	
	/**
	 * Insert a new ordered item into the specified list
	 * @param itemRoot the set or list to insert into.
	 * @param location the institution who controls this set 
	 * @param item the item to insert.
	 */
	public boolean insert(String itemRoot, int location, Item item);
	
	/**
	 * Delete an ordered item from the specified list
	 * @param itemRoot the set to delete from.
	 * @param location the institution who controls this set.
	 * @param item the item to delete.
	 */
	public boolean delete(String itemRoot, int location, Item item);
	
	/**
	 * Update an item in an ordered list.
	 * @param itemRoot the set or list in which the update occurs
	 * @param location the institution who controls this set
	 * @param item the item updated.
	 */
	public boolean update(String itemRoot, int location, Item item);
	

}
