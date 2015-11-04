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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;

import org.kuali.continuity.dao.jpa.BaseDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.ServerDAO;
import org.kuali.continuity.plan.domain.Server;

public class ServerDAOImpl extends BaseDomainObjectDAOImpl implements
		ServerDAO {

	public void create(Server dObj) {
		super.create(dObj);
	}
	
	public void update(Server dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Server getById(int id) {
		return (Server) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Server> getListByOwnerId(int ownerId) {
		return (List<Server>) super.getListByOwnerId(ownerId);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return Server.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Server.list";
	}

}
