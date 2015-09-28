package CMS.assignment;

import CSM.loanapp.LoanAppEdit;
import base.KeywordsCSM;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class GetCMSNum implements KeywordsCSM {

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
