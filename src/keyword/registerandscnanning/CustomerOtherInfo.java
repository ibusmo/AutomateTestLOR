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

import keyword.Keywords;

public class CustomerOtherInfo  implements Keywords{
	
	
	private String PeriodYear;
	private String NumberOfChild;
	private String CurAddrYear;
	private String WorkCurYear;
	private String WorkAllYear;
	
	public CustomerOtherInfo() {
		// TODO Auto-generated constructor stub
	}

	public CustomerOtherInfo(String PeriodYear, String NumberOfChild, String CurAddrYear, String WorkCurYear, String WorkAllYear) {
		this.PeriodYear = PeriodYear;
		this.NumberOfChild = NumberOfChild;
		this.CurAddrYear = CurAddrYear;
		this.WorkCurYear = WorkCurYear;
		this.WorkAllYear = WorkAllYear;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	public boolean execute() {
		sendToLogStart();
		try{
			String SubOtherInfo = "//div[@id='subTabs']/ul[1]/li[2]";
			new WaitFor().xpath(SubOtherInfo);
			driver.findElement(By.xpath(SubOtherInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab ข้อมูลอื่นๆ" + "Click tab ข้อมูลอื่นๆ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab ข้อมูลอื่นๆ" +  "Click tab ข้อมูลอื่นๆ");
		}
		
		
		try { 
			String inputCustPeriod = "custPeriodYear";
			new WaitFor().id(inputCustPeriod);
			driver.findElement(By.id(inputCustPeriod)).sendKeys(PeriodYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ระยะเวลาในการเป็นลูกค้า" + "ระยะเวลาในการเป็นลูกค้า");

		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ระยะเวลาในการเป็นลูกค้า" + "ระยะเวลาในการเป็นลูกค้า");

		}
		
		
		try{
			String inputField = "//*[@id='incomeSourceCode']/input";
			String inputValue = "1 : เงินเดือน";
			String selectField = "incomeSourceCode";
			String selectValue = "1";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "แหล่งที่มาของรายได้ " + "แหล่งที่มาของรายได้ ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "แหล่งที่มาของรายได้ " + "แหล่งที่มาของรายได้ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "แหล่งที่มาของรายได้ " + "แหล่งที่มาของรายได้ ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='coborrowerRelatedTypeCode']/input";
			String inputValue = "01 : ไม่มีผู้กู้ร่วม/ไม่มีผู้ค้ำประกัน";
			String selectField = "coborrowerRelatedTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้ " + "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้ ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้ " + "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้ " + "ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้ ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='garantorRelatedTypeCode']/input";
			String inputValue = "01 : ไม่มีผู้กู้ร่วม/ไม่มีผู้ค้ำประกัน";
			String selectField = "garantorRelatedTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก  " + "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก " + "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก " + "ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก ");
			return false;
		}
		
		
		try{
			String inputChildAll = "childCountAll";
			new WaitFor().id(inputChildAll);
			driver.findElement(By.id(inputChildAll)).sendKeys(NumberOfChild);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "จำนวนบุตรทังหมด " + "จำนวนบุตรทังหมด  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "จำนวนบุตรทังหมด  " + "จำนวนบุตรทังหมด  ");
			return false;
		}
		
		
		try{
			String inputCurAddrYear = "curAddrYear";
			new WaitFor().id(inputCurAddrYear);
			driver.findElement(By.id(inputCurAddrYear)).sendKeys(CurAddrYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน  " + "ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน   " + "ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน   ");
			return false;
		}
		
		
		
		
		try{
			String inputField = "//*[@id='houseTypeCode']/input";
			String inputValue = "01 : บ้านเดี่ยว";
			String selectField = "houseTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทที่พักอาศัย   " + "ประเภทที่พักอาศัย  ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ประเภทที่พักอาศัย  " + "ประเภทที่พักอาศัย  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ประเภทที่พักอาศัย  " + "ประเภทที่พักอาศัย ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='houseOwnershipCode']/input";
			String inputValue = "01 : เป็นของตนเอง / คู่สมรส - ปลอดภาระผูกพัน";
			String selectField = "houseOwnershipCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "สถานะที่พักอาศัย  " + "สถานะที่พักอาศัย   ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "สถานะที่พักอาศัย   " + "สถานะที่พักอาศัย   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "สถานะที่พักอาศัย   " + "สถานะที่พักอาศัย  ");
			return false;
		}
		
		try{
			String inputWorkCurYear = "workCurExpYear";	
			new WaitFor().id(inputWorkCurYear);
			driver.findElement(By.id(inputWorkCurYear)).sendKeys(WorkCurYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "อายุงานปัจจุบัน    " + "อายุงานปัจจุบัน   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "อายุงานปัจจุบัน    " + "อายุงานปัจจุบัน   ");
		}
		
		
		try{
			String inputworkAllExpYear = "workAllExpYear";	
			new WaitFor().id(inputworkAllExpYear);
			driver.findElement(By.id(inputworkAllExpYear)).sendKeys(WorkAllYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "อายุงานรวม  " + "อายุงานรวม ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "อายุงานรวม  " + "อายุงานรวม ");
		}
		
		
		try{
			String btnSave = "btnSave";
			new WaitFor().id(btnSave);
			driver.findElement(By.id(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Save  " + "Save ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Save  " + "Save ");
		}
		
		
		
		try{
			String inputExpenseConsumer = "expenseConsumer";
			new WaitFor().id(inputExpenseConsumer);
			driver.findElement(By.id(inputExpenseConsumer)).sendKeys(ExpenseConsumer);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าใช้จ่ายอุปโภคบริโภค " + "ค่าใช้จ่ายอุปโภคบริโภค ");
			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าใช้จ่ายอุปโภคบริโภค " + "ค่าใช้จ่ายอุปโภคบริโภค ");
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
