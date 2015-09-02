package customcomponent;

import org.openqa.selenium.By;

public class DatePicker implements CustomComponent{
	public void pickDate(String inputDateField, String dateStr){
		new WaitFor().id(inputDateField);
		String jQuery = "$('#"+inputDateField+"').val('"+dateStr+"');";
		executor.executeScript(jQuery, driver.findElement(By.id(inputDateField)));
	}
}
