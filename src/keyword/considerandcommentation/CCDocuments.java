package keyword.considerandcommentation;

import keyword.common.AttachFiles;
import keyword.common.RequireDocuments;
import output.LogTag.logoperation;

public class CCDocuments {
	public boolean execute(){
		if(new RequireDocuments(logoperation.ConsComment).execute()==false){
			return false;
		}
		if(new AttachFiles(logoperation.ConsComment).execute()==false){
			return false;
		}
		return true;		
	}
}
