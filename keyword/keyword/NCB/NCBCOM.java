package keyword.NCB;

import keyword.KeywordsCOM;

public class NCBCOM extends KeywordsCOM {

	public NCBCOM(int sheetIndex) {
		super.workSheetPath = "NCB_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.NCB;
		super.logsubtab 		= output.LogTag.logsubtab.None;

		super.sizeOfData = 8;
		super.offsetRow = 2;

		loadData();
	}

}
