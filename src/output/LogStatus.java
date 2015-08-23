package output;

public class LogStatus {
	public enum logexestatus{
		PASS,
		FAIL,
		START,
		FINISH
	}
	public enum logoperation{
		General,
		RegisterScanning
	}
	public enum logpage{
		Home,
		Certificate,
		Login,
		Logout,
		Register,
		WorkBox
	} 
	public enum logtab{
		
	} 
	public enum logsubtab{
		
	} 
	public enum logelement{
		
	}
	public enum logaction{
		Fill_login,
		Fill_login_again,
		Comfirm,
		Click,
		Radio,
		Dropdown,
	}
}
