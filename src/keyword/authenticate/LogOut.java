package keyword.authenticate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogStatus.logaction;
import output.LogStatus.logexestatus;
import output.LogStatus.logoperation;
import output.LogStatus.logpage;

public class LogOut implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
			//executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
			driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")).click();
			Alert javascriptprompt = driver.switchTo().alert();
			logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Logout, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Logout, logaction.Comfirm, "Yes");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Logout, "Time out");
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
		logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Logout);
	}

}
