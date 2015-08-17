package defaultKeyword;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class LogOut implements Keywords {

	@Override
	public void initKeywords() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean execute() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("redirect('j_acegi_logout');", driver.findElement(By.xpath("//*[@id='menu-vertical']/ul/li[9]/div/a")));
		return false;
	}

}
