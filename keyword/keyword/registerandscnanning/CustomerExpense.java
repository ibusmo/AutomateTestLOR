package keyword.registerandscnanning;

import keyword.KeywordsCOM;
import testdata.LoadElement;

public class CustomerExpense extends KeywordsCOM {
	
	public CustomerExpense() {
		initKeywords();
	}
	
//	1	ค่าใช้จ่าย
//	2	คลิก
//	3	ค่าใช้จ่ายทั่วไป
//	4	ค่าใช้จ่ายอุปโภคบริโภค
//	5	ค่าใช้จ่ายที่พักอาศัย
//	6	ค่าใช้จ่ายอื่นๆ
//	7	ระบุรายละเอียด
//	8	รวมค่าใช้จ่าย
//	9	คลิก
//	10	

	@Override
	public void initKeywords() {
		logoperation 	= output.LogTag.logoperation.RegScanning;
		logtab 			= output.LogTag.logtab.RegCustomer;
		logsubtab 		= output.LogTag.logsubtab.CIFExpense;

		String workSheetPath = "customer_expense";
		int sizeOfData = 10;
		int offsetRow = 2;

		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		loadData();
	}
	
}
