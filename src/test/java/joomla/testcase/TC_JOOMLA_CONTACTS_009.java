package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewContactsPage;
import joomla.page.ContactsPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_009 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contactPage = new ContactsPage();
	AddNewContactsPage addNewContactPage = new AddNewContactsPage();

	String contactName = Utilities.randomName();
	String category = "Sample Data-Contact";

	@BeforeMethod
	public void beforeMethod() {
		Log.info("Step 1. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar ");
		contactPage.clickButton("new");

		Log.info("Step 4. Fill information into Name, Category, Status field");
		addNewContactPage.addNewContact(contactName, "Published", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contactPage.doesConfirmMsgDisplay("Contact saved"),
				"Message should be displayed.");
		Assert.assertTrue(contactPage.doesContactExists(contactName),
				"Contact should exist.");
	}

	@Test(description = "TC_JOOMLA_CONTACTS_009 - Verify user can search for contacts using the filter text field")
	public void testTC009() {
		Log.info("Step 5. Search contacts using the filter text field");
		contactPage.searchText(contactName);

		Log.info("VP. Verify the titles of displayed contacts are partially matched with the entered keyword");
		Assert.assertTrue(contactPage.doesContactExistBySearch(contactName),
				"Contact should exist.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Log.info("Final. Clean data");
		contactPage.cleanData();
	}

}
