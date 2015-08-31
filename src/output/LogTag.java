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
		ConsiderComment,
		None
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
		None, 
	} 
	public enum logsubtab{
		WorkBox,
		PersonalBox,
		Add,
		
		CIFInfo,
		CIFOtherInfo,
		CIFIncome,
		CIFCareer,
		CIFExpense,
		CIFNonNCB,
		
		LongTermLoan,
		
		NCB,
		None
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
		Type,
		Save,
		Get,
		Date,
		Popup,
		Check,
		Attach,
		SendWork,
		None
	}
}
