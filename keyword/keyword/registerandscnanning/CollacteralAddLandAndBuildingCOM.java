package keyword.registerandscnanning;

import keyword.KeywordsCOM;

public class CollacteralAddLandAndBuildingCOM extends KeywordsCOM {

	public CollacteralAddLandAndBuildingCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addlandandbuilding_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 	= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.Collateral;
		super.logsubtab 		= output.LogTag.logsubtab.AddLandBuilding;

		super.sizeOfData = 74;
		super.offsetRow = 2;

		loadData();
	}
}
