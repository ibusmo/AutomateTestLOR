package CMS.assignment;

import common.SendWork;
import log.LogTag.logoperation;

public class ASSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.Assigment).execute()==false){
			return false;
		}
		return true;		
	}
}
