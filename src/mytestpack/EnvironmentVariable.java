package mytestpack;

public class EnvironmentVariable {
	
	private static EnvironmentVariable instance = null;
	public static String logPath = null;
	public static String excelPath = null;
	
	private EnvironmentVariable(){
		
	}
	
	public static EnvironmentVariable getInstance(){
		if(instance == null){
			instance = new EnvironmentVariable();
		}
		return instance;
	}	
	
	public static EnvironmentVariable getInstance(String log, String excel){
		if(instance == null){
			instance = new EnvironmentVariable();
			logPath = log;
			excelPath = excel;
		}
		return instance;
	}
	
}
