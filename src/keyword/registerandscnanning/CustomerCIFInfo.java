package keyword.registerandscnanning;

import org.openqa.selenium.TimeoutException;

import keyword.Keywords;
import output.LogTag.logaction;
import output.LogTag.logelement;
import output.LogTag.logexestatus;
import output.LogTag.logoperation;
import output.LogTag.logsubtab;
import output.LogTag.logtab;

public class CustomerCIFInfo implements Keywords{

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}
	
	
	public boolean execute() {
		sendToLogStart();
		try{
			sendToLogCustom(logexestatus.PASS, logaction.Click, "㈤土倥 CIF" +  "㈤土倥 CIF");
		}catch (TimeoutException e){
			sendToLogCustom(logexestatus.FAIL, logaction.Click, "㈤土倥 CIF" +  "㈤土倥 CIF");
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
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, null);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.RegisScan, logtab.RegisCust, logsubtab.Add, logelement.None,
				logaction, str);
	}
}
