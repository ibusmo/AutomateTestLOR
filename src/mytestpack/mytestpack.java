package mytestpack;

import java.util.Random;
import java.util.Scanner;

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
import keyword.common.AttachFiles;
import keyword.common.RequireDocuments;
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
import keyword.registerandscnanning.CollacteralAddLandAndBuildingCOM;
import keyword.registerandscnanning.CollacteralAddLandCOM;
import keyword.registerandscnanning.CollacteralAddWarranter;
import keyword.registerandscnanning.CustomerAdd;
import keyword.registerandscnanning.CustomerAddCOM;
import keyword.registerandscnanning.CustomerCIFInfo;
import keyword.registerandscnanning.CustomerCareerCOM;
import keyword.registerandscnanning.CustomerExpense;
import keyword.registerandscnanning.CustomerExpenses;
import keyword.registerandscnanning.CustomerIncome;
import keyword.registerandscnanning.CustomerNonNCB;
import keyword.registerandscnanning.CustomerNonNCBCOM;
import keyword.registerandscnanning.CustomerOtherInfo;
import keyword.registerandscnanning.CustomerOtherInfoCOM;
import keyword.registerandscnanning.CustomerSalaryCOM;
import keyword.registerandscnanning.ReScnDocuments;
import keyword.registerandscnanning.RegScnSendWork;
import keyword.registerandscnanning.LoanFormAdd;
import keyword.registerandscnanning.LoanFormAddCOM;
import keyword.registerandscnanning.LoanFormLongTermLoan;
import keyword.registerandscnanning.TabPolicy;
import output.LogCat;
import output.LogTag.logoperation;
import testdata.ReadExcel;
import testdata.CellTag.col;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){		
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");		
//		new OpenBrowser("https://172.31.1.41:9445/LOR/login.jsp").execute();
//		new Login("AdisakC", "testuser").execute();
//		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
//		new Login("AdisakC", "testuser").execute();
//		new OpenBrowser("http://172.31.1.41:9084/LOR/login.jsp").execute();
//		new Login("NiponM", "testuser").execute();
		
//		String CIF = "3";
//		String appID = registerSM2();					waitForInterrupt();
//		String appID = "038309580006";
//		new GotoApp(appID).execute();					waitForInterrupt();		
//		registerAndScanningCOM(appID, CIF);				waitForInterrupt();
		

		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		WebDriverEngine.getDriver().manage().window().maximize();
		new Login("PisutC", "testuser").execute();		waitForInterrupt();
		new ListOfCMS("003301580002").execute();						waitForInterrupt();
		
		new Logout().execute();
		WebDriverEngine.Close();
		WebDriverEngine.quit();
		logCat.endLog();
	}
	
	private static String registerSM2() {
		RegisterCOM reg = new RegisterCOM(1);		
		reg.execute();							
		return reg.getAppID();
	}
	
	private static void registerAndScanningCOM(String appID, String CIF){
		new GotoApp(appID).execute();						waitForInterrupt();			
//		new NCBCOM(1).execute();							waitForInterrupt();	
		new CustomerAddCOM(1).execute();					waitForInterrupt();	
//		new CustomerAddCOM(2).execute();					waitForInterrupt();	
		new LoanFormAddCOM(1).execute();					waitForInterrupt();
//		new CollacteralAddLandCOM(1).execute();				waitForInterrupt();
//		new CollacteralAddLandAndBuildingCOM(1).execute();	waitForInterrupt();
		new CollacteralAddWarranter(1).execute();			waitForInterrupt();
//		new RequireDocuments().execute();
//		new AttachFiles().execute();						waitForInterrupt();
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
		System.out.println("Enter the first number");
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
}

/*
driver.get("https://10.251.108.203/LOR/login.jsp");

driver.findElement(By.id("j_username")).sendKeys("adisakc");
driver.findElement(By.id("j_password")).sendKeys("testuser");
driver.findElement(By.id("wp-submit")).click();
/*
/*
  driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")).click();

  Robot robot = new Robot();
  robot.keyPress(KeyEvent.VK_ENTER);
 */
/*
JavascriptExecutor executor = (JavascriptExecutor) driver;
executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));

String i = driver.getCurrentUrl();
System.out.println(i);
driver.close();
*/