package com.andrew.curtain.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.andrew.curtain.client.ReceivingService;
import com.andrew.curtain.server.jdo.MenuJDO;
import com.andrew.curtain.server.jdo.SampleImageJDO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ReceivingServiceImpl extends RemoteServiceServlet implements
		ReceivingService {

	private static final Logger LOG = Logger
			.getLogger(ReceivingServiceImpl.class.getName());

	private static final PersistenceManagerFactory PMF = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	// public String greetServer(String input) throws IllegalArgumentException {
	// // Verify that the input is valid.
	// if (!FieldVerifier.isValidName(input)) {
	// // If the input is not valid, throw an IllegalArgumentException back to
	// // the client.
	// throw new IllegalArgumentException(
	// "Name must be at least 4 characters long");
	// }
	//
	// String serverInfo = getServletContext().getServerInfo();
	// String userAgent = getThreadLocalRequest().getHeader("User-Agent");
	//
	// // Escape data from the client to avoid cross-site script
	// vulnerabilities.
	// input = escapeHtml(input);
	// userAgent = escapeHtml(userAgent);
	//
	// return "Hello, " + input + "!<br><br>I am running " + serverInfo
	// + ".<br><br>It looks like you are using:<br>" + userAgent;
	// }

	private PersistenceManager getPersistenceManager() {
		return PMF.getPersistenceManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void removeMenuItem(MenuJDO object) throws IllegalArgumentException {
		PersistenceManager pm = getPersistenceManager();
		try {
			long deleteCount = 0;	
			String query = "select from ".concat(MenuJDO.class.getName());
			List<MenuJDO> items = (List<MenuJDO>) pm.newQuery(query).execute();
			for (MenuJDO itm : items) {
				if (object.equals(itm)) {
					deleteCount++;
					pm.deletePersistent(itm);
				}
			}
			if (deleteCount != 1) {
				LOG.log(Level.WARNING, "removeMenuItem deleted " + deleteCount
						+ " Items");
			}
		} finally {
			pm.close();
		}
	}

	/**
	 * Создает объект в DataStore
	 */
	@Override
	public void addMenuItem(MenuJDO menuItem) throws IllegalArgumentException {
		PersistenceManager pm = getPersistenceManager();
		try {
			pm.makePersistent(menuItem);
		} finally {
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuJDO> getMenuItems() throws IllegalArgumentException {
		PersistenceManager pm = getPersistenceManager();
		List<MenuJDO> items = new ArrayList<MenuJDO>();
		try {
			String query  = "select from ".concat(MenuJDO.class.getName()); 
			 List<MenuJDO> itms = (List<MenuJDO>) pm.newQuery(query).execute();
			 for (MenuJDO menuJDO : itms) {
				items.add(menuJDO);
			}
		} finally {
			pm.close();
		}
		return items;
	}

	@Override
	public void removeGalleryImage(SampleImageJDO img)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGalleryImage(SampleImageJDO img)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
}
