package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.liveGuru.LoginPageUI;

public class LoginPageObject extends AbstractPages {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmailTextbox(String emailValue) {
		waitForElementVisible(30, LoginPageUI.EMAIL_TEXTBOX, driver);
		sendkeyToElement(LoginPageUI.EMAIL_TEXTBOX, emailValue, driver);
	}

	public void inputPasswordTextbox(String passwordValue) {
		waitForElementVisible(30, LoginPageUI.PASSWORD_TEXTBOX, driver);
		sendkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, passwordValue, driver);
	}

	public MyDashBoardPageObject clickToLoginButton() {
		waitForElementClickable(30, LoginPageUI.LOGIN_BUTTON, driver);
		clickToElement(LoginPageUI.LOGIN_BUTTON, driver);
		return new MyDashBoardPageObject(driver);

	}

	public boolean isEmptyEmailErrorMessageDisplayed(String emptyEmailErrorMessage) {
		waitForElementVisible(30, String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, emptyEmailErrorMessage), driver);
		return isElementDisplayed(String.format(LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE, emptyEmailErrorMessage), driver);
	}

	public boolean isEmptyPasswordErrorMessageDisplayed(String emptyPasswordErrorMessage) {
		waitForElementVisible(30, String.format(LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE, emptyPasswordErrorMessage),
				driver);
		return isElementDisplayed(String.format(LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE, emptyPasswordErrorMessage),
				driver);
	}

	public boolean isEmailInvalidErrorMessageDisplayed(String emailInvalidErrorMessage) {
		waitForElementVisible(30, String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, emailInvalidErrorMessage), driver);
		return isElementDisplayed(String.format(LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE, emailInvalidErrorMessage), driver);
	}

	public boolean
	isEmailNotExistOrIncorrectPasswordErrorMessageDisplayed(String emailNotExistOrIncorrectPasswordErrorMessage) {
		waitForElementVisible(30, String.format(LoginPageUI.EMAIL_NOT_EXIST_OR_INCORRECT_PASSWORD_ERROR_MESSAGE, emailNotExistOrIncorrectPasswordErrorMessage), driver);
		return isElementDisplayed(String.format(LoginPageUI.EMAIL_NOT_EXIST_OR_INCORRECT_PASSWORD_ERROR_MESSAGE, emailNotExistOrIncorrectPasswordErrorMessage), driver);
	}

	public boolean isPasswordInvalidErrorMessageDisplayed(String passwordInvalidErrorMessage) {
		waitForElementVisible(30, String.format(LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE, passwordInvalidErrorMessage), driver);
		return isElementDisplayed(String.format(LoginPageUI.PASSWORD_INVALID_ERROR_MESSAGE, passwordInvalidErrorMessage), driver);
	}

}
