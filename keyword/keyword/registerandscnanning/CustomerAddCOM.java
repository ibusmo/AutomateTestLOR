package keyword.registerandscnanning;

import keyword.KeywordsCOM;

public class CustomerAddCOM extends KeywordsCOM {
	
	public CustomerAddCOM(int sheetIndex) {
		super.workSheetPath = "customer_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.RegScanning;
		super.logtab 			= output.LogTag.logtab.RegCustomer;
		super.logsubtab 		= output.LogTag.logsubtab.Add;

		super.sizeOfData = 177;
		super.offsetRow = 2;

		loadData();
	}
		
}