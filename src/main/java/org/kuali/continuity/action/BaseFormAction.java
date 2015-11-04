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
package org.kuali.continuity.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.util.AdminListHelper;
import org.kuali.continuity.action.util.DTO2DomainObjectConverter;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.action.util.ReferenceListHelper;
import org.kuali.continuity.service.BaseService;

@SuppressWarnings("serial")
public abstract class BaseFormAction extends BaseActionSupport {
	
	// service
	private BaseService service;
	
	// beans
	private DomainObjectDTO dto;
	private List<? extends DomainObjectDTO> dtos;
	
	// bean id
	private int rowId;

	// types of save, for multiple saves.
	// default to zero to execute all saves.
	private int saveActionType = 0;
	
	// actions
	private AddAction addAction;
	private UpdateAction updateAction;
	private DeleteAction deleteAction;
	private ReadListAction readListAction;
	private ReadRowAction readRowAction;
	private ValidateAction validateAction;
	
	// save actions (for multiple saves)
	private Map<Integer, SaveAction> saveActions = new HashMap<Integer, SaveAction>();
	
	// admin and reference list map
	private Map<String, List<DomainObjectDTO>> adminListMap = new HashMap<String, List<DomainObjectDTO>>();
	private Map<String, List<RefDTO>> refListMap = new HashMap<String, List<RefDTO>>();
	
	// admin and reference helpers
	private AdminListHelper adminListHelper;
	private ReferenceListHelper refListHelper;
	
	// converters
	private DomainObject2DTOConverter do2dtoConverter;
	private DTO2DomainObjectConverter dto2doConverter;
	
	// TODO: refactor
	private boolean redir;
	
	public BaseFormAction() {
		super();
	}
	
	public BaseService getService() {
		return this.service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}

	public DomainObjectDTO getDto() {
		return this.dto;
	}

	public void setDto(DomainObjectDTO dto) {
		this.dto = dto;
	}

	public List<? extends DomainObjectDTO> getDtos() {
		return this.dtos;
	}

