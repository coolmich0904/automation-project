package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	String data;
	
	public ExcelUtils (String excelPath, String sheetName) {
		try {
		File src = new File(excelPath);
		FileInputStream fs = new FileInputStream(src);
		wb = new XSSFWorkbook(fs);
		sheet =  wb.getSheet(sheetName);
		
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public int getRowCount() {
		
		int rowCount = 0;
		try {
		rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of Rows : " + rowCount);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColCount() {
		
		int colCount = 0;
		try {
		colCount = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println("Number of Columns : " + colCount);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}	
	
	
	public String getCellDataString (int rowNum, int colNum) {
		String cellData = null;
		try {
		cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		//System.out.println(cellData);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
	
	public void getCellDataNumber (int rowNum, int colNum) {
		try {
		Double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cellData);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	
	
}
