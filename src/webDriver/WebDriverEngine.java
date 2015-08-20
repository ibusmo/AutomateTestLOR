package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import output.LogCat;

public class WebDriverEngine {
	private static WebDriverEngine instance    =  null;
	private static WebDriver driverTest = null;
	private static String webEngine = null;
	private static LogCat logCat;
	
	private WebDriverEngine(){
		
	}

	//default WebDriver
	public static WebDriverEngine getInstance(){
		if(instance == null){
			instance = new WebDriverEngine();
			webEngine = "firefox";
		}
		return instance;
	}

	//custom WebDriver
	public static WebDriverEngine getInstance(String bw){
		if(instance == null){
			instance = new WebDriverEngine();
			webEngine = bw;
		}
		return instance;
	}

	public static WebDriver getDriver() {
		if(driverTest == null){
			if(webEngine == "firefox"){
				driverTest = new FirefoxDriver();
			}
			else if(webEngine == "IE"){
				System.setProperty("webdriver.ie.driver", "C://Devs//IE//32//IEDriverServer.exe");
				driverTest = new InternetExplorerDriver();
			}
			else{
				driverTest = new FirefoxDriver();
			}		
		}
		logCat = LogCat.getInstance();
		logCat.sendToLog("WebDriver Starting " + webEngine);	
		return driverTest;
	}
	
	public static void Close(){
		driverTest.close();
		logCat.sendToLog("WebDriver Close");		
	}
}
