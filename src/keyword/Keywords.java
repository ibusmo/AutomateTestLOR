package keyword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import output.LogCat;
import webDriver.WebDriverEngine;

public interface Keywords {
	public WebDriver driver = WebDriverEngine.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	public LogCat logCat = LogCat.getInstance();
	public void initKeywords();
	public boolean sendToLog();
	public boolean execute();
}
