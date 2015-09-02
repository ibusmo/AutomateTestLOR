package keyword.basicinfocheck;

import keyword.common.SendWork;
import output.LogTag.logoperation;

public class BICSendWork {
	public boolean execute(){
		if(new SendWork(logoperation.BasiInfo).execute()==false){
			return false;
		}
		return true;		
	}
}
