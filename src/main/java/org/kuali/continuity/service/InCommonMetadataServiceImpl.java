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

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.kuali.continuity.security.SecurityEnum;
import org.kuali.continuity.security.SecurityUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class InCommonMetadataServiceImpl implements InCommonMetadataService{
	
	private boolean found = false;

	private String filePath;
	
	private String entityId;
	
	private String singleSignOnLocation;
	
    private Cache cache;
    
    private String appUrl;
    
    public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
    
    public String getAppUrl() {
		return appUrl;
	}
    
	public void setCache(Cache cache){
		this.cache = cache;
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	
	public String getSingleSignOnLocation(String entityId){
		this.entityId = entityId;
		
		final Element cachedElement = this.cache.get(entityId);
		

		
		if (cachedElement != null) {
            //System.out.println("Found cashe match: " + entityId);
            return (cachedElement.getValue().toString());
        }

		// Use an instance of ourselves as the SAX event handler
        DefaultHandler saxHandler = new SaxHandler();

        // Use the default (non-validating) parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
        try {
            // Parse the input
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(filePath), saxHandler);
        } catch (Throwable t) {
            //t.printStackTrace();
        }
             
        if(singleSignOnLocation != null && !"".equals(singleSignOnLocation)){
        	 this.cache.put(new Element(entityId, singleSignOnLocation));
        }  
        
        return singleSignOnLocation;
        		
	}
	
	public String getLoginUrl(String entityId, String customUrl){
		StringBuilder builder = new StringBuilder();
		builder.append(getSingleSignOnLocation(entityId))
		.append("?")
		.append("shire=")
		.append(appUrl)
		.append("/Shibboleth.sso/SAML/POST&target=")
		.append(appUrl)
		.append("/shibboleth-sp.html" + "?" + SecurityEnum.sdname.toString() + "=" + SecurityUtil.encode(customUrl) + "&providerId=")
		.append(appUrl)
		.append("/shibboleth-sp");
		
		return builder.toString();
	}
	
	public class SaxHandler extends DefaultHandler {
		
	    final static String BINDING_VALUE = "urn:mace:shibboleth:1.0:profiles:AuthnRequest";
	    
		//===========================================================
	    // SAX DocumentHandler methods
	    //===========================================================
	    public void startDocument() throws SAXException {
	    	//Initialize to default value
	    	found = false;
	    	singleSignOnLocation = null;	    	
	    }

	    public void endDocument() throws SAXException {	        
	    }

	    public void startElement(String namespaceURI, String sName, // simple name
	        String qName, // qualified name
	        Attributes attrs) throws SAXException {

	        String eName = sName; // element name

	        if ("".equals(eName)) {
	            eName = qName; // not namespaceAware
	        }	        
	        
	        if(!found){
	        	if(eName.equals(InCommonMetadataEnum.ENTITY_DESCRIPTOR.toString())){
		        	if(attributeValueEquals(attrs, InCommonMetadataEnum.ENTITY_ID, entityId)){
		        		found = true;
		        	}
		        } 
	        } else{
	        	if(eName.equals(InCommonMetadataEnum.SINGLE_SIGNON_SERVICE.toString()) &&
	        	   BINDING_VALUE.equals(attributeValue(attrs, InCommonMetadataEnum.BINDING))){
	        		singleSignOnLocation = attributeValue(attrs, InCommonMetadataEnum.LOCATION);
	        		throw new SAXException("Single sign-on location has been found: " + singleSignOnLocation);
	        	}
	        }
	        	        	             
	    }

	    public void endElement(String namespaceURI, String sName, // simple name
	        String qName // qualified name
	    ) throws SAXException {
	    }
	    
	    
	    private boolean attributeValueEquals(Attributes attrs, InCommonMetadataEnum metaEnum, String value){
	    	if (attrs != null) {
	            for (int i = 0; i < attrs.getLength(); i++) {
	            	
	                String aName = attrs.getLocalName(i); // Attr name 

	                if ("".equals(aName)) {
	                    aName = attrs.getQName(i);
	                }	                
	                
	                if(aName.equals(metaEnum.toString())){
	                	if(attrs.getValue(i).equals(value)){                			                		
	                		return true;
	                	} else{
	                		return false;
	                	}
	                }
	            }
	            return false;
	        }
	    	return false;
	    }
	    
	    private String attributeValue(Attributes attrs, InCommonMetadataEnum metaEnum){
	    	if (attrs != null) {
	            for (int i = 0; i < attrs.getLength(); i++) {
	                String aName = attrs.getLocalName(i); // Attr name 

	                if ("".equals(aName)) {
	                    aName = attrs.getQName(i);
	                }
	                
	                if(aName.equals(metaEnum.toString())){
	                	return attrs.getValue(i);
	                		
	                }
	            }
	            return null;
	        }
	    	return null;
	    }
        
	}
	
}
