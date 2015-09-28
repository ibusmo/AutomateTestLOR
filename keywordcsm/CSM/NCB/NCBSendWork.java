package CSM.NCB;

import common.SendWork;
import log.LogTag.logoperation;

public class NCBSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
