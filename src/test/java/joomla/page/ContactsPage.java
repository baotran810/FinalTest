package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class ContactsPage extends GeneralPage {

	private By _btnNew = By.cssSelector(".button-new");
	private String messageXpath = "//div[text()='%s']";
	private String elementXpath = "//a[text()='%s']";

	public AddNewContactsPage AddNew() {
		Constant.WEBDRIVER.findElement(_btnNew).click();
		return new AddNewContactsPage();
	}

	public boolean checkMessage(String message) {
		boolean messageExist = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(messageXpath, message))).size() == 1;
		return messageExist;
	}

	public boolean checkElementExist(String element) {
		boolean elementExist = Constant.WEBDRIVER.findElements(
				By.xpath(String.format(elementXpath, element))).size() == 1;
		return elementExist;
	}

}
