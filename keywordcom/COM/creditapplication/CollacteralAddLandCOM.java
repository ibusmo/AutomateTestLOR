package COM.creditapplication;

import base.KeywordsCOM;
import testdata.ConfigElementObj;

public class CollacteralAddLandCOM extends KeywordsCOM {

	//Not use
	int collacteralIndex;

	//Not use
	public CollacteralAddLandCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "collateral_addland_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	//Not use
	public CollacteralAddLandCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "collateral_addland_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
	}
	
	//Use
	public CollacteralAddLandCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addland_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 	= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.Collateral;
		super.logsubtab 		= log.LogTag.logsubtab.AddLand;

		super.sizeOfData = 37;
		super.offsetRow = 2;

		loadData();
	}
}
