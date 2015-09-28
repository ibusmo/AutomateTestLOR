package common;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.AlertHandle;
import customcomponent.Click;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import testdata.CellTag.fieldType;

public class AttachFilesCOM extends base.KeywordsCOM {
	
	public AttachFilesCOM(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.AttachFiles;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click เอกสารแนบ Tab
			String btnAttachFilesTab = "เอกสารแนบ";
			new Click().auto(fieldType.linktext, btnAttachFilesTab);
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เอกสารแนบ  Tab");			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เอกสารแนบ Tab");
			return false;
		}
		try{
			// Alert
			new AlertHandle().execute();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "เอกสารแนบ Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "เอกสารแนบ Tab");
		}
		int numRows=0;
		try{
			//Get number of Table Rows
			String elementOfTableX = "//*[@id='divListDocument']/div[2]/div/table/tbody/tr";
			//String elementOfTable = "#divListDocument > div:nth-child(4) > div > table > tbody > tr";
			new WaitFor().xpath(elementOfTableX);
			numRows = driver.findElements(By.xpath(elementOfTableX)).size();
			sendToLogCustom(logexestatus.PASS, logaction.Check, "There are " +(numRows-1)+ " " + " rows.");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "Can't get number of rows.");
		}
		for(int index=2;index<=numRows;index++){
			try{
				String xpathTmp = "//*[@id='divListDocument']/div[2]/div/table/tbody/tr["+index+"]/td[7]/button[2]/img";
									   //*[@id="divListDocument"]/div[2]/div/table/tbody/tr[2]        /td[7]/button[2]/img
				new WaitFor().xpath(xpathTmp);
				String bynTitle = driver.findElement(By.xpath(xpathTmp)).getAttribute("src");
				//System.out.println(bynTitle);
				if(bynTitle.toLowerCase().contains("select")){
					driver.findElement(By.xpath(xpathTmp)).click();
					//Select File Page
					new WaitFor().name("theFile");
					driver.findElement(By.name("theFile")).sendKeys("C:\\Windows\\system.ini");
					String btnAccept = "//*[@id='docList']/table/tbody/tr[4]/td/button[1]";
					driver.findElement(By.xpath(btnAccept)).click();
					sendToLogCustom(logexestatus.PASS, logaction.Attach, "Attached\t" + (index-1));
				}else{
					sendToLogCustom(logexestatus.PASS, logaction.Attach, "Not require\t" + (index-1));						
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Attach, "Error, Something went wrong.");
			}
		}
		sendToLogFinish();
		return true;
	}
}
