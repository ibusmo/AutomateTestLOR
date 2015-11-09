package mytestpack;

import java.util.Scanner;

import CMS.assignment.ASSendWork;
import CMS.assignment.Assignment;
import CMS.basicinfocheck.BICDocuments;
import CMS.basicinfocheck.BICExecutiveSummary;
import CMS.basicinfocheck.BICSendWork;
import CSM.NCB.NCB;
import CSM.NCB.NCBSendWork;
import CSM.considerandcommentation.CCDocuments;
import CSM.considerandcommentation.CCExecutiveSummary;
import CSM.considerandcommentation.CCSendWork;
import CSM.considerandcommentation.CollateralAdd;
import CSM.considerandcommentation.CollateralInfo;
import CSM.considerandcommentation.CollateralMortgage;
import CSM.register.RegisterCSM;
import CSM.registerandscanning.CustomerAdd;
import CSM.registerandscanning.CustomerCIFInfo;
import CSM.registerandscanning.CustomerExpenses;
import CSM.registerandscanning.CustomerIncome;
import CSM.registerandscanning.CustomerNonNCB;
import CSM.registerandscanning.CustomerOtherInfo;
import CSM.registerandscanning.LoanFormAdd;
import CSM.registerandscanning.LoanFormLongTermLoan;
import CSM.registerandscanning.ReScnDocuments;
import CSM.registerandscanning.RegScnSendWork;
import CSM.registerandscanning.TabPolicy;
import autocms.ListOfCMS;
import helper.GotoApp;
import helper.Login;
import helper.Logout;
import helper.OpenBrowser;

public class CSMOperation {
	
	public void LORasCSM(){
		new helper.OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
	
		new Login("AdisakC", "testuser").execute();
		//Register
		String appID = register();						waitForInterrupt();
		//Add customer and information of customer
		//Loan Application and detail
		//Require documents, and attach them
		registerandscanning(appID, "1357");				waitForInterrupt();
		//Enter NCB
		ncb(appID);										waitForInterrupt();
		//Consider And Commendation
		considerAndCommentation(appID);					waitForInterrupt();
		new Logout().execute();
		
		new Login("JirapornS1", "testuser").execute();		
		basicInfoCheck(appID);							waitForInterrupt();
		new Logout().execute();
		
		//Assign Work on Credit Application
		new Login("SurachaiT1", "testuser").execute();		
		assignment(appID);								waitForInterrupt();
		new Logout().execute();
		
		//CMS collateral valuation
		CMSVersion2("003309580011");	
	}
	
	private String register() {
		RegisterCSM register = new RegisterCSM();				
		register.execute();								
		String appID = register.getAppID();				addSpace();
		return appID;
	}
	
	private void registerandscanning(String appID, String CIF) {
		new GotoApp(appID).execute();					addSpace();														
		new CustomerAdd(CIF).execute();					addSpace();
		new CustomerCIFInfo().execute();				addSpace();
		new CustomerOtherInfo().execute();				addSpace();
		new CustomerIncome().execute();					addSpace();
		new CustomerExpenses().execute();				addSpace();
		new CustomerNonNCB().execute();					addSpace();														
		new LoanFormAdd().execute();					addSpace();
		new LoanFormLongTermLoan().execute();			addSpace();		
		new ReScnDocuments().execute();					addSpace();		
		new TabPolicy().execute();						addSpace();
		new RegScnSendWork().execute();					addSpace();
	}
	
	private void ncb(String appID) {
		new GotoApp(appID).execute();					addSpace();		
		new NCB().execute();							addSpace();		
		new NCBSendWork().execute();					addSpace();
	}
	
	private void considerAndCommentation(String appID) {
		new GotoApp(appID).execute();					addSpace();
		new CollateralAdd().execute();					addSpace();
		new CollateralMortgage().execute();				addSpace();
		new CollateralInfo().execute();					addSpace();		
		new CCExecutiveSummary().execute();				addSpace();
		new CCDocuments().execute();					addSpace();		
		new CCSendWork().execute();						addSpace();
	}
	
	private void basicInfoCheck(String appID) {
		new GotoApp(appID).execute();					addSpace();		
		new BICExecutiveSummary().execute();			addSpace();
		new BICDocuments().execute();					addSpace();		
		new BICSendWork().execute();					addSpace();
	}
	
	private void assignment(String appID) {
		new GotoApp(appID).execute();					addSpace();
		new Assignment().execute();						addSpace();
		new ASSendWork().execute();						addSpace();
	}
	
//	CMS Operation By Find CMS number and valuation from it.
//	private String getCMS(String appID){
//		new GotoApp(appID).execute();					addSpace();		
//		LoanAppEdit getCSM = new LoanAppEdit();
//		getCSM.execute();
//		return getCSM.getCMSNum();
//	}
//	
//	private void CMSOp(String cMSNo){
//		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
//		new Login("PisutC", "testuser").execute();		waitForInterrupt();
//		new CMSGotoApp(cMSNo).execute();				waitForInterrupt();
//		new CMSLandInfo().execute();					waitForInterrupt();
//		new CMSBuildingInfo().execute(); 				waitForInterrupt();
//		new CMSSupportInfo().execute(); 				waitForInterrupt();
//		new CMSEvaluationMethod().execute(); 			waitForInterrupt();
//		new CMSValue().execute(); 						waitForInterrupt();
//		new CMSPartPledge().execute(); 					waitForInterrupt();
//		new CMSSendWork(cMSNo).execute(); 				waitForInterrupt();
//		new Logout().execute();			
//	}
	
//	CMS Operation By search all collateral that relate to APP ID.
	private void CMSVersion2(String appID){
		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		new Login("PisutC", "testuser").execute();					waitForInterrupt();
		// Auto valuation
		new ListOfCMS(appID).execute();								waitForInterrupt();
		new Logout().execute();
	}
	
	@SuppressWarnings("resource")
	private void waitForInterrupt() {
		System.out.println("Enter to continue");
		new Scanner(System.in).nextLine();
		addSpace();
	}

	private void addSpace() {
		System.out.println("\n...\n");
	}
}
