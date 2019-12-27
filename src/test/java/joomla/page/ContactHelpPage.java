package joomla.page;

import java.util.Set;

import joomla.constant.Constant;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactHelpPage {

	public boolean doesHelpPageDisplays() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 20);
		String parentWithHandle = Constant.WEBDRIVER.getWindowHandle();
		Set<String> winHandles = Constant.WEBDRIVER.getWindowHandles();
		for (String handles : winHandles) {
			if (!handles.equals(parentWithHandle)) {
				Constant.WEBDRIVER.switchTo().window(handles);
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
