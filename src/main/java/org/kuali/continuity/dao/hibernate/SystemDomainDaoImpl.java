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

import org.apache.log4j.Logger;
import org.kuali.continuity.dao.SystemDomainDao;
import org.kuali.continuity.domain.SystemDomain;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@Deprecated
public class SystemDomainDaoImpl extends HibernateDaoSupport implements SystemDomainDao {
	@SuppressWarnings("unused")
	private static final Logger log = Logger
	.getLogger(SystemDomainDaoImpl.class);
	
	public void create(SystemDomain systemDomain) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int instutionId) {
		// TODO Auto-generated method stub
		
	}

	public SystemDomain get(int institutionId) {
		SystemDomain sd = null;
        try {
        	sd = (SystemDomain) getHibernateTemplate().get(SystemDomain.class, institutionId);
        } catch (Exception e) {
        	logger.error(e);
        	System.out.println("Exception: "+e);
        }
		return sd;
	}

	public List<SystemDomain> list() 
	
	throws DataAccessException {
		final int maintype=0;
    return getHibernateTemplate().findByNamedParam(
		"from SystemDomain sd where sd.type  = :type", "type",
	    		maintype);
	}

	public List<SystemDomain> selectByType(int maintype, int activetype) 	throws DataAccessException {
	    return getHibernateTemplate().findByNamedParam(
	    		"from SystemDomain sd where sd.type  = :type", "type",
	    		maintype);
	}

	public void update(SystemDomain systemDomain) {
		// TODO Auto-generated method stub
		
	}

}
