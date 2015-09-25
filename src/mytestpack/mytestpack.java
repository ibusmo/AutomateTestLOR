package mytestpack;

import java.util.Random;
import java.util.Scanner;

import config.ConfigElementObj;
import config.TestConfig;
import keyword.NCB.NCB;
import keyword.NCB.NCBCOM;
import keyword.NCB.NCBSendWork;
import keyword.assignment.ASSendWork;
import keyword.assignment.Assignment;
import keyword.authenticate.Login;
import keyword.authenticate.Logout;
import keyword.basicinfocheck.BICDocuments;
import keyword.basicinfocheck.BICExecutiveSummary;
import keyword.basicinfocheck.BICSendWork;
import keyword.cms.CMSBuildingInfo;
import keyword.cms.CMSEvaluationMethod;
import keyword.cms.CMSLandInfo;
import keyword.cms.CMSPartPledge;
import keyword.cms.CMSSendWork;
import keyword.cms.CMSSupportInfo;
import keyword.cms.CMSValue;
import keyword.cmscom.ListOfCMS;
import keyword.common.AttachFilesCOM;
import keyword.common.RequireDocumentsCOM;
import keyword.common.SendWorkCOM;
import keyword.cms.CMSGotoApp;
import keyword.considerandcommentation.CCDocuments;
import keyword.considerandcommentation.CCExecutiveSummary;
import keyword.considerandcommentation.CCSendWork;
import keyword.considerandcommentation.CollateralAdd;
import keyword.considerandcommentation.CollateralInfo;
import keyword.considerandcommentation.CollateralMortgage;
import keyword.helper.GotoApp;
import keyword.helper.OpenBrowser;
import keyword.loanapp.LoanAppEdit;
import keyword.register.RegisterCOM;
import keyword.register.RegisterCSM;
import keyword.registerandscnanning.CollacteralAddAccountingCOM;
import keyword.registerandscnanning.CollacteralAddBuildingCOM;
import keyword.registerandscnanning.CollacteralAddLandAndBuildingCOM;
import keyword.registerandscnanning.CollacteralAddLandCOM;
import keyword.registerandscnanning.CollacteralAddWarranterCOM;
import keyword.registerandscnanning.CustomerAdd;
import keyword.registerandscnanning.CustomerAddCOM;
import keyword.registerandscnanning.CustomerCIFInfo;
import keyword.registerandscnanning.CustomerExpenses;
import keyword.registerandscnanning.CustomerIncome;
import keyword.registerandscnanning.CustomerNonNCB;
import keyword.registerandscnanning.CustomerOtherInfo;
import keyword.registerandscnanning.ReScnDocuments;
import keyword.registerandscnanning.RegScnSendWork;
import keyword.registerandscnanning.LoanFormAdd;
import keyword.registerandscnanning.LoanFormAddCOM;
import keyword.registerandscnanning.LoanFormLongTermLoan;
import keyword.registerandscnanning.TabPolicy;
import output.LogCat;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){		
		//Init LOG and DRIVER
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");	
		
		//Load CONFIGURATION
		TestConfig tc = new TestConfig();
		tc.loadData();
		
		//OPERATING
		String appID = null;
		for(ConfigElementObj obj : tc.configElementObj){
			switch(obj.sheet){
				case Login:
					if(obj.process.toLowerCase().contains("lor")){
						LORLogin(obj.remark);								waitForInterrupt();
					}
					else if(obj.process.toLowerCase().contains("cms")){
						CMSLogin(obj.remark);								waitForInterrupt();
					}
					break;
				case Logout:
					new Logout().execute();									waitForInterrupt();
					break;
				case Register:
					appID = registerSM2(obj.index);							waitForInterrupt();
					break;
				case GotoApp:
					String tmpAppID = obj.remark.length()>5 ? obj.remark : appID;
					new GotoApp(tmpAppID).execute();						waitForInterrupt();
					break;
				case NCB:
					new NCBCOM(obj.index).execute();						waitForInterrupt();	
					break;
				case AddCustomer:	
					new CustomerAddCOM(obj.index).execute();				waitForInterrupt();	
					break;
				case AddLoan:
					new LoanFormAddCOM(obj.index).execute();				waitForInterrupt();
					break;
					
				case CollLand:
					new CollacteralAddLandCOM(obj.index).execute();			waitForInterrupt();
					break;
				case CollBuilding:
					new CollacteralAddBuildingCOM(obj.index).execute();		waitForInterrupt();
					break;
				case CollLandBuiling:
					new CollacteralAddLandAndBuildingCOM(obj.index).execute();	waitForInterrupt();
					break;
				case CollAccounting:
					new CollacteralAddAccountingCOM(obj.index).execute();	waitForInterrupt();
					break;
				case CollWarranter:
					new CollacteralAddWarranterCOM(obj.index).execute();	waitForInterrupt();
					break;
					
				case Document:
					new RequireDocumentsCOM().execute();					waitForInterrupt();
					new AttachFilesCOM().execute();							waitForInterrupt();
					break;
					
				case SendWork:
					new SendWorkCOM().execute();					waitForInterrupt();
					break;
			default:
				break;
			}
		}
		
		WebDriverEngine.Close();
		WebDriverEngine.quit();
		logCat.endLog();
	}
	
	private static String registerSM2(int index) {
		RegisterCOM reg = new RegisterCOM(index);		
		reg.execute();							
		return reg.getAppID();
	}
	
	private static void registerAndScanningCOM(String appID){		
		new GotoApp(appID).execute();			waitForInterrupt();
		new NCBCOM(1).execute();		waitForInterrupt();	
		new CustomerAddCOM(1).execute();					waitForInterrupt();	
		new CustomerAddCOM(2).execute();					waitForInterrupt();	
		new LoanFormAddCOM(1).execute();					waitForInterrupt();
		new CollacteralAddLandAndBuildingCOM(1).execute();	waitForInterrupt();
		new CollacteralAddBuildingCOM(1).execute();			waitForInterrupt();
		new CollacteralAddLandCOM(1).execute();				waitForInterrupt();
		new CollacteralAddAccountingCOM(1).execute();		waitForInterrupt();
		new CollacteralAddWarranterCOM(1).execute();		waitForInterrupt();
		new RequireDocumentsCOM().execute();
		new AttachFilesCOM().execute();						waitForInterrupt();
	}	
	
	private static void CMSV2(String appID){
		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		WebDriverEngine.getDriver().manage().window().maximize();
		new Login("PisutC", "testuser").execute();						waitForInterrupt();
		new ListOfCMS(appID).execute();								waitForInterrupt();
		new Logout().execute();
	}
	
	private static void LORLogin(String user){
		new OpenBrowser("http://172.31.1.41:55011/LOR/login.jsp").execute();
		new Login(user, "testuser").execute();
	}
	private static void CMSLogin(String user){
		new OpenBrowser("http://172.31.1.42:9080/CMS/login.jsp").execute();
		new Login(user, "testuser").execute();
	}
	
	private static void LORLogout(){
		new Logout().execute();
	}
	
	
	
	
	
	
	
	
	private static void CMSOp(String cMSNo){
		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		new Login("PisutC", "testuser").execute();		waitForInterrupt();
		new CMSGotoApp(cMSNo).execute();				waitForInterrupt();
		new CMSLandInfo().execute();					waitForInterrupt();
		new CMSBuildingInfo().execute(); 				waitForInterrupt();
		new CMSSupportInfo().execute(); 				waitForInterrupt();
		new CMSEvaluationMethod().execute(); 			waitForInterrupt();
		new CMSValue().execute(); 						waitForInterrupt();
		new CMSPartPledge().execute(); 					waitForInterrupt();
		new CMSSendWork(cMSNo).execute(); 				waitForInterrupt();
		new Logout().execute();			
	}
	
	private static String getCMS(String appID){
		new GotoApp(appID).execute();					addSpace();		
		LoanAppEdit getCSM = new LoanAppEdit();
		getCSM.execute();
		return getCSM.getCMSNum();
	}
	
	private static void assignment(String appID) {
		new GotoApp(appID).execute();					addSpace();
		new Assignment().execute();						addSpace();
		new ASSendWork().execute();						addSpace();
	}
	
	private static void basicInfoCheck(String appID) {
		new GotoApp(appID).execute();					addSpace();		
		new BICExecutiveSummary().execute();			addSpace();
		new BICDocuments().execute();					addSpace();		
		new BICSendWork().execute();					addSpace();
	}
	
	private static void considerAndCommentation(String appID) {
		new GotoApp(appID).execute();					addSpace();
		new CollateralAdd().execute();					addSpace();
		new CollateralMortgage().execute();				addSpace();
		new CollateralInfo().execute();					addSpace();		
		new CCExecutiveSummary().execute();				addSpace();
		new CCDocuments().execute();					addSpace();		
		new CCSendWork().execute();						addSpace();
	}
	
	private static void ncb(String appID) {
		new GotoApp(appID).execute();					addSpace();		
		new NCB().execute();							addSpace();		
		new NCBSendWork().execute();					addSpace();
	}

	private static void registerandscanning(String appID, String CIF) {
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

	private static String register() {
		RegisterCSM register = new RegisterCSM();				
		register.execute();								
		String appID = register.getAppID();				addSpace();
		return appID;
	}
	
	private static void waitForInterrupt() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter to continue");
		// get user input for a
		@SuppressWarnings("unused")
		String x = reader.nextLine();					addSpace();
	}
	
	private static void addSpace() {
		System.out.println("\n...\n");
	}
	
	public static String getNum(int point){
		Random ran = new Random();
		int low = (int) Math.pow(10, point-1);
		int high = (int) Math.pow(10, point)-low;
		int tmp = ran.nextInt(high) + low;
		return ""+tmp;
	}
	
	public static void LORAsCMS(){
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		new Login("AdisakC", "testuser").execute();
		String appID = register();						waitForInterrupt();
		registerandscanning(appID, "1357");				waitForInterrupt();
		ncb(appID);										waitForInterrupt();
		considerAndCommentation(appID);					waitForInterrupt();
		new Logout().execute();
		
		new Login("JirapornS1", "testuser").execute();		
		basicInfoCheck(appID);							waitForInterrupt();
		new Logout().execute();
		
		new Login("SurachaiT1", "testuser").execute();		
		assignment(appID);								waitForInterrupt();
		new Logout().execute();
	
		CMSV2("003309580011");	
	}
}
