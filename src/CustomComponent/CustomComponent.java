package CustomComponent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.WebDriverEngine;

public interface CustomComponent {
	WebDriver driver = WebDriverEngine.getDriver();
	WebDriverWait wait = WebDriverEngine.getDriverWait();
	JavascriptExecutor executor = WebDriverEngine.getExecutor();
}
