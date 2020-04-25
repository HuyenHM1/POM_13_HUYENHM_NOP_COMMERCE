package pageObjects.NopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageUIs.NopCommerce.FooterSearchPageUI;
import pageUIs.NopCommerce.LoginPageUI;

public class FooterSearchPageObject extends AbstractPages {
	WebDriver driver;

	public FooterSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
