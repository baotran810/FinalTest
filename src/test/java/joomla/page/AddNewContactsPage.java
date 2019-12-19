package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class AddNewContactsPage extends GeneralPage {

	private By _txtName = By.id("jform_name");
	private By _btnCategory = By.cssSelector("#jform_catid_chzn");
	private By _btnCategoryItem = By
			.xpath("//li[text()='Sample Data-Contact']");
	private By _btnSaveandClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public ContactsPage addNewContact(String name) {
		Constant.WEBDRIVER.findElement(_txtName).sendKeys(name);
		Constant.WEBDRIVER.findElement(_btnCategory).click();
		Constant.WEBDRIVER.findElement(_btnCategoryItem).click();
		Constant.WEBDRIVER.findElement(_btnSaveandClose).click();
		return new ContactsPage();
	}

}
