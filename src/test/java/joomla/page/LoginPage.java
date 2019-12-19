package joomla.page;

import joomla.common.Log;
import joomla.constant.Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private final By _txtUsername = By.id("mod-login-username");
	private final By _txtPassword = By.id("mod-login-password");
	private final By _btnLogin = By.xpath("//button[contains(@class,login-button)]");
	
	private WebElement getTxtUsername(){
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}
	
	private WebElement getTxtPassword(){
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}
	
	private WebElement getBtnLogin(){
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}
	
	//log in 
	public HomePage login(String username, String password){
		Log.info("Fill username textbox");
		this.getTxtUsername().sendKeys(username);
		
		Log.info("Fill password textbox");
		this.getTxtPassword().sendKeys(password);
		
		Log.info("Click Login button");
		this.getBtnLogin().click();
		
		return new HomePage();
	}

}
