package COM.prescreen;

import base.KeywordsCOM;
import testdata.ConfigElementObj;

public class CollacteralAddAccountingCOM extends KeywordsCOM {
	
	//Not use
	int collacteralIndex;

	//Not use
	public CollacteralAddAccountingCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "collateral_addaccounting_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	//Not use
	public CollacteralAddAccountingCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "collateral_addaccounting_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
	}
	
	public CollacteralAddAccountingCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addaccounting_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.Collateral;
		super.logsubtab 		= log.LogTag.logsubtab.AddAccounting;

		super.sizeOfData = 39;
		super.offsetRow = 2;

		loadData();
	}
}
