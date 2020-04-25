package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPages;
import pageUIs.NopCommerce.LoginPageUI;

public class LogInPageObject extends AbstractPageFactory {
	WebDriver driver;

	public LogInPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(how = How.XPATH, using = "//input[@class='button-1 login-button']")
	private WebElement loginButton;

	public void inputToEmailTextbox(String emailValue) {
		waitForElementVisible(15, emailTextbox, driver);
		sendkeyToElement(emailTextbox, emailValue, driver);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitForElementVisible(15, passwordTextbox, driver);
		sendkeyToElement(passwordTextbox, passwordValue, driver);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(15, loginButton, driver);
		clickToElement(loginButton, driver);
		return new HomePageObject(driver);
	}

}
