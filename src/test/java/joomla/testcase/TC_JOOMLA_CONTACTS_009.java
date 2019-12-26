package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewContactsPage;
import joomla.page.ContactsPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_009 extends TestHelper {

	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contact = new ContactsPage();
	AddNewContactsPage newContact = new AddNewContactsPage();

	String contactName = Utilities.randomName();
	String category = "Sample Data-Contact";

	@Test(description = "TC_JOOMLA_CONTACTS_009 - Verify user can search for contacts using the filter text field")
	public void testTC009() throws InterruptedException {

		Log.info("Step 1. Login with valid account");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar ");
		contact.clickButton("new");

		Log.info("Step 4. Fill information into Name, Category, Status field");
		newContact.addNewContact(contactName, "Published", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contact.doesConfirmMsgDisplays("Contact saved"),
				"Message displays.");
		Assert.assertTrue(contact.doesContactExists(contactName),
				"Contact exists.");

		Log.info("Step 5. Search contacts using the filter text field");
		contact.searchText(contactName);

		Log.info("VP. Verify the titles of displayed contacts are partially matched with the entered keyword");
		Assert.assertTrue(contact.doesContactExistBySearch(contactName),
				"Contact exists.");
		
		Log.info("Final. Clean data");
		contact.cleanData();
	}
}
