package CustomComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import output.LogCat;

public class SelectPopup implements CustomComponent{
	public WebDriver byxpath(String xpath){
		for(String winHandle : driver.getWindowHandles()){ 
		    WebDriver popup = null;
		    popup = driver.switchTo().window(winHandle);
		    try{
			    if(popup.findElement(By.xpath(xpath)).isDisplayed()){
					LogCat.getInstance().sendToLog("[SELECT] " + driver.getCurrentUrl());	
			    	return popup;
			    }
		    }catch (NoSuchElementException e){
				//LogCat.getInstance().sendToLog("GET POPUP CRASH !!!");			
			}
			LogCat.getInstance().sendToLog("[POPUP] " + driver.getCurrentUrl());
		  }
		return null;
	}
}
