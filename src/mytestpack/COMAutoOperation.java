package mytestpack;

import java.util.Scanner;

import COM.CMS.ListOfCMS;
import CSM.register.RegisterCOM;
import common.AttachFilesCOM;
import common.RequireDocumentsCOM;
import common.SearchWorkBOx;
import common.SendWorkCOM;
import common.Wait;
import creditanalysis.CMDEPTAssign;
import creditanalysis.SBROAssign;
import creditanalysis.SBROSECAssign;
import creditapplication.CollacteralAddAccountingCOM;
import creditapplication.CollacteralAddBuildingCOM;
import creditapplication.CollacteralAddLandAndBuildingCOM;
import creditapplication.CollacteralAddLandCOM;
import creditapplication.CollacteralAddWarranterCOM;
import creditapplication.CollacteralAddWarranterOrgCOM;
import creditapplication.CustomerAddCOM;
import creditapplication.CustomerOrgAddCOM;
import creditapplication.ExcutiveSummary;
import creditapplication.LoanFormCOMAddCOM;
import creditapplication.LoanFormDDAAddCOM;
import creditapplication.NCBOptionCOM;
import creditapplication.NCBSummaryCOM;
import helper.GotoApp;
import helper.Login;
import helper.Logout;
import helper.OpenBrowser;
import testdata.ConfigElementObj;
import testdata.TestConfig;
import webdriver.WebDriverEngine;

public class COMAutoOperation {

	String username = null;
	String appID = null;
	int delayTime = 2000;
	Boolean NCB = false;
	int CutomerNormal = 0;
	int CutomerLegal = 0;
	int CutomerNormalQueue = 0;
	int CutomerLegalQueue = 0;

	int LoanCOM = 0;
	int LoanDDA = 0;

	int CMSLandBuilding = 0;
	int CMSBuilding = 0;
	int CMSLand = 0;
	int CMSAccounting = 0;
	int CMSLegalWar = 0;
	int CMSNormalWar = 0;

	TestConfig tc;

	public void LORasCOM() {
		// Load CONFIGURATION
		tc = new TestConfig("auto");
		tc.loadData();

		loadConfigAndSetting();
		showSetting();

		// OPERATING
		creditApplication();
		
		CMSValuation2(appID);
		
//		waitForInterrupt();

//		/////////////////////////////////////////////////// Credit Analysis (CA)
//		// Current User (SuneeR, SatapornM) 		SBRO
		login(username, "LOR");
		new GotoApp(appID).execute();
		new SBROAssign().execute();
//		waitForInterrupt();
		new Logout().execute();
//
//		//ONLY SomchaiA 							SBROSEC
		username = "SomchaiA";
		login(username, "LOR");
		new GotoApp(appID).execute();
		new SBROSECAssign().execute();
//		waitForInterrupt();
		new Logout().execute();
//
//		//ONLY ThanypornK							CMDEPT
		username = "ThanypornK";
		login(username, "LOR");
		new GotoApp(appID).execute();
		new CMDEPTAssign().execute();
//		waitForInterrupt();
		// search for next ROLE
		searchForRole();
		new Logout().execute();

//		//Skill Set									CM
		login(username, "LOR");
		new GotoApp(appID).execute();
//		new CA().execute();
//		new SendWorkCOM().execute();
		//waitForInterrupt();
		new Logout().execute();

//		//ONLY ThanypornK							CMDEPT
//		login("ThanypornK", "LOR");
//		new GotoApp(appID).execute();
//		new Comment().execute();
//		new SendWorkCOM().execute();
//		waitForInterrupt();
//		searchForRole();
//		new Logout().execute();
	}

