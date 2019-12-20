package joomla.page;

import java.util.Set;

import joomla.constant.Constant;

public class HelpPage {

	public boolean doesHelpPageDisplays() throws InterruptedException {
		String parentWinHandle = Constant.WEBDRIVER.getWindowHandle();
		Set<String> winHandles = Constant.WEBDRIVER.getWindowHandles();
		boolean exists = true;
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				Constant.WEBDRIVER.switchTo().window(handle);
				Thread.sleep(1000);
				System.out.println("Title of the new window: "
						+ Constant.WEBDRIVER.getTitle());
				String title = Constant.WEBDRIVER.getTitle();
				if (title.equals("Joomla! Help Screens"))
					exists = true;
				else
					exists = false;
			}
		}
		return exists;
	}

}
