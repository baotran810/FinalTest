package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class ArticlePage {
	
	private By btnNew = By
			.xpath("//div[@id='toolbar']//div[@id='toolbar-new']");

	
	public AddNewArticle clickNewbutton(){
		Constant.WEBDRIVER.findElement(btnNew).click();
		return new AddNewArticle();
	}
 
}
