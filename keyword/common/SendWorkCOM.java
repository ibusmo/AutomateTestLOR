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

public class SendWorkCOM extends KeywordsCOM {

	public SendWorkCOM(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.SendWork;
		super.logtab 			= log.LogTag.logtab.SendWork;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Select DropDown :กรุณาเลือกทางเลือก =ส่งงานต่อ
			new Dropdown().id("responses", "Next", "showHideDivByEndReason(this.value);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
		} catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
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
