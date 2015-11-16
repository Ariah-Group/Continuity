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

import java.util.HashMap;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Location extends SimpleGridViewerS {

	final ListBox locationList = new ListBox();
	final TextBox instBox = new TextBox();
	final TextBox customUrlBox = new TextBox();
	
    String thisLocType = "";
	final ListBox access = new ListBox();
    
	final TextBox idpBox = new TextBox();
	final TextBox shibUniqueIdBox = new TextBox();
	final ListBox loginMethod = new ListBox();
	
	final FileUpload imgUpload1 = new FileUpload();
	final FileUpload imgUpload2 = new FileUpload();
	final FileUpload imgUpload3 = new FileUpload();
	final FileUpload imgUpload4 = new FileUpload();
	
	final Button imgInstallButton1 = new Button("Install Image");
	final Button imgInstallButton2 = new Button("Install Image");
	final Button imgInstallButton3 = new Button("Install Image");
	final Button imgInstallButton4 = new Button("Install Image");
	final Button imgRestoreButton1 = new Button("Restore Default Image");
	final Button imgRestoreButton2 = new Button("Restore Default Image");
	final Button imgRestoreButton3 = new Button("Restore Default Image");
	final Button imgRestoreButton4 = new Button("Restore Default Image");

	final Hidden systemDomainId = new Hidden("systemDomainId");
	final Hidden systemDomainAccess = new Hidden("systemDomainAccess");
	final Hidden restore = new Hidden("restore");
	final Hidden uiImageEnum = new Hidden("uiImageEnum");
	
	int[] gcsize = { 75, 120, 50, 50, 0, 0 };

	public ColumnConfig groupCol = new ColumnConfig("Institution",
			"group", gcsize[0], true);
	public ColumnConfig locationCol = new ColumnConfig("Location",
			"name", gcsize[1], true);
//	public ColumnConfig sublocationCol = new ColumnConfig("Sublocation",
//			"subLocation", gcsize[1], true);

//	public ColumnConfig typeCol = new ColumnConfig("Type", "typestr", gcsize[2],
//			true);
	public ColumnConfig accessCol = new ColumnConfig("Access", "accessstr",
			gcsize[3], true);

	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] { groupCol, locationCol,
//			sublocationCol, typeCol, 
			accessCol });
	RecordDef recordDef = new RecordDef(new FieldDef[] {
			new StringFieldDef("id"), new StringFieldDef("group"), 
			new StringFieldDef("parentSystemDomainName"),
			new StringFieldDef("name"),
			new StringFieldDef("typestr"),
			new StringFieldDef("accessstr"), new StringFieldDef("order") });
	int thisAuthId =0;
	
	HashMap<String, String> systemAccessIndex = new HashMap<String, String>();
	
	public void onModuleLoad() {
		
		this.formController = lfc;
		this.setElementNames(columnModel, recordDef);
		
		// labels
		Label lblIns = new Label("Institution");
		Label lblLoc = new Label("Location");
		Label lblAcc = new Label("Access");
		Label lblCus = new Label("User Friendly Url:");
		Label lblCs1 = new Label("https://us.ready.kuali.org/");
		Label lblLog = new Label("Login Method");
		Label lblIdp = new Label("IDP");
		Label lblIdi = new Label("Shibboleth unique attribute");
		lblIns.setStyleName("gwt-HTML-location");
		lblLoc.setStyleName("gwt-HTML-location");
		lblAcc.setStyleName("gwt-HTML-location");
		lblCus.setStyleName("gwt-HTML-location");
		lblCs1.setStyleName("gwt-HTML-location");
		lblLog.setStyleName("gwt-HTML-location");
		lblIdp.setStyleName("gwt-HTML-location");
		lblIdi.setStyleName("gwt-HTML-location");
		
		instBox.setWidth("100px");
        textBox.setWidth("180px");
		customUrlBox.setWidth("100px");
		idpBox.setWidth("350px");
		shibUniqueIdBox.setWidth("350px");

		// enable text boxes
		enableTextBox(instBox, true);
		enableTextBox(textBox, true);
		enableTextBox(customUrlBox, true);
		enableTextBox(idpBox, false);
		enableTextBox(shibUniqueIdBox, false);
		
        // access
        access.setVisibleItemCount(1);
		access.addItem("System Admin Only", "0");
		access.addItem("System and Institutional Admins Only", "3");
		access.addItem("Admins Only", "1");
		access.addItem("All Users", "2");
		systemAccessIndex.put("0", "0"); // For System Admins
		systemAccessIndex.put("3", "1"); // For System and Insitutional
		systemAccessIndex.put("1", "2"); // For Admins
		systemAccessIndex.put("2", "3"); // For All Users

		
		// login method
		loginMethod.setVisibleItemCount(1);
		loginMethod.addItem("Direct Login", "0");
		loginMethod.addItem("Shibboleth Login", "1");
		loginMethod.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				showErr(false);
				int idx = loginMethod.getSelectedIndex();
				enableShibTextBoxes(idx);
			}
		});

		// tables
		FlexTable formTable = new FlexTable();
		formTable.setStylePrimaryName("location-form");
		formTable.setWidget(0, 0, lblIns);
		formTable.setWidget(0, 1, instBox);
		formTable.setWidget(0, 2, lblLoc);
		formTable.setWidget(0, 3, textBox);
		formTable.getFlexCellFormatter().setColSpan(1, 0, 4);
		formTable.setWidget(1, 0, lblCus);
		formTable.setWidget(2, 0, lblCs1);
		formTable.setWidget(2, 1, customUrlBox);
		formTable.setWidget(2, 2, lblAcc);
		formTable.setWidget(2, 3, access);
		
		FlexTable shibTable = new FlexTable();
		shibTable.setStylePrimaryName("location-shib-form");
		shibTable.setWidget(0, 0, lblLog);
		shibTable.setWidget(0, 1, loginMethod);
		shibTable.setWidget(0, 2, lblIdp);
		shibTable.setWidget(0, 3, idpBox);
		shibTable.setWidget(1, 0, new Label(" "));
		shibTable.setWidget(1, 1, new Label(" "));
		shibTable.setWidget(1, 2, lblIdi);
		shibTable.setWidget(1, 3, shibUniqueIdBox);
		
		flexForm.add(formTable);
		flexForm.add(shibTable);
		itemRootName = "location";

		// set token
		String token = Cookies.getCookie(CSRF_TOKEN);
		csrfToken.setValue(token);
		flexForm.registerWidget(csrfToken);
		
		this.doExtraSectionLoad();
	}
    /**
     * The LocationFormController has special formatting tasks.  

     *  
     * @author richkatz
     *
     */
	class LocationFormController extends SimpleFormController {
		
		/**
         * 	For sublocation: Load the pull-down (if not already loaded) 
         * 		Point to the current item.   And display the pulldown.
         *      
         *  For main location the parent is loaded into instBox.
         *      And display the textbox.
		 */
		public boolean formLoad(Object result) {
			
			LocationItem item = (LocationItem) result;
			instBox.setText(item.getGroup());
			textBox.setText(item.getName());
			customUrlBox.setText(item.getCustomUrl());
			access.setItemSelected(Integer
				.parseInt((String) systemAccessIndex.get(item.getAccess())), true);
			thisAuthId=item.getAuthId();
			thisLocType=item.getTypestr();
			
			idpBox.setText(item.getAuthLocation());
			shibUniqueIdBox.setText(item.getShibUniqueId());
			if (item.isShibMode()){
				loginMethod.setSelectedIndex(1);
			} else{
				loginMethod.setSelectedIndex(0);
			}
			enableShibTextBoxes(loginMethod.getSelectedIndex());
			
			systemDomainId.setValue("" + item.getAuthId());
			systemDomainAccess.setValue(access.getValue(access.getSelectedIndex()));
			
			// set visible
			imgRestoreButton1.setVisible(item.isCustomImage1());
			imgRestoreButton2.setVisible(item.isCustomImage2());
			imgRestoreButton3.setVisible(item.isCustomImage3());
			imgRestoreButton4.setVisible(item.isCustomImage4());

			return true;
		}

		
		/**
		 * validateSave
		 * For items of type 
		 * 		Member  - set the name to the subLocation.
		 * 		Primary - set the name to the Main location.
		 *     
		 */
		@Override
		public NamedItem validateSave(NamedItem item) {

			LocationItem it = new LocationItem();
			it.setTypestr(thisLocType);

			it.setName(textBox.getText());
			it.setGroup(instBox.getText());
			it.setCustomUrl(customUrlBox.getText());
			it.setCsrfToken(csrfToken.getValue());
			
		
			it.setAuthId(thisAuthId);  // This means the parent ID.
			it.setAccess(access.getValue(access.getSelectedIndex()));
//            Window.alert(
//            		 it.getName()
//            		 +" "+it.getAccess()
//            		 +" "+it.getTypestr()
//            		 +" "+it.getAuthId());
						
			
			if(loginMethod.getSelectedIndex() == 0){
				it.setShibMode(false);
				it.setAuthLocation(idpBox.getText());
				it.setShibUniqueId(shibUniqueIdBox.getText());
			} else{
				it.setShibMode(true);
				it.setAuthLocation(idpBox.getText());
				it.setShibUniqueId(shibUniqueIdBox.getText());
			}
			
			if (buttonPressed.equals("delete")) {
				mainerror="Institution/Location is in use and may not be deleted.";
				 //  Previous mainerror="Unable to delete location that has plans or user. Please delete all plans and users first.";
			}
			if (buttonPressed.equals("insert")) { 
				  // Check for duplicates.
				  int nitems=store.getTotalCount();
				  for (int i =0;i<nitems;i++) {
					  Record rec = store.getRecordAt(i);
					  String thisname=rec.getAsString("name");
					  if (it.getName().equals(thisname)) {
						  // Duplicate found.
						 // Window.alert("Potential duplicate location "+thisname+" already exists.");
						  String tableGroup=rec.getAsString("group");
						  String newGroup = it.getGroup();
						  // Window.alert("Table: "+tableGroup+"  new "+newGroup+ " "+isEmpty(tableGroup)+" "+isEmpty(newGroup));
						  if(it.getGroup().equals(tableGroup) || (isEmpty(tableGroup) && isEmpty(newGroup)) ) {
							  mainerror="Location "+newGroup+" : "+thisname+" already exists.";
							  setError(mainerror);
							  // showErr(true);
							  // Window.alert("Location "+rec.getAsString("group")+" : "+thisname+" already exists.");
							  it=null;
						  }
					  }

				  }
				  // Check for empty Location.
				  if(it.getName().trim().length()==0) {
					  mainerror="Location must not be empty.";
					  setError(mainerror);
					  return null;
				  }
				  
				// Check for empty Institution.
				  if(it.getGroup().trim().length()==0) {
					  mainerror="Institution must not be empty.";
					  setError(mainerror);
					  return null;
				  }
			} else if (buttonPressed.equals("update")) { 
				  if(it.getName().trim().length()==0) {
					  mainerror="Location must not be empty.";
					  setError(mainerror);
					  return null;
				  }
				  
				 // Check for empty Institution.
				  if(it.getGroup().trim().length()==0) {
					  mainerror="Institution must not be empty.";
					  setError(mainerror);
					  return null;
				  }			
			}
			return it;
		}
	}
	
    boolean isEmpty(String s) {
    	boolean ret=false;
    	if (null==s || s.trim().length()==0) {
    		ret=true;
    	}
    	return ret;
    }
	LocationFormController lfc = new LocationFormController();
	
	void enableShibTextBoxes(int index) {
		if (index == 0) {
			enableTextBox(idpBox, false);
			enableTextBox(shibUniqueIdBox, false);
		} else {
			enableTextBox(idpBox, true);
			enableTextBox(shibUniqueIdBox, true);
		}
		
	}

	void enableTextBox(TextBox t, boolean enabled) {
		t.setEnabled(enabled);
		t.setReadOnly(!enabled);
		String primarycolor = "gandalfwhite";
		if (!enabled) {
			primarycolor = "gandalfgrey";

		}
		t.setStylePrimaryName(primarycolor);
		t.setStyleName(primarycolor);

	}
	
	protected void clearThisForm() {
		instBox.setText("");
        textBox.setText("");
		customUrlBox.setText("");
		idpBox.setText("");
		shibUniqueIdBox.setText("");
		access.setSelectedIndex(0);
		loginMethod.setSelectedIndex(0);
	}
	
	protected void doExtraSectionLoad() {
		// init form
		final VerticalPanel vPanel = new VerticalPanel();
		final FormPanel formPanel = new FormPanel();
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		formPanel.setAction(Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/continuity/admin/customImageUpload");
		
		// set form handler
		formPanel.addFormHandler(new FormHandler()
		{
		    public void onSubmit(FormSubmitEvent event) {
		        // event.setCancelled(true);
		    }

		    public void onSubmitComplete(
		        FormSubmitCompleteEvent event) {
		    	boolean isRestore = restore.getValue().equals("true");
		    	if (uiImageEnum.getValue().equals("BEGIN")) {
		    		imgRestoreButton1.setVisible(!isRestore);
		    	} else if (uiImageEnum.getValue().equals("BEGIN_TEXT")) {
		    		imgRestoreButton2.setVisible(!isRestore);
		    	} else if (uiImageEnum.getValue().equals("BANNER")) {
		    		imgRestoreButton3.setVisible(!isRestore);
		    	} else if (uiImageEnum.getValue().equals("BANNER_TEXT")) {
		    		imgRestoreButton4.setVisible(!isRestore);
		    	}
				csrfToken.setValue(Cookies.getCookie(CSRF_TOKEN));
				String message = isRestore ? "Default image restored!" : "Custom image upload completed!";
				Window.alert(message);
		    }
		});

		// custom image labels
		Label lblImg1 = new Label("Entry screen top image:");
		Label lblImg2 = new Label("Entry screen bottom image:");
		Label lblImg3 = new Label("Banner left image:");
		Label lblImg4 = new Label("Banner right image:");
		Label lblImgDim1 = new Label("Recommended dimensions:  700 pixels x 200 pixels");
		Label lblImgDim2 = new Label("Recommended dimensions:  700 pixels x 100 pixels");
		Label lblImgDim3 = new Label("Recommended height:  80 pixels");
		Label lblImgDim4 = new Label("Recommended height:  80 pixels");
		
		// styles
		lblImg1.setStyleName("gwt-HTML-location-bold");
		lblImg2.setStyleName("gwt-HTML-location-bold");
		lblImg3.setStyleName("gwt-HTML-location-bold");
		lblImg4.setStyleName("gwt-HTML-location-bold");
		lblImgDim1.setStyleName("gwt-HTML-location");
		lblImgDim2.setStyleName("gwt-HTML-location");
		lblImgDim3.setStyleName("gwt-HTML-location");
		lblImgDim4.setStyleName("gwt-HTML-location");

		// entry fields
		imgInstallButton1.setStyleName("ButtonClass");
		imgInstallButton2.setStyleName("ButtonClass");
		imgInstallButton3.setStyleName("ButtonClass");
		imgInstallButton4.setStyleName("ButtonClass");
		imgRestoreButton1.setStyleName("ButtonClass");
		imgRestoreButton2.setStyleName("ButtonClass");
		imgRestoreButton3.setStyleName("ButtonClass");
		imgRestoreButton4.setStyleName("ButtonClass");
		imgUpload1.setStyleName("ButtonClass");
		imgUpload2.setStyleName("ButtonClass");
		imgUpload3.setStyleName("ButtonClass");
		imgUpload4.setStyleName("ButtonClass");
		imgUpload1.setWidth("300px");
		imgUpload2.setWidth("300px");
		imgUpload3.setWidth("300px");
		imgUpload4.setWidth("300px");
		imgUpload1.setName("uploadedImg1");
		imgUpload2.setName("uploadedImg2");
		imgUpload3.setName("uploadedImg3");
		imgUpload4.setName("uploadedImg4");

		// construct table
		FlexTable imageTable = new FlexTable();
		imageTable.setStylePrimaryName("location-form");

		imageTable.getFlexCellFormatter().setColSpan(0, 0, 3);
		imageTable.setWidget(0, 0, lblImg1);
		imageTable.getFlexCellFormatter().setColSpan(1, 0, 3);
		imageTable.setWidget(1, 0, lblImgDim1);
		imageTable.setWidget(2, 0, imgUpload1);
		imageTable.setWidget(2, 1, imgInstallButton1);
		imageTable.setWidget(2, 2, imgRestoreButton1);
		
		imageTable.getFlexCellFormatter().setColSpan(3, 0, 3);
		imageTable.setWidget(3, 0, lblImg2);
		imageTable.getFlexCellFormatter().setColSpan(4, 0, 3);
		imageTable.setWidget(4, 0, lblImgDim2);
		imageTable.setWidget(5, 0, imgUpload2);
		imageTable.setWidget(5, 1, imgInstallButton2);
		imageTable.setWidget(5, 2, imgRestoreButton2);

		imageTable.getFlexCellFormatter().setColSpan(6, 0, 3);
		imageTable.setWidget(6, 0, lblImg3);
		imageTable.getFlexCellFormatter().setColSpan(7, 0, 3);
		imageTable.setWidget(7, 0, lblImgDim3);
		imageTable.setWidget(8, 0, imgUpload3);
		imageTable.setWidget(8, 1, imgInstallButton3);
		imageTable.setWidget(8, 2, imgRestoreButton3);

		imageTable.getFlexCellFormatter().setColSpan(9, 0, 3);
		imageTable.setWidget(9, 0, lblImg4);
		imageTable.getFlexCellFormatter().setColSpan(10, 0, 3);
		imageTable.setWidget(10, 0, lblImgDim4);
		imageTable.setWidget(11, 0, imgUpload4);
		imageTable.setWidget(11, 1, imgInstallButton4);
		imageTable.setWidget(11, 2, imgRestoreButton4);
		
		imageTable.setWidget(12, 0, systemDomainId);
		imageTable.setWidget(12, 1, restore);
		imageTable.setWidget(12, 2, uiImageEnum);

		// button click listener
		imgInstallButton1.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload1, false, "BEGIN");
			}
		});
		imgInstallButton2.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload2, false, "BEGIN_TEXT");
			}
		});
		imgInstallButton3.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload3, false, "BANNER");
			}
		});
		imgInstallButton4.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload4, false, "BANNER_TEXT");
			}
		});
		imgRestoreButton1.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload1, true, "BEGIN");
			}
		});
		imgRestoreButton2.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload2, true, "BEGIN_TEXT");
			}
		});
		imgRestoreButton3.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload3, true, "BANNER");
			}
		});
		imgRestoreButton4.addClickListener(new ClickListener() {
			public void onClick(final Widget sender) {
				customImageFormSubmit(formPanel, imgUpload4, true, "BANNER_TEXT");
			}
		});
		
		// vertical panel
		vPanel.setStylePrimaryName("location-shib-form");
		vPanel.add(new HTML("<h1>Upload Custom Images</h1>"));
		vPanel.add(new HTML("To upload custom images, highlight the row on the grid then use the entry form below to upload your images."));
		
		// add table to form
		formPanel.add(imageTable);
		vPanel.add(formPanel);
		
		// dock form
