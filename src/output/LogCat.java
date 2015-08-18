package output;

import java.util.ArrayList;
import java.util.List;

public class LogCat {
	private static LogCat instance = null;
	private static List<String> logString;
	private static LogToFile logToFile;
	
	public static LogCat getInstance(){
		if(instance == null){
			instance = new LogCat();
			logString = new ArrayList<String>();
			logToFile = new LogToFile();
		}
		return instance;
	}
	
	public void sendToLog(String logStr){
		logString.add(logStr);
		logToFile.writeln(logStr);
		System.out.println(logStr);
	}
	
	public void endLog(){
		logToFile.closeFile();
	}
}
