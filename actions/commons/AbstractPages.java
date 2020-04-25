package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.NopCommerce.FooterMyAccountPageObject;
import pageObjects.NopCommerce.FooterNewProductPageObject;
import pageObjects.NopCommerce.FooterSearchPageObject;
import pageObjects.NopCommerce.HomePageObject;
import pageUIs.NopCommerce.AbstractPageUI;
import pageUIs.NopCommerce.FooterMyAccountPageUI;
import pageUIs.NopCommerce.FooterNewProductPageUI;
import pageUIs.NopCommerce.FooterSearchPageUI;
import pageUIs.NopCommerce.HomePageUI;

public abstract class AbstractPages {
	public WebDriver driver;
	public Select select;
	public WebDriverWait explicitWait;
	public WebElement element;
	public List<WebElement> elements;
	public Set<String> allWindowID;
	public Actions action;
	public long longTimeout;

	public void getURL(String urlPage, WebDriver driver) {
		driver.get(urlPage);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(String valueInputToAlert, WebDriver driver) {
		driver.switchTo().alert().sendKeys(valueInputToAlert);
	}

	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(byXpath(driver, locator));
	}

	public WebElement findElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElement(byXpath(driver, locator));
	}

	public By byXpath(WebDriver driver, String locator) {
		return By.xpath(locator);
	}
	
	public By byXpath(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return By.xpath(locator);
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(byXpath(driver, locator));
	}

	public List<WebElement> findElements(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return driver.findElements(byXpath(driver, locator));
	}

	public void clickToElement(String locator, WebDriver driver) {
		findElement(driver, locator).click();
	}

	public void clickToElement(String locator, WebDriver driver, String... values) {
		findElement(driver, locator, values).click();
	}

	public void sendkeyToElement(String locator, String value, WebDriver driver) {
		findElement(driver, locator).sendKeys(value);
	}
	
	public void sendkeyToElement(String locator, String valueToSendkey, WebDriver driver, String... values) {
		findElement(driver, locator, values).sendKeys(valueToSendkey);
	}

	public void selectItemInHtmlDropdown(String locator, String valueOfOptionChosen, WebDriver driver) {
		select = new Select(findElement(driver, locator));
		select.selectByVisibleText(valueOfOptionChosen);
	}

	public WebElement getSelectedItemInHtmlDropdown(String locator, WebDriver driver) {
		select = new Select(findElement(driver, locator));
		return select.getFirstSelectedOption();
	}

	public int getItemsInDropdown(String locator, WebDriver driver) {
		select = new Select(findElement(driver, locator));
		return select.getOptions().size();
	}

	public void selectItemInCustomDropdown(long longTimeout, String locator, String locatorForListWebElement, String valueOfItemChosen, WebDriver driver) {
		findElement(driver, locator).click();
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(driver, locatorForListWebElement)));
		elements = findElements(driver, locatorForListWebElement);
		for (WebElement elementItem : elements) {
			if (elementItem.getText().equals(valueOfItemChosen)) {
				elementItem.click();
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String nameOfAttribute, WebDriver driver) {
		return findElement(driver, locator).getAttribute(nameOfAttribute);
	}

	public String getTextElement(String locator, WebDriver driver) {
		return findElement(driver, locator).getText();
	}
	
	public String getTextElement(String locator, WebDriver driver, String... values) {
		return findElement(driver, locator, values).getText();
	}

	public int countElementNumber(String locator, WebDriver driver) {
		elements = findElements(driver, locator);
		return elements.size();
	}

	public void checkTheCheckbox(String locator, WebDriver driver) {
		element = findElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(String locator, WebDriver driver) {
		element = findElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator, WebDriver driver) {
		return findElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementDisplayed(String locator, WebDriver driver, String... values ) {
		return findElement(driver, locator, values).isDisplayed();
	}

	public boolean isElementSelected(String locator, WebDriver driver) {
		return findElement(driver, locator).isSelected();
	}

	public boolean isElementEnabled(String locator, WebDriver driver) {
		return findElement(driver, locator).isEnabled();
	}

	public void switchWindowByID(String parentWindowID, WebDriver driver) {
		allWindowID = driver.getWindowHandles();
		for (String WindowID : allWindowID) {
			if (!WindowID.equals(parentWindowID)) {
				driver.switchTo().window(WindowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(String titleOfWindow, WebDriver driver) {
		allWindowID = driver.getWindowHandles();
		for (String WindowID : allWindowID) {
			driver.switchTo().window(WindowID);
			String titleOfRunWindow = driver.getTitle();
			if (titleOfRunWindow.equals(titleOfWindow)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(String parentWindowID, WebDriver driver) {
		allWindowID = driver.getWindowHandles();
		for (String runWindowID : allWindowID) {
			if (!runWindowID.equals(parentWindowID)) {
				driver.switchTo().window(runWindowID);
				driver.close();
			}
			driver.switchTo().window(parentWindowID);
		}
	}

	public WebDriver switchToFrameOrIframe(String locator, WebDriver driver) {
		return driver.switchTo().frame(findElement(driver, locator));
	}

	public void doubleClickToElement(String locator, WebDriver driver) {
		action = new Actions(driver);
		action.doubleClick(findElement(driver, locator)).perform();
	}

	public void moveToElement(String locator, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(findElement(driver, locator)).perform();
	}

	public void rightClick(String locator, WebDriver driver) {
		action = new Actions(driver);
		action.contextClick(findElement(driver, locator)).perform();
	}

	public void dragAndDrop(String fromLocator, String toLocator, WebDriver driver) {
		action = new Actions(driver);
		action.dragAndDrop(findElement(driver, fromLocator), findElement(driver, toLocator)).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key, WebDriver driver) {
		action = new Actions(driver);
		action.sendKeys(findElement(driver, locator), key).perform();
	}

	public void uploadOneFile(String locator, String filePath, WebDriver driver) {
		findElement(driver, locator).sendKeys(filePath);
	}

	public void uploadMultipleFile(String locator, String multipleFilePath, WebDriver driver) {
		findElement(driver, locator).sendKeys(multipleFilePath);
	}

	public WebElement waitForElementPresence(long longTimeout, String locator, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(driver, locator)));
	}

	public WebElement waitForElementVisible(long longTimeout, String locator, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(driver, locator)));
	}
	
	public WebElement waitForElementVisible(long longTimeout, String locator, WebDriver driver, String... values) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(driver, locator, values)));
	}

	public WebElement waitForElementClickable(long longTimeout, String locator, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(driver, locator)));
	}
	
	public WebElement waitForElementClickable(long longTimeout, String locator, WebDriver driver, String... values) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(driver, locator, values)));
	}

	public boolean waitForElementInvisible(long longTimeout, String locator, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(driver, locator)));
	}

	public Alert waitForAlertPresence(long longTimeout, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	// Open Footer Page

	public FooterNewProductPageObject openNewProductPage(WebDriver driver) {
		waitForElementClickable(15, AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, driver);
		clickToElement(AbstractPageUI.FOOTER_NEW_PRODUCT_LINK, driver);
		return PageGeneratorManager.getFooterNewProductPageObject(driver);
	}

	public FooterMyAccountPageObject openFooterMyAccountPage(WebDriver driver) {
		waitForElementClickable(15, AbstractPageUI.MY_ACCOUNT_FOOTER_LINK, driver);
		clickToElement(AbstractPageUI.MY_ACCOUNT_FOOTER_LINK, driver);
		return PageGeneratorManager.getFooterMyAccountPageObject(driver);
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForElementClickable(15, AbstractPageUI.HOME_PAGE_LINK, driver);
		clickToElement(AbstractPageUI.HOME_PAGE_LINK, driver);
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public FooterSearchPageObject openSearchPage(WebDriver driver) {
		waitForElementClickable(15, AbstractPageUI.FOOTER_SEARCH_LINK, driver);
		clickToElement(AbstractPageUI.FOOTER_SEARCH_LINK, driver);
		return PageGeneratorManager.getFooterSearchPageObject(driver);
	}
	
	public AbstractPages openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementVisible(15, AbstractPageUI.DYNAMIC_FOOTER_LINK, driver, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, driver, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getFooterSearchPageObject(driver);
		case "New products":
			return PageGeneratorManager.getFooterNewProductPageObject(driver);
		default :
			return PageGeneratorManager.getFooterMyAccountPageObject(driver);
		}
	}
	
	public void openFooterPagesByName(WebDriver driver, String pageName) {
		waitForElementVisible(15, AbstractPageUI.DYNAMIC_FOOTER_LINK, driver, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, driver, pageName);
	}
	

}
