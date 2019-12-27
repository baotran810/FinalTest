package joomla.page;

import java.util.Set;

import joomla.constant.Constant;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticleHelpPage {

	public boolean doesHelpPageDisplays() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);
		// get current window handle
		String parentWinHandle = Constant.WEBDRIVER.getWindowHandle();
		// get the window handles of all the open windows in a set
		Set<String> winHandles = Constant.WEBDRIVER.getWindowHandles();
		// loop through all handles
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				Constant.WEBDRIVER.switchTo().window(handle);
				wait.until(ExpectedConditions.titleIs(Constant.HELPAGE_TITLE));
				String title = Constant.WEBDRIVER.getTitle();
				if (title.equals(Constant.HELPAGE_TITLE))
					return true;
				else
					return false;
			}
		}
		return false;
	}

}
