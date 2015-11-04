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
package org.kuali.continuity.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.AnnualReview;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.domain.ContactInfo;
import org.kuali.continuity.admin.domain.CriticalFunctionExample;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.domain.FAQ;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.PlannerLogCategory;
import org.kuali.continuity.admin.domain.Reference;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.admin.domain.ToKnowItem;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.admin.main.client.AcronymItem;
import org.kuali.continuity.admin.main.client.BuildingItem;
import org.kuali.continuity.admin.main.client.DependencyItem;
import org.kuali.continuity.admin.main.client.FaqItem;
import org.kuali.continuity.admin.main.client.Item;
import org.kuali.continuity.admin.main.client.LocationItem;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.admin.main.client.SettingItem;
import org.kuali.continuity.admin.main.client.SkillItem;
import org.kuali.continuity.domain.SystemLog;

/**
 * Abstract Factory Service that produces families of DAOs and related items and domain objects.
 * @author richkatz
 *
 */
public class ItemDaoFactoryImpl implements ItemDaoFactory {
	private final Logger logger = Logger.getLogger(ItemDaoFactoryImpl.class);

	/**
	 * Spring injected map of itemRoot to configured DAOs.
	 */
	Map daoMap;

	// Spring injected.

	public void setDaoMap(Map daoMap) {
		this.daoMap = daoMap;
	}

	 /**
     * Map of Item Root name to Domain objects
     * This could be replaced by Spring, however it is worth 
     * having it as typesafe here. 
     */
	HashMap domainObjectMap = new HashMap() {
		{
			put("application", CentralApplication.class);
			put("acronym", Acronym.class);
			put("activitylog", SystemLog.class);
		
			put("building", Building.class);
			put("group", SystemDomainGroup.class);
			put("location", SystemDomain.class);
			put("setting", SystemDomain.class);
			put("review", AnnualReview.class);
			put("contact", ContactInfo.class);
			put("function", CriticalFunctionExample.class);
			put("type", DepartmentType.class);
			put("dependency", Dependency.class);
			put("faq", FAQ.class);
			put("division", MajorDivision.class);
			put("department", InstructionalDepartment.class);
			put("plannerscategory", PlannerLogCategory.class);
			put("plan", Object.class);   // Actually, we get an Object array.
			
			put("reference", Reference.class);
			put("shift",Shift.class);
			put("skill", Skill.class);
			put("staffcategory", StaffCategory.class);
			
			put("knowledge", ToKnowItem.class);
			//put("user", User.class);
			put("utility", Utility.class);
		
		}
	};
	
	/**
	 * Map of itemRoot to UI Item classes.
	 */
	protected HashMap namedItemMap = new HashMap() {
		{
			put("application", Item.class);
			
			put("acronym", AcronymItem.class);
			put("activitylog", AcronymItem.class);
			put("building", BuildingItem.class);
			put("group", AcronymItem.class);
			put("location", LocationItem.class);	
			put("setting", SettingItem.class);
			put("dependency",DependencyItem.class);
			put("review", Item.class);
			put("contact", Item.class);
			put("function", Item.class);
			put("type", Item.class);
		
			put("faq", FaqItem.class);
			put("division", AcronymItem.class);
			put("department", AcronymItem.class);
			put("plannerscategory", Item.class);
			put("reference", Item.class);
			put("shift",Item.class);
			put("skill", SkillItem.class);
			put("staffcategory", Item.class);
			put("knowledge", Item.class);
			//put("user", User.class);
			put("utility", Item.class);

		}
	};

	public HashMap getDomainObjectMap() {
		return domainObjectMap;
	}
    /** 
     * getDao Returns a  DAO for ordered Items
     */
	public BaseAdminOrderedDAO getDao(String rootName) {

		// Class daoClass= (Class) daoMap.get(tableSet).get(0);
		System.out.println("get DAO :"+rootName);
		BaseAdminOrderedDAO ret = (BaseAdminOrderedDAO) ((List) daoMap.get(rootName)).get(0);
		try {

			// ret = (OrderingDao) daoClass.newInstance();
			ret = (BaseAdminOrderedDAO) ((List) daoMap.get(rootName)).get(0);

		} catch (Exception e) {
			logger.warn("Item Dao does not exist for " + rootName, e);
		}
		return ret;
	}

	 /** 
	  * getAdminDao returns a DAO for a named item.
	  */
	public SimpleAdminDao getAdminDao(String rootName) {
		SimpleAdminDao ret = null;
		System.out.println("get DAO :"+rootName);
		try {
			ret= (SimpleAdminDao) ((List) daoMap.get(rootName))
			.get(0);
			// ret = (OrderingDao) daoClass.newInstance();
			// ret = (SimpleAdminDao) ((List) daoMap.get(rootName)).get(0);

		} catch (Exception e) {
			logger.warn("Item Dao does not exist for " + rootName, e);
		}
		return ret;
	}
    
	/**
	 * returns a mapped domain object.
	 */
	public BaseAdminOrderedDomainObject getItem(String itemName) {
		BaseAdminOrderedDomainObject ret = null;
		Class itemClass = (Class) domainObjectMap.get(itemName);
		try {
			ret = (BaseAdminOrderedDomainObject) itemClass.newInstance();
		} catch (Exception e) {
			logger.warn("BaseAdminOrderedDomainObject does not exist for " + itemName, e);
		}
		return ret;
	}
    
	/**
	 * Returns a mapped Domain Object.
	 */
	public BaseAdminDomainObject getDomainItem(String domainName) {
		BaseAdminDomainObject ret = null;
		Class itemClass = (Class) domainObjectMap.get(domainName);
		try {
			ret = (BaseAdminDomainObject) itemClass.newInstance();
		} catch (Exception e) {
			logger.warn("Type does not exist for " + domainName, e);
			System.out.println("Type does not exist for " + domainName+" "+e);
				}
		return ret;
	}
	
    /**
     * returns mapped UI Item.
     */
	public NamedItem getNamedItem(String rootName) {
		String action = "getting class from map";
		NamedItem ret = null;
		try {
			Class namedItemClass = (Class) namedItemMap.get(rootName);
		
            action="getting instance";
			ret = (NamedItem) namedItemClass.newInstance();
		} catch (Exception e) {
			logger.warn("NamedItem does not exist for " + rootName, e);
			System.out.println("NamedItem not found " + rootName + ":"+action +":"
					+ e);
		}
		return ret;
	}

	public void dispMap() {
		System.out.println("we're here");
		List list = (List) daoMap.get("application");
		Set keys = daoMap.entrySet();
		for (Object s : keys) {
			System.out.println(s.toString());

		}
		System.out.println("Got it" + list.getClass().getName());
		Object o = list.get(0);
		System.out.println("Got it" + o.getClass().getName());
		System.out.println("Got it" + o.getClass().getCanonicalName());
	}

	public Map getItemMap() {
		return domainObjectMap;
	}


}
