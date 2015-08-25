package CustomComponent;

import org.openqa.selenium.By;

public class SelectDropdown implements CustomComponent{
	
	public void select(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void select(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String selectExe = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(selectExe, driver.findElement(By.id(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.id(selectField)));
	}
}
