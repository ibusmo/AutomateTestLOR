package keyword.registerandscnanning;

import keyword.KeywordsCOM;

public class CollacteralAddAccountingCOM extends KeywordsCOM {
	
	public CollacteralAddAccountingCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addaccounting_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.Collateral;
		super.logsubtab 		= output.LogTag.logsubtab.AddAccounting;

		super.sizeOfData = 39;
		super.offsetRow = 2;

		loadData();
	}
}
