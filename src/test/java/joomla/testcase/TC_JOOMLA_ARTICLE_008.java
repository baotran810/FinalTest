package joomla.testcase;

import joomla.common.Log;
import joomla.constant.Constant;
import joomla.page.ArticlePage;
import joomla.page.HelpPage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_008 extends TestHelper {

	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage article = new ArticlePage();
	HelpPage helpPage = new HelpPage();

	@Test(description = "TC_JOOMLA_ARTICLE_008 - Verify that user can access article's help section")
	public void testTC008() throws InterruptedException {
		Log.info("Step 1. Log in");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		homePage.gotoArticle();

		Log.info("Step 3. Click on 'Help' icon of the top right toolbar");
		article.clickButton("help");

		Log.info("Step 4. Verify the article's help window is displayed");
		Assert.assertTrue(helpPage.doesHelpPageDisplays(), "Window displays");
	}
}