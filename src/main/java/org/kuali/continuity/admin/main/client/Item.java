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
package org.kuali.continuity.admin.main.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Item extends NamedOrderedItem  {

	
	public Item () {}
    public Item (int id, String name, int order) {
    	this.id=id;
    	this.name=name;
    	this.order=order;
    }

	public void setOrder(String order) {
		this.order = Integer.parseInt(order);
	}
 	public String getOrder() {
		return ""+order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
}
