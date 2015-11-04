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
package org.kuali.continuity.admin.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.UITextDTO;
import org.kuali.continuity.admin.service.SystemDomainUITextService;
import org.kuali.continuity.domain.UITextEnum;

@SuppressWarnings("serial")
public class SystemDomainUITextAction extends BaseActionSupport {

	private SystemDomainUITextService systemDomainUITextService;
	private Map<String, String> textMap;
	@SuppressWarnings("unchecked")
	private Class<? extends Enum> textEnumClass;
	private String textKey;
	
	public SystemDomainUITextAction(
		SystemDomainUITextService systemDomainUITextService) {
			this.systemDomainUITextService = systemDomainUITextService;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() {
		// get text map
		this.textMap = new HashMap<String, String>();
		Map<UITextEnum, String> textEnumMap = 
			this.systemDomainUITextService.getByOwnerId(this.getSessionSystemDomain().id);
		if (textEnumMap == null) return SUCCESS;
		Set<UITextEnum> textEnumKeys = textEnumMap.keySet();
		for (UITextEnum textEnum : textEnumKeys) {
			this.textMap.put(((Enum)textEnum).name(), textEnumMap.get(textEnum));
		}

		// put in session
		UITextDTO uiTextDTO = new UITextDTO();
		if (textEnumMap != null) uiTextDTO = new UITextDTO(textEnumMap);
		this.putInSession(SessionKey.uiText, uiTextDTO);

		// return
		return SUCCESS;
	}
	
	public String installText() {
		String text = this.textMap.get(this.textKey);
		if (text == null || text.trim().length() == 0) return this.restoreText();
		int systemDomainId = this.getSessionSystemDomain().id;
		UITextEnum uiTextEnum = this.getUITextEnum(this.textEnumClass, this.textKey);
		this.systemDomainUITextService.update(systemDomainId, uiTextEnum, text);
		return SUCCESS;
	}
	
	public String restoreText() {
		int systemDomainId = this.getSessionSystemDomain().id;
		UITextEnum uiTextEnum = this.getUITextEnum(this.textEnumClass, this.textKey);
		this.systemDomainUITextService.delete(systemDomainId, uiTextEnum);
		return SUCCESS;
	}

	public Map<String, String> getTextMap() {
		return this.textMap;
	}

	public void setTextMap(Map<String, String> textMap) {
		this.textMap = textMap;
	}

	@SuppressWarnings("unchecked")
	public Class<? extends Enum> getTextEnumClass() {
		return this.textEnumClass;
	}

	@SuppressWarnings("unchecked")
	public void setTextEnumClass(Class<? extends Enum> textEnumClass) {
		this.textEnumClass = textEnumClass;
	}

	public String getTextKey() {
		return this.textKey;
	}

	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}

	@Override
	public void prepare() throws Exception {
	}

	@SuppressWarnings("unchecked")
	private UITextEnum getUITextEnum(Class<? extends Enum> uiTextEnumClass, String name) {
		try {
			// check instruction enums
			UITextEnum uiTextEnum = (UITextEnum) Enum.valueOf(uiTextEnumClass, name);
			return uiTextEnum;
		} catch (IllegalArgumentException e) {
			// ignore;
			return null;
		}
	}

}
