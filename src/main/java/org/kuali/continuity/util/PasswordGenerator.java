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

import java.util.Date;
import java.util.Random;

/* From LOR */
public class PasswordGenerator {
	
	static Random random = null;
	
	//
	// Generates a password 8-17 characters long, and with a combination 
	// of letters and numbers, with no spaces or special characters.
	//
	public static String generate(String seedString) 
	{
		String password;
		String validLetters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
		String validNumbers = "23456789";
		String validChars = validLetters + validNumbers;
		initialize(seedString);

		int length = 7; // + random.nextInt(8);
		StringBuffer buffer = new StringBuffer();

		// At least one letter
		buffer.append(validChars.charAt(random.nextInt(validLetters.length())));
		
		// Any letter or number
		for (int i = 1; i < length; i++) {
			buffer.append(validChars.charAt(random.nextInt(validChars.length())));
		}
		
		// At least one number
		buffer.append(validChars.charAt(validLetters.length() + 
										random.nextInt(validNumbers.length())));

		password = buffer.toString();

		return password;
	}


	//
	// Set the seed for the random number generator the first time used.
	//
	private static void initialize(String seedString)
	{
		if (random == null) {
			Date date = new Date();
			long hashCode = (seedString == null) ? date.hashCode() : seedString.hashCode();
			long seed = date.getTime() * hashCode;
			random = new Random(seed);
		}
	}
}
