package keyword.assignment;

import keyword.Keywords;
import keyword.loanapp.LoanAppEdit;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class GetCMSNum implements Keywords {

	String CMSNum = "";
	
	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		LoanAppEdit getCMS = new LoanAppEdit();
		if(getCMS.execute()==false)	return false;
		CMSNum = getCMS.getCMSNum();
		sendToLogFinish();
		return true;
	}
	
	public String getCMS(){
		return CMSNum;
	}
	
	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.Assigment, logtab.GetCMS, logsubtab.None, logelement.None,
				logaction, null);
	}	
	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.Assigment, logtab.GetCMS, logsubtab.None, logelement.None,
				logaction, str);
	}

}
