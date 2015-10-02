package common;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Click;
import customcomponent.Type;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import base.KeywordsCOM;

public class SearchWorkBOx extends KeywordsCOM {

	String appID;
	String username;
	
	//viewStatus('038309580126')
	
	public SearchWorkBOx(String appID){
		this.appID = appID;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.SearchWorkBOx;
		super.logtab 			= log.LogTag.logtab.SearchWorkBOx;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// คลิก Tab ค้นหาใบคำขอสินเชื่อ
			new Click().linkText("ค้นหา");
			new Click().linkText("ค้นหาใบคำขอสินเชื่อ");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Tab ค้นหาใบคำขอสินเชื่อ");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Tab ค้นหาใบคำขอสินเชื่อ");
			return false;
		}
		
		try {
			// เลขที่ใบคำขอสินเชื่อ
			new Type().id("searchCaNumber", appID);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "เลขที่ใบคำขอสินเชื่อ : " + appID);
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "เลขที่ใบคำขอสินเชื่อ : " + appID);
			return false;
		}

		try {
			// คลิก ค้นหา
			new Click().xpath("//*[@id='searchApplicationDiv']/div[2]/center/button[1]");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ค้นหา");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ค้นหา");
			return false;
		}

		try {
			// คลิก ติดตามสถานะ
			new Click().xpath("//*[@id='searchResultDiv']/table/tbody/tr[2]/td[8]/button[2]");
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ติดตามสถานะ");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ติดตามสถานะ");
			return false;
		}
		
		try {
			// Get username
			String usernamePath = "//*[@id='searchResultDiv']/table/tbody/tr[2]/td[2]";
			new WaitFor().xpath(usernamePath);
			username = driver.findElement(By.xpath(usernamePath)).getText();
			sendToLogCustom(logexestatus.PASS, logaction.Get, "username");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Get, "username");
			return false;
		}
		
		System.out.println(username);
	
		sendToLogFinish();
		return true;
	}
	
	public String getUsername(){
		return username;
	}
}
