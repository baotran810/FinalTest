package joomla.testcase;

import static org.testng.Assert.assertEquals;
import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticle;
import joomla.page.AddNewContactsPage;
import joomla.page.ArticlePage;
import joomla.page.ContactsPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.annotations.Test;

public class TcJoomlaContacts001 extends TestHelper {
	
	  LoginPage login = new LoginPage();
	  HomePage home = new HomePage();
	  ArticlePage article = new ArticlePage();
	  AddNewArticle addNew = new AddNewArticle();
	  
	  String articleName = Utilities.randomTitle();
	  String articleContent = Utilities.randomContent();
	  
  @Test(description="Verify that user can create new contact with valid information")
  public void tc001() {
	  
	  Log.info("Step 1. Log in");
	  login.login(Constant.USERNAME, Constant.PASSWORD);
	  Log.info("User can log in with valid account");
	  
	  Log.info("Step 2. Go to Article page");
	  home.gotoCreateArticle();
	  
	  Log.info("Step 3. Click New button");
	  article.clickNewbutton();
	  
	  Log.info("Step 4. Fill information in new article page");
	  addnew.CreateArticle(articleName,articleContent);
	  
	  
  }
  
  
}
