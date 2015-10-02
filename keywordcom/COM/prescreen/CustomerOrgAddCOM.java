package COM.prescreen;

import base.KeywordsCOM;

public class CustomerOrgAddCOM extends KeywordsCOM {
	
	public CustomerOrgAddCOM(int sheetIndex) {
		super.workSheetPath = "customer_org_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.RegCustomerOrg;
		super.logsubtab 		= log.LogTag.logsubtab.Add;

		super.sizeOfData = 51;
		super.offsetRow = 2;

		loadData();
	}
		
}
