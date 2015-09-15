package customcomponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testdata.elementObj;
import testdata.CellTag.fieldType;

public class Radio implements CustomComponent{
	
	public void RunRadio(elementObj obj) {
		auto(obj.filedType, obj.fieldName, obj.value);
	}
	
	public void auto(fieldType field, String fieldName, String value) {
		switch(field){
		case id:
			break;
		case name:
			name(fieldName, Integer.parseInt(value));
			break;
		case xpath:
			break;
		case linktext:
			break;
		}
	}
	
	public void name(String field, int value){
		new WaitFor().name(field);
		List<WebElement> radios = driver.findElements(By.name(field));
		radios.get(value).click();
	}
	
}
