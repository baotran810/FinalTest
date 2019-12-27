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

public class TC_JOOMLA_CONTACTS_004 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contactPage = new ContactsPage();
	AddNewContactsPage addNewContactPage = new AddNewContactsPage();

	String nameContact = Utilities.randomName();
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
		addNewContactPage.addNewContact(nameContact, "Published", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contactPage.doesConfirmMsgDisplay("Contact saved"),
				"Message should be displayed.");
		Assert.assertTrue(contactPage.doesContactExists(nameContact),
				"Contact should exist.");
	}

	@Test(description = "TC_JOOMLA_CONTACTS_004 - Verify user can unpublish a published contact")
	public void testTC004() throws InterruptedException {
		Log.info("Step 5. Check on the recently added contact's checkbox");
		contactPage.selectCheckBox(nameContact);

		Log.info("Step 6. Click on 'Unpublish' icon of the top right toolbar");
		contactPage.clickButton("unpublish");

		Log.info("VP. Verify the contact is unpublished successfully");
		Assert.assertTrue(
				contactPage.doesStatusExists(nameContact, "unpublish"),
				"The icon of the selected item should be showed as 'Unpublish'.");
		Assert.assertTrue(
				contactPage.doesConfirmMsgDisplay("contact unpublished"),
				"Message should be displayed.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Log.info("Final. Clean data");
		contactPage.cleanData();
	}

}
