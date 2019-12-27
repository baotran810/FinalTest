package joomla.testcase;

import joomla.common.Log;
import joomla.constant.Constant;
import joomla.page.ContactsPage;
import joomla.page.ContactHelpPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_008 extends TestHelper{
	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();

	ContactsPage contactPage = new ContactsPage();
	ContactHelpPage contactHelpPage = new ContactHelpPage();

	@Test(description = "TC_JOOMLA_CONTACTS_008 - Verify user can access contact's help section")
	public void testTC008() throws InterruptedException {
		Log.info("Step 1. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();
		
		Log.info("Step 3. Click Help button on the toolbar");
		contactPage.clickButton("help");
		
		Log.info("VP. Verify the article's help window is displayed");
		Assert.assertTrue(contactHelpPage.doesHelpPageDisplays(), "Help window should be displayed.");
	}
}
