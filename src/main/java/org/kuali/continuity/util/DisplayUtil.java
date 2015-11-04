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

import java.util.HashMap;

import org.apache.log4j.Logger;
/**
 * Utility to produce external display values for internal fields.
 * @author richardkatz
 *
 */
public class DisplayUtil {
	private static final Logger logger = Logger.getLogger(DisplayUtil.class);

	/**
	 * User Roles
	 * @author richardkatz
	 *
	 */
	public static final HashMap rolemap = new HashMap() {
		{
			// xxxx
			// ROLE VALUE List 3 of 4 .  Next go to SecurityTypeEnum
			put("0","SA");
			put("1", "LA");
			put("2", "UV");
			put("3", "IA");
			put("4", "MO");
			put("9", "LU");
		}

	};

	public static String displayRole(String role) {
		String drole=(String) rolemap.get(role);

		return drole;

	}
	public static String displayAccess(String access) {
//		String daccess="ON";
//		if (access.equals("0")) {
//			daccess="OFF";
//		}
		return access;

	}


}
