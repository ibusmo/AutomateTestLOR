package mytestpack;

import java.io.IOException;

import keyword.NCB.CustomerNCB;
import keyword.authenticate.LogIn;
import keyword.authenticate.LogOut;
import keyword.helper.GotoApp;
import keyword.helper.OpenBrowser;
import keyword.registerandscnanning.LoanFormAdd;
import output.LogCat;
import webdriver.WebDriverEngine;
//26/08/2015 09:56
public class mytestpack {
	public static void main(String[] args){
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox"); //IE
		
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		//new CertificateClick().execute();
		new LogIn("SuwitL", "testuser").execute();
		//new Register().execute();
		//050908580043 050908580033 050908580044
		new GotoApp("050908580044").execute();
		new LoanFormAdd().execute();
		waitForInterrupt();
		//new Customer().execute();
		//new TabPolicy().execute();
		//new CustomerNCB().execute();
		waitForInterrupt();
		new LogOut().execute();
		
		WebDriverEngine.Close();
		logCat.endLog();
	}

	private static void waitForInterrupt() {
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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