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

public class AbstractPage {
	public WebDriver driver;
	public Select select;
	public WebDriverWait explicitWait;
	public WebElement element;
	public List<WebElement> elements;
	public Set<String> allWindowID;
	public Actions action;
	public long longTimeout;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void getURL(String urlPage) {
		driver.get(urlPage);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backPage() {
		driver.navigate().back();
	}

	public void forwardPage() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(String valueInputToAlert) {
		driver.switchTo().alert().sendKeys(valueInputToAlert);
	}

	public WebElement findElement(String locator) {
		return driver.findElement(byXpath(locator));
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public List<WebElement> findElements(String locator) {
		return driver.findElements(byXpath(locator));
	}

	public void clickToElement(String locator) {
		findElement(locator).click();
	}

	public void sendkeyToElement(String locator, String value) {
		findElement(locator).sendKeys(value);
	}

	public void selectItemInHtmlDropdown(String locator, String valueOfOptionChosen) {
		select = new Select(findElement(locator));
		select.selectByVisibleText(valueOfOptionChosen);
	}

	public WebElement getSelectedItemInHtmlDropdown(String locator) {
		select = new Select(findElement(locator));
		return select.getFirstSelectedOption();
	}
	
	public int getItemsInDropdown(String locator) {
		select = new Select(findElement(locator));
		return select.getOptions().size();
	}

	public void selectItemInCustomDropdown(long longTimeout, String locator, String locatorForListWebElement,
			String valueOfItemChosen) {
		findElement(locator).click();
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(locatorForListWebElement)));
		elements = findElements(locatorForListWebElement);
		for (WebElement elementItem : elements) {
			if (elementItem.getText().equals(valueOfItemChosen)) {
				elementItem.click();
				break;
			}
		}
	}

	public String getAttributeValue(String locator, String nameOfAttribute) {
		return findElement(locator).getAttribute(nameOfAttribute);
	}

	public String getTextElement(String locator) {
		return findElement(locator).getText();
	}

	public int countElementNumber(String locator) {
		elements = findElements(locator);
		return elements.size();
	}

	public void checkTheCheckbox(String locator) {
		element = findElement(locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(String locator) {
		element = findElement(locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		return findElement(locator).isDisplayed();
	}

	public boolean isElementSelected(String locator) {
		return findElement(locator).isSelected();
	}

	public boolean isElementEnabled(String locator) {
		return findElement(locator).isEnabled();
	}

	public void switchWindowByID(String parentWindowID) {
		allWindowID = driver.getWindowHandles();
		for (String WindowID : allWindowID) {
			if (!WindowID.equals(parentWindowID)) {
				driver.switchTo().window(WindowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(String titleOfWindow) {
		allWindowID = driver.getWindowHandles();
		for (String WindowID : allWindowID) {
			driver.switchTo().window(WindowID);
			String titleOfRunWindow = driver.getTitle();
			if (titleOfRunWindow.equals(titleOfWindow)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParent(String parentWindowID) {
		allWindowID = driver.getWindowHandles();
		for (String runWindowID : allWindowID) {
			if (!runWindowID.equals(parentWindowID)) {
				driver.switchTo().window(runWindowID);
				driver.close();
			}
			driver.switchTo().window(parentWindowID);
		}
	}

	public WebDriver switchToFrameOrIframe(String locator) {
		return driver.switchTo().frame(findElement(locator));
	}

	public void doubleClickToElement(String locator) {
		action = new Actions(driver);
		action.doubleClick(findElement(locator)).perform();
	}

	public void moveToElement(String locator) {
		action = new Actions(driver);
		action.moveToElement(findElement(locator)).perform();
	}

	public void rightClick(String locator) {
		action = new Actions(driver);
		action.contextClick(findElement(locator)).perform();
	}

	public void dragAndDrop(String fromLocator, String toLocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElement(fromLocator), findElement(toLocator)).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElement(locator), key).perform();
	}

	public void uploadOneFile(String locator, String filePath) {
		findElement(locator).sendKeys(filePath);
	}

	public void uploadMultipleFile(String locator, String multipleFilePath) {
		findElement(locator).sendKeys(multipleFilePath);
	}

	public WebElement waitForElementPresence(long longTimeout, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}

	public WebElement waitForElementVisible(long longTimeout, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public WebElement waitForElementClickable(long longTimeout, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
	}

	public boolean waitForElementInvisible(long longTimeout, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
	}

	public Alert waitForAlertPresence(long longTimeout) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
