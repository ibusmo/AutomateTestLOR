package keyword.authenticate;

import org.openqa.selenium.Alert;
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

public class LogOut implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
			//executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
			driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")).click();
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "Yes");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "Time Out");
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
				logoperation.Logout, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.Logout, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				str);
	}
}
