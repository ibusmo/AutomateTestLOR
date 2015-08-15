package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverEngine {
	private static WebDriverEngine instance    =  null;
	public static WebDriver driverTest;
	private WebDriverEngine(){
		
	}

	//default WebDriver
	public static WebDriverEngine initWebDriver(){
		if(instance   == null){
			instance   = new WebDriverEngine();
			selectWebDriver("firefox");
		}
		return instance;
	}

	//custom WebDriver
	public static WebDriverEngine initWebDriver(String bw){
		if(instance   == null){
			instance   = new WebDriverEngine();
			selectWebDriver(bw);
		}
		return instance;
	}

	//select WebDriver
	public static void selectWebDriver(String webEngine){
			if(webEngine == "firefox")
				driverTest = new FirefoxDriver();
	}
}
