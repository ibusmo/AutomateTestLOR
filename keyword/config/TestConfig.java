package config;

import java.util.List;

import output.LogCat;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;
import testdata.LoadElement;
import testdata.ReadExcel;
import testdata.TestDatas;
import testdata.CellTag.col;

public class TestConfig implements TestDatas{

	private LogCat logCat = LogCat.getInstance();
	private LoadElement regData;
	public List<ConfigElementObj> configElementObj;
	
	private logoperation logoperation;
	
	private String workSheetPath;
	private int sizeOfData;
	private int offsetRow;
	
	public TestConfig(){
		logoperation 	= output.LogTag.logoperation.Config;
		workSheetPath = "config";

		sizeOfData = getSize();
		offsetRow = 2;
	}

	public boolean loadData(){
		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		if(regData.loadConfigData()){
			configElementObj = regData.getConfigObject();
			sendToLogCustom(logexestatus.PASS, logaction.LoadData, null);
		}else{
			sendToLogCustom(logexestatus.FAIL, logaction.LoadData, null);		
			return false;	
		}
		return true;
	}
	
	private int getSize() {
		ReadExcel rdExl = new ReadExcel(workBookPath, workSheetPath);
		System.out.print(rdExl.getString(col.A, row(1)) + "\t");
		int size 		= (int) Math.round(Double.parseDouble(rdExl.getString(col.A, row(1))));
		System.out.println(size);
		rdExl.closeFile();
		return size;
	}
	
	private int row(int r){
		return r + offsetRow;
	}
	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation, logtab.None, logsubtab.None, logelement.None,
				logaction, str);
	}
}
