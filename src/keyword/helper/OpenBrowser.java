package keyword.helper;

import keyword.Keywords;

public class OpenBrowser implements Keywords {
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
		sendToLog();
		return true;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public boolean sendToLog() {
		logCat.sendToLog("[PASS]\t -Open & Go\t " + "-" + url);
		return true;
	}

}
