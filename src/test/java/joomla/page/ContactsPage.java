package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class ContactsPage extends GeneralPage {
	
	private final By _btnNew = By.cssSelector(".button-new");
	private final String messageXpath = "//div[text()='%s']";
	private final String elementXpath = "//a[text()='%s']";
	
	//click New button to add new contact
	public AddNewContactsPage AddNew(){
		Constant.WEBDRIVER.findElement(_btnNew).click();
		return new AddNewContactsPage();
	}
	
	//check if Message exists
	public boolean checkMessage(String message){
		
		boolean messageExist = Constant.WEBDRIVER.findElements(By.xpath(String.format(messageXpath, message))).size()==1;
		return messageExist;
	}
	
	//check if created contact exits
	public boolean checkElementExist(String element){
		boolean elementExist = Constant.WEBDRIVER.findElements(By.xpath(String.format(elementXpath, element))).size()==1;
		return elementExist;
	}

}
