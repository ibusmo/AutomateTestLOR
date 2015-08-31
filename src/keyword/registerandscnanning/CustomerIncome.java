package keyword.registerandscnanning;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CustomerIncome implements Keywords{
	
	private String workExpYear;
	private String Salary;
	private String Tax;
	private String SocialSecurity;
	private String ProvidentFund;
	private String CooperativeShare;
	private String ChorOrSor;
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	public CustomerIncome(String workExpYear, String Salary, String Tax, String SocialSecurity, String ProvidentFund, String CooperativeShare, String ChorOrSor) {
		this.workExpYear = workExpYear;
		this.Salary = Salary;
		this.Tax = Tax;
		this.SocialSecurity = SocialSecurity;
		this.ProvidentFund = ProvidentFund;
		this.CooperativeShare = CooperativeShare;
		this.ChorOrSor = ChorOrSor;
		// TODO Auto-generated constructor stub
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
			driver.findElement(By.id(inputregSalary)).sendKeys(Salary);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "อัตราเงินเดือน  *" + "อัตราเงินเดือน  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "อัตราเงินเดือน  *" + "อัตราเงินเดือน  *");
			return false;
		}
		
		
		
		try{
			// Input ภาษี
			String inputregTax = "regTax";
			new WaitFor().id(inputregTax);
			driver.findElement(By.id(inputregTax)).sendKeys(Tax);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าภาษี *" + "ค่าภาษี  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าภาษี *" + "ค่าภาษี  *");
			return false;
		}
		
		
		
		try{
			// Input ประกันสังคม
			String inputregSocialSecurity = "regSocialSecurity";
			new WaitFor().id(inputregSocialSecurity);
			driver.findElement(By.id(inputregSocialSecurity)).sendKeys(SocialSecurity);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าประกันสังคม " + "ค่าประกันสังคม ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าประกันสังคม " + "ค่าประกันสังคม ");
			return false;
		}
		
		
		
		try{
			// Input กองทุนเลี้ยงชีพ
			String inputregProvidentFund = "regProvidentFund";
			new WaitFor().id(inputregProvidentFund);
			driver.findElement(By.id(inputregProvidentFund)).sendKeys(ProvidentFund);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "กองทุนสำรองเลี้ยงชีพ  " + "กองทุนสำรองเลี้ยงชีพ  ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "กองทุนสำรองเลี้ยงชีพ  " + "กองทุนสำรองเลี้ยงชีพ  ");
			return false;
		}
		
		
		
		
		try{
			// Input หุ้นสหกรณ์
			String inputregCooperativeShare = "regCooperativeShare";
			new WaitFor().id(inputregCooperativeShare);
			driver.findElement(By.id(inputregCooperativeShare)).sendKeys(CooperativeShare);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าหุ้นสหกรณ์  " + "ค่าหุ้นสหกรณ์ ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าหุ้นสหกรณ์ " + "ค่าหุ้นสหกรณ์ ");
			return false;
		}
		
		
		try{
			// Input ฌอส.
			String inputregChorOrSor = "regChorOrSor";
			new WaitFor().id(inputregChorOrSor);
			driver.findElement(By.id(inputregChorOrSor)).sendKeys(ChorOrSor);
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

