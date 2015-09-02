package keyword.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.DatePicker;
import customcomponent.SelectDropdown;
import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CMSValue implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			// Click Subtab มูลค่าหลักประกัน
			String linkSubtab = "มูลค่าหลักประกัน";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab มูลค่าหลักประกัน");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab มูลค่าหลักประกัน");
			return false;
		}
		try {
			// Click Input Date //Date Picker วันที่ขอสินเชื่อ *
			String inputDateField = "firstCreateApprDt"; // name
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getCurDate();
			datePicker.nameSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ขอสินเชื่อ * " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ขอสินเชื่อ * ");
			return false;
		}
		try {
			// Click Input Date //Date Picker วันที่ส่งประเมินราคา
			String inputDateField = "appraisalDt"; // name
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getCurDate();
			datePicker.nameSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ส่งประเมินราคา " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ส่งประเมินราคา ");
			return false;
		}
		try {
			// Input Text ราคาประเมินที่ดินครั้งแรก *
			String firstApprField = "firstApprVal";
			String firstApprValue = "800000";
			new WaitFor().id(firstApprField);
			driver.findElement(By.id(firstApprField)).sendKeys(firstApprValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ราคาประเมินที่ดินครั้งแรก * " + firstApprValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ราคาประเมินที่ดินครั้งแรก * ");
			return false;
		}
		try {
			// Input Text ราคาประเมินสิ่งปลูกสร้างครั้งแรก *
			String firstApprBldField = "firstApprBldVal";
			String firstApprBldValue = "800000";
			new WaitFor().id(firstApprBldField);
			driver.findElement(By.id(firstApprBldField)).sendKeys(firstApprBldValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ราคาประเมินสิ่งปลูกสร้างครั้งแรก * " + firstApprBldValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ราคาประเมินสิ่งปลูกสร้างครั้งแรก * ");
			return false;
		}
		try {
			// Input Text ราคาประเมินรวมครั้งแรก *
			String firstApprTotalField = "firstApprBldVal";
			String firstApprTotalValue = "1600000";
			new WaitFor().id(firstApprTotalField);
			driver.findElement(By.id(firstApprTotalField)).sendKeys(firstApprTotalValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ราคาประเมินรวมครั้งแรก * " + firstApprTotalValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ราคาประเมินรวมครั้งแรก * ");
			return false;
		}
		try {
			// Click Input Date //Date Picker วันที่ประเมินราคาครั้งแรก *
			String inputDateField = "firstApprDt"; // name
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getPrevDate();
			datePicker.nameSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ประเมินราคาครั้งแรก * " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ประเมินราคาครั้งแรก * ");
			return false;
		}
		try {
			// Click Input Date //Date Picker วันที่ประเมินราคา *
			String inputDateField = "approveDt"; // name
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getCurDate();
			datePicker.nameSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ประเมินราคา * " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ประเมินราคา * ");
			return false;
		}
		try {
			// Input Text ราคาตามสัญญาจะซื้อจะขาย *
			String contractPriceField = "contractPrice";
			String contractPriceValue = "1600000";
			new WaitFor().id(contractPriceField);
			driver.findElement(By.id(contractPriceField)).sendKeys(contractPriceValue);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "ราคาตามสัญญาจะซื้อจะขาย * " + contractPriceValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "ราคาตามสัญญาจะซื้อจะขาย * ");
			return false;
		}
		try {
			// Click Input Date //Date Picker วันที่ตามสัญญาจะซื้อจะขาย *
			String inputDateField = "contractPriceDt"; // name
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getCurDate();
			datePicker.nameSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ตามสัญญาจะซื้อจะขาย * " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ตามสัญญาจะซื้อจะขาย * ");
			return false;
		}
		try {
			// Input Text ราคาประเมินที่ดิน *
			String landLndField = "landLndVal";
			String landLndValue = "800000";
			new WaitFor().id(landLndField);
			driver.findElement(By.id(landLndField)).sendKeys(landLndValue);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "ราคาประเมินที่ดิน * " + landLndValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "ราคาประเมินที่ดิน * ");
			return false;
		}
		try {
			// Input Text ราคาประเมิน *
			String appraisalField = "appraisalVal";
			String appraisalValue = "1600000";
			new WaitFor().id(appraisalField);
			driver.findElement(By.id(appraisalField)).sendKeys(appraisalValue);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "ราคาประเมิน * " + appraisalValue);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "ราคาประเมิน * ");
			return false;
		}
		try{
			// Select Dropdown วิธีการประเมินราคา *
			String inputField = "//*[@id='content']/div/form/div/table/tbody/tr[18]/td[2]/input[1]";
			String inputValue = "1 : ตีราคาโดยใช้ราคาตลาด";
			String selectField = "appraisalType";
			String selectValue = "1";
			String jsExe = "disableAllAppraisalField('"+selectValue+"');";
			new SelectDropdown().id(inputField, inputValue, selectField, selectValue, jsExe);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "วิธีการประเมินราคา * " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "วิธีการประเมินราคา * ");
			return false;
		}
		try{
			// Select Dropdown การจัดเกรดทรัพย์/สภาพคล่อง *
			String inputField = "//*[@id='content']/div/form/div/table/tbody/tr[19]/td[2]/input[1]";
			String inputValue = "A : สภาพคล่องสูง";
			String selectField = "realLiquidityCd";
			String selectValue = "A";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "การจัดเกรดทรัพย์/สภาพคล่อง * " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "การจัดเกรดทรัพย์/สภาพคล่อง * ");
			return false;
		}
		try{
			// Click SAVE
			String btnSave = "//*[@id='content']/div/form/div/table/tbody/tr[21]/td/input";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click SAVE ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click SAVE ");
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.Value, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.Value, logelement.None,
				logaction, str);
	}

}
