package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class ArticlePage {
	
	private By btnNew = By
			.xpath("//div[@id='toolbar']//div[@id='toolbar-new']");
	private By confirmMsg = By
			.xpath("//div[@id='system-message-container']//div[@class='alert-message']");
	
	public AddNewArticle clickNewbutton(){
		Constant.WEBDRIVER.findElement(btnNew).click();
		return new AddNewArticle();
	}

}
