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
package org.kuali.continuity.admin.main.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.dao.BaseAdminDAO;
import org.kuali.continuity.admin.dao.ItemDaoFactory;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.CriticalFunctionExample;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainSettings;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.main.client.AcronymItem;
import org.kuali.continuity.admin.main.client.BuildingItem;
import org.kuali.continuity.admin.main.client.LocationItem;
import org.kuali.continuity.admin.main.client.NamedItem;
import org.kuali.continuity.admin.main.client.SettingItem;
import org.kuali.continuity.admin.main.client.SimpleService;
import org.kuali.continuity.admin.service.AdminTestModeService;
import org.kuali.continuity.admin.service.SystemDomainUIImageService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.admin.service.GenericAdminService.GenericSortBy;
import org.kuali.continuity.admin.service.util.PlanString;
import org.kuali.continuity.dao.SystemLogDAO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.BuildingOwnership;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.SystemDomainAccess;
import org.kuali.continuity.domain.SystemLog;
import org.kuali.continuity.domain.SystemLogEventTypeEnum;
import org.kuali.continuity.domain.UIImage;
import org.kuali.continuity.domain.UIImageEnum;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanAdminValidationService;
import org.kuali.continuity.plan.service.ContinuityPlanService;
import org.kuali.continuity.plan.service.CriticalFunctionService;
import org.kuali.continuity.security.SecurityUtil;
import org.kuali.continuity.service.ListService;

/**
 * Simple Service sends and receives GUI NamedItems from the client and sends
 * and transforms between these and BaseAdminDomainObject instances of the same
 * family and transmits BaseAdminDomainObject to and from the database.
 * 
 * The abstract factory ItemDaoFactory provides it with DAO, Domain, and UI
 * Value Objects (Items) of the same family required to perform the operation.
 * 
 * @author richkatz
 * 
 */
