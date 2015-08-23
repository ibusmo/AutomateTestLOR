package output;

import java.util.ArrayList;
import java.util.List;

import output.LogStatus.logaction;
import output.LogStatus.logexestatus;
import output.LogStatus.logoperation;
import output.LogStatus.logpage;

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
		loging(logStr);
	}
	
	public void sendToLog(logexestatus logexestatus, logoperation logoperation, logpage logpage){
		String logStr = "["+logexestatus+"]\t"
						+"{"+logoperation+"}\t"
						+"-"+logpage+"\t";
		loging(logStr);
	}
	
	public void sendToLog(logexestatus logexestatus, logoperation logoperation, logpage logpage, String str){
		String logStr = "["+logexestatus+"]\t"
						+"{"+logoperation+"}\t"
						+"-"+logpage+"\t"
						+"-"+str;
		loging(logStr);
	}
	
	public void sendToLog(logexestatus logexestatus, logoperation logoperation, logpage logpage, logaction logaction){
		String logStr = "["+logexestatus+"]\t"
						+"{"+logoperation+"}\t"
						+"-"+logpage+"\t"
						+"-"+logaction+"\t";
		loging(logStr);
	}
	
	public void sendToLog(logexestatus logexestatus, logoperation logoperation, logpage logpage, logaction logaction, String str){
		String logStr = "["+logexestatus+"]\t"
						+"{"+logoperation+"}\t"
						+"-"+logpage+"\t"
						+"-"+logaction+"\t"
						+"-"+str;
		loging(logStr);
	}
	
	public void loging(String logStr){
		logString.add(logStr);
		logToFile.writeln(logStr);
		System.out.println(logStr);
	}
	
	public void endLog(){
		logToFile.closeFile();
	}
}
