package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elementAttribute.LogInElement;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class LogIn implements Keywords {
	
	private LogInElement loginElement;
	private String username;
	private String password;
	
	public LogIn(){
		initKeywords();
	}
	
	public LogIn(String username, String password){
		this.username = username;
		this.password = password;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		loginElement = new LogInElement();
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Fill Login Field and Submit
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginElement.textboxUsername)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginElement.textboxPassword)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginElement.buttonLogin)));
			driver.findElement(By.id(loginElement.textboxUsername)).clear();
			driver.findElement(By.id(loginElement.textboxUsername)).sendKeys(username);
			driver.findElement(By.id(loginElement.textboxPassword)).clear();
			driver.findElement(By.id(loginElement.textboxPassword)).sendKeys(password);
			driver.findElement(By.id(loginElement.buttonLogin)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Fill_login, username + " : " + password);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Fill_login, username + " : " + password);
			return false;
		}
		try{
			//Kick
			driver.findElement(By.id(loginElement.textboxPassword)).sendKeys(password);
			driver.findElement(By.id(loginElement.buttonLogin)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Fill_again, username + " : " + password);
		}catch (NoSuchElementException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Fill_again, username + " : " + password);
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
				logoperation.Login, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}
	
	private void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.Login, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 				
				logaction, 
				str);
	}
}
