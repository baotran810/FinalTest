package joomla.common;

import joomla.constant.Constant;

public class Utilities {


	public static String randomContent() {
		return Constant.FAKER.ancient().god();
	}

	public static String randomTitle() {
		return Constant.FAKER.book().title();
	}
	
	public static String randomName(){
		return Constant.FAKER.cat().name();
	}	
	
}
