package mytestpack;

import keyword.CertificateClick;
import keyword.LogIn;
import keyword.LogOut;
import keyword.OpenBrowser;
import keyword.Register;
import output.LogCat;
import webDriver.WebDriverEngine;

public class mytestpack {
	public static void main(String[] args){
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance(); //IE
		
		new OpenBrowser("https://10.251.108.203/LOR/login.jsp").execute();
		
		//new CertificateClick().execute();
		new LogIn("SuwitL", "testuser").execute();
		new Register().execute();
		
		new LogOut().execute();
		
		//WebDriverEngine.Close();
		logCat.endLog();
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