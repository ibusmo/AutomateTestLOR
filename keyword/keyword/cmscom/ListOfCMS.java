package keyword.cmscom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Click;
import customcomponent.WaitFor;
import keyword.KeywordsCOM;
import output.LogTag.logaction;
import output.LogTag.logexestatus;
import testdata.CellTag.fieldType;

public class ListOfCMS extends KeywordsCOM {

	String appID;
	List<String> CMSNumbers;
	
	public ListOfCMS(String appID){
		this.appID = appID;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.CMS;
		super.logtab 			= output.LogTag.logtab.ListofCMS;
		super.logsubtab 		= output.LogTag.logsubtab.None;	
	}


	@Override
	public boolean execute() {
		sendToLogStart();
		
		if(workBox()==false)		return false;		

		if(listAllCMS()==false)		return false;
		
		for(String CMSnumber : CMSNumbers){
			String buttonEval = getButtonEval(CMSnumber);
			System.out.println(buttonEval);
			if(buttonEval==null){	return false;	}
			
		} 
		
		
		
		
		sendToLogFinish();
		return true;
	}
	
	private String getButtonEval(String cMSnumber) {
		int numberOfRows=0;
		try{
			String elementOfTableX = "//*[@id='content']/div/form/table/tbody/tr";						
			new WaitFor().xpath(elementOfTableX);
			numberOfRows = driver.findElements(By.xpath(elementOfTableX)).size();
			sendToLogCustom(logexestatus.PASS, logaction.Check, "There are " +numberOfRows+ " " + " rows.");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "Can't get number of rows.");
			return null;
		}

		for(int index=2;index<=numberOfRows;index++){
			try{
				String row = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[2]";
				new WaitFor().xpath(row);
				String tempCMSnum = driver.findElement(By.xpath(row)).getText();
				System.out.println(tempCMSnum);
				if(tempCMSnum.toLowerCase().matches(cMSnumber)){
					// Get CMS number
					return "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[9]/input[1]";	
					//String buttonSend = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[9]/input[2]";
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Get, "Error, Something went wrong.");
			}	
		}
		return null;
	}

	private boolean listAllCMS() {
		//Get number of Table Rows
		int numberOfRows=0;
		try{
			String elementOfTableX = "//*[@id='content']/div/form/table/tbody/tr";						
			new WaitFor().xpath(elementOfTableX);
			numberOfRows = driver.findElements(By.xpath(elementOfTableX)).size();
			sendToLogCustom(logexestatus.PASS, logaction.Check, "There are " +numberOfRows+ " " + " rows.");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "Can't get number of rows.");
			return false;
		}
		
		// Search CMS by App ID
		CMSNumbers = new ArrayList<String>();
		for(int index=2;index<=numberOfRows;index++){
			try{
				String row = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[3]";
				new WaitFor().xpath(row);
				String tempAppID = driver.findElement(By.xpath(row)).getText();
				System.out.println(tempAppID);
				// Match with App ID
				if(tempAppID.toLowerCase().matches(appID)){
					// Get CMS number
					String rowCMS = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[2]";
					new WaitFor().xpath(rowCMS);
					String tempCMSnum = driver.findElement(By.xpath(rowCMS)).getText();
					CMSNumbers.add(tempCMSnum);
					System.out.println(tempCMSnum);
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Get, "Error, Something went wrong.");
			}			
		}
		return true;
	}

	private boolean workBox() {
		// Click ประเมินราคาใหม่จาก LOR link
		try {
			String linkEva = "ประเมินราคาใหม่จาก LOR";
			new Click().auto(fieldType.linktext, linkEva);
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ประเมินราคาใหม่จาก LOR link");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ประเมินราคาใหม่จาก LOR link");
			return false;
		}
		return true;
	}
	
}
