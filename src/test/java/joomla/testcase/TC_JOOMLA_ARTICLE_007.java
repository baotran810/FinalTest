package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticle;
import joomla.page.ArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_007 extends TestHelper {

	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage article = new ArticlePage();
	AddNewArticle addNewArticle = new AddNewArticle();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test
	public void testTC007() throws InterruptedException {
		Log.info("Step 1. Login with valid account");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 2. Go to Article page ");
		homePage.gotoArticle();

		Log.info("Step 3. Click on 'New' icon of the top right toolbar");
		article.clickButton("new");

		Log.info("Step 4. Fill \"Add new article\" form ");
		addNewArticle.createArticle(articleName, articleContent, "Published");

		Log.info("VP. Verify the article is saved successfully ");
		Assert.assertTrue(article.doesConfirmMessageDisplays("Article saved."),
				"Message displays.");
		Assert.assertTrue(article.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Step 5. Check on the recently added article's checkbox");
		article.selectCheckbox(articleName);

		Log.info("Step 6. Click on 'Trash' icon of the top right toolbar");
		article.clickButton("trash");

		Log.info("VP. Verify the confirm message is displayed");
		Assert.assertTrue(
				article.doesConfirmMessageDisplays("article trashed."),
				"Message displays.");

		Log.info("Step 7. Select 'Trash' item of 'Status' dropdown list");
		article.clickBtnClear();
		article.clickBtnSearchTool();
		article.waitForDivFilter(30);
		article.selectStatusDropdownList("Trashed");

		Log.info("VP. Verify the deleted article is displayed on the table grid");
		Assert.assertTrue(article.doesArticleExists(articleName),
				"Article exists.");
	}

}
