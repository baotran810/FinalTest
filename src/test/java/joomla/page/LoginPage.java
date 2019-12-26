package joomla.page;

import joomla.constant.Constant;

import org.openqa.selenium.By;

public class LoginPage {

	private By _txtUsername = By.id("mod-login-username");
	private By _txtPassword = By.id("mod-login-password");
	private By _btnLogin = By.xpath("//button[contains(@class,login-button)]");

	public HomePage login(String username, String password) {
		Constant.WEBDRIVER.findElement(_txtUsername).sendKeys(username);
		Constant.WEBDRIVER.findElement(_txtPassword).sendKeys(password);
		Constant.WEBDRIVER.findElement(_btnLogin).click();
		return new HomePage();
	}

}
