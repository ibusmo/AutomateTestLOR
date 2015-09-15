package keyword;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

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

public abstract class KeywordsCOM implements Keywords {

//	public WebDriver driver = WebDriverEngine.getDriver();
//	public WebDriverWait wait = WebDriverEngine.getDriverWait();
//	public JavascriptExecutor executor = WebDriverEngine.getExecutor();
//	public LogCat logCat = LogCat.getInstance();
	
	public abstract void initKeywords();
	
	protected LoadElement regData;
	protected List<elementObj> elementObjList;
	
	protected void loadData(){
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
				try{
					new Click().RunButton(obj);
					sendToLogCustom(logexestatus.PASS, logaction.Click, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case dropdown:
				try{
					new Dropdown().RunDropdown(obj, false);
					sendToLogCustom(logexestatus.PASS, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case text:
				try{
					new Type().RunText(obj);
					sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case radio:
				try{
					new Radio().RunRadio(obj);
					sendToLogCustom(logexestatus.PASS, logaction.Radio, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Radio, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case checkbox:
				try{
					new CheckBox().RunCheckBox(obj);
					sendToLogCustom(logexestatus.PASS, logaction.Checkbox, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case date:
				try{
					new DatePicker().runDatePicker(obj);
					sendToLogCustom(logexestatus.PASS, logaction.Date, obj.nameTag + ": " + obj.dataTag);
				}catch (TimeoutException e){
					sendToLogCustom(logexestatus.FAIL, logaction.Date, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			case popup:
				WebDriver popup = new Popup().RunPopup(obj);
				if (popup != null) {
					sendToLogCustom(logexestatus.PASS, logaction.Popup, obj.nameTag + ": " + obj.dataTag);
				} else {
					sendToLogCustom(logexestatus.FAIL, logaction.Popup, obj.nameTag + ": " + obj.dataTag);
					return false;
				}
				break;
			default:
				break;
			}
		}
		
		sendToLogFinish();
		return true;
	}
		
	protected logoperation logoperation;
	protected logtab logtab;
	protected logsubtab logsubtab;
	
	
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
