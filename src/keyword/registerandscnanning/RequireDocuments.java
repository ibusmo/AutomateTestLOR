package keyword.registerandscnanning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class RequireDocuments implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click เอกสารที่ต้องการ Tab
			String btnReqDocsTab = "เอกสารที่ต้องการ";
			new WaitFor().linkText(btnReqDocsTab);
			driver.findElement(By.linkText(btnReqDocsTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เอกสารที่ต้องการ  Tab");			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เอกสารที่ต้องการ Tab");
			return false;
		}
		try{
		// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "เอกสารที่ต้องการ  Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "เอกสารที่ต้องการ  Tab");
		}
		try{
			// Check Req Docs
			String verifyReqDocsTab = "//*[@id='documentActionForm']/div[4]/div/table/tbody/tr[1]/th[2]";
			new WaitFor().xpath(verifyReqDocsTab);
			sendToLogCustom(logexestatus.PASS, logaction.Check, "เอกสารที่ต้องการ  Tab OK");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "เอกสารที่ต้องการ  Tab OK");
		}
		try {
			// Click Save บันทึก
			String btnSave = "btnSave";
			new WaitFor().id(btnSave);
			driver.findElement(By.id(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึก");
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None, "");
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None, "");		
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RequireDoc, logsubtab.None, logelement.None,
				logaction, str);
	}
}
