package com.andrew.curtain.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;
/**
 * Resources application
 * 
 * @author Andrew Malapura
 *
 */
public interface Resources extends ClientBundle {

	@Source("test/images/img.jpg")
	ImageResource logo();
	
	@Source("test/images/master.jpg")
	ImageResource master();
	
	@Source("test/images/image001.jpg")
	ImageResource img001();
	
	@Source("test/images/image002.jpg")
	ImageResource img002();
	
	@Source("test/images/image003.jpg")
	ImageResource img003();
	
	@Source("test/images/image004.jpg")
	ImageResource img004();
	
	@Source("test/images/image005.jpg")
	ImageResource img005();
	
	// -------- Menu icons bundle ----------------
	
	@Source("icons/home.png")
	ImageResource homeIcon();
	
	@Source("icons/camera.png")
	ImageResource galleryIcon();
		
	@Source("icons/book.png")
	ImageResource infoIcon();
	
	@Source("icons/phone.png")
	ImageResource contactIcon();
	
	// --------- pages bundle --------
	
	@Source("pages/main.html")
	TextResource main();
	
	@Source("pages/contacts.html")
	TextResource contacts();
	
	@Source("pages/livingroom.html")
	TextResource livingroom();
	
	@Source("pages/kitchen.html")
	TextResource kitchen();
	
	@Source("pages/nursery.html")
	TextResource nursery();
	
	@Source("pages/cabinet.html")
	TextResource cabinet();
	
	@Source("pages/accessories.html")
	TextResource accessories();

	/**
	 * 
	 * 				Ресурсы стили штор
	 * 
	 */
	
	
	final static String INFO_PATH = "pages/information/";
	
	@Source(INFO_PATH + "classic.html")
	TextResource classic();
	
	@Source(INFO_PATH + "roman.html")
	TextResource roman();
	
	@Source(INFO_PATH + "modern.html")
	TextResource modern();
	
	@Source(INFO_PATH + "english.html")
	TextResource english();
	
	@Source(INFO_PATH + "french.html")
	TextResource french();
	
	@Source(INFO_PATH + "italian.html")
	TextResource italian();	

}
