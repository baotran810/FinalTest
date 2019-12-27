package joomla.page;

import java.util.concurrent.TimeUnit;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends GeneralPage {

	private String btnXpath = "//div[@id='toolbar-%s']/button";
	private String confirmMsg = "//div[@class='alert alert-success']/div[contains(text(),'%s')]";
	private String contactXpath = "//table[@id='contactList']//tr/td//a[normalize-space(text())='%s']";
	private String checkboxXpath = "//table[@id='contactList']//tr//a[normalize-space(text())='%s']//ancestor::tr//input[@type='checkbox']";
	private String statusXpath = "//table[@id='contactList']//tr//a[normalize-space(text())='%s']//ancestor::tr//span[@class='icon-%s']";
	private String itemStatus = "//select[@id='filter_published']/..//li[text()='%s']";

	private By _btnClear = By
			.cssSelector("button[class$='js-stools-btn-clear']");
	private By _btnSearchTool = By
			.cssSelector("button[class$='js-stools-btn-filter']");
	private By divFilter = By
			.cssSelector("div[class^='js-stools-container-filters']");
	private By _listStatus = By
			.xpath("//select[@id='filter_published']/..//span[text()='- Select Status -']");
	private By _txtSearch = By.xpath("//input[@id='filter_search']");
	private By _iconSeach = By.cssSelector("button[class$='hasTooltip']");
	private By _tagThead = By.xpath("//table[@id='contactList']/thead");
	private By _checkboxAll = By
			.xpath("//table[@id='contactList']/thead//input[@name='checkall-toggle']");

	private WebElement getCheckBox(String nameContact) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(
				checkboxXpath, nameContact)));
	}

	private WebElement getBtnSearchTool() {
		return Constant.WEBDRIVER.findElement(_btnSearchTool);
	}

	private WebElement getBtnClear() {
		return Constant.WEBDRIVER.findElement(_btnClear);
	}

	public boolean doesConfirmMsgDisplay(String message) {
		return Constant.WEBDRIVER.findElements(
				By.xpath(String.format(confirmMsg, message))).size() == 1;
	}

	public boolean doesContactExists(String nameContact) {
		return Constant.WEBDRIVER.findElements(
				By.xpath(String.format(contactXpath, nameContact))).size() == 1;
	}

	public boolean doesStatusExists(String nameContact, String status) {
		return Constant.WEBDRIVER.findElements(
				By.xpath(String.format(statusXpath, nameContact, status)))
				.size() == 1;
	}

	public boolean doesIconDisplay(String contactName, String status) {
		String xpathSt = String.format(statusXpath, contactName, status);
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(3, TimeUnit.SECONDS);
		return Constant.WEBDRIVER.findElements(By.xpath(xpathSt)).size() == 1;
	}

	public boolean doesContactExistBySearch(String nameContact) {
		return Constant.WEBDRIVER.findElements(
				By.xpath(String.format(contactXpath, nameContact))).size() != 0;
	}

	public void clickButton(String nameBtn) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(btnXpath, nameBtn))).click();
	}

	public void selectCheckBox(String nameContact) {
		if (!this.getCheckBox(nameContact).isSelected()) {
			this.getCheckBox(nameContact).click();
		}
	}

	public void clickContactName(String contactName) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(contactXpath, contactName))).click();
	}

	public void waitForDivFilter(int seconds) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(divFilter));
	}

	public void clickBtnClear() {
		this.getBtnClear().click();
	}

	public void clickBtnSearchTool() {
		this.getBtnSearchTool().click();
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

	public void searchText(String contactName) {
		Constant.WEBDRIVER.findElement(_txtSearch).sendKeys(contactName);
		Constant.WEBDRIVER.findElement(_iconSeach).click();
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
		Thread.sleep(20);
	}

}
