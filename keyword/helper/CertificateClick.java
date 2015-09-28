package helper;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.KeywordsCSM;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class CertificateClick implements KeywordsCSM {

	private String linkCertiificate;
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Click Certificate 
			linkCertiificate = "overridelink";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(linkCertiificate)));
			driver.findElement(By.id(linkCertiificate)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click);
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
		logCat.sendToLog(logexestatus, 
				logoperation.Certificate, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}
}
