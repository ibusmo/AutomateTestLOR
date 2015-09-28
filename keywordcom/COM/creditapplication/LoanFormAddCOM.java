package COM.creditapplication;

import base.KeywordsCOM;

public class LoanFormAddCOM extends KeywordsCOM {

	public LoanFormAddCOM(int sheetIndex) {
		super.workSheetPath = "loanform_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.LoanForm;
		super.logsubtab 		= log.LogTag.logsubtab.Add;

		super.sizeOfData = 92;
		super.offsetRow = 2;
		
		loadData();
	}
}
