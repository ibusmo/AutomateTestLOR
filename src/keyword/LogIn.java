package keyword;

import org.openqa.selenium.By;

import element.LogInElement;

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
		driver.findElement(By.id(element.textboxUsername)).sendKeys(username);
		driver.findElement(By.id(element.textboxPassword)).sendKeys(password);
		driver.findElement(By.id(element.buttonLogin)).click();
		sendToLog();
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean sendToLog() {
		logCat.sendToLog("Log in as u:" + username + " p:" + password);
		return true;
	}
}
