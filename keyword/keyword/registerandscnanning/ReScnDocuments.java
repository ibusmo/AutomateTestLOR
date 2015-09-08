package keyword.registerandscnanning;

import keyword.common.AttachFiles;
import keyword.common.RequireDocuments;
import output.LogTag.logoperation;

public class ReScnDocuments {
	public boolean execute(){
		if(new RequireDocuments(logoperation.RegScanning).execute()==false){
			return false;
		}
		if(new AttachFiles(logoperation.RegScanning).execute()==false){
			return false;
		}
		return true;		
	}
}
