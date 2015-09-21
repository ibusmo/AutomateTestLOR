package keyword.basicinfocheck;

import keyword.common.AttachFiles;

public class BICDocuments {
	public boolean execute(){
//		if(new RequireDocuments(logoperation.BasiInfo).execute()==false){
//			//return false;
//		}
		if(new AttachFiles().execute()==false){
			return false;
		}
		return true;		
	}
}
