package customcomponent;

import java.time.LocalDateTime;

import org.openqa.selenium.By;

import testdata.CellTag.fieldType;
import testdata.elementObj;

public class DatePicker implements CustomComponent{
	
	public void runDatePicker(elementObj obj){
		auto(obj.filedType, obj.fieldName, obj.dataTag);
	}
	
	private void auto(fieldType filedType, String inputDateField, String dateStr) {
		if(dateStr=="today"){
			dateStr = getCurDate();
		}
		else if(dateStr=="yesterday"){
			dateStr = getPrevDate();
		}
		else if(dateStr=="tomorrow"){
			dateStr = getNextDate();
		}
		switch(filedType){
		case id:
			idSetDate(inputDateField, dateStr);
			break;
		case name:
			nameSetDate(inputDateField, dateStr);
			break;
		default:
			break;
		}
	}

	public void idSetDate(String inputDateField, String dateStr){
		new WaitFor().id(inputDateField);
		String jQuery = "$('#"+inputDateField+"').val('"+dateStr+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(inputDateField)));
	}	
	
	public void nameSetDate(String inputDateField, String dateStr){
		new WaitFor().name(inputDateField);
		//String jQuery = "$('#"+inputDateField+"').val('"+dateStr+"');";
		String jQuery = "$(\"input[name*='"+inputDateField+"']\").val( '"+dateStr+"' );";
		executor.executeScript(jQuery, driver.findElement(By.name(inputDateField)));
	}	
	
	public String getCurDate() {
		String localTime = "" + String.format("%02d", LocalDateTime.now().getDayOfMonth()) + "/"
				+ String.format("%02d", LocalDateTime.now().getMonthValue()) + "/" + LocalDateTime.now().getYear();
		return localTime;
	}	
	public String getPrevDate() {
		String localTime = "" + String.format("%02d", LocalDateTime.now().minusDays(1).getDayOfMonth()) + "/"
				+ String.format("%02d", LocalDateTime.now().getMonthValue()) + "/" + LocalDateTime.now().getYear();
		return localTime;
	}
	public String getNextDate() {
		String localTime = "" + String.format("%02d", LocalDateTime.now().plusDays(1).getDayOfMonth()) + "/"
				+ String.format("%02d", LocalDateTime.now().getMonthValue()) + "/" + LocalDateTime.now().getYear();
		return localTime;
	}
}
