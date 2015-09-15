package keyword.register;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import customcomponent.CheckBox;
import customcomponent.Click;
import customcomponent.DatePicker;
import customcomponent.Dropdown;
import customcomponent.Popup;
import customcomponent.Radio;
import customcomponent.Type;
import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;
import testdata.LoadElement;
import testdata.elementObj;

public class RegisterCOM implements Keywords {


	String appID;

	String workSheetPath;
	int sizeOfData;
	int offsetRow;

	LoadElement regData;
	List<elementObj> elementObjList;

	public RegisterCOM(){
		initKeywords();
	}

//	1	ลงทะเบียน
//	2	คลิก Tab ลงทะเบียน
	
//	3	ข้อมูลผู้ขาย/ผู้แนะนำ
//	4	กลุ่มลูกค้าสินเชื่อ *
//	5	วัตถุประสงค์ของผู้ใช้งานระบบ *
//	6	วันทีสมัครใช้บริการ
//	7	ช่องทางการรับข่าวสาร
//	8	ผู้สร้างใบคำขอสินเชื่อ
//	9	เบอร์มือถือ
//	10	เบอร์ที่ทำงาน
//	11	ต่อ
	
//	12	หน่วยงานที่แนะนำลูกค้า
//	13	หน่วยงานที่แนะนำลูกค้า
//	14	หน่วยงานภายนอก *
//	15	หน่วยงานภายใน
//	16	เบอร์มือถือ
//	17	เบอร์ที่ทำงาน
//	18	ต่อ
	
//	19	หน่วยงานที่ดูแลลูกค้า
//	20	เบอร์มือถือ
//	21	เบอร์ที่ทำงาน
//	22	ต่อ
//	23	คลิก บันทึก
//	24		

	@Override
	public void initKeywords() {
		workSheetPath = "register_com";
		sizeOfData = 24;
		offsetRow = 2;
		appID = "None";
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
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None, null);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.Register, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				str);
	}
}
