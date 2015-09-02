package keyword.cms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import customcomponent.WaitFor;
import output.LogTag.logaction;
import output.LogTag.logexestatus;

public class CMSLandInfo extends BaseCMS  {
	private String landNo = "325";
	private String landBkNo = "123";
	private String landPageNo = "789";
	private String landRavang = "529";
	private String landDocPageNo = "883";
	private String landLndVol1 = "909";
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		sendToLogStart();
		try{
			// Click Sub-tab ¢éÍÁÙÅ·Õè´Ô¹
			String linkSubtab = "¢éÍÁÙÅ·Õè´Ô¹";
			new WaitFor().xpath(linkSubtab);
			driver.findElement(By.xpath(linkSubtab)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click Subtab ¢éÍÁÙÅ·Õè´Ô¹ ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click Subtab ¢éÍÁÙÅ·Õè´Ô¹ ");
			return false;
		}
		try{
			// Type input àÅ¢·Õè´Ô¹
			String inputLandNo = "//*[@id='content']/div/form/div/table[1]/tbody/tr[1]/td[4]/input";
			new WaitFor().xpath(inputLandNo);
			driver.findElement(By.xpath(inputLandNo)).sendKeys(landNo);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input àÅ¢·Õè´Ô¹");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input  àÅ¢·Õè´Ô¹");
			return false;
		}
		try{
			// Type input àÅ¢·Õè
			String inputLandBkNo = "//*[@id='content']/div/form/div/table[1]/tbody/tr[2]/td[2]/input";
			new WaitFor().xpath(inputLandBkNo);
			driver.findElement(By.xpath(inputLandBkNo)).sendKeys(landBkNo);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input àÅ¢·Õè ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input àÅ¢·Õè ");
			return false;
		}
		try{
			// Type input Ë¹éÒ·Õè
			String inputlandPageNo = "//*[@id='content']/div/form/div/table[1]/tbody/tr[2]/td[4]/input";
			new WaitFor().xpath(inputlandPageNo);
			driver.findElement(By.xpath(inputlandPageNo)).sendKeys(landPageNo);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input Ë¹éÒ·Õè");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input Ë¹éÒ·Õè");
			return false;
		}
		try{
			// Type input àÅ¢·ÕèÃÐÇÒ§
			String inputlandRavang = "//*[@id='content']/div/form/div/table[1]/tbody/tr[3]/td[2]/input";
			new WaitFor().xpath(inputlandRavang);
			driver.findElement(By.xpath(inputlandRavang)).sendKeys(landRavang);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input àÅ¢·ÕèÃÐÇÒ§");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input àÅ¢·ÕèÃÐÇÒ§");
			return false;
		}
		try{
			// Type input Ë¹éÒÊÓÃÇ¨
			String inputlandDocPageNo = "//*[@id='content']/div/form/div/table[1]/tbody/tr[3]/td[4]/input";
			new WaitFor().xpath(inputlandDocPageNo);
			driver.findElement(By.xpath(inputlandDocPageNo)).sendKeys(landDocPageNo);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input Ë¹éÒÊÓÃÇ¨");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input Ë¹éÒÊÓÃÇ¨");
			return false;
		}
		try{
			// Type input à¹×éÍ·Õè
			String inputlandLndVol1 = "landLndVol1";
			new WaitFor().id(inputlandLndVol1);
			driver.findElement(By.id(inputlandLndVol1)).sendKeys(landLndVol1);
			sendToLogCustom(logexestatus.PASS, logaction.Type, "Type input à¹×éÍ·Õè ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Type, "Type input à¹×éÍ·Õè ");
			return false;
		}
		try{
			// Click SAVE
			String btnSave = "//*[@id='content']/div/form/div/table[2]/tbody/tr[5]/td/input[1]";
			new WaitFor().id(btnSave);
			driver.findElement(By.id(btnSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "Click SAVE ");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "Click SAVE ");
			return false;
		}
		sendToLogFinish();
		return true;
	}
}
