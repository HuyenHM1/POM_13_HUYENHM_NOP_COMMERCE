package com.nopcommerce.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractPages;

public class Login_02_RegisterAndLogin_Apply_AbstractPage_Extends extends AbstractPages{
	private WebDriver driver;
	private Select select;
	String email, passWord;
	
	@BeforeTest
	public void beforeTest() {
//		String osName = System.getProperty("os.name");
//		if(osName.toLowerCase().contains("windows")) {
//			System.setProperty("webdriver.gecko.driver", "");
//		}else if(osName.contains("mac")) {
//			System.setProperty("webdriver.gecko.driver", "");
//		}else{
//			System.setProperty("webdriver.gecko.driver", "");
//		}
		
		driver = new FirefoxDriver();

		getURL("https://demo.nopcommerce.com", driver);
	
		email = "Auto" + randomNumber() + "@gmail.com";
		passWord = "111111";
	  }
	
	@Test
	public void TC01_Register() {
//		Click to Register link
		clickToElement("//a[text()='Register']", driver);
//		Click to Radio button
		clickToElement("//input[@id='gender-female']", driver);
//		Input First Name
		sendkeyToElement("//input[@id='FirstName']", "Auto", driver);
//		Input Last Name
		sendkeyToElement("//input[@id='LastName']", "Auto", driver);
//		Choose DayAuto
		selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "1", driver);
		int numberOfDay = getItemsInDropdown("//select[@name='DateOfBirthDay']", driver);
		Assert.assertEquals(numberOfDay, 32);
//		Choose Month
		selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "May", driver);
		int numberOfMonth = getItemsInDropdown("//select[@name='DateOfBirthMonth']", driver);
		Assert.assertEquals(numberOfMonth, 13);
//		Choose Year
		selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1980", driver);
		int numberOfYear = getItemsInDropdown("//select[@name='DateOfBirthYear']", driver);
		Assert.assertEquals(numberOfYear, 112);
//		Input email
		sendkeyToElement("//input[@id='Email']", email, driver);
//		Input company
		sendkeyToElement("//input[@id='Company']", "NopCommerce", driver);
//		Input password
		sendkeyToElement("//input[@id='Password']", passWord, driver);
//		Input confirm password 
		sendkeyToElement("//input[@id='ConfirmPassword']", passWord, driver);
//		Click to Register button
		clickToElement("//input[@id='register-button']", driver);
//		Verify register successfully
		Assert.assertEquals(getTextElement("//div[@class='result']", driver), "Your registration completed");
		
//		Log out
		clickToElement("//a[@class='ico-logout']", driver);
  }
	
	
	@Test
	public void TC02_Login() {
//		Click to Login link
		clickToElement("//a[@class='ico-login']", driver);
//		Input to Email textbox
		sendkeyToElement("//input[@id='Email']", email, driver);
//		Input to Password textbox
		sendkeyToElement("//input[@id='Password']", passWord, driver);
//		Click to Login button
		clickToElement("//input[@class='button-1 login-button']", driver);
//		Verify
		Assert.assertTrue(isElementDisplayed("//div[@class='header-links']//a[text()='My account']", driver));
		Assert.assertTrue(isElementDisplayed("//a[text()='Log out']", driver));
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
