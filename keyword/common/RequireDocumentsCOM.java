package common;


import org.openqa.selenium.TimeoutException;

import customcomponent.AlertHandle;
import customcomponent.Click;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import base.KeywordsCOM;
import testdata.CellTag.fieldType;

public class RequireDocumentsCOM extends KeywordsCOM {

	public RequireDocumentsCOM(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RequireDoc;
		super.logtab 			= log.LogTag.logtab.RequireDoc;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click เอกสารที่ต้องการ Tab
			String btnReqDocsTab = "เอกสารที่ต้องการ";
			btnReqDocsTab = "ใบตรวจสอบเอกสาร";
			new Click().auto(fieldType.linktext, btnReqDocsTab);
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เอกสารที่ต้องการ  Tab");			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เอกสารที่ต้องการ Tab");
			return false;
		}
		try{
		// Alert
			new AlertHandle().execute();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "เอกสารที่ต้องการ  Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "เอกสารที่ต้องการ  Tab");
		}
//		try{
//			// Check Req Docs
//			String verifyReqDocsTab = "//*[@id='documentActionForm']/div[4]/div/table/tbody/tr[1]/th[2]";
//			new WaitFor().xpath(verifyReqDocsTab);
//			sendToLogCustom(logexestatus.PASS, logaction.Check, "เอกสารที่ต้องการ  Tab OK");
//		}catch(TimeoutException e){
//			sendToLogCustom(logexestatus.FAIL, logaction.Check, "เอกสารที่ต้องการ  Tab OK");
//		}
		try {
			// Click Save บันทึก
			String btnSave = "btnSave";
			new Click().auto(fieldType.id, btnSave);
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึก");
			return false;
		}
		sendToLogFinish();
		return true;
	}

}
