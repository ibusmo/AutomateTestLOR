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

public class CustomerExpenses implements Keywords {
	
	private String ExpenseConsumer;
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	public CustomerExpenses(String ExpenseConsumer ) {
		this.ExpenseConsumer = ExpenseConsumer;
	}
	
	public boolean execute() {
		sendToLogStart();
		
		
		
		
		try{
			String inputExpenseConsumer = "ExpenseConsumer";
			new WaitFor().id(inputExpenseConsumer);
			driver.findElement(By.id(inputExpenseConsumer)).sendKeys(ExpenseConsumer);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "§Ë“„™È®Ë“¬Õÿª‚¿§∫√‘‚¿§   " + "§Ë“„™È®Ë“¬Õÿª‚¿§∫√‘‚¿§ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "§Ë“„™È®Ë“¬Õÿª‚¿§∫√‘‚¿§   " + "§Ë“„™È®Ë“¬Õÿª‚¿§∫√‘‚¿§  ");
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
