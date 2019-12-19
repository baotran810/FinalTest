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

public class TcJoomlaArticle004 extends TestHelper{

	LoginPage lg = new LoginPage();
	HomePage hp = new HomePage();
	ArticlePage article = new ArticlePage();
	AddNewArticle addNew = new AddNewArticle();

	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_004 - Verify user can unpublish a published article")
	public void TC004() {
		Log.info("Step 2. Login with valid account");
		lg.login(Constant.USERNAME, Constant.PASSWORD);

		Log.info("Step 3. Go to Article page ");
		hp.gotoCreateArticle();

		Log.info("Step 4. Click on 'New' icon of the top right toolbar");
		article.clickNewbutton();

		Log.info("Step 5. Fill \"Add new article\" form ");
		addNew.CreateArticle(articleName, articleContent, "Published");
		
		Log.info("Step 6. Verify the article is saved successfully ");
		Assert.assertTrue(article.checkConfirmMessage("Article saved."), "Message displays.");
		Assert.assertTrue(article.checkArticleExists(articleName), "Article exists.");
		
		Log.info("Step 7. Check on the recently added article's checkbox");
		article.selectCheckbox(articleName);
		
		Log.info("Step 8. Click on 'Unpublish' icon of the top right toolbar");
		article.clickButton("unpublish");
		
		Log.info("Step 9. Verify the article is unpublished successfully");
		Assert.assertTrue(article.checkConfirmMessage("article unpublished."), "Message displays.");
		Assert.assertTrue(article.checkStatusExists(articleName, "unpublish"), "Set unpublish status successfully.");
	}

}
