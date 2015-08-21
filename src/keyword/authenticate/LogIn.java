package keyword.authenticate;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import element.LogInElement;
import keyword.Keywords;

public class LogIn implements Keywords {
	
	private LogInElement element;
	
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
		element = new LogInElement();
	}

	@Override
	public boolean execute() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.textboxUsername)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.textboxPassword)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.buttonLogin)));
			driver.findElement(By.id(element.textboxUsername)).clear();
			driver.findElement(By.id(element.textboxUsername)).sendKeys(username);
			driver.findElement(By.id(element.textboxPassword)).clear();
			driver.findElement(By.id(element.textboxPassword)).sendKeys(password);
			driver.findElement(By.id(element.buttonLogin)).click();
			logCat.sendToLog("[PASS]\t {Loin Page}\t -Fill login\t -" + username + " : " + password);
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Loin Page}\t -Fill login\t -" + username + " : " + password);
			return false;
		}

		try{
			///
			driver.findElement(By.id(element.textboxPassword)).sendKeys(password);
			driver.findElement(By.id(element.buttonLogin)).click();
			///
			logCat.sendToLog("[PASS]\t {Loin Page}\t -Login again\t -Login");
		}catch (NoSuchElementException e){
			logCat.sendToLog("[FAIL]\t {Loin Page}\t -Login again\t -Login");
			//return false;
		}
		
		sendToLog();
		return true;
	}

	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t {Loin Page}\t -Already Login");
		return true;
	}
}
