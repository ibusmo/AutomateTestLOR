package creditapplication;

import base.KeywordsCOM;
import testdata.elementObj;

public class LoanFormDDAAddCOM extends KeywordsCOM {

	public LoanFormDDAAddCOM(int sheetIndex) {
		super.workSheetPath = "loanform_dda__add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.LoanFormDDA;
		super.logsubtab 		= log.LogTag.logsubtab.Add;

		super.sizeOfData = 100;
		super.offsetRow = 2;
		
		loadData();
	}

	@Override
	protected void precondition(elementObj obj) {
//		if(obj.fieldType == fieldType.linktext){
//			if(obj.fieldName.contains("คำขอสินเชื่อ")){
//				obj.fieldName = "New คำขอสินเชื่อ (สำหรับRM/BRO)";
//			}
//		}
	}
}
