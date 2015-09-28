package COM.creditapplication;

import base.KeywordsCOM;
import testdata.LoadElement;

public class CustomerCareerCOM extends KeywordsCOM {

	public CustomerCareerCOM() {
		initKeywords();
	}
	
//	1	รายได้จากการประกอบอาชีพ
//	2	คลิก
//	3	iSiG Group
//	4	ประเภทธุรกิจ 1 *
//	5	ประเภทธุรกิจ 2 *
//	6	ประเภทธุรกิจ 3 *
//	7	จำนวนพนักงาน *
//	8	ระยะเวลาในการทำธุรกิจ/อาชีพอิสระ(กรณีธุรกิจ) (ปี)
//	9	ระยะเวลาในการทำธุรกิจ/อาชีพอิสระ(กรณีธุรกิจ) เดือน
//	10	กรรมสิทธิ์ในสถานที่ประกอบการ
//	11	ลักษณะสถานที่ประกอบการ
//	12	รายได้ของกิจการ/อาชีพอิสระ
//	13	รายได้
//	14	รายได้อื่นๆ จากธุรกิจ
//	15	ระบุรายละเอียด
//	16	รวมรายได้
//	17	ค่าใช้จ่าย
//	18	ค่าใช้จ่าย (%, จำนวนเงิน)
//	19	ค่าใช้จ่ายซื้อสินค้าและบริการ * (%)
//	20	ค่าใช้จ่ายซื้อสินค้าและบริการ *
//	21	เงินเดือนคนงาน
//	22	ค่าเช่าสถานที่ประกอบการ
//	23	ค่าน้ำ ค่าไฟ ค่าโทรศัพท์
//	24	ค่าใช้จ่ายอื่นๆ
//	25	รวมค่าใช้จ่าย
//	26	กำไรสุทธิ/ขาดทุนสุทธิ
//	27	กำไรขั้นต้น
//	28	ดอกเบี้ย
//	29	กำไรก่อนหักภาษี
//	30	ภาษี
//	31	กำไรสุทธิ
//	32	สัดส่วนผู้ถือหุ้น(ผู้กู้) (%)
//	33	สัดส่วนผู้ถือหุ้น(ผู้กู้)
//	34	คลิก
//	35	

	@Override
	public void initKeywords() {
		logoperation 	= log.LogTag.logoperation.RegScanning;
		logtab 			= log.LogTag.logtab.RegCustomer;
		logsubtab 		= log.LogTag.logsubtab.CIFCareer;

		String workSheetPath = "customer_incomefromcareer";
		int sizeOfData = 35;
		int offsetRow = 2;

		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		loadData();
	}
}
