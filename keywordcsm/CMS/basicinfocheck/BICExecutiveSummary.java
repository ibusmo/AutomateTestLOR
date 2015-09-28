package CMS.basicinfocheck;

import common.ExecutiveSummary;
import log.LogTag.logoperation;

public class BICExecutiveSummary {
	public boolean execute(){
		if(new ExecutiveSummary(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
