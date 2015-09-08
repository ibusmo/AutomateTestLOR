package customcomponent;

import java.time.LocalDateTime;

import org.openqa.selenium.By;

public class DatePicker implements CustomComponent{
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
