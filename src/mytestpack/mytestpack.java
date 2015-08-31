package mytestpack;

import java.util.Scanner;

import keyword.NCB.NCB;
import keyword.authenticate.LogIn;
import keyword.authenticate.LogOut;
import keyword.considerandcommentation.ExecutiveSummary;
import keyword.helper.GotoApp;
import keyword.helper.OpenBrowser;
import keyword.register.Register;
import keyword.registerandscnanning.AttachFiles;
import keyword.registerandscnanning.CustomerAdd;
import keyword.registerandscnanning.CustomerCIFInfo;
import keyword.registerandscnanning.CustomerExpenses;
import keyword.registerandscnanning.CustomerIncome;
import keyword.registerandscnanning.CustomerNonNCB;
import keyword.registerandscnanning.CustomerOtherInfo;
import keyword.registerandscnanning.LoanFormAdd;
import keyword.registerandscnanning.LoanFormLongTermLoan;
import keyword.registerandscnanning.RequireDocuments;
import keyword.registerandscnanning.SendWork;
import keyword.registerandscnanning.TabPolicy;
import output.LogCat;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){		
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");		
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		new LogIn("SuwitL", "testuser").execute();		addSpace();
		
		String appID = "";
		String CIF = "1357";

		//appID = register();								waitForInterrupt();
		//registerandscanning(appID, CIF);				waitForInterrupt();
		//ncb(appID);										waitForInterrupt();
		
		appID = "050908580054";
		new GotoApp(appID).execute();					waitForInterrupt();
		new AttachFiles().execute();					waitForInterrupt();	
		
//		new ExecutiveSummary().execute();				waitForInterrupt();
//		new RequireDocuments().execute();				waitForInterrupt();
//		new AttachFiles().execute();					waitForInterrupt();	
		
		new LogOut().execute();							
		
		WebDriverEngine.Close();
		logCat.endLog();
	}
	
	private static void ncb(String appID) {
		new GotoApp(appID).execute();					addSpace();
		
		new NCB().execute();							addSpace();
		
		new SendWork().execute();						addSpace();
	}

	private static void registerandscanning(String appID, String CIF) {
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		new GotoApp(appID).execute();					addSpace();
														
		new CustomerAdd(CIF).execute();					addSpace();
		new CustomerCIFInfo().execute();				addSpace();
		new CustomerOtherInfo("1", "3", "5", "7", "9").execute();								addSpace();
		new CustomerIncome("2", "20000", "1000", "1000", "1000", "1000", "1000").execute();		addSpace();
		new CustomerExpenses("8000").execute();			addSpace();
		new CustomerNonNCB("0").execute();				addSpace();
														
		new LoanFormAdd().execute();					addSpace();
		new LoanFormLongTermLoan().execute();			addSpace();
		
		new RequireDocuments().execute();				addSpace();
		new AttachFiles().execute();					addSpace();	
		
		new TabPolicy().execute();						addSpace();
		
		new SendWork().execute();						addSpace();
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
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