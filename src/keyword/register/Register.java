package keyword.register;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class Register implements Keywords {
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Click Register Tab
			String btnRegisterTab = "//*[@id='menu-vertical']/ul/li[2]/div/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnRegisterTab)));
			driver.findElement(By.xpath(btnRegisterTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Register Tab");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Register Tab");
			return false;
		}
		try{		
			//Select DropDown กลุ่มลูกค้าสินเชื่อ *	
			String inputGroup = "//*[@id='applicationForm']/div[3]/div/div/div[2]/div[2]/input";
			String selectGroup = "workflowCode";
			String groupValue = "CSM";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputGroup)));
			driver.findElement(By.xpath(inputGroup)).clear();
			driver.findElement(By.xpath(inputGroup)).sendKeys("CSM : สินเชื่อรายย่อย");
			executor.executeScript("$('#"+selectGroup+"').val('"+groupValue+"');", driver.findElement(By.id(selectGroup)));
			executor.executeScript("populatePurposeLoanByWorkFlow('"+groupValue+"','',true,false,'purposeLoanCode');getWorkflowGroup('"+groupValue+"');", driver.findElement(By.id(selectGroup)));
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "กลุ่มลูกค้าสินเชื่อ *");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "กลุ่มลูกค้าสินเชื่อ *");
			return false;
		}
		try{
			//Radio Button การตรวจสอบสมาชิกในคำขอ ไม่ตรวจสอบ
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("groupCheck")));
			List<WebElement> radios = driver.findElements(By.name("groupCheck"));
			radios.get(1).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "การตรวจสอบสมาชิกในคำขอ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "การตรวจสอบสมาชิกในคำขอ");
			return false;
		}
		try{
			//Select DropDown ช่องทางการรับข่าวสาร Event	
			String inputNews = "//*[@id='dropdownFixWidth']/input";
			String selectNews = "newsSourceCode";
			String NewsValue = "06";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputNews)));
			driver.findElement(By.xpath(inputNews)).clear();
			driver.findElement(By.xpath(inputNews)).sendKeys("06 : Event");
			executor.executeScript("$('#"+selectNews+"').val('"+NewsValue+"');", driver.findElement(By.id(selectNews)));
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ช่องทางการรับข่าวสาร");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ช่องทางการรับข่าวสาร");
			return false;
		}		
		try{
			//Radio Button สินเชื่อ Fast Track
			List<WebElement> radios = driver.findElements(By.name("fastTrackFlag"));
			radios.get(0).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "FastTrackFlag");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "FastTrackFlag");
			return false;
		}	
		try{
			//Input Text ผู้สร้างใบคำขอสินเชื่อ, หน่วยงานที่ขาย			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("issuerPhoneMobile")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("issuerPhoneOffice")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("issuerPhoneOfficeExt")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("salePhoneMobile")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("salePhoneOffice")));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("salePhoneOfficeExt")));
			driver.findElement(By.name("issuerPhoneMobile")).sendKeys("0812345678");
			driver.findElement(By.name("issuerPhoneOffice")).sendKeys("0212345678");
			driver.findElement(By.name("issuerPhoneOfficeExt")).sendKeys("123");
			driver.findElement(By.name("salePhoneMobile")).sendKeys("0812345678");
			driver.findElement(By.name("salePhoneOffice")).sendKeys("0212345678");
			driver.findElement(By.name("salePhoneOfficeExt")).sendKeys("123");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "PhoneNumber");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "PhoneNumber");
			return false;
		}
		try{
			//Button Click บันทึก
			String buttonSave = "//*[@id='applicationForm']/div[3]/div/div/div[26]/button[1]";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonSave)));
			driver.findElement(By.xpath(buttonSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Save, "บันทึก");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Save, "บันทึก");
			return false;
		}
		String appID = "None";
		try{
			//Get App ID
			String textAppID = "current_appId";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(textAppID)));
			appID = driver.findElement(By.id(textAppID)).getText();
			sendToLogCustom(logexestatus.PASS, logaction.Get, appID);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Get, appID);
			return false;
		}
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
				logoperation.Register, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.Register, 
				logtab.None, 
				logsubtab.None, 
				logelement.None, 
				logaction, 
				str);
	}
}
