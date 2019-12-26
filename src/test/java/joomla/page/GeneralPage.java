package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class GeneralPage {

	private By _linkContent = By
			.xpath("//ul[@id='menu']//li/a[normalize-space(text())='Content']");
	private By _linkArticle = By
			.xpath("//ul[@id='menu']//li/a[text()='Articles']");
	private By _linkComponents = By.xpath("//ul[@id='menu']//li/a[normalize-space(text())='Components']");
	private By _linkContacts = By.xpath("//ul[@id='menu']//li[@class='dropdown-submenu']/a[text()='Contacts']");

	public void gotoArticle() {
		Constant.WEBDRIVER.findElement(_linkContent).click();
		Constant.WEBDRIVER.findElement(_linkArticle).click();
	}
	
	public void goToContacts() {
		Constant.WEBDRIVER.findElement(_linkComponents).click();
		Constant.WEBDRIVER.findElement(_linkContacts).click();
	}

}
