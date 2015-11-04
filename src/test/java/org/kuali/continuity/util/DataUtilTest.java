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

import static org.junit.Assert.*;

import org.junit.Test;

public class DataUtilTest {

	@Test
	public void testSafeTrimmingString() {
		String leadingSpace = "   abc";
		assertEquals(DataUtil.safeTrimmingString(leadingSpace), "abc");	
		String trailingSpace = "abc   ";
		assertEquals(DataUtil.safeTrimmingString(trailingSpace), "abc");
		String middleSpace = " a bc   ";
		assertEquals(DataUtil.safeTrimmingString(middleSpace), "a bc");
		String nullString = "";
		assertEquals(DataUtil.safeTrimmingString(nullString), "");
		assertEquals(DataUtil.safeTrimmingString(null), "");	
	}

}
