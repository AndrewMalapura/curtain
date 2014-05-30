package com.andrew.curtain.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface IconBundle extends ClientBundle {
	
	@Source("icons/home.png")
	ImageResource homeIcon();

	@Source("icons/camera.png")
	ImageResource galleryIcon();

	@Source("icons/book.png")
	ImageResource infoIcon();

	@Source("icons/phone.png")
	ImageResource contactIcon();

}
