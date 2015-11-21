USE [Continuity]
GO
ALTER TABLE [dbo].[SystemDomain] ADD [RecoveryTimeFlag] char(1) DEFAULT '0' NOT NULL
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminInstitutionAccess','0','System Admin Only')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminInstitutionAccess','3','System and Institution Admins Only')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminInstitutionAccess','1','Admins Only')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminInstitutionAccess','2','All Users')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('AccessStatus','0','OFF')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('AccessStatus','1','ON')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','0','System Admin')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','1','Local Admin')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','2','Universal Viewer')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','3','Institution Admin')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','4','Moderator')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysAdminRoleSet','9','Local User')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','ac','Accessed')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','cr','Created')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','dl','Deleted')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','in','Login')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','rw','Reviewed')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('SysLogEventType','st','Status Changed')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('BuildingOwnership','0','Not Owned')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('BuildingOwnership','1','Owned')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('BuildingOwnership','2','Special Status')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('EvacuationPlan','0','No')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('EvacuationPlan','1','Yes')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('EvacuationPlan','2','Some, not all')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('EvacuationPlan','3','Do not know')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DependencyType','0','Downstream')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DependencyType','1','Upstream')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','p','Paper')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','e','Electronic (computer)')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','mf','Microfiche')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','mf','Microfilm')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','pl','More than one (explain)')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('DocumentMedium','ot','Other (explain)')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('PlanStatus','N','In-Progress')
GO
INSERT INTO [dbo].[DescriptionLookup] (LookupName,LookupValue,LookupDescription) VALUES ('PlanStatus','C','Complete')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,2,'1','less than $100')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,3,'2','$100 to $1000')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,4,'3','$1000 to $10,000')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,5,'4','$10,000 to $100,000')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,6,'5','more than $100,000')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (19,1,'x','Do Not Know')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (15,1,'1','One time')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (15,2,'2','Annual')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (15,3,'3','Both one time and annual')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (15,4,'4','Other')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,1,'1','my unit itself')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,2,'2','my unit together with other units on campus')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,3,'3','my larger department,division or control unit')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,4,'4','the campus')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,5,'5','other')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (20,6,'6','not sure')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (21,1,'d','Needs further discussion')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (21,2,'n','Not yet begun')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (21,3,'p','In Progress')
GO
INSERT INTO [dbo].[lookup_items] (lookup_id,lookup_item_no,lookup_item_id,lookup_item_desc) VALUES (21,4,'c','Completed')
GO
INSERT INTO [dbo].[SystemCriticalLevelFunc] (LevelNo,Name,Descr,LongDescr) VALUES ('1','Extreme','Extreme','Super crazy critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelFunc] (LevelNo,Name,Descr,LongDescr) VALUES ('2','High','High','Really critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelFunc] (LevelNo,Name,Descr,LongDescr) VALUES ('3','Medium','Medium','Average critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelFunc] (LevelNo,Name,Descr,LongDescr) VALUES ('4','Deferrable','Deferrable','Not really critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelAppl] (LevelNo,Name,Descr,LongDescr) VALUES ('1','Extreme','Extreme','Super crazy critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelAppl] (LevelNo,Name,Descr,LongDescr) VALUES ('2','High','High','Really critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelAppl] (LevelNo,Name,Descr,LongDescr) VALUES ('3','Medium','Medium','Average critical')
GO
INSERT INTO [dbo].[SystemCriticalLevelAppl] (LevelNo,Name,Descr,LongDescr) VALUES ('4','Deferrable','Deferrable','Not really critical')
GO
INSERT INTO [dbo].[SystemDomainGroup] (Name) VALUES ('Demo Group')
GO
INSERT INTO [dbo].[SystemDomain] (Institution,InstitutionType,InstitutionOrgList,AuthLocation,AuthType,Domain,News,NewsExpirationDate,Tips,TipsExpirationDate,Logo,Phone,Fax,EMail,InstitutionAccess,DirectoryAccess,TeamsScreenFlag,SkillsScreenFlag,StaffingScreenFlag,ExamplesScreenFlag,LBNLFlag,SamplePlan,ReplaceStep4Flag,Instruction_URL,InstGroupID,InstGroup,SystemName,Moderation,CustomUrl,ShibUniqueID,CriticalLvlDtlsFlag,RecoveryTimeFlag) VALUES ('Demo University','0','','','0',0,'',CURRENT_TIMESTAMP,'',CURRENT_TIMESTAMP,null,'','','','2','0','1','1','1','1','0',null,'0','',(SELECT IDENT_CURRENT('SystemDomainGroup')),'Demo University','Demo University','1','demo',null,'0','0')
GO
INSERT INTO [dbo].[UserSecurity] (AuthID,InstitutionID,SecurityType,FirstName,LastName,WorkPhone,HomePhone,CellPhone,EMailRegular,EMailBackup,WorkFAX,Title,DepartmentName,DepartmentOrg,DepartmentOrgHierarchy,WorkAddress,HomeAddress,AccessStatus,LockStatus,CreatedDate,Affiliations,Password,SecurityAttribute,DirectoryID,ModApprovedFlag) VALUES ('admin',(SELECT IDENT_CURRENT('SystemDomain')),'0','Super','User','999-999-9999','','','admin@example.com','','','Admin','Administration','','','','','1','0',CURRENT_TIMESTAMP,'','4E17A448E043206801B95DE317E07C839770C8B8',1,'','1')
GO
