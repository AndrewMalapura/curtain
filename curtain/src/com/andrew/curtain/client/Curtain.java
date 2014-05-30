package com.andrew.curtain.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.andrew.curtain.client.resources.Resources;
import com.andrew.curtain.client.widget.ImageViewer;
import com.andrew.curtain.client.widget.SitePage;
import com.andrew.curtain.server.jdo.MenuJDO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
//import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Curtain implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	@SuppressWarnings("unused")
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final ReceivingServiceAsync receivingService = GWT
			.create(ReceivingService.class);

	Resources resources = GWT.create(Resources.class);
	
	Document view;
	MainMenu menu;
	StackPanel navigationPanel;
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
     
     SitePage mainPage = new SitePage("ГЛАВНАЯ СТРАНИЦА");
     view =  Document.get();
     view.getElementById("contentContainer").appendChild(mainPage.getElement());
     menu = new MainMenu();
     menuInit();
     navigationPanel = new NavigationPanel(view);
	//     view.getElementById("menuPlace").appendChild(menu.getElement());
     RootPanel.get("menuPlace").add(menu);
     RootPanel.get("vertMenuContainer").add(navigationPanel);
	}
	
	private void menuInit() {
		MenuItem mainMenu = menu.getMainPageItem();
		mainMenu.setScheduledCommand(viewMainPage);
		
		MenuBar gallerySubMenu = menu.getWorksPageItem().getSubMenu();
		Set<String> gKeys = menu.items.galeryMap().keySet();
		for(String key: gKeys) {
			gallerySubMenu.addItem(new MenuItem(key, viewGallery));
		}

		
		// create info sub menu
		MenuBar infoSubMenu = menu.getInformPageItem().getSubMenu();
		Map<String, String> subInfo = menu.items.infoMap();
		Set<String> keys = subInfo.keySet();
		for(String key: keys){
//				String text = getTextPage(subInfo.get(key));
//				HTML html_page = new HTML(text);
				infoSubMenu.addItem(key, viewInformation);		
		}
		
		MenuItem contactsMenu = menu.getContactsPageItem();
		contactsMenu.setScheduledCommand(viewContacts);
	}
	
	String getTextPage(String name) {
		if(null!=name){
			
			if(name.equals("classic.html")){
				return resources.classic().getText();				
			} else if (name.equals("roman.html")){
				return resources.roman().getText();
			} else if (name.equals("modern.html")){
				return resources.modern().getText();
			} else if (name.equals("english.html")){
				return resources.english().getText();
			} else if (name.equals("french.html")){
				return resources.french().getText();
			} else if (name.equals("italian.html")){
				return resources.italian().getText();
			} 
		}
		return null;
	}
	
	/**
	 *  показать главную страницу
	 */
	ScheduledCommand viewMainPage = new ScheduledCommand() {
		
		@Override
		public void execute() {
			 SitePage mainPage = new SitePage("ГЛАВНАЯ СТРАНИЦА");
		     Element container = view.getElementById("contentContainer");
		     container.removeAllChildren();
			container.appendChild(mainPage.getElement());
		}
	};
	
	/**
	 * показать портфолио
	 */
	ScheduledCommand viewGallery = new ScheduledCommand() {
		
		@Override
		public void execute() {
			view.getElementById("contentContainer").removeAllChildren();
			RootPanel.get("contentContainer").add(new ImageViewer());
//			Window.alert("viewGallery");
		}
	}; 
	
	ScheduledCommand viewInformation = new ScheduledCommand() {

		@Override
		public void execute() {
			
			receivingService.getMenuItems(new AsyncCallback<List<MenuJDO>>() {
				public void onFailure(Throwable error) {
					// do something, when fail
					Window.alert("ERROR READ");
				}

				@Override
				public void onSuccess(List<MenuJDO> result) {
					Window.alert("" + result.size());
					
				}
			});
//			Window.alert("viewInformation");

		}
	};

	ScheduledCommand viewContacts = new ScheduledCommand() {

		@Override
		public void execute() {
//			main.clear();
//			htmpPage = new HTML(resources.contacts().getText());
//			main.add(htmpPage);
			AsyncCallback<Void> callback = new AsyncCallback<Void>() {
				public void onFailure(Throwable error) {
					// do something, when fail
					Window.alert("failed");
				}
	 
				public void onSuccess(Void ignore) {
					// when successful, do something, about UI
					Window.alert("create");
				}
			};
			MenuJDO test = new MenuJDO(1, "test", "path");
			receivingService.addMenuItem(test, callback);
//			Window.alert("viewContacts");
		}
	};
	
	class SubMenuCommand implements ScheduledCommand {

		private Widget contentWidget; 
		
		
		
		/**
		 * @param contentWidget
		 */
		public SubMenuCommand(Widget contentWidget) {
			super();
			this.contentWidget = contentWidget;
		}

		@Override
		public void execute() {
//			main.clear();
//			main.add(contentWidget);
			Window.alert("SubMenuCommand"+contentWidget.getElement().getId());
		}

		public Widget getContentWidget() {
			return contentWidget;
		}

		public void setContentWidget(Widget contentWidget) {
			this.contentWidget = contentWidget;
		}
		
		
		
	}
}
