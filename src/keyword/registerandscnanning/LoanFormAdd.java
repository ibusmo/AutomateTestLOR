package keyword.registerandscnanning;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import CustomComponent.SelectDropdown;
import CustomComponent.SelectPopup;
import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class LoanFormAdd implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click คำขอสินเชื่อ Tab
			String btnRLoanFormTab = "//*[@id='mainTab']/ul/li[5]/a";
			new WaitFor().xpath(btnRLoanFormTab);
			driver.findElement(By.xpath(btnRLoanFormTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "คำขอสินเชื่อ Tab");
			// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "OK");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "คำขอสินเชื่อ Tab");
			return false;
		}
		try {
			// Click เพิ่ม Market Code
			String btnAddLoanForm = "//*[@id='tabs-1']/div[1]/div[1]/div/button";
			new WaitFor().xpath(btnAddLoanForm);
			driver.findElement(By.xpath(btnAddLoanForm)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เพิ่ม Market Code");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เพิ่ม Market Code");
			return false;
		}
		try {
			// Click เพิ่ม Market Code
			String btnAddLoanForm = "//*[@id='tabs-1']/div[1]/div[1]/div/button";
			new WaitFor().xpath(btnAddLoanForm);
			driver.findElement(By.xpath(btnAddLoanForm)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เพิ่ม Market Code");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เพิ่ม Market Code");
			return false;
		}
		// Select PopUp page for creditPicklist เพิ่มคำขอสินเชื่อ
		String xpathcreditPicklist = "//*[@id='addCreditDiv']/table/thead/tr/th";
		WebDriver popupcreditPicklist = new SelectPopup().byxpath(xpathcreditPicklist, 2);
		if (popupcreditPicklist == null) {
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
			return false;
		} else {
			if (addLoanFormPopup(popupcreditPicklist)==false)
				return false;
			sendToLogCustom(logexestatus.PASS, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
		}
		// Select PopUp page for Main Page
		String xpathMainPage = "//*[@id='content']/div/div/div[1]";
		WebDriver popupMainPage = new SelectPopup().byxpath(xpathMainPage, 1);
		if (popupMainPage == null) {
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "Browser หลัก");
			return false;
		} else {
			sendToLogCustom(logexestatus.PASS, logaction.Popup, "Browser หลัก");
		}
		sendToLogFinish();
		return true;
	}

	private boolean addLoanFormPopup(WebDriver popup) {
		try {
			// Select DropDown กลุ่มผลิตภัณฑ์ *
			String inputField = "//*[@id='normalDiv']/div[2]/input";
			String inputValue = "LN : Consumer Loans";
			String selectField = "productGroupCode";
			String selectValue = "LN";
			String jEXE = "changeProductGroupCode(null,false)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "กลุ่มผลิตภัณฑ์ * " + "LN : Consumer Loans");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "กลุ่มผลิตภัณฑ์ * " + "LN : Consumer Loans");
			return false;
		}
		try {
			// Select DropDown Product Type *
			String inputField = "//*[@id='showpanel']/div[2]/input";
			String inputValue = "7100 : สินเชื่อที่อยู่อาศัย";
			String selectField = "productTypeCode";
			String selectValue = "7100";
			String jEXE = "changeProductTypeCode(null)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Product Type * " + "7100 : สินเชื่อที่อยู่อาศัย");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Product Type * " + "7100 : สินเชื่อที่อยู่อาศัย");
			return false;
		}
		try {
			// Select DropDown Account Sub Type *
			String inputField = "//*[@id='showpanel']/div[6]/input";
			String inputValue = "10001 : สินเชื่อเคหะ";
			String selectField = "productSubTypeCode";
			String selectValue = "10001";
			String jEXE = "changeProductSubTypeCode(null)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Account Sub Type * " + "10001 : สินเชื่อเคหะ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Account Sub Type * " + "10001 : สินเชื่อเคหะ");
			return false;
		}
		try {
			// Select DropDown Account Sub Type *
			String inputField = "//*[@id='showpanel']/div[8]/input";
			String inputValue = "1007 : ลูกค้าทั่วไป";
			String selectField = "marketCodeCode";
			String selectValue = "1007";
			String jEXE = "changeMarketCodeCode(null)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Market Code * " + "1007 : ลูกค้าทั่วไป");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Market Code * " + "1007 : ลูกค้าทั่วไป");
			return false;
		}
		try {
			// Select DropDown Campaign Code *
			String inputField = "//*[@id='showpanel']/div[11]/input";
			String inputValue = "1 : ดอกเบี้ยลอยตัวอิงวงเงิน";
			String selectField = "campaignCode";
			String selectValue = "1";
			String jEXE = "changeCampaignCode(null)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Campaign Code * " + "1 : ดอกเบี้ยลอยตัวอิงวงเงิน");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Campaign Code * " + "1 : ดอกเบี้ยลอยตัวอิงวงเงิน");
			return false;
		}
		try {
			// Input Text วงเงินกู้ *
			String inputCreditLimit = "creditLimit"; // id
			String creditLimitValue = "1000000";
			driver.findElement(By.id(inputCreditLimit)).clear();
			driver.findElement(By.id(inputCreditLimit)).sendKeys(creditLimitValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "วงเงินกู้ * " + "1,000,000");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "วงเงินกู้ * " + "1,000,000");
			return false;
		}
		try {
			// Input Text ระยะเวลาผ่อนชำระ *
			String inputTerm = "term"; // id
			String termValue = "360";
			driver.findElement(By.id(inputTerm)).clear();
			driver.findElement(By.id(inputTerm)).sendKeys(termValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ระยะเวลาผ่อนชำระ * " + 360);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ระยะเวลาผ่อนชำระ * " + 360);
			return false;
		}
		try {
			// Select DropDown ประเภทหลักประกัน *
			String inputField = "//*[@id='showpanel']/div[17]/input";
			String inputValue = "2 : ที่ดินพร้อมสิ่งปลูกสร้าง";
			String selectField = "collTypeId";
			String selectValue = "2";
			String jEXE = "changeCollTypeId(null)";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown,
					"ประเภทหลักประกัน * " + "2 : ที่ดินพร้อมสิ่งปลูกสร้าง");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,
					"ประเภทหลักประกัน * " + "2 : ที่ดินพร้อมสิ่งปลูกสร้าง");
			return false;
		}
		try {
			// Select DropDown สัดส่วนวงเงินที่ขอกู้ *
			String inputField = "//*[@id='showpanel']/div[19]/input";
			String inputValue = "1 : 0 - 100 %";
			String selectField = "ltvCode";
			String selectValue = "0-100";
			String jEXE = "changeLtvCode()";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สัดส่วนวงเงินที่ขอกู้ * " + "1 : 0 - 100 %");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สัดส่วนวงเงินที่ขอกู้ * " + "1 : 0 - 100 %");
			return false;
		}
		try {
			// Click Save บันทึก
			String btnSave = "//*[@id='normalDiv']/div[4]/button[1]";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึก");
			return false;
		}
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
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.LoanForm, logsubtab.Add, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.LoanForm, logsubtab.Add, logelement.None,
				logaction, str);
	}
}
