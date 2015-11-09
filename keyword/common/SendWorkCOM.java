package common;


import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;

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
			// Select DropDown :กรุณาเลือกทางเลือก =ส่งงานต่อ
			new Dropdown().id("//*[@id='btnSendDiv']/table[2]/tbody/tr[1]/td/div[2]/input", "ส่งงานต่อ",
								"responses", "Next", 
								"showHideDivByEndReason(this.value);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
			e.getStackTrace();
			//return false;
		}catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
			e.getStackTrace();
			//return false;
		}
		
		
		
		
		
		
		
		
		try {
			// Click Send ส่งงานต่อ
			new Click().id("btnSend");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ส่งงานต่อ");

			try{
				// Alert ยืนยันการส่งงาน
				new AlertHandle().execute();
				sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ยืนยันการส่งงาน OK");
			}catch (NoAlertPresentException e) {
				sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ยืนยันการส่งงาน");
			}
			
			sendToLogFinish();
			return true;
			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
			//return false;
		}
		
		
		
		
		
		
		
		try {
			// Click Send ส่งงานต่อ
			new Click().xpath("//*[@id='btnSendDiv']/table[2]/tbody/tr/td/button");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ส่งงานต่อ");

			try{
				// Alert ยืนยันการส่งงาน
				new AlertHandle().execute();
				sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ยืนยันการส่งงาน OK");
			}catch (NoAlertPresentException e) {
				sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ยืนยันการส่งงาน");
			}
			
			sendToLogFinish();
			return true;
			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
			//return false;
		}catch(UnhandledAlertException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
		}

		sendToLogFinish();
		return true;
	}
}
