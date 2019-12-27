package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticlePage;
import joomla.page.ArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_007 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticlePage addNewArticlePage = new AddNewArticlePage();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description="TC_JOOMLA_ARTICLE_007-Verify user can move an article to trash section")
	public void testTC007() throws InterruptedException {
		Log.info("Step 1. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Article page ");
		homePage.gotoArticle();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar");
		articlePage.clickButton("new");

		Log.info("Step 4. Fill \"Add new article\" form ");
		addNewArticlePage.createArticle(articleName, articleContent, "Published");

		Log.info("VP. Verify the article is saved successfully ");
		Assert.assertTrue(articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message displays.");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Step 5. Check on the recently added article's checkbox");
		articlePage.selectCheckBox(articleName);

		Log.info("Step 6. Click on 'Trash' icon of the top right toolbar");
		articlePage.clickButton("trash");

		Log.info("VP. Verify the confirm message is displayed");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("article trashed."),
				"Message displays.");

		Log.info("Step 7. Select 'Trash' item of 'Status' dropdown list");
		articlePage.clickBtnClear();
		articlePage.clickBtnSearchTool();
		articlePage.waitForDivFilter(30);
		articlePage.selectStatusDropdownList("Trashed");

		Log.info("VP. Verify the deleted article is displayed on the table grid");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article exists.");
	}

}
