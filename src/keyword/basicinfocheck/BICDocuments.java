package keyword.basicinfocheck;

import keyword.common.AttachFiles;
import output.LogTag.logoperation;

public class BICDocuments {
	public boolean execute(){
//		if(new RequireDocuments(logoperation.BasiInfo).execute()==false){
//			//return false;
//		}
		if(new AttachFiles(logoperation.BasiInfo).execute()==false){
			return false;
		}
		return true;		
	}
}
