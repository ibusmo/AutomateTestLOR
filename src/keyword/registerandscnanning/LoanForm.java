package keyword.registerandscnanning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import CustomComponent.SelectPopup;
import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class LoanForm implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Click คำขอสินเชื่อ  Tab
			String btnRLoanFormTab = "//*[@id='mainTab']/ul/li[5]/a";
			new WaitFor().xpath(btnRLoanFormTab);
			driver.findElement(By.xpath(btnRLoanFormTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "คำขอสินเชื่อ Tab");
			//Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "OK");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "คำขอสินเชื่อ Tab");
			return false;
		}
		try{
			//Click เพิ่ม Market Code
			String btnAddLoanForm = "//*[@id='tabs-1']/div[1]/div[1]/div/button";
			new WaitFor().xpath(btnAddLoanForm);
			driver.findElement(By.xpath(btnAddLoanForm)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เพิ่ม Market Code");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เพิ่ม Market Code");			
		}
		try{
			//Click เพิ่ม Market Code
			String btnAddLoanForm = "//*[@id='tabs-1']/div[1]/div[1]/div/button";
			new WaitFor().xpath(btnAddLoanForm);
			driver.findElement(By.xpath(btnAddLoanForm)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เพิ่ม Market Code");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เพิ่ม Market Code");			
		}
		String xpath = "//*[@id='addCreditDiv']/table/thead/tr/th";
		WebDriver popup = new SelectPopup().byxpath(xpath);
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
				logoperation.RegisScan, 
				logtab.LoanForm, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.RegisScan, 
				logtab.LoanForm, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				str);
	}
}