//		dockPanel.add(vPanel, DockPanel.SOUTH);
		RootPanel rootPanel = RootPanel.get("gwtRoot");
		rootPanel.add(vPanel);
	}
	
	protected void customImageFormSubmit(FormPanel formPanel, FileUpload fileUpload, boolean isRestore, String uiImageEnumValue) {
		// check location
		if (systemDomainId.getValue() == null || systemDomainId.getValue().trim().length() == 0) {
			Window.alert("Please select your location first from the location grid.");
			return;
		}
		
		if (systemDomainAccess.getValue().equals("2")) {
			boolean ok = Window.confirm("Access is set to 'All Users'.  Do you wish to proceed?");
			if (!ok) return;
		}
		
		if (!isRestore) {
			// check file
			String fileName = fileUpload.getFilename().toLowerCase();
			if (fileName == null || fileName.trim().length() == 0) {
				Window.alert("Please enter image to upload.");
				return;
			}
			
			int lastIndex = fileName.lastIndexOf('.');
			if (lastIndex < 0) {
				Window.alert("Invalid image file");
				return;
			} 
			
			if (!(fileName.endsWith("gif") || 
				fileName.endsWith("jpeg") || 
				fileName.endsWith("jpg") || 
				fileName.endsWith("tiff") || 
				fileName.endsWith("bmp") || 
				fileName.endsWith("png"))) {
				Window.alert("Invalid image file");
				return;
			}
		}
		
		restore.setValue(isRestore ? "true" : "false");
		uiImageEnum.setValue(uiImageEnumValue);
		
		formPanel.submit();
	}
}
