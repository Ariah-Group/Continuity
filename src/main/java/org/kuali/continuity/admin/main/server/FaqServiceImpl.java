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
package org.kuali.continuity.admin.main.server;

import java.util.List;

import org.apache.log4j.Logger;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.main.client.FaqService;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.ItemService;
import org.kuali.continuity.service.ListService;
import org.kuali.continuity.service.OrderingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class FaqServiceImpl extends RemoteServiceServlet implements FaqService,  ListService {
	private final Logger logger = Logger.getLogger(FaqServiceImpl.class);

	private ItemDaoFactory itemDaoFactory;
	
	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}
	private OrderingService orderingService;
	private BaseAdminOrderedDAO getDao(String itemRootName) {
		return itemDaoFactory.getDao(itemRootName);
	}

	public void deleteItem(String itemSet, Item item) {
		// TODO Auto-generated method stub
		
	}

	public Item getItem(String itemSet, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getList(String itemSet, String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}



	public List getSortedList(String itemSet, int start, String sortBy,
			int limit, String dir, String institutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertItem(String itemSet, Item item) {
		// TODO Auto-generated method stub
		
	}

	public void updateItem(String itemSet, Item item) {
		// TODO Auto-generated method stub
		
	}

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId) {
		// TODO Auto-generated method stub
		return null;
	}
}
