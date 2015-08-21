package keyword.register;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;

public class Register implements Keywords {
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		try{
			//Click Register Tab
			String btnRegisterTab = "//*[@id='menu-vertical']/ul/li[2]/div/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnRegisterTab)));
			driver.findElement(By.xpath(btnRegisterTab)).click();
			logCat.sendToLog("[PASS]\t {Register}\t -Click\t\t -Register Tab");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Click\t\t -Register Tab");
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
			logCat.sendToLog("[PASS]\t {Register}\t -Dropdown\t -WorkflowCode\t\t -กลุ่มลูกค้าสินเชื่อ *");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Dropdown\t -WorkflowCode\t\t -กลุ่มลูกค้าสินเชื่อ *");
			return false;
		}
		try{
			//Radio Button การตรวจสอบสมาชิกในคำขอ ไม่ตรวจสอบ
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("groupCheck")));
			List<WebElement> radios = driver.findElements(By.name("groupCheck"));
			radios.get(1).click();
			logCat.sendToLog("[PASS]\t {Register}\t -Radio\t\t -GroupCheck\t\t -การตรวจสอบสมาชิกในคำขอ");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Radio\t\t -GroupCheck\t\t -การตรวจสอบสมาชิกในคำขอ");
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
			logCat.sendToLog("[PASS]\t {Register}\t -Dropdown\t -NewsSourceCode\t -ช่องทางการรับข่าวสาร");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Dropdown\t -NewsSourceCode\t -ช่องทางการรับข่าวสาร");
			return false;
		}		
		try{
			//Radio Button สินเชื่อ Fast Track
			List<WebElement> radios = driver.findElements(By.name("fastTrackFlag"));
			radios.get(0).click();
			logCat.sendToLog("[PASS]\t {Register}\t -Radio\t\t -FastTrackFlag");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Radio\t\t -FastTrackFlag");
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
			logCat.sendToLog("[PASS]\t {Register}\t -Input Text\t -PhoneNumber");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Input Text\t -PhoneNumber");
			return false;
		}
		try{
			//Button Click บันทึก
			String buttonSave = "//*[@id='applicationForm']/div[3]/div/div/div[26]/button[1]";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonSave)));
			driver.findElement(By.xpath(buttonSave)).click();
			logCat.sendToLog("[PASS]\t {Register}\t -Button click\t -Save\t\t\t -บันทึก");
		}catch(TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Button click\t -Save\t\t\t -บันทึก");
			return false;
		}
		String appID = "None";
		try{
			//Get App ID
			String textAppID = "current_appId";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(textAppID)));
			appID = driver.findElement(By.id(textAppID)).getText();
			logCat.sendToLog("[PASS]\t {Register}\t -Get App ID\t : " + appID);
		}catch(TimeoutException e){
			logCat.sendToLog("[FAIL]\t {Register}\t -Get App ID\t : " + appID);
			return false;
		}
		sendToLog();
		return true;
	}
	
	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t {Register}\t -Already Register");
		return false;
	}
}
