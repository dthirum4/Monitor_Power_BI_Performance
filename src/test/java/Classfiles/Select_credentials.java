package Classfiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Select_credentials {
	
	public static String select_credentials(int data, int j) throws IOException,Exception
	{

		FileInputStream fis = new FileInputStream(".\\TestData\\Email_id.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		return sheet.getRow(data).getCell(j).getStringCellValue();
	}

}
