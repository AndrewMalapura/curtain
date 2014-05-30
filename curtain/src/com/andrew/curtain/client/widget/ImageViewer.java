package com.andrew.curtain.client.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;

public class ImageViewer extends Composite implements RequiresResize,
		ProvidesResize {
	
	DockLayoutPanel dockLayoutPanel = new DockLayoutPanel(Unit.PCT);

	
	
	public ImageViewer() {
		super();
		dockLayoutPanel.setStyleName("viewer-Image-style");
		initWidget(dockLayoutPanel);
		dockLayoutPanel.setSize("100%", "auto");
	}



	@Override
	public void onResize() {
		// TODO Auto-generated method stub

	}

}
