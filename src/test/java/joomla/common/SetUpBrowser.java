package joomla.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import joomla.constant.Constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetUpBrowser {

	public static WebDriver WEBDRIVER;

	// set up browser with Chrome
	public static void setupChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		Constant.WEBDRIVER = new ChromeDriver();
		getBrowser();
	}

	// set up browser with Firefox
	public static void setupFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		Constant.WEBDRIVER = new FirefoxDriver();
		getBrowser();
	}

	// set up browser with IE
	public static void setupIEBrowser() {
		WebDriverManager.iedriver().setup();
		Constant.WEBDRIVER = new InternetExplorerDriver();
		getBrowser();
	}
	
	public static void getBrowser() {
		Constant.WEBDRIVER.get(Constant.JOOMLA_URL);
		Constant.WEBDRIVER.manage().window().maximize();
	}

}