	public void setDtos(List<? extends DomainObjectDTO> dtos) {
		this.dtos = dtos;
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public int getSaveActionType() {
		return this.saveActionType;
	}

	public void setSaveActionType(int saveActionType) {
		this.saveActionType = saveActionType;
	}

	public boolean isRedir() {
		return this.redir;
	}

	public void setRedir(boolean redir) {
		this.redir = redir;
	}

	// used for multiple saves
	public String save() throws Exception {
		if (this.getSaveActions() == null || this.getSaveActions().isEmpty()) return SUCCESS;
		SaveAction saveAction = this.saveActions.get(this.getSaveActionType());
		if (saveAction != null) {
			// single save action
			String retValue = this.doSave(saveAction);
			if (!retValue.equals(SUCCESS)) return retValue;
		} else {
			// default save (all)
			Collection<SaveAction> actions = this.saveActions.values();
			for (SaveAction action : actions) {
				String retValue = this.doSave(action);
				if (!retValue.equals(SUCCESS)) return retValue;
			}
		}
		return this.getSaveTypeEnum().getActionReturnValue();
	}

	public String add() throws Exception {
		String retValue = this.doSave(this.getAddAction());
		if (!retValue.equals(SUCCESS)) return retValue;
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String update() throws Exception {
		String retValue = this.doSave(this.getUpdateAction());
		if (!retValue.equals(SUCCESS)) return retValue;
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	private String doSave(SaveAction saveAction) throws Exception {
		
		// return if null
		if (saveAction == null) return SUCCESS;

		if (saveAction instanceof BaseSaveAction)  {
			// base save action
			BaseSaveAction action = (BaseSaveAction) saveAction;
		
			// set service if null
			this.setServiceAction(action);
			
			// set validation if null
			if (action.getValidateAction() == null)
				action.setValidateAction(this.getValidateAction());
			
			// set converter if null
			if (action.getDto2doConverter() == null)
				action.setDto2doConverter(this.dto2doConverter);
			
			// save
			String retVal = action.save(this.dto);
			
			// return
			if (retVal.equals(SUCCESS)) return SUCCESS;
			this.checkSaveSuccess(action);
			return retVal;
		}
		
		// simple save
		return saveAction.execute();
		
	}
	
	private void checkSaveSuccess(BaseSaveAction action) {
		// no validation
		if (!(action instanceof BaseSaveAction)) return;
		
		// cast to base save action and get validator
		BaseSaveAction saveAction = (BaseSaveAction) action;
		ValidateAction validAction = saveAction.getValidateAction();
		
		// no validation
		if (validAction == null) return;
		
		// check errors
		if ((validAction.getActionErrors() == null || validAction.getActionErrors().isEmpty()) && 
			(validAction.getFieldErrors() == null  || validAction.getFieldErrors().isEmpty()))
			return;
		
		// with errors
		if (!validAction.getActionErrors().isEmpty())
			this.setActionErrors(validAction.getActionErrors());
		if (!validAction.getFieldErrors().isEmpty())
			this.setFieldErrors(validAction.getFieldErrors());
	}
	
	public String delete() throws Exception {
		DeleteAction action = this.getDeleteAction();
		if (action == null) return SUCCESS; 
		this.setServiceAction(action);
		if (action instanceof BaseDeleteAction)
			((BaseDeleteAction)action).setRowId(this.rowId);
		return action.execute();
	}
	
	public String list() throws Exception {
		ReadListAction action = this.getReadListAction();
		if (action == null) return SUCCESS;
		this.setServiceAction(action);
		if (action instanceof BaseReadListAction) {
			BaseReadListAction readListAction = (BaseReadListAction) action;
			readListAction.setOwnerId(this.getOwnerId());
			if (readListAction.getDo2dtoConverter() == null)
				readListAction.setDo2dtoConverter(this.do2dtoConverter);
			String retVal = readListAction.execute();
			if (retVal.equals(SUCCESS))
				this.dtos = readListAction.getDtos();
			return retVal;
		}
		return action.execute();
	}
	
	public String get() throws Exception {
		ReadRowAction action = this.getReadRowAction();
		if (action == null) return SUCCESS; 
		this.setServiceAction(action);
		if (action instanceof BaseReadRowAction) {
			BaseReadRowAction readRowAction = (BaseReadRowAction) action; 
			readRowAction.setRowId(this.rowId);
			if (readRowAction.getDo2dtoConverter() == null)
				readRowAction.setDo2dtoConverter(this.do2dtoConverter);
			String retVal = readRowAction.execute();
			if (retVal.equals(SUCCESS))
				this.dto = readRowAction.getDto();
		}
		return action.execute();
	}
	
	public AddAction getAddAction() {
		return this.addAction;
	}

	public void setAddAction(AddAction addAction) {
		this.addAction = addAction;
	}

	public UpdateAction getUpdateAction() {
		return this.updateAction;
	}

	public void setUpdateAction(UpdateAction updateAction) {
		this.updateAction = updateAction;
	}

	public DeleteAction getDeleteAction() {
		return this.deleteAction;
	}

	public void setDeleteAction(DeleteAction deleteAction) {
		this.deleteAction = deleteAction;
	}

	public ReadListAction getReadListAction() {
		return this.readListAction;
	}

	public void setReadListAction(ReadListAction readListAction) {
		this.readListAction = readListAction;
	}

	public ReadRowAction getReadRowAction() {
		return this.readRowAction;
	}

	public void setReadRowAction(ReadRowAction readRowAction) {
		this.readRowAction = readRowAction;
	}

	public ValidateAction getValidateAction() {
		return this.validateAction;
	}

	public void setValidateAction(ValidateAction validateAction) {
		this.validateAction = validateAction;
	}

	public Map<Integer, SaveAction> getSaveActions() {
		return this.saveActions;
	}

	public void setSaveActions(Map<Integer, SaveAction> saveActions) {
		this.saveActions = saveActions;
	}

	public Map<String, List<DomainObjectDTO>> getAdminListMap() {
		return this.adminListMap;
	}

	public void setAdminListMap(Map<String, List<DomainObjectDTO>> adminListMap) {
		this.adminListMap = adminListMap;
	}

	public Map<String, List<RefDTO>> getRefListMap() {
		return this.refListMap;
	}

	public void setRefListMap(Map<String, List<RefDTO>> refListMap) {
		this.refListMap = refListMap;
	}
	
	public AdminListHelper getAdminListHelper() {
		return this.adminListHelper;
	}

	public void setAdminListHelper(AdminListHelper adminListHelper) {
		this.adminListHelper = adminListHelper;
	}

	public ReferenceListHelper getRefListHelper() {
		return this.refListHelper;
	}

	public void setRefListHelper(ReferenceListHelper refListHelper) {
		this.refListHelper = refListHelper;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public DTO2DomainObjectConverter getDto2doConverter() {
		return this.dto2doConverter;
	}

	public void setDto2doConverter(DTO2DomainObjectConverter dto2doConverter) {
		this.dto2doConverter = dto2doConverter;
	}

	public void prepare() throws Exception {
		if (!(this.getSaveType() == 0 || this.getSaveTypeEnum() == SaveTypeEnum.SAVE))
			return;

		// load reference lists
		if (this.refListHelper != null)  {
			this.setRefListMap(this.refListHelper.getReferenceListMap());
		}
		
		// load admin lists
		if (this.adminListHelper != null) {
			int systemDomainId = 0;
			if (this.getSessionSystemDomain() != null) 
				systemDomainId = this.getSessionSystemDomain().id;
			else if (this.getSessionValue(SessionKey.loginSystemDomain) != null)
				systemDomainId = ((SessionSystemDomainDTO)this.getSessionValue(SessionKey.loginSystemDomain)).id;
			this.adminListHelper.setSystemDomainId(systemDomainId);
			this.setAdminListMap(this.adminListHelper.getAdminListMap());
		}
	}
	
	protected void setServiceAction(Object action) {
		if (!(action instanceof ServiceAction)) return;
		ServiceAction serviceAction = (ServiceAction) action;
		if (serviceAction.getService() == null)
			serviceAction.setService(this.getService());
	}
	
	protected abstract int getOwnerId();
	
}
