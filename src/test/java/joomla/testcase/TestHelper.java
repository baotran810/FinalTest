package joomla.testcase;

import joomla.common.SetUpBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestHelper {

	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) {
		if(browser.equalsIgnoreCase("chrome")){
			 SetUpBrowser.setupChromeBrowser();
	  }
			 //if browser is Firefox, then do this
	  else if(browser.equalsIgnoreCase("firefox")){
			 SetUpBrowser.setupFireFoxBrowser();
	  }
	  else if(browser.equalsIgnoreCase("ie")){
		  SetUpBrowser.setupIEBrowser();
	  }
 }

// @AfterClass
// public void afterClass() {
//	  Log.info("Post-Condition");
//	  Constant.WEBDRIVER.quit();
// }

}
