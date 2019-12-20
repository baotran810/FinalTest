package joomla.page;

import joomla.constant.Constant;
import org.openqa.selenium.By;

public class LoginPage {

	private By txtUsername = By.id("mod-login-username");
	private By txtPassword = By.id("mod-login-password");
	private By btnLogin = By.xpath("//button[contains(@class,login-button)]");

	public HomePage login(String username, String password) {
		Constant.WEBDRIVER.findElement(txtUsername).sendKeys(username);
		Constant.WEBDRIVER.findElement(txtPassword).sendKeys(password);
		Constant.WEBDRIVER.findElement(btnLogin).click();
		return new HomePage();
	}

}
