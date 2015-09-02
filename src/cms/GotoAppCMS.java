package cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import output.LogTag.logaction;
import output.LogTag.logexestatus;

public class GotoAppCMS extends GetElement{
	
	String CMSNum;
	
	public GotoAppCMS(String CMSNum) {
		this.CMSNum = CMSNum;
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click ประเมินราคาใหม่จาก LOR link
			String linkEva = "ประเมินราคาใหม่จาก LOR";
			new WaitFor().linkText(linkEva);
			driver.findElement(By.linkText(linkEva)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ประเมินราคาใหม่จาก LOR link");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ประเมินราคาใหม่จาก LOR link");
			return false;
		}
		try {
			// Click บันทึกราคาประเมิน
			String btnEva = new GetElement().getElement(CMSNum, "EDIT");
			if(btnEva==null){
				sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึกราคาประเมิน null");
				return false;  
			}
			new WaitFor().xpath(btnEva);
			driver.findElement(By.xpath(btnEva)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึกราคาประเมิน");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึกราคาประเมิน");
			return false;
		}		
		sendToLogFinish();
		return true;
	}
}
