package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
	}

}
