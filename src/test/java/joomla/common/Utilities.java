package joomla.common;

import joomla.constant.Constant;

public class Utilities {

	public static String randomContent() {
		return Constant.FAKER.lorem().paragraph();
	}

	public static String randomTitle() {
		return Constant.FAKER.lorem().sentence();
	}

	public static String randomName() {
		return Constant.FAKER.name().fullName();
	}

	public static String randomNewContact() {
		return Constant.FAKER.name().username();
	}

}
