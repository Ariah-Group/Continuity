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

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.TableCell;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

public abstract class PageElementTest extends BaseHTTPTest {
	
	protected void doTestPageElement(String pageUrl, HTMLTagSettings settings) throws Exception {
		// page url
		System.out.println("Testing Page: " + pageUrl);

		// get web conversation with session
		WebConversation wc = this.getNewWebConversation();
		
		// get request using url
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + pageUrl);
		
		// get response
		WebResponse resp = wc.getResponse(req);
		
		// check
		this.doTestPageElement(resp, settings);
	}
	
	protected void doTestPageElement(String[] weblinkImageTexts, HTMLTagSettings settings) throws Exception {
		// get web conversation
		WebConversation wc = this.getNewWebConversation();
		
		// get current page
		WebResponse resp = wc.getCurrentPage();
		
		// iterate thru web links
		for (String weblinkImageText : weblinkImageTexts) {
			// get web link
			WebLink weblink = resp.getLinkWithImageText(weblinkImageText);
			assertNotNull(weblink);
			
			// get current page
			weblink.click();
			resp = wc.getCurrentPage();
		}
		
		// check
		this.doTestPageElement(resp, settings);
	}
	
	protected void doTestPageInTableElement(String mainNavLink, String tableName, int tableCol, String subNavLink, HTMLTagSettings settings) throws Exception {
		// get web conversation
		WebConversation wc = this.getNewWebConversation();
		
		// get current page
		WebResponse resp = wc.getCurrentPage();
		
		// get main nav web link
		WebLink weblink = resp.getLinkWithImageText(mainNavLink);
		assertNotNull(weblink);
		weblink.click();
		resp = wc.getCurrentPage();

		// get table web link
		WebTable table = resp.getTableWithID(tableName);
		assertNotNull(table);
		assertTrue(table.getRowCount() > 0);
		TableCell cell = table.getTableCell(1, tableCol);
		WebLink[] links = cell.getLinks();
		weblink = links[0];
		weblink.click();
		resp = wc.getCurrentPage();

		// get sub nav web link
		weblink = resp.getLinkWithImageText(subNavLink);
		weblink.click();
		resp = wc.getCurrentPage();
		
		// check
		this.doTestPageElement(resp, settings);
	}
	
	protected void doTestPageElement(WebResponse resp, HTMLTagSettings settings) throws Exception {
		// test tag if it exists
		HTMLElement[] tagElements = resp.getElementsByTagName(settings.getTagName());
		assertNotNull(tagElements);
		
		// test element
		HTMLElement tagElement = tagElements[settings.getTagIndex()];
		assertNotNull(tagElement);
		
		// test value
		String tagElementValue = tagElement.getText();
		assertFalse(tagElementValue.indexOf(settings.getTagValue()) < 0);
		System.out.println("Tag (" + settings.getTagName().toUpperCase() + "): " + tagElementValue);
		System.out.println();
	}
	
}
