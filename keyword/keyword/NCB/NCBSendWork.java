package keyword.NCB;

import keyword.common.SendWork;
import output.LogTag.logoperation;

public class NCBSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
