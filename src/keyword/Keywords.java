package keyword;

import org.openqa.selenium.WebDriver;

import output.LogCat;
import webDriver.WebDriverEngine;

public interface Keywords {
	public WebDriver driver = WebDriverEngine.getDriver();
	public LogCat logCat = LogCat.getInstance();
	public void initKeywords();
	public boolean sendToLog();
	public boolean execute();
}
