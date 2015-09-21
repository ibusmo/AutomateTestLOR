package webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import output.LogCat;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

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
		// Config driver here
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
		logCat.sendToLog(logexestatus.TEAR, 
				logoperation.WebDriver, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction.Stop, 
				webEngine);
	}
	
	private static void sendToLog() {	
		logCat.sendToLog(logexestatus.INIT, 
				logoperation.WebDriver, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction.Start, 
				webEngine);
	}

	public static void quit() {
		driver.quit();
	}
}
