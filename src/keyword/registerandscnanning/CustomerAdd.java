package keyword.registerandscnanning;

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

public class CustomerAdd implements Keywords {

	private String CIFNo;

	public CustomerAdd() {
		// TODO Auto-generated constructor stub
	}

	public CustomerAdd(String CIFNo) {
		this.CIFNo = CIFNo;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Add Customer
			String btnAddCustomer = "//div[@id='tabs-1']/div/div/div[2]/button";
			new WaitFor().xpath(btnAddCustomer);
			driver.findElement(By.xpath(btnAddCustomer)).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.RegisScan, logtab.RegisCust, logsubtab.None,
					logelement.None, logaction.Click, "เพิ่มลูกค้า ");
		} catch (TimeoutException e) {
			logCat.sendToLog(logexestatus.FAIL, logoperation.RegisScan, logtab.RegisCust, logsubtab.None,
					logelement.None, logaction.Click, "เพิ่มลูกค้า ");
			return false;
		}
		try {
			// Select PopUp page for เพิ่มผู้ขอสินเชื่อ
			String xpathPopup = "//html/body/form/table/thead/tr[1]/th";
			WebDriver popup = new SelectPopup().byxpath(xpathPopup, 2);
			if (popup == null) {
				sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มผู้ขอสินเชื่อ");
				return false;
			} else {
				/*
				if (addLoanFormPopup(popup)==false)
					return false;
				sendToLogCustom(logexestatus.PASS, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
				*/
			}
			System.out.println(driver.getCurrentUrl());
			String rdoSearchCustomer = "addClientFlag";
			new WaitFor().name(rdoSearchCustomer);
			driver.findElement(By.name(rdoSearchCustomer)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ค้นหาในระบบ" + "ค้นหาในระบบ");
		} catch (TimeoutException e) {
			logCat.sendToLog(logexestatus.FAIL, logoperation.RegisScan, logtab.RegisCust, logsubtab.None,
					logelement.None, logaction.Click, "เพิ่มลูกค้า ");
			return false;
		}
		try {
			String rdoSearchCustomerByCIF = "//div[@id='searchCriteria']/div[33]/input[@name='searchType']";
			new WaitFor().xpath(rdoSearchCustomerByCIF);
			driver.findElement(By.xpath(rdoSearchCustomerByCIF)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "ค้นหาโดย CIF No." + "ค้นหาโดย CIF No.");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "CIF No.");
			return false;
		}
		try {
			String inputCIFNo = "filterCIFNo";
			new WaitFor().id(inputCIFNo);
			driver.findElement(By.id(inputCIFNo)).clear();
			driver.findElement(By.id(inputCIFNo)).sendKeys(CIFNo);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "พิมพ์  CIF No." + "พิมพ์  CIF No.");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "พิมพ์  CIF No.");
			return false;
		}
		try {
			String btnSearch = "btnSearch";
			new WaitFor().name(btnSearch);
			driver.findElement(By.name(btnSearch)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "กดปุ่นค้นหา" + "กดปุ่มค้นหา");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Search");
			return false;
		}
		try {
			// Select DropDown ประเภทผู้ขอสินเชื่อ
			String inputField = "//*[@id='dropdownFixWidth']/input";
			String inputValue = "ผู้ขอสินเชื่อหลัก";
			String selectField = "searchedCustType";
			String selectValue = "B";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().id(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทผู้ขอสินเชื่อ " + "ผู้ขอสินเชื่อหลัก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ประเภทผู้ขอสินเชื่อ " + "ผู้ขอสินเชื่อหลัก");
			return false;
		}
		try {
			String rdoSelectCustomer = "//div[@id='table_result_search']/table[1]/tbody[1]/tr[2]/td[1]/input";
			new WaitFor().xpath(rdoSelectCustomer);
			driver.findElement(By.xpath(rdoSelectCustomer)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "เลือกผู้กู้" + "เลือกผู้กู้");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "เลือกผู้กู้" + "เลือกผู้กู้");
			return false;
		}
		try {
			String BtnSave = "//div[@id='table_search']/div[4]/button[1]";
			new WaitFor().xpath(BtnSave);
			driver.findElement(By.xpath(BtnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึก" + "บันทึก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึก" + "บันทึก");
			return false;
		}
		try {
			String BtnSaveConfirm = "//div[@id='dialog-modal']/table[3]/tbody[1]/tr[1]/th[1]/button[1]";
			new WaitFor().xpath(BtnSaveConfirm);
			driver.findElement(By.xpath(BtnSaveConfirm)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ยืนยันบันทึก" + "ยืนยันบันทึก");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ยืนยันบันทึก" + "ยืนยันบันทึก");
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
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, str);
	}

}
