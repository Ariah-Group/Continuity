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
package org.kuali.continuity.plan.action.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.plan.action.WorkstationBackupMethodDTO;
import org.kuali.continuity.plan.action.WorkstationTechSupportDTO;
import org.kuali.continuity.plan.domain.WorkstationBackupMethod;
import org.kuali.continuity.plan.domain.WorkstationProcedure;
import org.kuali.continuity.plan.domain.WorkstationTechSupport;

public class WorkstationProcedureDTO {
	
	public Map<String, WorkstationBackupMethodDTO> backupMethods = new HashMap<String, WorkstationBackupMethodDTO>();
	public Map<String, WorkstationTechSupportDTO>  techSupports  = new HashMap<String, WorkstationTechSupportDTO>();

	public WorkstationProcedureDTO() {
		
	}
	
	public WorkstationProcedureDTO(WorkstationProcedure workstationProcedure) {
		if (workstationProcedure == null) return;
		
		// backup method
		Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> wbms = workstationProcedure.getBackupMethods();
		Set<WorkstationBackupMethod.Type> wbmKeys = wbms.keySet();
		for (WorkstationBackupMethod.Type wbmType : wbmKeys) {
			WorkstationBackupMethodDTO bm = new WorkstationBackupMethodDTO();
			WorkstationBackupMethod wbm = wbms.get(wbmType);
			bm.percentUsers = wbm.getPercentUsers();
			bm.comment = wbm.getComment();
			this.backupMethods.put(wbmType.name(), bm);
		}
		
		// tech support
		Map<WorkstationTechSupport.Type, WorkstationTechSupport>  wtss = workstationProcedure.getTechSupports();
		Set<WorkstationTechSupport.Type> wtsKeys = wtss.keySet();
		for (WorkstationTechSupport.Type wtsType : wtsKeys) {
			WorkstationTechSupportDTO ts = new WorkstationTechSupportDTO();
			WorkstationTechSupport wts  = wtss.get(wtsType);
			ts.isSupported = wts.isSupported();
			ts.comment = wts.getComment();
			this.techSupports.put(wtsType.name(), ts);
		}
	}
	
	public WorkstationProcedure getWorkstationProcedure() {
		// init
		WorkstationProcedure wp = new WorkstationProcedure();
		
		// backup method
		Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> wbms = 
			new HashMap<WorkstationBackupMethod.Type, WorkstationBackupMethod>();
		
		if (this.backupMethods != null && !this.backupMethods.isEmpty()) {
			Set<String> wbmKeys = this.backupMethods.keySet();
			for (String wbmType : wbmKeys) {
				WorkstationBackupMethodDTO bm = this.backupMethods.get(wbmType);
				if (bm != null) {
					WorkstationBackupMethod wbm = new WorkstationBackupMethod(bm.percentUsers, bm.comment);
					wbms.put(WorkstationBackupMethod.Type.valueOf(wbmType), wbm);
				}
			}
		}
		
		// tech support
		Map<WorkstationTechSupport.Type, WorkstationTechSupport> wtss = 
			new HashMap<WorkstationTechSupport.Type, WorkstationTechSupport>();
		
		if (this.techSupports != null && !this.techSupports.isEmpty()) {
			Set<String> wtsKeys = this.techSupports.keySet();
			for (String wtsType : wtsKeys) {
				WorkstationTechSupportDTO ts = this.techSupports.get(wtsType);
				if (ts != null) {
					WorkstationTechSupport wts = new WorkstationTechSupport(ts.isSupported, ts.comment);
					wtss.put(WorkstationTechSupport.Type.valueOf(wtsType), wts);
				}
			}
		}
		
		// set
		wp.setBackupMethods(wbms);
		wp.setTechSupports(wtss);

		// return
		return wp;
	}
}
