package testdata;

public class CellTag {
	public enum col{
		A, B, C, D, E, F, G, H, I, J, K
	}
	public enum inputType{
		dropdown, dropdownx, text, radio, date, button, checkbox, popup, alert
	}
	public enum fieldType{
		id, name, xpath, linktext
	}
	public enum collacteralType{
		Land,
		Building,
		Condo,
		LandNBuilding, Vehicle, None
	}
	public enum sheetType{
		Register,
		AddCustomer,
		
		NCBOption,
		
		AddLoanCOM,
		
		CollLandBuilding,
		CollLand,
		CollBuilding,
		CollWarranter,
		CollAccounting,
		
		CMSLandBuilding,
		CMSLand,
		CMSBuilding, 
		
		Document, ReqDoc, AttachDoc, 
		LOR, CMS, GotoApp, Login, Logout, SendWork, CMSValuation, None, EndWork, Wait, ExcutiveSummary, NCBSummary, SearchWorkBox, AddCustomerOrg, CollWarranterOrg, AddLoanDDA, NCB, CutomerNormal, CutomerLegal, LoanCOM, LoanDDA, CMSAccounting, CMSLegalWar, CMSNormalWar, Seller
	}
}
