package mytestpack;

import java.util.Random;
import java.util.Scanner;

import keyword.NCB.NCB;
import keyword.NCB.NCBSendWork;
import keyword.authenticate.LogIn;
import keyword.authenticate.LogOut;
import keyword.basicinfocheck.BICDocuments;
import keyword.basicinfocheck.BICExecutiveSummary;
import keyword.basicinfocheck.BICSendWork;
import keyword.considerandcommentation.CCDocuments;
import keyword.considerandcommentation.CCExecutiveSummary;
import keyword.considerandcommentation.CCSendWork;
import keyword.considerandcommentation.CollateralAdd;
import keyword.considerandcommentation.CollateralInfo;
import keyword.considerandcommentation.CollateralMortgage;
import keyword.helper.GotoApp;
import keyword.helper.OpenBrowser;
import keyword.register.Register;
import keyword.registerandscnanning.CustomerAdd;
import keyword.registerandscnanning.CustomerCIFInfo;
import keyword.registerandscnanning.CustomerExpenses;
import keyword.registerandscnanning.CustomerIncome;
import keyword.registerandscnanning.CustomerNonNCB;
import keyword.registerandscnanning.CustomerOtherInfo;
import keyword.registerandscnanning.ReScnDocuments;
import keyword.registerandscnanning.RegScnSendWork;
import keyword.registerandscnanning.LoanFormAdd;
import keyword.registerandscnanning.LoanFormLongTermLoan;
import keyword.registerandscnanning.TabPolicy;
import output.LogCat;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){		
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");		
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		new LogIn("SuwitL", "testuser").execute();			addSpace();

		String appID = "050908580057";
		String CIF = "1357";
		
		appID = register();								waitForInterrupt();
		registerandscanning(appID, CIF);					waitForInterrupt();
		ncb(appID);										waitForInterrupt();
		considerAndCommentation(appID);					waitForInterrupt();
		new LogOut().execute();							waitForInterrupt();
		
		new LogIn("BoonthamC", "testuser").execute();		waitForInterrupt();
		basicInfoCheck(appID);								waitForInterrupt();
		
		new LogOut().execute();							
		
		WebDriverEngine.Close();
		logCat.endLog();
	}
	
	private static void basicInfoCheck(String appID) {
		new GotoApp(appID).execute();					addSpace();
		
		new BICExecutiveSummary().execute();				addSpace();
		new BICDocuments().execute();		addSpace();
		//new RequireDocuments().execute();				addSpace();
		//new AttachFiles().execute();					addSpace();
		
		new BICSendWork().execute();			addSpace();
	}
	
	private static void considerAndCommentation(String appID) {
		new GotoApp(appID).execute();					addSpace();
		
		new CollateralAdd().execute();					addSpace();
		new CollateralMortgage().execute();					addSpace();
		new CollateralInfo().execute();					addSpace();
		
		new CCExecutiveSummary().execute();				addSpace();
		new CCDocuments().execute();			addSpace();
		//new RequireDocuments().execute();				addSpace();
		//new AttachFiles().execute();					addSpace();
		
		new CCSendWork().execute();			addSpace();
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
		new CustomerOtherInfo("1", "3", "5", "7", "9").execute();								addSpace();
		new CustomerIncome("2", "20000", "1000", "1000", "1000", "1000", "1000").execute();		addSpace();
		new CustomerExpenses("8000").execute();			addSpace();
		new CustomerNonNCB("0").execute();				addSpace();
														
		new LoanFormAdd().execute();					addSpace();
		new LoanFormLongTermLoan().execute();			addSpace();
		
		new ReScnDocuments().execute();		addSpace();
		//new RequireDocuments().execute();				addSpace();
		//new AttachFiles().execute();					addSpace();	
		
		new TabPolicy().execute();						addSpace();
		
		new RegScnSendWork().execute();			addSpace();
	}

	private static String register() {
		Register register = new Register();				
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
		String x = reader.nextLine();
		
		addSpace();
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