package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPages;
import commons.PageGeneratorManager;
import pageFactory.nopCommerce.AbstractPageFactory;
import pageObjects.NopCommerce.HomePageObject;
import pageObjects.NopCommerce.LogInPageObject;
import pageObjects.NopCommerce.RegisterPageObject;



public class Login_05_RegisterAndLogin_Page_Generator_Manager {
	private WebDriver driver;
	String email, passWord;
	private HomePageObject homePage;
	private LogInPageObject loginPage;
	private RegisterPageObject registerPage;
	
	@BeforeTest
	public void beforeTest() {
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		}else if(osName.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		}else{
			System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		}
		
		driver = new FirefoxDriver();

		driver.get("https://demo.nopcommerce.com");
	
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
	
	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(99999);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
  }

}
