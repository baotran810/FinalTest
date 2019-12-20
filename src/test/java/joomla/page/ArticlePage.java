package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class ArticlePage {
	
	private By btnNew = By
			.xpath("//div[@id='toolbar']//div[@id='toolbar-new']");
	private String checkBox = "//a[normalize-space(text())='%s']/../../preceding-sibling::td//input[@type='checkbox']";
	private By btnEdit = By.id("toolbar-edit");
	
	public AddNewArticle clickNewButton(){
		Constant.WEBDRIVER.findElement(btnNew).click();
		return new AddNewArticle();
	}
	
	public EditArticlePage clickEditButton(String articleName){
		Constant.WEBDRIVER.findElement(By.xpath(String.format(checkBox, articleName))).click();
		Constant.WEBDRIVER.findElement(btnEdit).click();
		return new EditArticlePage();
	}

}
