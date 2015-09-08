package keyword.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogCat;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class GotoApp implements Keywords {

	private String appID;
	
	public GotoApp(String appID) {
		this.appID = appID;
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();

		//Wait For Elements
		try {
			Thread.sleep(3000);
			LogCat.getInstance().sendToLog("[DELAY]\t" + "Wait for app " + " ...");	
		} catch (InterruptedException e) {
			LogCat.getInstance().sendToLog("[DELAY]\t" + "Wait for app " + " Thread Error");	
			e.printStackTrace();
		}
		try{
			//Click WorkBox Tab
			String btnWorkBoxTab = "//*[@id='menu-vertical']/ul/li[1]/div/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnWorkBoxTab)));
			driver.findElement(By.xpath(btnWorkBoxTab)).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.None, logelement.None, logaction.Click, "WorkBox Tab");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.None, logelement.None, logaction.Click, "WorkBox Tab");
			return false;
		}
		try{
			//Click PersonalWorkBox SubTab
			String btnPersonalWorkBoxTab = "//*[@id='101']/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnPersonalWorkBoxTab)));
			driver.findElement(By.xpath(btnPersonalWorkBoxTab)).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "PersonalWorkBox SubTab");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "PersonalWorkBox SubTab");
			return false;
		}
		try{
			//Search AppID เลขที่ใบคำขอ
			//Radio Button เลขที่ใบคำขอ
			String radioSearchType = "selectedSearchType"; //name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(radioSearchType)));
			List<WebElement> radios = driver.findElements(By.name(radioSearchType));
			radios.get(1).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Radio, "เลขที่ใบคำขอ");
			//Input Text เลขที่ใบคำขอ
			String textsearchAppId = "searchAppId"; //name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(textsearchAppId)));
			driver.findElement(By.name(textsearchAppId)).sendKeys(appID);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Type, "เลขที่ใบคำขอ");
			//Button Click ค้นหา
			String buttonSearch = "//*[@id='content']/div/div/form/div[2]/button";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonSearch)));
			driver.findElement(By.xpath(buttonSearch)).click();			
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "ค้นหา");
			//Link Click AppID
			String buttonAppID = appID;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(buttonAppID)));
			driver.findElement(By.linkText(buttonAppID)).click();			
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, appID);
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Radio, "เลขที่ใบคำขอ");
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Type, "เลขที่ใบคำขอ");
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "ค้นหา");
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, appID);
			return false;
		}
		sendToLogFinish();
		return true;
	}

	@Override
	public void sendToLogStart() {
		logCat.sendToLog(logexestatus.START, logoperation.WorkBox, logtab.None, logsubtab.None, logelement.None, logaction.None, appID);
	}

	@Override
	public void sendToLogFinish() {
		logCat.sendToLog(logexestatus.FINISH, logoperation.WorkBox, logtab.None, logsubtab.None, logelement.None, logaction.None, appID);
	}
}
