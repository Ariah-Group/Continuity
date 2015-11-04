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

import org.kuali.continuity.admin.main.client.controls.RichTextToolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;

public class Faq extends SimpleGridViewer {

	
	// Screen elements for Dependency.
	// HtmlEditor htmlEditor1 = new HtmlEditor("Question", "question");  
	// HtmlEditor htmlEditor2 = new HtmlEditor("Answer", "answer"); 
	RichTextArea richBox1 = new RichTextArea();
	RichTextArea richBox2 = new RichTextArea();
	
	final ListBox type = new ListBox();
	int[] gcsize = { 40, 200, 200};

    // Grid setup	
	public ColumnConfig orderColumn = new ColumnConfig("Order", "order",
			gcsize[0], true);
	public ColumnConfig questionCol = new ColumnConfig("Question", "question",
			gcsize[0], true);
	
	public ColumnConfig answerCol = new ColumnConfig("Answer", "answer",
			gcsize[2], true);
	
	
	ColumnModel columnModel = new ColumnModel(new ColumnConfig[] {  orderColumn, questionCol, answerCol  });
	
	// Service

	int textht=150;
	RecordDef recordDef = new RecordDef(new FieldDef[] { new StringFieldDef("id"),
			new StringFieldDef("question"), new StringFieldDef("answer"),  new IntegerFieldDef("order") });

	public void onModuleLoad()  {
		// Grid
		String proxyUrl="./items.lst";
		// gpheight="250px";
		Element dataelement = DOM.getElementById("dataelement");
		itemRootName=dataelement.getTitle();
		this.formController=fc;
		itemService = (ItemServiceAsync) GWT.create(ItemService.class);
		
	    onModuleLoad("FAQs", proxyUrl, columnModel, recordDef);
		// questionCol.setCss("white-space:wrap !important;");
		// answerCol.setCss("white-space:wrap !important;");	
		// Buttons

		setButtonNames("FAQ");
		
		// Heading
		String plural="Frequently Asked Questions";
		setHeadingName(plural+" Setup");

		// Form
        // Fields: Order
        HorizontalPanel formdata = new HorizontalPanel();
        formdata.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);  
        flexForm.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
        flexForm.addIdentifiedItem(new HTML("<B>Order</B>"), orderBox);
        formPanel.add(formdata);
	    // Create Rich Text Area
		richBox1.ensureDebugId("cwRichText-area");
		richBox1.setSize("642px", "6em");
		richBox1.setStyleName("select");
		richBox1.setStylePrimaryName("select");
		
		
		RichTextToolbar toolbar1 = new RichTextToolbar(richBox1);
		
		toolbar1.ensureDebugId("cwRichText-toolbar");
		toolbar1.setWidth("642px");
		Grid grid1 = new Grid(2, 1);
		grid1.setStyleName("cw-RichText");
		grid1.setWidget(0, 0, toolbar1);
		grid1.setWidget(1, 0, richBox1);
		
		flexForm.addRow();
		flexForm.addIdentifiedItemVertical(new HTML("<B>Question</B>"), grid1);
		richBox2.ensureDebugId("cwRichText-area");
		richBox2.setSize("642px", "8em");
		richBox2.setStyleName("r-text");
		RichTextToolbar toolbar2 = new RichTextToolbar(richBox2);
		toolbar2.ensureDebugId("cwRichText-toolbar");
		toolbar2.setWidth("642px");
		Grid grid2 = new Grid(2, 1);
		grid2.setStyleName("cw-RichText");
		grid2.setWidget(0, 0, toolbar2);
		grid2.setWidget(1, 0, richBox2);
		flexForm.addRow();
		flexForm.addIdentifiedItemVertical(new HTML("<B>Answer</B>"), grid2);
		flexForm.registerWidget(richBox1);
		flexForm.registerWidget(richBox2);
      	itemRootName="faq";

      	// set token
      	String token = Cookies.getCookie(CSRF_TOKEN);
      	csrfToken.setValue(token);
      	flexForm.registerWidget(csrfToken);
		
	}
	FaqController fc = new FaqController();
    class FaqController extends SimpleFormController {


    	public void showController() {
        	Window.alert("Faq");
        }

    	public boolean formLoad(Object result) {
			FaqItem item = (FaqItem) result;

			
			richBox1.setHTML(htmlLeader+item.getName()+htmlTrailer);
			richBox2.setHTML(htmlLeader+item.getAnswer()+htmlTrailer);
//			richBox1.setHTML(item.getQuestion());
//			richBox2.setHTML(item.getAnswer());
					
			orderBox.setText(item.getOrder());
			return true;
		}
		public NamedItem validateSave(NamedItem namedItem) {
			FaqItem item = new FaqItem();
			item.setQuestion(richBox1.getHTML());
			item.setAnswer(richBox2.getHTML());
			item.setCsrfToken(csrfToken.getValue());
			String orderStr = orderBox.getText();
			if (orderStr.trim().isEmpty()) orderStr = "999";  // max 3 digit int
			item.setOrder(orderStr);
			return (NamedItem) item;
		}

		

    };

}
