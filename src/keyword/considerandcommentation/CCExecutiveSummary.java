package keyword.considerandcommentation;

import keyword.common.ExecutiveSummary;
import output.LogTag.logoperation;

public class CCExecutiveSummary {
	public boolean execute(){
		if(new ExecutiveSummary(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
