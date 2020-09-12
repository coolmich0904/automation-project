package utilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	@Test(dataProvider = "logindata")
	public void testLogin (String username, String password) {
		System.out.println(username + " | " + password);
	}
	
	@DataProvider(name = "logindata")
	public Object[][] getData() {
		String excelPath = "C:\\eclipse-workspace\\qaProject1\\src\\test\\resources\\excel\\profile.xlsx";
		
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	
	public Object[][] testData (String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		
		Object data[][] =  new Object[rowCount-1][colCount-1];
		
		for(int i = 1; i < rowCount; i++) {
			for(int j = 1; j < colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | " );
				data[i-1][j-1] = cellData;
			}
			System.out.println();
		}
		return data;
	}

}
