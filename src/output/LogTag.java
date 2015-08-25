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
		policy,
		None
	} 
	public enum logsubtab{
		WorkBox,
		PersonalBox,
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
		None
	}
}
