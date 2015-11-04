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

@Deprecated
public class DependencyDAOFactoryImpl implements DependencyDAOFactory {
	
	private DependencyDAO adminDAO;
	private DependencyDAO allDAO;
	
	public DependencyDAOFactoryImpl() {
	}
	
	public DependencyDAO getAdminDAO() {
		return this.adminDAO;
	}

	public void setAdminDAO(DependencyDAO adminDAO) {
		this.adminDAO = adminDAO;
	}


	public DependencyDAO getAllDAO() {
		return this.allDAO;
	}


	public void setAllDAO(DependencyDAO allDAO) {
		this.allDAO = allDAO;
	}


	public DependencyDAO getDependencyDAO(boolean isAdmin) {
		return (isAdmin ? adminDAO : allDAO);
	}

}
