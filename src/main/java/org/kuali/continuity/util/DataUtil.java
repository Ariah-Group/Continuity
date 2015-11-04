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
package org.kuali.continuity.util;

import java.util.StringTokenizer;

import org.kuali.continuity.domain.User;

public class DataUtil {
	public static String nonulls(String instr) {
		String outstr="";
		if(instr!=null) {
			outstr=instr;
		}
		return outstr;
	}
	public static String nonulls(String instr, String defaultto) {
		String outstr=defaultto;
		if(instr!=null && !"".equals(instr)) {
			outstr=instr;
		}
		return outstr;
	}
	
	public static String safeTrimmingString(String input){
		if(input == null || "".equals(input)){
			return "";
		} else{
			return input.replaceAll("^\\s+", "").trim();
		}
	}
	
	
	public static  User getEmptyUser() {
		User u = new User();
	 // u.setAuthId("");
	 u.setInstitutionId(0);
	 u.setSecurityType("");
	 u.setFirstName("");
	 u.setLastName("");
	 u.setWorkPhone("");
	 u.setHomePhone("");
	 u.setCellPhone("");
	 u.setEmailregular("");
	 u.setEmailbackup("");
	 u.setWorkFax("");
	 u.setTitle("");
	 u.setDepartmentName("");
	 u.setDepartmentOrg("");
	 u.setDepartmentOrgHierarchy("");
	 u.setWorkAddress("");
	 u.setHomeAddress("");
	 u.setAccessStatus("");
	 u.setLockStatus("");

	 u.setPassword("");

	 u.setDirectoryId("");
	 return u;
	}
	
	public static String postPaddingSpace(String data, int size, char pad) {
		StringBuilder builder = new StringBuilder(data);
		
		if(size > data.length()){
			for(int i=0; i < (size-data.length()); i++){
				builder.append(pad);
			}
			return builder.toString();
		} else{
			return data;
		}
		
	}
	
	public static String padGenerator(int size, char pad) {
		char[] postPadding = new char[size];
		
		for(int i=0; i  < postPadding.length; i++){
			postPadding[i] = pad;
		}
		
		return new String(postPadding);
		
	}
	
	public static String formatString(String padding, String data, int lineSize, String seperator) {
		StringBuilder builder = new StringBuilder();
		String space = " "; // insert space for StrigTokenizer	
		String temp = "";		
		StringTokenizer tokenizer = new StringTokenizer(data); 
		
		if(data.length() <= lineSize){
			return data;
		}
		
		while (tokenizer.hasMoreTokens()) {
			String nextToken = tokenizer.nextToken();
			if((temp.length() + 1 + nextToken.length()) <= lineSize ){
				temp += space;
				temp += nextToken;
			} else{
				builder.append(temp);
				builder.append(seperator);
				builder.append(padding);
				temp = nextToken;
			}
	     }
		builder.append(temp);
		return builder.toString();
	}
}
