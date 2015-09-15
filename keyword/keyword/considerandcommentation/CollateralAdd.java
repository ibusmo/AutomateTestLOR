package keyword.considerandcommentation;

import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import customcomponent.Dropdown;
import customcomponent.Popup;
import customcomponent.WaitFor;
import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CollateralAdd implements Keywords{
	private String DocLicenseNumber = getNum(5);
	private String buildingNo = getNum(3);
	private String buildingID = getNum(3);
	private String noOfBuilding = getNum(3);
	@Override
	public boolean execute() {
		sendToLogStart();
		try{
			// Click Tab หลักประกัน
			String tabAddColl = "หลักประกัน";
			new WaitFor().linkText(tabAddColl);
			driver.findElement(By.linkText(tabAddColl)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click tab หลักประกัน" + "Click tab หลักประกัน");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click tab หลักประกัน" + "Click tab หลักประกัน");
		}
		try{
			// Alert
			Alert javascriptprompt = driver.switchTo().alert();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, javascriptprompt.getText());
			javascriptprompt.accept();
			sendToLogCustom(logexestatus.PASS, logaction.Comfirm, "หลักประกัน Tab OK");
		}catch (NoAlertPresentException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Comfirm, "หลักประกัน Tab");
		}
		try{
			// Click Add หลักประกัน
			String btnAddColl = "addCollateralBtn";
			new WaitFor().id(btnAddColl);
			driver.findElement(By.id(btnAddColl)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Button เพิ่มหลักประกัน" + "Click Button เพิ่มหลักประกัน");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Button เพิ่มหลักประกัน" + "Click Button เพิ่มหลักประกัน");
		}
		try{
			// Select PopUp
			String xpathpopupAddColl = "//*[@id='addCollateralDiv']/table/thead/tr/th";
			WebDriver popupAddColl = new Popup().byxpath(xpathpopupAddColl, 2);
			if (popupAddColl == null) {
				sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
				return false;
			} else {
				if (AddCollateral()==false)
					return false;
				sendToLogCustom(logexestatus.PASS, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
			}
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
		}
		// Select Main Browser 
		String xpathMainPage = "//*[@id='content']/div/div/div[1]";
		WebDriver popupMainPage = new Popup().byxpath(xpathMainPage, 1);
		if (popupMainPage == null) {
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "Browser หลัก");
			return false;
		} else {
			sendToLogCustom(logexestatus.PASS, logaction.Popup, "Browser หลัก");
		}
		try{
			// Click Add สิ่งปลูกสร้าง
			String btnaddLandBldRel = "addLandBldRelBtn";
			new WaitFor().id(btnaddLandBldRel);
			driver.findElement(By.id(btnaddLandBldRel)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Button สิ่งปลูกสร้าง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Button สิ่งปลูกสร้าง");
		}
		try{
			// Select PopUp
			String xpathpopupAddBuilding = "//*[@id='searchNewCollateral']/table[1]/thead/tr/th";
			WebDriver popupAddBuilding = new Popup().byxpath(xpathpopupAddBuilding, 2);
			if (popupAddBuilding == null) {
				sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
				return false;
			} else {
				if (AddBuilding()==false)
					return false;
				sendToLogCustom(logexestatus.PASS, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
			}
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "เพิ่มคำขอสินเชื่อ");
		}
		// Select Main Browser 
		String xpathMainPage2nd = "//*[@id='tabs-2']/div[1]/div/div/div[1]";
		WebDriver popupMainPage2nd = new Popup().byxpath(xpathMainPage2nd, 1);
		if (popupMainPage2nd == null) {
			sendToLogCustom(logexestatus.FAIL, logaction.Popup, "Browser หลัก");
			return false;
		} else {
			sendToLogCustom(logexestatus.PASS, logaction.Popup, "Browser หลัก");
		}
		sendToLogFinish();
		return true;
	}
	private boolean AddBuilding() {
		// TODO Auto-generated method stub
		try{
			// Click เลือกสิ่งปลูกสร้างที่ต้องการ
			String chboxAddBuilding = "collBuildingBOList[0].checkFlag";
			new WaitFor().name(chboxAddBuilding);
			driver.findElement(By.name(chboxAddBuilding)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox, "เลือกสิ่งปลูกสร้างที่ต้องการ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, "เลือกสิ่งปลูกสร้างที่ต้องการ");
			return false;
		}
		try{
			String btnChoose = "//*[@id='searchNewCollateral']/div/button[1]";
			new WaitFor().xpath(btnChoose);
			driver.findElement(By.xpath(btnChoose)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ปุ่มเลือก");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ปุ่มเลือก");
			return false;
		}
		return true;
	}
	private boolean AddCollateral(){
		try{
			// Click Radio Add New Collateral
			String rdoAddNewColl = "//*[@id='addCollateralDiv']/div[2]/input[2]";
			new WaitFor().xpath(rdoAddNewColl);
			driver.findElement(By.xpath(rdoAddNewColl)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "เพิ่มหลักประกันใหม่");
		}catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Radio, "เพิ่มหลักประกันใหม่");
			return false;
		}
		try {
			// Select Dropdown เลือกประเภทหลักประกัน
			String inputField = "//*[@id='addCollTypeIdDiv']/div[2]/input";
			String inputValue = "2 : ที่ดินพร้อมสิ่งปลูกสร้าง";
			String selectField = "addCollTypeId";
			String selectValue = "2";
			String jEXE = "changeCollType('add')";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "ประเภทหลักประกันหลัก * " + "2 : ที่ดินพร้อมสิ่งปลูกสร้าง");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "ประเภทหลักประกันหลัก * " + "2 : ที่ดินพร้อมสิ่งปลูกสร้าง");
			return false;
		}
		try{
			// Select Dropdown เลือกหลักประกันย่อย
			String inputField = "//*[@id='addCollSubTypeIdDiv']/div[2]/input";
			String inputValue = "1 : โฉนด";
			String selectField = "addCollSubTypeId";
			String selectValue = "6";
			String jEXE = "showHideDivByCollSubType('add')";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "หลักประกันย่อย *" + "1 : โฉนด");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "หลักประกันย่อย *" + "1 : โฉนด");
			return false;
		}
		try{
			// Select Type input เลขที่เอกสารสิทธิ์
			String inputAddLandChanote = "addLandChanote";
			new WaitFor().id(inputAddLandChanote);
			driver.findElement(By.id(inputAddLandChanote)).clear();
			driver.findElement(By.id(inputAddLandChanote)).sendKeys(DocLicenseNumber);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "เลขที่เอกสารสิทธิ์ * " + DocLicenseNumber);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "เลขที่เอกสารสิทธิ์ * " + DocLicenseNumber);
			return false;
		}
		try{
			// Select Dropdown เลือกประเทศ
			String inputField = "//*[@id='addLandCountryIdDiv']/div[2]/input";
			String inputValue = "TH : ไทย";
			String selectField = "addLandCountryId";
			String selectValue = "214";
			String jEXE = "populateLandProvince('"+selectValue+"','',true ,'addLandProvinceId','addLandDistrictId','addLandSubDistrictId'); ";
			new Dropdown().id(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "เลือกประเทศ*");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, "เลือกประเทศ*");
			return false;
		}
		try{
			// Select Dropdown เลือกจังหวัด
			String inputField = "//*[@id='addLandProvinceIdDiv']/div[2]/input";
			String inputValue = "001 : ปทุมธานี (ธัญบุรี)";
			String selectField = "addLandProvinceId";
			String selectValue = "8";
			String jEXE = "populateLandDistrict('"+selectValue+"','',true ,'addLandDistrictId','addLandSubDistrictId')";
			new Dropdown().idNoText(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "จังหวัด *" + "001 : ปทุมธานี (ธัญบุรี)");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "จังหวัด *" + "001 : ปทุมธานี (ธัญบุรี)");
			return false;
		} 
		try{
			// Select Dropdown เขต/อำเภอ
			String inputField = "//*[@id='addLandDistrictIdDiv']/div[2]/input";
			String inputValue = "001 : ธัญบุรี (กลางเมือง)";
			String selectField = "addLandDistrictId";
			String selectValue = "640";
			String jEXE = "populateLandSubDistrict('"+selectValue+"','',true ,'addLandSubDistrictId')";
			new Dropdown().idNoText(inputField, inputValue, selectField, selectValue, jEXE);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "จังหวัด *" + "001 : ปทุมธานี (ธัญบุรี)");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "จังหวัด *" + "001 : ปทุมธานี (ธัญบุรี)");
			return false;
		}
		try{
			// Select Dropdown  แขวง/ตำบล
			String inputField = "//*[@id='addLandSubDistrictIdDiv']/div[2]/input";
			String inputValue = "001 : ประชาธิปัตย์ (คลองรังสิตฝั่งเหนือ)";
			String selectField = "addLandSubDistrictId";
			String selectValue = "1";
			//String jEXE = "populateLandSubDistrict('"+selectValue+"','',true ,'addLandSubDistrictId')";
			new Dropdown().idNoText(inputField, inputValue, selectField, selectValue);
			sendToLogCustom(logexestatus.PASS, logaction.Dropdown, "แขวง/ตำบล*" + "001 : ประชาธิปัตย์ (คลองรังสิตฝั่งเหนือ)");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown,  "แขวง/ตำบล *" + "001 : ประชาธิปัตย์ (คลองรังสิตฝั่งเหนือ)");
			return false;
		}
		try{
			// Click Radio ระบุสิ่งปลูกสร้างที่เสร็จแล้ว
			String rdoBuilding = "//*[@id='addBldBuildingNoDiv']/div[2]/input";
			new WaitFor().xpath(rdoBuilding);
			driver.findElement(By.xpath(rdoBuilding)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Radio, "สิ่งปลูกสร้างที่เสร็จแล้ว*");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Radio,  "สิ่งปลูกสร้างที่เสร็จแล้ว*");
			return false;
		}
		try{
			// Type input เลขที่สิ่ปลูกสร้าง
			String bldBuildingNo = "addBldBuildingNo";
			new WaitFor().id(bldBuildingNo);
			driver.findElement(By.id(bldBuildingNo)).clear();
			driver.findElement(By.id(bldBuildingNo)).sendKeys(buildingNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text,  "เลขที่สิ่งปลูกสร้าง * " + buildingNo);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text,  "เลขที่สิ่งปลูกสร้าง * " + buildingNo);
			return false;
		}
		try{
			// Type input รหัสประจำบ้าน
			String bldBuildingID = "addBldBuildingId";
			new WaitFor().id(bldBuildingID);
			driver.findElement(By.id(bldBuildingID)).clear();
			driver.findElement(By.id(bldBuildingID)).sendKeys(buildingID);
			sendToLogCustom(logexestatus.PASS, logaction.Text,  "รหัสประจำบ้าน * " + buildingID);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text,  "รหัสประจำบ้าน * " + buildingID);
			return false;
		}
		try{
			// Type input อาคารที่/หลังที่ *
			String noOfBldBuilding = "addNoOfBldBuilding";
			new WaitFor().id(noOfBldBuilding);
			driver.findElement(By.id(noOfBldBuilding)).clear();
			driver.findElement(By.id(noOfBldBuilding)).sendKeys(noOfBuilding);
			sendToLogCustom(logexestatus.PASS, logaction.Text,  "เลขที่สิ่งปลูกสร้าง * " + noOfBuilding);
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text,  "เลขที่สิ่งปลูกสร้าง * " + noOfBuilding);
			return false;
		}
		try{
			// Click Button SAVE
			String btnSaveColl = "//*[@id='addNewCollateral']/div[51]/button[1]";
			new WaitFor().xpath(btnSaveColl);
			driver.findElement(By.xpath(btnSaveColl)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Text,  "บันทึก");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text,  "บันทึก");
		}
		try{
			// Confirm and SAVE 
			String btnConfirmSAVE = "//*[@id='chooseCollTypeCollSubType']/div[19]/button[1]";
			new WaitFor().xpath(btnConfirmSAVE);
			driver.findElement(By.xpath(btnConfirmSAVE)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Text,  "ยืนยันบันทึก");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text,  "ยืนยันบันทึก");
		}
		sendToLogFinish();
		return true;
	}
	public static String getNum(int point){
		  Random ran = new Random();
		  int low = (int) Math.pow(10, point-1);
		  int high = (int) Math.pow(10, point)-low;
		  int tmp = ran.nextInt(high) + low;
		  return ""+tmp;
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
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Add, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.ConsComment, logtab.RegColl, logsubtab.Add, logelement.None,
				logaction, str);
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

}

