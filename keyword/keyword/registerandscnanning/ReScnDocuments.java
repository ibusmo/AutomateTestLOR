package keyword.registerandscnanning;

import keyword.common.AttachFiles;
import keyword.common.RequireDocuments;

public class ReScnDocuments {
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
