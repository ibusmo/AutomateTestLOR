package helper;


import org.openqa.selenium.TimeoutException;

import base.KeywordsCSM;
import customcomponent.Click;
import customcomponent.Radio;
import customcomponent.Type;
import log.LogCat;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class GotoApp implements KeywordsCSM {

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
			String btnWorkBoxTab = "กล่องงาน";
			new Click().linkText(btnWorkBoxTab);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.None, logelement.None, logaction.Click, "WorkBox Tab");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.None, logelement.None, logaction.Click, "WorkBox Tab");
			return false;
		}
		try{
			//Click PersonalWorkBox SubTab
			String btnPersonalWorkBoxTab = "//*[@id='101']/a";
			new Click().xpath(btnPersonalWorkBoxTab);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "PersonalWorkBox SubTab");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "PersonalWorkBox SubTab");
			return false;
		}
		try{
			//Search AppID เลขที่ใบคำขอ
			//Radio Button เลขที่ใบคำขอ
			String radioSearchType = "selectedSearchType"; //name
			new Radio().name(radioSearchType, 1);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Radio, "เลขที่ใบคำขอ");
			//Input Text เลขที่ใบคำขอ
			String textsearchAppId = "searchAppId"; //name
			new Type().name(textsearchAppId, appID);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Text, "เลขที่ใบคำขอ");
			//Button Click ค้นหา
			String buttonSearch = "//*[@id='content']/div/div/form/div[2]/button";
			new Click().xpath(buttonSearch);
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, "ค้นหา");
			//Link Click AppID
			String buttonAppID = appID;	
			new Click().linkText(buttonAppID);	
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Click, appID);
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Radio, "เลขที่ใบคำขอ");
			logCat.sendToLog(logexestatus.PASS, logoperation.WorkBox, logtab.WorkBox, logsubtab.PersonalBox, logelement.None, logaction.Text, "เลขที่ใบคำขอ");
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
