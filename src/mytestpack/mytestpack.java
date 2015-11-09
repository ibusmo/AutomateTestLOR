package mytestpack;

import java.util.Scanner;

import autocms.ListOfCMS;
import creditanalysis.CA;
import helper.GotoApp;
import helper.Login;
import helper.Logout;
import helper.OpenBrowser;
import log.LogCat;
import webdriver.WebDriverEngine;

public class mytestpack {
	public static void main(String[] args){		
		String filePath = "C:\\Users\\EthanHuntTB1\\Desktop\\testdata\\";
		String fileName = "testdata";
		
		//fileName = "testdata";
		
		//Init LOG and DRIVER
		EnvironmentVariable.getInstance(filePath + fileName + ".log", filePath + fileName + ".xlsx");
		LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");	

		new COMAutoOperation().LORasCOM();		
//		new COMManualOperation().LORasCOM();
//		CMSValuation2("038311580031");
//		CA();
		
		WebDriverEngine.Close();
		WebDriverEngine.quit();
	}
	
	@SuppressWarnings("unused")
	private static void CA(){
		//new OpenBrowser("http://172.31.1.41:55011/LOR/login.jsp").execute();
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		new Login("RoongrojW", "testuser").execute();
		new GotoApp("050910580002").execute();
		new CA().execute();
		waitForInterrupt();
		new Logout().execute();
	}
	
	@SuppressWarnings("unused")
	private static void CMSValuation2(String appID) {
		new OpenBrowser("http://172.31.1.42:9080/CMS/login.jsp").execute();
//		new OpenBrowser("https://10.251.108.202/CMS/login.jsp").execute();
		WebDriverEngine.getDriver().manage().window().maximize();
		new Login("SomchaiA", "testuser").execute();
//		new Login("PisutC", "testuser").execute();
//		new Login("UraiwanK", "testuser").execute();
		waitForInterrupt();
		new ListOfCMS(appID).execute();
		waitForInterrupt();
		new Logout().execute();
	}
	
	@SuppressWarnings("resource")
	private static void waitForInterrupt() {
		System.out.println("Enter to continue");
		new Scanner(System.in).nextLine();
	}
	
}
