package creditapplication;

import base.KeywordsCOM;

public class ExcutiveSummary extends KeywordsCOM {

	public ExcutiveSummary(int sheetIndex) {
		super.workSheetPath = "excutivesummary_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.BasiInfo;
		super.logtab 			= log.LogTag.logtab.ExcSummary;
		super.logsubtab 		= log.LogTag.logsubtab.None;

		super.sizeOfData = 7;
		super.offsetRow = 2;
		
		loadData();
	}
}
