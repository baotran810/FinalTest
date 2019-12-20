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

public class TC_JOOMLA_ARTICLE_004 extends TestHelper{

	LoginPage login = new LoginPage();
	HomePage homepage = new HomePage();
	ArticlePage article = new ArticlePage();
	AddNewArticle addNewArticle = new AddNewArticle();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_004 - Verify user can unpublish a published article")
	public void TC004() {
		Log.info("Step 2. Login with valid account");
		login.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 3. Go to Article page ");
		homepage.gotoCreateArticle();

		Log.info("Step 4. Click on 'New' icon of the top right toolbar");
		article.clickNewButton();

		Log.info("Step 5. Fill \"Add new article\" form ");
		addNewArticle.CreateArticle(articleName, articleContent, "Published");
		
		Log.info("Step 6. Verify the article is saved successfully ");
		Assert.assertTrue(article.doesConfirmMessage("Article saved."), "Message displays.");
		Assert.assertTrue(article.doesArticleExists(articleName), "Article exists.");
		
		Log.info("Step 7. Check on the recently added article's checkbox");
		article.selectCheckbox(articleName);
		
		Log.info("Step 8. Click on 'Unpublish' icon of the top right toolbar");
		article.clickButton("unpublish");
		
		Log.info("Step 9. Verify the article is unpublished successfully");
		Assert.assertTrue(article.doesConfirmMessage("article unpublished."), "Message displays.");
		Assert.assertTrue(article.doesStatusExists(articleName, "unpublish"), "Set unpublish status successfully.");
	}

}
