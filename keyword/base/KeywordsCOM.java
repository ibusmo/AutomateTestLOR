package base;



import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import customcomponent.AlertHandle;
import customcomponent.CheckBox;
import customcomponent.Click;
import customcomponent.DatePicker;
import customcomponent.Dropdown;
import customcomponent.Popup;
import customcomponent.Radio;
import customcomponent.Type;
import log.LogCat;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import testdata.LoadElement;
import testdata.elementObj;
import testdata.CellTag.fieldType;
import testdata.CellTag.inputType;
import webdriver.WebDriverEngine;

public abstract class KeywordsCOM{

	protected WebDriver driver = WebDriverEngine.getDriver();
	protected WebDriverWait wait = WebDriverEngine.getDriverWait();
	protected JavascriptExecutor executor = WebDriverEngine.getExecutor();
	protected LogCat logCat = LogCat.getInstance();
	
	protected logoperation logoperation;
	protected logtab logtab;
	protected logsubtab logsubtab;
	
	protected String workSheetPath;
	protected int sizeOfData;
	protected int offsetRow;
	
	protected abstract void initKeywords();
	
	protected LoadElement regData;
	protected List<elementObj> elementObjList;
	
	protected void loadData(){
		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		if(regData.loadData()){
			elementObjList = regData.getObject();
			sendToLogCustom(logexestatus.PASS, logaction.LoadData, null);
		}else{
			sendToLogCustom(logexestatus.FAIL, logaction.LoadData, null);			
		}
	}

	public boolean execute() {
		sendToLogStart();

		for(elementObj obj : elementObjList){
			precondition(obj);
			if(obj.run==false) continue;
			switch(obj.inputType){
				case button:
					if(caseButton(obj)==false) 
						return false;
					break;
				case dropdown:
				case dropdownx:
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
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
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
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Date, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
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
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
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
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}
		return true;
	}
	
//	Default case
//	protected boolean caseText(elementObj obj) {
//		try{
//			new Type().RunText(obj);
//			sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
//		}catch (TimeoutException e){
//			sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag);
//			return false;
//		}
//		return true;
//	}
	
	protected boolean caseText(elementObj obj) {
		//@Override Method for GENERATE NUMBER
		try{
			obj.dataTag = obj.value!="" && obj.value!="null" ? getNum((int)Math.round(Double.parseDouble(obj.value))) : obj.dataTag;
			new Type().RunText(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
		}catch(NumberFormatException e){
			new Type().RunText(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag);
			return false;
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}
		return true;
	}
	
	private String getNum(int point){
		  Random ran = new Random();
		  int low = (int) Math.pow(10, point-1);
		  int high = (int) Math.pow(10, point)-low;
		  int tmp = ran.nextInt(high) + low;
		  return ""+tmp;
	}
	
	protected boolean caseDropdown(elementObj obj) {
		try{
			if(obj.inputType==inputType.dropdownx){
				new Dropdown().RunDropdown(obj, true);
				sendToLogCustom(logexestatus.PASS, logaction.DropdownNoText, obj.nameTag + ": " + obj.dataTag);
			}
			else{
				new Dropdown().RunDropdown(obj, false);
				sendToLogCustom(logexestatus.PASS, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
			}
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
			return false;
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}catch(NoSuchElementException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
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
			if(obj.fieldType == fieldType.linktext)	{
				//Nothing TO DO
			}
			else if(obj.dataTag.toLowerCase().contains("DRAFT")){
				//Nothing TO DO
			}else{
				return false;
			}
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}
		return true;
	}	
	
	protected void precondition(elementObj obj) {
		// TO BE OVERRIDE
	}
	
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None, null);
	}

	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation, logtab, logsubtab, logelement.None,
				logaction, str);
	}
}
