package com.andrew.curtain.client.resources;

import java.util.Map;

import com.google.gwt.i18n.client.Constants;

public interface MenuItemsNames extends Constants {

	final static String INFO_PATH = "";

	@DefaultStringValue("Главная")
	String home();

	@DefaultStringValue("Каталог")
	String gallery();

	@DefaultStringMapValue({ "Гостинная", "livingroom", "Кухня", "kitchen",
			"Детская", "nursey", "Кабинет", "cabinet", "Спальня", "bedroom",
			"Аксессуары", "accessories" })
	Map<String, String> galeryMap();

	@DefaultStringValue("Стили штор")
	String info();

	@DefaultStringMapValue({ "Классический", INFO_PATH + "classic.html",
			"Романский", INFO_PATH + "roman.html", "Модерн",
			INFO_PATH + "modern.html", "Английский",
			INFO_PATH + "english.html", "Французкий",
			INFO_PATH + "french.html", "Итальянский",
			INFO_PATH + "italian.html" })
	Map<String, String> infoMap();

	@DefaultStringValue("Контакты")
	String contacts();

}
