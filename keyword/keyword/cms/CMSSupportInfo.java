package keyword.cms;

import keyword.Keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Dropdown;
import customcomponent.WaitFor;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CMSSupportInfo implements Keywords{

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		sendToLogStart();
		try{
			// Click Sub-tab ข้อมูลสนับสนุน ธปท.
			String linkSubtab = "ข้อมูลสนับสนุน ธปท.";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab ข้อมูลสนับสนุน ธปท.");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab ข้อมูลสนับสนุน ธปท.");
			return false;
		}
		try{
			// Select Dropdown รหัสหลักประกัน (ธปท.) *
			String inputField = "//*[@id='botCdDiv']/input[2]";
			String inputValue = "ที่ดินพร้อมสิ่งปลูกสร้าง";
			String selectField = "botCd";
			String selectValue = "286006";
			String jsExe = "populateSubBOT('"+selectValue+"', 'subbotCd');";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jsExe);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "รหัสหลักประกัน (ธปท.) *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "รหัสหลักประกัน (ธปท.) *: ");
			return false;
		}
		try{
			// Select Dropdown รหัสหลักประกันย่อย(ธปท.) *
			String inputField = "//*[@id='subbotCdDiv']/input[2]";
			String inputValue = "ที่ดินพร้อมสิ่งปลูกสร้าง";
			String selectField = "subbotCd";
			String selectValue = "0";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "รหัสหลักประกันย่อย(ธปท.) *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "รหัสหลักประกันย่อย(ธปท.) *: ");
			return false;
		}
		try{
			// Select Dropdown ประเภทของอสังหาริมทรัพย์ *
			String inputField = "//*[@id='content']/div/form/div/table/tbody/tr[3]/td[2]/input";
			String inputValue = "1 : อสังหาริมทรัพย์เพื่อที่อยู่อาศัย (Residential Real Estate)";
			String selectField = "realEstateCd";
			String selectValue = "1";
			new Dropdown().idNoText(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทของอสังหาริมทรัพย์ *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ประเภทของอสังหาริมทรัพย์ *: ");
			return false;
		}
		try{
			// Select Dropdown ข้อจำกัดของการใช้ประโยชน์ที่ดินตาม พรบ.ผังเมือง *
			String inputField = "//*[@id='realUseinfoCdDiv']/input[2]";
			String inputValue = "เขตสีแดง ที่ดินประเภทพาณิชยกรรม";
			String selectField = "realUseinfoCd";
			String selectValue = "2";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ข้อจำกัดของการใช้ประโยชน์ที่ดินตาม พรบ.ผังเมือง *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ข้อจำกัดของการใช้ประโยชน์ที่ดินตาม พรบ.ผังเมือง *: ");
			return false;
		}
		try{
			// Click SAVE
			/*
			String btnSave = "//*[@id='content']/div/form/div/table/tbody/tr[5]/td/input[1]";
			new WaitFor().xpath(btnSave);
			driver.findElement(By.xpath(btnSave)).click();
			*/
			executor.executeScript("selectPage('doSaveDraft')", driver.findElement(By.id("content")));
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click SAVE ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click SAVE ");
			return false;
		}
		sendToLogFinish();
		return true;
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.SupportInfo, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.SupportInfo, logelement.None,
				logaction, str);
	}
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}
}
