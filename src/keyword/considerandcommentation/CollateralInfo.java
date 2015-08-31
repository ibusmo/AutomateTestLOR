package keyword.considerandcommentation;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import CustomComponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CollateralInfo implements Keywords{
	@Override
	public boolean execute(){
		sendToLogStart();
		try{
			// Click ดูรายละเอียด
			String btnCollInfo = "//*[@id='collateralList']/div/div[2]/div/table/tbody/tr[2]/td[1]/button[1]";
			new WaitFor().xpath(btnCollInfo);
			driver.findElement(By.xpath(btnCollInfo)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click ดูรายละเอียด ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click ดูรายละเอียด");
		}
		try{
			//Radio Button เลือกที่สิ่งปลูกส้ราง
			new WaitFor().name("selectedRecord");
			List<WebElement> radios = driver.findElements(By.name("selectedRecord"));
			radios.get(1).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "เลือกที่สิ่งปลูกส้ราง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "เลือกที่สิ่งปลูกส้ราง");
			return false;
		}	
		try{
			// Click ดูรายละเอียด
			String btnWarrantee = "//*[@id='subTabs']/ul/li[2]/a";
			new WaitFor().xpath(btnWarrantee);
			driver.findElement(By.xpath(btnWarrantee)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click ทุนประกันภัย");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click ทุนประกันภัย");
		}
		try{
			//Radio Button เลือกทำประกันใหม่
			new WaitFor().name("insurePurposeCode");
			List<WebElement> radios = driver.findElements(By.name("insurePurposeCode"));
			radios.get(0).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "เลือกทำประกันใหม่");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "เลือกทำประกันใหม่");
			return false;
		}	
		try{
			// SAVE
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
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToLogStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendToLogFinish() {
		// TODO Auto-generated method stub
		
	}
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Warrantee, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Warrantee, logelement.None,
				logaction, str);
	}
}
