package joomla.testcase;

import joomla.common.Log;
import joomla.constant.Constant;
import joomla.page.ContactsPage;
import joomla.page.HelpPageOfContact;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_008 extends TestHelper{
	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contact = new ContactsPage();
	HelpPageOfContact helpContact = new HelpPageOfContact();

	@Test(description = "TC_JOOMLA_CONTACTS_008 - Verify user can access contact's help section")
	public void testTC008() throws InterruptedException {
		Log.info("Step 1. Login with valid account");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();
		
		Log.info("Step 3. Click Help button on the toolbar");
		contact.clickButton("help");
		
		Log.info("Step 4. Verify the article's help window is displayed");
		Assert.assertTrue(helpContact.doesHelpPageDisplays(), "Window displays");
	}
}
