package customcomponent;

import org.openqa.selenium.Alert;

import testdata.elementObj;

public class AlertHandle implements CustomComponent{

	public void RunAlert(elementObj obj) {
		Alert javascriptprompt = driver.switchTo().alert();
		javascriptprompt.accept();
	}
	
	public void execute() {
		Alert javascriptprompt = driver.switchTo().alert();
		javascriptprompt.accept();
	}
}
