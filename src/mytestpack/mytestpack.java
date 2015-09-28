package mytestpack;
import log.LogCat;
import webdriver.WebDriverEngine;

public class mytestpack {
	public static void main(String[] args){		
		//Init LOG and DRIVER
		LogCat logCat = LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");	
		
		new COMOperation().LORasCOM();
		
		WebDriverEngine.Close();
		WebDriverEngine.quit();
		logCat.endLog();
	}
	

	
	
	

	

	
	
	
	
	
	
	
	

	

	

	

	





	

}
