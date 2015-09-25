package keyword.registerandscnanning;

import keyword.KeywordsCOM;

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
}
