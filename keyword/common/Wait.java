package common;
import base.KeywordsCOM;
import log.LogTag.logaction;
import log.LogTag.logexestatus;

public class Wait extends KeywordsCOM {

	int msTime;
	
	public Wait(int msTIme){
		this.msTime = msTIme;
		initKeywords();
	}
	
	public Wait(String msTIme){
		this.msTime = (int) Math.round(Double.parseDouble(msTIme));
		initKeywords();
	}	
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.Wait;
		super.logtab 			= log.LogTag.logtab.Wait;
		super.logsubtab 		= log.LogTag.logsubtab.None;	
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			Thread.sleep(msTime);
			sendToLogCustom(logexestatus.PASS, logaction.Wait, "Wait for " + msTime + " ms");
		} catch (InterruptedException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Wait, "Wait for " + msTime + " ms");
			e.printStackTrace();		
			return false;
		}
		sendToLogFinish();
		return true;
	}
}
