package keyword.registerandscnanning;

import keyword.KeywordsCOM;

public class CollacteralAddWarranter extends KeywordsCOM {
	
	public CollacteralAddWarranter(int sheetIndex) {
		super.workSheetPath = "collateral_addwarranter_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.Collateral;
		super.logsubtab 		= output.LogTag.logsubtab.AddWarranter;

		super.sizeOfData = 186;
		super.offsetRow = 2;

		loadData();
	}
}
