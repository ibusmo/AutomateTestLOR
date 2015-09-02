package keyword.cms;

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

public class CMSGotoApp implements Keywords{
	
	String CMSNum;
	
	public CMSGotoApp(String CMSNum) {
		this.CMSNum = CMSNum;
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
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
			String btnEva = new CMSGetElement().getElement(CMSNum, "EDIT");
			if(btnEva==null){
				sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึกราคาประเมิน null with " + CMSNum);
				return false;  
			}
			new WaitFor().xpath(btnEva);
			driver.findElement(By.xpath(btnEva)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "บันทึกราคาประเมิน " + CMSNum);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "บันทึกราคาประเมิน " + CMSNum);
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CMSGotoApp, logsubtab.None, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CMSGotoApp, logsubtab.None, logelement.None,
				logaction, str);
	}
}
