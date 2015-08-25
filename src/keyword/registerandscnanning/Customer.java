package keyword.registerandscnanning;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class Customer implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendToLogStart() {
		// TODO Auto-generated method stub
		logCat.sendToLog(logexestatus.START, logoperation.RegisScan, logtab.RegisCust, logsubtab.None, logelement.None, logaction.None, null);
	}

	@Override
	public void sendToLogFinish() {
		logCat.sendToLog(logexestatus.FINISH, logoperation.RegisScan, logtab.RegisCust, logsubtab.None, logelement.None, logaction.None, null);
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			//Add Customer
			String btnAddCustomer = "เพิ่ม";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(btnAddCustomer)));
			driver.findElement(By.xpath(btnAddCustomer)).click();
			logCat.sendToLog(logexestatus.PASS, logoperation.RegisScan, logtab.RegisCust, logsubtab.None, logelement.None, logaction.Click, "เพิ่มลูกค้า ");
		}catch (TimeoutException e){
			logCat.sendToLog(logexestatus.FAIL, logoperation.RegisScan, logtab.RegisCust, logsubtab.None, logelement.None, logaction.Click, "เพิ่มลูกค้า ");
			return false;
		}
		sendToLogFinish();
		return false;
	}
	
}
