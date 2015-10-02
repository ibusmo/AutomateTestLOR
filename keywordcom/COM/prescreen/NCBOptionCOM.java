package COM.prescreen;

import base.KeywordsCOM;

public class NCBOptionCOM extends KeywordsCOM {

	public NCBOptionCOM(int sheetIndex) {
		super.workSheetPath = "NCB_option_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.NCB;
		super.logsubtab 		= log.LogTag.logsubtab.None;

		super.sizeOfData = 8;
		super.offsetRow = 2;

		loadData();
	}

}
