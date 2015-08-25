package CustomComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitFor implements CustomComponent {
	public void element(By obj){
		wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
	}
	public void id(String id){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	public void name(String name){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	}
	public void xpath(String xpath){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
}
