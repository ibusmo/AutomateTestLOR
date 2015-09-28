package helper;


import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;
import webdriver.WebDriverEngine;

public class OpenBrowser implements base.KeywordsCSM {
	private String url;
	
	public OpenBrowser() {
		// TODO Auto-generated constructor stub
	}	
	
	public OpenBrowser(String url) {
		this.url = url;
	}

	@Override
	public void initKeywords() {
		//setUrl("https://10.251.108.203/LOR/login.jsp");
	}

	@Override
	public boolean execute() {
		driver.get(url);
		// Config driver here
		WebDriverEngine.getDriver().manage().window().maximize();
		sendToLogFinish();
		return true;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void sendToLogStart() {
		// TODO Auto-generated method stub
	}

	@Override
	public void sendToLogFinish() {
		logCat.sendToLog(logexestatus.PASS, logoperation.OpenBrowser, logtab.None, logsubtab.None, logelement.None, logaction.None, url);
	}

}
