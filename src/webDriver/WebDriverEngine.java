package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverEngine {
	private static WebDriverEngine instance    =  null;
	private static WebDriver driverTest = null;
	private static String webEngine = null;
	
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

	public static WebDriver getDriverTest() {
		if(driverTest == null){
			if(webEngine == "firefox")
				driverTest = new FirefoxDriver();
			else
				driverTest = new FirefoxDriver();
		}
		return driverTest;
	}
}
