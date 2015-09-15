package customcomponent;

import org.openqa.selenium.By;
import testdata.elementObj;
import testdata.CellTag.fieldType;

public class Type implements CustomComponent{
	
	public void RunText(elementObj obj) {
		auto(obj.filedType, obj.fieldName, obj.dataTag);
	}
	
	public void auto(fieldType filedType, String field, String value) {
		switch(filedType){
		case id:
			id(field, value);
			break;
		case name:
			name(field, value);
			break;
		case xpath:
			xpath(field, value);
			break;
		case linktext:
			linkText(field, value);
			break;
		}
	}

	public void id(String field, String value){
		new WaitFor().id(field);
		driver.findElement(By.id(field)).clear();
		driver.findElement(By.id(field)).sendKeys(value);
	}

	public void name(String field, String value){
		new WaitFor().name(field);
		driver.findElement(By.name(field)).clear();
		driver.findElement(By.name(field)).sendKeys(value);
	}

	public void linkText(String field, String value){
		new WaitFor().linkText(field);
		driver.findElement(By.linkText(field)).clear();
		driver.findElement(By.linkText(field)).sendKeys(value);
	}

	public void xpath(String field, String value){
		new WaitFor().xpath(field);
		driver.findElement(By.xpath(field)).clear();
		driver.findElement(By.xpath(field)).sendKeys(value);
	}
}
