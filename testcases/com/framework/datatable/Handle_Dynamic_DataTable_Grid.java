package com.framework.datatable;

import org.testng.annotations.Test;

import commons.AbstractPages;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Handle_Dynamic_DataTable_Grid extends AbstractPages {
	WebDriver driver;
	String total;
	int index;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ".\\libraries\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//  @Test
	public void TC_01_Click_To_Page() {
		// 5
		goToPageByPageName("5");
		Assert.assertTrue(isPageActivedByPageNumber("5"));
		// 10
		goToPageByPageName("10");
		Assert.assertTrue(isPageActivedByPageNumber("10"));
		// 13
		goToPageByPageName("13");
		Assert.assertTrue(isPageActivedByPageNumber("13"));
		// 18
		goToPageByPageName("1");
		Assert.assertTrue(isPageActivedByPageNumber("1"));
	}

//  @Test
	public void TC_02_Click_To_Icon_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");

		clickToIconNameByCountryName("Albania", "remove");
		clickToIconNameByCountryName("Argentina", "remove");
		clickToIconNameByCountryName("Armenia", "remove");

		clickToIconNameByCountryName("Afghanistan", "edit");
	}

//  @Test
	public void TC_03_Get_Total_Value_By_Country() {
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		total = getTotalByCountryName("Argentina");
		Assert.assertEquals(total, "687522");
		total = getTotalByCountryName("Albania");
		Assert.assertEquals(total, "49397");
		total = getTotalByCountryName("Armenia");
		Assert.assertEquals(total, "32487");
	}

//  @Test
	public void TC_04_Input_To_Textbox_By_Column_And_Row_Name() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
//	  inputToTextBoxByColumnAndRowName("KSM", "company", "1");
		inputToTextBoxByColumnAndRow("Company", "1", "KSM");

//	  inputToTextBoxByColumnAndRowName("John", "name", "3");
		inputToTextBoxByColumnAndRow("Contact Person", "3", "John");

//	  inputToTextBoxByColumnAndRowName("500", "orderPlaced", "2");
		inputToTextBoxByColumnAndRow("Order Placed", "2", "500");
	}

	@Test
	public void TC_05_Click_Icon_By_Row_Name() {
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		// Insert to row 2
		clickToIconByRowNumber("2", "Insert Row Above");

		// Move up at row 3
		clickToIconByRowNumber("3", "Move Up");

		// Move down at row 1
		clickToIconByRowNumber("1", "Move Down");

		// Remove row 2
		clickToIconByRowNumber("2", "Remove Current Row");
	}

	public void goToPageByPageName(String pageNumber) {
		String locator = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
		waitForElementClickable(30, locator, driver, pageNumber);
		clickToElement(locator, driver, pageNumber);
	}

	public boolean isPageActivedByPageNumber(String pageNumber) {
		String locator = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
		waitForElementVisible(30, locator, driver, pageNumber);
		return isElementDisplayed(locator, driver, pageNumber);
	}

	public void clickToIconNameByCountryName(String countryName, String iconName) {
		String locator = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']//button[@class='qgrd-%s-row-btn']";
		waitForElementClickable(30, locator, driver, countryName, iconName);
		clickToElement(locator, driver, countryName, iconName);
	}

	public String getTotalByCountryName(String countryName) {
		String locator = "//td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='total']";
		waitForElementVisible(30, locator, driver, countryName);
		return getTextElement(locator, driver, countryName);
	}

	public void inputToTextBoxByColumnAndRowName(String valueToSendkey, String columnName, String rowName) {
		String locator = "//input[@id='tblAppendGrid_%s_%s']";
		waitForElementVisible(30, locator, driver, columnName, rowName);
		sendkeyToElement(locator, valueToSendkey, driver, columnName, rowName);
	}

	public void inputToTextBoxByColumnAndRow(String columnName, String rowName, String valueToSendkey) {
		String locator = "//th[(text()='%s')]/preceding-sibling::th";
		index = findElements(driver, locator, columnName).size() + 1;
		String locatorNew = "//tr[" + rowName + "]//td[" + index + "]//input";
		waitForElementVisible(15, locatorNew, driver);
		sendkeyToElement(locatorNew, valueToSendkey, driver);
	}

	public void clickToIconByRowNumber(String rowName, String iconName) {
		String locator = "//tbody//tr[%s]//button[@title='%s']";
		waitForElementClickable(30, locator, driver, rowName, iconName);
		clickToElement(locator, driver, rowName, iconName);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
