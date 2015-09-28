package keyword.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.Dropdown;
import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class CMSBuildingInfo implements KeywordsCSM{
	
	private String realBldArea = "80";
	private String bldFloor = "2";
	private String bldVal = "1000000";
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			// Click Subtab ข้อมูลสิ่งปลูกสร้าง
			String linkSubtab = "ข้อมูลสิ่งปลูกสร้าง";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab ข้อมูลสิ่งปลูกสร้าง ");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab ข้อมูลสิ่งปลูกสร้าง ");
			return false;
		}
		try{
			// Click แก้ไข
			String linkSubtab = "แก้ไข";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click แก้ไข");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click แก้ไข");
			return false;
		}
		try{
			// Select Dropdown ประเภทสิ่งปลูกสร้าง
			String inputField = "//*[@id='content']/div/form/div/table[1]/tbody/tr[2]/td[2]/input[1]";
			String inputValue = "10 : ทาวน์เฮาส์ 2 ชั้น";
			String selectField = "bldCategoryCd";
			String selectValue = "10";
			String jsExe = "populateBuildingTypeByBldCategory('"+selectValue+"')";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jsExe);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทสิ่งปลูกสร้าง*" + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "ประเภทสิ่งปลูกสร้าง*");
			return false;
		}
		try{
			// Type input พื้นที่ใช้สอย (ตรม.) *
			String inputrealBldArea = "realBldArea";
			new WaitFor().name(inputrealBldArea);
			driver.findElement(By.name(inputrealBldArea)).clear();
			driver.findElement(By.name(inputrealBldArea)).sendKeys("89");
			sendToLogCustom(logexestatus.PASS, logaction.Text, "พื้นที่ใช้สอย (ตรม.) *: " + realBldArea);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "พื้นที่ใช้สอย (ตรม.) *: " + realBldArea);
			return false;
		}
		try{
			// Type input ชั้นลอย/จำนวนรวมชั้น *
			String inputbldFloor = "bldFloor";
			new WaitFor().name(inputbldFloor);
			driver.findElement(By.name(inputbldFloor)).clear();
			driver.findElement(By.name(inputbldFloor)).sendKeys(bldFloor);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "ชั้นลอย/จำนวนรวมชั้น *: " + bldFloor);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "ชั้นลอย/จำนวนรวมชั้น *: " + bldFloor);
			return false;
		}
		try{
			// Type input มูลค่าสิ่งปลูกสร้าง *
			String inputbldVal = "bldVal";
			new WaitFor().name(inputbldVal);
			driver.findElement(By.name(inputbldVal)).clear();
			driver.findElement(By.name(inputbldVal)).sendKeys(bldVal);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "มูลค่าสิ่งปลูกสร้าง *: " + bldVal);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "มูลค่าสิ่งปลูกสร้าง *: " + bldVal);
			return false;
		}
		try{
			// Select Dropdown ความเป็นเจ้าของที่ดินที่ตั้งสิ่งปลูกสร้าง *
			String inputField = "//*[@id='content']/div/form/div/table[3]/tbody/tr[1]/td[2]/input";
			String inputValue = "1 : เป็นเจ้าของที่ดิน";
			String selectField = "bldLandOwnershipCd";
			String selectValue = "1";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "เลือกประเภทสิ่งปลูกสร้าง*: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "เลือกประเภทสิ่งปลูกสร้าง*: ");
			return false;
		}
		try{
			// Select Dropdown ฝา/ผนัง *
			String inputField = "//*[@id='content']/div/form/div/table[3]/tbody/tr[4]/td[2]/input";
			String inputValue = "1 : คอนกรีตเสริมเหล็ก";
			String selectField = "bldWall";
			String selectValue = "1";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ฝา/ผนัง *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "ฝา/ผนัง *: ");
			return false;
		}
		try{
			// Select Dropdown หลังคา *
			String inputField = "//*[@id='content']/div/form/div/table[3]/tbody/tr[5]/td[2]/input";
			String inputValue = "1 : คอนกรีตเสริมเหล็ก";
			String selectField = "roof";
			String selectValue = "1";
			new Dropdown().id(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "หลังคา *: " + inputValue);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "หลังคา *: ");
			return false;
		}
		try{
			//Click Save แก้ไข
			String btnEdit = "//*[@id='content']/div/form/div/table[4]/tbody/tr/td/input[1]";
			new WaitFor().xpath(btnEdit);
			driver.findElement(By.xpath(btnEdit)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click แก้ไข ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click แก้ไข ");
			return false;
		}
		try{
			// Click SAVE
			/*
			String btnSave = "//*[@id='content']/div/form/div/table[3]/tbody/tr/td/input[1]";
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.BuildingInfo, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.BuildingInfo, logelement.None,
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
