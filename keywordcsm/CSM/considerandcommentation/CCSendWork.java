package CSM.considerandcommentation;

import common.SendWork;
import log.LogTag.logoperation;

public class CCSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
