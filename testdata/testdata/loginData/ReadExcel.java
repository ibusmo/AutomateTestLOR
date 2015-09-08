package testdata.loginData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testdata.CellTag.col;

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
		String data = cellTmp==null ? "" : cellTmp.toString();
		return data;
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
