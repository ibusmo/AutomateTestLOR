package COM.CMS;

public class CMSBuilding extends CMSBase{
	
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
		super.logoperation 		= log.LogTag.logoperation.CMS;
		super.logtab 			= log.LogTag.logtab.Building;
		super.logsubtab 		= log.LogTag.logsubtab.Evaluate;
		
		super.sizeOfData = 76;
		super.offsetRow = 2;

		loadData();		
	}
}
