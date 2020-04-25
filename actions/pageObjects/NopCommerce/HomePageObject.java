package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.HomePageUI;

public class HomePageObject extends AbstractPages {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(15, HomePageUI.REGISTER_LINK, driver);
		clickToElement(HomePageUI.REGISTER_LINK, driver);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public LogInPageObject clickToLoginLink() {
		waitForElementClickable(15, HomePageUI.LOGIN_LINK, driver);
		clickToElement(HomePageUI.LOGIN_LINK, driver);
		return PageGeneratorManager.getLogInPageObject(driver);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(15, HomePageUI.MY_ACCOUNT_HEADER_LINK, driver);
		return isElementDisplayed(HomePageUI.MY_ACCOUNT_HEADER_LINK, driver);
	}

}
