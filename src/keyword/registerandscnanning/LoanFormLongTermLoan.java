package keyword.registerandscnanning;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CustomComponent.SelectDropdown;
import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class LoanFormLongTermLoan implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Select DropDown :Payment Calculation Method * =15 : P&I
			String inputField = "//*[@id='tabs-2']/div[4]/div[8]/input";
			String inputValue = "15 : P&I";
			String selectField = "paymentCalculationMethodCode";
			String selectValue = "15";
			String jEXE = "changePCM('"+selectValue+"');";
			new SelectDropdown().idNoText(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Payment Calculation Method * " + "15 : P&I");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Payment Calculation Method * " + "15 : P&I");
			return false;
		}
		try {
			// Input Text :Payment Frequency * =1
			String inputPayFreq = "paymentFrequencyTerm"; //name
			String payFreqValue = "1";
			driver.findElement(By.name(inputPayFreq)).clear();
			driver.findElement(By.name(inputPayFreq)).sendKeys(payFreqValue);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Payment Frequency * " + "1");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Payment Frequency * " + "1");
			return false;
		}
		try {
			// Select DropDown :Payment Frequency * =M
			String inputField = "//*[@id='tabs-2']/div[4]/div[12]/div/input";
			String inputValue = "M : เดือน";
			String selectField = "paymentFrequencyTermUnitCode"; //name
			String selectValue = "M";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "Payment Frequency * " + "M : เดือน");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "Payment Frequency * " + "M : เดือน");
			return false;
		}
		try {
			// Select DropDown :กรณีวันที่ชำระตรงกับวันหยุด * =N : Next Business Date
			String inputField = "//*[@id='tabs-2']/div[4]/div[14]/input";
			String inputValue = "N : Next Business Date";
			String selectField = "paymentOnHolidayCaseCode"; //name
			String selectValue = "N";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "กรณีวันที่ชำระตรงกับวันหยุด * " + "N : Next Business Date");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "กรณีวันที่ชำระตรงกับวันหยุด * " + "N : Next Business Date");
			return false;
		}
		try {
			// Select DropDown :ชำระทุกวันที่ * =E : ชำระทุกสิ้นเดือน
			String inputField = "//*[@id='tabs-2']/div[4]/div[16]/input";
			String inputValue = "E : ชำระทุกสิ้นเดือน";
			String selectField = "paymentDateCode"; //name
			String selectValue = "E";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ชำระทุกวันที่ * " + "E : ชำระทุกสิ้นเดือน");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ชำระทุกวันที่ * " + "E : ชำระทุกสิ้นเดือน");
			return false;
		}
		try {
			// Click :คำนวณ First Payment Date
			String btnCalculate = "//*[@id='tabs-2']/div[4]/div[20]/button";
			new WaitFor().xpath(btnCalculate);
			driver.findElement(By.xpath(btnCalculate)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "คำนวณ");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "คำนวณ");
			return false;
		}
		try{
			//Radio Button :ประเภทเงินงวด * =เงินงวดเท่ากันทุกงวด
			//installmentTypeSingleValue	เงินงวดเท่ากันทุกงวด
			//installmentTypeTierValue		เงินงวดแบบขั้นบันได
			String radioIST = "installmentTypeSingleValue";		
			new WaitFor().id(radioIST);	
			driver.findElement(By.id(radioIST)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, ":ประเภทเงินงวด * =เงินงวดเท่ากันทุกงวด");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, ":ประเภทเงินงวด * =เงินงวดเท่ากันทุกงวด");
			return false;
		}	
		try {
			// Click :คำนวณเงินงวด
			String btnCalculate = "//*[@id='tabs-2']/div[5]/div[1]/button";
			new WaitFor().xpath(btnCalculate);
			driver.findElement(By.xpath(btnCalculate)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "คำนวณงวด");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "คำนวณงวด");
			return false;
		}		
		try {
			// Select DropDown :Arrangement Purpose Code * =012001 : เพื่อการอุปโภคบริโภคส่วนบุคคล (เฉพาะบุคคลธรรมดา)
			String inputField = "//*[@id='tabs-2']/div[9]/div[10]/input";
			String inputValue = "012001 : เพื่อการอุปโภคบริโภคส่วนบุคคล (เฉพาะบุคคลธรรมดา)";
			String selectField = "purposeArrangementId"; //id
			String selectValue = "24";
			String jEXE = "changePurposeArrangement("+selectField+");"; //Set this
			new SelectDropdown().idNoText(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "012001 : เพื่อการอุปโภคบริโภคส่วนบุคคล (เฉพาะบุคคลธรรมดา)");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "012001 : เพื่อการอุปโภคบริโภคส่วนบุคคล (เฉพาะบุคคลธรรมดา)");
			return false;
		}
		try {
			// Select DropDown :Personal Consumption * =11001 : การซื้อที่ดินเปล่า
			String inputField = "//*[@id='tabs-2']/div[9]/div[13]/input";
			String inputValue = "11001 : การซื้อที่ดินเปล่า";
			String selectField = "personalConsumptionId"; //id
			String selectValue = "53";
			new SelectDropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "11001 : การซื้อที่ดินเปล่า");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "11001 : การซื้อที่ดินเปล่า");
			return false;
		}
		try {
			// Select DropDown :Commit Line * =0 : Not Commit ธนาคารสามารถยกเลิกวงเงินเมื่อใดก็ได้
			String inputField = "//*[@id='tabs-2']/div[9]/div[21]/input";
			String inputValue = "0 : Not Commit ธนาคารสามารถยกเลิกวงเงินเมื่อใดก็ได้";
			String selectField = "commitLineCode"; //name
			String selectValue = "0";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "0 : Not Commit ธนาคารสามารถยกเลิกวงเงินเมื่อใดก็ได้");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "0 : Not Commit ธนาคารสามารถยกเลิกวงเงินเมื่อใดก็ได้");
			return false;
		}
		try {
			// Select DropDown :Specialised Lending * =0 : 05 : ไม่เข้าเงื่อนไข
			String inputField = "//*[@id='tabs-2']/div[9]/div[29]/input";
			String inputValue = "05 : ไม่เข้าเงื่อนไข";
			String selectField = "specialisedLendingCode"; //name
			String selectValue = "05";
			new SelectDropdown().name(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "05 : ไม่เข้าเงื่อนไข");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "05 : ไม่เข้าเงื่อนไข");
			return false;
		}
		try {
			// Select DropDown :สถานะการเรียกเก็บ * =0 : ชำระด้วยตนเอง
			String inputField = "//*[@id='tabs-2']/div[10]/div[3]/input";
			String inputValue = "0 : ชำระด้วยตนเอง";
			String selectField = "paymentMethodCode"; //id
			String selectValue = "0";
			new SelectDropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "0 : ชำระด้วยตนเอง");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "0 : ชำระด้วยตนเอง");
			return false;
		}
		try{
			//Button Click บันทึก
			String buttonSave = "btnSave";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(buttonSave)));
			driver.findElement(By.id(buttonSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Save, "บันทึก");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Save, "บันทึก");
			return false;
		}
		sendToLogFinish();
		return false;
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
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.LoanForm, logsubtab.LongTermLoan, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.LoanForm, logsubtab.LongTermLoan, logelement.None,
				logaction, str);
	}
}
