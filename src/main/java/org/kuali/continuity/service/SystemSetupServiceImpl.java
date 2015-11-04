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

import org.kuali.continuity.dao.SystemSetupDAO;
import org.kuali.continuity.domain.SystemSetup;
import org.kuali.continuity.domain.SystemSetupSamplePlanDocument;

public class SystemSetupServiceImpl implements SystemSetupService {
	
	private SystemSetupDAO systemSetupDAO;

	@Override
	public SystemSetupSamplePlanDocument getDefaultSamplePlanDocument() {
		return this.systemSetupDAO.getDefaultSamplePlanDocument();
	}

	@Override
	public SystemSetup getSystemSetup() {
		return this.systemSetupDAO.getSystemSetup();
	}

	public SystemSetupDAO getSystemSetupDAO() {
		return this.systemSetupDAO;
	}

	public void setSystemSetupDAO(SystemSetupDAO systemSetupDAO) {
		this.systemSetupDAO = systemSetupDAO;
	}

}
