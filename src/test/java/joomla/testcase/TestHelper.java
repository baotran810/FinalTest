package joomla.testcase;

import joomla.common.Log;
import joomla.common.SetUpBrowser;
import joomla.constant.Constant;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestHelper {

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		Log.info("Pre-conditions");
		if (browser.equalsIgnoreCase("chrome")) {
			SetUpBrowser.setupChromeBrowser();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			SetUpBrowser.setupFireFoxBrowser();
		} 
		else if (browser.equalsIgnoreCase("ie")) {
			SetUpBrowser.setupIEBrowser();
		}
	}

	@AfterClass
	public void afterClass() {
		Log.info("Final");
		Constant.WEBDRIVER.quit();
	}

}
