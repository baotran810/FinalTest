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

public class TC_JOOMLA_CONTACTS_005 extends TestHelper{
	@Test(description = "TC_JOOMLA_CONTACTS_005 - Verify user can move a contact to the archive")
	public void f() throws InterruptedException {
		LoginPage logIn = new LoginPage();
		HomePage homePage = new HomePage();
		ContactsPage contact = new ContactsPage();
		AddNewContactsPage newContact = new AddNewContactsPage();
		
		String nameContact = Utilities.randomName();
		String category = "Sample Data-Contact";
		
		Log.info("Step 1. Login with valid account");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Contacts page");
		homePage.goToContacts();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar ");
		contact.clickButton("new");

		Log.info("Step 4. Fill information into Name, Category, Status field");
		newContact.addNewContact(nameContact, "Unpublished", category);

		Log.info("VP. Verify the contact is saved successfully");
		Assert.assertTrue(contact.doesConfirmMsgDisplays("Contact saved"),
				"Message displays.");
		Assert.assertTrue(contact.doesContactExists(nameContact),
				"Contact exists.");

		Log.info("Step 5. Check on the recently added contact's checkbox");
		contact.selectCheckbox(nameContact);
		
		Log.info("Step 6. Click on 'Archived' icon of the top right toolbar");
		contact.clickButton("archive");
		
		Log.info("Step 7. Verify that the confirm message displays after archiving article");
		Assert.assertTrue(contact.doesConfirmMsgDisplays("contact archived."), "Message displays.");
		
		Log.info("Step 8. Search archived contact by DropDown list");
		contact.clickBtnClear();
		contact.clickBtnSearchTool();
		contact.waitForDivFilter(30);
		contact.selectStatusDropdownList("Archived");
		
		Log.info("Step 9. Verify that archived contact displays in archived table");
		Assert.assertTrue(contact.doesContactExists(nameContact), "Contact exists.");
	}
}
