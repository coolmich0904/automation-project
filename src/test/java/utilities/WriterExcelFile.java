package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriterExcelFile {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell Cell;	 
    XSSFRow Row;
     
	public void writerExcelFile(String excelpath, String SheetName) throws IOException{
		try {
		// open Excel file		
		FileInputStream fs = new FileInputStream (excelpath);
		// Access the required test data sheet
		wb = new XSSFWorkbook(fs);
		sheet  = wb.getSheet(SheetName);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	

}