	private void showSetting() {
		System.out.println("username " + username);
		System.out.println("appID " + appID);
		System.out.println("delayTime " + delayTime);
		System.out.println("NCB " + NCB);

		System.out.println("CutomerNormal " + CutomerNormal);
		System.out.println("CutomerLegal " + CutomerLegal);
		System.out.println("CutomerNormalQueue " + CutomerNormalQueue);
		System.out.println("CutomerLegalQueue " + CutomerLegalQueue);

		System.out.println("LoanCOM " + LoanCOM);
		System.out.println("LoanDDA " + LoanDDA);

		System.out.println("CMSLandBuilding " + CMSLandBuilding);
		System.out.println("CMSBuilding " + CMSBuilding);
		System.out.println("CMSLand " + CMSLand);
		System.out.println("CMSAccounting " + CMSAccounting);
		System.out.println("CMSLegalWar " + CMSLegalWar);
		System.out.println("CMSNormalWar " + CMSNormalWar);
	}

	private void creditApplication() {
		/////////////////////////////////////////////////// Node1
		// login
		login(username, "LOR");
		
		prescreen();

		/////////////////////////////////////////////////// Node2
		// If customer is Legal and NCB option is true -> NCB
		NCBSummary();

		// Basic Information
		basicInformation();

		// Search for next role
		searchForRole();

		// Logout
		new Logout().execute();

		// VerifyAndCommitment
		verifyAndCommitment();

	}

	private void verifyAndCommitment() {
		login(username, "LOR");
		new GotoApp(appID).execute();
		new ExcutiveSummary(1).execute();
		new SendWorkCOM().execute();
		new Logout().execute();
	}

	private void prescreen() {
		// Register
		appID = register(1);

		// NCB option
		NCBOption();

		// Add Customer
		addCustomer();

		// Add Loan
		addLoan();

		// Collateral
		addCollateral();

		// If customer is Normal -> DOCUMENT
		document();

		// Send work
		new SendWorkCOM().execute();
		new Wait(delayTime).execute();
	}

	private void document() {
		if (CutomerNormalQueue == 1) {
			new RequireDocumentsCOM().execute();
			new AttachFilesCOM().execute();
		}
	}

	private void searchForRole() {
		SearchWorkBOx swb = new SearchWorkBOx(appID);
		swb.execute();
		username = swb.getUsername();
	}

	private void basicInformation() {
		new GotoApp(appID).execute();
		for (int i = 1; i <= CutomerNormal + CutomerLegal; i++) {
			new NCBSummaryCOM(1, i).execute();
		}
		new ExcutiveSummary(1).execute();
		new SendWorkCOM().execute();
		new Wait(delayTime).execute();
	}

	private void NCBSummary() {
		if (CutomerLegalQueue == 1 && NCB) {
			new GotoApp(appID).execute();
			new NCBSummaryCOM(1).execute();
			new SendWorkCOM().execute();
			new Wait(delayTime).execute();
		}
	}

	private void addCollateral() {
		int collIndex = 1;
		if (CMSLandBuilding > 0) {
			for (int i = 1; i <= CMSLandBuilding; i++) {
				new CollacteralAddLandAndBuildingCOM(i, collIndex++).execute();
			}
		}
		if (CMSBuilding > 0) {
			for (int i = 1; i <= CMSBuilding; i++) {
				new CollacteralAddBuildingCOM(i, collIndex++).execute();
			}
		}
		if (CMSLand > 0) {
			for (int i = 1; i <= CMSLand; i++) {
				new CollacteralAddLandCOM(i, collIndex++).execute();
			}
		}
		if (CMSAccounting > 0) {
			for (int i = 1; i <= CMSAccounting; i++) {
				new CollacteralAddAccountingCOM(i, collIndex++).execute();
			}
		}
		if (CMSNormalWar > 0) {
			for (int i = 1; i <= CMSNormalWar; i++) {
				new CollacteralAddWarranterCOM(i, collIndex++).execute();
			}
		}
		if (CMSLegalWar > 0) {
			for (int i = 1; i <= CMSLegalWar; i++) {
				new CollacteralAddWarranterOrgCOM(i, collIndex++).execute();
			}
		}
	}

