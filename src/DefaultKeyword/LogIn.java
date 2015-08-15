package DefaultKeyword;

import org.openqa.selenium.By;

public class LogIn implements Keywords {

	private String username;
	private String password;
	
	public LogIn(){
		
	}
	
	public LogIn(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean execute() {
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).click();
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