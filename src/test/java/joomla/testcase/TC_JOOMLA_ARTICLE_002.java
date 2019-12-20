package joomla.testcase;

import joomla.common.Log;
import joomla.common.Utilities;
import joomla.constant.Constant;
import joomla.page.AddNewArticle;
import joomla.page.ArticlePage;
import joomla.page.EditArticlePage;
import joomla.page.HomePage;
import joomla.page.LoginPage;

import org.testng.annotations.Test;

public class TC_JOOMLA_ARTICLE_002 extends TestHelper {
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	ArticlePage articlePage = new ArticlePage();
	AddNewArticle addNew = new AddNewArticle();
	EditArticlePage editArticle = new EditArticlePage();
	String articleName = Utilities.randomTitle();
	String articleContent = Utilities.randomContent();
	String category = "- Park Site";
	String newArticleName = Utilities.randomTitle();
	String newArticleContent = Utilities.randomContent();

	@Test(description = "TC_JOOMLA_ARTICLE_002 - Verify user can edit an article")
	public void testTC002() {
		Log.info("Step 1. Log in");
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Log.info("User can log in with valid account");

		Log.info("Step 2. Go to Article page");
		home.gotoArticle();

		Log.info("Step 3. Click New button");
		articlePage.clickNewButton();

		Log.info("Step 4. Fill information in new article page");
		addNew.CreateArticle(articleName, articleContent);
		
		Log.info("Step 5. Select article to edit");
		articlePage.clickEditButton(articleName);
		
		Log.info("Step 6. Edit article");
		editArticle.editArticle(newArticleName, newArticleContent, category);
	}
}
