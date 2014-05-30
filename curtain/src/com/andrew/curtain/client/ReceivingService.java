package com.andrew.curtain.client;

import java.util.List;

import com.andrew.curtain.server.jdo.MenuJDO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("receive")
public interface ReceivingService extends RemoteService {
	// удаление сущности из DataStore
	void removeMenuItem(MenuJDO object) throws IllegalArgumentException;
	// добавление сущности в DataStore
	void addMenuItem(MenuJDO menuItem) throws IllegalArgumentException;
	// получение коллекции сущностей из DataStore
	List<MenuJDO> getMenuItems() throws IllegalArgumentException;
}
