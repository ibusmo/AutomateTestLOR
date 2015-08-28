package mytestpack;

import java.util.Scanner;

import keyword.NCB.CustomerNCB;
import keyword.authenticate.LogIn;
import keyword.authenticate.LogOut;
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
import keyword.registerandscnanning.TabPolicy;
import output.LogCat;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){
		
		String appID = "";
		String CIF = "1357";
		
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox"); //IE
		
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		new LogIn("SuwitL", "testuser").execute();		addSpace();

		/*
		Register register = new Register();
		register.execute();
		appID = register.getAppID();
														waitForInterrupt();
		
		//050908580043 050908580033 050908580044 061108580021
		//050908580045		
		new GotoApp(appID).execute();					waitForInterrupt();
		
		new CustomerAdd(CIF).execute();					waitForInterrupt();
		new CustomerCIFInfo().execute();				waitForInterrupt();
		new CustomerOtherInfo("1", "3", "5", "7", "9").execute();								waitForInterrupt();
		new CustomerIncome("2", "20000", "1000", "1000", "1000", "1000", "1000").execute();		waitForInterrupt();
		new CustomerExpenses("8000").execute();			waitForInterrupt();
		new CustomerNonNCB("0").execute();				waitForInterrupt();

		new LoanFormAdd().execute();					waitForInterrupt();
		new LoanFormLongTermLoan().execute();			waitForInterrupt();
		
		new RequireDocuments().execute();				waitForInterrupt();
		new AttachFiles().execute();					waitForInterrupt();	
		
		new TabPolicy().execute();						waitForInterrupt();

		new AttachFiles().execute();					waitForInterrupt();	
		*/

		new GotoApp("050908580048").execute();
		new CustomerNCB().execute();
		
		new LogOut().execute();							
		
		WebDriverEngine.Close();
		logCat.endLog();
	}

	private static void waitForInterrupt() {
		addSpace();
//		@SuppressWarnings("resource")
//		Scanner reader = new Scanner(System.in);
//		System.out.println("Enter the first number");
//		// get user input for a
//		@SuppressWarnings("unused")
//		String x = reader.nextLine();
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