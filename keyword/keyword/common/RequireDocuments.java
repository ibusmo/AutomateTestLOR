package keyword.common;

import org.openqa.selenium.TimeoutException;

import customcomponent.AlertHandle;
import customcomponent.Click;
import keyword.KeywordsCOM;
import output.LogTag.logaction;
import output.LogTag.logexestatus;
import testdata.CellTag.fieldType;

public class RequireDocuments extends KeywordsCOM {

	public RequireDocuments(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.RequireDoc;
		super.logsubtab 		= output.LogTag.logsubtab.None;	
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click เอกสารที่ต้องการ Tab
			String btnReqDocsTab = "เอกสารที่ต้องการ";
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
