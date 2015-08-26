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
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab ����������" + "Click tab ����������");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab ����������" +  "Click tab ����������");
		}
		
		
		try { 
			String inputCustPeriod = "custPeriodYear";
			new WaitFor().id(inputCustPeriod);
			driver.findElement(By.id(inputCustPeriod)).sendKeys(PeriodYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "��������㹡�����١���" + "��������㹡�����١���");

		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "��������㹡�����١���" + "��������㹡�����١���");

		}
		
		
		try{
			String inputField = "//*[@id='incomeSourceCode']/input";
			String inputValue = "1 : �Թ��͹";
			String selectField = "incomeSourceCode";
			String selectValue = "1";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "���觷���Ңͧ����� " + "���觷���Ңͧ����� ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���觷���Ңͧ����� " + "���觷���Ңͧ����� ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���觷���Ңͧ����� " + "���觷���Ңͧ����� ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='coborrowerRelatedTypeCode']/input";
			String inputValue = "01 : ����ռ��������/����ռ���ӻ�Сѹ";
			String selectField = "coborrowerRelatedTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "��������ѹ��ͧ�������������յ�͡�á�� " + "��������ѹ��ͧ�������������յ�͡�á�� ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "��������ѹ��ͧ�������������յ�͡�á�� " + "��������ѹ��ͧ�������������յ�͡�á��  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "��������ѹ��ͧ�������������յ�͡�á�� " + "��������ѹ��ͧ�������������յ�͡�á�� ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='garantorRelatedTypeCode']/input";
			String inputValue = "01 : ����ռ��������/����ռ���ӻ�Сѹ";
			String selectField = "garantorRelatedTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ  " + "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ " + "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ " + "��������ѹ��ͧ����ӻ�Сѹ�Ѻ�������ѡ ");
			return false;
		}
		
		
		try{
			String inputChildAll = "childCountAll";
			new WaitFor().id(inputChildAll);
			driver.findElement(By.id(inputChildAll)).sendKeys(NumberOfChild);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "�ӹǹ�ص÷ѧ��� " + "�ӹǹ�ص÷ѧ���  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "�ӹǹ�ص÷ѧ���  " + "�ӹǹ�ص÷ѧ���  ");
			return false;
		}
		
		
		try{
			String inputCurAddrYear = "curAddrYear";
			new WaitFor().id(inputCurAddrYear);
			driver.findElement(By.id(inputCurAddrYear)).sendKeys(CurAddrYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "�������ҷ�������㹷������Ѩ�غѹ  " + "�������ҷ�������㹷������Ѩ�غѹ   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "�������ҷ�������㹷������Ѩ�غѹ   " + "�������ҷ�������㹷������Ѩ�غѹ   ");
			return false;
		}
		
		
		
		
		try{
			String inputField = "//*[@id='houseTypeCode']/input";
			String inputValue = "01 : ��ҹ�����";
			String selectField = "houseTypeCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "���������ѡ�����   " + "���������ѡ�����  ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���������ѡ�����  " + "���������ѡ�����  ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���������ѡ�����  " + "���������ѡ����� ");
			return false;
		}
		
		
		
		try{
			String inputField = "//*[@id='houseOwnershipCode']/input";
			String inputValue = "01 : �繢ͧ���ͧ / ������� - ��ʹ���м١�ѹ";
			String selectField = "houseOwnershipCode";
			String selectValue = "01";
			String jEXE = "populateCorpGroup();";
			new SelectDropdown().select(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ʶҹз��ѡ�����  " + "ʶҹз��ѡ�����   ");
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ʶҹз��ѡ�����   " + "ʶҹз��ѡ�����   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ʶҹз��ѡ�����   " + "ʶҹз��ѡ�����  ");
			return false;
		}
		
		try{
			String inputWorkCurYear = "workCurExpYear";	
			new WaitFor().id(inputWorkCurYear);
			driver.findElement(By.id(inputWorkCurYear)).sendKeys(WorkCurYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���اҹ�Ѩ�غѹ    " + "���اҹ�Ѩ�غѹ   ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���اҹ�Ѩ�غѹ    " + "���اҹ�Ѩ�غѹ   ");
		}
		
		
		try{
			String inputworkAllExpYear = "workAllExpYear";	
			new WaitFor().id(inputworkAllExpYear);
			driver.findElement(By.id(inputworkAllExpYear)).sendKeys(WorkAllYear);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���اҹ���  " + "���اҹ��� ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���اҹ���  " + "���اҹ��� ");
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
			sendToLogCustom(logexestatus.PASS, logaction.Type, "���������ػ��������� " + "���������ػ��������� ");
			
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "���������ػ��������� " + "���������ػ��������� ");
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
