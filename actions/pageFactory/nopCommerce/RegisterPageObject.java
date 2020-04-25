package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPages;
import pageUIs.NopCommerce.RegisterPageUI;

public class RegisterPageObject extends AbstractPageFactory {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='gender-female']")
	private WebElement genderFemaleRadio;
	
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private WebElement firstnameTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private WebElement lastnameTextbox;
	
	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthDay']")
	private WebElement dayDropdown;
	
	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthMonth']")
	private WebElement monthDropdown;
	
	@FindBy(how = How.XPATH, using = "//select[@name='DateOfBirthYear']")
	private WebElement yearDropdown;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Company']")
	private WebElement companyTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(how = How.XPATH, using = "//div[@class='result']")
	private WebElement successMessage;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-logout']")
	private WebElement logoutButton;
	
	
	
	
	
	
	
	
	
	

	public void clickToFemaleRadio() {
		waitForElementClickable(15, genderFemaleRadio, driver);
		clickToElement(genderFemaleRadio, driver);
	}

	public void inputToFirstNameTextbox(String firstnameValue) {
		waitForElementVisible(15, firstnameTextbox, driver);
		sendkeyToElement(firstnameTextbox, firstnameValue, driver);
	}

	public void inputToLastNameTextbox(String lastnameValue) {
		waitForElementVisible(15, lastnameTextbox, driver);
		sendkeyToElement(lastnameTextbox, lastnameValue, driver);
	}

	public void selectDayDropdown(String dayValue) {
		waitForElementVisible(15, dayDropdown, driver);
		selectItemInHtmlDropdown(dayDropdown, dayValue, driver);
	}

	public void selectMonthDropdown(String monthValue) {
		waitForElementVisible(15, monthDropdown, driver);
		selectItemInHtmlDropdown(monthDropdown, monthValue, driver);
	}

	public void selectYearDropdown(String yearValue) {
		waitForElementVisible(15, yearDropdown, driver);
		selectItemInHtmlDropdown(yearDropdown, yearValue, driver);
	}

	public void inputToEmailTexbox(String emailValue) {
		waitForElementVisible(15, emailTextbox, driver);
		sendkeyToElement(emailTextbox, emailValue, driver);
	}

	public void inputToCompanyTextbox(String companyValue) {
		waitForElementVisible(15, companyTextbox, driver);
		sendkeyToElement(companyTextbox, companyValue, driver);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(15, passwordTextbox, driver);
		sendkeyToElement(passwordTextbox, passwordValue, driver);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitForElementVisible(15, confirmPasswordTextbox, driver);
		sendkeyToElement(confirmPasswordTextbox, confirmPasswordValue, driver);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(15, registerButton, driver);
		clickToElement(registerButton, driver);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(15, successMessage, driver);
		return getTextElement(successMessage, driver);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(15, logoutButton, driver);
		clickToElement(logoutButton, driver);
		return new HomePageObject(driver);
	}

}
