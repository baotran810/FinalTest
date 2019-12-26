package joomla.common;

import joomla.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SetUpBrowser {

	public static WebDriver WEBDRIVER;

	// set up browser with Chrome
	public static void setupChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		Constant.WEBDRIVER = new ChromeDriver(options);
		Constant.WEBDRIVER.get(Constant.JOOMLA_URL);
		Constant.WEBDRIVER.manage().window().maximize();
	}

	// set up browser with Firefox
	public static void setupFireFoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		Constant.WEBDRIVER = new FirefoxDriver();
		Constant.WEBDRIVER.get(Constant.JOOMLA_URL);
	}

	// set up browser with IE
	public static void setupIEBrowser() {
		WebDriverManager.iedriver().setup();
		Constant.WEBDRIVER = new InternetExplorerDriver();
		Constant.WEBDRIVER.get(Constant.JOOMLA_URL);
	}

}
