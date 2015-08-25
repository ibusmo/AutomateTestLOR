package keyword.registerandscnanning;

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

public class TabPolicy implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		try{
			//Click Policy Tab เกณฑ์นโบยนบาย
			String btnPolicyTab = "//*[@id='mainTab']/ul/li[11]/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnPolicyTab)));
			driver.findElement(By.xpath(btnPolicyTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เกณฑ์นโบยนบาย");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เกณฑ์นโบยนบาย");
			return false;
		}
		try{		
			//Select DropDown สินเชื่อที่ขอขัดต่อกฎหมายหรือไม่ *
			String inputField = "//*[@id='bankPolicyActionForm']/div[2]/div[2]/input";
			String selectField = "loanContraryToLawFlag";
			String inputValue = "ไม่ขัดต่อนโยบายหลักและนโยบายรอง";
			String selectValue = "1";
			selectPolicyHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อกฎหมายหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อกฎหมายหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
			return false;
		}
		try{		
			//Select DropDown หลักประกันที่ยี่นขัดต่อด้านหลักประกันของธนาคารที่ไม่สามารถเป็นหลักประกันหรือไม่ *
			String inputField = "//*[@id='bankPolicyActionForm']/div[2]/div[4]/input";
			String selectField = "collateralContraryToBankPolicyFlag";
			String inputValue = "ไม่ขัดต่อนโยบายหลักและนโยบายรอง";
			String selectValue = "1";
			selectPolicyHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "หลักประกันที่ยี่นขัดต่อด้านหลักประกันของธนาคารที่ไม่สามารถเป็นหลักประกันหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "หลักประกันที่ยี่นขัดต่อด้านหลักประกันของธนาคารที่ไม่สามารถเป็นหลักประกันหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
			return false;
		}
		try{		
			//Select DropDown สินเชื่อที่ขอขัดต่อนโยบายด้านการให้สินเชื่อของธนาคารหรือไม่ *
			String inputField = "//*[@id='bankPolicyActionForm']/div[2]/div[6]/input";
			String selectField = "loanContraryToBankPolicyFlag";
			String inputValue = "ไม่ขัดต่อนโยบายหลักและนโยบายรอง";
			String selectValue = "1";
			selectPolicyHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อนโยบายด้านการให้สินเชื่อของธนาคารหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อนโยบายด้านการให้สินเชื่อของธนาคารหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
			return false;
		}
		try{		
			//Select DropDown สินเชื่อที่ขอขัดต่อมาตรฐานการอำนวยสินเชื่อหรือไม่ *
			String inputField = "//*[@id='bankPolicyActionForm']/div[2]/div[8]/input";
			String selectField = "loanContraryToStandardApprovalFlag";
			String inputValue = "ไม่ขัดต่อนโยบายหลักและนโยบายรอง";
			String selectValue = "1";
			selectPolicyHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อมาตรฐานการอำนวยสินเชื่อหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สินเชื่อที่ขอขัดต่อมาตรฐานการอำนวยสินเชื่อหรือไม่ * " + "ไม่ขัดต่อนโยบายหลักและนโยบายรอง");
			return false;
		}
		try{		
			//Select DropDown ธนาคารมีข้อมูลเพียงพอในการรู้จักลูกค้า (KYC) *
			String inputField = "//*[@id='bankPolicyActionForm']/div[2]/div[10]/input";
			String selectField = "kycFlag";
			String inputValue = "มี";
			String selectValue = "Y";
			selectPolicyHelper(inputField, selectField, inputValue, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ธนาคารมีข้อมูลเพียงพอในการรู้จักลูกค้า (KYC) * " + "มี");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ธนาคารมีข้อมูลเพียงพอในการรู้จักลูกค้า (KYC) * " + "มี");
			return false;
		}
		return true;
	}
	
	private void selectPolicyHelper(String inputField, String selectField, String inputValue, String selectValue) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputField)));
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		executor.executeScript("$('#"+selectField+"').val('"+selectValue+"');", driver.findElement(By.id(selectField)));
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, 
				logoperation.RegisScan, 
				logtab.policy, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}
	
	@Override
	public void sendToLogStart() {
	}

	@Override
	public void sendToLogFinish() {
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.RegisScan, 
				logtab.policy, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				str);
	}	
}
