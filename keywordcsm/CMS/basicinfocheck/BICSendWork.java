package CMS.basicinfocheck;

import common.SendWork;
import log.LogTag.logoperation;

public class BICSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.BasiInfo).execute()==false){
			return false;
		}
		return true;		
	}
}
