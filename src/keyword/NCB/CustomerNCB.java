package keyword.NCB;

import java.time.LocalDateTime;

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

public class CustomerNCB implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Click NCB Tab
			String btnNCBSubtab = "//*[@id='subTabs']/ul/li[6]/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnNCBSubtab)));
			driver.findElement(By.xpath(btnNCBSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "NCB Tab");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "NCB Tab");
			return false;
		}
		try{
			//Click Input Date
			String inputDate = "reportedDt"; //id
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputDate)));
			executor.executeScript("$('#"+inputDate+"').val('"+getCurDate()+"');", driver.findElement(By.id(inputDate)));
			//driver.findElement(By.id(inputDate)).clear();
			//driver.findElement(By.id(inputDate)).sendKeys(getCurDate());
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ของข้อมูล * " + getCurDate());
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ของข้อมูล * " + getCurDate());
			return false;
		}
		try{		
			//Select DropDown สถานะฟ้องร้องคดี *
			String inputField = "//*[@id='tabs-2']/div[1]/div/div[6]/input";
			String selectField = "litigationStatusCode";
			String inputValue = "02 : ไม่มี";
			String selectValue = "02";
			selectNCBHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สถานะฟ้องร้องคดี * " + "02 : ไม่มี");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สถานะฟ้องร้องคดี * " + "02 : ไม่มี");
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	private String getCurDate() {
		
		String localTime = ""
				+ String.format("%02d", LocalDateTime.now().getDayOfMonth()) + "/"
				+ String.format("%02d", LocalDateTime.now().getMonthValue()) + "/"
				+ LocalDateTime.now().getYear();
		return localTime;
	}
	
	private void selectNCBHelper(String inputField, String selectField, String inputValue, String selectValue) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputField)));
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		executor.executeScript("$('#"+selectField+"').val('"+selectValue+"');", driver.findElement(By.id(selectField)));
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
				logoperation.NCB, 
				logtab.RegisCust, 
				logsubtab.NCB, 
				logelement.None, 
				logaction, 
				null);
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.NCB, 
				logtab.RegisCust, 
				logsubtab.NCB, 
				logelement.None, 
				logaction, 
				str);
	}
}
