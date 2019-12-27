package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticlePage;
import joomla.page.ArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_004 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticlePage addNewArticlePage = new AddNewArticlePage();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@BeforeMethod
	public void beforeMethod() {
		Log.info("Step 1. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Article page ");
		homePage.gotoArticle();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar");
		articlePage.clickButton("new");

		Log.info("Step 4. Fill \"Add new article\" form ");
		addNewArticlePage.createArticle(articleName, articleContent,
				"Published");

		Log.info("VP. Verify the article is saved successfully ");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message should be displayed.");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article should exist.");
	}

	@Test(description = "TC_JOOMLA_ARTICLE_004 - Verify user can unpublish a published article")
	public void testTC004() {
		Log.info("Step 5. Check on the recently added article's checkbox");
		articlePage.selectCheckBox(articleName);

		Log.info("Step 6. Click on 'Unpublish' icon of the top right toolbar");
		articlePage.clickButton("unpublish");

		Log.info("VP. Verify the article is unpublished successfully");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("article unpublished."),
				"Message should be displayed.");
		Assert.assertTrue(
				articlePage.doesStatusExists(articleName, "unpublish"),
				"Article should be displayed with published status.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Log.info("Final. Clean data");
		articlePage.cleanData();
	}

}
