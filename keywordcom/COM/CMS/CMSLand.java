package COM.CMS;

public class CMSLand extends CMSBase{
	
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
		super.logoperation 		= log.LogTag.logoperation.CMS;
		super.logtab 			= log.LogTag.logtab.Land;
		super.logsubtab 		= log.LogTag.logsubtab.Evaluate;
		
		super.sizeOfData = 83;
		super.offsetRow = 2;

		loadData();
	}	
}
