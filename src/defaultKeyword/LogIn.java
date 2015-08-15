package defaultKeyword;

import org.openqa.selenium.By;

import element.LogInElement;

public class LogIn implements Keywords {
	
	private LogInElement logInElement;
	
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
		logInElement = new LogInElement();
	}

	@Override
	public boolean execute() {
		driver.findElement(By.id(logInElement.textboxUsername)).sendKeys(username);
		driver.findElement(By.id(logInElement.textboxPassword)).sendKeys(password);
		driver.findElement(By.id(logInElement.buttonLogin)).click();
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
}
