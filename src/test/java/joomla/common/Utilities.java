package joomla.common;

import joomla.constant.Constant;

public class Utilities {

	public static String randomTitle() {
		return Constant.FAKER.book().title();
	}

	public static String randomContent() {
		return Constant.FAKER.ancient().god();
	}
}
