package keyword.considerandcommentation;

import keyword.common.SendWork;
import output.LogTag.logoperation;

public class CCSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
