package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class EditArticlePage {

	private By txtTitle = By.id("jform_title");
	private By iframe = By.id("jform_articletext_ifr");
	private By txtArea = By.id("tinymce");
	private By category = By
			.xpath("//label[@id='jform_catid-lbl']/..//following-sibling::div[@class='controls']");
	private String categoryItem = "//label[@id='jform_catid-lbl']/..//following-sibling::div//li[text()='%s']";
	private By btnSaveClose = By
			.xpath("//div[@id='toolbar']//button[@class='btn btn-small button-save']");

	public void editArticle(String newTitle, String newContent, String newCategory) {
		WebElement Element5 = Constant.WEBDRIVER.findElement(iframe);
		Constant.WEBDRIVER.findElement(txtTitle).clear();
		Constant.WEBDRIVER.findElement(txtTitle).sendKeys(newTitle);
		Constant.WEBDRIVER.switchTo().frame(Element5);
		Constant.WEBDRIVER.findElement(txtArea).sendKeys(newContent);
		Constant.WEBDRIVER.switchTo().defaultContent();
		Constant.WEBDRIVER.findElement(category).click();
		Constant.WEBDRIVER.findElement(By.xpath(String.format(categoryItem, newCategory))).click();
		Constant.WEBDRIVER.findElement(btnSaveClose).click();
	}

}
