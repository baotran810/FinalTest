package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticlePage;
import joomla.page.ArticlePage;
import joomla.page.EditArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_002 extends TestHelper {
	
	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticlePage addNewArticlePage = new AddNewArticlePage();
	EditArticlePage editArticlePage = new EditArticlePage();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();
	String category = "- Park Site";
	String newArticleName = Utilities.randomTitle();
	String newArticleContent = Utilities.randomContent();

	@BeforeMethod
	public void beforeMethod() {
		Log.info("Step 1. Log in");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		homePage.gotoArticle();

		Log.info("Step 3. Click New button");
		articlePage.clickButton("new");

		Log.info("Step 4. Fill information in new article page");
		addNewArticlePage.createArticle(articleName, articleContent, "");

		Log.info("VP. Verify the article is saved successfully ");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message should be displayed.");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article should exist.");

	}

	@Test(description = "TC_JOOMLA_ARTICLE_002 - Verify user can edit an article")
	public void testTC002() {
		Log.info("Step 5. Select article to edit");
		articlePage.selectCheckBox(articleName);

		Log.info("Step 6. Click on 'Edit' icon of the top right toolbar");
		articlePage.clickButton("edit");

		Log.info("Step 7. Edit article");
		editArticlePage
				.editArticle(newArticleName, newArticleContent, category);

		Log.info("VP. Verify the article is edited successfully ");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message should displayed.");
		Assert.assertTrue(articlePage.doesArticleExists(newArticleName),
				"Article should exist.");
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Log.info("Final. Clean data");
		articlePage.cleanData();
	}
	
}
