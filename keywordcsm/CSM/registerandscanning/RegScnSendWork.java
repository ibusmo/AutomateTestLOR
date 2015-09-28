package CSM.registerandscanning;

import common.SendWork;
import log.LogTag.logoperation;

public class RegScnSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.RegScanning).execute()==false){
			return false;
		}
		return true;		
	}
}
