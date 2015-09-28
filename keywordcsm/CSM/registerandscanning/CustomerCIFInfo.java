package CSM.registerandscanning;

import org.openqa.selenium.TimeoutException;

import base.KeywordsCSM;
import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class CustomerCIFInfo implements KeywordsCSM{

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	
	public boolean execute() {
		sendToLogStart();
		try{
			sendToLogCustom(logexestatus.PASS, logaction.Click, "ข้อมูล CIF" +  "ข้อมูล CIF");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "ข้อมูล CIF" +  "ข้อมูล CIF");
		}
		
		sendToLogFinish();
		return true;
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
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFInfo, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegScanning, logtab.RegCustomer, logsubtab.CIFInfo, logelement.None,
				logaction, str);
	}
}
