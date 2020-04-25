package com.liveguru.login;

import org.testng.annotations.Test;

import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashBoardPageObject;

import org.testng.annotations.BeforeTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Login_01_LoginToSystem {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private MyDashBoardPageObject myDashBoardPage;

	@BeforeClass
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
//		driver = new ChromeDriver();
		driver.get("http://live.demoguru99.com/index.php/");
		homePage = new HomePageObject(driver);
		
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("");
		loginPage.inputPasswordTextbox("");
		loginPage.clickToLoginButton();	
		Assert.assertTrue(loginPage.isEmptyEmailErrorMessageDisplayed("This is a required field."));;
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed("This is a required field."));
	}
	@Test
	public void TC_02_LoginInvalidEmail() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("123@123.123");
		loginPage.inputPasswordTextbox("");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailInvalidErrorMessageDisplayed("Please enter a valid email address. For example johndoe@domain.com."));
	}
	@Test
	public void TC_03_LoginEmailNotExist() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("Ann" + randomNumber() + "@gmail.com");
		loginPage.inputPasswordTextbox("121121");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailNotExistOrIncorrectPasswordErrorMessageDisplayed("Invalid login or password."));
	}
	@Test
	public void TC_04_LoginIncorrectPassword() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("automationfc.vn@gmail.com");
		loginPage.inputPasswordTextbox("111111");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isEmailNotExistOrIncorrectPasswordErrorMessageDisplayed("Invalid login or password."));
	}
	@Test
	public void TC_05_LoginWithPasswordLessThan6Chars() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("automationfc.vn@gmail.com");
		loginPage.inputPasswordTextbox("123");
		loginPage.clickToLoginButton();
		Assert.assertTrue(loginPage.isPasswordInvalidErrorMessageDisplayed("Please enter 6 or more characters without leading or trailing spaces."));
	}
	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		loginPage = homePage.clickToMyAccountLink();
		loginPage.inputEmailTextbox("automationfc.vn@gmail.com");
		loginPage.inputPasswordTextbox("123123");
		myDashBoardPage = loginPage.clickToLoginButton();
		Assert.assertTrue(myDashBoardPage.isFullNameDisplayed("Automation FC"));
		Assert.assertTrue(myDashBoardPage.isEmailDisplayed("automationfc.vn@gmail.com"));
	}
	
	public int randomNumber() {
		Random ran = new Random();
		return ran.nextInt(9999); 	
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
