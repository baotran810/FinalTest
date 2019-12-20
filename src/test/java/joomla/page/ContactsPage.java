package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends GeneralPage {

	private String btnXpath = "//div[@id='toolbar-%s']/button";
	private String confirmMsg = "//div[@class='alert alert-success']/div[contains(text(),'%s')]";
	private String contactXpath = "//table[@id='contactList']//tr/td//a[normalize-space(text())='%s']";
	private String checkboxXpath = "//table[@id='contactList']//tr//a[normalize-space(text())='%s']//ancestor::tr//input[@type='checkbox']";
	private String statusXpath = "//table[@id='contactList']//tr//a[normalize-space(text())='%s']//ancestor::tr//span[@class='icon-%s']";

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

}
