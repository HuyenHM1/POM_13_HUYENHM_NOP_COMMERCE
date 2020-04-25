package pageFactory.nopCommerce;

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

public class AbstractPageFactory {
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

	public By byXpath(WebDriver driver, String locator) {
		return By.xpath(locator);
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(byXpath(driver, locator));
	}

	public void clickToElement(WebElement element, WebDriver driver) {
		element.click();
	}

	public void sendkeyToElement(WebElement element, String value, WebDriver driver) {
		element.sendKeys(value);
	}

	public void selectItemInHtmlDropdown(WebElement element, String valueOfOptionChosen, WebDriver driver) {
		select = new Select(element);
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

	public void selectItemInCustomDropdown(long longTimeout, String locator, String locatorForListWebElement,
			String valueOfItemChosen, WebDriver driver) {
		findElement(driver, locator).click();
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(driver, locatorForListWebElement)));
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

	public String getTextElement(WebElement element, WebDriver driver) {
		return element.getText();
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

	public boolean isElementDisplayed(WebElement element, WebDriver driver) {
		return element.isDisplayed();
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

	public WebElement waitForElementVisible(long longTimeout, WebElement element, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementClickable(long longTimeout, WebElement element, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public boolean waitForElementInvisible(long longTimeout, String locator, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(driver, locator)));
	}

	public Alert waitForAlertPresence(long longTimeout, WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

}
