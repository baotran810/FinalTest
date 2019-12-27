package joomla.testcase;

import joomla.common.Log;
import joomla.constant.Constant;
import joomla.page.ArticlePage;
import joomla.page.HelpPageOfArticle;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_008 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	HelpPageOfArticle helpPage = new HelpPageOfArticle();

	@Test(description = "TC_JOOMLA_ARTICLE_008 - Verify that user can access article's help section")
	public void testTC008() throws InterruptedException {
		Log.info("Step 1. Log in");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		homePage.gotoArticle();

		Log.info("Step 3. Click on 'Help' icon of the top right toolbar");
		articlePage.clickButton("help");

		Log.info("Step 4. Verify the article's help window is displayed");
		Assert.assertTrue(helpPage.doesHelpPageDisplays(), "Window displays");
	}
}