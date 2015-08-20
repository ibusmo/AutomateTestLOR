package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Register implements Keywords {

	String btnRegisterTab = "//*[@id='menu-vertical']/ul/li[2]/div/a";
	String ddwWorkflowCode = "workflowCode";
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnRegisterTab)));
			driver.findElement(By.xpath(btnRegisterTab)).click();
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t -Time out\t -Register Tab");
			return false;
		}

		try{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("workflowCode")));
			Select dropdown = new Select(driver.findElement(By.id("workflowCode")));
			dropdown.selectByValue("CSM");			
			/*
			driver.findElement(By.xpath("//*[@id='applicationForm']/div[3]/div/div/div[2]/div[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id='applicationForm']/div[3]/div/div/div[2]/div[2]/input")).sendKeys("CSM : สินเชื่อรายย่อย");
			driver.findElement(By.xpath("//*[@id='applicationForm']/div[3]/div/div/div[2]/div[2]/input")).click();
			*/
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t -Time out\t -WorkflowCode");
			return false;
		}
		sendToLog();
		return true;
	}
	
	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t -XXX\t -Register Tab");
		return false;
	}
}
