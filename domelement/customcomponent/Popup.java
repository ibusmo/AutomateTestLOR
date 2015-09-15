package customcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import output.LogCat;
import testdata.CellTag.fieldType;
import testdata.elementObj;

public class Popup implements CustomComponent {
	
	public WebDriver RunPopup(elementObj obj) {
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX RunPopup");
		return auto(obj.filedType, obj.fieldName, obj.value);
	}
	
	private WebDriver auto(fieldType filedType, String fieldName, String value) {
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX auto");
		switch(filedType){
		case id:
			break;
		case name:
//			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX filedType");
			return byname(fieldName, Integer.parseInt(value));
		case xpath:
			return byxpath(fieldName, Integer.parseInt(value));
		case linktext:
			break;
		}
		return null;
	}

	public WebDriver byxpath(String xpath, int numPopup) {
		//Wait for POPUP
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
			if (timeCount > 100) {
				// break;
				return null;
			}
		} while (driver.getWindowHandles().size() != numPopup);
		
		//Wait For Elements
		try {
			Thread.sleep(3000);
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
	
	public WebDriver byname(String name, int numPopup) {
//		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX byname");
		//Wait for POPUP
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
			if (timeCount > 100) {
				// break;
				return null;
			}
		} while (driver.getWindowHandles().size() != numPopup);
		
		//Wait For Elements
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			LogCat.getInstance().sendToLog("[POPUP]\t" + "Wait for popup " + " Thread Error");	
			e.printStackTrace();
		}
		
		//SELECT POPUP
		for (String winHandle : driver.getWindowHandles()) {
			WebDriver popup = null;
			popup = driver.switchTo().window(winHandle);
			try {
				if (popup.findElement(By.name(name)).isDisplayed()) {
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
