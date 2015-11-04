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
package org.kuali.continuity.plan.http;

public class HTMLTagSettings {

	private String tagName;
	private int tagIndex;
	private String tagValue;
	
	public HTMLTagSettings(String tagName, int tagIndex, String tagValue) {
		this.tagName = tagName;
		this.tagIndex = tagIndex;
		this.tagValue = tagValue;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getTagIndex() {
		return this.tagIndex;
	}

	public void setTagIndex(int tagIndex) {
		this.tagIndex = tagIndex;
	}

	public String getTagValue() {
		return this.tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

}
