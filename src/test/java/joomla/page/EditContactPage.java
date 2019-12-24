package joomla.page;

import org.openqa.selenium.By;

import joomla.constant.Constant;

public class EditContactPage {
	private By txtName = By.id("jform_name");
	private By listCategory = By.xpath("//select[@id='jform_catid']/..//div");
	private String itemCategory = "//select[@id='jform_catid']/..//li[text()='%s']";
	private By btnSaveAndClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public void editContact(String newName, String newCategory) {
		Constant.WEBDRIVER.findElement(txtName).clear();
		Constant.WEBDRIVER.findElement(txtName).sendKeys(newName);
		Constant.WEBDRIVER.findElement(listCategory).click();
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemCategory, newCategory))).click();
		Constant.WEBDRIVER.findElement(btnSaveAndClose).click();
	}
}
