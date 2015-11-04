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
package org.kuali.continuity.dao.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.domain.UIText;
import org.kuali.continuity.domain.UITextEnum;

public class UITextUtil {
	
	private static UITextUtil instance = new UITextUtil();
	
	private UITextUtil() {
		
	}

	public static UITextUtil getInstance() {
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public Map<UITextEnum, String> getUITexts(Class<? extends Enum> uiTextEnumClass, List<? extends UIText> uiTextList) {
		Map<UITextEnum, String> uiTextMap = new HashMap<UITextEnum, String>();
		for (UIText uiText : uiTextList) {
			String name = uiText.getName();
			String text = uiText.getText();
			UITextEnum uiTextEnum = this.getUITextEnum(uiTextEnumClass, name);
			if (uiTextEnum == null) continue;
			uiTextMap.put(uiTextEnum, text);
		}
		return uiTextMap;
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
