package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	public String fetchDataFromExcelSheets(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1= new FileInputStream("./src/test/resources/ExcelData1.xlsx"); //test script data is stored in excel
		Workbook workbook = WorkbookFactory.create(fis1);
		return workbook.getSheet(sheetname).getRow(row).getCell(cell).toString();
		
	}
}
