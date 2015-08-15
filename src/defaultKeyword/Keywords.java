package defaultKeyword;

import org.openqa.selenium.WebDriver;

import webDriver.WebDriverEngine;

public interface Keywords {
	public WebDriver driver = WebDriverEngine.getDriverTest();
	public void initKeywords();
	public boolean execute();
}
