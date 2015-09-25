package keyword.registerandscnanning;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import customcomponent.Dropdown;
import customcomponent.WaitFor;
import keyword.KeywordsCOM;
import output.LogTag.logaction;
import output.LogTag.logexestatus;
import testdata.elementObj;
import testdata.CellTag.inputType;

public class CollacteralAddBuildingCOM extends KeywordsCOM {

	public CollacteralAddBuildingCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addbuilding_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 	= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.Collateral;
		super.logsubtab 		= output.LogTag.logsubtab.AddBuilding;

		super.sizeOfData = 56;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	protected boolean caseDropdown(elementObj obj) {
		try{
			if(obj.jsExe.toUpperCase().matches("SPECIAL")){
				new WaitFor().xpath(obj.fieldOpnal);
				int target = (int) Math.round(Double.parseDouble(obj.value))+1;
				driver.findElement(By.xpath(obj.fieldOpnal)).clear();
				driver.findElement(By.xpath(obj.fieldOpnal)).click();
				for(int i=0;i<target;i++)
					driver.findElement(By.xpath(obj.fieldOpnal)).sendKeys(Keys.DOWN);
				driver.findElement(By.xpath(obj.fieldOpnal)).sendKeys(Keys.ENTER);
				sendToLogCustom(logexestatus.PASS, logaction.DropdownRobot, obj.nameTag + ": " + obj.dataTag);
			}
			else if(obj.inputType==inputType.dropdownx){
				new Dropdown().RunDropdown(obj, true);
				sendToLogCustom(logexestatus.PASS, logaction.DropdownNoText, obj.nameTag + ": " + obj.dataTag);
			}
			else{
				new Dropdown().RunDropdown(obj, false);
				sendToLogCustom(logexestatus.PASS, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
			}
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag);
			return false;
		}catch (InvalidElementStateException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Dropdown, obj.nameTag + ": " + obj.dataTag + " " + e.getMessage());
			return false;			
		}
		return true;
	}
}
