package CustomComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.WebDriverEngine;

public class SelectDropdown {
	private WebDriver driver = WebDriverEngine.getDriver();
	private WebDriverWait wait = WebDriverEngine.getDriverWait();
	private JavascriptExecutor executor = WebDriverEngine.getExecutor();
	
	public void select(String inputField, String inputValue, String selectField, String selectValue) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputField)));
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void select(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(inputField)));
		driver.findElement(By.xpath(inputField)).clear();
		driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
		String selectExe = "$('#"+selectField+"').val('"+selectValue+"');";
		executor.executeScript(selectExe, driver.findElement(By.id(selectField)));
		executor.executeScript(jsExe, driver.findElement(By.id(selectField)));
	}
}
