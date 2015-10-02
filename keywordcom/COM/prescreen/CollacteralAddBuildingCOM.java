package COM.prescreen;

import base.KeywordsCOM;
import testdata.ConfigElementObj;
import testdata.elementObj;
import testdata.CellTag.inputType;

public class CollacteralAddBuildingCOM extends KeywordsCOM {

	int collacteralIndex;
	
	public CollacteralAddBuildingCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "collateral_addbuilding_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	public CollacteralAddBuildingCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "collateral_addbuilding_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
	}

	@Override
	public void initKeywords() {
		super.logoperation 	= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.Collateral;
		super.logsubtab 		= log.LogTag.logsubtab.AddBuilding;

		super.sizeOfData = 56;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	protected void precondition(elementObj obj) {
		if(obj.inputType==inputType.radio){
			if(obj.dataTag.contains("เลขที่เอกสารสิทธิ์")){
				int radioPosition = collacteralIndex - 1;
				obj.value = radioPosition + "";
			}
		}
		else if(obj.inputType==inputType.button){
			if(obj.dataTag.contains("ดูรายละเอียด")){
				int xpathPosition = collacteralIndex + 1;
				obj.fieldName = obj.fieldName.replaceAll("position", xpathPosition+"");
			}
		}
	}
}
