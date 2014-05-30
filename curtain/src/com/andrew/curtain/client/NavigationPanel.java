package com.andrew.curtain.client;

import com.andrew.curtain.client.widget.AdminWidget;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NavigationPanel extends StackPanel {
	
	Document contentPlace;
	
	public NavigationPanel(Document contentPlace) {
		this.contentPlace = contentPlace;
		init();
	}
	
	private void init() {
		this.add(new Label("First"), "главная");
		VerticalPanel secPanel = new VerticalPanel();
		Anchor adminpage = new Anchor("admin page");
		adminpage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AdminWidget adminka = new AdminWidget(); 
				contentPlace.getElementById("contentContainer").removeAllChildren();
				contentPlace.getElementById("contentContainer").appendChild(adminka.getElement());
			}
		});
		secPanel.add(adminpage);
		secPanel.add(new Label("Second 2"));
		secPanel.add(new Label("Second 3"));
		secPanel.add(new Label("Second 4"));
		this.add(secPanel, "каталог");
		this.add(new Label("Third"), "Полезная информ.");
	}

}
