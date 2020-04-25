package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.FooterMyAccountPageUI;
import pageUIs.NopCommerce.LoginPageUI;

public class FooterMyAccountPageObject extends AbstractPages {
	WebDriver driver;

	public FooterMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
