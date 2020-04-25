package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.FooterNewProductPageUI;
import pageUIs.NopCommerce.LoginPageUI;

public class FooterNewProductPageObject extends AbstractPages {
	WebDriver driver;

	public FooterNewProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
