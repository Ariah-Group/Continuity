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

import org.kuali.continuity.dao.ReferenceDomainObjectDAO;
import org.kuali.continuity.domain.BaseRefDomainObject;

public class ReferenceDomainObjectDAOImpl<T extends BaseRefDomainObject> extends BaseDAOImpl implements
		ReferenceDomainObjectDAO<T> {

	private Class<T> refType;
	
	public ReferenceDomainObjectDAOImpl(Class<T> refType) {
		this.refType = refType;
	}
	
	public List<T> getReferenceDomainObjects() {
		String queryName = this.refType.getSimpleName();
		return (List<T>) this.getResultList(queryName);
	}
	
	@SuppressWarnings("unchecked")
	private List<T> getResultList(String queryName) {
		Query query = this.getEntityManager().createNamedQuery(queryName + ".list");
		return (List<T>) query.getResultList();
	}

}
