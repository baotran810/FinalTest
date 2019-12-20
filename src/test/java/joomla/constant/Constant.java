package joomla.constant;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class Constant {

	public static WebDriver WEBDRIVER;
	public static String JOOMLA_URL = "http://192.168.189.152:8080/administrator/index.php";
	public static String USERNAME = "satt";
	public static String PASSWORD = "123456";
	public static String CATEGORY = "Sample Data-Contact";
	public static Faker FAKER = new Faker();
}