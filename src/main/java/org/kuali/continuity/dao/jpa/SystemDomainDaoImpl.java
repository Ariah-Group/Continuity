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
package org.kuali.continuity.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.dao.SystemDomainDao;
import org.kuali.continuity.domain.SystemDomain;

@Deprecated
public class SystemDomainDaoImpl extends BaseDAOImpl implements SystemDomainDao {
	
	public void create(SystemDomain systemDomain) {
		// TODO Auto-generated method stub
	}

	public void update(SystemDomain systemDomain) {
		// TODO Auto-generated method stub	
	}

	public void delete(int instutionId) {
		// TODO Auto-generated method stub
	}

	public SystemDomain get(int institutionId) {
		return (SystemDomain) this.getEntityManager().find(SystemDomain.class, institutionId);
	}

	public List<SystemDomain> list() {
		final int maintype=0;
		return this.selectByType(maintype, 0);
	}
	
	@SuppressWarnings("unchecked")
	public List<SystemDomain> selectByType(int maintype, int activetype) {
		// TODO: activetype?
		Query query = this.getEntityManager().createQuery("SELECT OBJECT(sd) FROM SystemDomain sd WHERE sd.type = :type");
		query.setParameter("type", maintype);
		return (List<SystemDomain>) query.getResultList();
	}
}