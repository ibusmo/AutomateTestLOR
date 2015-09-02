package keyword.assignment;

import keyword.common.SendWork;
import output.LogTag.logoperation;

public class ASSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.Assigment).execute()==false){
			return false;
		}
		return true;		
	}
}
