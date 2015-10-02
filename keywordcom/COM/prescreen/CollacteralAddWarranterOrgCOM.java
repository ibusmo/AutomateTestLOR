package COM.prescreen;

import base.KeywordsCOM;
import testdata.ConfigElementObj;

public class CollacteralAddWarranterOrgCOM extends KeywordsCOM {
	
	//Not use
	int collacteralIndex;

	//Not use
	public CollacteralAddWarranterOrgCOM(int sheetIndex, ConfigElementObj configElementObj) {
		super.workSheetPath = "collateral_addwarranter_org_" + sheetIndex;
		this.collacteralIndex = (int) Math.round(Double.parseDouble(configElementObj.remark));
		initKeywords();
	}
	
	//Not use
	public CollacteralAddWarranterOrgCOM(int sheetIndex, int collacteralIndex) {
		super.workSheetPath = "collateral_addwarranter_org_" + sheetIndex;
		this.collacteralIndex = collacteralIndex;
	}
	
	public CollacteralAddWarranterOrgCOM(int sheetIndex) {
		super.workSheetPath = "collateral_addwarranter_org_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.RegScanning;
		super.logtab 			= log.LogTag.logtab.Collateral;
		super.logsubtab 		= log.LogTag.logsubtab.AddWarranterOrg;

		super.sizeOfData = 58;
		super.offsetRow = 2;

		loadData();
	}
}
