package customcomponent;

import org.openqa.selenium.By;
import testdata.elementObj;
import testdata.CellTag.fieldType;

public class Dropdown implements CustomComponent{
	
	public void RunDropdown(elementObj obj, boolean notext) {
		auto(obj.fieldType, obj.fieldName, obj.value,  obj.fieldOpnal, obj.dataTag, obj.jsExe, notext);
	}
	
	public void auto(fieldType filedNameType, String selectField, String selectValue, String inputField, String inputValue, String jsExe, boolean noText) {
		switch(filedNameType){
		case id:
			if(jsExe.length()<6 && jsExe.toLowerCase().contains("null")){
				if(noText==true)
					idNoText(inputField, inputValue, selectField, selectValue);
				else
					id(inputField, inputValue, selectField, selectValue);
			}
			else{
				if(noText==true)
					idNoText(inputField, inputValue, selectField, selectValue, jsExe);
				else
					id(inputField, inputValue, selectField, selectValue, jsExe);
			}
			break;
		case name:
			if(jsExe.length()<6 && jsExe.toLowerCase().contains("null")){
				if(noText==true)
					nameNoText(inputField, inputValue, selectField, selectValue);
				else
					name(inputField, inputValue, selectField, selectValue);
			}
			else{
				if(noText==true)
					nameNoText(inputField, inputValue, selectField, selectValue, jsExe);
				else
					name(inputField, inputValue, selectField, selectValue, jsExe);
			}
			break;
		default:
			break;
		}
	}
	
	public void id(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		new Type().xpath(inputField, inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void idNoText(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void id(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		new Type().xpath(inputField, inputValue);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
		executor.executeScript(replaceValue(jsExe, selectValue), driver.findElement(By.id(selectField)));
	}
	
	public void idNoText(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
		executor.executeScript(replaceValue(jsExe, selectValue), driver.findElement(By.id(selectField)));
	}
	
	public void name(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		new Type().xpath(inputField, inputValue);
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
	}	
	
	public void nameNoText(String inputField, String inputValue, String selectField, String selectValue) {
		new WaitFor().xpath(inputField);
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
	}
	
	public void name(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		new Type().xpath(inputField, inputValue);
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
		executor.executeScript(replaceValue(jsExe, selectValue), driver.findElement(By.name(selectField)));
	}
	public void nameNoText(String inputField, String inputValue, String selectField, String selectValue, String jsExe) {
		new WaitFor().xpath(inputField);
		new Type().xpath(inputField, inputValue);
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
		executor.executeScript(replaceValue(jsExe, selectValue), driver.findElement(By.name(selectField)));
	}

	public void id(String selectField, String selectValue, String jEXE) {
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
		executor.executeScript(replaceValue(jEXE, selectValue), driver.findElement(By.id(selectField)));		
	}
	
	public void name(String selectField, String selectValue, String jsExe) {
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
		executor.executeScript(replaceValue(jsExe, selectValue), driver.findElement(By.name(selectField)));
	}

	public void id(String selectField, String selectValue) {
		String jQuery = "$('#"+selectField+"').val('"+selectValue+"');";
		//new WaitFor().id(selectField);
		executor.executeScript(jQuery, driver.findElement(By.id(selectField)));
	}
	
	public void name(String selectField, String selectValue) {
		String jQuery = "$(\"select[name*='"+selectField+"']\").val( '"+selectValue+"' );";
		//new WaitFor().name(selectField);
		executor.executeScript(jQuery, driver.findElement(By.name(selectField)));
	}
	
	private String replaceValue(String str, String val){
		str = str.replaceAll("this.value", "'"+val+"'");
		str = str.replaceAll("this", val);
		return str;
	}
}
