package base;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import log.LogCat;
import webdriver.WebDriverEngine;

public interface KeywordsCSM {
	public WebDriver driver = WebDriverEngine.getDriver();
	public WebDriverWait wait = WebDriverEngine.getDriverWait();
	public JavascriptExecutor executor = WebDriverEngine.getExecutor();
	public LogCat logCat = LogCat.getInstance();
	
	public void initKeywords();
	public boolean execute();
	public void sendToLogStart();
	public void sendToLogFinish();
}
