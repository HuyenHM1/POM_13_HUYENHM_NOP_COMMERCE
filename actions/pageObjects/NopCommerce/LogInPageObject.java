package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.LoginPageUI;

public class LogInPageObject extends AbstractPages {
	WebDriver driver;
	
	public LogInPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(30, LoginPageUI.EMAIL_TEXTBOX, driver);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, emailValue, driver);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(15, LoginPageUI.PASSWORD_TEXTBOX, driver);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordValue, driver);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(15, LoginPageUI.LOGIN_BUTTON, driver);
		clickToElement(LoginPageUI.LOGIN_BUTTON, driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
