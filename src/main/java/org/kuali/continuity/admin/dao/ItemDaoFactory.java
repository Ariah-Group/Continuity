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
package org.kuali.continuity.admin.dao;

import java.util.Map;

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.main.client.NamedItem;

/**
 * Service Interface for Abstract Factory for DAOs and related family items.
 * @author richkatz
 *
 */
public interface ItemDaoFactory {

	public  BaseAdminOrderedDAO getDao(String itemRootName);
	public  SimpleAdminDao getAdminDao(String itemRootName);
	public  BaseAdminOrderedDomainObject getItem(String itemRootName);
   
	public  void dispMap();
	public Map getItemMap();
	NamedItem getNamedItem(String rootName); 
	BaseAdminDomainObject getDomainItem(String domainName);
    	
}