public class SimpleServiceImpl extends ServiceImpl implements SimpleService,
		ListService {
	private final Logger logger = Logger.getLogger(SimpleServiceImpl.class);
	


	// -----------------------
	// Spring injected
	private SystemLogDAO systemLogDAO;
	private DeptPlanService deptPlanService;

	private ItemDaoFactory itemDaoFactory;
	private SystemDomainDAO systemDomainDAO;
	private CriticalFunctionService criticalFunctionService;
	private ContinuityPlanService continuityPlanService;
	private ContinuityPlanAdminValidationService continuityPlanAdminValidationService;
	private UserService userService;
	private SystemDomainUIImageService systemDomainUIImageService;
	private AdminTestModeService adminEmailTestModeService;
	
	public void setSystemLogDAO(SystemLogDAO systemLogDAO) {
		this.systemLogDAO = systemLogDAO;
	}

	public void setCriticalFunctionService(
			CriticalFunctionService criticalFunctionService) {
		this.criticalFunctionService = criticalFunctionService;
	}
	
	public void setDeptPlanService(DeptPlanService deptPlanService) {
		this.deptPlanService = deptPlanService;
	}
	public void setContinuityPlanService(
			ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}

	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO = systemDomainDAO;
	}

	public void setItemDaoFactory(ItemDaoFactory itemDaoFactory) {
		this.itemDaoFactory = itemDaoFactory;
	}

	// Call-out to Abstract Factory to get DAO
	private SimpleAdminDao getAdminDao(String itemRootName) {
		logger.info("get Dao for " + itemRootName);
		return itemDaoFactory.getAdminDao(itemRootName);
	}
	
	public void setContinuityPlanAdminValidationService(ContinuityPlanAdminValidationService continuityPlanAdminValidationService){
		this.continuityPlanAdminValidationService = continuityPlanAdminValidationService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSystemDomainUIImageService(SystemDomainUIImageService systemDomainUIImageService) {
		this.systemDomainUIImageService = systemDomainUIImageService;
	}
	
	public AdminTestModeService getAdminTestModeService() {
		return this.adminEmailTestModeService;
	}

	public void setAdminTestModeService(AdminTestModeService adminEmailTestModeService) {
		this.adminEmailTestModeService = adminEmailTestModeService;
	}

	// Obtain the name of the name field for SQL ORDER BY clause
	class SortByName implements SortByType {

		public String getSortByValue() {
			return "name";
		}

	}

	SortByName sortByName = new SortByName();

	HashMap serviceBasedInstance = new HashMap() {
		{
			put("plan", "continuityPlanService");
			put("function", "criticalFunctionService");
			put("location", "systemDomainDAO");
		}
	};

	// Interface Implementation Methods
	Date getDateFromString(String dateString) {
		GregorianCalendar gc = new GregorianCalendar();
		gc
				.set(Calendar.MONTH, Integer.parseInt(dateString
						.substring(0, 2)) - 1);
		gc.set(Calendar.DATE, Integer.parseInt(dateString.substring(3, 5)));
		gc.set(Calendar.YEAR, Integer.parseInt(dateString.substring(6, 10)));
		Date ret = gc.getTime();
		return ret;
	}

	public List getSortedList(String rootName, int start, String sortBy,
			int limit, String dir, Integer institutionId0) {
		List destlist = new ArrayList();
		System.out.println("SS: Begin Get list for: " + rootName);
		List sourceList = null;
		System.out.println("SS: Get Domain ID: " + rootName);
		Integer institutionId = (Integer) this
				.getContextAttribute("systemDomainId");
		int accessLevel = (Integer) this.getContextAttribute("accessLevel");
		System.out.println("SS: accessLevel: " + accessLevel);
		Object service = serviceBasedInstance.get(rootName);
		// Special case for 1. Location and SysAdmin Access, 2. plan, and 3.
		// function.
		if (null != service
				&& ((!rootName.equals("location")) || (accessLevel == 1))) {
			System.out.println("Special Cases: " + service);
			if (rootName.equals("location")) {
				System.out.println("SS: Get List 1: " + rootName);
				sourceList = systemDomainDAO.getAll();
			} else if (rootName.equals("plan")) {
				sourceList = continuityPlanService.getSimpleContinuityPlanList(
						institutionId, sortByName, true);
				// .getContinuityPlanList(institutionId)
			} else if (rootName.equals("function")) {
				int planId = institutionId; // In this case the UI sends a plan
				// Id instead.
				sourceList = criticalFunctionService.getCriticalFunctionList(
						planId, sortByName, true);
			}

		} else {
			// Everything else.

			if (rootName.equals("activitylog")) {
				Date startDate = this.getDateFromString(sortBy);
				Date endDate = this.getDateFromString(dir);
				System.out.println("Start date: " + startDate + " " + sortBy);
				System.out.println("End date: " + endDate + " " + dir);
				System.out.println("Plan ID: " + start);
				// SystemLogDAO sdl =(SystemLogDAO) getAdminDao(rootName);
				System.out.println(systemLogDAO.getClass().getName());

				sourceList = systemLogDAO.getListByPlanIdAndDates(start,
						startDate, endDate);

			} else if (rootName.equals("location")) {
				System.out.println("SS: Get List 2: " + rootName);
				sourceList = systemDomainDAO.getAll();
			} else {
				sourceList = getAdminDao(rootName)
						.getSortedListBySystemDomainId(
								institutionId.intValue(), sortByName, true);
			}
		}
		if (!rootName.equals("plan")) {
			for (Object obj : sourceList) {
				destlist
						.add(transform2UI(rootName, (BaseAdminDomainObject) obj));

			}

			// Addin Plan Name for ActivityLog item.
			if (rootName.equals("activitylog")) {
				ContinuityPlan planObj = continuityPlanService
						.getContinuityPlan(start);
				if (planObj != null) {
					String planName = planObj.getAcronymPlusName();
					for (Object d : destlist) {
						NamedItem ni = (NamedItem) d;
						ni.setName(planName);
					}
				} else {
					for (SystemLog sysLog : (List<SystemLog>)sourceList) {
						if (SystemLogEventTypeEnum.dl.getRefDomainObject().equals(sysLog.getEventType())) {
							String planName = sysLog.getComment();
							for (Object d : destlist) {
								NamedItem ni = (NamedItem) d;
								ni.setName(planName);
							}
							break;
						}
					}
				}
			}
		} else {
			for (Object obj : sourceList) {
				System.out.println(obj.getClass().getName());
				NamedItem ni = new NamedItem();
				SimpleContinuityPlan scp = (SimpleContinuityPlan) obj;

				ni.setId(scp.getId());
				ni.setName(scp.getName());
				destlist.add(ni);
			}

		}
		return destlist;
	}

	public String deleteItem(String rootName, NamedItem item) {
		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		List<Object[]> planList = continuityPlanAdminValidationService.getPlans(
				itemDaoFactory.getDomainItem(rootName).getClass(), 
				item.getId());
		
		if(planList.size() > 0){
			return "Following Plans have links to the record selected for deletion:" + "|" + PlanString.planList2String(planList);
		} else{		
			//If rootName is location, check if there is any users associated with it.
			if (rootName.equals("location")) {
				List<User> userList = userService.getListBySystemDomainId(item.getId());
				if(userList.size() > 0){
					return "Following users have links to the record selected for deletion:" + "|" + PlanString.userList2String(userList);
				}
			}		
			itemDaoFactory.getAdminDao(rootName).delete(item.getId());
		}							
		return "";
	}

	int[] ownerindexindex = { 1, 0, 2 };
	String[] ownerDescr = { "Owned", "Not Owned", "Special Status" };

	/**
	 * Transform simple Items for the UI. Consider refactoring into Transform
	 * Class with instances mapped by Domain AND Item
	 * 
	 * @param rootName
	 *            : Name of root element
	 * @param orig
	 *            Database Domain instance
	 * @return Mapped UI xxxxItem instance
	 */
	NamedItem transform2UI(String rootName, BaseAdminDomainObject orig) {
		NamedItem dest = null;

		if (null != orig) {
			String action = "getting destination instance for " + rootName;
			try {

				dest = (NamedItem) itemDaoFactory.getNamedItem(rootName);
				System.out.println("Dest class is: "
						+ dest.getClass().getName());
				action = "transforming";
				PropertyUtils.copyProperties(dest, orig);
				// Refactoring notes: Now do getTransformClass(rootName)
				// Amd call the Transform Post-process
				if (rootName.equals("activitylog")) {
					AcronymItem aitem = (AcronymItem) dest;
					SystemLog sorig = (SystemLog) orig;
					aitem.setActDate(sorig.getEventDate().toString());
					System.out.println("Setting activityDate to: "
							+ sorig.getEventDate().toString());
					aitem.setFullName(sorig.getEventType().getDescription());

				} else if (dest instanceof BuildingItem) {
					BuildingItem bi = (BuildingItem) dest;
					String idstr = ((Building) orig).getOwnership().getId();
					Integer ownerIndex = ownerindexindex[Integer
							.parseInt(idstr)];
					bi.setOwnerIndex(ownerIndex);
					String owner = ((Building) orig).getOwnership()
							.getDescription();

					bi.setOwner(ownerDescr[ownerIndex]);

				} else if (dest instanceof LocationItem) {
					// System.out.println("Getting Location: " +
					// orig.getName()s);
					LocationItem ldest = (LocationItem) dest;
					SystemDomain sorig = (SystemDomain) orig;
					System.out.println("Transfering: " + ldest.getName());
					// ldest.setParentSystemDomainName(ldest.getName());
					// TODO --- please take a look at this - OK
					if (sorig.getSystemDomainGroup() != null
							&& sorig.getSystemDomainGroup() != null) {
						ldest.setGroup(sorig.getSystemDomainGroup());
						//ldest.setGroupId(sorig.getSystemDomainGroup().getId())
						// ;

					}
					
					if (sorig.isShibMode()){
						ldest.setShibMode(true);
					} else{
						ldest.setShibMode(false);
					}
					
					if (sorig.getShibIDP() != null && !"".equals(sorig.getShibIDP())){
						ldest.setAuthLocation(sorig.getShibIDP());
					}
					
					String[] accstrs = { "System Admin Only", "Admins Only",
							"All Users" };
									
					
					// ldest.setAuthId(sorig.getParentSystemDomainId());
					ldest.setAuthId(sorig.getId());
					// ldest.setTypestr(sorig.getType().getDescription());
					System.out.println("SS: LI: Setting access to: "
							+ sorig.getSystemDomainAccess().getDescription());

					ldest.setAccessstr(sorig.getSystemDomainAccess()
							.getDescription());
					if (ldest.getAccessstr().trim().length() == 0) {
						System.out.println("SS: LI: access String was blank ");
						int acId = Integer.parseInt(sorig
								.getSystemDomainAccess().getId());
						System.out.println("SS: LI: access value: " + acId);
						ldest.setAccessstr(accstrs[acId]);
					}
					ldest.setAccess(sorig.getSystemDomainAccess().getId());
					ldest.setShibUniqueId(sorig.getShibUniqueId());
					ldest.setCustomUrl(sorig.getCustomUrl());
					
					// custom images
					Map<UIImageEnum, UIImage> imageMap = this.systemDomainUIImageService.getByOwnerId(sorig.getId());
					ldest.setCustomImage1(imageMap.get(UIImageEnum.BEGIN) != null);
					ldest.setCustomImage2(imageMap.get(UIImageEnum.BEGIN_TEXT) != null);
					ldest.setCustomImage3(imageMap.get(UIImageEnum.BANNER) != null);
					ldest.setCustomImage4(imageMap.get(UIImageEnum.BANNER_TEXT) != null);
					
					
				} else if (rootName.equals("function")) {
					CriticalFunctionExample corig = (CriticalFunctionExample) orig;
					dest.setName(corig.getPlans());

				} else if (dest instanceof SettingItem) {
					System.out.println("single transform:" + rootName);
					// This code could be moved to transform2UI
					SettingItem dset = (SettingItem) dest;

					SystemDomain dget = (SystemDomain) orig;
				
					Map m = getUserInfo();
					SessionUserDTO sud = (SessionUserDTO)m.get(SessionKey.user.name());
					if(sud!=null){
						dset.setLoggedUserAccessLevel(sud.getDomainObject().getSecurityType().getId());
					}else{
						System.out.println("SessionUserDTO is null");
					}
					//SecurityType
					
					
					dset.setId(dget.getId());
					System.out.println("Settings: 1 of 3 Getting Access:"
							+ rootName);
					Integer access = Integer.parseInt(dget
							.getSystemDomainAccess().getId());
					dset.setAccess(access);
					SystemDomainSettings sds = dget.getSettings();

					Boolean[] opts = { false, false, false, false, false, false };
					System.out.println("Settings: 2 of 3 opts:" + rootName);
					opts[SettingItem.optionType.Skills.ordinal()] = sds
							.isSkillsScreenVisible();
					opts[SettingItem.optionType.Teams.ordinal()] = sds
							.isTeamsScreenVisible();
					opts[SettingItem.optionType.Staffing.ordinal()] = sds
							.isStaffRequirementsScreenVisible();
					opts[SettingItem.optionType.Functions.ordinal()] = sds
							.isCriticalFunctionsScreenVisible();
					opts[SettingItem.optionType.Replace.ordinal()] = sds
							.isInstructionVisible();
					opts[SettingItem.optionType.CriticalityLevel.ordinal()] = sds
							.isCriticalLevelDetailsVisible();

					dset.setOptions(opts);
					dset.setSublocation("");
					System.out.println("Settings: 3 of 3 getting NetDomains:"
							+ rootName);
					Set<String> dnet = dget.getNetDomains();
					String[] dnetArray = new String[dnet.size()];
					dnet.toArray(dnetArray);

					dset.setDomainList(dnetArray);
					// if (dget.getId() != dget.getParentSystemDomainId()) {
					// int parentId = dget.getParentSystemDomainId();
					// dset.setSublocation(dset.getName());
					// SystemDomain parent = (SystemDomain) getAdminDao(
					// rootName).getById(parentId);
					// dset.setName(parent.getName());
					//
					// }
					dset.setInTestMode(this.isInTestMode(sud.id));
					dset.setFullModeration(dget.getFullModeration());
					dset.setSystemName(dget.getSystemName());
					dset.setEmail(dget.getEmail());
					dset.setShibMode((Boolean)this.getContextAttribute("shibMode"));

				}
			} catch (Exception e) {
				logger.warn(
						"SS Transform: Failed to retrieve  Admin Object while"
								+ action + ":" + rootName, e);
				System.out
						.println("SS Transform: FFailed to retrieve  Admin Object while"
								+ action + ":" + rootName + " " + e);
			}
		}
		return dest;
	}

	/**
	 * This method returns a covariant display item by transforming its family
	 * related domain item that is retrieved by the family DAO.
	 */
	public NamedItem getItem(String rootName, Integer id) {
		// TODO Auto-generated method stub
		System.out.println("SS get Item:" + rootName);
		
		if (rootName.equals("setting")) {
			// Retrieve Shib info for Setting here
			//System.out.println("SS get systemDomainId:" + rootName);

			if (id.intValue() == 0) {
				id = (Integer) this.getContextAttribute("systemDomainId");
			}
			if (id.intValue() == 0) {
				id = 1; // Check for testing only.
			}
		}
		//System.out.println("SS retrieve Dao for:" + rootName);
		SimpleAdminDao dao = getAdminDao(rootName);

		//System.out.println("SS retrieve Database Data for:" + rootName + " "+ id);
		BaseAdminDomainObject orig = null;
		if (!rootName.equals("function")) {
			orig = dao.getById(id);
		} else {
			int institutionId = (Integer) this.getContextAttribute("systemDomainId");
			//System.out.println("Fetting Orig List for Institution with ID: " + institutionId);
			List origlist = ((BaseAdminDAO) dao)
					.getListBySystemDomainId(institutionId);
			//System.out.println(origlist.size());
			if (origlist == null || origlist.isEmpty()) {
				orig = new CriticalFunctionExample(institutionId);
			} else {
				orig = (BaseAdminDomainObject) origlist.get(0);
			}
			

		}
		NamedItem dest = null;

		if (null != orig) {
			String action = "getting destination class";
			try {
				// Create new destination.
				dest = (NamedItem) itemDaoFactory.getNamedItem(rootName);

				// Transform
				dest = transform2UI(rootName, (BaseAdminDomainObject) orig);
				action = "special get Only case";

				// Special Get Only Cases:

			} catch (Exception e) {
				logger.warn("SS get: Failed to retrieve  Admin Object while"
						+ action + ":" + rootName, e);
				System.out
						.println("SS get:  Failed to retrieve  Admin Object while"
								+ action + ":" + rootName + " " + e);
			}
			System.out.println("get Returning: " + dest.getClass().getName());
		}
		return dest;
	}

	public String insertItem(String rootName, NamedItem item) {
		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;

		System.out.println("insert Simple called on " + rootName + " ");
		int thelocation = (Integer) this.getContextAttribute("systemDomainId");
		logger.info("insertItem " + rootName + item.getName());
		System.out.println("insertItem " + rootName + item.getName());
		BaseAdminDomainObject dest = null;
		String action = "getting destination object for Institution: "
				+ thelocation;
		item.setSystemDomainId(thelocation);
		System.out.print(action + " ");

		if (item != null) {
			try {
				if (item instanceof LocationItem) {
					String customUrl = ((LocationItem)item).getCustomUrl();
					
					if (!SecurityUtil.uriSyntaxCheck(customUrl)){
						return "User Friendly URL has invalid characters.";
					}
					
					if (this.systemDomainDAO.isCustomUrlTaken(0, customUrl)) {
						return "User Friendly URL is already taken by another institution.";						
					}
				}
				
				dest = itemDaoFactory.getDomainItem(rootName);
				System.out.println(dest.getClass().getName());
				action = "SS insert: transforming";
				System.out.print(action + " ");
				dest = transformFromUI2Domain(rootName, dest, item, false);
				// PropertyUtils.copyProperties(dest, item);
				action = "SS insert: setting ID to null for insert.";
				System.out.println(action + " ");
				dest.setId(null); // Null out for insert.

				action = "SS insert: getting DAO for " + rootName;
				System.out.println(action + " ");
				SimpleAdminDao itemDao = itemDaoFactory.getAdminDao(rootName);
				System.out.println("SS insert: inserting Simple: " + rootName
						+ " Name: " + dest.getName() + " "
						+ dest.getSystemDomainId());
				action = "SS inserting " + rootName;
				itemDao.create(dest);
			} catch (Exception e) {
				logger.warn("SS INSERT Failed to create  Admin Object while"
						+ action + ":" + rootName, e);
				System.out
						.println("SS INSERT Failed to save  Admin Object while "
								+ action + ":" + rootName + " " + e);
			}
			System.out.println("SS insert Done");
		} else {

			logger.warn("SS INSERT Failed to create  Admin Object -- " + ""
					+ "item was null!" + ":" + rootName);
		}
		return "";
	}

	/**
	 * This is the rest of the transform mechanism.
	 * 
	 * @param rootName
	 *            name of the tranform
	 * @param dest
	 *            the domain instance to transform into (this must be included
	 *            because it may be being updated)
	 * @param item
	 *            the UI value object from which the transform takes place
	 * @return returns a completed domain instance.
	 * @throws Exception
	 */
	protected BaseAdminDomainObject transformFromUI2Domain(String rootName,
			BaseAdminDomainObject dest, NamedItem item, boolean upflag) throws Exception {
		System.out.println("Name before transform: " + dest.getName());
		if (!rootName.equals("setting")) {
			PropertyUtils.copyProperties(dest, item);
			dest.setName(item.getName());
		}

		if (item instanceof BuildingItem) {
			// Name is building Name.
			System.out.println("UI2: Starting transformof Building Item");
			// CaanName is commonName
			BuildingItem bitem = (BuildingItem) item;
			System.out.println("UI2: Got Building Item");
			Building bdest = (Building) dest;
			bdest.setCaan(((BuildingItem) item).getCaan());

			bdest.setCommonName(((BuildingItem) item).getCommonName());
			bdest.setName(((BuildingItem) item).getName());
			bdest.setAddress(((BuildingItem) item).getAddress());

			System.out.println("Building ownership index: "
					+ bitem.getOwnerIndex());
			String ox = "" + bitem.getOwnerIndex();
			// Set with ownership index.
			if (null == bdest.getOwnership()) {
				bdest.setOwnership(new BuildingOwnership(ox));
			} else {
				bdest.getOwnership().setId(ox);

			}
			System.out.println("UI2:  Building Item transform done");
			logger.info("Building Object to store: " + bdest.getAddress() + "|"
					+ bdest.getCommonName() + "|" + bdest.getName() + "|"
					+ bdest.getCaan() + "|" + bdest.getOwnership().getId()
					+ "|" + bdest.getSystemDomainId());
		} else if (rootName.equals("acronym")) {
			AcronymItem aitem = (AcronymItem) item;
			Acronym adest = (Acronym) dest;
			logger.info("SETTING acronym: " + aitem.getName());
			adest.setName(aitem.getName());
			adest.setFullName(aitem.getFullName());

		} else if (rootName.equals("setting")) {
			logger.info("Start save settings transform.");
			SettingItem sitem = (SettingItem) item;

			SystemDomain sdest = (SystemDomain) dest;
			SystemDomainAccess sda = new SystemDomainAccess();
			sda.setId(sitem.getAccess().toString());
			sdest.setSystemDomainAccess(sda);
			SystemDomainSettings sds = new SystemDomainSettings();
			Boolean opts[] = sitem.getOptions();
			sds.setSkillsScreenVisible(opts[SettingItem.optionType.Skills
					.ordinal()]);
			sds
					.setCriticalFunctionsScreenVisible(opts[SettingItem.optionType.Functions
							.ordinal()]);
			sds
					.setStaffRequirementsScreenVisible(opts[SettingItem.optionType.Staffing
							.ordinal()]);
			sds.setTeamsScreenVisible(opts[SettingItem.optionType.Teams
					.ordinal()]);

			sds.setInstructionVisible(opts[SettingItem.optionType.Replace
					.ordinal()]);
			sds.setCriticalLevelDetailsVisible(opts[SettingItem.optionType.CriticalityLevel
			           					.ordinal()]);
			sdest.setSettings(sds);
			List<String> netList = Arrays.asList(sitem.getDomainList());

			sdest.setNetDomains(new HashSet<String>(netList));
		    
			sdest.setFullModeration(sitem.getFullModeration());
			sdest.setSystemName(sitem.getSystemName());
			sdest.setEmail(sitem.getEmail());
			logger.info("End save settings transform.");

		} else if (rootName.equals("function")) {
			logger.info("Start saving critical function example");
			CriticalFunctionExample cdest = (CriticalFunctionExample) dest;
			cdest.setPlans(item.getName());
		} else if (rootName.equals("location")) {
			// Location is a complex item and has fields that are not updated from the UI.
			if  (upflag) {
				SystemDomain sdest = (SystemDomain) this.getAdminDao("location").getById(item.getId());
				// Recopy properties again to new object.
				BeanUtils.copyProperties(sdest, item);
				dest=sdest;
			} else {
				SystemDomain sdest = (SystemDomain) dest;
				sdest.setShibMode(false);
				sdest.setLBNL(false);
				sdest.setShibIDP("");
				sdest.setEmail("");
				sdest.setFax("");
				sdest.setPhone("");
				Set<String> domains = new HashSet<String>();
				sdest.setNetDomains(domains);
			}
			LocationItem li = (LocationItem) item;
			SystemDomain sdest = (SystemDomain) dest;
			sdest.setId(li.getAuthId());
			sdest.setSystemDomainGroup(li.getGroup());
			sdest.setShibUniqueId(li.getShibUniqueId());
			sdest.setCustomUrl(li.getCustomUrl());
			SystemDomainAccess systemDomainAccess = new SystemDomainAccess();
			systemDomainAccess.setId("0");
			
			if (null !=li.getAccess() && li.getAccess().length()>0) {
				systemDomainAccess.setId(li.getAccess());
			}
			sdest.setSystemDomainAccess(systemDomainAccess);
			// Optional fields.

			
			if (sdest.getSettings() == null) {
				SystemDomainSettings systemDomainSetting = new SystemDomainSettings();
				systemDomainSetting.setInstructionVisible(true);
				sdest.setSettings(systemDomainSetting);
			}
			System.out.println(" Location UI2:  "+sdest.getName()+" group: "+sdest.getSystemDomainGroup()+" "+sdest.getSystemDomainAccess().getId());
			// sdest.setParentSystemDomainId(li.getAuthId());
			// } else if (rootName.equals("department")) {
			// InstructionalDepartment idest = (InstructionalDepartment) dest;
			// AcronymItem aitem = (AcronymItem) item;
			// idest.setName(aitem.getName());
			
			sdest.setShibIDP(li.getAuthLocation());
			if(li.isShibMode()){
				sdest.setShibMode(true);
			} else{
				sdest.setShibMode(false);
			}
			
		}
		System.out.println("Name after transform: " + dest.getName());
		return dest;

	}

	@SuppressWarnings("unchecked")
	public String updateItem(String rootName, NamedItem item) {
		// check token
		if (!this.isCsrfTokenValid(item.getCsrfToken())) return INVALID_CSRF_TOKEN_MESSAGE;
		
		// Retrieve item to be updated.
		Integer thelocation = (Integer) this
				.getContextAttribute("systemDomainId");
		logger.info("CONTEXT has SYSTEM DOMAIN: " + thelocation);
		item.setSystemDomainId(thelocation);
		logger.info("updateItem " + rootName + item.getName());
		System.out.println("updateItem " + rootName + " named: "
				+ item.getName());
		BaseAdminDomainObject dest = null;
		String action = "getting destination class";
		boolean isNewFunction = false;
		// Because this is an update we're going to get the live existing
		// object.

		if (item != null)
			try {
				if (item instanceof LocationItem) {
					int sId = ((LocationItem)item).getId();
					String customUrl = ((LocationItem)item).getCustomUrl();				
					if (!SecurityUtil.uriSyntaxCheck(customUrl)){
						return "User Friendly URL has invalid characters.";
					}				
					if (this.systemDomainDAO.isCustomUrlTaken(((LocationItem)item).getId(), customUrl)) {
						return "User Friendly URL is already taken by another institution.";
					}
				}

				SimpleAdminDao dao = getAdminDao(rootName);
				System.out.println("Got DAO for save: "
						+ dao.getClass().getSimpleName());
				if (rootName.equals("setting")) {
					item.setId(thelocation);
				}
				if (rootName.equals("function")) {
					List<CriticalFunctionExample> cfExs = (List<CriticalFunctionExample>)
						dao.getSortedListBySystemDomainId(thelocation, GenericSortBy.id, true);
					if (cfExs != null && !cfExs.isEmpty()) {
						dest = cfExs.get(0);
						item.setId(dest.getId());
					}
				} else {
					dest = dao.getById(item.getId());
				}
				if (dest != null) {
					System.out
							.println("Updating: " + dest.getClass().getName());
				} else {
					if (rootName.equals("function")) {
						isNewFunction = true;
						dest = new CriticalFunctionExample(thelocation);
					}
					System.out.println("Can't retrieve dest instance for: "
							+ rootName);

				}
				if (!rootName.equals("setting")) {
					thelocation = dest.getSystemDomainId(); // Preserve
					logger.info("GOT SYSTEM DOMAIN: " + thelocation);

				} else {

				}

				action = "transforming";
				dest = transformFromUI2Domain(rootName, dest, item, true);
				// if (!rootName.equals("setting")) {
				// dest.setSystemDomainId(thelocation);
				// }

				logger.info("STORING ENTRY." + rootName + " : "
						+ dest.getName() + "DAO:"
						+ dao.getClass().getSimpleName() + ".  SYSTEM DOMAIN: "
						+ dest.getSystemDomainId());
				if (rootName.equals("setting")) {
					System.out.println("Storing settings:" + dest.getName());
				}
				if (rootName.equals("function") && isNewFunction) {
					dest.setId(null);
					dao.create(dest);
				} else {
					dao.update(dest);
				}
				if (rootName.equals("setting")) {
					SettingItem setItem = (SettingItem) item;

					// system domain settings
					this.resetSystemDomainSettings(((SystemDomain)dest).getSettings(), setItem.isInTestMode());
					
					// admin disabled
					SessionUserDTO userDTO = (SessionUserDTO) this.getSessionValue(SessionKey.user.name());
					if (userDTO != null) 
						this.setInTestMode(setItem.isInTestMode(), userDTO.id);
				}
				System.out.println("Success!");
			} catch (Exception e) {
				logger.warn("SS UPDATE Failed to save  Admin Object while"
						+ action + ":" + rootName, e);
				System.out
						.println("SS UPDATE Failed to retrieve  Admin Object while"
								+ action + ":" + rootName + " " + e);
			}			
			return "";
	}

	/**
	 * Special functions for Critical Function Examples
	 */
	public String[][] getStringArray(String rootName, Integer institutionId) {
		
		GregorianCalendar now = new GregorianCalendar();
		System.out.println("get String Array Start. " + now.getTime()+": "+rootName);
        
		List sourceList = new ArrayList();
		try {
			if (rootName.equals("plan")) {
				institutionId = (Integer) this.getContextAttribute("systemDomainId");
				logger.debug("get String Array: Getting plans:");
				sourceList = continuityPlanService
					.getSimpleContinuityPlanList(institutionId);
				logger.debug("get String Array: got plans: "
					+ sourceList.size());
			
			} else if (rootName.equals("deptplan")) {
				institutionId = (Integer) this.getContextAttribute("systemDomainId");
				logger.debug("get String Array: Getting plans:");
				sourceList = 
					deptPlanService.getSimpleContinuityPlanList(institutionId);
				
				logger.debug("get String Array: got plans: "
						+ sourceList.size());
				
				String[][] ret = new String[sourceList.size()][3];
				for (int i = 0; i < sourceList.size(); i++) {
					Object[] cp = (Object[])sourceList.get(i);
					// Object[] cp = (Object[]) ddata;
					ret[i][0] = cp[0].toString();
					ret[i][1] = cp[1].toString();
					ret[i][2] = cp[2].toString();
					// ret[i][0] = cp[0].toString();
					// ret[i][1] = cp[1].toString();
					// ret[i][2] =
				}

				return ret;
			
			} else if (rootName.equals("function")) {
				int planId = institutionId; // In this case the UI sends a plan Id
			// instead.
			
				logger.debug("Getting functions for Plan " + planId);
				sourceList = criticalFunctionService
					.getCriticalFunctionList(planId);
				logger.debug("Got response from service " + sourceList.size());
			}
		} catch (Exception e) {
			logger.warn("Error occurred getting Array for: "+rootName,e);
			System.out.println("Error occurred getting Array for: "+rootName+": "+e);
			e.printStackTrace();
		}
		String[][] ret;
		ArrayList<String[]> lret = new ArrayList();
		int retsize=1;
		if (sourceList.size()>1) retsize=sourceList.size();
		ret = new String[retsize][2];
		int iret = 0;
		for (int i = 0; i < sourceList.size(); i++) {

			Object ddata = sourceList.get(i);
			if (ddata instanceof BaseDomainObject) {
				BaseDomainObject bd = (BaseDomainObject) ddata;
				ret[i][0] = bd.getId().toString();
				ret[i][1] = bd.getName();
				iret++;

				// These can be eliminated.
			} else if (ddata instanceof Object[]) {
				Object[] cp = (Object[]) ddata;
				ret[i][0] = cp[0].toString();
				ret[i][1] = cp[1].toString();
				iret++;
			} else if (ddata instanceof ContinuityPlan) {
				ContinuityPlan cp = (ContinuityPlan) ddata;
				ret[i][0] = cp.getId().toString();
				ret[i][1] = cp.getName();
				iret++;
			} else if (ddata instanceof CriticalFunction) {
				CriticalFunction cf = (CriticalFunction) ddata;
				ret[i][0] = cf.getId().toString();
				ret[i][1] = cf.getName();
				iret++;
			}

		}
		GregorianCalendar now2 = new GregorianCalendar();
		System.out.println("get String Array End. " + now2.getTime());
		return ret;
	}

	// String[] x = { "a", "b", "c" };
	// String[] y = { "a", "b", "c" };
	// String[][] ret = { x, y };

	public void saveStringArray(String rootName, Integer institutionId,
			String[][] stringArray) {
		SimpleAdminDao dao = getAdminDao(rootName);

	}

	@Override
	public String[][] getStringPlanArray(String rootName, Integer institutionId) {
		List sourceList = null;
		// sourceList = continuityPlanService
		// .getSimpleContinuityPlanList(institutionId);

		sourceList = continuityPlanService.getSimpleContinuityPlanList(
				institutionId, (SortByType) ContinuityPlan.SortBy.id, true);
		String[][] ret = new String[sourceList.size()][3];
		for (int i = 0; i < sourceList.size(); i++) {
			Object ddata = sourceList.get(i);
			// Object[] cp = (Object[]) ddata;
			SimpleContinuityPlan cp = (SimpleContinuityPlan) ddata;
			ret[i][0] = cp.getId().toString();
			ret[i][1] = cp.getName();
			ret[i][2] = cp.getStatus().toString();
			// ret[i][0] = cp[0].toString();
			// ret[i][1] = cp[1].toString();
			// ret[i][2] =
		}

		return ret;
	}

	protected void resetSystemDomainSettings(SystemDomainSettings settings, boolean isInTestMode) {
		SessionSystemDomainDTO dto = (SessionSystemDomainDTO)
		    this.getSessionValue(SessionKey.systemDomain+"Full");
		if (dto == null) return;
		dto.settings.isCriticalFunctionsScreenVisible = settings.isCriticalFunctionsScreenVisible();
		dto.settings.isInstructionVisible = settings.isInstructionVisible();
		dto.settings.isSkillsScreenVisible = settings.isSkillsScreenVisible();
		dto.settings.isStaffRequirementsScreenVisible = settings.isStaffRequirementsScreenVisible();
		dto.settings.isTeamsScreenVisible = settings.isTeamsScreenVisible();
		dto.settings.isCriticalLevelDetailsVisible = settings.isCriticalLevelDetailsVisible();
		dto.settings.isInTestMode = isInTestMode;
	}

	protected void setInTestMode(boolean isInTestMode, int userId) {
		this.adminEmailTestModeService.setInTestMode(isInTestMode, userId);
	}
	
	protected boolean isInTestMode(int userId) {
		return this.adminEmailTestModeService.isInTestMode(userId);
	}
	
	@SuppressWarnings("unchecked")
	private Object getSessionValue(Object sessionKey) {
		Map m = this.getUserInfo();
		if (m == null) return null;
		return m.get(sessionKey);
	}
	
}
