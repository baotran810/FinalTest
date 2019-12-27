package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticlePage;
import joomla.page.ArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_006 extends TestHelper {

	LoginPage logInPage = new LoginPage();
	HomePage homePage = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticlePage addNewArticlePage = new AddNewArticlePage();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_006 - Verify user can check in an article")
	public void testTC006() throws InterruptedException {

		Log.info("Step 2. Login with valid account");
		logInPage.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 3. Go to Article page ");
		homePage.gotoArticle();

		Log.info("Step 4. Click on 'New' icon of the top right toolbar");
		articlePage.clickButton("new");

		Log.info("Step 5. Fill \"Add new article\" form ");
		addNewArticlePage.createArticle(articleName, articleContent, "Published");

		Log.info("Step 6. Verify the article is saved successfully ");
		Assert.assertTrue(articlePage.doesConfirmMessageDisplay("Article saved."),
				"Message displays.");
		Assert.assertTrue(articlePage.doesArticleExists(articleName),
				"Article exists.");

		Log.info("Step 7. Check on the recently added article's checkbox");
		articlePage.selectCheckBox(articleName);

		Log.info("Step 8. Click on 'Check In' icon of the top right toolbar");
		articlePage.clickButton("checkin");

		Log.info("Step 9. Verify the article is checked in successfully");
		Assert.assertTrue(
				articlePage.doesConfirmMessageDisplay("1 article checked in."),
				"Message displays.");
		articlePage.clickArticleName(articleName);
		JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
		js.executeScript("history.go(-1);");

		Boolean isExist = articlePage.doesIconDisplay(articleName, "checkedout");
		Assert.assertTrue(isExist, "Set check-out status successfully.");
		
		Log.info("Final. Clean data");
		articlePage.cleanData();
	}
}
