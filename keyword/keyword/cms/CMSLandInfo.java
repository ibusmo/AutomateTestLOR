package keyword.cms;

import keyword.Keywords;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CMSLandInfo implements Keywords{
	private String landNo = getNum(5);
	private String landBkNo = getNum(5);
	private String landPageNo = getNum(3);
	private String landRavang = getNum(5);
	private String landDocPageNo = getNum(3);
	private String landLndVol1 = getNum(2);
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		sendToLogStart();
		try{
			// Click Sub-tab ข้อมูลที่ดิน
			String linkSubtab = "ข้อมูลที่ดิน";
			new WaitFor().linkText(linkSubtab);
			driver.findElement(By.linkText(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab ข้อมูลที่ดิน ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab ข้อมูลที่ดิน ");
			return false;
		}
		try{
			// Type input เลขที่ดิน
			String inputLandNo = "landNumber";
			new WaitFor().name(inputLandNo);
			driver.findElement(By.name(inputLandNo)).clear();
			driver.findElement(By.name(inputLandNo)).sendKeys(landNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input เลขที่ดิน");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input  เลขที่ดิน");
			return false;
		}
		try{
			// Type input เลขที่
			String inputLandBkNo = "landBkNo";
			new WaitFor().name(inputLandBkNo);
			driver.findElement(By.name(inputLandBkNo)).clear();
			driver.findElement(By.name(inputLandBkNo)).sendKeys(landBkNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input เลขที่ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input เลขที่ ");
			return false;
		}
		try{
			// Type input หน้าที่
			String inputlandPageNo = "landPageNo";
			new WaitFor().name(inputlandPageNo);
			driver.findElement(By.name(inputlandPageNo)).clear();
			driver.findElement(By.name(inputlandPageNo)).sendKeys(landPageNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input หน้าที่");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input หน้าที่");
			return false;
		}
		try{
			// Type input เลขที่ระวาง
			String inputlandRavang = "landRavang";
			new WaitFor().name(inputlandRavang);
			driver.findElement(By.name(inputlandRavang)).clear();
			driver.findElement(By.name(inputlandRavang)).sendKeys(landRavang);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input เลขที่ระวาง");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input เลขที่ระวาง");
			return false;
		}
		try{
			// Type input หน้าสำรวจ
			String inputlandDocPageNo = "landDocPageNo";
			new WaitFor().name(inputlandDocPageNo);
			driver.findElement(By.name(inputlandDocPageNo)).clear();
			driver.findElement(By.name(inputlandDocPageNo)).sendKeys(landDocPageNo);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input หน้าสำรวจ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input หน้าสำรวจ");
			return false;
		}
		try{
			// Type input เนื้อที่
			String inputlandLndVol1 = "landLndVol1";
			new WaitFor().id(inputlandLndVol1);
			driver.findElement(By.id(inputlandLndVol1)).clear();
			driver.findElement(By.id(inputlandLndVol1)).sendKeys(landLndVol1);
			sendToLogCustom(logexestatus.PASS, logaction.Text, "Type input เนื้อที่ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, "Type input เนื้อที่ ");
			return false;
		}
		try{
			// Click SAVE
			/*
			String btnSave = "//*[@id='content']/div/form/div/table[3]/tbody/tr[5]/td/input[1]";
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
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.LandInfo, logelement.None,
				logaction, null);
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.CMS, logtab.CollInfo, logsubtab.LandInfo, logelement.None,
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

	public static String getNum(int point){
		  Random ran = new Random();
		  int low = (int) Math.pow(10, point-1);
		  int high = (int) Math.pow(10, point)-low;
		  int tmp = ran.nextInt(high) + low;
		  return ""+tmp;
	}

}
