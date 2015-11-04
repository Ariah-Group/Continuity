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

import java.io.Serializable;
import java.util.TimeZone;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * Intercepts flushdirty and save events.
 */
public class HibernateInterceptor extends EmptyInterceptor {
	/**
	 *
	 */
	private static final long serialVersionUID = 8315941938607562986L;
	public static final String TIME_ZONE = TimeZone.getDefault().getID();

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currState, Object[] prevState, String[] propNames,
			Type[] types) {

		return super.onFlushDirty(entity, id, currState, prevState, propNames,
				types);
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propNames, Type[] types) {

		return super.onSave(entity, id, state, propNames, types);
	}
}
