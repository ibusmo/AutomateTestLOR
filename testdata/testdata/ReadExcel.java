package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testdata.CellTag.col;
import testdata.CellTag.fieldType;
import testdata.CellTag.inputType;
import testdata.CellTag.sheetType;

public class ReadExcel {
	
	String WorkBookPath;
	String WorkSheetPath;
	FileInputStream fileInputStream;
	XSSFWorkbook workbook;
	XSSFSheet worksheet;
	
	public ReadExcel(String WorkBookPath, String WorkSheetPath){
		this.WorkBookPath = WorkBookPath;
		this.WorkSheetPath = WorkSheetPath;
		openFile();
	}
	
	public boolean openFile(){
		try {
			fileInputStream = new FileInputStream(WorkBookPath);			
			workbook = new XSSFWorkbook(fileInputStream);
			worksheet = workbook.getSheet(WorkSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean closeFile(){
		try {
			workbook.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String getString(col colTag, int rowTag) {
		int col = getColumnMap(colTag);
		int row = getRowMap(rowTag);
		XSSFRow rowTmp = worksheet.getRow(row);		
		XSSFCell cellTmp = rowTmp.getCell(col);
		String data;
		try{
			data = cellTmp==null ? "null" : cellTmp.getRichStringCellValue().toString();
		}catch(IllegalStateException e){
			data = cellTmp==null ? "null" : cellTmp.toString();
		}
		return data;
	}
	
	public fieldType getFlType(col colTag, int rowTag) {
		String ioStr = getString(colTag, rowTag);
		switch(ioStr){
		case "id" :
			return fieldType.id;
		case "name" :
			return fieldType.name;
		case "xpath" :
			return fieldType.xpath;
		case "linktext" :
			return fieldType.linktext;
		}
		return null;
	}	
	
	public boolean getRun(col colTag, int rowTag) {
		String run = getString(colTag, rowTag);
		switch(run){
		case "false" :
			return false;
		case "true" :
			return true;
		}
		return false;
	}
	
	public inputType getIOType(col colTag, int rowTag) {
		String typStr = getString(colTag, rowTag);
		switch(typStr){
		case "dropdown" :
			return inputType.dropdown;
		case "dropdownx" :
			return inputType.dropdownx;
		case "date" :
			return inputType.date;
		case "text" :
			return inputType.text;
		case "radio" :
			return inputType.radio;
		case "button" :
			return inputType.button;
		case "checkbox" :
			return inputType.checkbox;
		case "alert" :
			return inputType.alert;
		case "popup" :
			return inputType.popup;
		}
		return null;
	}
	
	public sheetType getSheetType(col colTag, int rowTag){
		String sheetStr = getString(colTag, rowTag).toLowerCase();
		switch(sheetStr){			
			case "lor" :							return sheetType.LOR;
			case "cms" :							return sheetType.CMS;
			case "login" :							return sheetType.Login;
			case "logout" :							return sheetType.Logout;
		
			case "register_com" :					return sheetType.Register;
			
			case "gotoapp" :						return sheetType.GotoApp;
			
			case "ncb" :							return sheetType.NCB;
			
			case "customer_add" :					return sheetType.AddCustomer;
			
			case "loanform_add" :					return sheetType.AddLoan;
			
			case "colleteral_addlandbuilding" :		return sheetType.CollLandBuiling;
			case "colleteral_addwarranter" :		return sheetType.CollWarranter;
			case "colleteral_addland" :				return sheetType.CollLand;

			case "document" :						return sheetType.Document;
			case "sendwork" :						return sheetType.SendWork;
		}
		return null;
	}

	private int getColumnMap(col colTag) {	
		char colChar = colTag.toString().charAt(0);
		if(colChar>='A' && colChar<='Z')
			return colTag.toString().charAt(0)-'A';
		else
			return colTag.toString().charAt(0)-'a';
	}
	
	private int getRowMap(int row) {
		return row-1;
	}
}
