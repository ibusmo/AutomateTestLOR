package keyword.cmscom;

public class CMSLand extends baseCMSCOM{
	
	//This is default
	public CMSLand(){
		super.workSheetPath = "cms_land";
		initKeywords();
	}
	
	public CMSLand(int sheetIndex){
		super.workSheetPath = "cms_land_" + sheetIndex;
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.CMS;
		super.logtab 			= output.LogTag.logtab.Land;
		super.logsubtab 		= output.LogTag.logsubtab.Evaluate;
		
		super.sizeOfData = 83;
		super.offsetRow = 2;

		loadData();
	}	
}
