package keyword.registerandscnanning;

import java.util.Random;

import org.openqa.selenium.TimeoutException;

import customcomponent.Type;
import keyword.KeywordsCOM;
import output.LogTag.logaction;
import output.LogTag.logexestatus;
import testdata.elementObj;

public class CollacteralAddLandCOM extends KeywordsCOM {

	public CollacteralAddLandCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addland_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 	= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.Collateral;
		super.logsubtab 		= output.LogTag.logsubtab.AddLand;

		super.sizeOfData = 37;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	protected boolean caseText(elementObj obj) {
		//@Override Method for GENERATE NUMBER
		try{
			obj.dataTag = obj.value!="" && obj.value!="null" ? getNum((int)Math.round(Double.parseDouble(obj.value))) : obj.value;
			new Type().RunText(obj);
			sendToLogCustom(logexestatus.PASS, logaction.Text, obj.nameTag + ": " + obj.dataTag);
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Text, obj.nameTag + ": " + obj.dataTag);
			return false;
		}
		return true;
	}
	
	private String getNum(int point){
		  Random ran = new Random();
		  int low = (int) Math.pow(10, point-1);
		  int high = (int) Math.pow(10, point)-low;
		  int tmp = ran.nextInt(high) + low;
		  return ""+tmp;
	}
}
