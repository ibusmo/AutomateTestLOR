package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;

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
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t -Time out\t -Certificate");
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	@Override
	public boolean sendToLogStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendToLogFinish() {
		logCat.sendToLog("[FAIL]\t -Certificate\t ");
		return false;
	}

}
