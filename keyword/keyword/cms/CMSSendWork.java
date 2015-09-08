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

public class CMSSendWork implements Keywords{

	String CMSNum;
	
	public CMSSendWork(String CMSNum) {
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
			// Click ส่งงาน
			String btnSend = new CMSGetElement().getElement(CMSNum, "SEND");
			if(btnSend==null){
				sendToLogCustom(logexestatus.FAIL, logaction.SendWork, "ส่งงาน null with " + CMSNum);
				return false;  
			}
			new WaitFor().xpath(btnSend);
			driver.findElement(By.xpath(btnSend)).click();
			sendToLogCustom(logexestatus.PASS, logaction.SendWork, "ส่งงาน " + CMSNum);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.SendWork, "ส่งงาน " + CMSNum);
			return false;
		}		
		try {
			// Click ตกลง
			String btnAccept = "//*[@id='content']/div/form/table/tbody/tr[2]/td/input";
			new WaitFor().xpath(btnAccept);
			driver.findElement(By.xpath(btnAccept)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ตกลง");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ตกลง");
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CMSSendWork, logsubtab.None, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CMSSendWork, logsubtab.None, logelement.None,
				logaction, str);
	}
}
