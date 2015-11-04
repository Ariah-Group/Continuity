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
package org.kuali.continuity.admin.service;

import org.kuali.continuity.admin.dao.AdminTestModeDAO;
import org.kuali.continuity.domain.UserAccessValue;

public class AdminTestModeServiceImpl implements AdminTestModeService {
	
	private AdminTestModeDAO adminTestModeDAO;
	private boolean isCampuswideEnabled;

	@Override
	public void setInTestMode(boolean isInTestMode, Integer userId) {
		this.adminTestModeDAO.setInTestMode(isInTestMode, userId);
	}

	@Override
	// AOP
	public void setInTestMode(UserAccessValue userAccessValue) {
		if (userAccessValue == null) return;
		if (!this.isCampuswideEnabled())
			userAccessValue.setInTestMode(true);
		else
			userAccessValue.setInTestMode(this.isInTestMode(userAccessValue.getUserId()));
	}

	@Override
	public boolean isInTestMode(Integer userId) {
		return this.adminTestModeDAO.isInTestMode(userId);
	}

	public AdminTestModeDAO getAdminTestModeDAO() {
		return this.adminTestModeDAO;
	}

	public void setAdminTestModeDAO(AdminTestModeDAO adminTestModeDAO) {
		this.adminTestModeDAO = adminTestModeDAO;
	}

	public boolean isCampuswideEnabled() {
		return this.isCampuswideEnabled;
	}

	public void setCampuswideEnabled(boolean isCampuswideEnabled) {
		this.isCampuswideEnabled = isCampuswideEnabled;
	}

}
