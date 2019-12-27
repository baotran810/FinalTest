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
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_005 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticlePage addNewArticlePage = new AddNewArticlePage();
	EditArticlePage editArticlePage = new EditArticlePage();
	
	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_005 - User can move an article to the archive")
	public void testTC005() throws InterruptedException {
		Log.info("Step 1. Log in");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		homePage.gotoArticle();

		Log.info("Step 3. Click New button");
		articlePage.clickButton("new");

		Log.info("Step 4. Fill information in new article page");
		addNewArticlePage.createArticle(articleName, articleContent, "");

		Log.info("Step 5. Verify the article is saved successfully ");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message displays.");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Step 6. Select article to archive");
		articlePage.selectCheckBox(articleName);

		Log.info("Step 7. Click on 'Archive' icon of the top right toolbar");
		articlePage.clickButton("archive");

		Log.info("Step 8. Verify that the confirm message displays after archiving article");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("article archived."),
				"Message displays.");

		Log.info("Step 9. Search archived article by DropDown list");
		articlePage.clickBtnClear();
		articlePage.clickBtnSearchTool();
		articlePage.waitForDivFilter(30);
		articlePage.selectStatusDropdownList("Archived");

		Log.info("Step 10. Verify that archived article displays in archived table");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Final. Clean data");
		articlePage.cleanData();
	}
}
