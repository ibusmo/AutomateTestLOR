package output;

public class LogTag {
	public enum logexestatus{
		INIT,
		TEAR,
		PASS,
		FAIL,
		START,
		FINISH,
		None
	}
	public enum logoperation{
		WebDriver,
		OpenBrowser,
		Certificate,
		Login,
		Logout,
		Register,
		WorkBox,
		RegScanning,
		NCB,
		ConsComment,
		BasiInfo,
		None, RegisScan, Assigment, LoanApp, CMS, CSMColl, Config, SendWork, RequireDoc
	}
	public enum logtab{
		WorkBox,
		RegCustomer,
		LoanForm,
		Policy,
		RequireDoc,
		AttachFiles,
		
		RegCollate,
		ExcSummary,
		None, RegColl, Assignment, Edit, GetCMS, CollInfo, CMSSendWork, CMSGotoApp, Collateral, NCB, ListofCMS, Land, LandBuilding, Building, SendWork, 
	} 
	public enum logsubtab{
		WorkBox,
		PersonalBox,
		Add,
		
		CIFInfo,
		CIFOtherInfo,
		CIFSalary,
		CIFCareer,
		CIFExpense,
		CIFNonNCB,
		
		LongTermLoan,
		
		NCB,
		None, Warrantee, Mortgage, GeneralInfo, LandInfo, BuildingInfo, SupportInfo, EvaMethod, Value, PartPledge, AddLand, AddLandBuilding, AddWarranter, Evaluate, AddBuilding, AddAccounting
	} 
	public enum logelement{
		None
	}
	public enum logaction{
		Start,
		Stop,
		Fill_login,
		Fill_again,
		Comfirm,
		Click,
		Radio,
		Dropdown,
		Text,
		Save,
		Get,
		Date,
		Popup,
		Check,
		Attach,
		SendWork,
		None, Checkbox, LoadData, DropdownNoText, Draft, OK, DropdownRobot
	}
}
