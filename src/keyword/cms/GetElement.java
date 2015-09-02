package keyword.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import output.LogTag.logaction;
import output.LogTag.logexestatus;

public class GetElement extends BaseCMS {
	
	public String getElement(String CMSNum, String elementType){
		int numRows=0;
		try{
			//Get number of Table Rows
			String elementOfTableX = "//*[@id='content']/div/form/table/tbody/tr";						
			new WaitFor().xpath(elementOfTableX);
			numRows = driver.findElements(By.xpath(elementOfTableX)).size();
			sendToLogCustom(logexestatus.PASS, logaction.Check, "There are " +numRows+ " " + " rows.");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "Can't get number of rows.");
		}
		for(int index=2;index<=numRows;index++){
			try{
				String xpathCMSRow = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[2]";
				new WaitFor().xpath(xpathCMSRow);
				String tmpCMSNum = driver.findElement(By.xpath(xpathCMSRow)).getText();
				System.out.println(tmpCMSNum);
				if(tmpCMSNum.toLowerCase().matches(CMSNum)){
					String xpathCMSButton = null;
					switch (elementType){
					case "EDIT":
						xpathCMSButton = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[9]/input[1]";
						break;
					case "SEND":
						xpathCMSButton = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[9]/input[2]";
						break;
					} 
					return xpathCMSButton;
				}else{					
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Get, "Error, Something went wrong.");
			}
		}
		return null;		
	}
}
