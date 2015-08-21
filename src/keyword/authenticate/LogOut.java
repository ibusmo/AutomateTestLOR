package keyword.authenticate;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;

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
			logCat.sendToLog("[PASS]\t {Logout}\t -Comfirm ...\t -" + javascriptprompt.getText());
			javascriptprompt.accept();
			logCat.sendToLog("[PASS]\t {Logout}\t -Yes\t");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Logout}\t -Time out\t");
			return false;
		}

		sendToLog();
		return true;
	}

	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t {Logout}\t -Already Logout");
		return true;
	}

}
