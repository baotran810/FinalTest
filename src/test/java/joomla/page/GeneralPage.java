package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {

	private By tabComponents = By
			.xpath("//a[normalize-space(text())='Components']");
	private By tabContacts = By
			.xpath("//ul//li//a[@class='dropdown-toggle menu-contact' and text()='Contacts']");

	private WebElement getTabComponents() {
		return Constant.WEBDRIVER.findElement(tabComponents);
	}

	private WebElement getTabContacts() {
		return Constant.WEBDRIVER.findElement(tabContacts);
	}

	public ContactsPage gotoContactPage() {
		this.getTabComponents().click();
		this.getTabContacts().click();
		return new ContactsPage();
	}

}
