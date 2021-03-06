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
package org.kuali.continuity.plan.service;

import java.util.List;

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.ServerDAO;
import org.kuali.continuity.plan.domain.Server;

public class ServerServiceImpl implements ServerService {

	private ServerDAO serverDAO;

	public void create(Server obj) {
		this.serverDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((Server)obj);
	}

	public void update(Server obj) {
		this.serverDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((Server)obj);
	}

	public void delete(int id) {
		this.serverDAO.delete(id);
	}

	public Server getById(int id) {
		return this.serverDAO.getById(id);
	}

	public List<Server> getListByOwnerId(int ownerId) {
		return this.serverDAO.getListByOwnerId(ownerId);
	}

	public ServerDAO getServerDAO() {
		return this.serverDAO;
	}

	public void setServerDAO(ServerDAO serverDAO) {
		this.serverDAO = serverDAO;
	}

}
