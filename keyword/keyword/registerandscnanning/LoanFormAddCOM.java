package keyword.registerandscnanning;

import keyword.KeywordsCOM;

public class LoanFormAddCOM extends KeywordsCOM {

	public LoanFormAddCOM(int sheetIndex) {
		super.workSheetPath = "loanform_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.LoanForm;
		super.logsubtab 		= output.LogTag.logsubtab.Add;

		super.sizeOfData = 92;
		super.offsetRow = 2;
		
		loadData();
	}
}
