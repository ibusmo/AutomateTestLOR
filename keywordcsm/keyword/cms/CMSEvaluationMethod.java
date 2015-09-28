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

public class CMSEvaluationMethod implements KeywordsCSM {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			// Click Sub-tab การประเมินราคา
			String linkSubtab = "การประเมินราคา";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab การประเมินราคา");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab การประเมินราคา");
			return false;
		}
		try{
			//Radio Button ประเมินราคาในประเทศ *
			String radioDomesticField = "isDomesticAppraisal";
			new WaitFor().name(radioDomesticField);
			List<WebElement> radios = driver.findElements(By.name(radioDomesticField));
			radios.get(1).click(); //ไม่ใช่
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "ประเมินราคาในประเทศ *: ไม่ใช่");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "ประเมินราคาในประเทศ *: ไม่ใช่");
			return false;
		}
		try{
			// Type input ประเมินราคาโดย * StarkIndustries
			String inputOrganize = "overSeaAppraisal";
			String organizeValue = "Stark Industry";
			new WaitFor().name(inputOrganize);
			driver.findElement(By.name(inputOrganize)).clear();
			driver.findElement(By.name(inputOrganize)).sendKeys(organizeValue);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "ประเมินราคาโดย * 	" + organizeValue);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "ประเมินราคาโดย * 	");
			return false;
		}
		try{
			// Type input หน่วยงานผู้อนุมัติราคา * S.H.I.E.L.D.
			String inputTeam = "foreignApprovalDept";
			String teamValue = "S.H.I.E.L.D.";
			new WaitFor().name(inputTeam);
			driver.findElement(By.name(inputTeam)).clear();
			driver.findElement(By.name(inputTeam)).sendKeys(teamValue);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "หน่วยงานผู้อนุมัติราคา * " + teamValue);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "หน่วยงานผู้อนุมัติราคา * ");
			return false;
		}
		try{
			// Click SAVE
			/*
			String btnSave = "//*[@id='content']/div/form/div/table[4]/tbody/tr/td/input[1]";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
			*/
			executor.executeScript("selectPage('doSaveDraft')", driver.findElement(By.id("content")));
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click SAVE ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click SAVE ");
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.EvaMethod, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.EvaMethod, logelement.None,
				logaction, str);
	}

}
