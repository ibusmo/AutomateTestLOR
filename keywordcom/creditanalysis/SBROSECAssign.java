package creditanalysis;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import base.KeywordsCOM;
import customcomponent.AlertHandle;
import customcomponent.CheckBox;
import customcomponent.Click;
import customcomponent.Dropdown;
import log.LogTag.logaction;
import log.LogTag.logexestatus;

public class SBROSECAssign extends KeywordsCOM {
	
	public SBROSECAssign(){
		initKeywords();
	}

	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.SBROSECAssign;
		super.logtab 			= log.LogTag.logtab.Assignment;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click Send ส่งงานต่อ
			new Click().linkText("ส่งงาน");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Tab ส่งงาน");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Tab ส่งงาน");
			return false;
		}
		try{
			// Alert
			new AlertHandle().execute();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ส่งงาน Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ส่งงาน Tab");
		}catch(NoAlertPresentException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ส่งงาน Tab");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

		try {
			// Select DropDown :กรุณาเลือกทางเลือก = ส่งงานต่อ
			new Dropdown().id("//*[@id='btnSendDiv']/table[2]/tbody/tr[1]/td/div[2]/input", "ส่งงานต่อ",
								"responses", "Next", 
								"showHideDivByEndReason(this.value);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ");
			e.getStackTrace();
			return false;
		}catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ");
			e.getStackTrace();
			return false;
		}
		try {
			// Click Send ส่งงานต่อ
			//new Click().id("btnSend");	
			//There are two btnSend
			//0 is hidden
			
			new Click().xpath("//*[@id='btnSendDiv']/table[3]/tbody/tr/td/button");
			
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ส่งงานต่อ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
			return false;
		}
		try{
			// Alert
			new AlertHandle().execute();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ส่งงาน Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ส่งงาน Tab");
		}catch(NoAlertPresentException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ส่งงาน Tab");
		}
		
		
		
		
		


		try {
			// Select DropDown :หน่วยงาน * =101010115385070 - หน่วยวิเคราะห์สินเชื่อ(ธนาคารออมสินเขตวัชรพล)
			new Dropdown().idNoText("//*[@id='assignUser']/div/div[3]/input", "ธนาคารออมสินเขตวัชรพลและสาขาภายใต้",
								"NEWSM2CMDept_DDL", "NEWSM2CMDept-group217", 
								"populateUserList(this.value, '', errorNoResult);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":หน่วยงาน * =ธนาคารออมสินเขตวัชรพลและสาขาภายใต้");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":หน่วยงาน * =ธนาคารออมสินเขตวัชรพลและสาขาภายใต้");
			e.getStackTrace();
			return false;
		}catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":หน่วยงาน * =ธนาคารออมสินเขตวัชรพลและสาขาภายใต้");
			e.getStackTrace();
			return false;
		}
		
		try{
			//new CheckBox().name("selectedUsers");
			//Check Box force to Radio
			//Force to select ThanypornK
			// 0 is hidden
			//new Radio().name("selectedUsers", 1);

			new CheckBox().xpath("//*[@id='NEWSM2CMDeptTable']/tr[4]/td[1]/input");
			
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox, "มอบหมายงาน :SBRO");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, "มอบหมายงาน :SBRO");
		}

		
		
		
		
		
		
		try {
			// Click Send ส่งงานต่อ
			//new Click().id("btnSend");	
			//There are two btnSend
			//0 is hidden
			
			new Click().xpath("//*[@id='assignUser']/table/tbody/tr/td/button[2]");
			
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ส่งงานต่อ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
			return false;
		}
		
		try{
			// Alert ยืนยันการส่งงาน
			new AlertHandle().execute();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ยืนยันการส่งงาน OK");
		}catch (NoAlertPresentException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ยืนยันการส่งงาน");
		}
		
		sendToLogFinish();
		return true;
	}

}
