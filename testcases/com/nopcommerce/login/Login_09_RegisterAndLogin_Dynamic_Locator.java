package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPages;
import commons.AbstractTest;
import commons.Global_Constants;
import commons.PageGeneratorManager;
import pageFactory.nopCommerce.AbstractPageFactory;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LogInPageObject;
import pageObjects.NopCommerce.RegisterPageObject;
import pageObjects.NopCommerce.FooterMyAccountPageObject;
import pageObjects.NopCommerce.FooterNewProductPageObject;
import pageObjects.NopCommerce.FooterSearchPageObject;

public class Login_09_RegisterAndLogin_Dynamic_Locator extends AbstractTest {
	private WebDriver driver;
	String email, passWord;
	private HomePageObject homePage;
	private LogInPageObject loginPage;
	private RegisterPageObject registerPage;
	private FooterMyAccountPageObject myAccountPage;
	private FooterNewProductPageObject newProductPage;
	private FooterSearchPageObject searchPage;

	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browserName) {

		driver = getBrowserDriver(browserName);
		email = "Auto" + randomNumber() + "@gmail.com";
		passWord = "111111";
		homePage = PageGeneratorManager.getHomePageObject(driver);
	  }
	
	@Test
	public void TC01_Register() {

//		Click to Register link -> Register Page
		registerPage = homePage.clickToRegisterLink();
//		Click to Radio button
		registerPage.clickToFemaleRadio();
//		Input First Name
		registerPage.inputToFirstNameTextbox("Heather");
//		Input Last Name
		registerPage.inputToLastNameTextbox("Luu");
//		Choose DayAuto
		registerPage.selectDayDropdown("15");
//		Choose Month
		registerPage.selectMonthDropdown("December");
//		Choose Year
		registerPage.selectYearDropdown("1995");
//		Input email
		registerPage.inputToEmailTexbox(email);
//		Input company
		registerPage.inputToCompanyTextbox("Heather");
//		Input password
		registerPage.inputToPasswordTextbox(passWord);
//		Input confirm password 
		registerPage.inputToConfirmPasswordTextbox(passWord);
//		Click to Register button
		registerPage.clickToRegisterButton();
//		Verify register successfully
		String successRegisterMessage = registerPage.getRegisterSuccessMessage();
		Assert.assertEquals(successRegisterMessage, "Your registration completed");
//		Log out
		homePage = registerPage.clickToLogoutLink();
  }
	
	
	@Test
	public void TC02_Login() {


//		Click to Login link
		loginPage = homePage.clickToLoginLink();
//		Input to Email textbox
		loginPage.inputToEmailTextbox(email);
//		Input to Password textbox
		loginPage.inputToPasswordTextbox(passWord);
//		Click to Login button
		homePage = loginPage.clickToLoginButton();
//		Verify My Account link display
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}

	@Test
	public void TC03_Dynamic_Less_Page() {

//		Homepage -> My Account (Footer)
		myAccountPage = (FooterMyAccountPageObject) homePage.openFooterPageByName(driver, "My account");
//		My Account -> Search
		searchPage = (FooterSearchPageObject) myAccountPage.openFooterPageByName(driver, "Search");
//		Search -> New Products
		newProductPage = (FooterNewProductPageObject) searchPage.openFooterPageByName(driver, "New products");
//		New Products -> Homepage
		homePage = newProductPage.openHomePage(driver);
//		Homepage -> Search
		searchPage = (FooterSearchPageObject) homePage.openFooterPageByName(driver, "Search");
	}
	@Test
	public void TC04_Dynamic_More_Page() {
		

//		Search -> New Products
		searchPage.openFooterPageByName(driver, "New products");
		newProductPage = PageGeneratorManager.getFooterNewProductPageObject(driver);
//		New Products -> Homepage
		homePage = newProductPage.openHomePage(driver);
//		Homepage -> Search
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getFooterSearchPageObject(driver);
	}
	
	public int randomNumber() {

		Random ran = new Random();
		return ran.nextInt(99999);
	}
	
	@AfterTest
	public void afterTest() {

		driver.quit();
  }

}
