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

public class CustomerNonNCB implements Keywords {
	
	private String reportedCoopCompLoan;
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	public CustomerNonNCB(String reportedCoopCompLoan ) {
		this.reportedCoopCompLoan = reportedCoopCompLoan;
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
			sendToLogCustom(logexestatus.PASS, logaction.Type, "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น" + "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น  " + "เงินกู้สหกรณ์ เงินกู้บริษัท เป็นต้น  ");
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
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.CIFNonNCB, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.CIFNonNCB, logelement.None,
				logaction, str);
	}
}
