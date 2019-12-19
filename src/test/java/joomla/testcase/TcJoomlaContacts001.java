package joomla.testcase;

import static org.testng.Assert.assertEquals;
import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewContactsPage;
import joomla.page.ContactsPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.annotations.Test;

public class TcJoomlaContacts001 extends TestHelper {
	
	  LoginPage login = new LoginPage();
	  HomePage home = new HomePage();
	  ContactsPage contactpage = new ContactsPage();
	  AddNewContactsPage addnew = new AddNewContactsPage();
	
  @Test(description="Verify that user can create new contact with valid information")
  public void tc001() {
	  
	  Log.info("Step 1. Log in");
	  login.login(Constant.USERNAME, Constant.PASSWORD);
	  Log.info("User can log in with valid account");
	  
	  Log.info("Step 2. Go to Contacts page");
	  home.gotoContactPage();
	  
	  Log.info("Step 3. Click New button");
	  contactpage.AddNew();
	  
	  Log.info("Step 4. Fill information in new contact page");
	  String contactName = Utilities.contactName();
	  addnew.addNewContact(contactName);
	  assertEquals(contactpage.checkMessage("Contact saved."), true, "Verify that message is displayed");
	  assertEquals(contactpage.checkElementExist(contactName), true, "Verify that created contact is displayed on the contacts table");
	  
  }
  
  
}
