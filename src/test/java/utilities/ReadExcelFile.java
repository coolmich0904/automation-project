package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	String data;
	
	public ReadExcelFile (String excelpath) {
		try {
		File src = new File(excelpath);
		FileInputStream fs = new FileInputStream(src);
		wb = new XSSFWorkbook(fs);
		sheet =  wb.getSheetAt(0);
		
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public String getData (int sheetnumber, int row, int col) {
		try {
		sheet = wb.getSheetAt(sheetnumber);
		data = sheet.getRow(row).getCell(col).getStringCellValue();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		System.out.println(row);
		row =  row +1;
		return row;
	}
	//Method return the number of columns in excel sheet
	
}
