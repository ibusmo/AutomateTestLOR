package mytestpack;

import log.LogCat;
import webdriver.WebDriverEngine;

public class mytestpack {
	public static void main(String[] args){		
		String filePath = "C:\\Users\\EthanHuntTB1\\Desktop\\testdata\\";
		String fileName = "S_LOR2_Rel2_031";
		
		//Init LOG and DRIVER
		EnvironmentVariable.getInstance(filePath + fileName + ".log", filePath + fileName + ".xlsx");
		LogCat.getInstance();
		WebDriverEngine.getInstance("firefox");	
		
		new COMOperation().LORasCOM();
		
		WebDriverEngine.Close();
		WebDriverEngine.quit();
	}
	

	
	
	

	

	
	
	
	
	
	
	
	

	

	

	

	





	

}
