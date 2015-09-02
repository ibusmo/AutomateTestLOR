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

public class CustomerExpenses implements Keywords {
	
	private String ExpenseOfConsumer;
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	public CustomerExpenses(String ExpenseOfConsumer ) {
		this.ExpenseOfConsumer = ExpenseOfConsumer;
	}
	
	public boolean execute() {
		sendToLogStart();
		
		// Click tab ค่าใช้จ่าย
		try{
			String SubOtherInfo = "//*[@id='subTabs']/ul/li[5]/a";
			new WaitFor().xpath(SubOtherInfo);
			driver.findElement(By.xpath(SubOtherInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab ค่าใช้จ่าย" + "Click tab ค่าใช้จ่าย");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab ค่าใช้จ่าย" + "Click tab ค่าใช้จ่าย");
		}
		
		// Input ค่าใช้จ่าย
		try{
			String inputExpenseConsumer = "expenseConsumer";
			new WaitFor().id(inputExpenseConsumer);
			driver.findElement(By.id(inputExpenseConsumer)).sendKeys(ExpenseOfConsumer);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "ค่าใช้จ่ายอุปโภคบริโภค   " + "ค่าใช้จ่ายอุปโภคบริโภค ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "ค่าใช้จ่ายอุปโภคบริโภค   " + "ค่าใช้จ่ายอุปโภคบริโภค  ");
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
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFExpense, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFExpense, logelement.None,
				logaction, str);
	}
}
