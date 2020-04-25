package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import commons.Global_Constants;

public abstract class DriverManager {
	protected WebDriver driver;
	
	protected abstract void createDriver();
	
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public WebDriver getDriver() {
		if(driver == null) {
			createDriver();
			driver.get(Global_Constants.uRL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	
	
	
	
}
