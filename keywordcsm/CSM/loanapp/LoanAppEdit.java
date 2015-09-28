package CSM.loanapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class LoanAppEdit implements KeywordsCSM {
	
	String CMSNo = "";

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click บันทึกแก้ไข Tab
			String btnEdit = "บันทึกแก้ไข";
			new WaitFor().linkText(btnEdit);
			driver.findElement(By.linkText(btnEdit)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึกแก้ไข Tab");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึกแก้ไข Tab");
			return false;
		}
		try{
		// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "บันทึกแก้ไข Tab OK");
		}catch (NoAlertPresentException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "บันทึกแก้ไข Tab");
		}
		try {
			// Get CMS 
			String cmsName = "//*[@id='tabs-1']/table/tbody/tr[2]/td[5]";
			new WaitFor().xpath(cmsName);
			String rawString = driver.findElement(By.xpath(cmsName)).getText();
			//System.out.println(rawString);
			int startNo = rawString.indexOf("เลขที่") + 7;
			for(int i=startNo;i<rawString.length();i++){
				if(rawString.charAt(i)>='0' && rawString.charAt(i)<='9'){
					CMSNo += rawString.charAt(i);
				}
				else{
					break;
				}
				//System.out.println(i+" "+"'"+rawString.charAt(i)+"'");
			}
			//System.out.println(CMSNo);
			sendToLogCustom(logexestatus.PASS, logaction.Get, "CMS No. " + CMSNo);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Get, "CMS No.");
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.LoanApp, logtab.Edit, logsubtab.None, logelement.None,
				logaction, null);
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.LoanApp, logtab.Edit, logsubtab.None, logelement.None,
				logaction, str);
	}

	public String getCMSNum() {
		return CMSNo;
	}

}
