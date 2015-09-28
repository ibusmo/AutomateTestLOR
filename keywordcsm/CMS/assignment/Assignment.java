package CMS.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import customcomponent.WaitFor;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import base.KeywordsCSM;

public class Assignment implements KeywordsCSM {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Click มอบหมายงาน Tab
			String btnAssign = "มอบหมายงาน";
			new WaitFor().linkText(btnAssign);
			driver.findElement(By.linkText(btnAssign)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Click, "มอบหมายงาน Tab");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "มอบหมายงาน Tab");
			return false;
		}
		try{
			// CheckBox สุรชัย ตันติกรกุล
			String target = "SurachaiT1";
			int idx = 3;
			for(int i=0;i<4;i++){
				String checkBoxAssign = "roleForAssignBOList[0].userBOList["+i+"].checkFlag";
				new WaitFor().name(checkBoxAssign);
				String checkBoxUser = "roleForAssignBOList[0].userBOList["+i+"].userCode";
				String getName = driver.findElement(By.name(checkBoxUser)).getAttribute("value");
				//System.out.println(getName);
				if(target.matches(getName)){
					idx = i;
					//System.out.println(idx);	
					break;
				}
			}
			String checkBoxAssign = "roleForAssignBOList[0].userBOList["+idx+"].checkFlag";
			String isChecked = "false";
			try{
				isChecked = driver.findElement(By.name(checkBoxAssign)).getAttribute("checked");
				if(isChecked==null)	isChecked = "false";
				//System.out.println(isChecked);			
			}catch(NullPointerException e){
				isChecked = "false";
			}
			if(!isChecked.matches("true")){
				driver.findElement(By.name(checkBoxAssign)).click();
			}
			sendToLogCustom(logexestatus.PASS, logaction.Checkbox, "สุรชัย ตันติกรกุล");
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Checkbox, "สุรชัย ตันติกรกุล");
			return false;
		}
		try{
			//Button Click บันทึก
			String buttonSave = "btnSave";
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(buttonSave)));
			driver.findElement(By.id(buttonSave)).click();
			sendToLogCustom(logexestatus.PASS, logaction.Save, "บันทึก");
		}catch(TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Save, "บันทึก");
			return false;
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
		logCat.sendToLog(logexestatus, logoperation.Assigment, logtab.Assignment, logsubtab.None, logelement.None,
				logaction, null);
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.Assigment, logtab.Assignment, logsubtab.None, logelement.None,
				logaction, str);
	}
}
