package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class AddNewContactsPage extends GeneralPage {

	private String itemCategory = "//select[@id='jform_catid']/..//li[text()='%s']";
	private String itemStatus = "//select[@id='jform_published']/..//li[text()='%s']";

	private By _txtName = By.id("jform_name");
	private By _listCategory = By.xpath("//select[@id='jform_catid']/..//div");
	private By _listStatus = By.xpath("//select[@id='jform_published']/../div");
	private By _btnSaveAndClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public ContactsPage addNewContact(String name, String status,
			String category) {
		Constant.WEBDRIVER.findElement(_txtName).sendKeys(name);

		if (!status.equals("")) {
			Constant.WEBDRIVER.findElement(_listStatus).click();
			Constant.WEBDRIVER.findElement(
					By.xpath(String.format(itemStatus, status))).click();
		}

		Constant.WEBDRIVER.findElement(_listCategory).click();
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemCategory, category))).click();
		Constant.WEBDRIVER.findElement(_btnSaveAndClose).click();
		return new ContactsPage();
	}
	
}
