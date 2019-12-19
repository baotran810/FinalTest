package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewArticle {
	
	private By txtTitle = By.id("jform_title");
	private By iframe = By.id("jform_articletext_ifr");
	private By txtArea = By.id("tinymce");
	private By category = By
	.xpath("//label[@id='jform_catid-lbl']/..//following-sibling::div[@class='controls']");
	private By categoryList = By
	.xpath("//label[@id='jform_catid-lbl']/..//following-sibling::div//li[text()='Sample Data-Articles']");
	private By btnSaveClose = By
	.xpath("//div[@id='toolbar']//button[@class='btn btn-small button-save']");

	public static void iframe(String iframe_id, String childen_xpath,
	String text) {
	WebElement Element5 = Constant.WEBDRIVER.findElement(By.id(iframe_id));
	Constant.WEBDRIVER.switchTo().frame(Element5);
	Constant.WEBDRIVER.findElement(By.xpath(childen_xpath)).sendKeys(text);
	}

	public void CreateArticle(String title, String content) {
	WebElement Element5 = Constant.WEBDRIVER.findElement(iframe);
	Constant.WEBDRIVER.findElement(txtTitle).sendKeys(title);
	Constant.WEBDRIVER.switchTo().frame(Element5);
	Constant.WEBDRIVER.findElement(txtArea).sendKeys(content);
	Constant.WEBDRIVER.switchTo().defaultContent();
	Constant.WEBDRIVER.findElement(category).click();
	Constant.WEBDRIVER.findElement(categoryList).click();
	Constant.WEBDRIVER.findElement(btnSaveClose).click();
	}

}
