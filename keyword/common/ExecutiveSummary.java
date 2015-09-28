package common;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;

import customcomponent.Dropdown;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class ExecutiveSummary implements base.KeywordsCSM {
	
	private logoperation logoperation;
	public ExecutiveSummary(logoperation logoperation){
		this.logoperation = logoperation;
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click บทสรุปผู้บริหาร Tab
			String btnExcSummaryTab = "//*[@id='mainTab']/ul/li[9]/a";
			new WaitFor().xpath(btnExcSummaryTab);
			driver.findElement(By.xpath(btnExcSummaryTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บทสรุปผู้บริหาร Tab");			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บทสรุปผู้บริหาร Tab");
			return false;
		}
		try{
		// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "บทสรุปผู้บริหาร Tab OK");
		}catch (NoAlertPresentException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "บทสรุปผู้บริหาร Tab");
		}
		try {
			// Select DropDown :เหุตผลหลักที่ใช้ในการพิจารณา *	=A01 : ผู้กู้มีความสามารถในการชำระหนี้ดี
			String inputField = "//*[@id='exConclusionForm']/table[1]/tbody/tr[1]/td[2]/input";
			String inputValue = "A01 : ผู้กู้มีความสามารถในการชำระหนี้ดี";
			String selectField = "mainCommentCode";
			String selectValue = "A01";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, ":เหุตผลหลักที่ใช้ในการพิจารณา *	=A01 : ผู้กู้มีความสามารถในการชำระหนี้ดี");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, ":เหุตผลหลักที่ใช้ในการพิจารณา *	=A01 : ผู้กู้มีความสามารถในการชำระหนี้ดี");
			return false;
		}
		try {
			// Input Text รายละเอียด *	
			String inputDescription = "description"; // id
			String descriptionValue = "ผู้กู้ชำระเงินตรงตามที่กำหนดในสัญญาเสมอเลยฮะ";
			driver.findElement(By.id(inputDescription)).clear();
			driver.findElement(By.id(inputDescription)).sendKeys(descriptionValue);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "รายละเอียด *	" + "ผู้กู้ชำระเงินตรงตามที่กำหนดในสัญญาเสมอเลยฮะ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "รายละเอียด *	" + "ผู้กู้ชำระเงินตรงตามที่กำหนดในสัญญาเสมอเลยฮะ");
			return false;
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
		return false;
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
		logCat.sendToLog(logexestatus, logoperation, logtab.ExcSummary, logsubtab.None, logelement.None,
				logaction, null);
	}
}
