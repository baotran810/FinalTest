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
	private String itemStatus = "//select[@id='filter_published']/..//li[text()='%s']";

	private By _btnClear = By
			.cssSelector("button[class$='js-stools-btn-clear']");
	private By _btnSearchTool = By
			.cssSelector("button[class$='js-stools-btn-filter']");
	private By _divFilter = By
			.cssSelector("div[class^='js-stools-container-filters']");
	private By _listStatus = By
			.xpath("//select[@id='filter_published']/..//span[text()='- Select Status -']");
	private By _tagThead = By.xpath("//table[@id='articleList']/thead");
	private By _checkboxAll = By
			.xpath("//table[@id='articleList']/thead//input[@name='checkall-toggle']");

	private WebElement getCheckbox(String articleName) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(
				checkboxXpath, articleName)));
	}

	private WebElement getBtnSearchTool() {
		return Constant.WEBDRIVER.findElement(_btnSearchTool);
	}

	private WebElement getBtnClear() {
		return Constant.WEBDRIVER.findElement(_btnClear);
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

	public boolean doesStatusExists(String articleName, String status) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(statusXpath, articleName, status)))
				.size() == 1;
		return exists;
	}

	public boolean doesIconDisplay(String articleName, String status) {
		String xpathSt = String.format(statusXpath, articleName, status);
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(3, TimeUnit.SECONDS);
		return Constant.WEBDRIVER.findElements(By.xpath(xpathSt)).size() == 1;
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

	public void clickArticleName(String articleName) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(articleXpath, articleName))).click();
	}

	public void waitForDivFilter(int seconds) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(_divFilter));
	}

	public void clickBtnSearchTool() {
		this.getBtnSearchTool().click();
	}

	public void clickBtnClear() {
		this.getBtnClear().click();
	}

	public void selectStatusDropdownList(String status)
			throws InterruptedException {
		Thread.sleep(60);
		Constant.WEBDRIVER.findElement(_listStatus).click();
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemStatus, status))).click();
	}

	public void cleanData() throws InterruptedException {
		if (Constant.WEBDRIVER.findElements(_tagThead).size() == 1) {
			Constant.WEBDRIVER.findElement(_checkboxAll).click();
			this.clickButton("trash");
		}

		this.getBtnClear().click();
		this.getBtnSearchTool().click();
		Thread.sleep(100);
		Constant.WEBDRIVER.findElement(_listStatus).click();
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemStatus, "Archived"))).click();

		while (Constant.WEBDRIVER.findElements(
				By.xpath("//div[@class='alert alert-no-items']")).size() == 0) {
			Constant.WEBDRIVER.findElement(_checkboxAll).click();
			this.clickButton("trash");
		}
		this.getBtnClear().click();
		this.getBtnSearchTool().click();
		Thread.sleep(100);
		Constant.WEBDRIVER.findElement(_listStatus).click();
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemStatus, "Trashed"))).click();

		if (Constant.WEBDRIVER.findElements(_tagThead).size() == 1) {
			Constant.WEBDRIVER.findElement(_checkboxAll).click();
			this.clickButton("delete");
		}

		Constant.WEBDRIVER.switchTo().alert().accept();
	}

}