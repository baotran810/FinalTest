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

public class TC_JOOMLA_ARTICLE_003 extends TestHelper {
	
	LoginPage login = new LoginPage();
	HomePage homepage = new HomePage();
	ArticlePage article = new ArticlePage();
	AddNewArticle addNewArticle = new AddNewArticle();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();
	
	@Test(description = "TC_JOOMLA_ARTICLE_003 - Verify user can publish an unpublished article")	
	public void TC003() {		
		Log.info("Step 2. Login with valid account");
		login.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 3. Go to Article page ");
		homepage.gotoCreateArticle();

		Log.info("Step 4. Click on 'New' icon of the top right toolbar");
		article.clickNewbutton();

		Log.info("Step 5. Fill \"Add new article\" form ");
		addNewArticle.CreateArticle(articleName, articleContent, "Unpublished");
		
		Log.info("Step 6. Verify the article is saved successfully ");
		Assert.assertTrue(article.doesConfirmMessage("Article saved."), "Message displays.");
		Assert.assertTrue(article.doesArticleExists(articleName), "Article exists.");
		
		Log.info("Step 7. Check on the recently added article's checkbox");
		article.selectCheckbox(articleName);
		
		Log.info("Step 8. Click on 'Publish' icon of the top right toolbar");
		article.clickButton("publish");
		
		Log.info("Step 9. Verify the article is published successfully");
		Assert.assertTrue(article.doesConfirmMessage("article published."), "Message displays.");
		Assert.assertTrue(article.doesStatusExists(articleName, "publish"), "Set publish status successfully.");
	}
}
