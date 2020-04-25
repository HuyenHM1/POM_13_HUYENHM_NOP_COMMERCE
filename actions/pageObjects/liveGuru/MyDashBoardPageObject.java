package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.MyDashBoardPageUI;

public class MyDashBoardPageObject extends AbstractPages {
	WebDriver driver;
	
	public MyDashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFullNameDisplayed(String fullNameText) {
		waitForElementVisible(15, String.format(MyDashBoardPageUI.FULL_NAME_TEXT, fullNameText), driver);
		return isElementDisplayed(String.format(MyDashBoardPageUI.FULL_NAME_TEXT, fullNameText), driver);
	}

	public boolean isEmailDisplayed(String emailText) {
		waitForElementVisible(15, String.format(MyDashBoardPageUI.EMAIL_TEXT, emailText), driver);
		return isElementDisplayed(String.format(MyDashBoardPageUI.EMAIL_TEXT, emailText), driver);
	}

}
