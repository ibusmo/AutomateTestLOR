package creditapplication;

import base.KeywordsCOM;
import testdata.elementObj;

public class LoanFormCOMAddCOM extends KeywordsCOM {

	public LoanFormCOMAddCOM(int sheetIndex) {
		super.workSheetPath = "loanform_com_add_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.LoanFormCOM;
		super.logsubtab 		= log.LogTag.logsubtab.Add;

		super.sizeOfData = 92;
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
