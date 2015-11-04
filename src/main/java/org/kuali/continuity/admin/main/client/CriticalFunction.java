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
package org.kuali.continuity.admin.main.client;

import java.util.Arrays;
import java.util.HashSet;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ChangeListenerCollection;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class CriticalFunction extends ListControl implements EntryPoint {
	final HorizontalPanel horizontalPanel = new HorizontalPanel();
	final ListBoxDC availablePlanListBox = new ListBoxDC();
	final VerticalPanel midPanel = new VerticalPanel();
	final Image addButton = new Image("Add.gif");
	final Image removeButton = new Image("Remove.gif");
	final ListBoxDC examplePlanListBox = new ListBoxDC();
	final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
	final ListBox criticalFunctionsListBox = new ListBox();
	final DockPanel dockPanel = new DockPanel();
	final DockPanel buttonBar = new DockPanel();
	final HorizontalPanel left = new HorizontalPanel();
	final HorizontalPanel right = new HorizontalPanel();
	final Label criticalFunctionLabel = new Label(" ");
	final Button backButton = new Button();
	final Button saveButton = new Button();
	final Button viewButton = new Button();
	int listBoxHeight = 17;
	String itemRootName;
	public SimpleServiceAsync itemService = null;
	int thisInstitution = 0;
	int currentId;
	final Hidden csrfToken = new Hidden();


	public void addMethod() {
		if (availablePlanListBox.getSelectedIndex() >= 0) {
			int curItem = availablePlanListBox.getSelectedIndex();
			String thisPlanName = availablePlanListBox.getItemText(curItem);
			String thisPlanId = availablePlanListBox.getValue(curItem);
			availablePlanListBox.removeItem(curItem);
			examplePlanListBox.addItem(thisPlanName, thisPlanId);
		}
	}

	public void removeMethod() {
		if (examplePlanListBox.getSelectedIndex() >= 0) {
			int curItem = examplePlanListBox.getSelectedIndex();
			String thisPlanName = examplePlanListBox.getItemText(curItem);
			String thisPlanId = examplePlanListBox.getValue(curItem);

			examplePlanListBox.removeItem(curItem);
			availablePlanListBox.addItem(thisPlanName, thisPlanId);
		}
	}

	public void onModuleLoad() {
		
		
		RootPanel rootPanel = RootPanel.get("gwtRoot");
		rootPanel.setWidth("642");
		Element screenelement = DOM.getElementById("itemdata");
		Element formelement = DOM.getElementById("formelement");
		Element pluralelement = DOM.getElementById("plural");
		String panelHeight = "250px";
		String planBoxWidth = "275px";

		String pageInfo = screenelement.getTitle();
		String pageTitle = screenelement.getTitle();
		String proxyUrl = "./items.lst";
		itemService = (SimpleServiceAsync) GWT.create(SimpleService.class);

		rootPanel.add(dockPanel);

		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		rootPanel.add(csrfToken);

		dockPanel.add(horizontalPanel, DockPanel.NORTH);
		horizontalPanel.setSize("601px", panelHeight);
		VerticalPanel leftPanel = new VerticalPanel();
		leftPanel.add(new Label("Available Plans"));
		leftPanel.add(availablePlanListBox);

		horizontalPanel.add(leftPanel);

		availablePlanListBox.setWidth(planBoxWidth);
		availablePlanListBox.setVisibleItemCount(listBoxHeight);
		availablePlanListBox.addClickListener(new ClickListener() {
			public void onClick(final Widget arg0) {
				if (availablePlanListBox.getSelectedIndex() >= 0)
					if (availablePlanListBox.getSelectedIndex() <= availablePlanListBox
							.getItemCount()) {
						int index = availablePlanListBox.getSelectedIndex();
						Integer planId = Integer.parseInt(availablePlanListBox
								.getValue(index));

						criticalFunctionLabel.setText(" - "+availablePlanListBox.getItemText(index));
						itemService.getStringArray("function", planId, callbackGetFunctions);
					}
			}

		});
		examplePlanListBox.setWidth(planBoxWidth);
		examplePlanListBox.addClickListener(new ClickListener() {
			public void onClick(final Widget arg0) {
				int index = examplePlanListBox.getSelectedIndex();
				if (index >= 0)
					if (index < examplePlanListBox.getItemCount()) {
						// Window.alert("" +
						// examplePlanListBox.getSelectedIndex()
						// + " " + examplePlanListBox.getItemCount());
						Integer planId = Integer.parseInt(examplePlanListBox
								.getValue(index));
						
						//Window.alert("Before getting plans for plan id " + planId);
						// criticalFunctionLabel.setText(" - "+examplePlanListBox
						// .getItemText(index));
						criticalFunctionLabel.setText(" - " + examplePlanListBox.getItemText(index));
						itemService.getStringArray("function", planId,
								callbackGetFunctions);
					}
			}
		});
		availablePlanListBox.addChangeListener(new ChangeListener() {

			public void onChange(Widget arg0) {
				// Window.alert("Double click "+availablePlanListBox.getItemText(
				// availablePlanListBox.getSelectedIndex()));
				addMethod();

			}
		});
		examplePlanListBox.addChangeListener(new ChangeListener() {

			public void onChange(Widget arg0) {
				// Window.alert("Double click "+availablePlanListBox.getItemText(
				// availablePlanListBox.getSelectedIndex()));
				removeMethod();

			}
		});
		itemRootName = pageInfo.toLowerCase();

		VerticalPanel topFiller = new VerticalPanel();
		String midwid = "90px";
		topFiller.setSize(midwid, "90px");
		topFiller.add(new Label(" "));
		midPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		midPanel.add(topFiller);
		horizontalPanel.add(midPanel);

		midPanel.add(addButton);
		addButton.addClickListener(new ClickListener() {
			public void onClick(final Widget arg0) {
				// Get plan from Available Plan List
				// Remove it and add it to example plan List
				addMethod();

			}
		});
		// addButton.setText("Add >");

		VerticalPanel midFiller = new VerticalPanel();
		midFiller.setSize(midwid, "12px");
		midFiller.add(new Label(" "));
		midPanel.add(midFiller);
		midPanel.add(removeButton);
		removeButton.addClickListener(new ClickListener() {
			public void onClick(final Widget arg0) {
				// Get selected item from example Plan List
				// Remove it from selected List and add it to
				// Available list.
				removeMethod();

			}
		});
		// removeButton.setText("< Remove ");
		VerticalPanel rightPanel = new VerticalPanel();
		rightPanel.add(new Label("Selected Plans"));
		rightPanel.add(examplePlanListBox);
		horizontalPanel.add(rightPanel);

		examplePlanListBox.setVisibleItemCount(listBoxHeight);
		examplePlanListBox.addClickListener(new ClickListener() {
			public void onClick(final Widget arg0) {
				// Show functions for the current plan.
				//itemService.getStringArray("function", thisInstitution,callbackGetPlans);
			}
		});

		horizontalPanel_1.setSize("601px", "128px");
		VerticalPanel bottom = new VerticalPanel();
		AbsolutePanel bottomLabelPanel = new AbsolutePanel();
		// HorizontalPanel bottomLabelPanelLeft = new HorizontalPanel();

		// bottomLabelPanelLeft.setWidth("220px");
		// bottomLabelPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		// bottomLabelPanelLeft.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		// bottomLabelPanel.add(bottomLabelPanelLeft);

		final Label cfTitle = new Label("Critical Functions of Plan");
		bottomLabelPanel.add(cfTitle, 0, 0);

		cfTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		// functionLabelPanel.add(spacer);
		criticalFunctionLabel.setStyleName("AttentionClass2");
		bottomLabelPanel.add(criticalFunctionLabel, 140, 0);
		criticalFunctionLabel.setWidth("341px");
		bottomLabelPanel.setHeight("12px");
		criticalFunctionLabel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		// criticalFunctionLabel.setText("Hi there Joe Smudley");

		// HorizontalPanel functionLabelPanel = new HorizontalPanel();
		// functionLabelPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		// functionLabelPanel.setWidth("136px");

		// bottomLabelPanel.add(functionLabelPanel, 409, 0);

		bottom.add(bottomLabelPanel);
		bottom.add(criticalFunctionsListBox);
		horizontalPanel_1.add(bottom);
		criticalFunctionsListBox.setWidth("642px");
		criticalFunctionsListBox.setVisibleItemCount(10);

		// Button Bar
		backButton.setText("Back");
		backButton.setStyleName("ButtonClass");
		backButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				redirect("/kcpt/admin/adminHome");
			}
		});
		viewButton.setText("View User-Screen");
		viewButton.setStyleName("ButtonClass");
		viewButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				redirect("/kcpt/plan/getCriticalFunctionExamples");
			}
		});
		saveButton.setText("Save Selections");
		saveButton.setStyleName("ButtonClass");

		saveButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				NamedItem item = new NamedItem();
				item.setId(currentId);
				// Create plan list
				String planString = "";
				String comma = "";
				for (int i = 0; i < examplePlanListBox.getItemCount(); i++) {
					String planId = examplePlanListBox.getValue(i);
					planString += comma + planId;
					comma = ",";
				}
				item.setName(planString);
				item.setCsrfToken(csrfToken.getValue());
				itemService.updateItem("function", item, callbackUpdate);
			}
		});

		buttonBar.add(left, DockPanel.WEST);
		left.setWidth("200px");
		right.setWidth("440px");
		right.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		left.add(backButton);
		right.add(saveButton);
		right.add(viewButton);
		buttonBar.add(right, DockPanel.EAST);

		buttonBar.setSize(screenWidth, "58px");
		dockPanel.add(buttonBar, DockPanel.SOUTH);
		dockPanel.add(horizontalPanel_1, DockPanel.SOUTH);
		// Begin load process.
		// Get Function Example list
		itemService.getItem("function", thisInstitution, callbackLoad);

		// formGrid.addFormItem("Order", orderBox);

	}

	public AsyncCallback callbackUpdate = new AsyncCallback() {

		public void onSuccess(Object arg0) {
			// TODO Call
			flashDone();

		}

		public void onFailure(Throwable arg0) {
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}
		}

	};

	String[][] functionList;
	String[][] selectedExamples;

	public AsyncCallback callbackGetFunctions = new AsyncCallback() {
		public void onSuccess(Object result) {
			String cf[][] = (String[][]) result;
			//Window.alert("Load Critical Functions Call back " + cf.length);
			loadFunctionListBox(cf);
		}

		public void onFailure(Throwable e) {
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}
		}
	};

	/**
	 * We now have the function example data. Loading the main listbox is a
	 * multistep process. First we get the list (function) of plans that have
	 * been selected. Then we proceed to the get the plan.
	 */
	public AsyncCallback callbackLoad = new AsyncCallback() {
		public void onSuccess(Object result) {

			// Now get the plan Array List.
			// Note that this is an actual application,
			// That uses several tables, not
			// just a one-table-per screen
			// Ideally this would be refactored into a single service
			// like roleService.
			NamedItem item = (NamedItem) result;
			// The entry list is stored in the item name.
			exampleString = item.getName();
			currentId = item.getId();
			thisInstitution = item.getSystemDomainId();

			// Window.alert("got list: "+examplePlanListString);
			if (null == exampleString)
				exampleString = "";
			itemService.getStringArray("plan", thisInstitution,
					callbackGetPlans);

		}

		public void onFailure(Throwable e) {
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}
		}
	};

	public void loadFunctionListBox(String cf[][]) {
		int nitems = cf.length;

		criticalFunctionsListBox.clear();
		for (int i = 0; i < nitems; i++) {
			criticalFunctionsListBox.addItem(cf[i][1], cf[i][0]);
		}
	}

	/**
	 * Now The Plan listbox is loaded. If the plan has been selected, the
	 * selected plan is placed in selectedPlanListBox, otherwise it is placed in
	 * availablePlanListBox.
	 */
	public AsyncCallback callbackGetPlans = new AsyncCallback() {
		public void onSuccess(Object result) {

			String[][] planlist = (String[][]) result;
			loadListBoxes(planlist);

		}

		public void onFailure(Throwable e) {
			//Window.alert("Get Plan  error occured:" + e);
			redirect(getLogoutUrlWithParm("3"));
		}
	};
	String exampleString = "";
	HashSet exampleMap = new HashSet();

	public void loadListBoxes(String[][] planList) {
		int nitems = planList.length;
		// if (nitems>40) nitems=40;
		examplePlanListBox.clear();
		availablePlanListBox.clear();
		// Load example map.
		String[] exampleArray = exampleString.split(",");
		exampleMap = new HashSet(Arrays.asList(exampleArray));
		if (planList != null) {
			for (int i = 0; i < nitems; i++) {
				String[] planEntry = (String[]) planList[i];
				// Is the plan id in the
				if (exampleMap.contains(planEntry[0])) {
					examplePlanListBox.addItem(planEntry[1], planEntry[0]);
				} else {
					availablePlanListBox.addItem(planEntry[1], planEntry[0]);
				}
			}

		}

	}

	public AsyncCallback callbackFunctionList = new AsyncCallback() {
		public void onSuccess(Object result) {
			// Now we have the selected Plan Function List
			String[][] functionList = (String[][]) result;
			int nitems = functionList.length;
			criticalFunctionsListBox.clear();
			for (int i = 0; i < nitems; i++) {
				String[] functionEntry = (String[]) functionList[i];
				criticalFunctionsListBox.addItem(functionEntry[1],
						functionEntry[0]);
			}
		}

		public void onFailure(Throwable e) {
			String directLoginCookie = Cookies.getCookie(KUALI_DIRECTLOGIN_COOKIE_KEY);			
			String shibbolethLoginCookie = Cookies.getCookie(SHIBBOLETH_LOGIN_IDP_ID);
			
			if (directLoginCookie != null || shibbolethLoginCookie != null){
				redirect(getWelcomeUrl());
			} else {
				redirect(getLogoutUrlWithParm(SESSION_EXPIRED_ERROR));
			}
		}
	};

	public class ListBoxDC extends ListBox implements SourcesChangeEvents {
		private ChangeListenerCollection changeListeners;

		public ListBoxDC() {
			super();
			this.sinkEvents(Event.ONDBLCLICK);
		}

		public void onBrowserEvent(Event event) {
			super.onBrowserEvent(event);
			int type = DOM.eventGetType(event);
			switch (type) {
			case Event.ONDBLCLICK: {
				if (changeListeners != null) {
					changeListeners.fireChange(this);
				}
				break;
			}
			}
		}

		public void addChangeListener(ChangeListener arg0) {
			if (changeListeners == null)
				changeListeners = new ChangeListenerCollection();
			changeListeners.add(arg0);

		}
	}
}
