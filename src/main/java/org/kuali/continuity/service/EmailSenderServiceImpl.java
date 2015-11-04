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

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.domain.UserAccessValue;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class EmailSenderServiceImpl implements EmailSenderService {

	public final static String SYSTEM_NAME = "systemName";
	public final static String KR_URL = "krURL";
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
	private Map<EmailMessageEnum, SimpleMailMessage> mailMessageMap;
	private SystemNameService systemNameService;
	private InCommonMetadataService inCommonMetadataService;	
	private SystemDomainService systemDomainService;
	private boolean isTest;
	private boolean isEnabled;
	private String testEmail;
	private String krURL;
	private String systemName;
    
	@Override
	public void sendEmailMessage(final String[] to, final String from, final String replyTo, final String subject,
			final String body, UserAccessValue userAccessValue) {
		// enabled?
		if (!this.isEnabled()) return;
		
		// return if there's no recipient
		if(to == null || to.length == 0) return;
		
		// simple email message
		SimpleMailMessage message = new SimpleMailMessage();

		// set email params
		message.setFrom(from);
		message.setSubject(subject);
		message.setText(body);				
		if (replyTo != null && replyTo.trim().length() != 0)
			message.setReplyTo(replyTo);
		
		// send email
		for (String toEmail : to) {
			message.setTo(this.getRecipient(userAccessValue, toEmail));
			this.getMailSender().send(message);
			// send only once if it is in test mode
			if (this.isInTestMode(userAccessValue)) break;
		}
	}

	@Override
	public void sendEmailMessage(final int systemDomainId, final String[] to, final EmailMessageEnum emailMessageEnum, UserAccessValue userAccessValue) {
		if (!this.isEnabled()) return;
		Map<String, Object> model = new HashMap<String, Object>();
		for (String toEmail : to) {
			this.sendEmail(systemDomainId, toEmail, emailMessageEnum, model, userAccessValue);
			// send only once if it is in test mode
			if (this.isInTestMode(userAccessValue)) break;
		}
	}

	@Override
	public void sendEmailMessage(final int systemDomainId, final String[] to, final EmailMessageEnum emailMessageEnum, final Map<String, Object> model, UserAccessValue userAccessValue) {
		if (!this.isEnabled()) return;
		Map<String, Object> newModel = model;
		if (newModel == null) newModel = new HashMap<String, Object>();
		for (String toEmail : to) {
			this.sendEmail(systemDomainId, toEmail, emailMessageEnum, newModel, userAccessValue);
			// send only once if it is in test mode
			if (this.isInTestMode(userAccessValue)) break;
		}
	}

	@Override
	public void sendEmailMessage(final int systemDomainId, final String to, final EmailMessageEnum emailMessageEnum, final Map<String, Object> model, UserAccessValue userAccessValue) {
		if (!this.isEnabled()) return;
		this.sendEmail(systemDomainId, to, emailMessageEnum, model, userAccessValue);
	}
	
	private void sendEmail(final int systemDomainId, final String to, final EmailMessageEnum emailMessageEnum, final Map<String, Object> model, final UserAccessValue userAccessValue) {
		final SimpleMailMessage simpleMessage = EmailSenderServiceImpl.this.getSimpleMailMessage(emailMessageEnum);
		if (to == null || to.trim().length() == 0 || simpleMessage == null) return;
		final String systemName = this.getSystemName(systemDomainId);
		SystemDomain systemDomain = this.systemDomainService.getById(systemDomainId);
		if (model != null) {		
			model.put(KR_URL, this.inCommonMetadataService.getAppUrl() + "/" + systemDomain.getCustomUrl());				 						
			model.put(SYSTEM_NAME, systemName);
		}
		final String sdEmail = systemDomain.getEmail();
	    MimeMessagePreparator preparator = new MimeMessagePreparator() {
	    	public void prepare(MimeMessage mimeMessage) throws Exception {
	    		String subject = simpleMessage.getSubject();
	    		String subjectModified = String.format(subject, systemName);
	    		boolean isValidEmail = EmailSenderServiceImpl.this.isValidEmailAddress(sdEmail);
	    		String from = isValidEmail ? sdEmail : simpleMessage.getFrom();
	    		String replyTo = isValidEmail ? sdEmail : 
	    			(simpleMessage.getReplyTo() == null) ? simpleMessage.getFrom() : simpleMessage.getReplyTo();
	    		MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	    		message.setTo(EmailSenderServiceImpl.this.getRecipient(userAccessValue, to));
	    		message.setFrom(from);
	    		message.setSubject(subjectModified);
	    		message.setReplyTo(replyTo);
	    		message.setText(EmailSenderServiceImpl.this.getSimpleMailMessageText(simpleMessage, model), true);
	    	}
	    };
	    this.getMailSender().send(preparator);
	}	
	
	public JavaMailSender getMailSender() {
		return this.mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

    public VelocityEngine getVelocityEngine() {
		return this.velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public Map<EmailMessageEnum, SimpleMailMessage> getMailMessageMap() {
		return this.mailMessageMap;
	}

	public void setMailMessageMap(
			Map<EmailMessageEnum, SimpleMailMessage> mailMessageMap) {
		this.mailMessageMap = mailMessageMap;
	}
	
	private SimpleMailMessage getSimpleMailMessage(EmailMessageEnum emailMessageEnum) {
		return this.getMailMessageMap().get(emailMessageEnum);
	}
	
	private String getSimpleMailMessageText(final SimpleMailMessage message, final Map<String, Object> model) {
		String text = message.getText();
		if (message instanceof VelocityMailMessage) {
			text = VelocityEngineUtils.mergeTemplateIntoString(
				EmailSenderServiceImpl.this.getVelocityEngine(), 
				((VelocityMailMessage)message).getTemplateName(), 
				model);
		}
		return text;
	}
	
	private boolean isInTestMode(UserAccessValue userAccessValue) {
		return (this.isTest() || (userAccessValue != null && userAccessValue.isInTestMode()));
	}
	
	private String getRecipient(UserAccessValue userAccessValue, String toEmail) {
		// if is in admin test mode
		if (userAccessValue != null && userAccessValue.isInTestMode()) {
			String adminEmail = userAccessValue.getEmailRegular();
			if (adminEmail == null || adminEmail.trim().length() == 0)
				adminEmail = this.getTestEmail();
			return adminEmail;
		}
		
		// if global settings is in test mode
		if (this.isTest())
			return this.getTestEmail();
			
		// return to recipient
		return toEmail;
	}
	
	private boolean isValidEmailAddress(String aEmailAddress){
		
	    if (aEmailAddress == null) return false;
	    
	    boolean result = true;
	    try {
	        new InternetAddress(aEmailAddress);
	        if (!hasNameAndDomain(aEmailAddress)) {
	        	result = false;
	        }
	    } catch (AddressException ex) {
	    	result = false;
	    }
	    
	    return result;
	}

	private boolean hasNameAndDomain(String aEmailAddress){
		String[] tokens = aEmailAddress.split("@");
		return 
			tokens.length == 2 &&
			tokens[0] != null && tokens[0].trim().length() != 0 && 
			tokens[1] != null && tokens[1].trim().length() != 0; 
	}

	public boolean isTest() {
		return this.isTest;
	}

	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public String getTestEmail() {
		return this.testEmail;
	}

	public void setTestEmail(String testEmail) {
		this.testEmail = testEmail;
	}

	public String getKrURL() {
		return this.krURL;
	}

	public void setKrURL(String krURL) {
		this.krURL = krURL;
	}

	public boolean isEnabled() {
		return this.isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public SystemNameService getSystemNameService() {
		return this.systemNameService;
	}

	public void setSystemNameService(SystemNameService systemNameService) {
		this.systemNameService = systemNameService;
	}
	
	protected String getSystemName(int id) {
		return this.getSystemNameService().getSystemName(id);
	}
	
	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}
	
	public void setInCommonMetadataService(
			InCommonMetadataService inCommonMetadataService) {
		this.inCommonMetadataService = inCommonMetadataService;
	}
	
}
