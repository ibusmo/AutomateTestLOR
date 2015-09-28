package CSM.registerandscanning;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class CustomerNonNCB implements KeywordsCSM {
	
	private String reportedCoopCompLoan;
	@Override
	public void initKeywords() {
		reportedCoopCompLoan = "0";
	}
	
	public CustomerNonNCB() {
		initKeywords();
	}
	
	public boolean execute() {
		sendToLogStart();		
		// Click tab Non NCB
		try{	
			String SubOtherInfo = "//*[@id='subTabs']/ul/li[6]/a";						
			new WaitFor().xpath(SubOtherInfo);
			driver.findElement(By.xpath(SubOtherInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab ข้อมูลอื่นๆ" + "Click tab ข้อมูลอื่นๆ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab ข้อมูลอื่นๆ" +  "Click tab ข้อมูลอื่นๆ");
		}
		// Input เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น
		try{
			String inputunreportedCoopCompLoan = "unreportedCoopCompLoan";
			new WaitFor().id(inputunreportedCoopCompLoan);
			driver.findElement(By.id(inputunreportedCoopCompLoan)).sendKeys(reportedCoopCompLoan);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น" + "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น  " + "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น  ");
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
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFNonNCB, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFNonNCB, logelement.None,
				logaction, str);
	}
}
