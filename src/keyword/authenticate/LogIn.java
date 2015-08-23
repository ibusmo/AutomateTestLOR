package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elementAttribute.LogInElement;
import keyword.Keywords;
import output.LogStatus.logaction;
import output.LogStatus.logexestatus;
import output.LogStatus.logoperation;
import output.LogStatus.logpage;

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
			logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Login, logaction.Fill_login, username + " : " + password);
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Login, logaction.Fill_login, username + " : " + password);
			return false;
		}
		try{
			//Kick
			driver.findElement(By.id(loginElement.textboxPassword)).sendKeys(password);
			driver.findElement(By.id(loginElement.buttonLogin)).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.General, logpage.Login, logaction.Fill_login_again);
		}catch (NoSuchElementException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Login, logaction.Fill_login_again);
			return false;
		}
		
		sendToLogFinish();
		return true;
	}

	@Override
	public void sendToLogStart() {
	}

	@Override
	public void sendToLogFinish() {
		logCat.sendToLog(logexestatus.FAIL, logoperation.General, logpage.Login);
	}
}
