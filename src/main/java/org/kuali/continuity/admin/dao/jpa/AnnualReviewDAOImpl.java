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
package org.kuali.continuity.admin.dao.jpa;

import java.util.List;

import org.kuali.continuity.admin.dao.AnnualReviewDAO;
import org.kuali.continuity.admin.domain.AnnualReview;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class AnnualReviewDAOImpl extends BaseAdminOrderedDAOImpl implements AnnualReviewDAO {


	public void create(AnnualReview dObj) {
		super.create(dObj);
	}
	
	public void update(AnnualReview dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public AnnualReview getById(int id) {
		return (AnnualReview) super.getById(id);
	}
	
	@Override
	public AnnualReview getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (AnnualReview) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public AnnualReview getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (AnnualReview) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public AnnualReview getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (AnnualReview) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AnnualReview> getListBySystemDomainId(int systemDomainId) {
		return (List<AnnualReview>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AnnualReview> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<AnnualReview>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AnnualReview> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<AnnualReview>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AnnualReview> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<AnnualReview>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AnnualReview> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<AnnualReview>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}
	
	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return AnnualReview.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "AnnualReview.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "AnnualReview.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM AnnualReview dObj WHERE dObj.systemDomainId = :systemDomainId";
	}

}
