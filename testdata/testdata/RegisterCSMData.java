package testdata;

import testdata.CellTag.col;

public class RegisterCSMData implements TestDatas {

	String workSheetPath = "register";
	ReadExcel rdExl;

	public String txtWorkflowCode;
	public String drpWorkflowCode;
	public String txtGroupCheck;
	public String rdoGroupCheck;
	public String txtNewsSourceCode;
	public String drpNewsSourceCode;
	public String txtFastTrackFlag;
	public String rdoFastTrackFlag;
	public String txtIssuerPhoneMobile;
	public String txtIssuerPhoneOffice;
	public String txtIssuerPhoneOfficeExt;
	public String txtSalePhoneMobile;
	public String txtSalePhoneOffice;
	public String txtSalePhoneOfficeExt;
	
	@Override
	public boolean loadData() {
		rdExl = new ReadExcel(workBookPath, workSheetPath);

		txtWorkflowCode = rdExl.getString(col.B, 2);
		drpWorkflowCode = rdExl.getString(col.C, 2);
		txtGroupCheck = rdExl.getString(col.B, 3);
		rdoGroupCheck = rdExl.getString(col.C, 3);
		txtNewsSourceCode = rdExl.getString(col.B, 4);
		txtNewsSourceCode = rdExl.getString(col.C, 4);
		txtFastTrackFlag = rdExl.getString(col.B, 5);
		rdoFastTrackFlag = rdExl.getString(col.C, 5);
		txtIssuerPhoneMobile = rdExl.getString(col.B, 6);
		txtIssuerPhoneOffice = rdExl.getString(col.B, 7);
		txtIssuerPhoneOfficeExt = rdExl.getString(col.B, 8);
		txtSalePhoneMobile = rdExl.getString(col.B, 9);
		txtSalePhoneOffice= rdExl.getString(col.B, 10);
		txtSalePhoneOfficeExt = rdExl.getString(col.B, 11);
		
		rdExl.closeFile();
		
		return true;
	}
}
