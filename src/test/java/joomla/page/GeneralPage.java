package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class GeneralPage {

	private By linkContent = By
			.xpath("//ul[@id='menu']//li/a[normalize-space(text())='Content']");
	private By linkArticle = By
			.xpath("//ul[@id='menu']//li/a[text()='Articles']");

	public void gotoCreateArticle() {
		Constant.WEBDRIVER.findElement(linkContent).click();
		Constant.WEBDRIVER.findElement(linkArticle).click();
	}

}
