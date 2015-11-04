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

import org.springframework.mail.SimpleMailMessage;

@SuppressWarnings("serial")
public class VelocityMailMessage extends SimpleMailMessage {
	
	private String templateName;
	private String krURL;

	public VelocityMailMessage() {
		super();
	}

	public VelocityMailMessage(SimpleMailMessage original) {
		super(original);
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getKrURL() {
		return this.krURL;
	}

	public void setKrURL(String krURL) {
		this.krURL = krURL;
	}

}
