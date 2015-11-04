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
package org.kuali.continuity.dao;

import java.util.List;

import org.kuali.continuity.domain.SystemDomain;

@Deprecated
public interface SystemDomainDao {
	public void create(SystemDomain systemDomain);
	public void update(SystemDomain systemDomain);
	public void delete(int instutionId);
	public SystemDomain get(int institutionId);
	public List<SystemDomain> list();
	public List<SystemDomain> selectByType(int maintype, int activetype);
}