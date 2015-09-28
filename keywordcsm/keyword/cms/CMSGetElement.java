package keyword.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class CMSGetElement implements KeywordsCSM {
	
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
				//System.out.println(tmpCMSNum);
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
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.WorkBox, logsubtab.None, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.WorkBox, logsubtab.None, logelement.None,
				logaction, str);
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}
}
