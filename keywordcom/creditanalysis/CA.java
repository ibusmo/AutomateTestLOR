package creditanalysis;

import org.openqa.selenium.By;

import base.KeywordsCOM;
import testdata.elementObj;
import testdata.CellTag.inputType;

public class CA extends KeywordsCOM {
	
	public CA() {
		super.workSheetPath = "CA";
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.CA;
		super.logtab 			= log.LogTag.logtab.CA;
		super.logsubtab 		= log.LogTag.logsubtab.info;

		super.sizeOfData = 54;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	protected void precondition(elementObj obj) {
		if(obj.inputType==inputType.button){
			if(obj.dataTag.contains("บันทึก")){
				String tmp = driver.findElement(By.xpath(obj.fieldName)).getText();
				//System.out.println(tmp);
				obj.run = tmp.contains("บันทึก") ? true : false;
			}
		}
	}
}
