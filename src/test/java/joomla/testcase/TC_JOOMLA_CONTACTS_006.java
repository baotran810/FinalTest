package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewContactsPage;
import joomla.page.ContactsPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_CONTACTS_006 extends TestHelper {
	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ContactsPage contactPage = new ContactsPage();
	AddNewContactsPage addNewContactPage = new AddNewContactsPage();

	String contactName = Utilities.randomName();
	String category = "Sample Data-Contact";

	@Test(description = "TC_JOOMLA_CONTACTS_006 - Verify user can check in a contact")
	public void testTC006() throws InterruptedException {

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
				"Message displays.");
		Assert.assertTrue(contactPage.doesContactExists(contactName),
				"Contact exists.");

		Log.info("Step 5. Check on the recently added contact's checkbox");
		contactPage.selectCheckBox(contactName);

		Log.info("Step 6. Click on 'Check In' icon of the top right toolbar");
		contactPage.clickButton("checkin");

		Log.info("Step 9. Verify the article is checked in successfully");
		Assert.assertTrue(
				contactPage.doesConfirmMsgDisplay("1 contact checked in."),
				"Message displays.");
		contactPage.clickContactName(contactName);

		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("history.go(-1);");

		// Constant.WEBDRIVER.navigate().back();
		Boolean isExist = contactPage.doesIconDisplay(contactName, "checkedout");
		Assert.assertTrue(isExist, "Set check-out status successfully.");

		Log.info("Final. Clean data");
		contactPage.cleanData();
	}
}
