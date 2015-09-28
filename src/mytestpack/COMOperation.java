package mytestpack;

import java.util.Scanner;

import COM.CMS.ListOfCMS;
import COM.creditapplication.CollacteralAddAccountingCOM;
import COM.creditapplication.CollacteralAddBuildingCOM;
import COM.creditapplication.CollacteralAddLandAndBuildingCOM;
import COM.creditapplication.CollacteralAddLandCOM;
import COM.creditapplication.CollacteralAddWarranterCOM;
import COM.creditapplication.CustomerAddCOM;
import COM.creditapplication.LoanFormAddCOM;
import CSM.NCB.NCBCOM;
import CSM.register.RegisterCOM;
import common.AttachFilesCOM;
import common.RequireDocumentsCOM;
import common.SendWorkCOM;
import helper.GotoApp;
import helper.Login;
import helper.Logout;
import helper.OpenBrowser;
import testdata.ConfigElementObj;
import testdata.TestConfig;
import webdriver.WebDriverEngine;

public class COMOperation {

	public void LORasCOM() {
		// Load CONFIGURATION
		TestConfig tc = new TestConfig();
		tc.loadData();

		// OPERATING
		String appID = null;
		for (ConfigElementObj obj : tc.configElementObj) {
			switch (obj.sheet) {
				case Login:
					login(obj);
					break;
				case Logout:
					new Logout().execute();
					break;
				case Register:
					appID = register(obj.index);
					break;
				case GotoApp:
					appID = obj.remark.length() > 5 ? obj.remark : appID;
					new GotoApp(appID).execute();
					break;
				case NCB:
					new NCBCOM(obj.index).execute();
					break;
				case AddCustomer:
					new CustomerAddCOM(obj.index).execute();
					break;
				case AddLoan:
					new LoanFormAddCOM(obj.index).execute();
					break;
	
				case CollBuilding:
					new CollacteralAddBuildingCOM(obj.index, obj).execute();
					break;
				case CollLandBuilding:
					new CollacteralAddLandAndBuildingCOM(obj.index, obj).execute();
					break;
				case CollLand:
					new CollacteralAddLandCOM(obj.index, obj).execute();
					break;
				case CollAccounting:
					new CollacteralAddAccountingCOM(obj.index).execute();
					break;
				case CollWarranter:
					new CollacteralAddWarranterCOM(obj.index).execute();
					break;
	
				case Document:
					new RequireDocumentsCOM().execute();
					new AttachFilesCOM().execute();
					break;
	
				case CMSValuation:
					CMSValuation2(appID);
					break;
	
				case SendWork:
					new SendWorkCOM().execute();
					break;
	
				default:
					break;
			}
			waitForInterrupt();
		}
	}

	private void login(ConfigElementObj obj) {
		if (obj.process.toLowerCase().contains("lor")) {
			new OpenBrowser("http://172.31.1.41:55011/LOR/login.jsp").execute();
		} else if (obj.process.toLowerCase().contains("cms")) {
			new OpenBrowser("http://172.31.1.42:9080/CMS/login.jsp").execute();
		}
		new Login(obj.remark, "testuser").execute();
		waitForInterrupt();
	}

	private static String register(int index) {
		RegisterCOM reg = new RegisterCOM(index);
		reg.execute();
		return reg.getAppID();
	}

	// DUMMY SCRIPT NOT LOAD DATA FROM EXCEL
	// private void creditApplication(String appID){
	// new GotoApp(appID).execute(); waitForInterrupt();
	// new NCBCOM(1).execute(); waitForInterrupt();
	// new CustomerAddCOM(1).execute(); waitForInterrupt();
	// new CustomerAddCOM(2).execute(); waitForInterrupt();
	// new LoanFormAddCOM(1).execute(); waitForInterrupt();
	// new CollacteralAddLandAndBuildingCOM(1, 1).execute(); waitForInterrupt();
	// new CollacteralAddBuildingCOM(1, 2).execute(); waitForInterrupt();
	// new CollacteralAddLandCOM(1, 3).execute(); waitForInterrupt();
	// new CollacteralAddAccountingCOM(1, 4).execute(); waitForInterrupt();
	// new CollacteralAddWarranterCOM(1, 5).execute(); waitForInterrupt();
	// new RequireDocumentsCOM().execute();
	// new AttachFilesCOM().execute(); waitForInterrupt();
	// }

	private void CMSValuation2(String appID) {
		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		WebDriverEngine.getDriver().manage().window().maximize();
		new Login("PisutC", "testuser").execute();
		waitForInterrupt();
		new ListOfCMS(appID).execute();
		waitForInterrupt();
		new Logout().execute();
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
