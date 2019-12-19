package joomla.common;

import joomla.constant.Constant;

public class Utilities {
	
	public static String contactName(){
		return Constant.FAKER.book().title();
	}
	
}
