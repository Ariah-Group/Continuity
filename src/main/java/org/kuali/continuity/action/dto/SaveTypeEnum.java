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
package org.kuali.continuity.action.dto;

import com.opensymphony.xwork2.Action;

public enum SaveTypeEnum {
	
	SAVE(1, Action.SUCCESS), 
	SAVE_CONTINUE(2, CustomActionExecutionConstants.CONTINUE), 
	CONTINUE(3, CustomActionExecutionConstants.CONTINUE);
	
	private int id;
	private String actionReturnValue;
	
	SaveTypeEnum(final int id, final String actionReturnValue) {
		this.setId(id);
		this.setActionReturnValue(actionReturnValue);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getActionReturnValue() {
		return this.actionReturnValue;
	}

	public void setActionReturnValue(String actionReturnValue) {
		this.actionReturnValue = actionReturnValue;
	}
	
	public boolean isSaveAction() {
		return (this == SAVE || this == SAVE_CONTINUE);
	}

	public static SaveTypeEnum getSaveTypeEnum(int id) {
		if (id == 0) return SAVE;
		for (SaveTypeEnum saveTypeEnum : SaveTypeEnum.values()) {
			if (saveTypeEnum.getId() == id) return saveTypeEnum;
		}
		return null;
	}

}
