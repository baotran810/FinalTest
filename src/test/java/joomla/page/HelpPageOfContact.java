package joomla.page;

import java.util.Set;

import joomla.constant.Constant;

public class HelpPageOfContact {

	public boolean doesHelpPageDisplays() throws InterruptedException {
		boolean exist = true;
		String parentWithHandle = Constant.WEBDRIVER.getWindowHandle();
		Set<String> winHandles = Constant.WEBDRIVER.getWindowHandles();
		for (String handles : winHandles) {
			if (!handles.equals(parentWithHandle)) {
				Constant.WEBDRIVER.switchTo().window(handles);
				Thread.sleep(1000);
				String title = Constant.WEBDRIVER.getTitle();
				System.out.println("Title is: " + title);
				if (title.equals("Joomla! Help Screens"))
					exist = true;
				else
					exist = false;
			}
		}

		return exist;
	}

}
