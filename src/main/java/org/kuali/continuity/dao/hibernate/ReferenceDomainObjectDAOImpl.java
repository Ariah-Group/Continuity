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
package org.kuali.continuity.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.kuali.continuity.dao.ReferenceDomainObjectDAO;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ReferenceDomainObjectDAOImpl<T extends BaseRefDomainObject> extends HibernateDaoSupport implements
		ReferenceDomainObjectDAO<T> {

	private Class<T> refType;
	
	public ReferenceDomainObjectDAOImpl(Class<T> refType) {
		this.refType = refType;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getReferenceDomainObjects() {
		String queryName = this.refType.getSimpleName();
		Query query = this.getSession().getNamedQuery(queryName + ".list");
		query.setCacheable(true);
		return query.list();
	}

}
