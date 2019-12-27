package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditArticlePage {
	private String categoryItem = "//label[@id='jform_catid-lbl']/..//following-sibling::div//li[text()='%s']";
	
	private By _txtTitle = By.id("jform_title");
	private By _iframe = By.id("jform_articletext_ifr");
	private By _txtArea = By.id("tinymce");
	private By _category = By
			.xpath("//label[@id='jform_catid-lbl']/..//following-sibling::div[@class='controls']");
	private By _btnSaveClose = By
			.xpath("//div[@id='toolbar']//button[@class='btn btn-small button-save']");

	public void editArticle(String newTitle, String newContent,
			String newCategory) {
		WebElement iframe = Constant.WEBDRIVER.findElement(_iframe);
		Constant.WEBDRIVER.findElement(_txtTitle).clear();
		Constant.WEBDRIVER.findElement(_txtTitle).sendKeys(newTitle);
		Constant.WEBDRIVER.switchTo().frame(iframe);
		Constant.WEBDRIVER.findElement(_txtArea).sendKeys(newContent);
		Constant.WEBDRIVER.switchTo().defaultContent();
		Constant.WEBDRIVER.findElement(_category).click();
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(categoryItem, newCategory))).click();
		Constant.WEBDRIVER.findElement(_btnSaveClose).click();
	}

}
