package keyword.registerandscnanning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class SendWork implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Select DropDown :กรุณาเลือกทางเลือก =ส่งงานต่อ
			// Manual DropDown
			String selectField = "responses";
			String selectValue = "Next";
			String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
			String jEXE = "showHideDivByEndReason('"+selectValue+"');";
			executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
			executor.executeScript(jEXE, driver.findElement(By.id(selectField)));
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
		} catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":กรุณาเลือกทางเลือก =ส่งงานต่อ");
			//return false;
		}
		try {
			// Click Send ส่งงานต่อ
			String btnSend = "btnSend";
			new WaitFor().id(btnSend);
			driver.findElement(By.id(btnSend)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ส่งงานต่อ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ส่งงานต่อ");
			return false;
		}
		try{
			// Alert ยืนยันการส่งงาน
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "ยืนยันการส่งงาน OK");
		}catch (NoAlertPresentException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "ยืนยันการส่งงาน");
		}
		sendToLogFinish();
		return true;
	}
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.SendWork, "");
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.SendWork, "");
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.None, logtab.None, logsubtab.None, logelement.None,
				logaction, str);
	}
}
