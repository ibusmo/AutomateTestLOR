package CustomComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import output.LogCat;

public class SelectPopup implements CustomComponent {
	//Wait for POPUP
	public WebDriver byxpath(String xpath, int numPopup) {
		int timeCount = 1;
		do {
			driver.getWindowHandles();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				LogCat.getInstance().sendToLog("[POPUP]\t" + "Wait for popup " + " Thread Error");	
				e.printStackTrace();			
			}
			timeCount++;
			if (timeCount > 50) {
				// break;
				return null;
			}
		} while (driver.getWindowHandles().size() != numPopup);
		
		//Wait For Elements
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			LogCat.getInstance().sendToLog("[POPUP]\t" + "Wait for popup " + " Thread Error");	
			e.printStackTrace();
		}
		
		//SELECT POPUP
		for (String winHandle : driver.getWindowHandles()) {
			WebDriver popup = null;
			popup = driver.switchTo().window(winHandle);
			try {
				if (popup.findElement(By.xpath(xpath)).isDisplayed()) {
					LogCat.getInstance().sendToLog("[SELECT]\t" + driver.getCurrentUrl());
					return popup;
				}
			} catch (NoSuchElementException e) {
				// LogCat.getInstance().sendToLog("GET POPUP CRASH !!!");
			}
			LogCat.getInstance().sendToLog("[POPUP]\t" + driver.getCurrentUrl());
		}
		return null;
	}
}
