package keyword.basicinfocheck;

import keyword.common.ExecutiveSummary;
import output.LogTag.logoperation;

public class BICExecutiveSummary {
	public boolean execute(){
		if(new ExecutiveSummary(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
