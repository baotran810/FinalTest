package joomla.page;

import java.util.concurrent.TimeUnit;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void clickBtnSearchTool() {
		Constant.WEBDRIVER.findElement(btnSearchTool).click();
	}
	
	public void waitForDivFilter(int seconds){
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(divFilter));
	}
	
	public void selectStatusDropdownList(String status) {
		Constant.WEBDRIVER.findElement(listStatus).click();
		Constant.WEBDRIVER.findElement(By.xpath(String.format(itemStatus, status))).click();
	}

	public void clickBtnSearchTool() {
		Constant.WEBDRIVER.findElement(btnSearchTool).click();
	}

	public void waitForDivFilter(int seconds) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(divFilter));
	}

	public void selectStatusDropdownList(String status) {
		Constant.WEBDRIVER.findElement(listStatus).click();
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemStatus, status))).click();
	}

}