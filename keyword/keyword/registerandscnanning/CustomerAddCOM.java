package keyword.registerandscnanning;

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
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;
import testdata.LoadElement;
import testdata.elementObj;

public class CustomerAddCOM implements Keywords {
	
	String CIFNo;
	
	logoperation logoperation;
	logtab logtab;
	logsubtab logsubtab;
	
	String workSheetPath;
	int sizeOfData;
	int offsetRow;
	
	LoadElement regData;
	List<elementObj> elementObjList;
	
	public CustomerAddCOM() {
		initKeywords();
	}	
	
	public CustomerAddCOM(String CIFNo) {
		this.CIFNo = CIFNo;
		initKeywords();
	}
	
//	1	NCB
//	2	คลิก
//	3	เลือกหน้าต่าง
//	4	แก้ไขข้อมูล NCB
//	5	คลิก
//	6	เลือกหน้าต่าง
//	7	เพิ่มลูกค้า
//	8	คลิก เพิ่มลูกค้า
//	9	เลือกหน้าต่าง
//	10	ค้นหาข้อมูลลูกค้า
//	11	ประเภทลูกค้า
//	12	ประเภทลูกค้า
//	13	คำค้น (Search Parameter)
//	14	คำค้น (Search Parameter)
//	15	ชื่อภาษาไทย
//	16	นามสกุลภาษาไทย
//	17	ชื่อภาษาอังกฤษ
//	18	นามสกุลภาษาอังกฤษ
//	19	ชื่อนิติบุคคลภาษาไทย
//	20	ชื่อนิติบุคคลภาษาอังกฤษ
//	21	หมายเลขบัตรประจำตัวประชาชน
//	22	หมายเลขหนังสือเดินทาง
//	23	หมายเลขทะเบียนการค้า
//	24	หมายเลขผู้เสียภาษี
//	25	CIF No.
//	26	คลิก ค้นหา
//	27	ประเภทผู้ขอสินเชื่อ
//	28	ประเภทผู้ขอสินเชื่อ
//	29	เลือกลูกค้าลำดับที่
//	30	คลิก
//	31	คลิก
//	32	เลือกหน้าต่าง
//	33	
	
	@Override
	public void initKeywords() {
		logoperation = output.LogTag.logoperation.RegScanning;
		logtab = output.LogTag.logtab.RegCustomer;
		logsubtab = output.LogTag.logsubtab.Add;
		
		workSheetPath = "customer_add";
		sizeOfData = 33;
		offsetRow = 2;
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
//				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXX POPUP");
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
