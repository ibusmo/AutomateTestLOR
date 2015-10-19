package creditapplication;

import base.KeywordsCOM;
import testdata.ConfigElementObj;

public class CollacteralAddWarranterCOM extends KeywordsCOM {
	
	//Not use
	int collacteralIndex;

	//Not use
	public CollacteralAddWarranterCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "collateral_addwarranter_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	//Not use
	public CollacteralAddWarranterCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "collateral_addwarranter_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
		initKeywords();
	}
	
	public CollacteralAddWarranterCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addwarranter_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.Collateral;
		super.logsubtab 		= log.LogTag.logsubtab.AddWarranter;

		super.sizeOfData = 186;
		super.offsetRow = 2;

		loadData();
	}
}
