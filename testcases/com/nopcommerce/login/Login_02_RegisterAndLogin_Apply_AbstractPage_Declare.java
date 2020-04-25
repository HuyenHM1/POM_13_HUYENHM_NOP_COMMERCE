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

public class Login_02_RegisterAndLogin_Apply_AbstractPage_Declare {
	private WebDriver driver;
	private Select select;
	String email, passWord;
	AbstractPage abstractPage;
	
	@BeforeTest
	public void beforeTest() {
		String osName = System.getProperty("os.name");
		if(osName.toLowerCase().contains("windows")) {
			System.setProperty("webdriver.gecko.driver", "");
		}else if(osName.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", "");
		}else{
			System.setProperty("webdriver.gecko.driver", "");
		}
		
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage(driver);
		abstractPage.getURL("https://demo.nopcommerce.com");
	
		email = "Auto" + randomNumber() + "@gmail.com";
		passWord = "111111";
	  }
	
	@Test
	public void TC01_Register() {
//		Click to Register link
		abstractPage.clickToElement("//a[text()='Register']");
//		Click to Radio button
		abstractPage.clickToElement("//input[@id='gender-female']");
//		Input First Name
		abstractPage.sendkeyToElement("//input[@id='FirstName']", "Auto");
//		Input Last Name
		abstractPage.sendkeyToElement("//input[@id='LastName']", "Auto");
//		Choose DayAuto
		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthDay']", "1");
		int numberOfDay = abstractPage.getItemsInDropdown("//select[@name='DateOfBirthDay']");
		Assert.assertEquals(numberOfDay, 32);
//		Choose Month
		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthMonth']", "May");
		int numberOfMonth = abstractPage.getItemsInDropdown("//select[@name='DateOfBirthMonth']");
		Assert.assertEquals(numberOfMonth, 13);
//		Choose Year
		abstractPage.selectItemInHtmlDropdown("//select[@name='DateOfBirthYear']", "1980");
		int numberOfYear = abstractPage.getItemsInDropdown("//select[@name='DateOfBirthYear']");
		Assert.assertEquals(numberOfYear, 112);
//		Input email
		abstractPage.sendkeyToElement("//input[@id='Email']", email);
//		Input company
		abstractPage.sendkeyToElement("//input[@id='Company']", "NopCommerce");
//		Input password
		abstractPage.sendkeyToElement("//input[@id='Password']", passWord);
//		Input confirm password 
		abstractPage.sendkeyToElement("//input[@id='ConfirmPassword']", passWord);
//		Click to Register button
		abstractPage.clickToElement("//input[@id='register-button']");
//		Verify register successfully
		Assert.assertEquals(abstractPage.getTextElement("//div[@class='result']"), "Your registration completed");
		
//		Log out
		abstractPage.clickToElement("//a[@class='ico-logout']");
  }
	
	
	@Test
	public void TC02_Login() {
//		Click to Login link
		abstractPage.clickToElement("//a[@class='ico-login']");
//		Input to Email textbox
		abstractPage.sendkeyToElement("//input[@id='Email']", email);
//		Input to Password textbox
		abstractPage.sendkeyToElement("//input[@id='Password']", passWord);
//		Click to Login button
		abstractPage.clickToElement("//input[@class='button-1 login-button']");
//		Verify 
		Assert.assertTrue(abstractPage.isElementDisplayed("//div[@class='header-links']//a[text()='My account']"));
		Assert.assertTrue(abstractPage.isElementDisplayed("//a[text()='Log out']"));
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
