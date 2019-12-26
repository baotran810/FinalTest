package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class EditContactPage {
	
	private String itemCategory = "//select[@id='jform_catid']/..//li[text()='%s']";
	
	private By _txtName = By.id("jform_name");
	private By _txtAlias = By.id("jform_alias");
	private By _listCategory = By.xpath("//select[@id='jform_catid']/..//div");
	private By _btnSaveAndClose = By
			.xpath("//button[@class='btn btn-small button-save']");

	public void editContact(String newName, String newCategory) {
		Constant.WEBDRIVER.findElement(_txtName).clear();
		Constant.WEBDRIVER.findElement(_txtAlias).clear();
		Constant.WEBDRIVER.findElement(_txtName).sendKeys(newName);
		Constant.WEBDRIVER.findElement(_listCategory).click();
		Constant.WEBDRIVER.findElement(
				By.xpath(String.format(itemCategory, newCategory))).click();
		Constant.WEBDRIVER.findElement(_btnSaveAndClose).click();
	}
}
