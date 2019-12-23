package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class AddNewContactsPage extends GeneralPage {

	private By txtName = By.id("jform_name");
	private By listCategory = By.xpath("//select[@id='jform_catid']/..//div");
	private By listStatus = By.xpath("//select[@id='jform_published']/../div");
	private String itemCategory = "//select[@id='jform_catid']/..//li[text()='%s']";
	private String itemStatus = "//select[@id='jform_published']/..//li[text()='%s']";
	private By btnSaveAndClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public ContactsPage addNewContact(String name, String status,
			String category) {
		Constant.WEBDRIVER.findElement(txtName).sendKeys(name);

		if (!status.equals("")) {
			Constant.WEBDRIVER.findElement(listStatus).click();
			Constant.WEBDRIVER.findElement(
					By.xpath(String.format(itemStatus, status))).click();
		}
		
		Constant.WEBDRIVER.findElement(listCategory).click();
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemCategory, category))).click();
		Constant.WEBDRIVER.findElement(btnSaveAndClose).click();
		return new ContactsPage();
	}

}
