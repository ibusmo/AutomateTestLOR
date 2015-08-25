package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CertificateClick implements Keywords {

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
