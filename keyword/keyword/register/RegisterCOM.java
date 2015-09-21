package keyword.register;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import keyword.KeywordsCOM;
import output.LogTag.logaction;
import output.LogTag.logexestatus;
import testdata.elementObj;

public class RegisterCOM extends KeywordsCOM {
	
	String appID;
	
	public RegisterCOM(int sheetIndex) {
		super.workSheetPath = "register_com_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 	= output.LogTag.logoperation.Register;
		super.logtab 			= output.LogTag.logtab.None;
		super.logsubtab 		= output.LogTag.logsubtab.None;

		super.sizeOfData = 26;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();

		for(elementObj obj : elementObjList){
			if(obj.run==false) continue;
			switch(obj.inputType){
			case button:
				if(caseButton(obj)==false) 
					return false;
				break;
			case dropdown:
				if(caseDropdown(obj)==false)
					return false;
				break;
			case text:
				if(caseText(obj)==false) 
					return false;
				break;
			case radio:
				if(caseRadio(obj)==false) 
					return false;
				break;
			case checkbox:
				if(caseCheckbox(obj)==false) 
					return false;
				break;
			case date:
				if(caseDate(obj)==false) 
					return false;
				break;
			case popup:
				if(casePopup(obj)==false) 
					return false;
				break;
			case alert:
				if(caseAlert(obj)==false) 
					return false;
				break;
			default:
				break;
			}
		}
		
		FindAppID();
		
		sendToLogFinish();
		return true;
	}
	
	private boolean FindAppID() {
		try{
			//Get AppID
			String textAppID = "current_appId";
			new WaitFor().id(textAppID);
			appID = driver.findElement(By.id(textAppID)).getText();
			sendToLogCustom(logexestatus.PASS, logaction.Get, appID);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Get, appID);
			return false;
		}
		return true;
	}

	public String getAppID() {
		return appID;
	}
}
