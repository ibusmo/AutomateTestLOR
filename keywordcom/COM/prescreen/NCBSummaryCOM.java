package COM.prescreen;

import base.KeywordsCOM;

public class NCBSummaryCOM extends KeywordsCOM {

	public NCBSummaryCOM(int sheetIndex) {
		super.workSheetPath = "NCB_summary_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.BasiInfo;
		super.logtab 			= log.LogTag.logtab.NCB;
		super.logsubtab 		= log.LogTag.logsubtab.None;

		super.sizeOfData = 11;
		super.offsetRow = 2;

		loadData();
	}

}
