package keyword.registerandscnanning;

import org.openqa.selenium.Alert;
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

public class AttachFiles implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click เอกสารแนบ Tab
			String btnAttachFilesTab = "เอกสารแนบ";
			new WaitFor().linkText(btnAttachFilesTab);
			driver.findElement(By.linkText(btnAttachFilesTab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "เอกสารแนบ  Tab");			
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "เอกสารแนบ Tab");
			return false;
		}
		try{
			// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "เอกสารแนบ Tab OK");
		}catch (NullPointerException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "เอกสารแนบ Tab");
		}
		int numRows=0;
		try{
			//Get number of Table Rows
			String elementOfTableX = "//*[@id='divListDocument']/div[2]/div/table/tbody/tr";
			//String elementOfTable = "#divListDocument > div:nth-child(4) > div > table > tbody > tr";
			new WaitFor().xpath(elementOfTableX);
			numRows = driver.findElements(By.xpath(elementOfTableX)).size();
			sendToLogCustom(logexestatus.PASS, logaction.Check, "There are " +numRows+ " " + " rows.");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Check, "Can't get number of rows.");
		}
		for(int index=2;index<=numRows;index++){
			try{
				String xpathTmp = "//*[@id='divListDocument']/div[2]/div/table/tbody/tr["+index+"]/td[7]/button[2]/img";
									   //*[@id="divListDocument"]/div[2]/div/table/tbody/tr[2]        /td[7]/button[2]/img
				new WaitFor().xpath(xpathTmp);
				String bynTitle = driver.findElement(By.xpath(xpathTmp)).getAttribute("title");
				//System.out.println(bynTitle);
				if(bynTitle=="เลือก"){
					driver.findElement(By.xpath(xpathTmp)).click();
					//Select File Page
					new WaitFor().name("theFile");
					driver.findElement(By.name("theFile")).sendKeys("C:\\Windows\\system.ini");
					String btnAccept = "//*[@id='docList']/table/tbody/tr[4]/td/button[1]";
					driver.findElement(By.xpath(btnAccept)).click();
					sendToLogCustom(logexestatus.PASS, logaction.Attach, "Attached\t" + (index-1));
				}else{
					sendToLogCustom(logexestatus.PASS, logaction.Attach, "Not require\t" + (index-1));						
				}
			}catch(TimeoutException e){
				sendToLogCustom(logexestatus.FAIL, logaction.Attach, "Error, Something went wrong.");
			}
		}
		sendToLogFinish();
		return false;
	}
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None, "");
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None, "");
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.AttachFiles, logsubtab.None, logelement.None,
				logaction, str);
	}
}