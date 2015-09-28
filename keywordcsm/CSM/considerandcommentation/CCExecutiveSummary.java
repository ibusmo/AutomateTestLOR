package CSM.considerandcommentation;

import common.ExecutiveSummary;
import log.LogTag.logoperation;

public class CCExecutiveSummary {
	public boolean execute(){
		if(new ExecutiveSummary(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
