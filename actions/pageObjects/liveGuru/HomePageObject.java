package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.HomePageUI;

public class HomePageObject extends AbstractPages{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitForElementClickable(15, HomePageUI.MY_ACCOUNT_LINK, driver);
		clickToElement(HomePageUI.MY_ACCOUNT_LINK, driver);
		return new LoginPageObject(driver);
	}

}
