package com.andrew.curtain.client.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.TextBox;

public class AdminWidget extends Composite {

	/**
	 *  наименование изображения
	 */
	TextBox imgName = new TextBox();
	
	TextBox categoryName = new TextBox();
	
	final FileUpload fileUpload = new FileUpload();
	
	DecoratorPanel decPanel = new DecoratorPanel();
	
	Button submitBtn = new Button("send data");
	
	public AdminWidget() {
		initWidget(decPanel);
	    // Create a table to layout the form options
	    FlexTable layout = new FlexTable();
	    layout.setCellSpacing(6);
	    FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();
	    
	    // Add a title to the form
	    layout.setHTML(0, 0, "<h1>Add image to DataStore<h1>");
	    cellFormatter.setColSpan(0, 0, 2);
	    cellFormatter.setHorizontalAlignment( 0, 0, HasHorizontalAlignment.ALIGN_CENTER);
	    
	    // Add some standard form options
	    layout.setHTML(1, 0, "Add image name");
	    layout.setWidget(1, 1, imgName);
	    layout.setHTML(2, 0, "Add form name");
	    layout.setWidget(2, 1, categoryName);
	    cellFormatter.setColSpan(3, 0, 2);
	    layout.setWidget(3, 0, fileUpload);
	   
//	    submitBtn.addClickHandler(handler);
	    Element buttonElement = submitBtn.getElement();
	    Event.sinkEvents(buttonElement, Event.ONCLICK);
	    Event.setEventListener(buttonElement, new EventListener() {

	        @Override
	        public void onBrowserEvent(Event event) {
	             if(Event.ONCLICK == event.getTypeInt()) {
	                 Window.alert("ok");
	             }

	        }
	    });
	    submitBtn.setWidth("85px");
	    layout.setWidget(4, 1, submitBtn);
	    
	    // Wrap the content in a DecoratorPanel
	    decPanel.setWidget(layout);
	   
	}

}
