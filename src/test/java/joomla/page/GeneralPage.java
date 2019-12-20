package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class GeneralPage {

	private By linkContent = By
			.xpath("//ul[@id='menu']//li/a[normalize-space(text())='Content']");
	private By linkArticle = By
			.xpath("//ul[@id='menu']//li/a[text()='Articles']");
	private By linkComponents = By.xpath("//ul[@id='menu']//li/a[normalize-space(text())='Components']");
	private By linkContacts = By.xpath("//ul[@id='menu']//li[@class='dropdown-submenu']/a[text()='Contacts']");

	public void gotoArticle() {
		Constant.WEBDRIVER.findElement(linkContent).click();
		Constant.WEBDRIVER.findElement(linkArticle).click();
	}
	
	public void goToContacts() {
		Constant.WEBDRIVER.findElement(linkComponents).click();
		Constant.WEBDRIVER.findElement(linkContacts).click();
	}

}
