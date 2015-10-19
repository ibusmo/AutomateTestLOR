package creditapplication;

import base.KeywordsCOM;
import testdata.ConfigElementObj;
import testdata.elementObj;
import testdata.CellTag.inputType;

public class NCBSummaryCOM extends KeywordsCOM {

	int collacteralIndex;
	
	public NCBSummaryCOM(int sheetIndex) {
		super.workSheetPath = "NCB_summary_" + sheetIndex;
		collacteralIndex = 1;
		initKeywords();
	}
	
	public NCBSummaryCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "NCB_summary_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	public NCBSummaryCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "NCB_summary_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.BasiInfo;
		super.logtab 			= log.LogTag.logtab.NCB;
		super.logsubtab 		= log.LogTag.logsubtab.None;

		super.sizeOfData = 12;
		super.offsetRow = 2;

		loadData();
	}
	
	@Override
	protected void precondition(elementObj obj) {
		if(obj.inputType==inputType.radio){
			if(obj.dataTag.contains("CIF")){
				int radioPosition = collacteralIndex - 1;
				obj.value = radioPosition + "";
			}
		}
	}

}
