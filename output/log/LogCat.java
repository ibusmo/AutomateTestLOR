package log;

import java.util.ArrayList;
import java.util.List;

import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import mytestpack.EnvironmentVariable;

public class LogCat {
	private static LogCat instance = null;
	private static List<String> logString = null;
	private static LogToFile logToFile = null;
	private static String filePath = null;
	
	public static LogCat getInstance(){
		if(instance == null){
			filePath = EnvironmentVariable.logPath;
			instance = new LogCat();
			logString = new ArrayList<String>();
			logToFile = new LogToFile(filePath);
		}
		return instance;
	}
	
	public static LogCat getInstance(String filePathStr){
		if(instance == null){
			filePath = filePathStr;
			instance = new LogCat();
			logString = new ArrayList<String>();
			logToFile = new LogToFile(filePath);
		}
		return instance;
	}
	
	public void sendToLog(String logStr){
		loging(logStr);
	}
	
	public void sendToLog(logexestatus logexestatus, 
							logoperation logoperation, 
							logtab logtab,
							logsubtab logsubtab,
							logelement logelement,
							logaction logaction,
							String str){
		String logStr = "";
		if(logexestatus != log.LogTag.logexestatus.None)
			logStr += String.format("%-10s","["+logexestatus+"]");
		if(logoperation != log.LogTag.logoperation.None)
			logStr += String.format("%-15s","{"+logoperation+"}");
		if(logtab != log.LogTag.logtab.None)
			logStr += String.format("%-15s","-"+logtab+"");
		if(logsubtab != log.LogTag.logsubtab.None)
			logStr += String.format("%-15s","-"+logsubtab+"");
		if(logelement != log.LogTag.logelement.None)
			logStr += String.format("%-15s","-"+logelement+"");
		if(logaction != log.LogTag.logaction.None)
			logStr += String.format("%-15s","-"+logaction+"");
		if(str != null)
			logStr += String.format("%-15s","-"+str+"");
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
