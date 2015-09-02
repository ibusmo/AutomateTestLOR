package customcomponent;

import org.openqa.selenium.By;

public class SelectDropdown implements CustomComponent{

	public void id(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void idNoText(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		//driver.findElement(By.xpath(inputField)).clear();
		//driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void id(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.id(selectField)));
	}
	
	public void idNoText(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		//driver.findElement(By.xpath(inputField)).clear();
		//driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.id(selectField)));
	}
	
	public void name(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		//String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		String jQuery = "$(\"input[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
	}	
	
	public void nameNoText(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		//driver.findElement(By.xpath(inputField)).clear();
		//driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		//String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		String jQuery = "$(\"input[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
	}
	
	public void name(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$(\"input[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.name(selectField)));
	}
	public void nameNoText(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		//driver.findElement(By.xpath(inputField)).clear();
		//driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$(\"input[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.name(selectField)));
	}
}
