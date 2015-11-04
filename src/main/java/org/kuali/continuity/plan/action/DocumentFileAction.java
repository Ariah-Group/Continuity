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
package org.kuali.continuity.plan.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.SamplePlanDocument;
import org.kuali.continuity.plan.action.dto.BinaryDocumentDTO;
import org.kuali.continuity.plan.domain.SystemDomainSamplePlanDocument;
import org.kuali.continuity.plan.service.BinaryDocumentService;
import org.kuali.continuity.plan.service.BinaryDocumentServiceFactory;

public class DocumentFileAction extends BasePlanAction {
	
	private BinaryDocumentServiceFactory binaryDocumentServiceFactory;
	private int id;
	private String type;
	private String contentType;
	private String contentDisposition;
	private boolean allowCaching;
	private InputStream inputStream;
	private static final Map<String, String> CONTENT_TYPES;
	private static final List<String> NO_CACHE_CONTENT_TYPES;

	// TODO: refactor
	static {
		// content type
		CONTENT_TYPES = new HashMap<String, String>();
		CONTENT_TYPES.put("txt","text/plain");
	    CONTENT_TYPES.put("htm", "text/html");
	    CONTENT_TYPES.put("html", "text/html");
	    CONTENT_TYPES.put("xml", "text/html");
	    CONTENT_TYPES.put("csv", "application/vnd.ms-excel");
	    CONTENT_TYPES.put("xls", "application/vnd.ms-excel");
	    CONTENT_TYPES.put("xlb", "application/vnd.ms-excel");
	    CONTENT_TYPES.put("xlsx", "application/vnd.ms-excel");
	    CONTENT_TYPES.put("xlw", "application/vnd.ms-excel");
	    CONTENT_TYPES.put("doc", "application/msword");
	    CONTENT_TYPES.put("docx", "application/msword");
	    CONTENT_TYPES.put("swf", "application/x-shockwave-flash");
	    CONTENT_TYPES.put("ppt", "application/vnd.ms-powerpoint");
	    CONTENT_TYPES.put("pptx", "application/vnd.ms-powerpoint");
	    CONTENT_TYPES.put("pdf", "application/pdf");
	    CONTENT_TYPES.put("rtf", "application/rtf");
	    CONTENT_TYPES.put("gif", "image/gif");
	    CONTENT_TYPES.put("jpg", "image/jpeg"); 
	    CONTENT_TYPES.put("jpeg", "image/jpeg");
	    CONTENT_TYPES.put("tiff", "image/tiff");
	    CONTENT_TYPES.put("bmp", "image/x-ms-bmp");
	    CONTENT_TYPES.put("png", "image/x-png");
	    CONTENT_TYPES.put("aac", "video/quicktime"); 
	    CONTENT_TYPES.put("adts", "video/quicktime");
	    CONTENT_TYPES.put("mov", "video/quicktime");
	    CONTENT_TYPES.put("mqv", "video/quicktime");
	    CONTENT_TYPES.put("qtl", "video/quicktime");
	    CONTENT_TYPES.put("mpe", "video/x-mpeg2");
	    CONTENT_TYPES.put("mpeg", "video/x-mpeg2"); 
	    CONTENT_TYPES.put("mpg", "video/x-mpeg2");     
	    CONTENT_TYPES.put("mpv2", "video/x-mpeg2");     
	    CONTENT_TYPES.put("mp2v", "video/x-mpeg2");     
	    CONTENT_TYPES.put("mpa", "video/x-mpeg2");
	    CONTENT_TYPES.put("wmv", "video/x-msvideo");
	    CONTENT_TYPES.put("avi", "video/x-msvideo");
	    CONTENT_TYPES.put("asf", "video/x-msvideo");
	    CONTENT_TYPES.put("m1v", "video/x-msvideo");
		
		// no cache
		NO_CACHE_CONTENT_TYPES = new ArrayList<String>();
		NO_CACHE_CONTENT_TYPES.add("application/vnd.ms-excel");
		NO_CACHE_CONTENT_TYPES.add("application/msword");
		NO_CACHE_CONTENT_TYPES.add("application/vnd.ms-powerpoint");
		NO_CACHE_CONTENT_TYPES.add("application/rtf");
	}
	
	
	public DocumentFileAction(BinaryDocumentServiceFactory binaryDocumentServiceFactory) {
		this.binaryDocumentServiceFactory = binaryDocumentServiceFactory;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDisposition() {
		return this.contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public boolean isAllowCaching() {
		return this.allowCaching;
	}

	public void setAllowCaching(boolean allowCaching) {
		this.allowCaching = allowCaching;
	}

	public InputStream getInputStream() {
		return this.inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String execute() throws Exception {
		// get document
		BinaryDocumentDTO.Type testType = BinaryDocumentDTO.Type.valueOf(this.type);
		BinaryDocumentService binaryDocumentService = 
			this.binaryDocumentServiceFactory.getBinaryDocumentService(testType.getBinaryDocumentClass());
		
		// for sample plan
		if (testType.getBinaryDocumentClass().equals(SamplePlanDocument.class)) {
			SessionUserDTO user = this.getSessionUser();
			this.id = user.systemDomain.id;
		}
		
		// get document
		BinaryDocument doc = binaryDocumentService.getDocument(this.id);
		
		// test
		if (doc != null) {
			String fileName = doc.getFileName();
			String fileExt  = "";
			int i = fileName.lastIndexOf('.');
			if (i >= 0) fileExt = fileName.substring(++i);
			this.setAttributes(fileExt, fileName);
			if (doc.getBlobDocument() != null)
				this.setInputStream(doc.getBlobDocument().getBinaryStream());
			else if (doc instanceof SystemDomainSamplePlanDocument && 
				((SystemDomainSamplePlanDocument)doc).getDefaultDocument() != null &&
				((SystemDomainSamplePlanDocument)doc).getDefaultDocument().getBlobDocument() != null)
				this.setInputStream(((SystemDomainSamplePlanDocument)doc).getDefaultDocument().getBlobDocument().getBinaryStream());
			else
				this.setInputStream(new ByteArrayInputStream("".getBytes()));
		}
		
		return SUCCESS;
	}
	
	private void setAttributes(String fileExt, String fileName) {
		// set content type
		String contentType = CONTENT_TYPES.get(fileExt);
		if (contentType == null) contentType = "";
		this.setContentType(contentType);
		
		// set content disposition
		this.setContentDisposition("attachment; filename=\"" + fileName + "\"");
		
		
		// set allow caching
		this.setAllowCaching(!NO_CACHE_CONTENT_TYPES.contains(this.getContentType()));
	}

}
