package webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import output.LogCat;

public class WebDriverEngine {
	private static WebDriverEngine instance    =  null;
	private static WebDriver driver = null;
	private static WebDriverWait driverWait = null;
	private static JavascriptExecutor executor = null;
	private static String webEngine = null;
	private static LogCat logCat = LogCat.getInstance();
	
	private WebDriverEngine(){
		
	}

	//default WebDriver
	public static WebDriverEngine getInstance(){
		if(instance == null){
			instance = new WebDriverEngine();
			webEngine = "firefox";
			getDriver();
			getDriverWait();
			getExecutor();
		}
		sendToLog();
		return instance;
	}

	//custom WebDriver
	public static WebDriverEngine getInstance(String browser){
		if(instance == null){
			instance = new WebDriverEngine();
			webEngine = browser;
			getDriver();
			getDriverWait();
			getExecutor();
		}
		sendToLog();
		return instance;
	}

	public static WebDriver getDriver() {
		if(driver == null){
			if(webEngine == "firefox"){
				driver = new FirefoxDriver();
			}
			else if(webEngine == "IE"){
				System.setProperty("webdriver.ie.driver", "C://Devs//IE//32//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else{
				driver = new FirefoxDriver();
			}		
		}
		return driver;
	}
	
	public static WebDriverWait getDriverWait(){
		if(driverWait == null){
			driverWait = new WebDriverWait(driver, 10);
		}
		return driverWait;
	}	
	
	public static JavascriptExecutor getExecutor(){
		if(executor == null){
			executor =  (JavascriptExecutor) driver;
		}
		return executor;
	}
	
	public static void Close(){
		driver.close();
		logCat.sendToLog("[Tear]\t -WebDriver Close");		
	}
	
	private static void sendToLog() {
		logCat.sendToLog("[Init]\t -WebDriver Starting -" + webEngine);			
	}
}
