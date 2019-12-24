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
	private By btnClear = By
			.cssSelector("button[class$='js-stools-btn-clear']");
	private By btnSearchTool = By
			.cssSelector("button[class$='js-stools-btn-filter']");
	private By divFilter = By
			.cssSelector("div[class^='js-stools-container-filters']");
	private By listStatus = By
			.xpath("//select[@id='filter_published']/..//span[text()='- Select Status -']");

	private String itemStatus = "//select[@id='filter_published']/..//li[text()='%s']";

	private By txtSearch = By.xpath("//input[@id='filter_search']");
	private By iconSeach = By.cssSelector("button[class$='hasTooltip']");

	private WebElement getCheckbox(String nameContact) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(
				checkboxXpath, nameContact)));
	}

	public void clickButton(String nameBtn) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(btnXpath, nameBtn))).click();
	}

	public boolean doesConfirmMsgDisplays(String message) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(confirmMsg, message))).size() == 1;
		return exists;
	}

	public boolean doesContactExists(String nameContact) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(contactXpath, nameContact))).size() == 1;
		return exists;
	}

	public void selectCheckbox(String nameContact) {
		if (!this.getCheckbox(nameContact).isSelected()) {
			this.getCheckbox(nameContact).click();
		}
	}

	public boolean doesStatusExists(String nameContact, String status) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(statusXpath, nameContact, status)))
				.size() == 1;
		return exists;
	}

	public void clickContactName(String contactName) {
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(contactXpath, contactName))).click();
	}

	public void clickBtnClear() {
		Constant.WEBDRIVER.findElement(btnClear).click();
	}

	public void clickBtnSearchTool() {
		Constant.WEBDRIVER.findElement(btnSearchTool).click();
	}

	public void waitForDivFilter(int seconds) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(divFilter));
	}

	public void selectStatusDropdownList(String status)
			throws InterruptedException {
		Thread.sleep(60);
		Constant.WEBDRIVER.findElement(listStatus).click();
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemStatus, status))).click();
	}

	public boolean doesIconDisplay(String contactName, String status) {
		String xpathSt = String.format(statusXpath, contactName, status);
		Constant.WEBDRIVER.manage().timeouts()
				.implicitlyWait(3, TimeUnit.SECONDS);
		return Constant.WEBDRIVER.findElements(By.xpath(xpathSt)).size() == 1;
	}

	public void textSearch(String contactName) {
		Constant.WEBDRIVER.findElement(txtSearch).sendKeys(contactName);
		Constant.WEBDRIVER.findElement(iconSeach).click();
	}

	public boolean doesContactExistBySearch(String nameContact) {
		boolean exists = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(contactXpath, nameContact))).size() != 0;
		return exists;
	}
}
