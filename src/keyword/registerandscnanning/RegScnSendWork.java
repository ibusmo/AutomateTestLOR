package keyword.registerandscnanning;

import keyword.common.SendWork;
import output.LogTag.logoperation;

public class RegScnSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.RegScanning).execute()==false){
			return false;
		}
		return true;		
	}
}
