/**
 * 
 */
package com.andrew.curtain.client.widget;

import com.andrew.curtain.client.resources.Resources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.UIObject;

/**
 * @author andrew
 *
 */
public class SitePage extends UIObject {

	private static SitePageUiBinder uiBinder = GWT
			.create(SitePageUiBinder.class);

	interface SitePageUiBinder extends UiBinder<Element, SitePage> {
	}
	
	Resources resources = GWT.create(Resources.class);

	@UiField
	SpanElement namePage;
	@UiField
	DivElement wrapperDiv;
	
	public SitePage(String pageName) {
		setElement(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
		namePage.setInnerText(pageName);
		wrapperDiv.setInnerHTML(resources.main().getText());
	}

}
