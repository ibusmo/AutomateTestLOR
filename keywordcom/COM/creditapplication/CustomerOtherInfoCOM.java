package COM.creditapplication;

import base.KeywordsCOM;
import testdata.LoadElement;

public class CustomerOtherInfoCOM extends KeywordsCOM {	
	
	public CustomerOtherInfoCOM() {
		initKeywords();
	}	
	
//	1	ข้อมูลอื่นๆ (แบบเต็ม)
//	2	คลิก
//	3	ข้อมูลทั่วไป
//	4	กลุ่มลูกค้า
//	5	ระยะเวลาในการเป็นลูกค้า (ปี)
//	6	ระยะเวลาในการเป็นลูกค้า (เดือน)
//	7	แหล่งที่มาของรายได้
//	8	ความสัมพันธ์ของผู้กู้ร่วมที่มีต่อการกู้
//	9	ความสัมพันธ์ของผู้ค้ำประกันกับผู้กู้หลัก
//	10	จำนวนบุตรทั้งหมด
//	11	จำนวนบุตรที่ทำงานแล้ว
//	12	ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน (ปี)
//	13	ระยะเวลาที่อาศัยในที่อยู่ปัจจุบัน (เดือน)
//	14	ประเภทที่พักอาศัย
//	15	สถานะที่พักอาศัย
//	16	ข้อมูลการทำงาน
//	17	อายุงานปัจจุบัน (ปี)
//	18	อายุงานปัจจุบัน (เดือน)
//	19	อายุงานรวม (ปี)
//	20	อายุงานรวม (เดือน)
//	21	งานพิเศษ
//	22	ข้อมูลคู่สมรส
//	23	เงินเดือน/รายได้คู่สมรส
//	24	ภาษีคู่สมรส
//	25	สินทรัพย์อื่นๆ
//	26	รถยนต์
//	27	มูลค่า
//	28	กรมธรรม์ประกันชีวิต
//	29	มูลค่า
//	30	สลากออมสิน
//	31	มูลค่า
//	32	อสังหาริมทรัพย์
//	33	มูลค่า
//	34	พันธบัตรออมสิน
//	35	มูลค่า
//	36	สมุดเงินฝาก
//	37	มูลค่า
//	38	เลขที่บัญชีเงินฝาก
//	39	มูลค่า
//	40	ธนาคาร
//	41	มูลค่า
//	42	เลขที่บัญชีเงินฝาก
//	43	มูลค่า
//	44	ธนาคาร
//	45	มูลค่า
//	46	คลิก
//	47	
	
	@Override
	public void initKeywords() {		
		logoperation 	= log.LogTag.logoperation.RegScanning;
		logtab 			= log.LogTag.logtab.RegCustomer;
		logsubtab 		= log.LogTag.logsubtab.CIFOtherInfo;

		String workSheetPath = "customer_otherinfo";
		int sizeOfData = 47;
		int offsetRow = 2;

		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		loadData();
	}
}
