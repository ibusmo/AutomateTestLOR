package DefaultKeyword;

import org.openqa.selenium.WebDriver;

import WebDriver.WebDriverEngine;

public interface Keywords {
	public WebDriver driver = WebDriverEngine.driverTest;
	public void initKeywords();
	public boolean execute();
}
