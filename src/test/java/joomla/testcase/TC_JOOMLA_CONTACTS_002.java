package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewContactsPage;
import joomla.page.ContactsPage;
import joomla.page.EditContactPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_002 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contactPage = new ContactsPage();
	AddNewContactsPage addNewContactPage = new AddNewContactsPage();
	EditContactPage editContactPage = new EditContactPage();

	String nameContact = Utilities.randomName();
	String newNameContact = Utilities.randomNewContact();
	String category = "Sample Data-Contact";
	String newCategory = "- Park Site";

	@Test(description = "TC_JOOMLA_CONTACTS_002-Verify user can edit a contact")
	public void testTC002() throws InterruptedException {

		Log.info("Step 1. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar ");
		contactPage.clickButton("new");

		Log.info("Step 4. Fill information into Name, Category, Status field");
		addNewContactPage.addNewContact(nameContact, "", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contactPage.doesConfirmMsgDisplay("Contact saved"),
				"Message displays.");
		Assert.assertTrue(contactPage.doesContactExists(nameContact),
				"Contact exists.");

		Log.info("Step 5. Select article to edit");
		contactPage.selectCheckBox(nameContact);

		Log.info("Step 6. Click on 'Edit' icon of the top right toolbar");
		contactPage.clickButton("edit");

		Log.info("Step 8. Edit article");
		editContactPage.editContact(newNameContact, newCategory);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contactPage.doesConfirmMsgDisplay("Contact saved"),
				"Message displays.");
		Assert.assertTrue(contactPage.doesContactExists(newNameContact),
				"Contact exists.");

		Log.info("Final. Clean data");
		contactPage.cleanData();
	}
}
