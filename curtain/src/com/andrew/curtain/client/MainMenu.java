package com.andrew.curtain.client;

import com.andrew.curtain.client.resources.MenuItemsNames;
import com.andrew.curtain.client.resources.IconBundle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;

/**
 * 
 * 
 * @author andrew
 * 
 */
public class MainMenu extends MenuBar {

	/**
	 * Шаблон для меню с иконкой
	 */
	public interface MenuIconPlace extends SafeHtmlTemplates {
		@Template("<img src=\"{0}\" class=\"image-menu\"/><br/><span class=\"menu-name\">{1}</span>")
		SafeHtml createItem(SafeUri uri, SafeHtml message);
	}

	public MenuIconPlace template = GWT.create(MenuIconPlace.class);
	public MenuItemsNames items = GWT.create(MenuItemsNames.class);
	public IconBundle icons = GWT.create(IconBundle.class);

	// главная страница
	MenuItem mainPageItem;
	// страница с фотками
	MenuItem worksPageItem;
	//
	MenuItem informPageItem;
	//
	MenuItem contactsPageItem;

	public MainMenu() {
		super();
		setAutoOpen(true);
		setWidth("auto");
		setHeight("auto");
		setAnimationEnabled(true);
		addHandler(menuBarOut, MouseOutEvent.getType());
		menuLinkage();
	}

	private void menuLinkage() {
		SafeHtml mainItemTmpl = template.createItem(icons.homeIcon()
				.getSafeUri(), SafeHtmlUtils.fromString(items.home()));
		mainPageItem = new MenuItem(mainItemTmpl);
		mainPageItem.addStyleName("voidMenu");
		addItem(mainPageItem);
		//addSeparator();
		SafeHtml galleryItemTmpl = template.createItem(icons.galleryIcon()
				.getSafeUri(), SafeHtmlUtils.fromString(items.gallery()));
		worksPageItem = new MenuItem(galleryItemTmpl);
		MenuBar galleryPopup = new MenuBar(true);
		galleryPopup.addHandler(popupOut, MouseOutEvent.getType());
		galleryPopup.addHandler(mouseWhell, MouseWheelEvent.getType());
		galleryPopup.setFocusOnHoverEnabled(false);
		worksPageItem.setSubMenu(galleryPopup);
		addItem(worksPageItem);
		//addSeparator();
		SafeHtml infoItemTmpl = template.createItem(icons.infoIcon()
				.getSafeUri(), SafeHtmlUtils.fromString(items.info()));
		MenuBar infoPopup = new MenuBar(true);
		informPageItem = new MenuItem(infoItemTmpl);
		infoPopup.addHandler(popupOut, MouseOutEvent.getType());
		infoPopup.addHandler(mouseWhell, MouseWheelEvent.getType());
		infoPopup.setFocusOnHoverEnabled(true);
		informPageItem.setSubMenu(infoPopup);
		addItem(informPageItem);
		//addSeparator();
		SafeHtml contactsItemTmpl = template.createItem(icons.contactIcon()
				.getSafeUri(), SafeHtmlUtils.fromString(items.contacts()));
		contactsPageItem = new MenuItem(contactsItemTmpl);
		contactsPageItem.addStyleName("voidMenu");
		addItem(contactsPageItem);
		addHandler(mouseWhell, MouseWheelEvent.getType());
	}

	/**
	 * Обработчик {@link MouseOutEvent} мышка покидает область выпадающего меню
	 */
	private MouseOutHandler popupOut = new MouseOutHandler() {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			closeAllChildren(true);
		}
	};

	private MouseOutHandler menuBarOut = new MouseOutHandler() {

		@Override
		public void onMouseOut(MouseOutEvent event) {
			if (event.getY() < 0) {
				closeAllChildren(true);
			}
		}
	};

	private MouseWheelHandler mouseWhell = new MouseWheelHandler() {

		@Override
		public void onMouseWheel(MouseWheelEvent event) {
			closeAllChildren(true);
		}

	};

	/* *********************************************************************
	 * getters && setters
	 * *******************************************************************
	 */

	public MenuItem getMainPageItem() {
		return mainPageItem;
	}

	public void setMainPageItem(MenuItem mainPageItem) {
		this.mainPageItem = mainPageItem;
	}

	public MenuItem getWorksPageItem() {
		return worksPageItem;
	}

	public void setWorksPageItem(MenuItem worksPageItem) {
		this.worksPageItem = worksPageItem;
	}

	public MenuItem getInformPageItem() {
		return informPageItem;
	}

	public void setInformPageItem(MenuItem informPageItem) {
		this.informPageItem = informPageItem;
	}

	public MenuItem getContactsPageItem() {
		return contactsPageItem;
	}

	public void setContactsPageItem(MenuItem contactsPageItem) {
		this.contactsPageItem = contactsPageItem;
	}

}
