package keyword;

import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import customcomponent.AlertHandle;
import customcomponent.CheckBox;
import customcomponent.Click;
import customcomponent.DatePicker;
import customcomponent.Dropdown;
import customcomponent.Popup;
import customcomponent.Radio;
import customcomponent.Type;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;
import testdata.LoadElement;
import testdata.elementObj;
import testdata.CellTag.fieldType;

public abstract class KeywordsCOM implements Keywords {

//	public WebDriver driver = WebDriverEngine.getDriver();
//	public WebDriverWait wait = WebDriverEngine.getDriverWait();
//	public JavascriptExecutor executor = WebDriverEngine.getExecutor();
//	public LogCat logCat = LogCat.getInstance();
	
	public abstract void initKeywords();
	
	protected LoadElement regData;
	protected List<elementObj> elementObjList;
	
	protected logoperation logoperation;
	protected logtab logtab;
	protected logsubtab logsubtab;
	
	protected String workSheetPath;
	protected int sizeOfData;
	protected int offsetRow;
	
	protected void loadData(){
		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		if(regData.loadData()){
			elementObjList = regData.getObject();
			sendToLogCustom(logexestatus.PASS, logaction.LoadData, null);
		}else{
			sendToLogCustom(logexestatus.FAIL, logaction.LoadData, null);			
		}
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
		
		sendToLogFinish();
		return true;
	}
		
	protected boolean caseAlert(elementObj obj) {
		try{
			new AlertHandle().RunAlert(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, obj.nameTag + ": " + obj.dataTag);
			//return false;
		}catch(NoAlertPresentException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, obj.nameTag + ": " + obj.dataTag);
			//return false;
		}
		return true;
	}

	protected boolean casePopup(elementObj obj) {
		WebDriver popup = new Popup().RunPopup(obj);
		if (popup != null) {
			sendToLogCustom(logexestatus.PASS, logaction.Popup, obj.nameTag + ": " + obj.dataTag);
		} else {
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseDate(elementObj obj) {
		try{
			new DatePicker().runDatePicker(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Date, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Date, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseCheckbox(elementObj obj) {
		try{
			new CheckBox().RunCheckBox(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseRadio(elementObj obj) {
		try{
			new Radio().RunRadio(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Radio, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseText(elementObj obj) {
		try{
			new Type().RunText(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseDropdown(elementObj obj) {
		try{
			new Dropdown().RunDropdown(obj, false);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}

	protected boolean caseButton(elementObj obj) {
		try{
			new Click().RunButton(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Click, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag);
			if(obj.filedType == fieldType.linktext)	{
				//Nothing TO DO
			}else
				return false;
		}
		return true;
	}	
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None, null);
	}
	
	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation, logtab, logsubtab, logelement.None,
				logaction, str);
	}
}
