package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LogInPageObject;
import pageObjects.NopCommerce.RegisterPageObject;
import pageObjects.NopCommerce.FooterMyAccountPageObject;
import pageObjects.NopCommerce.FooterNewProductPageObject;
import pageObjects.NopCommerce.FooterSearchPageObject;

public class PageGeneratorManager {
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LogInPageObject getLogInPageObject(WebDriver driver) {
		return new LogInPageObject(driver);
	}
	
	public static FooterMyAccountPageObject getFooterMyAccountPageObject(WebDriver driver) {
		return new FooterMyAccountPageObject(driver);
	}
	
	public static FooterSearchPageObject getFooterSearchPageObject(WebDriver driver) {
		return new FooterSearchPageObject(driver);
	}

	public static FooterNewProductPageObject getFooterNewProductPageObject(WebDriver driver) {
		return new FooterNewProductPageObject(driver);
	}
	
	
}
