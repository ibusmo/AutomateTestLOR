package COM.prescreen;

import base.KeywordsCOM;
import testdata.LoadElement;

public class CustomerSalaryCOM extends KeywordsCOM {

	public CustomerSalaryCOM() {
		initKeywords();
	}	
	
//	1	รายได้จากเงินเดือน
//	2	คลิก
//	3	1. รายได้ประจำ
//	4	จำนวนพนักงานในบริษัท
//	5	อายุงานในปัจจุบัน(กรณีเงินเดือน) (ปี)
//	6	อายุงานในปัจจุบัน(กรณีเงินเดือน) (เดือน)
//	7	1.1 รายได้สุทธิจากเงินเดือน
//	8	อัตราเงินเดือน
//	9	หัก รายการที่ไม่ใช่ภาระหนี้
//	10	ค่าภาษี
//	11	ค่าประกันสังคม
//	12	กองทุนสำรองเลี้ยงชีพ
//	13	ค่าหุ้นสหกรณ์
//	14	ฌอส.
//	15	อื่นๆ
//	16	ระบุรายละเอียด
//	17	รายได้สุทธิจากเงินเดือน
//	18	1.2  เงินได้ประจำอื่น ๆ
//	19	เงินประจำตำแหน่ง
//	20	เงินเบิกค่าเช่าบ้าน
//	21	ค่ารับรอง
//	22	ค่าครองชีพ/ค่าอาหาร /ค่าช่วยเหลือบุตร
//	23	ค่าพาหนะ /ค่าน้ำมัน
//	24	ค่าวิชาชีพ/วิทยฐานะ
//	25	อื่นๆ
//	26	ระบุรายละเอียด
//	27	รวมรายได้ประจำทั้งสิ้น (1.1 + 1.2) *
//	28	2. เงินได้อื่น ๆ ที่มีหลักฐาน
//	29	ค่า Commission
//	30	ค่า OT / ค่าเบี้ยขยัน
//	31	โบนัส
//	32	เงินปันผล/ดอกเบี้ยรับ
//	33	รายได้เสริมสุทธิ (ไม่มีต้นทุน)
//	34	อื่นๆ
//	35	ระบุรายละเอียด
//	36	รวมเงินได้อื่น ๆ
//	37	คลิก
//	38	

	@Override
	public void initKeywords() {
		logoperation 	= log.LogTag.logoperation.RegScanning;
		logtab 			= log.LogTag.logtab.RegCustomer;
		logsubtab 		= log.LogTag.logsubtab.CIFSalary;

		String workSheetPath = "customer_incomefromsalary";
		int sizeOfData = 38;
		int offsetRow = 2;

		regData = new LoadElement(workSheetPath, sizeOfData, offsetRow);
		loadData();
	}

}
