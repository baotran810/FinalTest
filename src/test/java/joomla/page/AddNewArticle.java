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
	private By listStatus = By
			.xpath("//select[@id='jform_state']/..//span[text()='Published']");
	private String liStatus = "//select[@id='jform_state']/..//li[text()='%s']";

	public void createArticle(String title, String content, String status) {
		WebElement Element5 = Constant.WEBDRIVER.findElement(iframe);
		Constant.WEBDRIVER.findElement(txtTitle).sendKeys(title);
		Constant.WEBDRIVER.switchTo().frame(Element5);
		Constant.WEBDRIVER.findElement(txtArea).sendKeys(content);
		Constant.WEBDRIVER.switchTo().defaultContent();

		if (!status.equals("")) {
			Constant.WEBDRIVER.findElement(listStatus).click();
			Constant.WEBDRIVER.findElement(
					By.xpath(String.format(liStatus, status))).click();
		}

		Constant.WEBDRIVER.findElement(category).click();
		Constant.WEBDRIVER.findElement(categoryList).click();
		Constant.WEBDRIVER.findElement(btnSaveClose).click();
	}

}
