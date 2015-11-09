package autocms;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import customcomponent.WaitFor;
import testdata.elementObj;

public class CMSLandBuilding extends CMSBase{
	
	//This is default
	public CMSLandBuilding(){
		super.workSheetPath = "cms_landbuilding";
		super.logtab 			= log.LogTag.logtab.LandBuilding;
		super.logsubtab 		= log.LogTag.logsubtab.Evaluate;
		initKeywords();
	}
	
	public CMSLandBuilding(int sheetIndex){
		super.workSheetPath = "cms_landbuilding_" + sheetIndex;
		initKeywords();
	}

	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.CMS;
		super.logtab 			= log.LogTag.logtab.LandBuilding;
		super.logsubtab 		= log.LogTag.logsubtab.Evaluate;
		
		super.sizeOfData = 122;
		super.offsetRow = 2;

		loadData();
	}	
	
	@Override
	public boolean execute() {
		sendToLogStart();
		//for(elementObj obj : elementObjList){
		for(int index=0;index<super.sizeOfData;index++){
			elementObj obj = super.elementObjList.get(index);
			if(index == 30){
				new WaitFor().linkText("แก้ไข");
				List<WebElement> editButton = driver.findElements(By.linkText("แก้ไข"));
				int numberOfEditRows = editButton.size();
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXx");
				System.out.println(numberOfEditRows);
				for(int loop=0;loop<numberOfEditRows;loop++){
					new WaitFor().linkText("แก้ไข");
					editButton = driver.findElements(By.linkText("แก้ไข"));
					editButton.get(loop).click();
					for(int subIndex=30;subIndex<=64;subIndex++){
						elementObj subObj = super.elementObjList.get(subIndex);
						if(subObj.run==false) continue;
						switch(subObj.inputType){
						case button:
							if(caseButton(subObj)==false) 
								return false;
							break;
						case dropdown:
						case dropdownx:
							if(caseDropdown(subObj)==false)
								return false;
							break;
						case text:
							if(caseText(subObj)==false) 
								return false;
							break;
						case radio:
							if(caseRadio(subObj)==false) 
								return false;
							break;
						case checkbox:
							if(caseCheckbox(subObj)==false) 
								return false;
							break;
						case date:
							if(caseDate(subObj)==false) 
								return false;
							break;
						case popup:
							if(casePopup(subObj)==false) 
								return false;
							break;
						case alert:
							if(caseAlert(subObj)==false) 
								return false;
							break;
						default:
							break;
						}
					}
				}
				index=65;
			}
			if(obj.run==false) continue;
			switch(obj.inputType){
			case button:
				if(caseButton(obj)==false) 
					return false;
				break;
			case dropdown:
			case dropdownx:
				if(caseDropdown(obj)==false)
					return false;
				break;
			case text:
				if(caseText(obj)==false) 
					return false;
				break;
			case radio:
				if(caseRadio(obj)==false) 
					return false;
				break;
			case checkbox:
				if(caseCheckbox(obj)==false) 
					return false;
				break;
			case date:
				if(caseDate(obj)==false) 
					return false;
				break;
			case popup:
				if(casePopup(obj)==false) 
					return false;
				break;
			case alert:
				if(caseAlert(obj)==false) 
					return false;
				break;
			default:
				break;
			}
		}
		
		sendToLogFinish();
		return true;
	}
}
