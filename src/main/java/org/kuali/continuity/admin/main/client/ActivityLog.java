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

// import com.google.code.p.gwtchismes.client.GWTCDatePicker;

import java.util.Date;

import com.google.code.p.gwtchismes.client.GWTCDatePicker;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class ActivityLog extends SimpleGridViewerSAL {

	String datePattern = "MM/dd/yyyy";

	final TextBox acronym = new TextBox();

	final ListBox access = new ListBox();

	int[] gcsize = { 180, 50, 50, 50, 0, 0 };
	public ColumnConfig planNameCol = new ColumnConfig("Plan Name", "name",
			gcsize[0], true);

	public ColumnConfig actDateCol = new ColumnConfig("Date", "actDate",
			gcsize[1], true);
	public ColumnConfig actionCol = new ColumnConfig("Action", "fullName",
			gcsize[1], true);

	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { planNameCol,
			actDateCol, actionCol });
	RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("id"), new StringFieldDef("name"),
			new StringFieldDef("actDate"), new StringFieldDef("fullName"),
			new StringFieldDef("order") });
	String[] w = { "310px", "85px", "85px" };
	String[] w2 = { "325px", "95px", "95px" };
	final Image showActivityButton = new Image("ShowActivity.gif");
	final Image dateChooserS = new Image("DateChooser.png");
	final Image dateChooserE = new Image("DateChooser.png");
	Label planSearchStatus = new Label("");

	// date picker options
	int options = GWTCDatePicker.CONFIG_DIALOG
			| GWTCDatePicker.CONFIG_FLAT_BUTTONS
			| GWTCDatePicker.CONFIG_NO_HELP_BUTTON;

	// Date Picker
	final GWTCDatePicker startDatePicker = new GWTCDatePicker(options);
	final GWTCDatePicker endDatePicker = new GWTCDatePicker(options);

	ClickListener startDateClickListener;
	ClickListener endDateClickListener;

	String planStatusFmt = "This plan is currently in (%s) status";

	public void onModuleLoad() {
		// Grid
		String proxyUrl = "./items.lst";
		final DateTimeFormat dateFormater = DateTimeFormat
				.getFormat(datePattern);

		startDatePicker.setMinimalDate(dateFormater.parse("01/01/1901"));
		endDatePicker.setMinimalDate(dateFormater.parse("01/01/1901"));
		
		// set default dates
		Date startDefDate = new Date();
		Date endDefDate = new Date();
		int startDefMonth = startDefDate.getMonth() - 1;
		startDefDate.setMonth(startDefMonth);
		startDatePicker.setSelectedDate(startDefDate);
		endDatePicker.setSelectedDate(endDefDate);
		startDate.setText(DateTimeFormat.getFormat("MM/dd/yyyy").format(startDefDate));
		endDate.setText(DateTimeFormat.getFormat("MM/dd/yyyy").format(endDefDate));

		startDatePicker.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				Date date = startDatePicker.getSelectedDate();
				startDate.setText(dateFormater.format(date));
				startDatePicker.hide();

			}
		});

		endDatePicker.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				Date date = endDatePicker.getSelectedDate();
				endDate.setText(dateFormater.format(date));
				endDatePicker.hide();
			}
		});
		startDate.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				Date d1 = getDateFromString(((TextBox) sender).getText());
				((TextBox) sender).setText(formatDate(d1));
			}
		});
		endDate.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				Date d1 = getDateFromString(((TextBox) sender).getText());
				((TextBox) sender).setText(formatDate(d1));
			}
		});
		ClickListener startDateClickListener = new ClickListener() {
			public void onClick(Widget sender) {
				startDatePicker.show();
			}
		};

		ClickListener endDateClickListener = new ClickListener() {
			public void onClick(Widget sender) {
				endDatePicker.show();
			}
		};

		dateChooserS.addClickListener(startDateClickListener);
		dateChooserE.addClickListener(endDateClickListener);

		this.formController = sf;
		this.showButtonRow = false;
		String formItemName = this.setElementNames(columnModel, recordDef);
		planSearchStatus.setStyleName("ShowInfoClass");
		// Form

		Label lab1 = new Label("Plan Name");
		lab1.setWidth(w[0]);
		Label lab2 = new Label("Start");
		lab2.setWidth(w[1]);
		Label lab3 = new Label("End");
		lab3.setWidth(w[2]);

		// flexForm.addFormItem("",lab1);
		// flexForm.addFormItem("",lab2);
		// flexForm.addFormItem("",lab3);
		//		
		// flexForm.addRow();
		//		

		textBox.setMaxLength(120);
		planListBox.setWidth(w[0]);
		textBox.setWidth(w[0]);

		startDate.setMaxLength(10);
		startDate.setWidth(w[1]);
		String marginstr = "&nbsp;";
		HTML margin = new HTML(marginstr);
		HorizontalPanel sdp = new HorizontalPanel();
		sdp.setWidth(w2[1]);
		HorizontalPanel edp = new HorizontalPanel();
		HorizontalPanel bdp = new HorizontalPanel();
		bdp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		sdp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		sdp.add(startDate);
		sdp.add(margin);
		sdp.add(dateChooserS);

		sdp.add(margin);

		edp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		edp.add(endDate);
		edp.add(margin);
		edp.add(dateChooserE);
		edp.add(margin);
		edp.setWidth(w2[2]);
		endDate.setMaxLength(10);
		endDate.setWidth(w[2]);
		((FlexFormPanel) flexForm).currentMargin = "   ";
		flexForm.setWidth("621px");
		HorizontalPanel pdp = new HorizontalPanel();
		pdp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		pdp.setWidth(w[0]);
		pdp.add(planListBox);
		flexForm.addVerticalItem("Plan Name", pdp, w[0]);

		flexForm.addVerticalItem(marginstr, margin, "2px");
		flexForm.addVerticalItem("Start", sdp, w2[1]);
		flexForm.addVerticalItem(marginstr, margin, "2px");
		flexForm.addVerticalItem("End", edp, w2[2]);
		flexForm.addVerticalItem(marginstr, margin, "2px");
		bdp.add(showActivityButton);

		HorizontalPanel fdp = new HorizontalPanel();
		fdp.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		fdp.setWidth("" + showActivityButton.getWidth() + "px");
		fdp.add(showActivityButton);
		flexForm.addVerticalItem("&nbsp;", fdp, "60px");

		// flexForm.addFormItem(" ",textBox);
		// flexForm.addFormItem(" ", startDate);
		// flexForm.addFormItem(" ", endDate);
		// flexForm.add(showActivityButton);

		flexForm.addRow();
		flexForm.add(planSearchStatus);
		// planSearchStatus.setText(getPlanStatus("Complete"));
		planSearchStatus.setText("");
		planSearchStatus.setStylePrimaryName("ShowInfoClass");
		showActivityButton.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				showErr(false);
				boolean oktogo = Window.confirm("Search for Activities: from"
						+ startDate.getText() + " through " + endDate.getText()
						+ "?");
				if (oktogo) {
					String planId = planListBox.getValue(planListBox
							.getSelectedIndex());
					String planStatusId = (String) statusMap.get(planId);
					String planStatus = "Complete";
					if (!planStatusId.equals("C")) {
						planStatus = "In-Progress";
					}
					planSearchStatus.setText(getPlanStatus(planStatus));
					gridLoad(1, 1, "id", "activitylog", store);

				}

			}
		});
		itemRootName = "deptplan";
		
		planListBox.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				// display status
				String planId = planListBox.getValue(planListBox
						.getSelectedIndex());
				if ("0".equals(planId)) {
					planSearchStatus.setText("");
					return;
				}
				String planStatusId = (String) statusMap.get(planId);
				String planStatus = "In-Progress";
				if ("C".equals(planStatusId))
					planStatus = "Complete";
				else if ("D".equals(planStatusId))
					planStatus = "Deleted";
				planSearchStatus.setText(getPlanStatus(planStatus));
			}
		});
		
		itemService.getStringArray(itemRootName, institutionId, callbackPload);

	}

	public String getPlanStatus(String status) {
		// JDK 6 String ret= String.format(planStatusFmt,status);
		String ret = "This plan is currently in (" + status + ") status";
		return ret;
	}

	SimpleFormController sf = new SimpleFormController() {
		@Override
		public boolean formLoad(Object result) {
			boolean ret = true;
			AcronymItem item = (AcronymItem) result;
			currentId = item.getId();
			textBox.setText(item.getName());
			startDate.setText(item.getFullName());
			return ret;
		}

		@Override
		public NamedItem validateSave(NamedItem item) {
			AcronymItem it = new AcronymItem();
			it.setName(textBox.getText());
			it.setFullName(startDate.getText());

			return (NamedItem) it;
		}

	};

	// Load plans into Listbox. Call during onModuleLoad.
	public AsyncCallback callbackPload = new AsyncCallback() {
		public void onSuccess(Object result) {
			String[][] rs = (String[][]) result;
			planListBox.clear();
			planListBox.addItem("Please select...", "0");
			loadListBox(planListBox, (String[][]) result, true);
			itemRootName = "activitylog";
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
	// Column 0 is description, column 1 is value.

}
