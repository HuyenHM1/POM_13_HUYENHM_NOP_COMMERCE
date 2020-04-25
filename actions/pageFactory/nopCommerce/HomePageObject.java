package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPages;
import pageUIs.NopCommerce.HomePageUI;

public class HomePageObject extends AbstractPageFactory {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='header-links']//a[text()='Register']")
	private WebElement registerLink;

	@FindBy(how = How.XPATH, using = "//div[@class='header-links']//a[text()='Log in']")
	private WebElement loginLink;

	@FindBy(how = How.XPATH, using = "//div[@class='header-links']//a[text()='My account']")
	private WebElement myAccountLink;

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(15, registerLink, driver);
		clickToElement(registerLink, driver);
		return new RegisterPageObject(driver);
	}

	public LogInPageObject clickToLoginLink() {
		waitForElementClickable(15, loginLink, driver);
		clickToElement(loginLink, driver);
		return new LogInPageObject(driver);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(15, myAccountLink, driver);
		return isElementDisplayed(myAccountLink, driver);
	}

}
