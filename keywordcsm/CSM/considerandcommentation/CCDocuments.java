package CSM.considerandcommentation;

import common.AttachFiles;
import common.RequireDocuments;

public class CCDocuments {
	public boolean execute(){
		if(new RequireDocuments().execute()==false){
			return false;
		}
		if(new AttachFiles().execute()==false){
			return false;
		}
		return true;		
	}
}
