package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class AddNewContactsPage extends GeneralPage {

	private By txtName = By.id("jform_name");
	private By btnCategory = By.cssSelector("#jform_catid_chzn");
	private By btnCategoryItem = By.xpath("//li[text()='Sample Data-Contact']");
	private By btnSaveandClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public ContactsPage addNewContact(String name) {
		Constant.WEBDRIVER.findElement(txtName).sendKeys(name);
		Constant.WEBDRIVER.findElement(btnCategory).click();
		Constant.WEBDRIVER.findElement(btnCategoryItem).click();
		Constant.WEBDRIVER.findElement(btnSaveandClose).click();
		return new ContactsPage();
	}

}
