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

public class TC_JOOMLA_CONTACTS_007 extends TestHelper {

	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contact = new ContactsPage();
	AddNewContactsPage newContact = new AddNewContactsPage();

	String nameContact = Utilities.randomName();
	String category = "Sample Data-Contact";

	@Test(description = "TC_JOOMLA_CONTACTS_007 - Verify user can move a contact to trash section")
	public void testTC007() throws InterruptedException {
		Log.info("Step 1. Login with valid account");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();

		Log.info("Step 3. Click on \"New\" icon of the top right toolbar");
		contact.clickButton("new");

		Log.info("Step 4. Fill information into Name, Category, Status field");
		newContact.addNewContact(nameContact, "Published", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contact.doesConfirmMsgDisplays("Contact saved"),
				"Message displays.");
		Assert.assertTrue(contact.doesContactExists(nameContact),
				"Contact exists.");

		Log.info("Step 5. Check on the recently added contact's checkbox");
		contact.selectCheckBox(nameContact);

		Log.info("Step 6. Click on 'Trash' icon of the top right toolbar");
		contact.clickButton("trash");

		Log.info("VP. Verify the confirm message is displayed");
		Assert.assertTrue(contact.doesConfirmMsgDisplays("contact trashed."),
				"Message displays.");

		Log.info("Step 7. Select 'Trash' item of 'Status' dropdown list");
		contact.clickBtnClear();
		contact.clickBtnSearchTool();
		contact.waitForDivFilter(30);
		contact.selectStatusDropdownList("Trashed");

		Log.info("VP. Verify the deleted contact is displayed on the table grid");
		Assert.assertTrue(contact.doesContactExists(nameContact),
				"Contact exists.");
	}
}
