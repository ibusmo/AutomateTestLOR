package common;


import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import customcomponent.AlertHandle;
import customcomponent.Click;
import customcomponent.Dropdown;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import base.KeywordsCOM;

public class EndWorkCOM extends KeywordsCOM {

	public EndWorkCOM(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.EndWork;
		super.logtab 			= log.LogTag.logtab.EndWork;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click Tab ส่งงาน
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
		}
		try {
			// Select DropDown :กรุณาเลือกทางเลือก =จบการทำงาน
			new Dropdown().id("//*[@id='btnSendDiv']/table[1]/tbody/tr[1]/td/div[2]/input", "จบการทำงาน",
								"responses", "End", 
								"showHideDivByEndReason(this.value);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก =จบการทำงาน");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =จบการทำงาน");
			//return false;
		}catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =จบการทำงาน");
			//return false;
		}
		try {
			// Select DropDown :เหตุผลการยกเลิก =CC : ลูกค้าปฏิเสธ
			new Dropdown().id("selectedEndReason", "CC");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":เหตุผลการยกเลิก =CC : ลูกค้าปฏิเสธ");
		} catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":เหตุผลการยกเลิก =CC : ลูกค้าปฏิเสธ");
			//return false;
		}
		try {
			// Click Send ส่งงานต่อ
			new Click().id("btnSend");
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
