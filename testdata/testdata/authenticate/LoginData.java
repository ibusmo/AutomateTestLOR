package testdata.authenticate;

import testdata.CellTag.col;
import testdata.TestDatas;
import testdata.loginData.ReadExcel;

public class LoginData implements TestDatas {

	String workSheetPath = "login";
	ReadExcel rdExl;
	
	public String username;
	public String password;
	
	public LoginData(){
	}

	@Override
	public boolean loadData() {
		rdExl = new ReadExcel(workBookPath, workSheetPath);
		
		username = rdExl.getString(col.B, 4);
		password = rdExl.getString(col.B, 5);
		
		rdExl.closeFile();
		return true;
	}
}
