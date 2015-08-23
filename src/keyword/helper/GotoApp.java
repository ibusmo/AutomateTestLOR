package keyword.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import keyword.Keywords;

public class GotoApp implements Keywords {

	private String appID;
	
	public GotoApp(String appID) {
		this.appID = appID;
	}

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		try{
			//Click WorkBox Tab
			String btnWorkBoxTab = "//*[@id='menu-vertical']/ul/li[1]/div/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnWorkBoxTab)));
			driver.findElement(By.xpath(btnWorkBoxTab)).click();
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Click\t\t -WorkBox Tab");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Click\t\t -WorkBox Tab");
			return false;
		}
		try{
			//Click PersonalWorkBox SubTab
			String btnPersonalWorkBoxTab = "//*[@id='101']/a";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnPersonalWorkBoxTab)));
			driver.findElement(By.xpath(btnPersonalWorkBoxTab)).click();
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Click\t\t -PersonalWorkBox Subtab");
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Click\t\t -PersonalWorkBox Subtab");
			return false;
		}
		try{
			//Search AppID เลขที่ใบคำขอ
			//Radio Button เลขที่ใบคำขอ
			String radioSearchType = "selectedSearchType"; //name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(radioSearchType)));
			List<WebElement> radios = driver.findElements(By.name(radioSearchType));
			radios.get(1).click();
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Radio\t\t -selectedSearchType\t -เลขที่ใบคำขอ");
			//Input Text เลขที่ใบคำขอ
			String textsearchAppId = "searchAppId"; //name
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(textsearchAppId)));
			driver.findElement(By.name(textsearchAppId)).sendKeys(appID);
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Input Text\t -textsearchAppId\t -เลขที่ใบคำขอ");
			//Button Click ค้นหา
			String buttonSearch = "//*[@id='content']/div/div/form/div[2]/button";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buttonSearch)));
			driver.findElement(By.xpath(buttonSearch)).click();			
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Button click\t -Search\t\t -ค้นหา");
			//Link Click AppID
			String buttonAppID = appID;
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(buttonAppID)));
			driver.findElement(By.linkText(buttonAppID)).click();			
			logCat.sendToLog("[PASS]\t {WorkBox}\t -Link click\t -AppID\t\t\t -" + appID);
		}catch (TimeoutException e){
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Radio]\t\t -selectedSearchType\t -เลขที่ใบคำขอ");
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Input Text\t -textsearchAppId\t -เลขที่ใบคำขอ");
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Button click\t -Search\t\t -ค้นหา");
			logCat.sendToLog("[FAIL]\t {WorkBox}\t -Link click\t -AppID\t\t\t -" + appID);
			return false;
		}
		sendToLogFinish();
		return true;
	}

	@Override
	public boolean sendToLogStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean sendToLogFinish() {
		logCat.sendToLog("[PASS]\t {WorkBox}\t -Already open WorkBox");
		return false;
	}
}
