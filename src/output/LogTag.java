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
		RegisScan,
		NCB,
		None
	}
	public enum logtab{
		WorkBox,
		RegisCust,
		LoanForm,
		Policy,
		RequireDoc,
		AttachFiles,
		None
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
		None
	}
}
