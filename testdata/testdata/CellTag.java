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
		
		NCB,
		
		AddLoan,
		
		CollLandBuiling,
		CollLand,
		CollBuilding,
		CollWarranter,
		CollAccounting,
		
		CMSLandBuiling,
		CMSLand,
		CMSBuilding, 
		
		document
	}
}
