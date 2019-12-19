package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


//import Common.*;


public class GeneralPage {
	
	private final By tabComponents = By.xpath("//a[normalize-space(text())='Components']");
	private final By tabContacts = By.xpath("//ul//li//a[@class='dropdown-toggle menu-contact' and text()='Contacts']");
	
	private WebElement getTabComponents(){
		return Constant.WEBDRIVER.findElement(tabComponents);
	}
	
	private WebElement getTabContacts(){
		return Constant.WEBDRIVER.findElement(tabContacts);
	}
	
	//go to Contact page
	public ContactsPage gotoContactPage(){
		this.getTabComponents().click();
		this.getTabContacts().click();
		return new ContactsPage();
	}


}
