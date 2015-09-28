package COM.CMS;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.TimeoutException;

import customcomponent.Click;
import log.LogTag.logaction;
import log.LogTag.logexestatus;
import base.KeywordsCOM;
import testdata.elementObj;
import testdata.CellTag.fieldType;

public class CMSBase extends KeywordsCOM{

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected boolean caseButton(elementObj obj) {
		try{
			// Force to save draft
			if(obj.dataTag.toUpperCase().contains("DRAFT")){
				executor.executeScript("selectPage('doSaveDraft')", driver.findElement(By.id("content")));
				//new Click().RunButton(obj);
				sendToLogCustom(logexestatus.PASS, logaction.Draft, obj.nameTag + ": " + obj.dataTag);
			}
			// Force to save
			else if(obj.dataTag.toUpperCase().contains("DONE")){
				executor.executeScript("selectPage('doSave')", driver.findElement(By.id("content")));
				new Click().RunButton(obj);
				sendToLogCustom(logexestatus.PASS, logaction.Save, obj.nameTag + ": " + obj.dataTag);
			}
			// Force to OK
			else if(obj.dataTag.toUpperCase().contains("OK")){
				executor.executeScript("selectPage('OK')", driver.findElement(By.id("content")));
				new Click().RunButton(obj);
				sendToLogCustom(logexestatus.PASS, logaction.OK, obj.nameTag + ": " + obj.dataTag);
			}
			// General Button
			else{
				new Click().RunButton(obj);
				sendToLogCustom(logexestatus.PASS, logaction.Click, obj.nameTag + ": " + obj.dataTag);
			}
		}catch (TimeoutException e){
			if(obj.filedType == fieldType.linktext)	{
				//Nothing TO DO
				sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag);
			}
			else if(obj.dataTag.toUpperCase().contains("DRAFT")){
				//Nothing TO DO
				sendToLogCustom(logexestatus.FAIL, logaction.Draft, obj.nameTag + ": " + obj.dataTag);
			}
			else if(obj.dataTag.toUpperCase().contains("DONE")){
				//Nothing TO DO
				sendToLogCustom(logexestatus.FAIL, logaction.Save, obj.nameTag + ": " + obj.dataTag);
			}
			else if(obj.dataTag.toUpperCase().contains("OK")){
				//Nothing TO DO
				sendToLogCustom(logexestatus.FAIL, logaction.OK, obj.nameTag + ": " + obj.dataTag);
			}else{
				sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag);
				return false;
			}
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}
		return true;
	}
}
