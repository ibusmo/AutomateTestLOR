package keyword.register;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Dropdown;
import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class RegisterCSM implements Keywords {
	
	
	String appID = null;
	
	public RegisterCSM(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Click Register Tab
			String btnRegisterTab = "//*[@id='menu-vertical']/ul/li[2]/div/a";
			new WaitFor().xpath(btnRegisterTab);
			driver.findElement(By.xpath(btnRegisterTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Register Tab");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Register Tab");
			return false;
		}
		try{		
			//Select DropDown กลุ่มลูกค้าสินเชื่อ *	
			String inputField = "//*[@id='applicationForm']/div[3]/div/div/div[2]/div[2]/input";
			String inputValue = "CSM : สินเชื่อรายย่อย";
			String selectField = "workflowCode";
			String selectValue = "CSM";
			String jsExe = "populatePurposeLoanByWorkFlow('"+selectValue+"','',true,false,'purposeLoanCode');"
							+"getWorkflowGroup('"+selectValue+"');";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jsExe);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "กลุ่มลูกค้าสินเชื่อ *");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "กลุ่มลูกค้าสินเชื่อ *");
			return false;
		}
		/*
		try{
			//Radio Button การตรวจสอบสมาชิกในคำขอ ไม่ตรวจสอบ
			int radioValue = Integer.parseInt(regData.rdoGroupCheck);
			new WaitFor().name("groupCheck");
			List<WebElement> radios = driver.findElements(By.name("groupCheck"));
			radios.get(radioValue).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "การตรวจสอบสมาชิกในคำขอ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "การตรวจสอบสมาชิกในคำขอ");
			return false;
		}
		try{
			//Select DropDown ช่องทางการรับข่าวสาร Event	
			String inputNewsField = "//*[@id='dropdownFixWidth']/input";
			String inputValue = regData.txtNewsSourceCode;
			String selectNewsField = "newsSourceCode";
			String selectNewsValue = regData.drpNewsSourceCode;
			new Dropdown().id(inputNewsField, inputValue, selectNewsField, selectNewsValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ช่องทางการรับข่าวสาร");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ช่องทางการรับข่าวสาร");
			return false;
		}		
		try{
			//Radio Button สินเชื่อ Fast Track
			int radioValue = Integer.parseInt(regData.rdoFastTrackFlag);
			new WaitFor().name("fastTrackFlag");
			List<WebElement> radios = driver.findElements(By.name("fastTrackFlag"));
			radios.get(radioValue).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "FastTrackFlag");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "FastTrackFlag");
			return false;
		}	
		try{
			//Input Text ผู้สร้างใบคำขอสินเชื่อ, หน่วยงานที่ขาย
			new WaitFor().name("issuerPhoneMobile");
			new WaitFor().name("issuerPhoneOffice");
			new WaitFor().name("issuerPhoneOfficeExt");
			new WaitFor().name("salePhoneMobile");
			new WaitFor().name("salePhoneOffice");
			new WaitFor().name("salePhoneOfficeExt");
			driver.findElement(By.name("issuerPhoneMobile")).sendKeys(regData.txtIssuerPhoneMobile);
			driver.findElement(By.name("issuerPhoneOffice")).sendKeys(regData.txtIssuerPhoneOffice);
			driver.findElement(By.name("issuerPhoneOfficeExt")).sendKeys(regData.txtIssuerPhoneOfficeExt);
			driver.findElement(By.name("salePhoneMobile")).sendKeys(regData.txtSalePhoneMobile);
			driver.findElement(By.name("salePhoneOffice")).sendKeys(regData.txtSalePhoneOffice);
			driver.findElement(By.name("salePhoneOfficeExt")).sendKeys(regData.txtSalePhoneOfficeExt);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "PhoneNumber");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "PhoneNumber");
			return false;
		}*/
		try{
			//Button Click บันทึก
			String buttonSave = "//*[@id='applicationForm']/div[3]/div/div/div[26]/button[1]";
			new WaitFor().xpath(buttonSave);
			driver.findElement(By.xpath(buttonSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Save, "บันทึก");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Save, "บันทึก");
			return false;
		}
		appID = "None";
		try{
			//Get AppID
			String textAppID = "current_appId";
			new WaitFor().id(textAppID);
			appID = driver.findElement(By.id(textAppID)).getText();
			sendToLogCustom(logexestatus.PASS, logaction.Get, appID);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Get, appID);
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	public String getAppID() {
		return appID;
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
