package com.andrew.curtain.client;

import java.util.List;

import com.andrew.curtain.server.jdo.MenuJDO;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>ReceivingService</code>.
 */
public interface ReceivingServiceAsync {

	void removeMenuItem(MenuJDO object, AsyncCallback<Void> callback);
	/**
	 * Add item to datastore
	 * 
	 * @param menuItem
	 * @param callback
	 */
	void addMenuItem(MenuJDO menuItem, AsyncCallback<Void> callback);

	void getMenuItems(AsyncCallback<List<MenuJDO>> callback);
}
