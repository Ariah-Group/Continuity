<%-- 
 % Copyright 2011 Kuali Foundation, Inc. Licensed under the
 % Educational Community License, Version 2.0 (the "License"); you may
 % not use this file except in compliance with the License. You may
 % obtain a copy of the License at
 % 
 % http://www.opensource.org/licenses/ecl2.php
 % 
 % Unless required by applicable law or agreed to in writing,
 % software distributed under the License is distributed on an "AS IS"
 % BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 % or implied. See the License for the specific language governing
 % permissions and limitations under the License.
 --%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<s:set name="tiles_includeStyles" value="{'/continuity/css/plan/planHome.css','/continuity/css/plan/getPlanReview.css'}"/>
<s:set name="tiles_includeScripts" value="{'/continuity/javascripts/plan/getPlanReviewLibrary.js'}"/>
<tiles:insertDefinition name="kcpt.getPlanReview"/>