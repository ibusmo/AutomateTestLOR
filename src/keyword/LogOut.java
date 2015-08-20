package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogOut implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t -Time out\t -Logout");
			return false;
		}

		sendToLog();
		return true;
	}

	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t -Log out ...");
		return true;
	}

}
