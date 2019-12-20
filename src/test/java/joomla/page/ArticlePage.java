package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {

	private String confirmMsg = "//div[@class='alert alert-success']/div[contains(text(),'%s')]";
	private String articleXpath = "//table[@id='articleList']//tr/td//a[normalize-space(text())='%s']";
	private String checkboxXpath = "//table[@id='articleList']//tr//a[normalize-space(text())='%s']//ancestor::tr//input[@type='checkbox']";
	private String btnXpath = "//div[@id='toolbar']//div[@id='toolbar-%s']/button";
	private String statusXpath = "//table[@id='articleList']//tr//a[normalize-space(text())='%s']//ancestor::tr//span[@class='icon-%s']";
	private By btnSearchTool = By.cssSelector("button[class$='js-stools-btn-filter']");
	private By divFilter = By.cssSelector("div[class^='js-stools-container-filters']");
	private By listStatus = By.xpath("//select[@id='filter_published']/..//span[text()='- Select Status -']");
	private String itemStatus = "//select[@id='filter_published']/..//li[text()='%s']";
	
	private WebElement getCheckbox(String articleName) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(
				checkboxXpath, articleName)));
	}

	public boolean doesConfirmMessageDisplays(String message) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(confirmMsg, message))).size() == 1;
		return exists;
	}

	public boolean doesArticleExists(String articleName) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(articleXpath, articleName))).size() == 1;
		return exists;
	}

	public void selectCheckbox(String articleName) {
		if (!this.getCheckbox(articleName).isSelected()) {
			this.getCheckbox(articleName).click();
		}
	}

	public void clickButton(String buttonName) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(btnXpath, buttonName))).click();
	}

	public boolean doesStatusExists(String articleName, String status) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(statusXpath, articleName, status)))
				.size() == 1;
		return exists;
	}
	
	

}