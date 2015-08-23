package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogStatus.logaction;
import output.LogStatus.logexestatus;
import output.LogStatus.logoperation;
import output.LogStatus.logpage;

public class CertificateClick implements Keywords {

	private String linkCertiificate;
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		try{
			linkCertiificate = "overridelink";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(linkCertiificate)));
			driver.findElement(By.id(linkCertiificate)).click();
			logCat.sendToLog("[FAIL]\t -Time out\t -Certificate");
			logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Certificate, logaction.Click);
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Certificate, logaction.Click);
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	@Override
	public void sendToLogStart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendToLogFinish() {
		logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Certificate);
	}

}
