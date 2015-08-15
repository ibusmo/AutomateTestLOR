package output;

import java.util.ArrayList;
import java.util.List;

public class LogCat {
	private static LogCat instance = null;
	private static List<String> logString = new ArrayList<String>();
	
	public static LogCat getInstance(){
		if(instance == null){
			instance = new LogCat();
		}
		return instance;
	}
	
	public void sendToLog(String logStr){
		logString.add(logStr);
		System.out.println(logStr);
	}
}
