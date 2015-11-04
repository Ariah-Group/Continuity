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
package org.kuali.continuity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="SystemCriticalLevelFunc")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@SuppressWarnings("serial")
public class SystemCriticalFunctionCriticalityLevel extends
		SystemCriticalityLevel implements CriticalFunctionCriticalityLevel {

	@Id
	@Column(name="LevelID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Override
	public Integer getId() {
		return super.getId();
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Column(name="LevelNo")
	@Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.domain.CriticalityLevelEnum"
			)})
	@Override
	public CriticalityLevelEnum getCriticalityLevelEnum() {
		return super.getCriticalityLevelEnum();
	}

	@Column(name="Descr")
	@Override
	public String getDescription() {
		return super.getDescription();
	}

	@Column(name="LongDescr")
	@Override
	public String getLongDescription() {
		return super.getLongDescription();
	}

}
