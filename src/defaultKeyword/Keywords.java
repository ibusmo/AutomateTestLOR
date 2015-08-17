package defaultKeyword;

import org.openqa.selenium.WebDriver;

import webDriver.WebDriverEngine;

public interface Keywords {
	public WebDriver driver = WebDriverEngine.getDriver();
	public void initKeywords();
	public boolean execute();
}
