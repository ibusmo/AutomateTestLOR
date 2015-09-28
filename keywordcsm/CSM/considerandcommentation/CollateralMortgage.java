package CSM.considerandcommentation;

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

public class CollateralMortgage implements KeywordsCSM {
	private String OrderNo = "1";
	private String guaranteeAmounts = "800000";
	@Override
	public boolean execute() {
		sendToLogStart();
		try{ 
			// Click Subtab จำนองจำนำ
			String ClickSubtabMontgage = "ข้อมูลจำนอง/จำนำ";
			new WaitFor().linkText(ClickSubtabMontgage);
			driver.findElement(By.linkText(ClickSubtabMontgage)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click,  "Click Subtab จำนองจำนำ");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click,  "Click Subtab จำนองจำนำ");
		}
		try{
			// Check box เลือกเจ้าของกรรมสิทธิ์
			String checkBoxOwner = "collOwnerBOList[0].checkFlag";
			new WaitFor().name(checkBoxOwner);
			driver.findElement(By.name(checkBoxOwner)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox,  "Click Checkbox เจ้าของกรรมสิทธิ์");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox,  "Click Checkbox เจ้าของกรรมสิทธิ์");
		}
		try{
			// Type input ลำดับเจ้าของกรรมสิทธิ์
			String checkBoxOwner = "collOwnerBOList[0].orderStr";
			new WaitFor().name(checkBoxOwner);
			driver.findElement(By.name(checkBoxOwner)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox,  "Type ลำดับ เจ้าของกรรมสิทธิ์");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox,  "Type ลำดับ เจ้าของกรรมสิทธิ์");
		}
		try{
			// Select Dropdown ประเภทนิติกรรม
			String inputField = "//*[@id='tabs-2']/div[1]/div/div[11]/table/tbody/tr[2]/td[1]/input";
			String inputValue = "1 : สัญญาหลัก";
			String selectField = "mortgageContractRelationTypeCode";
			String selectValue = "1";
			String jEXE = "populateDropDownmortgageContractType('"+selectValue+"')";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทนิติกรรม   1 : สัญญาหลัก");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "ประเภทนิติกรรม   1 : สัญญาหลัก");
			return false;
		}
		try{
			// Select Dropdown ประเภทของสัญญา *
			String inputField = "//*[@id='tabs-2']/div[1]/div/div[11]/table/tbody/tr[2]/td[2]/input";
			String inputValue = "1 : สัญญาจำนอง (อสังหาริมทรัพย์)";
			String selectField = "mortgageContractTypeCode";
			String selectValue = "1";
			new Dropdown().idNoText(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทของสัญญา * :   1 : สัญญาจำนอง (อสังหาริมทรัพย์)");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "ประเภทของสัญญา * :   1 : สัญญาจำนอง (อสังหาริมทรัพย์)");
			return false;
		}
		try{
			// Select Type input ลำดับ/ครั้งที่ *
			String inputmortgageContractSeq = "mortgageContractSeq";
			new WaitFor().id(inputmortgageContractSeq);
			driver.findElement(By.id(inputmortgageContractSeq)).clear();
			driver.findElement(By.id(inputmortgageContractSeq)).sendKeys(OrderNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "ลำดับ/ครั้งที่ *" + "1");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "ลำดับ/ครั้งที่ *" + "1");
			return false;
		}
		try{
			// Select Type input มูลจำนอง * 
			String inputguaranteeAmount = "guaranteeAmount";
			new WaitFor().id(inputguaranteeAmount);
			driver.findElement(By.id(inputguaranteeAmount)).clear();
			driver.findElement(By.id(inputguaranteeAmount)).sendKeys(guaranteeAmounts);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "ลำดับ/ครั้งที่ *" + guaranteeAmounts);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "ลำดับ/ครั้งที่ *" + guaranteeAmounts);
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
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}
	
	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Mortgage, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Mortgage, logelement.None,
				logaction, str);
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

}

