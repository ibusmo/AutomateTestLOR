package keyword.registerandscnanning;

import keyword.KeywordsCOM;
import testdata.LoadElement;

public class CustomerNonNCBCOM extends KeywordsCOM {
	
	public CustomerNonNCBCOM() {
		initKeywords();
	}
	
//	1	Non NCB
//	2	คลิก
//	3	หนี้สินที่ไม่ได้รายงานต่อ NCB
//	4	วันที่ของข้อมูล
//	5	รวมภาระหนี้สินทั้งหมด
//	6	กรณีคำขอครั้งนี้เป็นการ Refinance
//	7	ภาระการผ่อนหนี้เดิม
//	8	ความเห็นเพิ่มเติม
//	9	คลิก
//	10	
	
	@Override
	public void initKeywords() {
		logoperation 	= output.LogTag.logoperation.RegScanning;
		logtab 			= output.LogTag.logtab.RegCustomer;
		logsubtab 		= output.LogTag.logsubtab.CIFNonNCB;

		String workSheetPath = "customer_nonncb";
		int sizeOfData = 10;
		int offsetRow = 2;

		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		loadData();
	}

}
