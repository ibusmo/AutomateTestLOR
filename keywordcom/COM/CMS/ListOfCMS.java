package COM.CMS;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Click;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import base.KeywordsCOM;
import testdata.CellTag.collacteralType;
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
		super.logoperation 		= log.LogTag.logoperation.CMS;
		super.logtab 			= log.LogTag.logtab.ListofCMS;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}


	@Override
	public boolean execute() {
		sendToLogStart();
		
		if(workBox()==false)	return false;		

		if(listAllCMS()==false)	return false;
		workBox();
		
		for(String CMSnumber : CMSNumbers){
			workBox();
			
			String buttonEval = getButtonEval(CMSnumber);	System.out.print(CMSnumber + " ");	System.out.println(buttonEval);
			if(buttonEval==null){	return false;	}
			
			collacteralType collType = enterAndGetCMSType(buttonEval, CMSnumber);
			if(collType==collacteralType.None)	return false;
			else if(collType==collacteralType.Land){
				new CMSLand().execute();
			}
			else if(collType==collacteralType.LandNBuilding){
				new CMSLandBuilding().execute();
			}
			else if(collType==collacteralType.Building){
				new CMSBuilding().execute();
			}						
		} 
		
		for(String CMSnumber : CMSNumbers){
			workBox();
			
			String buttonEval = getButtonSend(CMSnumber);	System.out.print(CMSnumber + " ");	System.out.println(buttonEval);
			if(buttonEval==null){	return false;	}
			
			sendWork(buttonEval);
			
			break;			
		} 
		
		sendToLogFinish();
		return true;
	}
	
	private void sendWork(String buttonEval) {
		new WaitFor().xpath(buttonEval);
		new Click().auto(fieldType.xpath, buttonEval);		
	}

	private collacteralType enterAndGetCMSType(String buttonEval, String cMSnumber) {		
		String tmpCollTypeStr = null;
		collacteralType tmpCollType = collacteralType.None;
		try{		
			new WaitFor().xpath(buttonEval);
			new Click().auto(fieldType.xpath, buttonEval);		
			String typeOfCollacteral = "//*[@id='securities']/table/tbody/tr[1]/td[5]";
			new WaitFor().xpath(typeOfCollacteral);
			tmpCollTypeStr = driver.findElement(By.xpath(typeOfCollacteral)).getText();
			//System.out.println(tmpCollTypeStr);
			
			if(tmpCollTypeStr.contains("18")){
				tmpCollType = collacteralType.Vehicle;	
			}else if(tmpCollTypeStr.contains("1")){
				tmpCollType =  collacteralType.Land;		
			}else if(tmpCollTypeStr.contains("2")){
				tmpCollType = collacteralType.LandNBuilding;				
			}else if(tmpCollTypeStr.contains("3")){
				tmpCollType = collacteralType.Building;				
			}
			sendToLogCustom(logexestatus.PASS, logaction.Get, "CMS:" + cMSnumber + " : " + tmpCollTypeStr + " : " + tmpCollType);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Get, "CMS:" + cMSnumber + " : " + tmpCollTypeStr + " : " + tmpCollType);
		}
		return tmpCollType;
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
				//System.out.println(tempCMSnum);
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

	private String getButtonSend(String cMSnumber) {
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
				//System.out.println(tempCMSnum);
				if(tempCMSnum.toLowerCase().matches(cMSnumber)){
					// Get CMS number
					return "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[9]/input[2]";	
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
				//System.out.println(tempAppID);
				// Match with App ID
				if(tempAppID.toLowerCase().matches(appID)){
					// Get CMS number
					String rowCMS = "//*[@id='content']/div/form/table/tbody/tr["+index+"]/td[2]";
					new WaitFor().xpath(rowCMS);
					String tempCMSnum = driver.findElement(By.xpath(rowCMS)).getText();
					CMSNumbers.add(tempCMSnum);
					//System.out.println(tempCMSnum);
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Get, "Error, Something went wrong.");
			}			
		}
		return true;
	}

	private boolean workBox() {
		// Click การประเมินราคาใหม่จาก
		try {
			String linkEva = "การประเมินราคาใหม่";
			new Click().auto(fieldType.linktext, linkEva);
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Tab การประเมินราคาใหม่");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Tab การประเมินราคาใหม่");
			return false;
		}
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
