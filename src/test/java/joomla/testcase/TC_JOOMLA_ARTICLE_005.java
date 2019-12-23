package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticle;
import joomla.page.ArticlePage;
import joomla.page.EditArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_005 extends TestHelper {

	LoginPage logIn = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage article = new ArticlePage();
	AddNewArticle addNew = new AddNewArticle();
	EditArticlePage editArticle = new EditArticlePage();
	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_005 - User can move an article to the archive")
	public void testTC005() throws InterruptedException {
		Log.info("Step 1. Log in");
		logIn.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		homePage.gotoArticle();

		Log.info("Step 3. Click New button");
		article.clickButton("new");

		Log.info("Step 4. Fill information in new article page");
		addNew.createArticle(articleName, articleContent, "");

		Log.info("Step 5. Verify the article is saved successfully ");
		Assert.assertTrue(article.doesConfirmMessageDisplays("Article saved."),
				"Message displays.");
		Assert.assertTrue(article.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Step 6. Select article to archive");
		article.selectCheckbox(articleName);

		Log.info("Step 7. Click on 'Archive' icon of the top right toolbar");
		article.clickButton("archive");
		
		Log.info("Step 8. Verify that the confirm message displays after archiving article");
		Assert.assertTrue(article.doesConfirmMessageDisplays("article archived."), "Message displays.");
		
		Log.info("Step 9. Search archived article by DropDown list");
		article.clickBtnClear();
		article.clickBtnSearchTool();
		article.waitForDivFilter(30);
		article.selectStatusDropdownList("Archived");
		
		Log.info("Step 10. Verify that archived article displays in archived table");
		Assert.assertTrue(article.doesArticleExists(articleName), "Article exists.");
	}
}
