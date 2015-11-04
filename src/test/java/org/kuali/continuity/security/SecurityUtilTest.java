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
package org.kuali.continuity.security;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kuali.continuity.security.SecurityUtil;;

public class SecurityUtilTest {
	@Test
	public void testUriSyntaxCheck() {
		String regular = "abc";		
		assertTrue(SecurityUtil.uriSyntaxCheck(regular));
		
		String regular1 = "ab.c";		
		assertFalse(SecurityUtil.uriSyntaxCheck(regular1));
		
		String regular2 = "ucsf-test";		
		assertTrue(SecurityUtil.uriSyntaxCheck(regular2));				
		
		String wrong = "/";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong));
		
		String wrong1 = "a/a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong1));
		
		String wrong2 = "a@a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong2));
		
		String wrong3 = "a'a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong3));
		
		String wrong4 = "a'''a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong4));
		
		String wrong5 = "a]]a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong5));
		
		String wrong6 = "a,a";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong6));
		
		String wrong7 = "!aa";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong7));
		
		String wrong8 = "";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong8));
		
		String wrong9 = "a/";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong9));
		
		String wrong10 = "<>";		
		assertFalse(SecurityUtil.uriSyntaxCheck(wrong10));
		
	}
}
