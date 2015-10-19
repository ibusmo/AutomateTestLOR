package creditanalysis;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import base.KeywordsCOM;
import customcomponent.AlertHandle;
import customcomponent.Click;
import customcomponent.Dropdown;
import log.LogTag.logaction;
import log.LogTag.logexestatus;

public class CMDEPTAssign extends KeywordsCOM {
	
	public CMDEPTAssign(){
		initKeywords();
	}

	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.CMDEPTAssign;
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
			// Select DropDown :กรุณาเลือกทางเลือก = ส่งงานต่อ (Auto Assign)
			new Dropdown().idNoText("//*[@id='btnSendDiv']/table[2]/tbody/tr[1]/td/div[2]/input", "ส่งงานต่อ (Auto Assign)",
								"responses", "NextAuto", 
								"showHideDivByEndReason(this.value);");
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ (Auto Assign)");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ (Auto Assign)");
			e.getStackTrace();
			return false;
		}catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก = ส่งงานต่อ (Auto Assign)");
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
		
		
		
		
		
		
		
		
		
		sendToLogFinish();
		return true;
	}

}
