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
package org.kuali.continuity.admin.dao.ldap;

import java.io.IOException;

import javax.naming.ldap.Control;

import org.springframework.ldap.control.CreateControlFailedException;
import org.springframework.ldap.control.SortControlDirContextProcessor;

import com.sun.jndi.ldap.ctl.SortControl;

// no spring support for multi key sort yet
public class MultiKeySortControlDirContextProcessor extends
		SortControlDirContextProcessor {
	
	private String[] sortKeys;

	public MultiKeySortControlDirContextProcessor(String sortKey) {
		super(sortKey);
	}

	public MultiKeySortControlDirContextProcessor(String[] sortKeys) {
		super(null);
		this.setSortKeys(sortKeys);
	}

	public String[] getSortKeys() {
		return this.sortKeys;
	}

	public void setSortKeys(String[] sortKeys) {
		this.sortKeys = sortKeys;
	}
	
    public Control createRequestControl() {
        try {
            return new SortControl(this.getSortKeys(), true);
        } catch (IOException e) {
            throw new CreateControlFailedException(
                    "Error creating SortControl", e);
        }
    }
}
