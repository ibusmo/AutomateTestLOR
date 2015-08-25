package output;

import java.util.ArrayList;
import java.util.List;

import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

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
	
	public void sendToLog(logexestatus logexestatus, 
							logoperation logoperation, 
							logtab logtab,
							logsubtab logsubtab,
							logelement logelement,
							logaction logaction,
							String str){
		String logStr = "";
		if(logexestatus != output.LogTag.logexestatus.None)
			logStr += String.format("%-10s","["+logexestatus+"]");
		if(logoperation != output.LogTag.logoperation.None)
			logStr += String.format("%-15s","{"+logoperation+"}");
		if(logtab != output.LogTag.logtab.None)
			logStr += String.format("%-15s","-"+logtab+"");
		if(logsubtab != output.LogTag.logsubtab.None)
			logStr += String.format("%-15s","-"+logsubtab+"");
		if(logelement != output.LogTag.logelement.None)
			logStr += String.format("%-15s","-"+logelement+"");
		if(logaction != output.LogTag.logaction.None)
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
