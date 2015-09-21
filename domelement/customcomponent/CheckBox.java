package customcomponent;

import org.openqa.selenium.By;

import testdata.elementObj;
import testdata.CellTag.fieldType;

public class CheckBox implements CustomComponent{
	
	public void RunCheckBox(elementObj obj) {
		auto(obj.filedType, obj.fieldName);
	}
	
	public void auto(fieldType filedType, String fieldName) {
		switch(filedType){
		case id:
			id(fieldName);
			break;
		case name:
			name(fieldName);
			break;
		case xpath:
			xpath(fieldName);
			break;
		case linktext:
			linkText(fieldName);
			break;
		}
	}
	
	public void id(String field){
		new WaitFor().id(field);
		driver.findElement(By.id(field)).click();
	}

	public void name(String field){
		new WaitFor().name(field);
		driver.findElement(By.name(field)).click();
	}

	public void linkText(String field){
		new WaitFor().linkText(field);
		driver.findElement(By.linkText(field)).click();
	}

	public void xpath(String field){
		new WaitFor().xpath(field);
		driver.findElement(By.xpath(field)).click();
	}
	
//	String isChecked = "false";
//	try{
//		isChecked = driver.findElement(By.name(checkBoxAssign)).getAttribute("checked");
//		if(isChecked==null)	isChecked = "false";
//
//		if(!isChecked.matches("true")){
//			driver.findElement(By.name(checkBoxAssign)).click();
//		}
//		
//		//System.out.println(isChecked);			
//	}catch(NullPointerException e){
//		isChecked = "false";
//	}	
	
}
