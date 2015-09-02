package keyword.cms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CMSPartPledge implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
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
			String btnSave = "//*[@id='content']/div/form/div/table/tbody/tr[9]/td/input";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.PartPledge, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.PartPledge, logelement.None,
				logaction, str);
	}

}
