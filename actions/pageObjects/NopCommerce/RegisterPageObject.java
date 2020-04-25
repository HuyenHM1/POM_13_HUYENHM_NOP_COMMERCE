package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFemaleRadio() {
		waitForElementClickable(15, RegisterPageUI.GENDER_FEMALE_RADIO, driver);
		clickToElement(RegisterPageUI.GENDER_FEMALE_RADIO, driver);
	}

	public void inputToFirstNameTextbox(String firstnameValue) {
		waitForElementVisible(15, RegisterPageUI.FIRST_NAME_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstnameValue, driver);
	}

	public void inputToLastNameTextbox(String lastnameValue) {
		waitForElementVisible(15, RegisterPageUI.LAST_NAME_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastnameValue, driver);
	}

	public void selectDayDropdown(String dayValue) {
		waitForElementVisible(15, RegisterPageUI.DAY_DROP_DOWN, driver);
		selectItemInHtmlDropdown(RegisterPageUI.DAY_DROP_DOWN, dayValue, driver);
	}

	public void selectMonthDropdown(String monthValue) {
		waitForElementVisible(15, RegisterPageUI.MONTH_DROP_DOWN, driver);
		selectItemInHtmlDropdown(RegisterPageUI.MONTH_DROP_DOWN, monthValue, driver);
	}

	public void selectYearDropdown(String yearValue) {
		waitForElementVisible(15, RegisterPageUI.YEAR_DROP_DOWN, driver);
		selectItemInHtmlDropdown(RegisterPageUI.YEAR_DROP_DOWN, yearValue, driver);
	}

	public void inputToEmailTexbox(String emailValue) {
		waitForElementVisible(15, RegisterPageUI.EMAIL_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, emailValue, driver);
	}

	public void inputToCompanyTextbox(String companyValue) {
		waitForElementVisible(15, RegisterPageUI.COMPANY_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.COMPANY_TEXTBOX, companyValue, driver);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(15, RegisterPageUI.PASSWORD_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, passwordValue, driver);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitForElementVisible(15, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, driver);
		sendkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue, driver);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(15, RegisterPageUI.REGISTER_BUTTON, driver);
		clickToElement(RegisterPageUI.REGISTER_BUTTON, driver);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(15, RegisterPageUI.SUCCESS_MESSAGE, driver);
		return getTextElement(RegisterPageUI.SUCCESS_MESSAGE, driver);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(15, RegisterPageUI.LOGOUT_BUTTON, driver);
		clickToElement(RegisterPageUI.LOGOUT_BUTTON, driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
