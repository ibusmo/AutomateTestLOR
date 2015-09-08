package keyword.registerandscnanning;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CustomerIncome implements Keywords{
	
	private String workExpYear;
	private String salary;
	private String tax;
	private String socialSecurity;
	private String srovidentFund;
	private String cooperativeShare;
	private String chorOrSor;
	
	public CustomerIncome(){
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		workExpYear = "2";
		salary = "20000";
		tax = "1000";
		socialSecurity = "1000";
		srovidentFund = "1000";
		cooperativeShare = "1000";
		chorOrSor = "1000";
	}	
	
	public boolean execute() {
		sendToLogStart();
		try{
			// Click tab รายได้จากเงินเดือน
			String SubOtherInfo = "//div[@id='subTabs']/ul[1]/li[3]/a";
			new WaitFor().xpath(SubOtherInfo);
			driver.findElement(By.xpath(SubOtherInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab รายได้จากเงินเดือน" + "Click tab รายได้จากเงินเดือน");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab รายได้จากเงินเดือน" + "Click tab รายได้จากเงินเดือน");
			return false;
		}
		
		
		
		try{
			// Input อายุงาน
			String inputworkYear = "workExpYear";
			new WaitFor().id(inputworkYear);
			driver.findElement(By.id(inputworkYear)).clear();
			driver.findElement(By.id(inputworkYear)).sendKeys(workExpYear);;
			sendToLogCustom(logexestatus.PASS, logaction.Type, "อายุงานในปัจจุบัน(กรณีเงินเดือน) *" + "อายุงานในปัจจุบัน(กรณีเงินเดือน) *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "อายุงานในปัจจุบัน(กรณีเงินเดือน) *" + "อายุงานในปัจจุบัน(กรณีเงินเดือน) *");
			return false;
		}
		
		
		
		try{
			// Input เงินเดือน
			String inputregSalary = "regSalary";
			new WaitFor().id(inputregSalary);
			driver.findElement(By.id(inputregSalary)).clear();
			driver.findElement(By.id(inputregSalary)).sendKeys(salary);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "อัตราเงินเดือน  *" + "อัตราเงินเดือน  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "อัตราเงินเดือน  *" + "อัตราเงินเดือน  *");
			return false;
		}
		
		
		
		try{
			// Input ภาษี
			String inputregTax = "regTax";
			new WaitFor().id(inputregTax);
			driver.findElement(By.id(inputregTax)).clear();
			driver.findElement(By.id(inputregTax)).sendKeys(tax);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าภาษี *" + "ค่าภาษี  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าภาษี *" + "ค่าภาษี  *");
			return false;
		}
		
		
		
		try{
			// Input ประกันสังคม
			String inputregSocialSecurity = "regSocialSecurity";
			new WaitFor().id(inputregSocialSecurity);
			driver.findElement(By.id(inputregSocialSecurity)).clear();
			driver.findElement(By.id(inputregSocialSecurity)).sendKeys(socialSecurity);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าประกันสังคม " + "ค่าประกันสังคม ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าประกันสังคม " + "ค่าประกันสังคม ");
			return false;
		}
		
		
		
		try{
			// Input กองทุนเลี้ยงชีพ
			String inputregProvidentFund = "regProvidentFund";
			new WaitFor().id(inputregProvidentFund);
			driver.findElement(By.id(inputregProvidentFund)).clear();
			driver.findElement(By.id(inputregProvidentFund)).sendKeys(srovidentFund);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "กองทุนสำรองเลี้ยงชีพ  " + "กองทุนสำรองเลี้ยงชีพ  ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "กองทุนสำรองเลี้ยงชีพ  " + "กองทุนสำรองเลี้ยงชีพ  ");
			return false;
		}
		
		
		
		
		try{
			// Input หุ้นสหกรณ์
			String inputregCooperativeShare = "regCooperativeShare";
			new WaitFor().id(inputregCooperativeShare);
			driver.findElement(By.id(inputregCooperativeShare)).clear();
			driver.findElement(By.id(inputregCooperativeShare)).sendKeys(cooperativeShare);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าหุ้นสหกรณ์  " + "ค่าหุ้นสหกรณ์ ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าหุ้นสหกรณ์ " + "ค่าหุ้นสหกรณ์ ");
			return false;
		}
		
		
		try{
			// Input ฌอส.
			String inputregChorOrSor = "regChorOrSor";
			new WaitFor().id(inputregChorOrSor);
			driver.findElement(By.id(inputregChorOrSor)).clear();
			driver.findElement(By.id(inputregChorOrSor)).sendKeys(chorOrSor);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ฌอส. " + "ฌอส. ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ฌอส. " + "ฌอส.  ");
			return false;
		}
		
		
		
		// SAVE
		try{
			String btnSave = "btnSave";
			new WaitFor().id(btnSave);
			driver.findElement(By.id(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Save  " + "Save ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Save  " + "Save ");
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
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFIncome, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFIncome, logelement.None,
				logaction, str);
	}
}

