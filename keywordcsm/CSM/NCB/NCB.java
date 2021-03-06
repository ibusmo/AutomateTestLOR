package CSM.NCB;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.DatePicker;
import customcomponent.Dropdown;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class NCB implements KeywordsCSM {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click NCB Tab
			String btnNCBSubtab = "//*[@id='subTabs']/ul/li[6]/a";
			new WaitFor().xpath(btnNCBSubtab);
			driver.findElement(By.xpath(btnNCBSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "NCB Tab");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "NCB Tab");
			return false;
		}
		try {
			// Click Input Date //Date Picker
			String inputDateField = "reportedDt"; // id
			DatePicker datePicker = new DatePicker();
			String dateStr = datePicker.getCurDate();
			datePicker.idSetDate(inputDateField, dateStr);
			sendToLogCustom(logexestatus.PASS, logaction.Date, "วันที่ของข้อมูล * " + dateStr);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Date, "วันที่ของข้อมูล * ");
			return false;
		}
		try {
			// Select DropDown สถานะฟ้องร้องคดี *
			String inputField = "//*[@id='tabs-2']/div[1]/div/div[6]/input";
			String inputValue = "02 : ไม่มี";
			String selectField = "litigationStatusCode";
			String selectValue = "02";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สถานะฟ้องร้องคดี * " + "02 : ไม่มี");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "สถานะฟ้องร้องคดี * " + "02 : ไม่มี");
			return false;
		}
		try {
			// Select DropDown สถานะฟ้องร้องคดี *
			ArrayList<String> inputText = new ArrayList<String>();
			ArrayList<String> showText = new ArrayList<String>();
			inputText.add("reportedCountAccount");			showText.add("จำนวนบัญชี");
			inputText.add("reportedCountCreditCard");		showText.add("จำนวนบัตรเครดิตที่ถืออยู่");
			inputText.add("reportedLimitAmount");			showText.add("วงเงินรวม");
			inputText.add("reportedOutStanding");			showText.add("ยอดคงค้างรวม");
			inputText.add("reportedOutStandingOverdue");	showText.add("ยอดคงค้างที่พ้นกำหนดชำระรวม");
			inputText.add("reportedDebtHome");				showText.add("ภาระหนี้คงเหลือของที่พักอาศัย(กรณีเป็นเจ้าของ)");
			inputText.add("reportedInstallment");			showText.add("หนี้เดิมผ่อนชำระต่อเดือนที่รายงานต่อ NCB (ไม่รวมหนี้เดิมของ GSB)");
			inputText.add("reportedCreditCardMinPaymant");	showText.add("ยอดชำระขั้นต่ำของบัตรเครดิต");
			inputText.add("reportedOverdraftInterest");		showText.add("ดอกเบี้ยของวงเงินเบิกเกินบัญชี");
			
			for (int i=0; i<inputText.size(); i++) {
				new WaitFor().id(inputText.get(i));
				driver.findElement(By.id(inputText.get(i))).clear();
				driver.findElement(By.id(inputText.get(i))).sendKeys("0");
				sendToLogCustom(logexestatus.PASS, logaction.Text, showText.get(i));
			}
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Text Field Problem");
			return false;
		}
		try{
			//Button Click บันทึก
			String btnSave = "btnSave";
			new WaitFor().id(btnSave);
			driver.findElement(By.id(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Save, "บันทึก");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Save, "บันทึก");
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
				logoperation.NCB, 
				logtab.RegCustomer, 
				logsubtab.NCB, 
				logelement.None, 
				logaction,
				null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, 
				logoperation.NCB, 
				logtab.RegCustomer, 
				logsubtab.NCB, 
				logelement.None, 
				logaction,
				str);
	}
}
