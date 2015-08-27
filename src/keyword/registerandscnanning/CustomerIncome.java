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
			String SubOtherInfo = "//div[@id='subTabs']/ul[1]/li[3]";
			new WaitFor().xpath(SubOtherInfo);
			driver.findElement(By.xpath(SubOtherInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab �����ҡ�Թ��͹" + "Click tab �����ҡ�Թ��͹");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab �����ҡ�Թ��͹" + "Click tab �����ҡ�Թ��͹");
			return false;
		}
		
		
		
		try{
			String inputworkYear = "workExpYear";
			new WaitFor().id(inputworkYear);
			driver.findElement(By.id(inputworkYear)).sendKeys(workExpYear);;
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���اҹ㹻Ѩ�غѹ(�ó��Թ��͹) *" + "���اҹ㹻Ѩ�غѹ(�ó��Թ��͹) *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���اҹ㹻Ѩ�غѹ(�ó��Թ��͹) *" + "���اҹ㹻Ѩ�غѹ(�ó��Թ��͹) *");
			return false;
		}
		
		
		
		try{
			String inputregSalary = "regSalary";
			new WaitFor().id(inputregSalary);
			driver.findElement(By.id(inputregSalary)).sendKeys(Salary);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "�ѵ���Թ��͹  *" + "�ѵ���Թ��͹  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "�ѵ���Թ��͹  *" + "�ѵ���Թ��͹  *");
			return false;
		}
		
		
		
		try{
			String inputregTax = "regTax";
			new WaitFor().id(inputregTax);
			driver.findElement(By.id(inputregTax)).sendKeys(Tax);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "������� *" + "�������  *");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "������� *" + "�������  *");
			return false;
		}
		
		
		
		try{
			String inputregSocialSecurity = "regSocialSecurity";
			new WaitFor().id(inputregSocialSecurity);
			driver.findElement(By.id(inputregSocialSecurity)).sendKeys(SocialSecurity);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "��һ�Сѹ�ѧ�� " + "��һ�Сѹ�ѧ�� ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "��һ�Сѹ�ѧ�� " + "��һ�Сѹ�ѧ�� ");
			return false;
		}
		
		
		
		try{
			String inputregProvidentFund = "regProvidentFund";
			new WaitFor().id(inputregProvidentFund);
			driver.findElement(By.id(inputregProvidentFund)).sendKeys(ProvidentFund);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "�ͧ�ع���ͧ����§�վ  " + "�ͧ�ع���ͧ����§�վ  ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "�ͧ�ع���ͧ����§�վ  " + "�ͧ�ع���ͧ����§�վ  ");
			return false;
		}
		
		
		
		
		try{
			String inputregCooperativeShare = "regCooperativeShare";
			new WaitFor().id(inputregCooperativeShare);
			driver.findElement(By.id(inputregCooperativeShare)).sendKeys(CooperativeShare);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "�������ˡó�  " + "�������ˡó� ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "�������ˡó� " + "�������ˡó� ");
			return false;
		}
		
		
		try{
			String inputregChorOrSor = "regChorOrSor";
			new WaitFor().id(inputregChorOrSor);
			driver.findElement(By.id(inputregChorOrSor)).sendKeys(ChorOrSor);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���. " + "���. ");

			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���. " + "���.  ");
			return false;
		}
		
		
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
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, str);
	}
}

