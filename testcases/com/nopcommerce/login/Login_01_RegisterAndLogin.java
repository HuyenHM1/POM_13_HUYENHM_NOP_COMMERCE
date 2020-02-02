package com.nopcommerce.login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_01_RegisterAndLogin {
	private WebDriver driver;
	private Select select;
	
	String email, passWord;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com");
		
		email = "Auto" + randomNumber() + "@gmail.com";
		passWord = "111111";
	  }
	
	@Test
	public void TC01_Register() {
//		Click to Register link
		driver.findElement(By.xpath("//a[text()='Register']")).click();
//		Click to Radio button
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();
//		Input First Name
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Auto");
//		Input Last Name
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Auto");
//		Choose Day
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText("1");
		int numberOfDay = select.getOptions().size();
		Assert.assertEquals(numberOfDay, 32);
//		Choose Month
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText("May");
		int numberOfMonth = select.getOptions().size();
		Assert.assertEquals(numberOfMonth, 13);
//		Choose Year
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText("1980");
		int numberOfYear = select.getOptions().size();
		Assert.assertEquals(numberOfYear, 112);
//		Input email
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
//		Input company
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("NopCommerce");
//		Input password
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
//		Input confirm password 
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(passWord);
//		Click to Register button
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
//		Verify register successfully
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");
		
//		Log out
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
  }
	
	
	@Test
	public void TC02_Login() {
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='header-links']//a[text()='My account']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed());
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
