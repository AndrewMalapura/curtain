package com.andrew.curtain.client;

import java.util.List;

import com.andrew.curtain.server.jdo.MenuJDO;
import com.andrew.curtain.server.jdo.SampleImageJDO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ReceivingService</code>.
 */
public interface ReceivingServiceAsync {
	/**
	 * 
	 * @param object
	 * @param callback
	 */
	void removeMenuItem(MenuJDO menuItem, AsyncCallback<Void> callback);
	/**
	 * Add item to datastore
	 * 
	 * @param menuItem
	 * @param callback
	 */
	void addMenuItem(MenuJDO menuItem, AsyncCallback<Void> callback);
	/**
	 * 
	 * @param callback
	 */
	void getMenuItems(AsyncCallback<List<MenuJDO>> callback);
	/**
	 * 
	 * @param img
	 * @param callback
	 */
	void removeGalleryImage(SampleImageJDO img, AsyncCallback<Void> callback);
	/**
	 * 
	 * @param img
	 * @param callback
	 */
	void addGalleryImage(SampleImageJDO img, AsyncCallback<Void> callback);
}
