package keyword.cms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class CMSPartPledge implements KeywordsCSM {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			// Click Sub-tab จำนองเฉพาะส่วน
			String linkSubtab = "จำนองเฉพาะส่วน";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab จำนองเฉพาะส่วน");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab จำนองเฉพาะส่วน");
			return false;
		}
		try{
			//Radio Button จำนองเฉพาะส่วน *
			String radioPartPledgedField = "landIsPartPledged";
			new WaitFor().name(radioPartPledgedField);
			List<WebElement> radios = driver.findElements(By.name(radioPartPledgedField));
			radios.get(1).click(); //ไม่ใช่
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "จำนองเฉพาะส่วน *: ไม่ใช่");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "จำนองเฉพาะส่วน *: ไม่ใช่");
			return false;
		}
		try{
			// Click SAVE
			/*
			String btnSave = "//*[@id='content']/div/form/div/table/tbody/tr[9]/td/input";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
			*/
			executor.executeScript("selectPage('doSaveDraft')", driver.findElement(By.id("content")));
			executor.executeScript("selectPage('doSave')", driver.findElement(By.id("content")));
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click SAVE ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click SAVE ");
			return false;
		}
		try {
			// Click ตกลง
			String btnAccept = "//*[@id='content']/div/form/table/tbody/tr[2]/td/input";
			new WaitFor().xpath(btnAccept);
			driver.findElement(By.xpath(btnAccept)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ตกลง");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ตกลง");
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.PartPledge, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.PartPledge, logelement.None,
				logaction, str);
	}

}
