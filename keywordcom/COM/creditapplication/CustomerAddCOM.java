package COM.creditapplication;

import base.KeywordsCOM;

public class CustomerAddCOM extends KeywordsCOM {
	
	public CustomerAddCOM(int sheetIndex) {
		super.workSheetPath = "customer_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.RegCustomer;
		super.logsubtab 		= log.LogTag.logsubtab.Add;

		super.sizeOfData = 177;
		super.offsetRow = 2;

		loadData();
	}
		
}
