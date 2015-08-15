package mytestpack;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import defaultKeyword.LogIn;
import defaultKeyword.LogOut;
import defaultKeyword.OpenBrowser;
import output.LogCat;
import webDriver.WebDriverEngine;

import java.awt.event.KeyEvent;

public class mytestpack {
	public static void main(String[] args) throws AWTException {
		LogCat logCat = LogCat.getInstance();
		
		logCat.sendToLog("WebDriver Starting ...");
		WebDriverEngine.getInstance("firefox");
		logCat.sendToLog("WebDriver Started !!!");
		
		logCat.sendToLog("Opening ... https://10.251.108.203/LOR/login.jsp");
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		logCat.sendToLog("Opened !!!");
		
		logCat.sendToLog("Loging In ...");
		new LogIn("SuwitL", "testuser").execute();
		logCat.sendToLog("Loged In !!!");

		//new LogOut().execute();
	}
}








/*
driver.get("https://10.251.108.203/LOR/login.jsp");

driver.findElement(By.id("j_username")).sendKeys("adisakc");
driver.findElement(By.id("j_password")).sendKeys("testuser");
driver.findElement(By.id("wp-submit")).click();
/*
/*
  driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")).click();

  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_ENTER);
 */
/*
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));

String i = driver.getCurrentUrl();
System.out.println(i);
driver.close();
*/