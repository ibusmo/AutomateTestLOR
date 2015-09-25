package keyword.cmscom;

public class CMSBuilding extends baseCMSCOM{
	
	//This is default
	public CMSBuilding(){
		super.workSheetPath = "cms_building";
		initKeywords();
	}
	
	public CMSBuilding(int sheetIndex){
		super.workSheetPath = "cms_building_" + sheetIndex;
		initKeywords();
	}
	@Override
	public void initKeywords() {
		super.logoperation 		= output.LogTag.logoperation.CMS;
		super.logtab 			= output.LogTag.logtab.Building;
		super.logsubtab 		= output.LogTag.logsubtab.Evaluate;
		
		super.sizeOfData = 76;
		super.offsetRow = 2;

		loadData();		
	}
}