	private void addLoan() {
		if (LoanCOM > 0) {
			for (int i = 1; i <= LoanCOM; i++) {
				new LoanFormCOMAddCOM(i).execute();
			}
		}
		if (LoanDDA > 0) {
			for (int i = 1; i <= LoanDDA; i++) {
				new LoanFormDDAAddCOM(i).execute();
			}
		}
	}

	private void addCustomer() {
		if (CutomerNormalQueue == 1) {
			for (int i = 1; i <= CutomerNormal; i++) {
				new CustomerAddCOM(i).execute();
			}
			for (int i = 1; i <= CutomerLegal; i++) {
				new CustomerOrgAddCOM(i).execute();
			}
		} else if (CutomerLegalQueue == 1) {
			for (int i = 1; i <= CutomerLegal; i++) {
				new CustomerOrgAddCOM(i).execute();
			}
			for (int i = 1; i <= CutomerNormal; i++) {
				new CustomerAddCOM(i).execute();
			}
		}
	}

	private void NCBOption() {
		new GotoApp(appID).execute();
		if (NCB) {
			new NCBOptionCOM(1).execute();
		} else {
			new NCBOptionCOM(0).execute();
		}
	}

	private void loadConfigAndSetting() {
		// SETDATA
		for (ConfigElementObj obj : tc.configElementObj) {
			switch (obj.sheet) {
			case Seller:
				username = obj.remark;
				break;
			case NCB:
				NCB = obj.index == 1 ? true : false;
				break;
			case CutomerNormal:
				CutomerNormal = obj.index;
				if (CutomerNormalQueue == 0 && CutomerLegalQueue == 0 && CutomerNormal != 0) {
					CutomerNormalQueue = 1;
					CutomerLegalQueue = 2;
				}
				break;
			case CutomerLegal:
				CutomerLegal = obj.index;
				if (CutomerNormalQueue == 0 && CutomerLegalQueue == 0 && CutomerLegal != 0) {
					CutomerNormalQueue = 2;
					CutomerLegalQueue = 1;
				}
				break;
			case LoanCOM:
				LoanCOM = obj.index;
				break;
			case LoanDDA:
				LoanDDA = obj.index;
				break;
			case CMSLandBuilding:
				CMSLandBuilding = obj.index;
				break;
			case CMSBuilding:
				CMSBuilding = obj.index;
				break;
			case CMSLand:
				CMSLand = obj.index;
				break;
			case CMSAccounting:
				CMSAccounting = obj.index;
				break;
			case CMSLegalWar:
				CMSLegalWar = obj.index;
				break;
			case CMSNormalWar:
				CMSNormalWar = obj.index;
				break;
			default:
				break;
			}
		}
	}

	private void login(String username, String process) {
		if (process.toLowerCase().contains("lor")) {
			new OpenBrowser("http://172.31.1.41:55011/LOR/login.jsp").execute();
		} else if (process.toLowerCase().contains("cms")) {
			new OpenBrowser("http://172.31.1.42:9080/CMS/login.jsp").execute();
		}
		new Login(username, "testuser").execute();
	}

	private static String register(int index) {
		RegisterCOM reg = new RegisterCOM(index);
		reg.execute();
		return reg.getAppID();
	}

	private void CMSValuation2(String appID) {
		if (CMSLandBuilding > 0 || CMSBuilding > 0 || CMSLand > 0) {
			new OpenBrowser("http://172.31.1.42:9080/CMS/login.jsp").execute();
			WebDriverEngine.getDriver().manage().window().maximize();
			new Login("SomchaiA", "testuser").execute();
			waitForInterrupt();
			new ListOfCMS(appID).execute();
			waitForInterrupt();
			new Logout().execute();
		}
	}

	@SuppressWarnings("resource")
	private void waitForInterrupt() {
		System.out.println("Enter to continue");
		new Scanner(System.in).nextLine();
		addSpace();
	}

	private void addSpace() {
		System.out.println(".............................................................");
	}
}
